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
	
	
	public String cadastraPessoa(String cpf, String nome, String email) throws Exception {
		
		if (pessoas.containsKey(cpf)) {
			throw new Exception("Pessoa ja consta no banco de dados de pessoas");
		}
		Pessoa pessoa = new Pessoa(cpf, nome, email);
		
		pessoas.put(pessoa.getCpf(), pessoa);
		
		return cpf;
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
			throw new Exception("Erro na consulta de pessoa: Pessoa nao encontrada");
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
	public void editarPessoa(String cpf, String atributo, String valor) throws Exception{
		if (!pessoas.containsKey(cpf)) {
			throw new Exception("Erro na consulta de pessoa: Pessoa nao encontrada");
		}
		if(atributo.equalsIgnoreCase("Cpf")){
			pessoas.get(cpf).setCpf(valor);
		}
		if(atributo.equalsIgnoreCase("Nome")){
			pessoas.get(cpf).setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Email")){
			pessoas.get(cpf).setEmail(valor);
		}

	}

	/**
	 * Procura uma pessoa no conjunto, usando o CPF como chave.
	 * 
	 * @param cpf
	 * @return retorna a pessoa a qual o CPF pertence ou null caso nao ache uma
	 *         pessoa.
	 * @throws Exception
	 */
	public String getInfoPessoa(String cpf, String atributo) throws Exception{
		if (!pessoas.containsKey(cpf)) {
			throw new Exception("Erro na consulta de pessoa: Pessoa nao encontrada");
		}if(atributo.equalsIgnoreCase("Cpf")){
			return pessoas.get(cpf).getCpf();
		}
		if(atributo.equalsIgnoreCase("Nome")){
			return pessoas.get(cpf).getNome();
		}
		if(atributo.equalsIgnoreCase("Email")){
			return pessoas.get(cpf).getEmail();
		}
		return null;
	}
	

}
