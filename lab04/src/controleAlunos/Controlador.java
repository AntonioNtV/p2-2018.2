package controleAlunos;

import util.Util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação do controlador do Controle de Alunos
 *
 * Cada controlador possui um grupo de alunos (cada aluno é unicamente identifcado pela matrícula), um conjunto de grupos (Identificados pelo tema, o qual é único e não é dependente de caracteres especiais) e um grupo de alunos que vão ao quadro responder questões (cada aluno pode ir mais de 1x)
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018 ©
 */
public class Controlador {
    /**
     * Mapa de alunos, identificados unicamente pela matrícula.
     */
    HashMap<String, Aluno> alunos;
    /**
     * Mapa de grupos, identificados unicamente pelo tema do grupo.
     */
    HashMap<String, Grupo> grupos;
    /**
     * Lista de alunos que vão ao quadro responder as questões. Cada aluno pode ir mais de 1x.
     */
    ArrayList<Aluno> alunosQuestoes;

    /**
     * Constroi um Controlador. Inicializando o mapa de alunos, grupos e a lista de alunos que vão responder questões no quadro.
     */
    public Controlador() {
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.alunosQuestoes = new ArrayList<>();
    }

    /**
     * Criado para cadastrar alunos no Sistema. Cada aluno possui uma matrícula (que o torna único), um nome e um curso
     *
     * @param matricula String representando a matrícula do aluno (identificador único).
     * @param nome String representando o nome do aluno.
     * @param curso Stringg representando o curso do aluno.
     * @return a String "CADASTRO REALIZADO!" caso o cadastro aluno seja concluido ou a String "MATRÍCULA JÁ CADASTRADA" caso haja a tentiva de cadastrar um aluno com uma matrícula ja existente.
     */
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

    /**
     * Criado para consultar um aluno através da matrícula.
     *
     * @param matricula String representando a matricula do aluno.
     * @return
     */
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

    /**
     * Criado para cadastrar um grupo no sistema. Cada grupo é representado pelo seu tema (que é único)
     * @param tema String representando o tema do grupo.
     * @return String "CADASTRO REALIZADO" caso o cadastro ocorrer perfeitamente ou "GRUPO JÁ CADASTRADO" caso haja a tentativa de cadastrar um grupo com um tema já cadastrado.
     */
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

    /**
     * Criado para alocar um aluno (que já deve estar breviamente cadastrado) em um grupo (que já deve estar breviamente cadastrado).
     *
     * @param grupo String representando o grupo ao qual o aluno deve ser cadastrado.
     * @param matricula String que representa o aluno que deve ser cadastrado.
     * @return String "ALUNO ALOCADO!" Caso o alocamento do aluno seja concluido ou String "Grupo não cadastrado!" caso o grupo que tenha sido tentado alocar o aluno não esteja cadastrado ou "Aluno não cadastrado!" caso exista a tentativa de alocar um aluno que ainda não foi cadastrado.
     */
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

    /**
     * Criado para imprimir os alunos que estão em um determinado grupo.
     * @param grupo String representando o grupo que deve-se imprimir os dados dos alunos que participam dele.
     * @return String com representação dos alunos do grupo no padrão:
     * "Alunos do grupo grupo:
     * * matricula - nome - curso
     * * matricula - nome - curso
     */
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

    /**
     * Criado para cadastrar alunos que fazem questões no quadro.
     *
     * @param matricula String representando o aluno que vai fazer questões no quadro.
     * @return String "ALUNO REGISTRADO!" caso o cadastro tenha ocorrido corretamente ou String "Aluno não cadastrado." caso haja a tentativa de Cadastrar um aluno que ainda n tenha sido cadastrado no sistema.
     */
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

    /**
     * Criado para imprimir todos os alunos que vão fazer questões no quadro.
     *
     * @return String representando a lista de alunos que vão fazer questões no quadro. No padrão:
     * 1. matricula - nome - curso
     * 2. matricula - nome - curso
     */
    public String imprimeAlunosQuestoes() {
        String alunos = "Alunos:" + Util.pulaLinha();

        for (int i = 0; i < this.alunosQuestoes.size(); i++) {
            alunos += (i+1) + ". " + this.alunosQuestoes.get(i).toString() + Util.pulaLinha();
        }
        return alunos;
    }
}
