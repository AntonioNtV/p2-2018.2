package saga.Produto.CalculoDePreco;

import saga.Produto.Produto;

import java.util.Set;

public class CalculoCombo implements TipoDeCalculo {
    private Set<Produto> produtos;
    private double fator;

    public CalculoCombo(double fator) {
        this.fator = fator;
    }

    @Override
    public double getPreco() {
        double somaPreco = 0.0;
        for (Produto produto : this.produtos) {
            somaPreco += produto.getPreco();
        }
        return somaPreco * this.fator;
    }

    @Override
    public void alterarValor(double novoValor) {
        this.fator = novoValor;

    }
}
