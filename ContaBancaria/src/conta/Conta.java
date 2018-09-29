package conta;

public class Conta {
	private double saldo;
	
	
	public Conta() {
		this.saldo = 0.0;
	}
	
	public Conta(double valor) {
		this.saldo = valor;
	}
	
	public void sacaValor(double valor) {
		this.saldo -= valor;
	}
	
	public void depositaValor(double valor) {
		this.saldo += valor;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

}
