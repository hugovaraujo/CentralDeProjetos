package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.ParticipacaoControllerValidator;
import model.participacao.Participacao;
import model.participacao.tipos.GraduandoParticipacao;
import model.participacao.tipos.PosGraduandoParticipacao;
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
 * @author
 *
 */
public class ParticipacaoController {
	
	public List<Participacao> participacoes;
	private Participacao controleQuantidade;
	PessoasController pessoasController;
	ProjetosController projetosController;
	private ParticipacaoControllerValidator validator;
	
	/**
	 * Construtor de MainController 
	 */
	public ParticipacaoController(){
		
		participacoes = new ArrayList<>();
		pessoasController = new PessoasController();
		projetosController = new ProjetosController();
		validator = new ParticipacaoControllerValidator();
				
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
	 * @throws Exception 
	 */
	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras, int duracao) throws Exception{
		
		Pessoa pessoa = pessoasController.getPessoa(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este m�todo.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaProfessor(pessoa, projeto, qntHoras, valorHora, participacoes);
		
		ProfessorParticipacao participacao = new ProfessorParticipacao(pessoa, projeto, valorHora, qntHoras, coordenador,duracao);
		//System.out.println(" Associa Professor ------> Nome Projeto: " + participacao.getProjeto().getNome() + " Nome Pessoa: " + participacao.getPessoa().getNome() +" CPF: " + participacao.getPessoa().getCpf() + " Quantidade de horas: " + participacao.getQtdHoras() + " Valor da Hora: " + participacao.getValorHora());
		
		
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
	 * @throws Exception 
	 */
	
	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras, int duracao) throws Exception{
		Pessoa pessoa = pessoasController.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este m�todo.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaProfissional(pessoa, projeto);
	
		ProfissionalParticipacao participacao = new ProfissionalParticipacao(pessoa, projeto, cargo, valorHora, qntHoras,duracao);
		
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
	 * @throws Exception 
	 */
	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras, int duracao) throws Exception{
		
		Pessoa pessoa = pessoasController.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este m�todo.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaGraduando(pessoa, projeto, participacoes);

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
	 * @throws Exception 
	 */
	public void associaPosGraduando(String cpfPessoa, int codigoProjeto, String nivel, double valorHora, int qntHoras, int duracao) throws Exception{
		
		Pessoa pessoa = pessoasController.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este m�todo.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaPosGraduando(pessoa, projeto);
	
		PosGraduandoParticipacao participacao = new PosGraduandoParticipacao(pessoa, projeto, nivel, valorHora, qntHoras,duracao);
		
		participacoes.add(participacao);
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);	
		
	}
	
	
	
	public boolean removeParticipacao(String cpfPessoa, int codigoProjeto) throws Exception{
		
		Pessoa pessoa = pessoasController.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este m�todo.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaRemoveParticipacao(pessoa, projeto, participacoes);
		
		for (Participacao participacao : participacoes) {
			String cpfPessoa1 = participacao.getPessoa().getCpf();
			int codProjeto = participacao.getProjeto().getCodigo();
			
			if(cpfPessoa1.equals(pessoa.getCpf())&& (codProjeto == projeto.getCodigo())) {
				participacoes.remove(participacao);
				return true;
			}
		}
		return false;
	}
	
	public String getInfoPessoa(String cpf, String atributo) throws Exception{
		
		if(atributo.equals("Participacoes")){
			
			Pessoa pessoa = pessoasController.pessoas.get(cpf);
			
			if (pessoa == null) {
				throw new Exception("Pessoa nao existe");
			}
			
			return this.getPessoaParticipacao(pessoa);
			
		}else{
			 return pessoasController.getInfoPessoa(cpf, atributo);
		}
	}
	
	public String getInfoProjeto(int codigo, String atributo) throws Exception {
		
		if(atributo.equals("Participacoes")){
			
			Projeto projeto = projetosController.projetos.get(codigo);
			
			if (projeto == null) {
				throw new Exception("Erro na consulta de projeto: Projeto nao encontrado");
			}
			
			return this.getProjetoParticipantes(projeto);
			
		}else{
			 return projetosController.getInfoProjeto(codigo, atributo);
		}
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

	public PessoasController getPessoasController() {
		return pessoasController;
	}

	public ProjetosController getProjetosController() {
		return projetosController;
	}
	
	public double calculaPontuacaoPorParticipacao(String cpf) {
		double pontuacaoPorParticipacao = 0;
		
		for (Participacao participacao : participacoes) {
			if(participacao.getPessoa().getCpf().equals(cpf)){
				pontuacaoPorParticipacao += participacao.calculaPontuacaoPorParticipacao();
			}
		}
		return pontuacaoPorParticipacao;
	}
	
	public double getValorBolsa(String cpf){
		for (Participacao participacao : participacoes) {
			Pessoa pessoa = pessoasController.getPessoa(cpf);
			if (participacao.getPessoa().getCpf().equals(pessoa.getCpf())){
				return participacao.calculaBolsa();
			}
		}
		return 0;
	}
	
	
	
}
