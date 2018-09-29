package navio;

public class Armas {
	private String nome;
	private int poderFogo;
	private int municao;
	
	public Armas(String nome, int poderFogo) {
		this.nome = nome;
		this.poderFogo = poderFogo;
		this.municao = 50;
	}
	
	public int atira() {
		this.municao --;
		return this.poderFogo;
	}
	
	public String getNome() {
		return this.nome;
	}

}
