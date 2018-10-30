package saga.cliente;

public class ClienteBase extends ClienteAbstract {

    public ClienteBase(String cpf, String email, String nome, String localizacao) {
        super(cpf, email, nome, localizacao);
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
