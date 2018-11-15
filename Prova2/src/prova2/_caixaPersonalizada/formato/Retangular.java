package prova2._caixaPersonalizada.formato;

public class Retangular implements Formato {
    private String formato;
    private double lado1;
    private double lado2;

    public Retangular(double lado1, double lado2) {
        if (lado1 <= 0 || lado2 <= 0) {
            throw new IllegalArgumentException("Não foi possivel cadastrar Formato Retangular: Lado não pode ser um valor negativo");
        }

        this.formato = "Retangular";
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public String getFormato() {
        return this.formato;
    }

    @Override
    public String getDimensoes() {
        return this.lado1 + " - " + this.lado2;
    }

    @Override
    public double getArea() {
        return this.lado1 * this.lado2;
    }
}
