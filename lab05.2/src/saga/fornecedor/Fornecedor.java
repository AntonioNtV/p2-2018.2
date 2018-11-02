package saga.fornecedor;

import saga.Produto.Produto;
import saga.Produto.ProdutoID;

import java.util.*;

public class Fornecedor implements Comparable<Fornecedor>{
    private String nome;
    private String email;
    private String numero;
    private Map<ProdutoID, Produto> produtosCadastrados;

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
        this.produtosCadastrados = new HashMap<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void editaFornecedor(String atributo, String novoValor) {
        final String[] atributosValidos = {"email", "telefone"};
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

            case "telefone":
                this.numero = novoValor;
                break;
        }
    }

    public boolean possuiProduto(ProdutoID produto) {
        if (this.produtosCadastrados.containsKey(produto)) {
            return true;
        } else {
            return false;
        }
    }

    public void adicionaProduto(ProdutoID produtoID, String nome, String descricao, double preco) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        } else if (this.possuiProduto(produtoID)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        } else if (preco < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

       this.produtosCadastrados.put(produtoID, new Produto(nome, descricao, preco));

    }

    public String exibeProduto(String nome, String descricao) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (!this.possuiProduto(produto)){
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }

        return this.produtosCadastrados.get(produto).toString();
    }

    public String exibeProdutos() {
        String produtos = "";

        List<Produto> produtosList = new ArrayList<>(this.produtosCadastrados.values());
        Collections.sort(produtosList);

        for (Produto produto : produtosList) {
            produtos += this.nome + " - " + produto.toString() + " | ";
        }

        return produtos;
    }

    public void editaProduto(String nome, String descricao, double novoPreco) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        } else if (!this.possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }

        this.produtosCadastrados.get(produto).editaPreco(novoPreco);

    }

    public void removeProduto(String nome, String descricao) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        } else if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        } else if (!this.possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }

        this.produtosCadastrados.remove(produto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.numero;
    }

    @Override
    public int compareTo(Fornecedor fornecedor) {
        return this.nome.toLowerCase().compareTo(fornecedor.nome.toLowerCase());
    }
}
