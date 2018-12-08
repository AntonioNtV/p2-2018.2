package novoEu._entidades;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    public static final long serialVersionUID = 538853033952234445L;
    private int id;
    private String nome;
    private Dieta dieta;
    private int alimentosConsumidos;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.alimentosConsumidos = 0;
        this.dieta = null;
    }

    public int comeAlimento(Alimento alimento) {
        if (this.dieta == null) {
            this.alimentosConsumidos++;
        } else if (this.dieta.containsAlimento(alimento)) {
            this.alimentosConsumidos++;
        }

        return this.alimentosConsumidos;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        if (this.dieta != null) {
            return this.nome + " - " + this.id + " - " + this.dieta.getAlimentos().toArray() +  " - " + this.alimentosConsumidos;
        } else {
            return this.nome + " - " + this.id + " - " + "SEM DIETA CADASTRADA" +  " - " + this.alimentosConsumidos;

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return this.id;
    }
}
