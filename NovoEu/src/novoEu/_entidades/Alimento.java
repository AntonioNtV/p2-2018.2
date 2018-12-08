package novoEu._entidades;

import java.io.Serializable;
import java.util.Objects;

public class Alimento implements Serializable {
    public static final long serialVersionUID = 8754317978035772868L;
    private String nome;

    public Alimento(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alimento alimento = (Alimento) o;
        return Objects.equals(nome, alimento.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
