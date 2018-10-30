package saga.cliente;

import java.util.Objects;

public abstract class ClienteAbstract implements Cliente {
    protected String cpf;
    protected String nome;
    protected String email;
    protected String localizacao;

    public ClienteAbstract(String cpf, String nome, String email, String localizacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract void editorCliente(String atributo, String atributoNovo);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteAbstract that = (ClienteAbstract) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
