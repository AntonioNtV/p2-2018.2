package main;

import Alunos.*;

import util.Util;

public class MenuIteracao {
	public final static void exibirMenu() {
		String entrada = Util.input("Quantos Alunos você quer cadastrar? >" );
		int qtdAlunos = Integer.parseInt(entrada);
		controladorAlunos controle = new controladorAlunos(qtdAlunos);
		
		for (int i = 0; i < qtdAlunos; i++) {
			String[] info = Util.input("Digite o nome do aluno, a idade e a nota, separados por espaço").split(" ");
			controle.cadastraAlunos(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]));

 		}
		
		System.out.println(controle.qtdAlunos());
		
	}

}
 	