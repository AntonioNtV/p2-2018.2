package util;

import saga.cliente.ClienteController;
import saga.fornecedor.FornecedorController;

public class Main {
    public static void main(String[] args) {
        ClienteController clientes = new ClienteController();
        clientes.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br","Labarc");
        clientes.adicionaCliente("94412783134", "Wilson Andrade","wilson_andrade@ccc.ufcg.edu.br","Embedded");
        clientes.adicionaCliente("19418510068","Amigao Fernandes","amigao_fernandes@ccc.ufcg.edu.br","LSD");
        clientes.adicionaCliente("64269141198", "Ana Amari", "ana_amari@ccc.ufcg.edu.br","SPG");
        clientes.adicionaCliente("58217738123", "Lucio Correia", "lucio_correia@ccc.ufcg.edu.br","SPLab");

        System.out.println("\nClientes - exibeCliente");
        System.out.println(clientes.exibeCliente("00023827490"));
        System.out.println(clientes.exibeCliente("94412783134"));
        System.out.println(clientes.exibeCliente("19418510068"));
        System.out.println(clientes.exibeCliente("64269141198"));
        System.out.println(clientes.exibeCliente("58217738123"));

        System.out.println("\nClientes - exibeClientes");
        System.out.println(clientes.exibeClientes());

        System.out.println("\nClientes - editaClientes");
        clientes.editaCliente("00023827490", "nome","Manuel");
        System.out.println(clientes.exibeCliente("00023827490"));


        //Cadastro Fornecedores
        FornecedorController fornecedores = new FornecedorController();
        fornecedores.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
        fornecedores.adicionaFornecedor("Helhao", "quiosque@gmail.com", "83 98736-5050");
        fornecedores.adicionaFornecedor("Dona Alba", "alba@gmail.com", "83 99945-1294");
        fornecedores.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");

        System.out.println("\nFornecedores - exibeFornecedor");
        System.out.println(fornecedores.exibeFornecedor("Marcos"));
        System.out.println(fornecedores.exibeFornecedor("Helhao"));
        System.out.println(fornecedores.exibeFornecedor("Dona Alba"));
        System.out.println(fornecedores.exibeFornecedor("Seu olavo"));

        System.out.println("\nFornecedores - exibeFornecedores");
        System.out.println(fornecedores.exibeFornecedores());

        System.out.println("\nFornecedores - editaFornecedor");
        fornecedores.editaFornecedor("Seu olavo","email","olavetes@gmail.com");
        System.out.println(fornecedores.exibeFornecedor("Seu olavo"));
        fornecedores.editaFornecedor("Seu olavo","numero","3322-2067");
        System.out.println(fornecedores.exibeFornecedor("Seu olavo"));

        //Cadastro Produtos
        fornecedores.adicionaProduto("Seu olavo","X-france","Hamburguer de frango com queijo e calabresa",5.00);
        fornecedores.adicionaProduto("Seu olavo","x-burguer","Hamburguer de carne com queijo e calabresa",4.50);
        fornecedores.adicionaProduto("Dona Alba","Rubacao","Feijao com arroz e queijo coalho",14.00);
        fornecedores.adicionaProduto("Marcos","Coxao de Pizza","Coxao de frango com presunto e queijo",2.50);
        fornecedores.adicionaProduto("Marcos","Coxao de Frango","Coxao de frango com cheddar",2.50);

        System.out.println("\n Fornecedores - exibeProduto");
        System.out.println(fornecedores.exibeProduto("x-france","Hamburguer de frango com queijo e calabresa","seu olavo"));
        System.out.println(fornecedores.exibeProduto("x-burguer","Hamburguer de carne com queijo e calabresa","seu olavo"));
        System.out.println(fornecedores.exibeProduto("rubacao","Feijao com arroz e queijo coalho","dona alba"));
        System.out.println(fornecedores.exibeProduto("Coxao de pizza","Coxao de frango com presunto e queijo","Marcos"));
        System.out.println(fornecedores.exibeProduto("Coxao de Frango","Coxao de frango com cheddar","Marcos"));

        System.out.println("\n Fornecedores - exibeProdutos");
        System.out.println(fornecedores.exibeProdutos());


    }
}
