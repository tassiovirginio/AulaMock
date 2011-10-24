package fa7.agil.casa;

public class Usuario {
	
	private String idusuario;
	private String senha;
	private boolean logado;
	private boolean revogado;
	
	public Usuario() {
		logado = false;
		revogado = false;
	}
	
	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean senhaConfere(String candidata){
		return senha.equals(candidata);
	}
	
	public void setLogado(boolean valor){
		this.logado = valor;
	}
	
	public void setRevogado(boolean valor){
		this.revogado = valor;
	}

	public boolean isLogado() {
		return logado;
	}

	public boolean isRevogado() {
		return revogado;
	}

}
