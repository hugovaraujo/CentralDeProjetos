package jUnitTestCases;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.projeto.tipos.PED;

public class PEDTest {

	
	
	PED projetoPIVIC;
	PED projetoPIBIC;
	PED projetoPIBITI;
	PED projetoCOOP;
	
	@Before
	public void setUp() throws Exception {
		try {
			projetoPIVIC = new PED("Zero Dawn", "PIVIC", 1, 1, 1, "Maquinas", "05/05/2017", 24);
			projetoPIBIC = new PED("X", "PIBIC", 2, 2, 2, "Tecnologia", "06/06/2017", 24);
			projetoPIBITI = new PED("Attack on titan", "PIBITI", 3, 3, 3, "Entretenimento", "07/07/2017", 24);
			projetoCOOP = new PED("Shingeki no Kyojin", "COOP", 4, 4, 4, "Entretenimento", "08/08/2017", 24);	

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testProjeto(){
		try {
			Assert.assertEquals("Zero Dawn", projetoPIVIC.getNome());
			Assert.assertEquals("PIVIC", projetoPIVIC.getCategoria());
			Assert.assertEquals(1, projetoPIVIC.getProdTecnica());
			Assert.assertEquals(1, projetoPIVIC.getProdAcademica());
			Assert.assertEquals(1, projetoPIVIC.getPatentes());
			Assert.assertEquals("Maquinas", projetoPIVIC.getObjetivo());
			Assert.assertEquals("05/05/2017", projetoPIVIC.getDataInicio());
			Assert.assertEquals(24, projetoPIVIC.getDuracao());
			
			Assert.assertEquals("X", projetoPIBIC.getNome());
			Assert.assertEquals("PIBIC", projetoPIBIC.getCategoria());
			Assert.assertEquals(2, projetoPIBIC.getProdTecnica());
			Assert.assertEquals(2, projetoPIBIC.getProdAcademica());
			Assert.assertEquals(2, projetoPIBIC.getPatentes());
			Assert.assertEquals("Tecnologia", projetoPIBIC.getObjetivo());
			Assert.assertEquals("06/06/2017", projetoPIBIC.getDataInicio());
			Assert.assertEquals(24, projetoPIBIC.getDuracao());
			
			Assert.assertEquals("Attack on titan", projetoPIBITI.getNome());
			Assert.assertEquals("PIBITI", projetoPIBITI.getCategoria());
			Assert.assertEquals(3, projetoPIBITI.getProdTecnica());
			Assert.assertEquals(3, projetoPIBITI.getProdAcademica());
			Assert.assertEquals(3, projetoPIBITI.getPatentes());
			Assert.assertEquals("Entretenimento", projetoPIBITI.getObjetivo());
			Assert.assertEquals("07/07/2017", projetoPIBITI.getDataInicio());
			Assert.assertEquals(24, projetoPIBITI.getDuracao());
			
			Assert.assertEquals("Shingeki no Kyojin", projetoCOOP.getNome());
			Assert.assertEquals("COOP", projetoCOOP.getCategoria());
			Assert.assertEquals(4, projetoCOOP.getProdTecnica());
			Assert.assertEquals(4, projetoCOOP.getProdAcademica());
			Assert.assertEquals(4, projetoCOOP.getPatentes());
			Assert.assertEquals("Entretenimento", projetoCOOP.getObjetivo());
			Assert.assertEquals("08/08/2017", projetoCOOP.getDataInicio());
			Assert.assertEquals(24, projetoCOOP.getDuracao());

		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void testEditaProjeto(){
		try {
			
			projetoCOOP.editaProjeto("Nome", "SK");
			Assert.assertEquals("SK", projetoCOOP.getNome());
			projetoCOOP.editaProjeto("Categoria", "PIVIC");
			Assert.assertEquals("PIVIC", projetoCOOP.getCategoria());
			projetoCOOP.editaProjeto("Producao Tecnica", "5");
			Assert.assertEquals(5, projetoCOOP.getProdTecnica());
			projetoCOOP.editaProjeto("Producao Academica", "5");
			Assert.assertEquals(5, projetoCOOP.getProdAcademica());
			projetoCOOP.editaProjeto("Patentes", "5");
			Assert.assertEquals(5, projetoCOOP.getPatentes());
			projetoCOOP.editaProjeto("Objetivo", "O mesmo");
			Assert.assertEquals("O mesmo", projetoCOOP.getObjetivo());
			projetoCOOP.editaProjeto("Data de inicio", "09/09/2017");
			Assert.assertEquals("09/09/2017", projetoCOOP.getDataInicio());
			projetoCOOP.editaProjeto("Duracao", "12");
			Assert.assertEquals(12, projetoCOOP.getDuracao());

			
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			projetoCOOP.editaProjeto("Nome", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Nome", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Nome nulo ou vazio", e.getMessage());
		}
		
		try {
			projetoCOOP.editaProjeto("Categoria", "    ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Categoria nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Categoria", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Categoria nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Categoria", "PIBIT");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Categoria invalida", e.getMessage());
		}
		
		try {
			projetoCOOP.editaProjeto("Producao Tecnica", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao tecnica nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Producao Tecnica", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao tecnica nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Producao Tecnica", "-120");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Numero de producoes tecnicas invalido", e.getMessage());
		}
		
		try {
			projetoCOOP.editaProjeto("Producao Academica", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao academica nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Producao Academica", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Producao academica nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Producao Academica", "-120");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Numero de producoes academicas invalido", e.getMessage());
		}
		
		try {
			projetoCOOP.editaProjeto("Objetivo", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Objetivo", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Data de inicio", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Data de inicio", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Data de inicio", "2/2/16");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Formato de data invalido", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Duracao", "   ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao nula ou vazia", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Duracao", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao nula ou vazia", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("Duracao", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Duracao invalida", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("    ", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Atributo nulo ou invalido", e.getMessage());
		}
		try {
			projetoCOOP.editaProjeto("anos", "0");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na atualizacao de projeto: Atributo nulo ou invalido", e.getMessage());
		}
		
		
	}
	
	@Test
	public void testGetInfoProjeto(){
		try {
			Assert.assertEquals("Attack on titan", projetoPIBITI.getNome());
			Assert.assertEquals("PIBITI", projetoPIBITI.getCategoria());
			Assert.assertEquals(3, projetoPIBITI.getProdTecnica());
			Assert.assertEquals(3, projetoPIBITI.getProdAcademica());
			Assert.assertEquals(3, projetoPIBITI.getPatentes());
			Assert.assertEquals("Entretenimento", projetoPIBITI.getObjetivo());
			Assert.assertEquals("07/07/2017", projetoPIBITI.getDataInicio());
			Assert.assertEquals(24, projetoPIBITI.getDuracao());
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			Assert.assertEquals("Attack on titan", projetoPIBITI.getInfoProjeto("Impacto"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: PED nao possui Impacto", e.getMessage());
		}
		try {
			Assert.assertEquals("Attack on titan", projetoPIBITI.getInfoProjeto("Hello"));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro na consulta de projeto: Atributo nulo ou invalido", e.getMessage());
		}
	}

}
