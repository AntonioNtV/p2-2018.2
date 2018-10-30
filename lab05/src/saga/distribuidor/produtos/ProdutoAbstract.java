package saga.distribuidor.produtos;

import java.util.Objects;

public abstract class ProdutoAbstract implements Produto {

    protected String nome;
    protected String descricao;
    protected double preco;

    public ProdutoAbstract(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public abstract void editaPreco(double novoPreco);

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoAbstract that = (ProdutoAbstract) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
