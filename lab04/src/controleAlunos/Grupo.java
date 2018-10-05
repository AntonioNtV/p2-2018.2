package controleAlunos;

import util.Util;

import java.util.HashSet;
import java.util.Objects;

/**
 * Representação de um Grupo
 * Cada grupo possui um tema (que é seu identificador) e um conjunto de alunos que fazem parte desse grupo.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018 ©
 */
public class Grupo {
    /**
     * String representando o tema do grupo (Identificador único)
     */
    String tema;
    /**
     * Conjunto de alunos
     */
    HashSet<Aluno> alunos;

    /**
     * Criado para construir um Grupo
     * @param tema String representando o tema do Grupo (Identificador único)
     */
    public Grupo(String tema) {
        if (tema == null || tema.equals("")) {
            throw  new IllegalArgumentException("");
        }

        this.tema = tema;
        this.alunos = new HashSet<>();
    }

    /**
     * Criado para alocar um aluno no Grupo.
     * @param aluno Objeto Aluno representando o aluno que vai ser alocado no grupo.
     * @return String "ALUNO ALOCADO!" quando aloca um aluno no Grupo.
     */
    public String alocaAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("");
        }

        this.alunos.add(aluno);
        return "ALUNO ALOCADO!";
    }

    /**
     * String representando o tema do grupo.
     * @return String representando o tema do grupo.
     */
    public String getTema() {
        return this.tema;
    }

    /**
     * Criado imprimir os alunos que estão alocados no grupo.
     * @return String dos alunos que estão alocados no grupo. No padrão:
     * * matricula - nome - curso
     * * matricula - nome - curso
     */
    public String imprimeAlunos() {
        String alunos = "";

        for (Aluno aluno : this.alunos) {
            alunos += "* " + aluno.toString() + Util.pulaLinha();
        }

        return alunos;
    }

    /**
     * Um grupo é igual ao outro quando o tema e os alunos nele presente são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(tema, grupo.tema) &&
                Objects.equals(alunos, grupo.alunos);
    }

    /**
     * HashCode gerado a partir do tema e o conjunto de alunos.
     * @return int representando hashcode do objeto grupo.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tema, alunos);
    }
}
