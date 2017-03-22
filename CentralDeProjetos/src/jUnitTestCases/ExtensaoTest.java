package jUnitTestCases;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.projeto.tipos.Extensao;

public class ExtensaoTest {

	Extensao projeto1;
	Extensao projeto2;
	
	@Before
	public void setUp() throws Exception {
		try {
			projeto1 = new Extensao("Zero Dawn", "Destruir", 6, "21/08/2100", 24);
			projeto2 = new Extensao("X", "Xzinho", 1, "01/01/2019", 12);
			

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void testProjeto(){
		try {
			Assert.assertEquals("Zero Dawn", projeto1.getNome());
			Assert.assertEquals("Destruir", projeto1.getObjetivo());
			Assert.assertEquals(6, projeto1.getImpacto());
			Assert.assertEquals("21/08/2100", projeto1.getDataInicio());
			Assert.assertEquals(24, projeto1.getDuracao());
			
			Assert.assertEquals("X", projeto2.getNome());
			Assert.assertEquals("Xzinho", projeto2.getObjetivo());
			Assert.assertEquals(1, projeto2.getImpacto());
			Assert.assertEquals("01/01/2019", projeto2.getDataInicio());
			Assert.assertEquals(12, projeto2.getDuracao());
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void testEditaProjeto(){
		try {
			
			projeto2.editaProjeto("Nome", "Xzao");
			Assert.assertEquals("Xzao", projeto2.getNome());
			projeto2.editaProjeto("Objetivo", "X maior");
			Assert.assertEquals("X maior", projeto2.getObjetivo());
			projeto2.editaProjeto("Impacto", "2");
			Assert.assertEquals(2, projeto2.getImpacto());
			projeto2.editaProjeto("Data de inicio", "02/02/2019");
			Assert.assertEquals("02/02/2019", projeto2.getDataInicio());
			projeto2.editaProjeto("Duracao", "11");
			Assert.assertEquals(11, projeto2.getDuracao());
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		
		try {
			projeto2.editaProjeto("Nome", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Nome", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Objetivo", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Objetivo", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Impacto", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Impacto nulo ou vazio", e.getMessage());
		}
		
		try {
			projeto2.editaProjeto("Impacto", "  ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Impacto nulo ou vazio", e.getMessage());
		}
		
		try {
			projeto2.editaProjeto("Impacto", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Impacto invalido", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Data de inicio", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Data de inicio", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Data de inicio", "2/2/16");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Formato de data invalido", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Duracao", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao nula ou vazia", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Duracao", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao nula ou vazia", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Duracao", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao invalida", e.getMessage());
		}
		try {
			projeto2.editaProjeto("    ", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Atributo nulo ou invalido", e.getMessage());
		}
		try {
			projeto2.editaProjeto("anos", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Atributo nulo ou invalido", e.getMessage());
		}
	}
	
	@Test
	public void testGetInfoProjeto(){
		try {
			Assert.assertEquals("Zero Dawn", projeto1.getInfoProjeto("Nome"));
			Assert.assertEquals("Destruir", projeto1.getInfoProjeto("Objetivo"));
			Assert.assertEquals("6", projeto1.getInfoProjeto("Impacto"));
			Assert.assertEquals("21/08/2100", projeto1.getInfoProjeto("Data de inicio"));
			Assert.assertEquals("24", projeto1.getInfoProjeto("Duracao"));
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			Assert.assertEquals("Zero Dawn", projeto1.getInfoProjeto("Rendimento"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: Extensao nao possui Rendimento", e.getMessage());
		}
		try {
			Assert.assertEquals("Zero Dawn", projeto1.getInfoProjeto("Hello"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: Atributo nulo ou invalido", e.getMessage());
		}
	}

}
