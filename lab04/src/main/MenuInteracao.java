package main;

import controleAlunos.Controlador;
import util.Util;

/**
 * Criado apenas para exibir o menu de interação com o usuário
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018 ©
 */
public class MenuInteracao {
    /**
     * Exibição do menu de iteração
     */
    public static void exibirMenu() {
        String opcaoMenu = "(C)adastrar Aluno" + Util.pulaLinha()
                + "(E)xibir aluno" + Util.pulaLinha()
                + "(N)ovo Grupo" + Util.pulaLinha()
                + "(A)locar Aluno no Grupo e Imprimir Grupos" + Util.pulaLinha()
                + "(R)egistrar Aluno que Respondeu" + Util.pulaLinha()
                + "(I)mprimir Alunos que Responderam" + Util.pulaLinha()
                + "(O)ra, vamos fechar o programa!" + Util.pulaLinha(2)
                + "Opção> ";

        String comando = "";
        Controlador controlador = new Controlador();

        do {
            comando = Util.input(opcaoMenu).toUpperCase();

            switch (comando) {
                case "C":
                    cadastraAluno(controlador);
                    break;

                case "E":
                    exibirAluno(controlador);
                    break;

                case "N":
                    novoGrupo(controlador);
                    break;

                case "A":
                    alocarOuImprimir(controlador);
                    break;

                case "R":
                    registraAlunoQueResponde(controlador);
                    break;

                case "I":
                    imprimeAlunosQueResponderam(controlador);
                    break;
            }

        } while (!comando.equals("O"));

    }

    /**
     * Criado para melhorar a legibilidade do "exibirMenu"
     */
    private static void cadastraAluno(Controlador controlador) {
        String matricula = Util.input("Matrícula: ");
        String nome = Util.input("Nome: ");
        String curso = Util.input("Curso: ");

        System.out.println(controlador.cadastraAluno(matricula,nome,curso) + Util.pulaLinha());
    }

    /**
     * Criado para melhorar a legibilidade do "exibirMenu"
     */
    private static void exibirAluno(Controlador controlador) {
        String matricula = Util.input("Matrícula: ");

        System.out.println(controlador.consultaAlunos(matricula) + Util.pulaLinha());
    }

    /**
     * Criado para melhorar a legibilidade do "exibirMenu"
     */
    private static void novoGrupo(Controlador controlador) {
        String grupo = Util.input("Grupo: ");

        System.out.println(controlador.cadastraGrupo(grupo) + Util.pulaLinha());
    }

    /**
     * Criado para melhorar a legibilidade do "exibirMenu"
     */
    private static void alocarOuImprimir(Controlador controlador) {
        String opcao = Util.input("(A)locar Aluno ou (I)mprimir Grupo? ").toUpperCase();

        switch (opcao) {
            case "A":
                String matricula = Util.input("Matrícula: ");
                String grupo = Util.input("Grupo: ");

                System.out.println(controlador.alocarAluno(grupo,matricula) + Util.pulaLinha());
                break;

            case "I":
                String grupo2 = Util.input("Grupo: ");
                System.out.println(controlador.imprimeGrupo(grupo2));
                break;

            default:
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    /**
     * Criado para melhorar a legibilidade do "exibirMenu"
     */
    private static void registraAlunoQueResponde(Controlador controlador) {
        String matricula = Util.input("Matrícula: ");

        System.out.println(controlador.cadastraAlunoQuestao(matricula) + Util.pulaLinha());
    }

    /**
     * Criado para melhorar a legibilidade do "exibirMenu"
     */
    private static void imprimeAlunosQueResponderam(Controlador controlador) {
        System.out.println(controlador.imprimeAlunosQuestoes() + Util.pulaLinha());
    }

}
