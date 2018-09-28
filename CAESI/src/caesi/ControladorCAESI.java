package caesi;

import util.Util;

public class ControladorCAESI {
	private Aluno[] alunos;

	
	public ControladorCAESI() {
		this.alunos = new Aluno[100];
	}
	
	public void cadastraAlunos(String nome, String matricula) {
		if (this.alunos[this.alunos.length -1] != null) {
			aumentaArray();
		}
		
		for (int i = 0; i < this.alunos.length; i ++) {
			if (this.alunos[i] == null) {
				this.alunos[i] = new Aluno(nome, matricula);
				break;
			}
		}
	}
	
	public boolean consultaAluno(String nome, String matricula) {
		boolean presente = false;
		
		for (int i = 0; i < this.alunos.length; i++) {
			if (this.alunos[i] != null && this.alunos[i].getNome().equals(nome) && this.alunos[i].getMatricula().equals(matricula)) {
				presente = true;
			}
		}
		return presente;
	}
	
	public String listaAlunos() {
		String presentes  = "";
		
		for (int i = 0; i < this.alunos.length; i++) {
			if (this.alunos[i] != null) {
				presentes += this.alunos[i].getMatricula() + Util.pulaLinhas(1);
			}
		}
		
		return presentes;
	}
	
	private void aumentaArray() {
		Aluno[] novosAlunos = new Aluno[(this.alunos.length * 2)];
		
		for (int i = 0; i < this.alunos.length; i++) {
			novosAlunos[i] = this.alunos[i];
		}
		
		this.alunos = novosAlunos;
	}

}
