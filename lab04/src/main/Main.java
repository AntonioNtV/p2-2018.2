package main;

import controleAlunos.Controlador;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        System.out.println("---------- Teste de cadastra Aluno ----------");
        System.out.println(controlador.cadastraAluno("123","Neto", "Ciência da Computação"));
        System.out.println(controlador.cadastraAluno("123","Beto", "Ciência da Computação"));
        System.out.println(controlador.cadastraAluno("12345","Beto", "Ciência da Computação"));

        System.out.println("---------- Teste de consulta Aluno ----------");
        System.out.println(controlador.consultaAlunos("123"));
        System.out.println(controlador.consultaAlunos("1232131"));

        System.out.println("---------- Teste de cadastrarGrupo ----------");
        System.out.println(controlador.cadastraGrupo("Banho"));
        System.out.println(controlador.cadastraGrupo("Brenha"));
        System.out.println(controlador.cadastraGrupo("baNho"));

        System.out.println("---------- Teste aloca Alunos ----------");
        System.out.println(controlador.alocarAluno("Banho","123"));
        System.out.println(controlador.alocarAluno("banho","123"));
        System.out.println(controlador.alocarAluno("Creta","123"));
        System.out.println(controlador.alocarAluno("Banho","1313"));
        System.out.println(controlador.alocarAluno("banho","12345"));
        System.out.println(controlador.alocarAluno("Creta", "1313131"));

        System.out.println("---------- Teste Imprime Alunos ----------");
        System.out.println(controlador.imprimeGrupo("banho"));
        System.out.println(controlador.imprimeGrupo("Creta"));

        System.out.println("---------- Teste Cadastra Alunos que fazem questões no quadro ----------");
        System.out.println(controlador.cadastraAlunoQuestao("123"));
        System.out.println(controlador.cadastraAlunoQuestao("123"));
        System.out.println(controlador.cadastraAlunoQuestao("123333"));
        System.out.println(controlador.cadastraAlunoQuestao("12345"));

        System.out.println("---------- Teste Imprime Alunos que fazem questões no quadro ----------");
        System.out.println(controlador.imprimeAlunosQuestoes());


    }
}
