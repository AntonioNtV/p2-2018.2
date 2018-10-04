package main;

import controleAlunos.Controlador;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        System.out.println("Teste de cadastra Aluno");
        System.out.println(controlador.cadastraAluno("123","Neto", "Ciência da Computação"));
        System.out.println(controlador.cadastraAluno("123","Beto", "Ciência da Computação"));
        System.out.println("Teste de consulta Alunos");
        System.out.println(controlador.consultaAlunos("123"));
        System.out.println(controlador.consultaAlunos("1232131"));

    }
}
