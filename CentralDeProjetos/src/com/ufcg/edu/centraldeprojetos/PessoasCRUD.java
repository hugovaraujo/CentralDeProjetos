package com.ufcg.edu.centraldeprojetos;

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
	public boolean adicionarPessoa(Pessoa pessoa) throws Exception {
		if (pessoas.containsKey(pessoa.getCpf())) {
			throw new Exception("Pessoa ja consta no banco de dados de pessoas");
		}
		pessoas.put(pessoa.getCpf(), pessoa);
		return true;

	}

	/**
	 * Remove uma pessoa do conjunto de pessoas ja existentes.
	 * 
	 * @param pessoa
	 * @return true se for removido com sucesso, falso se nao for possivel
	 *         remover.
	 * @throws Exception
	 */
	public boolean removerPessoa(Pessoa pessoa) throws Exception {
		if (!pessoas.containsKey(pessoa.getCpf())) {
			throw new Exception("Pessoa nao existe no banco de dados de pessoas");
		}
		pessoas.remove(pessoa.getCpf());
		return true;
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
	public Pessoa getPessoa(String cpf) {
		return pessoas.get(cpf);
		// TODO: IMPORTANTE>>> Tratar a exceção caso a pessoa nao exista no
		// banco de dados de pessoas.
	}

}
