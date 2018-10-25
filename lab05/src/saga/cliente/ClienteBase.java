package saga.cliente;

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
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    @Override
    public void editorCliente(String atributo, String atributoNovo) {
        switch (atributo) {
            case "EMAIL":
                this.email = atributoNovo;
                break;

            case "NOME":
                this.nome = atributoNovo;
                break;

            case "LOCALIZACAO":
                this.localizacao = localizacao;
                break;

        }
    }
}
