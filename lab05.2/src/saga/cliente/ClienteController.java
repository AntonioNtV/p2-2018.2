package saga.cliente;

import java.util.*;

/**
 * Criado para controlar a classe Cliente.
 * Um Cliente Controller possui um Conjunto de clientes, que possuem como chave o cpf do cliente.
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018
 */
public class ClienteController {
    /**
     * Conjunto de Clientes, identificados unicamente pelo seu cpf, que também é a chave do Cliente.
     */
    private Map<String, Cliente> clientes;

    /**
     * Criado para inicializar o Cliente Controller
     */
    public ClienteController() {
        this.clientes = new HashMap<>();
    }

    /**
     * Criado para adicionar um cliente, ao controlador de tals.
     *
     * @param cpf String com cpf no cliente
     * @param nome String com nome do cliente.
     * @param email String com email do cliente.
     * @param localizacao String com local de trabalho do cliente.
     * @return String com cpf do cliente cadastrado.
     */
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

    /**
     * Criado para retornar a representação de um cliente especifico.
     *
     * @param cpf String com cpf do cliente que será retornaddo a representação textual
     * @return String com representação do cliente.
     */
    public String exibeCliente(String cpf) {
        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        } else if (cpf == null || cpf.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou invalido.");
        }
        return this.clientes.get(cpf).toString();
    }

    /**
     * Criado para retornar a representação de todos os clientes, ordenado por ordem alfabética.
     *
     * @return String com nome de todos os clientes cadastrados, em ordem alfabética.
     */
    public String exibeClientes() {
        String clientes = "";
        List<Cliente> listaClientes = this.ordenaPeloNomeCliente();

        for (Cliente cliente : listaClientes) {
            clientes += cliente.toString() + " | ";
        }

        return clientes.substring(0, clientes.length() - 3);
    }

    /**
     * Criado para ordenar pelo nome do cliente.
     *
     * @return Lista do tipo cliente, com todos os clientes ordenados por ordem alfabética.
     */
    public List<Cliente> ordenaPeloNomeCliente() {
        List<Cliente> listaClientes = new ArrayList<>(this.clientes.values());
        Collections.sort(listaClientes);

        return listaClientes;
    }

    /**
     * Criado para editar algum atributo do Cliente.
     *
     * @param cpf Cpf que irá identificar o cliente
     * @param atributo atributo o qual será modificado
     * @param novoValor valor o qual o atributo indicara que será substitituido.
     */
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

    /**
     * Criado para remove algum cliente.
     *
     * @param cpf String com cpf do cliente que será removido.
     */
    public void removeCliente(String cpf) {
        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
        } else if (cpf == null || cpf.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo");
        }

        this.clientes.remove(cpf);
    }
}
