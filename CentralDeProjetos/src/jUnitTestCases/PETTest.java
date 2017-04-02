package jUnitTestCases;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.projeto.tipos.PET;

public class PETTest {

	
	
	PET projeto;

	
	@Before
	public void setUp() throws Exception {
		try {
			projeto = new PET("Zero Dawn", "Maquinas", 5, 5, 5, 5, 5, "10/10/2017", 24);

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testProjeto(){
		try {
			Assert.assertEquals("Zero Dawn", projeto.getNome());
			Assert.assertEquals("Maquinas", projeto.getObjetivo());
			Assert.assertEquals(5, projeto.getImpacto());
			Assert.assertEquals(5, projeto.getRendimento());
			Assert.assertEquals(5, projeto.getProdTecnica());
			Assert.assertEquals(5, projeto.getProdAcademica());
			Assert.assertEquals(5, projeto.getPatentes());
			Assert.assertEquals("10/10/2017", projeto.getDataInicio());
			Assert.assertEquals(24, projeto.getDuracao());

		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void testEditaProjeto(){
		try {
			
			projeto.editaProjeto("Nome", "SK");
			Assert.assertEquals("SK", projeto.getNome());
			
			projeto.editaProjeto("Impacto", "4");
			Assert.assertEquals(4, projeto.getImpacto());
			
			projeto.editaProjeto("Rendimento", "4");
			Assert.assertEquals(4, projeto.getRendimento());
			
			projeto.editaProjeto("Producao Tecnica", "4");
			Assert.assertEquals(4, projeto.getProdTecnica());
			
			projeto.editaProjeto("Producao Academica", "4");
			Assert.assertEquals(4, projeto.getProdAcademica());
			
			projeto.editaProjeto("Patentes", "4");
			Assert.assertEquals(4, projeto.getPatentes());
			
			projeto.editaProjeto("Objetivo", "O mesmo");
			Assert.assertEquals("O mesmo", projeto.getObjetivo());
			
			projeto.editaProjeto("Data de inicio", "11/11/2017");
			Assert.assertEquals("11/11/2017", projeto.getDataInicio());
			
			projeto.editaProjeto("Duracao", "12");
			Assert.assertEquals(12, projeto.getDuracao());

			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		
		try {
			projeto.editaProjeto("Nome", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Nome", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Nome nulo ou vazio", e.getMessage());
		}
		
		try {
			projeto.editaProjeto("Objetivo", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Objetivo", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		
		
		try {
			projeto.editaProjeto("Impacto", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Impacto nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Impacto", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Impacto nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Impacto", "-120");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Impacto invalido", e.getMessage());
		}
		
		try {
			projeto.editaProjeto("Rendimento", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Rendimento nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Rendimento", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Rendimento nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Rendimento", "-120");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Rendimento invalido", e.getMessage());
		}
		
		
		try {
			projeto.editaProjeto("Producao Tecnica", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao tecnica nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Producao Tecnica", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao tecnica nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Producao Tecnica", "-120");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Numero de producoes tecnicas invalido", e.getMessage());
		}
		
		try {
			projeto.editaProjeto("Producao Academica", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao academica nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Producao Academica", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao academica nulo ou vazio", e.getMessage());
		}
		try {
			projeto.editaProjeto("Producao Academica", "-120");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Numero de producoes academicas invalido", e.getMessage());
		}
		
		
		try {
			projeto.editaProjeto("Data de inicio", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projeto.editaProjeto("Data de inicio", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projeto.editaProjeto("Data de inicio", "2/2/16");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Formato de data invalido", e.getMessage());
		}
		try {
			projeto.editaProjeto("Duracao", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao nula ou vazia", e.getMessage());
		}
		try {
			projeto.editaProjeto("Duracao", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao nula ou vazia", e.getMessage());
		}
		try {
			projeto.editaProjeto("Duracao", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao invalida", e.getMessage());
		}
		try {
			projeto.editaProjeto("    ", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Atributo nulo ou invalido", e.getMessage());
		}
		try {
			projeto.editaProjeto("anos", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Atributo nulo ou invalido", e.getMessage());
		}
		
		
	}
	
	@Test
	public void testGetInfoProjeto(){
		try {
			Assert.assertEquals("Zero Dawn", projeto.getNome());
			Assert.assertEquals("Maquinas", projeto.getObjetivo());
			Assert.assertEquals(5, projeto.getImpacto());
			Assert.assertEquals(5, projeto.getRendimento());
			Assert.assertEquals(5, projeto.getProdTecnica());
			Assert.assertEquals(5, projeto.getProdAcademica());
			Assert.assertEquals(5, projeto.getPatentes());
			Assert.assertEquals("10/10/2017", projeto.getDataInicio());
			Assert.assertEquals(24, projeto.getDuracao());
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			Assert.assertEquals("Zero Dawn", projeto.getInfoProjeto("Categoria"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: PET nao possui Categoria", e.getMessage());
		}
		try {
			Assert.assertEquals("Zero Dawn", projeto.getInfoProjeto("Hello"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: Atributo nulo ou invalido", e.getMessage());
		}
	}

}
