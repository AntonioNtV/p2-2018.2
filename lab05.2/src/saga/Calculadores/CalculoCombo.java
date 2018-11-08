package saga.Calculadores;

import saga.Produto.ProdutoAbstract;

import java.util.Set;

public class CalculoCombo implements TipoDeCalculo {
    private Set<ProdutoAbstract> produtos;
    private double fator;

    public CalculoCombo(double fator, Set<ProdutoAbstract> produtos) {
        this.fator = fator;
        this.produtos = produtos;
    }

    @Override
    public double getPreco() {
        double somaPreco = 0.0;
        for (ProdutoAbstract produto : this.produtos) {
            somaPreco += produto.getPreco();
        }
        return somaPreco * (1 - this.fator);
    }

    @Override
    public void alterarValor(double novoValor) {
        this.fator = novoValor;

    }
}
