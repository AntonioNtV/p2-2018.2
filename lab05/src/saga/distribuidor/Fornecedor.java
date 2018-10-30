package saga.distribuidor;

public interface Fornecedor {
    public void editorFornecedor(String atributo, String atributoNovo);
    public String toString();
    public void cadastraProduto(String nome, String descricao, double preco);
}

