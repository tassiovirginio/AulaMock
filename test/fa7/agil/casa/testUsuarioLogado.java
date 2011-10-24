package fa7.agil.casa;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testUsuarioLogado {
	
	private LoginService loginService;
	private Usuario usuario;
	
	@Before
	public void setup(){
		IUsuarioManager manager = mock(IUsuarioManager.class);
		usuario = new Usuario();
		usuario.setIdusuario("1");
		usuario.setSenha("12345");
		when(manager.findUsuario(anyString())).thenReturn(usuario);
		assertEquals(usuario, manager.findUsuario(anyString()));
		loginService = new LoginService(manager);
	}
	
	@Test
	public void loginComASenhaCorreta() throws Exception {
		loginService.login("1", "12345");
		assertTrue(usuario.isLogado());
		assertFalse(usuario.isRevogado());
	}
	
	@Test
	public void loginComASenhaIncorreta(){
		loginService.login("1", "123457");
		assertFalse(usuario.isLogado());
		assertFalse(usuario.isRevogado());
	}
	
	@Test
	public void ultrapassaQtdTentativas(){
		loginService.login("1", "132123");
		loginService.login("1", "2342342");
		loginService.login("1", "2342455");
		assertFalse(usuario.isLogado());
		assertTrue(usuario.isRevogado());
	}

}