package controleAlunos;

import java.util.Objects;

public class Aluno {
    private String matricula;
    private String nome;
    private String curso;

    public Aluno(String matricula, String nome, String curso) {
        if (matricula == null || nome == null || curso == null || matricula.equals("") || nome.equals("") || curso.equals("")) {
            throw new IllegalArgumentException("");
        }

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno alunos = (Aluno) o;
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
