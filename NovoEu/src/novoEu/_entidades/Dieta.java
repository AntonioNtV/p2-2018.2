package novoEu._entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Dieta implements Serializable {
    public static final long serialVersionUID = 9014447073319881130L;
    private String nome;
    private Set<Alimento> alimentos;

    public Dieta(String nome, List<Alimento> alimentos) {
        this.nome = nome;
        this.alimentos = new HashSet<>();
        this.alimentos.addAll(alimentos);
    }

    public boolean containsAlimento(Alimento alimento) {
        if (this.alimentos.contains(alimento)) {
            return true;
        }
        return false;
    }

    public Set<Alimento> getAlimentos() {
        return this.alimentos;
    }

    public void setAlimentos(Set<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dieta dieta = (Dieta) o;
        return Objects.equals(nome, dieta.nome) &&
                Objects.equals(alimentos, dieta.alimentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, alimentos);
    }
}
