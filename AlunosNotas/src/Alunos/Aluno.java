package Alunos;

public class Aluno {
	private String nome;
	private int idade;
	private int nota;
	
	
	public Aluno(String nome, int idade, int nota) {
		this.nome = nome;
		this.idade = idade;
		this.nota = nota;
	}
	
	public int getNota() {
		return this.nota;
	}
	
	public int getIdade() {
		return this.idade;
	}

}
