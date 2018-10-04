package controleAlunos;

import java.util.Objects;

public class Alunos {
    private String matricula;
    private String nome;
    private String curso;

    public Alunos(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alunos alunos = (Alunos) o;
        return Objects.equals(matricula, alunos.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " +  this.curso;
    }
}
