package saga;

import saga.cliente.ComparadorPeloNomeDoCliente;
import saga.cliente.Cliente;
import saga.cliente.ClienteBase;
import saga.distribuidor.Fornecedor;

import java.util.*;

public class ClienteController {
    private Map<String, Cliente> clientes;

    public ClienteController() {
        this.clientes = new HashMap<>();
    }

    public void cadastraClientes(String cpf, String email, String nome, String localizacao) {
        if (!this.clientes.containsKey(cpf)) {
            this.clientes.put(cpf, new ClienteBase(cpf,email, nome,localizacao));
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public String BuscaDeCliente(String cpf) {
        String saida = "";

        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("");
        } else {
            saida = this.clientes.get(cpf).toString();
        }
        return saida;
    }

    public String listaClientes() {
        String clientes = "";
        List<Cliente> listaClientes = new ArrayList<>(this.clientes.values());
        Collections.sort(listaClientes, new ComparadorPeloNomeDoCliente());

        for (Cliente cliente : listaClientes) {
                clientes += cliente.toString() + " | ";
        }
        return clientes.substring(0, clientes.length() -1);
    }

    public void editorCliente(String cpf, String atributo, String atributoNovo) {
        if (this.clientes.containsKey(cpf)) {
            this.clientes.get(cpf).editorCliente(atributo.toUpperCase(), atributoNovo);
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public void removeCliente(String cpf) {
        if (this.clientes.containsKey(cpf)) {
            this.clientes.remove(cpf);
        } else {
            throw new IllegalArgumentException("");
        }
    }
}
