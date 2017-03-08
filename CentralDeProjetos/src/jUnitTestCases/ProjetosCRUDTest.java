package jUnitTestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Monitoria;
import model.Extensao;
import model.PED;
import model.PET;

public class ProjetosCRUDTest {

	@Test
	public void testAdicionarMonitoria() {
		
		Monitoria m = new Monitoria("Nome", "disciplina", 1 , "objetivo", "periodo", null, 1);
		
		assertEquals("Nome", m.getNome());
		assertEquals("disciplina", m.getDisciplina());
		assertEquals(1, m.getRendimento());
		assertEquals("objetivo", m.getObjetivo());
		assertEquals("periodo", m.getPeriodo());
		assertEquals(1, m.getDuracao());
		
	}
	
	@Test
	public void testAdicionarExtensao() {
		
		Extensao e = new Extensao("Nome", "objetivo", 1, null, 1);
		
		assertEquals("Nome", e.getNome());
		assertEquals(1, e.getImpacto());
		assertEquals("objetivo", e.getObjetivo());
		assertEquals(1, e.getDuracao());
		
	}
	
	@Test
	public void testAdicionarPED() {
		
		PED p = new PED("Nome", "categoria", 1, 1, 1, "objetivo", null, 1);
		
		assertEquals("Nome", p.getNome());
		assertEquals(1, p.getProdTecnica());
		assertEquals(1, p.getProdAcademica());
		assertEquals(1, p.getPatentes());
		assertEquals("objetivo", p.getObjetivo());
		assertEquals(1, p.getDuracao());
		
	}
	
	@Test
	public void testAdicionarPET() {
		
		PET p = new PET("Nome", "objetivo", 1, 1, 1, 1, 1, null, 1);
		
		assertEquals("Nome", p.getNome());
		assertEquals(1, p.getImpacto());
		assertEquals(1, p.getRendimento());
		assertEquals(1, p.getProdTecnica());
		assertEquals(1, p.getProdAcademica());
		assertEquals(1, p.getPatentes());
		assertEquals("objetivo", p.getObjetivo());
		assertEquals(1, p.getDuracao());
		
	}
	
	

	@Test
	public void testRemoveProjeto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarProjeto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjeto() {
		fail("Not yet implemented");
	}

}
