package aluno;

public class Aluno {
	private String nome;
	private String matricula;
	private String apelido;
	private int nota;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		String apelido = "Não possui";
		
		if (this.apelido != null) {
			apelido = this.apelido;
		}
		
		return "nome: " + this.nome + " apelido: " + apelido + " matricula: " + this.matricula + " nota: " + this.nota;
	}
	
	

}
