package jUnitTestCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.CadastroException;
import exceptions.FormatoInvalidoException;
import model.Pessoa;

public class PessoaTest {

	private Pessoa pessoa1;
	private Pessoa pessoa2;
	private Pessoa pessoa3;

	
	@Before
	public void setUp() throws Exception {
		try {
			pessoa1 = new Pessoa("015.156.159-59", "Madoka", "madokamagica@outlook.com");
			pessoa2 = new Pessoa("589.265.148-69", "Akami", "akami@computacao.ufcg.edu.br");
			pessoa3 = new Pessoa("205.050.265-98", "Aloy", "horizonzerodawn@yahoo.com.br");
			

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void testPessoa(){
		try {
			Assert.assertEquals("Madoka", pessoa1.getNome());
			Assert.assertEquals("015.156.159-59", pessoa1.getCpf());
			Assert.assertEquals("madokamagica@outlook.com", pessoa1.getEmail());
			
			Assert.assertEquals("Akami", pessoa2.getNome());
			Assert.assertEquals("589.265.148-69", pessoa2.getCpf());
			Assert.assertEquals("akami@computacao.ufcg.edu.br", pessoa2.getEmail());
			
			Assert.assertEquals("Aloy", pessoa3.getNome());
			Assert.assertEquals("205.050.265-98", pessoa3.getCpf());
			Assert.assertEquals("horizonzerodawn@yahoo.com.br", pessoa3.getEmail());
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testPessoaInvalida() throws FormatoInvalidoException{
		try {

			Pessoa pessoaInvalida = new Pessoa(" ", "Madoka", "madokamagica@outlook.com");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: CPF nulo ou vazio", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa(null, "Madoka", "madokamagica@outlook.com");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: CPF nulo ou vazio", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("015.156.159-59", " ", "madokamagica@outlook.com");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Nome nulo ou vazio", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("015.156.159-59", null,"madokamagica@outlook.com");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Nome nulo ou vazio", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("Madoka", "015.156.159-59", "  ");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Email nulo ou vazio", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("Madoka", "015.156.159-59", null);
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Email nulo ou vazio", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("Madoka", "015.156.159-599", "madokamagica@outlook.com");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: CPF invalido", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("Madoka", "01515615959", "madokamagica@outlook.com");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: CPF invalido", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("015.156.159-59", "Madoka",  "madokamagica@");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Email invalido", e.getMessage());
		}
		try {

			Pessoa pessoaInvalida = new Pessoa("015.156.159-59", "Madoka", "@outlook.com");
			Assert.fail();
		} catch (CadastroException e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Email invalido", e.getMessage());
		}
	}
	
	@Test
	public void testSet(){
		try {
			pessoa1.setCpf("123.159.245-69");
			Assert.assertEquals("123.159.245-69", pessoa1.getCpf());
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			pessoa1.setEmail("madokamagica@ccc.ufcg.edu.br");
			Assert.assertEquals("madokamagica@ccc.ufcg.edu.br", pessoa1.getEmail());
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			pessoa1.setNome("Indecisa");
			Assert.assertEquals("Indecisa", pessoa1.getNome());
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			pessoa1.setNome("      ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Nome nulo ou vazio", e.getMessage());
		}
		try {
			pessoa1.setNome(null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Nome nulo ou vazio", e.getMessage());
		}
		try {
			pessoa1.setEmail("      ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Email nulo ou vazio", e.getMessage());
		}
		try {
			pessoa1.setEmail(null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Email nulo ou vazio", e.getMessage());
		}
		try {
			pessoa1.setEmail("madokamagica");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Email invalido", e.getMessage());
		}

		

	}
}
