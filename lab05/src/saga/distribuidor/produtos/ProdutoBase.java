package saga.distribuidor.produtos;

import saga.distribuidor.produtos.ProdutoAbstract;

public class ProdutoBase extends ProdutoAbstract {
    public ProdutoBase(String nome, String descricao, double preco) {
        super(nome, descricao, preco);
    }

    public void editaPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - R$" + this.preco;
    }

}
