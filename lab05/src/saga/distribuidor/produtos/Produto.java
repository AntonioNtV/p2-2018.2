package saga.distribuidor.produtos;

public interface Produto {
    public String getNome();
    public void editaPreco(double novoPreco);
    public String toString();
}
