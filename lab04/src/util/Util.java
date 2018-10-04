package util;

import java.util.Scanner;

public class Util {
    public static String input(String mensagem) {
        if (mensagem == null) {
            mensagem = "";
        }

        Scanner sc = new Scanner(System.in);

        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static String pulaLinha() {
        return System.lineSeparator();
    }

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

    public static int intInput(String mensagem) {
        if (mensagem == null) {
            mensagem = "";
        }

        Scanner sc2 = new Scanner(System.in);

        System.out.print(mensagem);
        return sc2.nextInt();
    }

}
