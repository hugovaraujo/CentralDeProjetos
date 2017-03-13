package controller;

import java.util.HashMap;

import exceptions.AtualizacaoException;
import exceptions.CadastroException;
import exceptions.ConsultaException;
import exceptions.RemoverException;
import exceptions.Verificador;
import model.Pessoa;

/**
 * Classe que representa o controller de Pessoas
 * 
 * @author
 *
 */
public class PessoasCRUD {

	public HashMap<String, Pessoa> pessoas;
	public Verificador verificador = new Verificador();
	
	/**
	 * Construtor de PessoasCRUD
	 */
	public PessoasCRUD() {
		pessoas = new HashMap<>();
		verificador = new Verificador();
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
			throw new CadastroException("de pessoa: Pessoa com mesmo CPF ja cadastrada");
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
	public void removePessoa(String cpf) throws Exception {
		if (!pessoas.containsKey(cpf)) {
			throw new RemoverException("pessoa: Pessoa nao encontrada");
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
	public void editaPessoa(String cpf, String atributo, String valor) throws Exception{
		try {
			verificador.verificaString(cpf, "CPF");
		} catch (Exception e) {
			throw new AtualizacaoException("de pessoa: " + e.getMessage());
		}
		try {
			verificador.verificaCpf(cpf);
		} catch (Exception e) {
			throw new AtualizacaoException("de pessoa: " + e.getMessage());
		}
		if (!pessoas.containsKey(cpf)) {
			throw new AtualizacaoException("de pessoa: Pessoa nao encontrada");
		}
		if(atributo.equalsIgnoreCase("Cpf")){
			throw new AtualizacaoException("de pessoa: CPF nao pode ser alterado");
		}
		if(atributo.equalsIgnoreCase("Nome")){
			pessoas.get(cpf).setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Email")){
			pessoas.get(cpf).setEmail(valor);
		}

	}
	
	public Pessoa getPessoa(String cpf){
		
		return pessoas.get(cpf);
		
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
			throw new ConsultaException("de pessoa: Pessoa nao encontrada");
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
