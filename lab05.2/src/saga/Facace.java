package saga;

public class Facace {
    ClienteController clientes = new ClienteController();
    FornecedorController fornecedores = new FornecedorController();

    public void adicionaCliente(String cpf, String nome, String email, String localizacao) {
        clientes.adicionaCliente(cpf,nome,email,localizacao);
    }

    public void exibeCliente(String cpf) {
        clientes.exibeCliente(cpf);
    }

    public void exibeClientes() {
        clientes.exibeClientes();
    }

    public void editacliente(String cpf, String atributo, String novoValor) {
        clientes.editaCliente(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        clientes.removeCliente(cpf);
    }

    public void adicionaFornecedor(String nome, String email, String telefone) {
        fornecedores.adicionaFornecedor(nome, email, telefone);
    }

    public void exibeFornecedor(String nome) {
        fornecedores.exibeFornecedor(nome);
    }

    public void exibeFornecedores() {
        fornecedores.exibeFornecedores();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
        fornecedores.editaFornecedor(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        fornecedores.removeFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nome, String descricao, double Preco) {
        //TODO
    }

    public void exibeProduto(String nome, String descricao, String fornecedor) {
        //TODO
    }

    public void exibeProdutos() {
        //TODO
    }

    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
        //TODO
    }

    public void removeProduto(String nome, String descricao, String fornecedor) {
        //TODO
    }
}
