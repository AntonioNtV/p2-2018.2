package maletaBancaria;

public class MaletaBancaria {
	int total;
	int totaloperacoes;
	
	public MaletaBancaria() {
		this.total = 0;
		this.totaloperacoes = 0;
		
	}
	
	public void cadastraConta(int valor) {
		this.total += valor;
		this.totaloperacoes ++;
	}
	
	private int media() {
		return this.total / this.totaloperacoes;
	
	}

	@Override
	public String toString() {
		return this.total + " " + this.media();
	}
	
	
	
	
	
	

}
