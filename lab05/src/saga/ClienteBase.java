package saga;

public abstract class ClienteAbstract implements Cliente{
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
}
