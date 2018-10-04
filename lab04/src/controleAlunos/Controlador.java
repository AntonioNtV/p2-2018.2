package controleAlunos;

import util.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class Controlador {
    HashMap<String, Aluno> alunos;
    HashMap<String, Grupo> grupos;
    ArrayList<Aluno> alunosQuestoes;

    public Controlador() {
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.alunosQuestoes = new ArrayList<>();
    }

    public String cadastraAluno(String matricula, String nome, String curso) {
        if (matricula == null || nome == null || curso == null || matricula .equals("") || nome.equals("") || curso.equals("")) {
            throw new IllegalArgumentException("");
        }

        if (!this.alunos.containsKey(matricula)) {
            Aluno cadastra = this.alunos.put(matricula, new Aluno(matricula, nome, curso));
            return "CADASTRO REALIZADO!";
        } else {
            return "MATRÍCULA JÁ CADASTRADA!";
        }
    }

    public String consultaAlunos(String matricula) {
        if (matricula == null || matricula.equals("")) {
            throw new IllegalArgumentException("");
        }

        if (this.alunos.containsKey(matricula)) {
            return this.alunos.get(matricula).toString();
        } else {
            return "Aluno não cadastrado.";
        }
    }

    public String cadastraGrupo(String tema) {
        if (tema == null || tema.equals("")) {
            throw new IllegalArgumentException("");
        }

        if (!this.grupos.containsKey(tema.toUpperCase())) {
            Grupo cadastra = this.grupos.put(tema.toUpperCase(), new Grupo(tema));
            return "CADASTRO REALIZADO!";
        } else {
            return "GRUPO JÁ CADASTRADO!";
        }
    }

    public String alocarAluno (String grupo, String matricula) {
        if (grupo == null || matricula == null || grupo.equals("") || matricula.equals("")) {
            throw new IllegalArgumentException("");
        }

        if (!this.grupos.containsKey(grupo.toUpperCase()) && !this.alunos.containsKey(matricula)) {
            return "Grupo não cadastrado!" + Util.pulaLinha() + "Aluno não cadastrado!";

        } else if (!this.alunos.containsKey(matricula)) {
            return "Aluno não cadastrado!";

        } else if (!this.grupos.containsKey(grupo.toUpperCase())) {
            return "Grupo não cadastrado!";

        } else {
            return this.grupos.get(grupo.toUpperCase()).alocaAluno(this.alunos.get(matricula));
        }
    }

    public String imprimeGrupo (String grupo) {
        if (grupo == null || grupo.equals("")) {
            throw new IllegalArgumentException("");
        }

        String alunosGrupo = Util.pulaLinha() + "";
        if (this.grupos.containsKey(grupo.toUpperCase())) {
            alunosGrupo += "Alunos do grupo " + this.grupos.get(grupo.toUpperCase()).getTema() + ":" + Util.pulaLinha() + this.grupos.get(grupo.toUpperCase()).imprimeAlunos();
        } else {
            return "Grupo não cadastrado.";
        }
        return alunosGrupo;
    }

    public String cadastraAlunoQuestao(String matricula) {
        if (matricula == null || matricula.equals("")) {
            throw new IllegalArgumentException("");
        }

        if (this.alunos.containsKey(matricula)) {
            this.alunosQuestoes.add(this.alunos.get(matricula));
            return "ALUNO REGISTRADO!";
        } else {
            return "Aluno não cadastrado.";
        }
    }

    public String imprimeAlunosQuestoes() {
        String alunos = "Alunos:" + Util.pulaLinha();

        for (int i = 0; i < this.alunosQuestoes.size(); i++) {
            alunos += (i+1) + ". " + this.alunosQuestoes.get(i).toString() + Util.pulaLinha();
        }
        return alunos;
    }
}
