package saga.cliente;

public class ClienteBase extends ClienteAbstract {

    public ClienteBase(String cpf, String nome, String email, String localizacao) {
        super(cpf, nome, email, localizacao);
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
