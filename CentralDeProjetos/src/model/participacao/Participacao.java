package model.participacao;

import java.io.Serializable;

import model.pessoa.Pessoa;
import model.projeto.Projeto;

public abstract class Participacao implements Pontuacao, ValorBolsa, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Pessoa pessoa;
	protected Projeto projeto;
	protected double valorHora;
	protected int qtdHoras;
	protected int duracao;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	@Override
	public double calculaBolsa(){
		double valorBolsa = 0;
		valorBolsa +=qtdHoras * valorHora;
		return valorBolsa;
	}
	
	public abstract String getTipo();
	

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public int getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(int qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	

}
