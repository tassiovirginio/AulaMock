package fa7.agil;

public class Conta {
	private String idConta;
	private long saldo;
	
	public Conta(String idConta, long saldoInicial) {
		super();
		this.idConta = idConta;
		this.saldo = saldoInicial;
	}

	public long getSaldo() {
		return saldo;
	}

	public void debitar(long valor) {
		saldo -= valor;
	}

	public void creditar(long valor) {
		saldo += valor;
	}
}
