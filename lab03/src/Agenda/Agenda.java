package Agenda;

import util.Util;

public class Agenda {
   private Contato[] listaContatos;

    public Agenda() {
        this.listaContatos = new Contato[100];
    }

    public void cadastraContato(String nome, String sobrenome, String codigoPais, String ddd, String numero, String tipo, int nivelAmizade, int posicao) {
            this.listaContatos[posicao - 1] = new Contato(nome, sobrenome, codigoPais, ddd, numero, tipo, nivelAmizade);
    }

    public void cadastraOutroNumero(int posicao,String tipo, String codigoPais, String ddd, String numero) {
        this.listaContatos[posicao -1].cadastraOutroNumero(tipo, codigoPais, ddd, numero);
    }

    public String listarContatos() {
        String stringSaida = "";

        for (int i = 0; i < listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                stringSaida += (i + 1) + " - " + this.listaContatos[i].getNome() + " " + this.listaContatos[i].getSobrenome() + Util.pulaLinha(1);
            }
        }
        return stringSaida;
    }

    public String consultarPorNome(String nome) {
        String contatos = "";

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                if (this.listaContatos[i].getNome().equals(nome)) {
                    contatos += (i + 1) + " - " +  this.listaContatos[i].getNome() + " " + this.listaContatos[i].getSobrenome() + Util.pulaLinha(1);
                }
            }
        }
        return contatos;
    }

    public String consultarPorNivel(int nivel) {
        String contatos = "";

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                if (this.listaContatos[i].getNivelAmizade() == nivel) {
                    contatos += (i + 1) + " - " + this.listaContatos[i].getNome() + " " + this.listaContatos[i].getSobrenome() + Util.pulaLinha(1);
                }
            }
        }
        return contatos;
    }

    public int qtdPorNivel(int nivel) {
        int qtdNivel = 0;

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                if (this.listaContatos[i].getNivelAmizade() == nivel) {
                    qtdNivel += 1;
                }
            }
        }
        return qtdNivel;
    }

    public int mediaContatos() {
        int somaNivel = 0;
        int qtdContatos = 0;

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                qtdContatos += 1;
                somaNivel += this.listaContatos[i].getNivelAmizade();
            }
        }
        return somaNivel / qtdContatos;
    }

    public String exibirContato(int posicao) {
        String saida = "";

        if (this.listaContatos[posicao - 1] != null) {
           saida = Util.pulaLinha(1) + this.listaContatos[posicao -1].toString() + Util.pulaLinha(1);
        }
        return saida;
    }

    @Override
    public String toString() {
        String retorno = "";

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null){
                retorno += this.listaContatos[i].getNome() + Util.pulaLinha(1);
            }
        }
        return retorno;
    }
}
