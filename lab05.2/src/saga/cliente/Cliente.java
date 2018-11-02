package saga.cliente;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Classe criada para Representar um Cliente.
 * Um Cliente é representado posusi um CPF (que possui 11 caracteres), Nome, Email e Localização. O mesmo é identificado unicamente pelo CPF.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018.
 */
public class Cliente implements Comparable<Cliente>{
    /**
     * Cpf do cliente. Por padrão possui 11 caracteres e é o identificador Unico.
     */
    private String cpf;
    /**
     * Nome do Cliente.
     */
    private String nome;
    /**
     * Email do Cliente.
     */
    private String email;
    /**
     * Localização do Cliente (Local de Trabalho).
     */
    private String localizacao;

    /**
     * Constroi um Cliente.
     *
     * @param cpf representando o cpf do cliente.
     * @param nome representando o nome do cliente.
     * @param email representando e email do cliente.
     * @param localizacao representando a localização do cliente(Local de Trabalho).
     */
    public Cliente(String cpf, String nome, String email, String localizacao) {
        if (nome.equals(null) || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        } else if (email.equals(null) || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        } else if (localizacao.equals(null) || localizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        } else if (cpf.length() != 11) {
            throw  new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    /**
     * Criado para retornar o nome do Cliente
     * @return String com o nome do Cliente.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Criado para retornar cpf do Cliente
     * @return String com o cpf do Cliente.
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Criado para editar algum Atributo no Cliente. Apenas pode-se editar o nome, email e localização.
     * @param atributo Atributo o qual deve ser editado.
     * @param novoValor Valor qual o atributo vai indicar para substituir.
     */
    public void editaCliente(String atributo, String novoValor) {
        final String[] atributosValidos = new String[] {"nome", "email", "localizacao"};
        final List<String> atributosValidosList = Arrays.asList(atributosValidos);

        if (atributo == null || atributo.equals("")) {
            throw  new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        } else if (novoValor == null || novoValor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        } else if (!atributosValidosList.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        }

        switch (atributo) {
            case "nome":
                this.nome = novoValor;
                break;

            case "email":
                this.email = novoValor;
                break;

            case "localizacao":
                this.localizacao = novoValor;
                break;
        }
    }

    /**
     * Equals baseado no cpf.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    /**
     * HashCode baseado no cpf.
     */
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    /**
     * Representação Textual do Cliente
     * @return String no formato "nome - localização - email"
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    @Override
    public int compareTo(Cliente cliente) {
        return this.nome.toLowerCase().compareTo(cliente.nome.toLowerCase());
    }
}
