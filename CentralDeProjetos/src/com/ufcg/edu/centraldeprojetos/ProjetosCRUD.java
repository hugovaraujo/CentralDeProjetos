package com.ufcg.edu.centraldeprojetos;

import model.Projeto;

public class ProjetosCRUD {

	/**
	 * Adiciona um novo projeto ao conjunto de projetos ja existentes.
	 * 
	 * @param novoProjeto
	 * @return true se for adicionado, false se nao for possivel adicionar.
	 */
	public boolean adicionarProjeto(Projeto novoProjeto) {
		return false;
		// TODO: adicionar um projeto ao BD
	}

	/**
	 * Remove um projeto do conjunto de projetos ja existentes.
	 * 
	 * @param projeto
	 * @return true se for removido com sucesso, falso se nao for possivel
	 *         remover.
	 */
	public boolean removeProjeto(Projeto projeto) {
		return false;
		// TODO: remover um projeto do BD
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
		// TODO: procurar saber o que � pra editar no projeto.
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
		return null;
		// TODO: recupera um projeto do BD
	}
}
