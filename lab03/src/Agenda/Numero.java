package Agenda;

public class Numero {
    String tipo;
    String codigoPais;
    String ddd;
    String numero;

    public Numero(String tipo, String codigoPais, String ddd, String numero) {
        this.tipo = tipo;
        this.codigoPais = codigoPais;
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return this.tipo + " +" + this.codigoPais + " " + "(" + this.ddd + ") " + this.numero;
    }
}
