package fa7.agil;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestContaService {

	@Test
	public void transferencia_ok() throws Exception {
		
		MockContaManager mockContaManager = new MockContaManager();
		
		Conta contaOrigem = new Conta("1", 200);
		Conta contaBeneficiada = new Conta ("1", 100);
		
		mockContaManager.addConta("1", contaOrigem);
		mockContaManager.addConta("2", contaBeneficiada);
		
		ContaService contaService = new ContaService(mockContaManager);
		
		contaService.transferir("1", "2", 50);
		assertEquals(150, contaOrigem.getSaldo());
		assertEquals(150, contaBeneficiada.getSaldo());
	}
}
