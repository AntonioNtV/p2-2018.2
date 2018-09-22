package Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comando = "";
        Agenda agenda = new Agenda();

        do {
            System.out.println("\n(C)adastrar Contato");
            System.out.println("(L)istar Contatos");
            System.out.println("(E)xibir Contato");
            System.out.println("(S)air");

            System.out.print("\nOpção> ");
            comando = sc.nextLine().toUpperCase();

            switch (comando) {
                case "C":
                    System.out.print("Posição: ");
                    String posicao = sc.nextLine();
                    if (Integer.parseInt(posicao) > 100) {
                        System.out.println("POSIÇÃO INVÁLIDA");
                        break;
                    }

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Sobrenome: ");
                    String sobrenome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String numero = sc.nextLine();

                    agenda.cadastraContato(nome,sobrenome,numero,Integer.parseInt(posicao));
                    System.out.println("CADASTRO REALIZADO");
                    break;

                case "L":
                    System.out.println();
                    agenda.listarContatos();
                    break;

                case "E":
                    System.out.print("Contato> ");
                    String posicaoBusca = sc.nextLine();

                    agenda.exibirContato(Integer.parseInt(posicaoBusca));
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }

        } while (!comando.equals("S"));
        System.out.println("Obrigado!");
    }
}
