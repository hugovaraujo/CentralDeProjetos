package model.pessoa;

import java.util.ArrayList;
import java.util.List;

import model.participacao.Participacao;
import model.projeto.Projeto;

public class Pessoa {

	private String nome;
	private String cpf;
	private String email;
	private List<Participacao> participacoes;

	

	public Pessoa(String cpf, String nome, String email){
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.participacoes = new ArrayList<Participacao>();
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
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
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
	
	

	public List<Projeto> getParticipacoesemProjeto() {
		
		List<Projeto> projetos = new ArrayList<Projeto>();
		
		for (Participacao participacao : participacoes) {
			
			projetos.add(participacao.getProjeto());
			
		}
		
		return projetos;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	public void addParticipacao(Participacao participacao) {
		
		this.participacoes.add(participacao);
		
	}

	

}