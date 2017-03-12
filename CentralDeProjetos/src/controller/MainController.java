package controller;

import model.Pessoa;
import model.Projeto;

public class MainController {
	
	ParticipacaoController participacao;
	PessoasCRUD pessoas;
	ProjetosCRUD projetos;
	
	public MainController(){
		
		participacao = new ParticipacaoController();
		pessoas = new PessoasCRUD();
		projetos = new ProjetosCRUD();
		
	}

	public void associaProfessor(String cpfPessoa, String codigoProjeto, boolean coordenador, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoas.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetos.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		//TODO: Checar exceptions
		
		participacao.associaProfessor(pessoa, projeto, coordenador, valorHora, qntHoras);
	}

	public void associaProfissional(String cpfPessoa, String codigoProjeto, String cargo, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoas.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetos.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		participacao.associaProfissional(pessoa, projeto, cargo, valorHora, qntHoras);
	}


	public void associaGraduando(String cpfPessoa, String codigoProjeto, double valorHora, int qntHoras) throws Exception {
		Pessoa pessoa = pessoas.pessoas.get(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este método.
		Projeto projeto = projetos.getProjeto(codigoProjeto);
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		participacao.associaGraduando(pessoa, projeto, valorHora, qntHoras);
	}

	public void removeParticipacao(String cpfPessoa, String codigoProjeto) {
		participacao.removeParticipacao(cpfPessoa, codigoProjeto);
	}
	
	
}
