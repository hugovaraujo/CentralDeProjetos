package controller;

import java.util.ArrayList;
import java.util.List;

import model.GraduandoParticipacao;
import model.Participacao;
import model.Pessoa;
import model.ProfessorParticipacao;
import model.ProfissionalParticipacao;
import model.Projeto;

/**
 * Classe que representa o controller de Participacao
 * 
 * @author
 *
 */

/**
 * @author neto
 *
 */
public class ParticipacaoController {
	
	public List<Participacao> participacoes;
	

	/**
	 * Construtor de ParticipacaoController
	 */
	public ParticipacaoController() {
		
		participacoes = new ArrayList<Participacao>();
		
	}
	
	/**
	 * Metodo que associa um Professor a uma participacao.
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param coordenador
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 */
	public void associaProfessor(Pessoa pessoa, Projeto projeto, boolean coordenador, double valorHora, int qntHoras, int duracao){
	
		ProfessorParticipacao participacao = new ProfessorParticipacao(pessoa, projeto, valorHora, qntHoras, duracao, coordenador);
		
		participacoes.add(participacao);
		
		
	}
	
	
	/**
	 * Metodo que associa um Profissional a uma participacao
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param cargo
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 */
	public void associaProfissional(Pessoa pessoa, Projeto projeto, String cargo, double valorHora, int qntHoras, int duracao){
	
		ProfissionalParticipacao participacao = new ProfissionalParticipacao(pessoa, projeto, valorHora, qntHoras, duracao, cargo);
		
		participacoes.add(participacao);
		
		
	}
	/**
	 * Metodo que associa um graduando a uma participacao.
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 */
	public void associaGraduando(Pessoa pessoa, Projeto projeto, double valorHora, int qntHoras, int duracao){
	
		GraduandoParticipacao participacao = new GraduandoParticipacao(pessoa, projeto, valorHora, qntHoras, duracao);
		
		participacoes.add(participacao);
		
		
	}
	public void removeParticipacao(){
		
	}


}
