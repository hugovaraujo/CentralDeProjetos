package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.ParticipacaoControllerValidator;
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
	PessoasCRUD pessoasController;
	ProjetosCRUD projetosController;
	private ParticipacaoControllerValidator validator;
	
	/**
	 * Construtor de MainController 
	 */
	public ParticipacaoController(){
		
		participacoes = new ArrayList<>();
		pessoasController = new PessoasCRUD();
		projetosController = new ProjetosCRUD();
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
	public void associaPosGraduando(Pessoa pessoa, Projeto projeto, String tipoVinculo, double valorHora, int qntHoras, int duracao) throws Exception{

		PosGraduandoParticipacao participacao = new PosGraduandoParticipacao(pessoa, projeto, tipoVinculo, valorHora, qntHoras, duracao);
		
		validator.validaAssociaPosGraduando(pessoa, projeto);
		
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

	public PessoasCRUD getPessoasController() {
		return pessoasController;
	}

	public ProjetosCRUD getProjetosController() {
		return projetosController;
	}
	
	
	
	
}
