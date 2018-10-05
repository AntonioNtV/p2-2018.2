package Agenda;

import util.Util;

/**
 * Representação de uma Agenda.
 * Toda Agenda possui uma Lista de Contatos.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto.
 */
public class Agenda {
    /**
     * Lista de contatos com no máximo 100 contatos.
     */
   private Contato[] listaContatos;

    /**
     * Criado para construir uma lista de contatos na Agenda. Com no máximo 100 contatos.
     */
    public Agenda() {
        this.listaContatos = new Contato[100];
    }

    /**
     * Criado para cadastrar um contato na Lista de Contatos na Agenda.
     *
     * @param nome Representando o nome do contato a ser cadastrado.
     * @param sobrenome Representando o sobrenome do contato a ser cadastrado.
     * @param codigoPais Representando o código do Pais do contato a ser cadastrado.
     * @param ddd Representando o DDD do contato a ser cadastrado.
     * @param numero Representando o número do contato a ser cadastrado.
     * @param tipo Representando o tipo do contato a ser cadastrado. Podendo ser dentre 3 tipos: CASA, TRABALHO, CELULAR.
     * @param nivelAmizade Representando o nível de Amizade do contato a ser cadastrado. Possui nível de 1 a 5.
     * @param posicao Representando a posição onde o número sera cadastrado na Lista. A posição pode ser um número >= 1 e <= 100.
     */
    public String cadastraContato(String nome, String sobrenome, String codigoPais, String ddd, String numero, String tipo, int nivelAmizade, int posicao) {
        try { 
        	this.listaContatos[posicao - 1] = new Contato(nome, sobrenome, codigoPais, ddd, numero, tipo, nivelAmizade);
        	
        } catch (Exception IndexOutOfBoundsException) {
        	return "Posição inválida";
        } 
            return "CADASTRADO REALIZADO!";
    }

    /**
     * Criado para cadastrar outro número em um contato.
     *
     * @param posicao Representando contato que terá outro número Cadastrado.
     * @param tipo Tipo do novo número que será cadastrado.
     * @param codigoPais Código do país do novo número que será cadastrado.
     * @param ddd DDD do novo número que será cadastrado.
     * @param numero Novo número cadastrado.
     */
    public void cadastraOutroNumero(int posicao,String tipo, String codigoPais, String ddd, String numero) {
        this.listaContatos[posicao -1].cadastraOutroNumero(tipo, codigoPais, ddd, numero);
    }

    /**
     * Criado para Listar todos os contatos que foram cadastrados.
     *
     * @return String no formato.
     * Posição do Contato - Nome do contato Sobrenome do contato.
     */
    public String listarContatos() {
        String stringSaida = "";

        for (int i = 0; i < listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                stringSaida += (i + 1) + " - " + this.listaContatos[i].getNome() + " " + this.listaContatos[i].getSobrenome() + Util.pulaLinha(1);
            }
        }
        return stringSaida;
    }

    /**
     * Criado para consultar um contato pelo nome.
     *
     * @param nome representando o nome do contato que será cadatrado.
     * @return String representando todos os contatos que possuem o mesmo número. No formato.
     * Posição na Lista - Nome do contato Sobrenome do Contato.
     */
    public String consultarPorNome(String nome) {
        String contatos = "";

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                if (this.listaContatos[i].getNome().equals(nome)) {
                    contatos += (i + 1) + " - " +  this.listaContatos[i].getNome() + " " + this.listaContatos[i].getSobrenome() + Util.pulaLinha(1);
                }
            }
        }
        return contatos;
    }

    /**
     * Criado para consultar contatos que possuam o mesmo nível de Amizade
     *
     * @param nivel representando o nível de amizade do Contato. Entre 1 e 5.
     * @return String com contatos que possuam mesmo nível de amizade especificado no formato:
     * Posição na Lista - Nome do Contato Sobrenome do Contato.
     */
    public String consultarPorNivel(int nivel) {
        String contatos = "";

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                if (this.listaContatos[i].getNivelAmizade() == nivel) {
                    contatos += (i + 1) + " - " + this.listaContatos[i].getNome() + " " + this.listaContatos[i].getSobrenome() + Util.pulaLinha(1);
                }
            }
        }
        return contatos;
    }

    /**
     * Criado para retornar um inteiro com quantidade de contatos que possuam um X nível de amizade.
     *
     * @param nivel inteiro representando o nível de amizade a ser consultado.
     * @return  Um inteiro representando a quantidade de contatos com X nível de Amizade
     */
    public int qtdPorNivel(int nivel) {
        int qtdNivel = 0;

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                if (this.listaContatos[i].getNivelAmizade() == nivel) {
                    qtdNivel += 1;
                }
            }
        }
        return qtdNivel;
    }

    /** Criado para retornar a média do Nível de Amizade da Agenda.
     *
     * @return um inteiro com a média do nível de amizade da Agenda.
     */
    public int mediaContatos() {
        int somaNivel = 0;
        int qtdContatos = 0;

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null) {
                qtdContatos += 1;
                somaNivel += this.listaContatos[i].getNivelAmizade();
            }
        }
        return somaNivel / qtdContatos;
    }

    /**
     * Criado para exibir detalhes de um contato específico
     *
     * @param posicao representando a posição do contato na Lista
     * @return uma String no formato:
     *  Nome Sobrenome - Nível de Amizade
     * "TIPO" +XX (DD) XXXXXXXXX
     * "TIPO" +XX (DD) XXXXXXXXX
     * "TIPO" +XX (DD) XXXXXXXXX
     */
    public String exibirContato(int posicao) {
        String saida = "";

        if (this.listaContatos[posicao - 1] != null) {
           saida = Util.pulaLinha(1) + this.listaContatos[posicao -1].toString() + Util.pulaLinha(1);
        }
        return saida;
    }

    /**
     * Criado para retornar a representação da Classe Agenda em String.
     *
     * @return Uma String com todos os contatos cadastrados na Agenda. No formato:
     * Nome do contato
     */
    @Override
    public String toString() {
        String retorno = "";

        for (int i = 0; i < this.listaContatos.length; i++) {
            if (this.listaContatos[i] != null){
                retorno += this.listaContatos[i].getNome() + Util.pulaLinha(1);
            }
        }
        return retorno;
    }
}
