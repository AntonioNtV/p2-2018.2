package util;

import java.util.Scanner;

public class Util {
    public static String input(String mensagem) {
        Scanner sc = new Scanner(System.in);

        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static String pulaLinha(int qtdLinhas) {
        String linha = "";

        for (int i = 0; i < qtdLinhas; i++) {
            linha += "\n";
        }

        return linha;
    }

    @Override
    public String toString() {
        return "Criado apenas para auxiliar na construção do código.";
    }
}
