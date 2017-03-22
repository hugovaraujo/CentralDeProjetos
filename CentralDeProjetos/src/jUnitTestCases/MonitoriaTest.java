package jUnitTestCases;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.projeto.tipos.Monitoria;

public class MonitoriaTest {

	
	
	Monitoria projeto1;
	Monitoria projeto2;
	
	@Before
	public void setUp() throws Exception {
		try {
			projeto1 = new Monitoria("Zero Dawn", "Jogos Digitais", 100, "Maquinas", "2017.1", "28/02/2017", 24);
			projeto2 = new Monitoria("Z", "Portugues", 10, "Cof Cof", "2000.2", "03/03/2013", 2);
			

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testProjeto(){
		try {
			Assert.assertEquals("Zero Dawn", projeto1.getNome());
			Assert.assertEquals("Jogos Digitais", projeto1.getDisciplina());
			Assert.assertEquals(100, projeto1.getRendimento());
			Assert.assertEquals("Maquinas", projeto1.getObjetivo());
			Assert.assertEquals("2017.1", projeto1.getPeriodo());
			Assert.assertEquals("28/02/2017", projeto1.getDataInicio());
			Assert.assertEquals(24, projeto1.getDuracao());
			
			Assert.assertEquals("Z", projeto2.getNome());
			Assert.assertEquals("Portugues", projeto2.getDisciplina());
			Assert.assertEquals(10, projeto2.getRendimento());
			Assert.assertEquals("Cof Cof", projeto2.getObjetivo());
			Assert.assertEquals("2000.2", projeto2.getPeriodo());
			Assert.assertEquals("03/03/2013", projeto2.getDataInicio());
			Assert.assertEquals(2, projeto2.getDuracao());
			
		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void testEditaProjeto(){
		try {
			
			projeto2.editaProjeto("Nome", "Zzao");
			Assert.assertEquals("Zzao", projeto2.getNome());
			projeto2.editaProjeto("Disciplina", "Chata");
			Assert.assertEquals("Chata", projeto2.getDisciplina());
			projeto2.editaProjeto("Rendimento", "2");
			Assert.assertEquals(2, projeto2.getRendimento());
			projeto2.editaProjeto("Objetivo", "Z maior");
			Assert.assertEquals("Z maior", projeto2.getObjetivo());
			projeto2.editaProjeto("Periodo", "2001.1");
			Assert.assertEquals("2001.1", projeto2.getPeriodo());
			projeto2.editaProjeto("Data de inicio", "02/02/2001");
			Assert.assertEquals("02/02/2001", projeto2.getDataInicio());
			projeto2.editaProjeto("Duracao", "1");
			Assert.assertEquals(1, projeto2.getDuracao());
			
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
			projeto2.editaProjeto("Disciplina", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Disciplina nula ou vazia", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Disciplina", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Disciplina nula ou vazia", e.getMessage());
		}
		
		try {
			projeto2.editaProjeto("Rendimento", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Rendimento nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Rendimento", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Rendimento nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Rendimento", "120");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Rendimento invalido", e.getMessage());
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
			projeto2.editaProjeto("Periodo", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Periodo nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Periodo", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Periodo nulo ou vazio", e.getMessage());
		}
		try {
			projeto2.editaProjeto("Periodo", "2010.6");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Periodo invalido", e.getMessage());
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
			Assert.assertEquals("Jogos Digitais", projeto1.getInfoProjeto("Disciplina"));
			Assert.assertEquals("100", projeto1.getInfoProjeto("Rendimento"));
			Assert.assertEquals("Maquinas", projeto1.getInfoProjeto("Objetivo"));
			Assert.assertEquals("2017.1", projeto1.getInfoProjeto("Periodo"));
			Assert.assertEquals("28/02/2017", projeto1.getInfoProjeto("Data de inicio"));
			Assert.assertEquals("24", projeto1.getInfoProjeto("Duracao"));
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			Assert.assertEquals("Zero Dawn", projeto1.getInfoProjeto("Impacto"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: Monitoria nao possui Impacto", e.getMessage());
		}
		try {
			Assert.assertEquals("Zero Dawn", projeto1.getInfoProjeto("Hello"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: Atributo nulo ou invalido", e.getMessage());
		}
	}

}
