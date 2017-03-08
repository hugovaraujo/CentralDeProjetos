package model;

import java.util.Date;

public abstract class Projeto {
	
	protected int codigo;
	protected String nome;
	protected String objetivo;
	protected Date dataInicio;
	protected int duracao;
	protected Despesa despesas;
	protected int custoTotal;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomeProjeto) {
		this.nome = nomeProjeto;
	}
	
	public String getObjetivo() {
		return objetivo;
	}
	
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public Despesa getDespesas() {
		return despesas;
	}
	
	public void setDespesas(Despesa despesas) {
		this.despesas = despesas;
	}
	
	public int getCustoTotal() {
		return custoTotal;
	}
	
	public void setCustoTotal(int custoTotal) {
		this.custoTotal = custoTotal;
	}
	
	
	
	
	
	
}
