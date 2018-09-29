package time;

public class Jogador {
	private String nome;
	private String posicao;
	private int qtdGols;
	
	
	public Jogador(String nome, String posicao) {
		this.nome = nome;
		this.posicao = posicao;
		this.qtdGols = 0;
	}
	
	public void cadastraGol() {
		this.qtdGols ++;
	}
	
	public int getQtdGols() {
		return this.qtdGols;
	}

}
