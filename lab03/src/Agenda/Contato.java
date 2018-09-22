package Agenda;

public class Contato {
    private String nome;
    private String sobrenome;
    private String numero;

    public Contato(String nome, String sobrenome, String numero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
        

    public String getNumero() {
        return this.numero;
    }

    public boolean equals(Contato contato) {
        if (this.nome.equals(contato.getNome()) && this.sobrenome.equals(contato.getSobrenome())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }
}
