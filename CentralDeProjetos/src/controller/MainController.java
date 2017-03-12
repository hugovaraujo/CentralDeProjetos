package controller;

import model.Pessoa;
import model.Projeto;

public class MainController {
	
	ParticipacaoController participacao;
	PessoasCRUD pessoas;
	ProjetosCRUD projetos;
	
	/**
	 * Construtor de MainController 
	 */
	public MainController(){
		
		participacao = new ParticipacaoController();
		pessoas = new PessoasCRUD();
		projetos = new ProjetosCRUD();
		
	}

	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoas.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetos.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		//TODO: Checar exceptions
		
		participacao.associaProfessor(pessoa, projeto, coordenador, valorHora, qntHoras,0);
	}

	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoas.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetos.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		participacao.associaProfissional(pessoa, projeto, cargo, valorHora, qntHoras,0);
	}


	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoas.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetos.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		participacao.associaGraduando(pessoa, projeto, valorHora, qntHoras, 0);
	}

	public void removeParticipacao(String cpfPessoa, String codigoProjeto) {
	//	participacao.removeParticipacao(cpfPessoa, codigoProjeto);
	}
	
	
}
