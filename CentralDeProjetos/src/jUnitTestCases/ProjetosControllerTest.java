package jUnitTestCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.ProjetosController;
import exceptions.CadastroException;
import exceptions.ParametroInvalidoException;
import exceptions.StringInvalidaException;


public class ProjetosControllerTest {
	
	ProjetosController projetos = new ProjetosController();
	
	@Before
	public void setUp() throws Exception {
		try {
			projetos.adicionaMonitoria("Monitoria", "disciplina", 1 , "objetivo", "2016.2", "01/01/2017", 1);
			projetos.adicionaExtensao("Extensao", "objetivo", 1, "02/02/2018", 1);
			projetos.adicionaPED("PED", "PIBIC", 1, 1, 1, "objetivo", "01/01/2111", 1);
			projetos.adicionaPET("PET", "objetivo", 1, 1, 1, 1, 1, "03/03/2013", 1);

		} catch (Exception e) {
			Assert.fail();
		}
	}


	@Test
	public void testAdicionarMonitoria() throws CadastroException, ParametroInvalidoException, StringInvalidaException {
		
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", "2016.2", "01/01/2017", 1);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			projetos.adicionaMonitoria("  ", "disciplina", 1 , "objetivo", "2016.2", null, 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria(null, "disciplina", 1 , "objetivo", "2016.2", null, 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "   ", 1 , "objetivo", "2016.2", "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Disciplina nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", null, 1 , "objetivo", "2016.2", "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Disciplina nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", -1 , "objetivo", "2016.2", "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Rendimento invalido", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "  ", "2016.2", "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , null, "2016.2", "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", "    ", "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Periodo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", null, "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Periodo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", "2016.22", "01/01/2017", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Periodo invalido", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", "2016.2", "   ", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", "2016.2", null, 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", "2016.2", "01/1/2018", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Formato de data invalido", e.getMessage());
		}
		try {
			projetos.adicionaMonitoria("Nome", "disciplina", 1 , "objetivo", "2016.2", "01/01/2017", -1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Duracao invalida", e.getMessage());
		}

		
	}
	
	@Test
	public void testAdicionarExtensao() throws CadastroException, ParametroInvalidoException, StringInvalidaException {
		try {
			projetos.adicionaExtensao("Nome", "objetivo", 1, "02/02/2018", 1);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			projetos.adicionaExtensao("   ", "objetivo", 1, "02/02/2018", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaExtensao(null, "objetivo", 1, "02/02/2018", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaExtensao("Nome", "    ", 1, "02/02/2018", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaExtensao("Nome", null, 1, "02/02/2018", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaExtensao("Nome", "objetivo", -1, "02/02/2018", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Impacto invalido", e.getMessage());
		}
		try {
			projetos.adicionaExtensao("Nome", "objetivo", 1, "    ", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaExtensao("Nome", "objetivo", 1, null, 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaExtensao("Nome", "objetivo", 1, "02/02/201888", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Formato de data invalido", e.getMessage());
		}
		try {
			projetos.adicionaExtensao("Nome", "objetivo", 1, "02/02/2018", -1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Duracao invalida", e.getMessage());
		}
		
	}
	
	@Test
	public void testAdicionarPED() throws CadastroException, ParametroInvalidoException, StringInvalidaException {
		
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, 1, "objetivo", "01/01/2111", 1);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			projetos.adicionaPED("   ", "PIBIC", 1, 1, 1, "objetivo", "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPED(null, "PIBIC", 1, 1, 1, "objetivo", "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "   ", 1, 1, 1, "objetivo", "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Categoria invalida", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", -1, 1, 1, "objetivo", "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Numero de producoes tecnicas invalido", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, -1, 1, "objetivo", "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Numero de producoes academicas invalido", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, -1, "objetivo", "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Numero de patentes invalido", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, 1, "   ", "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, 1, null, "01/01/2111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, 1, "objetivo", "        ", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, 1, "objetivo", null, 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, 1, "objetivo", "01/01/211111", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Formato de data invalido", e.getMessage());
		}
		try {
			projetos.adicionaPED("Nome", "PIBIC", 1, 1, 1, "objetivo", "01/01/2111", -1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Duracao invalida", e.getMessage());
		}
		
		
	}
	
	@Test
	public void testAdicionarPET() throws CadastroException, ParametroInvalidoException, StringInvalidaException {
		
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, 1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			projetos.adicionaPET("   ", "objetivo", 1, 1, 1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPET(null, "objetivo", 1, 1, 1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Nome nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "    ", 1, 1, 1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", null, 1, 1, 1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", -1, 1, 1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Impacto invalido", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, -1, 1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Rendimento invalido", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, -1, 1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Numero de producoes tecnicas invalido", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, 1, -1, 1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Numero de producoes academicas invalido", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, 1, 1, -1, "03/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Numero de patentes invalido", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, 1, 1, 1, "   ", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, 1, 1, 1, null, 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Data de inicio nula ou vazia", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, 1, 1, 1, "0333/03/2013", 1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Formato de data invalido", e.getMessage());
		}
		try {
			projetos.adicionaPET("Nome", "objetivo", 1, 1, 1, 1, 1, "03/03/2013", -1);
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de projeto: Duracao invalida", e.getMessage());
		}
		
		

		
	}
	
	

}
	

