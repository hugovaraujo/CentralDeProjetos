package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.GraduandoParticipacao;
import model.Participacao;
import model.Pessoa;
import model.PosGraduandoParticipacao;
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
 * @author
 *
 */
public class ParticipacaoController {
	
	public List<Participacao> participacoes;
	private Participacao controleQuantidade;
	

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
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);
		
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
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);
		
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
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);
		
	}
	
	
	/**
	 * Metodo que associa um  pos-graduando a uma participacao.
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 */
	public void associaPosGraduando(Pessoa pessoa, Projeto projeto, String tipoVinculo, double valorHora, int qntHoras, int duracao){

		PosGraduandoParticipacao participacao = new PosGraduandoParticipacao(pessoa, projeto, tipoVinculo, valorHora, qntHoras, duracao);
		
		participacoes.add(participacao);
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);
		
		
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
		
		ArrayList<String> listaParticipantes = new ArrayList<String>();
		String participantes = "";
		
		for (Participacao participacao : participacoes) {
			
		
			if(projeto.getCodigo() == participacao.getProjeto().getCodigo()){
				listaParticipantes.add(participacao.getPessoa().getNome());
			}
		}
		Collections.sort(listaParticipantes);
		for (int i = 0; i < listaParticipantes.size(); i++) {
			
			if(i==0)
				participantes += listaParticipantes.get(i);
			else{
				participantes += ", " + listaParticipantes.get(i); 
			}
			
		}
		
		return participantes;
	}

	public Participacao getControleQuantidade() {
		return controleQuantidade;
	}

	public void setControleQuantidade(Participacao controleQuantidade) {
		this.controleQuantidade = controleQuantidade;
	}
	
	
	
	
}
