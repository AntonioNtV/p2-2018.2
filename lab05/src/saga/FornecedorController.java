package saga;

import saga.distribuidor.Fornecedor;
import saga.distribuidor.FornecedorBase;

import java.util.HashMap;
import java.util.Map;

public class FornecedorController {
    private Map<String, Fornecedor> fornecedores;

    public FornecedorController() {
        this.fornecedores = new HashMap<>();
    }

    public void cadastroFornecedores(String nome, String email, String numero) {
        if (!this.fornecedores.containsKey(nome.toUpperCase())) {
            this.fornecedores.put(nome.toUpperCase(), new FornecedorBase(nome, email, numero));
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public void cadastroProdutos(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
        if (!this.fornecedores.containsKey(nomeFornecedor.toUpperCase())) {
            this.fornecedores.get(nomeFornecedor.toUpperCase()).cadastraProduto(nomeProduto, descricao, preco);
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public String buscaFornecedor(String nome) {
        String fornecedor = "";

        if (this.fornecedores.containsKey(nome.toUpperCase())) {
            fornecedor = this.fornecedores.get(nome.toUpperCase()).toString();
        } else {
            throw new IllegalArgumentException("");
        }
        return fornecedor;
    }

    public void removeFornecedor(String nome) {
        if (this.fornecedores.containsKey(nome.toUpperCase())) {
            this.fornecedores.remove(nome.toUpperCase());
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public void editorFornecedor(String nome, String atributo, String atributoNovo) {
        if (this.fornecedores.containsKey(nome.toUpperCase())) {
            this.fornecedores.get(nome.toUpperCase()).editorFornecedor(atributo, atributoNovo);
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public void editorProduto(String nomeFornecedor, String nomeProduto, double novoPreco) {
        if (this.fornecedores.containsKey(nomeFornecedor.toUpperCase())) {
            this.fornecedores.get(nomeFornecedor.toUpperCase()).editaPrecoProduto(nomeProduto, novoPreco);
        } else {
            throw new IllegalArgumentException("");
        }
    }
}