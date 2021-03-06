package saga.distribuidor;

import saga.distribuidor.produtos.ComparadorPorNomeProduto;
import saga.distribuidor.produtos.Produto;
import saga.distribuidor.produtos.ProdutoBase;

import java.util.*;

public abstract class FornecedorAbstract implements Fornecedor {
    protected String nome;
    protected String email;
    protected String numero;
    protected Map<String, Produto> produtos;

    public FornecedorAbstract(String nome, String email, String numero) {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.produtos = new HashMap<>();
    }

    @Override
    public void editaPrecoProduto(String nomeProduto, double preco) {
        if (this.produtos.containsKey(nomeProduto.toUpperCase())) {
            this.produtos.get(nomeProduto.toUpperCase()).editaPreco(preco);
        } else {
            throw new IllegalArgumentException("");
        }
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
    public String Listaproduto() {
        String produtos = "";
        List<Produto> listaProdutos = new ArrayList(this.produtos.values());
        Collections.sort(listaProdutos, new ComparadorPorNomeProduto());

       for (Produto produto : listaProdutos) {
           produtos += this.nome + " - " + produto.toString() + " | ";
       }
        return produtos;
    }

    @Override
    public void cadastraProduto(String nome, String descricao, double preco) {
        if (!this.produtos.containsKey(nome.toUpperCase())) {
            this.produtos.put(nome.toUpperCase(), new ProdutoBase(nome, descricao, preco));
        } else {
            throw new IllegalArgumentException("");
        }
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
