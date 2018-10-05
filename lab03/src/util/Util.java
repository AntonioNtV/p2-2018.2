package util;

import java.util.Scanner;

/**
 * Representação de uma Classe de Utilidades no usadas no Projeto.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto
 */
public class Util {
    /**
     * Método input() criado para facilitar a entrada de Dados e Saída de Mensagens
     *
     * @param mensagem para ser o print de uma mensagem
     * @return Uma string capturada na Entrada de Dados.
     */
    public static String input(String mensagem) {
        Scanner sc = new Scanner(System.in);

        System.out.print(mensagem);
        return sc.nextLine();
    }

    /**
     * Criado para facilitar a "pula de linhas" no código.
     *
     * @param qtdLinhas representando a quantidade de linhas a ser pulada.
     * @return Uma string com a quantidade de linhas a ser pulada.
     */
    public static String pulaLinha(int qtdLinhas) {
        String linha = "";

        for (int i = 0; i < qtdLinhas; i++) {
            linha += System.lineSeparator();
        }

        return linha;
    }

    /**
     * Representação da classe.
     *
     * @return uma String auto-explicativa do propósito da classe.
     */
    @Override
    public String toString() {
        return "Criado apenas para auxiliar na construção do código.";
    }
}
    