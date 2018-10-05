package Agenda;

import util.Util;

/**
 * Representação de um Contanto em uma agenda telefônica.
 * Todo contato possui um nome, sobrenome, um nível de Amizade e um no máximo 3 números.
 *

 * @author Antonio Bertino de Vasconcelos Cabral Neto
 */

public class Contato {
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	/**
     * Nome Pessoal do contato.
     */
    private String nome;
    /**
     * Sobre nome do contato.
     */
    private String sobrenome;
    /**
     * Lista de números de Contato. Podendo possuir até 3 números, no formato:   +AAA (DDD) XXXXXXXXX
     * onde AAA representa o código do pais, DDD o ddd do número e e XXXXXXXXX o número do usuário.
     */
    private Numero[] numeroLista;
    /**
     * Nível de Amizade do usuário, podendo ter 5 níveis.
     * nivel 1 - Distante.
     * nivel 2 - Colega.
     * nivel 3 - Amigo.
     * nivel 4 - Amigão.
     * nivel 5- Irmão.
     */
    private int nivelAmizade;

    /**
     *
     * Constroi um contato que possui 1 número padrão que vai ser a entrada.
     *
     * @param nome no Formato String.
     * @param sobrenome no Formato String
     * @param codigoPais no Formato XX
     * @param ddd no formato DD
     * @param numero no Formato XXXXXXXXX
     * @param tipo um número pode possuir um tipo, dentre 3: CASA, TRABALHO, CELULAR.
     * @param nivelAmizade pode ser representado por um número inteiro de 1 a 5. Cada número representando 1 nível diferente.
     */
    public Contato(String nome, String sobrenome,String codigoPais, String ddd, String numero, String tipo, int nivelAmizade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroLista = new Numero[3];
        this.numeroLista[0] = new Numero(tipo, codigoPais, ddd, numero);
        this.nivelAmizade = nivelAmizade;
    }

    /**
     * Criado para cadastrar um outro número no contato.
     *
     * @param tipo Podendo possuir 1 tipo dentro 3 diferentes: CASA, TRABALHO, CELULAR.
     * @param codigoPais Código do pais, no formato XX.
     * @param ddd DDD do número no Formato DD
     * @param numero Número do contato no formato XXXXXXXXX
     */
    public void cadastraOutroNumero(String tipo, String codigoPais, String ddd, String numero) {
        for (int i = 0; i < this.numeroLista.length; i++ ) {
            if (this.numeroLista[i] == null) {
                this.numeroLista[i] = new Numero(tipo, codigoPais, ddd, numero);
                break;
            }
        }
    }

    /**
     * Criado para retornar o nível de amizade do contato.
     *
     * @return um inteiro que representa o nível de amizade.
     */
    public int getNivelAmizade() {
        return this.nivelAmizade;
    }

    /**
     * Criado para retornar uma String com o nome do Contato.
     *
     * @return String com o nome do contato.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Criado para retornar uma String com o sobrenome do Contato.
     *
     * @return String com o sobrenome.
     */
     public String getSobrenome() {
        return this.sobrenome;
    }

    /**
     * Criado para retornar todos os números cadastrados no contato.
     *
     * @return String com todos os números cadastrados no contato no formato:
     * "TIPO" +XX (DD) XXXXXXXXXX
     * "TIPO" +XX (DD) XXXXXXXXXX
     * "TIPO" +XX (DD) XXXXXXXXXX
     */
    public String getNumero() {
        String numeros = "";

        for (int i = 0; i < this.numeroLista.length; i++) {
            if (this.numeroLista[i] != null) {
                numeros += this.numeroLista[i].toString() + Util.pulaLinha(1);
            }
        }

        return numeros;
    }

    /**
     * Criado para verificar se nome e sobrenome de outros objetos são iguais.
     *
     * @param contato um objeto do tipo contato
     * @return um booleano com True para dizer que Nome e sobrenomes são iguais ao outro objeto.
     */
    public boolean equals(Contato contato) {
        if (this.nome.equals(contato.getNome()) && this.sobrenome.equals(contato.getSobrenome())) {
            return true;
        }
        return false;
    }

    /**
     * Criado para retornar uma representação da classe Contato.
     *
     * @return uma String no formato:
     * Nome Sobrenome - Nível de Amizade
     * "TIPO" +XX (DD) XXXXXXXXX
     * "TIPO" +XX (DD) XXXXXXXXX
     * "TIPO" +XX (DD) XXXXXXXXX
     */
    @Override
    public String toString() {
        String nivelA = "";

        if (this.nivelAmizade == 1) {
            nivelA = "Distante";
        } else if (this.nivelAmizade == 2) {
            nivelA = "Colega";
        } else if (this.nivelAmizade == 3 ) {
            nivelA = "Amigo";
        } else if (this.nivelAmizade == 4) {
            nivelA = "Amigão";
        } else {
            nivelA = "Irmão";
        }

        return this.nome + " " + this.sobrenome + " - " + nivelA + Util.pulaLinha(1) + getNumero();
    }
}
