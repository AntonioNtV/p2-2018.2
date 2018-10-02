package Util;

import java.util.Scanner;

public class Util {
    public static String input(String mensagem) {
        Scanner sc = new Scanner(System.in);

        System.out.println(mensagem);
        return sc.nextLine();
    }

    public static int inputInt(String mensagem) {
        Scanner scInt = new Scanner(System.in);

        System.out.println(mensagem);
        return scInt.nextInt();
    }

    public static String pulaLinhas(int qtdLinhas) {
        String linhas = "";

        for (int i = 0; i < qtdLinhas; i++) {
            linhas += System.lineSeparator();
        }
        return linhas;
    }

    public static String pulaLinhas() {
        return System.lineSeparator();
    }
}
