package controleAlunos;

import java.util.HashMap;
import java.util.HashSet;

public class Controlador {
    HashMap<String,Alunos> alunos;

    public Controlador() {
        this.alunos = new HashMap<>();
    }

    public String cadastraAluno(String matricula, String nome, String curso) {
        if (!this.alunos.containsKey(matricula)) {
            Alunos cadastra = this.alunos.put(matricula, new Alunos(matricula, nome, curso));
            return "CADASTRO REALIZADO";
        } else {
            return "MATRÍCULA JÁ CADASTRADA!";
        }
    }

    public String consultaAlunos(String matricula) {
        if (this.alunos.containsKey(matricula)) {
            return this.alunos.get(matricula).toString();
        } else {
            return "Aluno não cadastro";
        }
    }
}
