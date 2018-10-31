package saga.fornecedor;

import java.util.Arrays;
import java.util.List;

public class Fornecedor {
    private String nome;
    private String email;
    private String numero;

    public Fornecedor(String nome, String email, String numero) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        } else if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        } else if (numero == null || numero.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: numero nao pode ser vazio ou nulo.");
        }

        this.nome = nome;
        this.email = email;
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void editaFornecedor(String atributo, String novoValor) {
        final String[] atributosValidos = {"email", "numero"};
        final List<String> atributosValidosList = Arrays.asList(atributosValidos);

        if (atributo.equals("nome")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        } else if (novoValor == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        } else if (atributo == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        } else if (!atributosValidosList.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }

        switch (atributo) {
            case "email":
                this.email = novoValor;
                break;

            case "numero":
                this.numero = novoValor;
                break;
        }
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.numero;
    }
}
