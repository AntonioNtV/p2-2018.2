package saga;

import saga.cliente.Cliente;
import saga.cliente.ClienteBase;

public class main {
    public static void main(String[] args) {
        ClienteController clientes = new ClienteController();
        FornecedorController fornecedor = new FornecedorController();

        // Cadastro Clientes
        clientes.cadastraClientes("123.953.214-86", "antoniontv18@gmai.com", "Antonio Neto", "LSD");
        clientes.cadastraClientes("123.456.789-10", "SérgioMenezes@gmail.com", "Sérgio Menezes", "CARIMBÃO");
        clientes.cadastraClientes("038.079.004-11", "jujuzinha@gmail.com", "Juliana Lêoncio", "SPLAB");
        clientes.cadastraClientes("543-412-312-40", "BernardoAlmeida@gmail.com", "Bernardo Almeida", "BND");

       // Cadastro Fornecedor
        fornecedor.cadastroFornecedores("Dona Inês","donaInes@gmail.com","83 9999-5050");
        fornecedor.cadastroFornecedores("Josenilda","josenilda@gmail.com","83 9998-5401");
        fornecedor.cadastroProdutos("Dona Inês","Bolo","Bolo de Chocolate",3.00);
        fornecedor.cadastroProdutos("Dona Inês","Tapioca","Tapioca com Manteiga",3.00);
        fornecedor.cadastroProdutos("Dona Inês","Tapioca Completa","Tapioca com côco, queijo e Manteiga",3.50);
        fornecedor.cadastroProdutos("Josenilda","Mousse","Mousse de Limão",4.00);
        fornecedor.cadastroProdutos("Josenilda","Salada de Frutas","Sala de Frutas com leite condensado",4.50);
        fornecedor.cadastroProdutos("Josenilda","Biscoito Doce","Maizena",3.00);


        System.out.println("FORNECEDORES INDIVIDUAIS\n");
        System.out.println(fornecedor.buscaFornecedor("Josenilda"));
        System.out.println(fornecedor.buscaFornecedor("dona Inês"));

        System.out.println("FORNECEDORES LISTA\n");
        System.out.println(fornecedor.listaFornecedores());

        System.out.println("\nCLIENTES INDIVIDUAIS");
        System.out.println(clientes.BuscaDeCliente("543-412-312-40"));
        System.out.println(clientes.BuscaDeCliente("123.953.214-86"));
        System.out.println(clientes.BuscaDeCliente("038.079.004-11"));
        System.out.println(clientes.BuscaDeCliente("123.456.789-10"));

        System.out.println("\nLISTA");
        System.out.println(clientes.listaClientes());
    }
}
