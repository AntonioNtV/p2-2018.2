package Agenda;

public class Agenda {
   private Contato[] listaContatos;

    public Agenda() {
        this.listaContatos = new Contato[100];
    }

    public void cadastraContato(String nome, String sobrenome, String numero, int posicao) {
        this.listaContatos[posicao - 1] = new Contato(nome, sobrenome, numero);
    }

    public void listarContatos() {
        String stringSaida = "";

        for (int i = 0; i < listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                System.out.println((i + 1) + " - " + this.listaContatos[i].toString());
            }
        }
    }

    public void exibirContato(int posicao) {
        if (this.listaContatos[posicao - 1] != null) {
            System.out.println("\n" + this.listaContatos[posicao -1].toString() + " - " + this.listaContatos[posicao - 1].getNumero());
        }
    }

}
