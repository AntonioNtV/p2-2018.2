package Agenda;

public class Agenda {
   private Contato[] listaContatos;

    public Agenda() {
        this.listaContatos = new Contato[100];
    }

    public void cadastraContato(String nome, String sobrenome, String numero, int posicao) {
        this.listaContatos[posicao - 1] = new Contato(nome, sobrenome, numero);
    }

    public String listarContatos() {
        String stringSaida = "";

        for (int i = 0; i < listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                stringSaida += i + " - " + this.listaContatos[i].toString() + "\n";
            }
        }
        return stringSaida;
    }

    public String exibirContato(int posicao) {
        if (this.listaContatos[posicao - 1] != null) {
            return this.listaContatos[posicao -1].toString() + " - " + this.listaContatos[posicao - 1].getNumero();
        } else {
            return "POSIÇÃO INVÁLIDA.";
        }
    }
}
