package saga.produto;

import java.util.Objects;

/**
 * Representação de um produto.
 * Um produto possui nome, descrição e preço. É identificado unicamente pelo nome e descrição.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018
 */
public abstract class ProdutoAbstract implements Comparable<ProdutoAbstract>{
    /**
     * String com nome do produto.
     */
    protected String nome;
    /**
     * String com descrição do produto.
     */
    protected String descricao;

    protected boolean combavel;


    /**
     * Constroi um produto
     *
     * @param nome String com o nome do produto
     * @param descricao String com descricao do produto
     */
    public ProdutoAbstract(String nome, String descricao, boolean combavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.combavel = combavel;
    }


    /**
     * Criado para retornar o Preço do produto
     * @return double com valor do produto.
     */
    public abstract double getPreco();

    public abstract void alteraValor(double novoValor);

    public boolean isCombavel() {
        return this.combavel;
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
     * Criado para retornar representação textual do produto.
     *
     * @return String no formato "Nome - descrição - R$preco"
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.getPreco());
    }

    private String nomeEDescricao() {
        return this.nome + " - " + this.descricao;
    }

    /**
     * compareTo baseado no toString do produto.
     */
    @Override
    public int compareTo(ProdutoAbstract produto) {
        return this.nome.toLowerCase().compareTo(produto.nome.toLowerCase());
    }
}
