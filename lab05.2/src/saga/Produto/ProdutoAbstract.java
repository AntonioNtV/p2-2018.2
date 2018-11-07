package saga.Produto;

import java.util.Objects;

/**
 * Representação de um Produto.
 * Um produto possui nome, descrição e preço. É identificado unicamente pelo nome e descrição.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018
 */
public class ProdutoAbstract implements Comparable<ProdutoAbstract>{
    /**
     * String com nome do produto.
     */
    protected String nome;
    /**
     * String com descrição do produto.
     */
    protected String descricao;


    /**
     * Constroi um produto
     *
     * @param nome String com o nome do produto
     * @param descricao String com descricao do produto
     */
    public ProdutoAbstract(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * Equals baseado no nome e na descrição do produto
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoAbstract that = (ProdutoAbstract) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao);
    }

    /**
     * HashCode Baseado no nome e na descrição.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**
     * compareTo baseado no toString do produto.
     */
    @Override
    public int compareTo(ProdutoAbstract produto) {
        return this.toString().toLowerCase().compareTo(produto.toString().toLowerCase());
    }
}
