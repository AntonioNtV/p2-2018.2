package Agenda;

/**
 * Representação de um número da Classe Contato.
 * Todo Número possui um Tipo que pode ser dentre 3 tipos: CASA, TRABALHO, CELULAR. Também possui um código do país, DDD e o próprio número em si.
 *
 * @autor Antonio Bertino de Vasconcelos Cabral Neto.
 */
public class Numero {
    /**
     * Tipo do contato que pode ser dentre 3 tipos:
     * CASA
     * TRABALHO
     * CELULAR
     */
    String tipo;
    /**
     * Código do País. No formato CP.
     */
    String codigoPais;
    /**
     * DDD do número. No formato DD.
     */
    String ddd;
    /**
     * Número do número. No formato XXXXXXXXX
     */
    String numero;

    /**
     * Criado para construir um número.
     *
     * @param tipo que como citado antes pode ser dentre 3 tipos.
     * @param codigoPais Um código do país no formato XX.
     * @param ddd DDD do número no formato DD
     * @param numero número do número no formato XXXXXXXXX.
     */
    public Numero(String tipo, String codigoPais, String ddd, String numero) {
        this.tipo = tipo;
        this.codigoPais = codigoPais;
        this.ddd = ddd;
        this.numero = numero;
    }

    /**
     * Criado para retornar uma representação da classe Número.
     *
     * @return uma String no formato:
     * "TIPO" +CP (DDD) XXXXXXXXXXX
     */
    @Override
    public String toString() {
        return this.tipo + " +" + this.codigoPais + " " + "(" + this.ddd + ") " + this.numero;
    }
}
