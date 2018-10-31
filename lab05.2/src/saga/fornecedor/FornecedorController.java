package saga.fornecedor;

import saga.Produto.ProdutoID;

import java.util.*;

public class FornecedorController {
    private Map<String, Fornecedor> fornecedores;

    public FornecedorController() {
        this.fornecedores = new HashMap<>();
    }

    public void adicionaFornecedor(String nome, String email, String numero) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        } else if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        } else if (numero == null || numero.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: numero nao pode ser vazio ou nulo.");
        } else if (this.fornecedores.containsKey(nome.toLowerCase())){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }

        this.fornecedores.put(nome.toLowerCase(), new Fornecedor(nome,email,numero));

    }

    public String exibeFornecedor(String nome) {
        if (!this.fornecedores.containsKey(nome.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

        return this.fornecedores.get(nome.toLowerCase()).toString();
    }

    public String exibeFornecedores() {
        String fornecedores = "";

        List<Fornecedor> fornecedoresLista = new ArrayList<>(this.fornecedores.values());
        Collections.sort(fornecedoresLista, new ComparadorPorNomeFornecedor());

        for (Fornecedor fornecedor : fornecedoresLista) {
            fornecedores += fornecedor.toString() + " | ";
        }

        return fornecedores.substring(0, fornecedores.length() -1);
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
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
        } else if (!this.fornecedores.containsKey(nome.toLowerCase())){
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

        this.fornecedores.get(nome.toLowerCase()).editaFornecedor(atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        if (this.fornecedores.containsKey(nome.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        } else if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        }

        this.fornecedores.remove(nome.toLowerCase());
    }

    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
        ProdutoID produto = new ProdutoID(nome, descricao);

        if (!this.fornecedores.containsKey(nome.toLowerCase())) {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        } else if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (this.fornecedores.get(fornecedor.toLowerCase()).possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro nos cadastro de produto: produto ja existe.");
        } else if (preco < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        this.fornecedores.get(fornecedor.toLowerCase()).adicionaProduto(produto,nome,descricao,preco);


    }

    public String exibeProduto(String nome, String descricao, String fornecedor) {
        return null;

    }






















}