package fa7.agil.casa;

public class LoginService {
	
	private int tentativasDeFalha;
	private IUsuarioManager manager;
	
	public LoginService(IUsuarioManager manager){
		this.manager = manager;
	}
	
	public void login(String idUsuario, String senha){
		Usuario usuario = this.manager.findUsuario(idUsuario);
		if(usuario.senhaConfere(senha)){
			usuario.setLogado(true);
		}else{
			tentativasDeFalha++;
		}
		if(tentativasDeFalha >= 3){
			usuario.setRevogado(true);
		}
	}

}
