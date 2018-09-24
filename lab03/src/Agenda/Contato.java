package Agenda;

import util.Util;

public class Contato {
    private String nome;
    private String sobrenome;
    private String codigoPais;
    private String ddd;
    private Numero[] numeroLista;
    private int nivelAmizade;

    public Contato(String nome, String sobrenome,String codigoPais, String ddd, String numero, String tipo, int nivelAmizade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.codigoPais = codigoPais;
        this.ddd = ddd;
        this.numeroLista = new Numero[3];
        this.numeroLista[0] = new Numero(tipo, codigoPais, ddd, numero);
        this.nivelAmizade = nivelAmizade;
    }

    public void cadastraOutroNumero(String tipo, String codigoPais, String ddd, String numero) {
        for (int i = 0; i < this.numeroLista.length; i++ ) {
            if (this.numeroLista[i] == null) {
                this.numeroLista[i] = new Numero(tipo, codigoPais, ddd, numero);
                break;
            }
        }
    }

    public int getNivelAmizade() {
        return this.nivelAmizade;
    }

    public String getNome() {
        return this.nome;
    }
     public String getSobrenome() {
        return this.sobrenome;
    }

    public String getNumero() {
        String numeros = "";

        for (int i = 0; i < this.numeroLista.length; i++) {
            if (this.numeroLista[i] != null) {
                numeros += this.numeroLista[i].toString() + Util.pulaLinha(1);
            }
        }

        return numeros;
    }

    public boolean equals(Contato contato) {
        if (this.nome.equals(contato.getNome()) && this.sobrenome.equals(contato.getSobrenome())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String nivelA = "";

        if (this.nivelAmizade == 1) {
            nivelA = "Distante";
        } else if (this.nivelAmizade == 2) {
            nivelA = "Colega";
        } else if (this.nivelAmizade == 3 ) {
            nivelA = "Amigo";
        } else if (this.nivelAmizade == 4) {
            nivelA = "Amigão";
        } else {
            nivelA = "Irmão";
        }

        return this.nome + " " + this.sobrenome + " - " + nivelA + Util.pulaLinha(1) + getNumero();
    }
}
