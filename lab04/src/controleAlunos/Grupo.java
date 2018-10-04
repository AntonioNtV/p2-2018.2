package controleAlunos;

import util.Util;

import java.util.HashSet;
import java.util.Objects;

public class Grupo {
    String tema;
    HashSet<Aluno> alunos;

    public Grupo(String tema) {
        if (tema == null || tema.equals("")) {
            throw  new IllegalArgumentException("");
        }

        this.tema = tema;
        this.alunos = new HashSet<>();
    }

    public String alocaAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("");
        }

        this.alunos.add(aluno);
        return "ALUNO ALOCADO!";
    }

    public String getTema() {
        return this.tema;
    }

    public String imprimeAlunos() {
        String alunos = "";

        for (Aluno aluno : this.alunos) {
            alunos += "* " + aluno.toString() + Util.pulaLinha();
        }

        return alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(tema, grupo.tema) &&
                Objects.equals(alunos, grupo.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tema, alunos);
    }
}
