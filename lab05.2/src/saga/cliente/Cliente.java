package saga.cliente;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    public Cliente(String cpf, String nome, String email, String localizacao) {
        if (nome.equals(null) || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        } else if (email.equals(null) || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        } else if (localizacao.equals(null) || localizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        } else if (cpf.length() != 11) {
            throw  new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return this.nome;
    }

    public void editaCliente(String atributo, String novoValor) {
        if (!atributo.equals("nome") || !atributo.equals("email") || !atributo.equals("localizacao")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        } else if (atributo.equals(null) || atributo.equals("")) {
            throw  new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        } else if (novoValor.equals(null) || novoValor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        }

        switch (atributo) {
            case "nome":
                this.nome = novoValor;
                break;

            case "email":
                this.email = novoValor;
                break;

            case "localizacao":
                this.localizacao = novoValor;
                break;
        }
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }
}
