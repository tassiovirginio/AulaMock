package fa7.agil;

public class ContaService {

	private final MockContaManager manager;

	public ContaService(MockContaManager manager) {
		this.manager = manager;
	}

	public void transferir(String idOrigem, String idBeneficiaria, long valor) throws Exception{
		Conta origem = manager.findContaById(idOrigem);
		Conta beneficiaria = manager.findContaById(idBeneficiaria);
		
		origem.debitar(valor);
		beneficiaria.creditar(valor);
		
		manager.updateConta(origem);
		manager.updateConta(beneficiaria);	
	}
}
