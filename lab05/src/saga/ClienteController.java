package saga;

import saga.cliente.Cliente;
import saga.cliente.ClienteBase;

import java.util.HashMap;
import java.util.Map;

public class ClienteController {
    private Map<String, Cliente> clientes;

    public ClienteController() {
        this.clientes = new HashMap<>();
    }

    public void cadastraClientes(String cpf, String email, String nome, String localizacao) {
        this.clientes.put(cpf, new ClienteBase(cpf,email,nome,localizacao));
    }

}
