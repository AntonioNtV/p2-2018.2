package saga;

import saga.cliente.Cliente;
import saga.cliente.ClienteBase;

public class main {
    public static void main(String[] args) {
        ClienteController clientes = new ClienteController();
        clientes.cadastraClientes("123.953.214-86", "antoniontv18@gmai.com", "Antonio Neto", "LSD");
        clientes.cadastraClientes("123.456.789-10", "SérgioMenezes@gmail.com", "Sérgio Menezes", "CARIMBÃO");
        clientes.cadastraClientes("038.079.004-11", "jujuzinha@gmail.com", "Juliana Lêoncio", "SPLAB");
        clientes.cadastraClientes("543-412-312-40", "BernardoAlmeida@gmail.com", "Bernardo Almeida", "BND");

        System.out.println("INDIVIDUAIS");
        System.out.println(clientes.BuscaDeCliente("543-412-312-40"));
        System.out.println(clientes.BuscaDeCliente("123.953.214-86"));
        System.out.println(clientes.BuscaDeCliente("038.079.004-11"));
        System.out.println(clientes.BuscaDeCliente("123.456.789-10"));

        System.out.println("LISTA");
        System.out.println(clientes.listaClientes());
    }
}
