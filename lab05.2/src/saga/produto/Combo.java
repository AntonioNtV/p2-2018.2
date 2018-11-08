package saga.produto;

import saga.calculadores.TipoDeCalculo;

public class Combo extends ProdutoAbstract {
    private TipoDeCalculo tipoDeCalculo;

    /**
     * Constroi um produto
     *
     * @param nome      String com o nome do produto
     * @param descricao String com descricao do produto
     */
    public Combo(String nome, String descricao, boolean combavel, TipoDeCalculo tipoDeCalculo) {
        super(nome, descricao, combavel);
        this.tipoDeCalculo = tipoDeCalculo;
    }

    @Override
    public double getPreco() {
        return this.tipoDeCalculo.getPreco();
    }

    public void alteraValor(double novoFator) {
        this.tipoDeCalculo.alterarValor(novoFator);
    }
}
