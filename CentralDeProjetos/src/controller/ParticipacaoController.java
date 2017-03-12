package controller;

import java.util.ArrayList;
import java.util.List;

import model.GraduandoParticipacao;
import model.Participacao;
import model.Pessoa;
import model.ProfessorParticipacao;
import model.ProfissionalParticipacao;
import model.Projeto;

public class ParticipacaoController {
	
	public List<Participacao> participacoes;
	

	public ParticipacaoController() {
		
		participacoes = new ArrayList<Participacao>();
		
	}
	
	public void associaProfessor(Pessoa pessoa, Projeto projeto, boolean coordenador, double valorHora, int qntHoras){
	
		ProfessorParticipacao participacao = new ProfessorParticipacao(pessoa, projeto, valorHora, qntHoras, duracao, coordenador);
		
		participacoes.add(participacao);
		
		
	}
	public void associaProfissional(Pessoa pessoa, Projeto projeto, String cargo, double valorHora, int qntHoras){
	
		ProfissionalParticipacao participacao = new ProfissionalParticipacao(pessoa, projeto, valorHora, qntHoras);
		
		participacoes.add(participacao);
		
		
	}
	public void associaGraduando(Pessoa pessoa, Projeto projeto, double valorHora, int qntHoras){
	
		GraduandoParticipacao participacao = new GraduandoParticipacao(pessoa, projeto, valorHora, qntHoras);
		
		participacoes.add(participacao);
		
		
	}
	public void removeParticipacao(String cpfPessoa, String codigoProjeto){
		//TODO: Busca linear procurando pelo CPF da pessoa e depois conferindo se o projeto é igual. Se for, deleta.
	}


}
