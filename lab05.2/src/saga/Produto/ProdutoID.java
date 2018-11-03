package saga.Produto;

import java.util.Objects;

/**
 * Criado para ser o identificador de um produto.
 * @author Antonio Bertino de Vasconcelos Cabral Neto.
 */
public class ProdutoID {
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
     * @param nome Nome do produto
     * @param descricao Descrição do produto
     */
    public ProdutoID(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * Equals baseado do nome e na descrição.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoID produtoID = (ProdutoID) o;
        return Objects.equals(nome, produtoID.nome) &&
                Objects.equals(descricao, produtoID.descricao);
    }

    /**
     * hashCde Baseado no nome e na descrição.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
