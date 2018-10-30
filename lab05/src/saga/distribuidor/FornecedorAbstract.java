package saga.distribuidor;

import saga.distribuidor.produtos.ProdutoBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class FornecedorAbstract implements Fornecedor {
    protected String nome;
    protected String email;
    protected String numero;
    protected Map<String, ProdutoBase> produtos;

    public FornecedorAbstract(String nome, String email, String numero) {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.produtos = new HashMap<>();
    }

    public void editorFornecedor(String atributo, String atributoNovo) {
        switch (atributo) {
            case "EMAIL":
                this.email = atributoNovo;
                break;

            case "NUMERO":
                this.numero = atributoNovo;
                break;
        }
    }

    @Override
    public void cadastraProduto(String nome, String descricao, double preco) {
        this.produtos.put(nome.toUpperCase(), new ProdutoBase(nome, descricao, preco));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorAbstract that = (FornecedorAbstract) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public abstract String toString();

}
