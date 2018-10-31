package saga;

import saga.cliente.ClienteController;
import saga.fornecedor.FornecedorController;

public class Facade {
    ClienteController clientes;
    FornecedorController fornecedores;

    public Facade() {
        this.clientes = new ClienteController();
        this.fornecedores = new FornecedorController();

    }

    public void adicionaCliente(String cpf, String nome, String email, String localizacao) {
        this.clientes.adicionaCliente(cpf,nome,email,localizacao);
    }

    public void exibeCliente(String cpf) {
        this.clientes.exibeCliente(cpf);
    }

    public void exibeClientes() {
        this.clientes.exibeClientes();
    }

    public void editacliente(String cpf, String atributo, String novoValor) {
        this.clientes.editaCliente(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        this.clientes.removeCliente(cpf);
    }

    public void adicionaFornecedor(String nome, String email, String telefone) {
        this.fornecedores.adicionaFornecedor(nome, email, telefone);
    }

    public void exibeFornecedor(String nome) {
        this.fornecedores.exibeFornecedor(nome);
    }

    public void exibeFornecedores() {
        this.fornecedores.exibeFornecedores();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.fornecedores.editaFornecedor(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        this.fornecedores.removeFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
        this.fornecedores.adicionaProduto(fornecedor, nome, descricao, preco);
    }

    public void exibeProduto(String nome, String descricao, String fornecedor) {
        this.fornecedores.exibeProduto(nome, descricao, fornecedor);
    }

    public void exibeProdutos() {
        this.fornecedores.exibeProdutos();
    }

    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
        this.fornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
    }

    public void removeProduto(String nome, String descricao, String fornecedor) {
        //TODO
    }
}
