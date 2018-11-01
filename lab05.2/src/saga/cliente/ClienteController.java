package saga.cliente;

import saga.cliente.Cliente;
import saga.cliente.ComparadorPeloNomeDoCliente;

import java.util.*;

public class ClienteController {
    private Map<String, Cliente> clientes;

    public ClienteController() {
        this.clientes = new HashMap<>();
    }

    public String  adicionaCliente(String cpf, String nome, String email, String localizacao) {
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
        return this.clientes.get(cpf).getCpf();
    }

    public String exibeCliente(String cpf) {
        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
        return this.clientes.get(cpf).toString();
    }

    public String exibeClientes() {
        String clientes = "";
        List<Cliente> listaClientes = new ArrayList<>(this.clientes.values());
        Collections.sort(listaClientes, new ComparadorPeloNomeDoCliente());

        for (Cliente cliente : listaClientes) {
            clientes += cliente.toString() + " | ";
        }

        return clientes.substring(0, clientes.length() - 3);
    }

    public void editaCliente(String cpf, String atributo, String novoValor) {
        final String[] atributosValidos = new String[] {"nome", "email", "localizacao"};
        final List<String> atributosValidosList = Arrays.asList(atributosValidos);

        if (atributo == null || atributo.equals("")) {
            throw  new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        } else if (novoValor == null || novoValor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        } else if (!atributosValidosList.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        } else if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        }

        this.clientes.get(cpf).editaCliente(atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
        } else if (cpf == null || cpf.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo");
        }

        this.clientes.remove(cpf);
    }
}
