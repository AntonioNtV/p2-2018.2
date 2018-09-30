package util;

import java.util.Scanner;

public class Util {
    private static Scanner sc;

    public static String pulaLinhas(int qtdLinhas) {
        String linhas = "";

        for (int i = 0; i < qtdLinhas; i++) {
            linhas += System.lineSeparator();
        }

        return linhas;
    }

    public static String input(String mensagem) {
        sc = new Scanner(System.in);

        System.out.println(mensagem);
        return sc.nextLine();

    }

}
