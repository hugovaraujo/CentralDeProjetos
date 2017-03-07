package view;

import com.ufcg.edu.centraldeprojetos.PessoasCRUD;
import com.ufcg.edu.centraldeprojetos.ProjetosCRUD;

import model.Pessoa;
import model.Projeto;

public class ProjetoFacade {

	public PessoasCRUD controllerPessoas = new PessoasCRUD();
	public ProjetosCRUD controllerProjetos = new ProjetosCRUD();

	public boolean adicionarPessoa(Pessoa pessoa) {
		return controllerPessoas.adicionarPessoa(pessoa);
	}

	public boolean removerPessoa(Pessoa pessoa) {
		return controllerPessoas.removerPessoa(pessoa);
	}

	public boolean editarPessoa(Pessoa pessoa) {
		return controllerPessoas.removerPessoa(pessoa);
	}

	public Pessoa getPessoa(String cpf) {
		return controllerPessoas.getPessoa(cpf);
	}

	public boolean adicionarProjeto(Projeto novoProjeto) {
		return controllerProjetos.adicionarProjeto(novoProjeto);
	}

	public boolean removerProjeto(Projeto projeto) {
		return controllerProjetos.removeProjeto(projeto);
	}

	public Projeto editarProjeto(String codigoProjeto) {
		return controllerProjetos.getProjeto(codigoProjeto);
	}

}
