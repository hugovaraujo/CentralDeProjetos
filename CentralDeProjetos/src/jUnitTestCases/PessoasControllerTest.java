package jUnitTestCases;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.PessoasController;

public class PessoasControllerTest {

	private PessoasController crud;

	@Before
	public void setUp() throws Exception {
		try {
			crud = new PessoasController();	
			crud.cadastraPessoa("200.150.150-01", "Wilson", "wilson@dont.starve.com.br");
			crud.cadastraPessoa("120.150.150-02", "Willow", "willow@dont.starve.com.br");
			crud.cadastraPessoa("200.150.300-03", "Wolfgang", "wolfgang@dont.starve.com.br");
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testCadastraPessoa(){
		try {
			crud.cadastraPessoa("100.100.100-05", "Wx", "wx78@dont.starve.com.br");
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			crud.cadastraPessoa("200.150.150-04", "Wendy", "wendy@dont.starve.com.br");
			crud.cadastraPessoa("200.150.150-04", "Abigail", "abigail.morta@dont.starve.com.br");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Pessoa com mesmo CPF ja cadastrada", e.getMessage());
		}
		//CPF
		try {
			crud.cadastraPessoa("250150150", "Wickerbottom", "wickerbottom@dont.starve.com.br");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: CPF invalido", e.getMessage());
		}
		try {
			crud.cadastraPessoa("    ", "Wickerbottom", "wickerbottom@dont.starve.com.br");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: CPF nulo ou vazio", e.getMessage());
		}
		try {
			crud.cadastraPessoa(null, "Wickerbottom", "wickerbottom@dont.starve.com.br");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: CPF nulo ou vazio", e.getMessage());
		}
		//Nome
		try {
			crud.cadastraPessoa("101.010.101-01", "   ", "erro@dont.starve.com.br");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Nome nulo ou vazio", e.getMessage());
		}
		try {
			crud.cadastraPessoa("101.010.101-10", null, "erro@dont.starve.com.br");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Nome nulo ou vazio", e.getMessage());
		}
		//Email
		try {
			crud.cadastraPessoa("101.010.101-10", "Woodie", "woodie@lucy");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Email invalido", e.getMessage());
		}
		try {
			crud.cadastraPessoa("101.010.101-10", "Woodie", "  ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Email nulo ou vazio", e.getMessage());
		}
		try {
			crud.cadastraPessoa("101.010.101-10", "Woodie", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de pessoa: Email nulo ou vazio", e.getMessage());
		}
		
	}
	
	@Test
	public void testEditarPessoa(){
		try {
			crud.cadastraPessoa("963.852.741-09", "Wes", "wes@dont.starve.com.br");
			Assert.assertEquals("963.852.741-09", crud.getInfoPessoa("963.852.741-09", "Cpf"));
			crud.editaPessoa("963.852.741-09", "Cpf", "863.145.741-09");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: CPF nao pode ser alterado", e.getMessage());
		}
		try {
			Assert.assertEquals("Wes", crud.getInfoPessoa("963.852.741-09", "Nome"));
			
			crud.editaPessoa("963.852.741-09", "Nome", "Mimico");
			Assert.assertEquals("Mimico", crud.getInfoPessoa("963.852.741-09", "Nome"));
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			Assert.assertEquals("wes@dont.starve.com.br", crud.getInfoPessoa("963.852.741-09", "Email"));
			crud.editaPessoa("963.852.741-09", "Email", "balaozinho@dont.starve.com.br");
			Assert.assertEquals("balaozinho@dont.starve.com.br", crud.getInfoPessoa("963.852.741-09", "Email"));
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		
		try {
			crud.editaPessoa("741.852.963-01", "Cpf", "123.456.789-01");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Pessoa nao encontrada", e.getMessage());
		}
		try {
			crud.editaPessoa("963.852.741-09", "Cpf", "123.456.789-001");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: CPF nao pode ser alterado", e.getMessage());
		}
		
		try {
			crud.editaPessoa("963.852.741-09", "Cpf", " ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: CPF nao pode ser alterado", e.getMessage());
		}
		try {
			crud.editaPessoa("963.852.741-09", "Cpf", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: CPF nao pode ser alterado", e.getMessage());
		}
		try {
			crud.editaPessoa("963.852.741-09", "Email", "piorpersonagem@");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Email invalido", e.getMessage());
		}
		try {
			crud.editaPessoa("963.852.741-09", "Email", "  ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Email nulo ou vazio", e.getMessage());
		}
		try {
			crud.editaPessoa("963.852.741-09", "Email", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de pessoa: Email nulo ou vazio", e.getMessage());
		}

		
	}

}
