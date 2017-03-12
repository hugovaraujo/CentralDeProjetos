package jUnitTestCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.FormatoInvalidoException;
import exceptions.StringInvalidaException;
import exceptions.Verificador;

public class VerificadorTest {
	
	String nome, cpf, email, data;
	Verificador verificador = new Verificador();
	
	@Before
	public void setUp() throws Exception {
		try {
			nome = "Harry";
			cpf = "666.555.444-33";
			email = "harrypotter@hogwarts.grifinoria.uk";
			data = "21/08/1997";
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testVerificaString(){
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaString(cpf, "Cpf");
			verificador.verificaString(email, "Email");
			verificador.verificaString(data, "Data");
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testVerificaStringInvalida() throws StringInvalidaException{
		try {
			verificador.verificaString("", "Nome");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
		}
		try {
			verificador.verificaString(null, "Nome");
			Assert.fail();
		} catch (StringInvalidaException e) {
			Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
		}
		try {
			verificador.verificaString("", "Cpf");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Cpf nulo ou vazio", e.getMessage());
		}
		try {
			verificador.verificaString(null, "Cpf");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Cpf nulo ou vazio", e.getMessage());
		}
		try {
			verificador.verificaString("", "Email");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Email nulo ou vazio", e.getMessage());
		}
		try {
			verificador.verificaString(null, "Email");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Email nulo ou vazio", e.getMessage());
		}
		try {
			verificador.verificaString("", "Data");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Data nulo ou vazio", e.getMessage());
		}
		try {
			verificador.verificaString("  ", "Data");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Data nulo ou vazio", e.getMessage());
		}
		

	}
	
	@Test
	public void testVerificaEmail(){
		try {
			verificador.verificaEmail(email);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			String emailInvalido = "juleobar@gmail..com";
			verificador.verificaEmail(emailInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("Email invalido", e.getMessage());
		}
		try {
			String emailInvalido = "juleobar@@gmail.com";
			verificador.verificaEmail(emailInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("Email invalido", e.getMessage());
		}
		try {
			String emailInvalido = "juleobar.gmail.com";
			verificador.verificaEmail(emailInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("Email invalido", e.getMessage());
		}
		try {
			String emailInvalido = "juleobar@@gmailcom";
			verificador.verificaEmail(emailInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("Email invalido", e.getMessage());
		}
		try {
			String emailInvalido = "@gmail.com";
			verificador.verificaEmail(emailInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("Email invalido", e.getMessage());
		}
	
	}
	
	@Test
	public void testVerificaCpf(){
		try {
			verificador.verificaCpf(cpf);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			String cpfInvalido = "058014.574-54";
			verificador.verificaCpf(cpfInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		try {
			String cpfInvalido = "058..014.574-54";
			verificador.verificaCpf(cpfInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		try {
			String cpfInvalido = "058.014.574.54";
			verificador.verificaCpf(cpfInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		try {
			String cpfInvalido = "058.0014.574-54";
			verificador.verificaCpf(cpfInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		try {
			String cpfInvalido = "058.014.574-564";
			verificador.verificaCpf(cpfInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		try {
			String cpfInvalido = "058.014.574564";
			verificador.verificaCpf(cpfInvalido);
			Assert.fail();
		} catch (FormatoInvalidoException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
	}
	
	@Test
	public void testVerificaData(){
		try {
			verificador.verificaData(data);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		try {
			String data = "01.02.2017";
			verificador.verificaData(data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			String data = "32/02/1920";
			verificador.verificaData(data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			String data = "10/13/1920";
			verificador.verificaData(data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			String data = "10/0200/1978";
			verificador.verificaData(data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			String data = "1010/02/1978";
			verificador.verificaData(data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			String data = "10/02/19";
			verificador.verificaData(data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Formato de data invalido", e.getMessage());
		}
		
	}
	
	
	
}
