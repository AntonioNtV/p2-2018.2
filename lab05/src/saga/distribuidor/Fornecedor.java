package saga.distribuidor;

public interface Fornecedor {
    public String getNome();
    public String Listaproduto();
    public void editaPrecoProduto(String nomeProduto, double preco);
    public void editorFornecedor(String atributo, String atributoNovo);
    public String toString();
    public void cadastraProduto(String nome, String descricao, double preco);
}

