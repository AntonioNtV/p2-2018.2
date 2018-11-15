package prova2._caixaPersonalizada.formato;

public class Circular implements Formato {
    private String formato;
    private double raio;

    public Circular(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("Não foi possivel cadastrar Formato Circular: Raio não pode ser um valor negativo");
        }

        this.formato = "Circular";
        this.raio = raio;
    }

    @Override
    public String getFormato() {
        return this.formato;
    }

    @Override
    public String getDimensoes() {
        return String.valueOf(this.raio);
    }

    @Override
    public double getArea() {
        return Math.PI * this.raio * this.raio;
    }
}
