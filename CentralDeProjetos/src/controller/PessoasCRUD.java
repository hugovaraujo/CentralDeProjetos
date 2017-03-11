package controller;

import java.util.HashMap;
import model.Pessoa;

public class PessoasCRUD {

	public HashMap<String, Pessoa> pessoas;

	public PessoasCRUD() {
		pessoas = new HashMap<>();
	}

	/**
	 * 
	 * Adiciona uma nova pessoa ao conjunto de pessoas ja existentes.
	 * 
	 * @param Pessoa
	 * @return true se for adicionado, false se nao for possivel adicionar.
	 * @throws Exception
	 */
	
	
	public void cadastraPessoa(String cpf, String nome, String email) throws Exception {
		
		if (pessoas.containsKey(cpf)) {
			throw new Exception("Pessoa ja consta no banco de dados de pessoas");
		}
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		pessoas.put(pessoa.getCpf(), pessoa);

	}

	/**
	 * Remove uma pessoa do conjunto de pessoas ja existentes.
	 * 
	 * @param pessoa
	 * @return true se for removido com sucesso, falso se nao for possivel
	 *         remover.
	 * @throws Exception
	 */
	public void removerPessoa(String cpf) throws Exception {
		if (!pessoas.containsKey(cpf)) {
			throw new Exception("Pessoa nao existe no banco de dados de pessoas");
		}
		pessoas.remove(cpf);
	}

	/**
	 * Edita uma pessoa enviada como parametro.
	 * 
	 * @param pessoa
	 * @return retorna true se editar com sucesso, falso se nao for possivel
	 *         editar.
	 */
	public boolean editarPessoa(Pessoa pessoa) {
		// TODO: Descobrir o que vai ser editado na pessoa
		return false;
	}

	/**
	 * Procura uma pessoa no conjunto, usando o CPF como chave.
	 * 
	 * @param cpf
	 * @return retorna a pessoa a qual o CPF pertence ou null caso nao ache uma
	 *         pessoa.
	 * @throws Exception
	 */
	public Pessoa getInfoPessoa(String cpf) {
		return pessoas.get(cpf);
		// TODO: IMPORTANTE>>> Tratar a exce��o caso a pessoa nao exista no
		// banco de dados de pessoas.
	}

}
