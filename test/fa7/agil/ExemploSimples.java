package fa7.agil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mockito.internal.matchers.Any;

public class ExemploSimples {
	@Test
	public void primeiroExemplo() {
		List mockedList = mock(List.class);
		mockedList.add("primeiro");
		mockedList.clear();
		verify(mockedList).add("primeiro");
		verify(mockedList).clear();
	}

	@Test
	public void segundoExemplo() {
		List mockedList = mock(List.class);
		when(mockedList.get(0)).thenReturn("primeiro");
		assertThat(mockedList.get(0).toString(), is(equalTo("primeiro")));
		assertThat(mockedList.get(999), is(nullValue()));
	}

	@Test(expected = IOException.class)
	public void ObjectOutputStreamDeveRepassarExcecaoDoFileOutputStream()
			throws IOException {
		FileOutputStream mock = mock(FileOutputStream.class);
		ObjectOutputStream osw = new ObjectOutputStream(mock);
		doThrow(new IOException()).when(mock).close();
		osw.close();
	}

	@Test
	public void iteratorDeveRetornarOl·Mundo() {
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Ol·").thenReturn("Mundo");
		String result = i.next() + " " + i.next();
		assertThat(result, is(equalTo("Ol· Mundo")));
	}

	@Test
	public void comArgumentos() {
		Comparable c = mock(Comparable.class);
		//Quando chamar o metodo "c.compareTo("Teste")" retornar 1.
		when(c.compareTo("Teste")).thenReturn(1);
		assertEquals(1, c.compareTo("Teste"));
	}

	@Test
	public void semArgumentosEspecificos() {
		Comparable c = mock(Comparable.class);
		//Quando chamar qualquer String retornar -1.
		when(c.compareTo(anyString())).thenReturn(-1);
		assertEquals(-1, c.compareTo("xyz"));
	}
}