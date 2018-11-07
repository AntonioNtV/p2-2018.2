package saga.Produto;

import java.util.Objects;

/**
 * Representação de um Produto.
 * Um produto possui nome, descrição e preço. É identificado unicamente pelo nome e descrição.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018
 */
public class Produto extends ProdutoAbstract {
    private TipoDeCalculo tipoDeCalculo;

    /**
     * Constroi um produto
     *
     * @param nome String com o nome do produto
     * @param descricao String com descricao do produto
     */
    public Produto(String nome, String descricao, TipoDeCalculo tipoDeCalculo) {
        super(nome, descricao);
        this.tipoDeCalculo = tipoDeCalculo;
    }

    /**
     * Criado para modificar o preço do produto.
     *
     * @param novoPreco double com o novo valor do produto.
     */
    public void editaPreco(double novoPreco) {
        this.tipoDeCalculo.alterarValor(novoPreco);
    }

    public double getPreco() {
        return this.tipoDeCalculo.getPreco();
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

}
