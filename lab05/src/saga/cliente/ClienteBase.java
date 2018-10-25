package saga.cliente;

import saga.cliente.Cliente;

public abstract class ClienteBase implements Cliente {
    protected String cpf;
    protected String nome;
    protected String email;
    protected String localizacao;

    public ClienteBase(String cpf, String nome, String email, String localizacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.localizacao + " " + this.email;
    }

    @Override
    public void editorEmail(String email) {
        this.email = email;
    }

    @Override
    public void editorlocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public void editorNome(String nome) {
        this.nome = nome;
    }
}
