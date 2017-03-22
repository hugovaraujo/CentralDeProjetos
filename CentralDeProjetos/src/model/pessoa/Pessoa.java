package model.pessoa;

import exceptions.AtualizacaoException;
import exceptions.CadastroException;
import exceptions.FormatoInvalidoException;
import exceptions.StringInvalidaException;
import exceptions.Validator;

public class Pessoa {

	private String nome;
	private String cpf;
	private String email;
	private Validator verificador = new Validator();

	public Pessoa(String cpf, String nome, String email) throws CadastroException {
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaString(cpf, "CPF");
			verificador.verificaString(email, "Email");
		} catch (StringInvalidaException e) {
			throw new CadastroException("de pessoa: " + e.getMessage());
		}
		try {
			verificador.verificaCpf(cpf);
			verificador.verificaEmail(email);
		} catch (FormatoInvalidoException e) {
			throw new CadastroException("de pessoa: " + e.getMessage());
		}
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCpf(String cpf) throws AtualizacaoException {
		this.cpf = cpf;
	}
	
	public void setEmail(String email) throws AtualizacaoException {
		try {
			verificador.verificaString(email, "Email");
		} catch (Exception e) {
			throw new AtualizacaoException("de pessoa: " + e.getMessage());
		}
		try {
			verificador.verificaEmail(email);
		} catch (Exception e) {
			throw new AtualizacaoException("de pessoa: " + e.getMessage());
		}
		this.email = email;
	}
	
	public void setNome(String nome) throws AtualizacaoException {
		try {
			verificador.verificaString(nome, "Nome");
		} catch (Exception e) {
			throw new AtualizacaoException("de pessoa: " + e.getMessage());
		}
		this.nome = nome;
	}

	
	@Override
	public String toString() {
		return "Nome: " + nome + "; CPF: " + cpf + "; EMAIL: " + email + ";";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	

}