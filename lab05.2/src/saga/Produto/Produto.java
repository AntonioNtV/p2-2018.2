package saga.Produto;

import java.util.Objects;

/**
 * Representação de um Produto.
 * Um produto possui nome, descrição e preço. É identificado unicamente pelo nome e descrição.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018
 */
public class Produto implements Comparable<Produto>{
    /**
     * String com nome do produto.
     */
    private String nome;
    /**
     * String com descrição do produto.
     */
    private String descricao;
    /**
     * Double com preço do produto
     */
    private double preco;

    /**
     * Constroi um produto
     *
     * @param nome String com o nome do produto
     * @param descricao String com descricao do produto
     * @param preco double com preço do produto.
     */
    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Criado para modificar o preço do produto.
     *
     * @param novoPreco double com o novo valor do produto.
     */
    public void editaPreco(double novoPreco) {
        if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }
        this.preco = novoPreco;
    }

    /**
     * Criado para retornar representação textual do produto.
     *
     * @return String no formato "Nome - descrição - R$preco"
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco);
    }

    /**
     * Equals baseado no nome e na descrição do produto
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao);
    }

    /**
     * HashCode baseado no nome e na descrição do produto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**
     * compareTo baseado no toString do produto.
     */
    @Override
    public int compareTo(Produto produto) {
        return this.toString().toLowerCase().compareTo(produto.toString().toLowerCase());
    }
}
