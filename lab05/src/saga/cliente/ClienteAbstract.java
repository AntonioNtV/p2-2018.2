package saga.cliente;

import java.util.Objects;

public abstract class ClienteAbstract implements Cliente {
    protected String cpf;
    protected String email;
    protected String nome;
    protected String localizacao;

    public ClienteAbstract(String cpf, String email, String nome, String localizacao) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.localizacao = localizacao;
    }

    @Override
    public void editorCliente(String atributo, String atributoNovo) {
        switch (atributo) {
            case "NOME":
                this.nome = atributoNovo;
                break;

            case "EMAIL":
                this.email = atributoNovo;
                break;

            case "LOCALIZACAO":
                this.localizacao = atributoNovo;
                break;
        }
    }

    public String getNome() {
        return this.nome;
    }

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

    @Override
    public abstract String toString();
}
