package saga.identifiers;

import java.util.Objects;

/**
 * Criado para ser o identificador de um produto.
 * @author Antonio Bertino de Vasconcelos Cabral Neto.
 */
public class ComboID implements ID {
    /**
     * Nome do produto
     */
    private String nome;
    /**
     * Descrição do produto.
     */
    private String descricao;

    /**
     * Inicializa o identificador
     *
     * @param nome      Nome do produto
     * @param descricao Descrição do produto
     */
    public ComboID(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComboID comboID = (ComboID) o;
        return Objects.equals(nome, comboID.nome) &&
                Objects.equals(descricao, comboID.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
