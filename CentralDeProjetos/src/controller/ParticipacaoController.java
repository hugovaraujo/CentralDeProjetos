package controller;

import java.util.ArrayList;
import java.util.List;

import model.participacao.Participacao;
import model.participacao.tipos.GraduandoParticipacao;
import model.participacao.tipos.ProfessorParticipacao;
import model.participacao.tipos.ProfissionalParticipacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

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
		
		ProfessorParticipacao participacao = new ProfessorParticipacao(pessoa, projeto, valorHora, qntHoras, coordenador,duracao);
		
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
	
		ProfissionalParticipacao participacao = new ProfissionalParticipacao(pessoa, projeto, valorHora, qntHoras,duracao);
		
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
	public boolean removeParticipacao(Pessoa pessoa, Projeto projeto){
		for (Participacao participacao : participacoes) {
			String cpfPessoa = participacao.getPessoa().getCpf();
			int codProjeto = participacao.getProjeto().getCodigo();
			
			if(cpfPessoa.equals(pessoa.getCpf())&& (codProjeto == projeto.getCodigo())) {
				participacoes.remove(participacao);
				return true;
			}
		}
		return false;
	}

	public String getPessoaParticipacao(Pessoa pessoa) {
		
		String projetos = "";
		
		for (Participacao participacao : participacoes) {
		
			if(pessoa.getCpf().equals(participacao.getPessoa().getCpf())){
				if(projetos.equals(""))
					projetos += participacao.getProjeto().getNome();
				else{
					projetos += ", "+ participacao.getProjeto().getNome();
				}
			}
			
		}
		
		return projetos;
	}

	public String getProjetoParticipantes(Projeto projeto) {
		
		String participantes = "";
		
		for (Participacao participacao : participacoes) {
			
		
			if(projeto.getCodigo() == participacao.getProjeto().getCodigo()){
				if(participantes.equals(""))
					participantes += participacao.getPessoa().getNome();
				else{
					participantes += ", "+ participacao.getPessoa().getNome();
				}
			}
			
		}
		
		return participantes;
	}
	
	


}
