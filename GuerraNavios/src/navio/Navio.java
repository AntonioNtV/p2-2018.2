package navio;

public class Navio {
	private int vida;
	private Armas[] armas;
	
	public Navio(int vida) {
		this.vida = vida;
		this.armas = new Armas[10];
	}
	
	public void armaNavio(String nome, int poderFogo) {
		for (int i = 0; i < this.armas.length; i++) {
			if (this.armas[i] == null) {
				this.armas[i] = new Armas(nome, poderFogo);
				break;
			}
		}	
	}
	
	public int atira(String arma) {
		int dano = 0;
		for(int i = 0; i < this.armas.length; i++) {
			if(this.armas[i] != null && this.armas[i].getNome().equals(arma)) {
				dano = this.armas[i].atira();
			}
		}
		return dano;		
	}
	
	public void recebeTiro(int dano) {
		this.vida -= dano;
	}
}
