package jUnitTestCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.pessoa.Pessoa;

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
	
}
