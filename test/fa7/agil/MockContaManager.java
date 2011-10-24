package fa7.agil;

import java.util.HashMap;
import java.util.Map;

public class MockContaManager {
	private Map<String, Conta> contas = new HashMap<String, Conta>();

	public void addConta(String idConta, Conta conta) {
		contas.put(idConta, conta);
	}

	public Conta findContaById(String idConta) {
		return contas.get(idConta);
	}

	public void updateConta(Conta origem) {
		// DEBIT nao faz nada por enquanto
	}
}
