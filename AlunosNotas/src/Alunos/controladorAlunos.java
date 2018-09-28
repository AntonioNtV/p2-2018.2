package Alunos;

public class controladorAlunos {
	private Aluno[] alunos;
	
	public controladorAlunos(int qtdAlunos) {
		this.alunos = new Aluno[qtdAlunos];
	}
	
	public void cadastraAlunos(String nome, int idade, int nota) {
		for (int i = 0; i < this.alunos.length; i++) {
			if (this.alunos[i] == null) {
				this.alunos[i] = new Aluno(nome, idade, nota);
				break;

				
			}
		}
	}
	
	public int qtdAlunos() {
		int qtdAlunosNotaIdade = 0;
		
		for (int i = 0; i < this.alunos.length; i++) {
			if (this.alunos[i] != null && this.alunos[i].getIdade() > 20 && this.alunos[i].getNota() >= 7) {
				qtdAlunosNotaIdade ++;
			}
		}
		
		return qtdAlunosNotaIdade;
	}
}
