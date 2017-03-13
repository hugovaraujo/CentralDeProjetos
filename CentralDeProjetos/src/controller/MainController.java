package controller;

import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class MainController {
	
	ParticipacaoController participacao;
	PessoasCRUD pessoasController;
	ProjetosCRUD projetosController;
	
	/**
	 * Construtor de MainController 
	 */
	public MainController(){
		
		participacao = new ParticipacaoController();
		pessoasController = new PessoasCRUD();
		projetosController = new ProjetosCRUD();
		
	}

	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoasController.getPessoa(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Erro na associacao de pessoa a projeto: Pessoa nao encontrada");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		//TODO: Checar exceptions
		
		participacao.associaProfessor(pessoa, projeto, coordenador, valorHora, qntHoras,0);
	}

	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoasController.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		participacao.associaProfissional(pessoa, projeto, cargo, valorHora, qntHoras,0);
	}


	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoasController.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		participacao.associaGraduando(pessoa, projeto, valorHora, qntHoras, 0);
	}

	public void removeParticipacao(String cpfPessoa, int codigoProjeto) throws Exception {
		
		Pessoa pessoa = pessoasController.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao encontrada");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao encontrado");
		}
		
		participacao.removeParticipacao(pessoa, projeto);
		
	}
	
	public String getInfoPessoa(String cpf, String atributo) throws Exception{
		
		if(atributo.equals("Participacoes")){
			
			Pessoa pessoa = pessoasController.pessoas.get(cpf);
			
			if (pessoa == null) {
				throw new Exception("Pessoa nao existe");
			}
			
			return participacao.getPessoaParticipacao(pessoa);
			
		}else{
			 return pessoasController.getInfoPessoa(cpf, atributo);
		}
	}
	
	public String getInfoProjeto(int codigo, String atributo) throws Exception {
		
		if(atributo.equals("Participacoes")){
			
			Projeto projeto = projetosController.projetos.get(codigo);
			
			if (projeto == null) {
				throw new Exception("Projeto nao existe");
			}
			
			return participacao.getProjetoParticipantes(projeto);
			
		}else{
			 return projetosController.getInfoProjeto(codigo, atributo);
		}
	}

	public ParticipacaoController getParticipacao() {
		return participacao;
	}

	public PessoasCRUD getPessoasController() {
		return pessoasController;
	}

	public ProjetosCRUD getProjetosController() {
		return projetosController;
	}
	
	
}
