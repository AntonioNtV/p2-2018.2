package saga.Calculadores;

public class CalculoComum implements TipoDeCalculo {
    private double preco;

    public CalculoComum(double preco) {
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public void alterarValor(double novoValor) {
        this.preco = novoValor;
    }
}
