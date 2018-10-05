package util;

import java.util.Scanner;

/**
 * Criado para facilitar e evitar repetição de código no Projeto.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018 ©
 */
public class Util {
    /**
     * Criado para printar uma mensagem e retornar uma entrada de dados.
     * Semelhando ao input() de python
     * @param mensagem String que será dado syso.
     * @return
     */
    public static String input(String mensagem) {
        if (mensagem == null) {
            mensagem = "";
        }

        Scanner sc = new Scanner(System.in);

        System.out.print(mensagem);
        return sc.nextLine();
    }

    /**
     * Criado para facilitar o processso de line break
     * @return String com 1 line break
     */
    public static String pulaLinha() {
        return System.lineSeparator();
    }

    /**
     * Criado para facilitar o processo de line break
     * @param qtdLinhas representando qtd de linhas que serão puladas
     * @return String com x line break
     */
    public static String pulaLinha(int qtdLinhas) {
        if (qtdLinhas < 0) {
            throw new IllegalArgumentException("");
        }

        String linhas = "";

        for (int i = 0; i < qtdLinhas; i++) {
            linhas += System.lineSeparator();
        }

        return linhas;
    }

    /**
     * Criado para printar uma mensagem e retornar uma entrada de dados.
     * Semelhando ao int(input()) de python
     * @param mensagem String que será dado syso.
     * @return
     */
    public static int intInput(String mensagem) {
        if (mensagem == null) {
            mensagem = "";
        }

        Scanner sc2 = new Scanner(System.in);

        System.out.print(mensagem);
        return sc2.nextInt();
    }

}
