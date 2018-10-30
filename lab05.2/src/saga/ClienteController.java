package saga;

import saga.cliente.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteController {
    private Map<String, Cliente> clientes;

    public ClienteController() {
        this.clientes = new HashMap<>();
    }

    public void adicionaCliente(String cpf, String nome, String email, String localizacao) {
        if (nome.equals(null) || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        } else if (email.equals(null) || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        } else if (localizacao.equals(null) || localizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        } else if (this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        } else if (cpf.length() != 11) {
            throw  new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }

        this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
    }

    public String exibeCliente(String cpf) {
        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
        return this.clientes.get(cpf).toString();
    }
}
