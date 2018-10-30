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
}
