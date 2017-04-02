package controller;

import java.io.Serializable;
import java.util.HashMap;

import exceptions.AtualizacaoException;
import exceptions.CadastroException;
import exceptions.ConsultaException;
import exceptions.PessoasControllerValidator;
import exceptions.RemocaoException;
import model.pessoa.Pessoa;

/**
 * Classe que representa o controller de Pessoas
 * 
 * @author
 *
 */
public class PessoasController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HashMap<String, Pessoa> pessoas;
	public PessoasControllerValidator validator;
	
	/**
	 * Construtor de PessoasCRUD
	 */
	public PessoasController() {
		pessoas = new HashMap<>();
		this.validator = new PessoasControllerValidator();
	}

	/**
	 * 
	 * Adiciona uma nova pessoa ao conjunto de pessoas ja existentes.
	 * 
	 * @param Pessoa
	 * @return true se for adicionado, false se nao for possivel adicionar.
	 * @throws CadastroException
	 */
	
	public String cadastraPessoa(String cpf, String nome, String email) throws CadastroException {
		
		validator.validaCadastraPessoa(cpf, nome, email, pessoas.containsKey(cpf));
		Pessoa pessoa = new Pessoa(cpf, nome, email);
		
		pessoas.put(pessoa.getCpf(), pessoa);
		
		return cpf;
	}

	/**
	 * Remove uma pessoa do conjunto de pessoas ja existentes.
	 * 
	 * @param pessoa

	 * @throws RemocaoException
	 */
	public void removePessoa(String cpf) throws RemocaoException {
		if (!pessoas.containsKey(cpf)) {
			throw new RemocaoException("de pessoa: Pessoa nao encontrada");
		}
		pessoas.remove(cpf);
	}

	/**
	 * Edita uma pessoa enviada como parametro.
	 * 
	 * @param cpf
	 * @param atributo
	 * @param valor
	 * @throws AtualizacaoException
	 */
	public void editaPessoa(String cpf, String atributo, String valor) throws AtualizacaoException{
		validator.validaEditaPessoa(cpf, atributo, valor, !pessoas.containsKey(cpf));
		
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
	 * @param atributo
	 * @return retorna a pessoa a qual o CPF pertence ou null caso nao ache uma
	 *         pessoa.
	 * @throws ConsultaException
	 */
	public String getInfoPessoa(String cpf, String atributo) throws ConsultaException{
		validator.validaGetInfoPesso(!pessoas.containsKey(cpf));
		if(atributo.equalsIgnoreCase("Cpf")){
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
