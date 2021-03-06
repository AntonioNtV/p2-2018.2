package saga.facade;

import easyaccept.EasyAccept;
import saga.cliente.ClienteController;
import saga.fornecedor.FornecedorController;

public class Facade {
    ClienteController clientes;
    FornecedorController fornecedores;

    public Facade() {
        this.clientes = new ClienteController();
        this.fornecedores = new FornecedorController();

    }

    public static void main(String[] args) {
        args = new String[] {"saga.facade.Facade", "acceptance_tests/us1.txt", "acceptance_tests/us2.txt", "acceptance_tests/us3.txt", "acceptance_tests/us4.txt"};
        EasyAccept.main(args);
    }

    //US1

    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.clientes.adicionaCliente(cpf,nome,email,localizacao);
    }

    public String exibeCliente(String cpf) {
        return this.clientes.exibeCliente(cpf);
    }

    public String exibeClientes() {
       return this.clientes.exibeClientes();
    }

    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.clientes.editaCliente(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        this.clientes.removeCliente(cpf);
    }

    // US2

    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.fornecedores.adicionaFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome) {
        return this.fornecedores.exibeFornecedor(nome);
    }

    public String exibeFornecedores() {
        return this.fornecedores.exibeFornecedores();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.fornecedores.editaFornecedor(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        this.fornecedores.removeFornecedor(nome);
    }

    //US3

    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
        this.fornecedores.adicionaProduto(fornecedor, nome, descricao, preco);
    }

    public String exibeProduto(String nome, String descricao, String fornecedor) {
        return this.fornecedores.exibeProduto(nome, descricao, fornecedor);
    }

    public String exibeProdutos() {
        return this.fornecedores.exibeProdutos();
    }

    public String exibeProdutosFornecedor(String fornecedor) {
        return this.fornecedores.exibeProdutosFornecedor(fornecedor);
    }

    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
        this.fornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
    }

    public void removeProduto(String nome, String descricao, String fornecedor) {
        this.fornecedores.removeProduto(nome, descricao, fornecedor);
    }

    // US4

    public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
        this.fornecedores.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
    }

    public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
        this.fornecedores.editaCombo(nome, descricao, fornecedor, novoFator);
    }

    //US5



}
