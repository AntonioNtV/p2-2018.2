package util;

import saga.ClienteController;

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
    }
}
