package com.ufcg.edu.centraldeprojetos;

import java.util.HashMap;

import model.Projeto;

public class ProjetosCRUD {

	public HashMap<String, Projeto> projetos;

	public ProjetosCRUD() {
		projetos = new HashMap<>();
	}

	/**
	 * Adiciona um novo projeto ao conjunto de projetos ja existentes.
	 * 
	 * @param novoProjeto
	 * @return true se for adicionado, false se nao for possivel adicionar.
	 * @throws Exception
	 */
	public boolean adicionarProjeto(Projeto novoProjeto) throws Exception {
		if (projetos.containsKey(novoProjeto)) {
			throw new Exception("Codigo de projeto ja existente");
		}
		projetos.put(novoProjeto.getCodigo(), novoProjeto);
		return true;
	}

	/**
	 * Remove um projeto do conjunto de projetos ja existentes.
	 * 
	 * @param projeto
	 * @return true se for removido com sucesso, falso se nao for possivel
	 *         remover.
	 */
	public boolean removeProjeto(Projeto projeto) {
		if (!projetos.containsKey(projeto.getCodigo())) {
			throw new Exception("Projeto nao existente");
		}
		projetos.remove(projeto.getCodigo());
		return true;
	}

	/**
	 * Edita um projeto enviado como parametro.
	 * 
	 * @param projeto
	 * @return retorna true se editar com sucesso, falso se nao for possivel
	 *         editar.
	 */
	public boolean editarProjeto(Projeto projeto) {
		return false;
		// TODO: procurar saber o que e pra editar no projeto.
	}

	/**
	 * Procura um projeto no conjunto, usando o codigo de identificao unica do
	 * projeto.
	 * 
	 * @param codigoProjeto
	 * @return returna o projeto pertencente ao codigo ou null caso nao ache um
	 *         projeto.
	 */
	public Projeto getProjeto(String codigoProjeto) {
		return projetos.get(codigoProjeto);
		// TODO: IMPORTANTE>>> Tratar a excecao caso a pessoa nao exista no
		// banco de dados de pessoas.
	}
}
