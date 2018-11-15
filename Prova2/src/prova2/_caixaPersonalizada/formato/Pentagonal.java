package prova2._caixaPersonalizada.formato;

public class Pentagonal implements Formato {
    private String formato;
    private double lado;

    public Pentagonal(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("Não foi possivel cadastrar Formato Pentagonal: Lado não pode ser um valor negativo");
        }

        this.formato = "Pentagonal";
        this.lado = lado;
    }

    @Override
    public String getFormato() {
        return this.formato;
    }

    @Override
    public String getDimensoes() {
        return String.valueOf(this.lado);
    }

    public double getArea() {
        return (this.lado * 5 * 10 )/ 2;
    }
}
