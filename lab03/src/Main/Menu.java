package Main;

import Agenda.Agenda;
import util.Util;

public class Menu {
    public static void exibirMenu() {
        String opcaoMenu = "(C)adastrar Contato" + Util.pulaLinha(1)
                + "(CA)dastrar em Contato já existente" + Util.pulaLinha(1)
                + "(CO)nsultar Contato" + Util.pulaLinha(1)
                + "(L)istar Contatos" + Util.pulaLinha(1)
                + "(E)xibir Contato" + Util.pulaLinha(1)
                + "(S)air" + Util.pulaLinha(2)
                + "Opção> ";
        String comando = "";
        Agenda agenda = new Agenda();


        do {
            comando = Util.input(opcaoMenu).toUpperCase();

            switch (comando) {
                case "C":
                    cadastraPessoa(agenda);
                    break;

                case "L":
                    listarContatos(agenda);
                    break;

                case "E":
                    exibirContato(agenda);
                    break;

                case "S":
                    System.out.println("Obrigado!!");
                    break;

                case "CA":
                    cadastraOutroNumero(agenda);
                    break;

                case "CO":
                    consultarContato(agenda);

                default:
                    System.out.println("OPÇÃO INVÁLIDA\n");
            }

        } while (!comando.equals("S"));

    }

    private static void cadastraPessoa(Agenda agenda) {
        String posicao = Util.input(Util.pulaLinha(1) + "Posição: ");
        String tipo = Util.input("Tipo: ").toUpperCase();
        String nome = Util.input("Nome: ");
        String sobrenome = Util.input("Sobrenome: ");
        String nivelAmizade = Util.input("Nível de Amizade: ");
        String codigoPais = Util.input("Código do País: ");
        String ddd = Util.input("DDD: ");
        String numero = Util.input("Telefone: ");

        agenda.cadastraContato(nome, sobrenome, codigoPais, ddd, numero, tipo, Integer.parseInt(nivelAmizade), Integer.parseInt(posicao));
        System.out.println("CADASTRO REALIZADO" + Util.pulaLinha(1));

    }

    private static void cadastraOutroNumero(Agenda agenda) {
        String posicao = Util.input("Contato: ");
        String tipo = Util.input("Tipo: ");
        String codigoPais = Util.input("Código do País: ");
        String ddd = Util.input("DDD: ");
        String numero = Util.input("Telefone: " + Util.pulaLinha(1));

        agenda.cadastraOutroNumero(Integer.parseInt(posicao),tipo, codigoPais, ddd, numero);

    }
    private static void consultarContato(Agenda agenda) {
        String comando = "";
        String opcoes = "Consultar por:" + Util.pulaLinha(1)
                        + "(N)ome" + Util.pulaLinha(1)
                        + "(NI)vel de Amizade" + Util.pulaLinha(2)
                        + "Opção > ";

        comando = Util.input(opcoes).toUpperCase();

        switch (comando) {
            case "N":
                consultarPorNomeMenu(agenda);
                break;

            case "NI":
                consultarPorNivelMenu(agenda);
                break;

            default:
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    private static void consultarPorNomeMenu(Agenda agenda) {
        String nome = Util.input(Util.pulaLinha(1) + "Digite o nome: ");

        System.out.println(agenda.consultarPorNome(nome));
    }

    private static void consultarPorNivelMenu(Agenda agenda) {
        String nivel = Util.input(Util.pulaLinha(1) + "Digite o nível de Amizade: ");

        System.out.println(agenda.consultarPorNivel(Integer.parseInt(nivel)));
    }

    private static void listarContatos(Agenda agenda) {
        System.out.println();
        System.out.println(agenda.listarContatos());
    }

    private static void exibirContato(Agenda agenda) {
        String posicaoBusca = Util.input("Contato> ");

        System.out.println(agenda.exibirContato(Integer.parseInt(posicaoBusca)));
    }

    @Override
    public String toString() {
        return "Apenas um menu de interação para cadastro de pessoas na agenda";
    }
}