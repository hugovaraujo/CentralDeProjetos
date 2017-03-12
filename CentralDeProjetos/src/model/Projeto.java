package model;


import java.util.Random;

public abstract class Projeto {
	
	protected int codigo;
	protected String nome;
	protected String objetivo;
	protected String dataInicio;
	protected int duracao;
	protected Despesa despesas;
	protected int custoTotal;
	
	
	public abstract boolean editaProjeto(String atributo, String valor) throws Exception;

	public abstract String getInfoProjeto(String atributo) throws Exception;
	
	
	public int getCodigo(){ 
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
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(String dataInicio) {
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
	
	public int geraCodigo(){
		int codigoGerado = 0;
		Random gerador = new Random();
	    for (int i = 0; i < 10; i++) {
			codigoGerado = gerador.nextInt(150000000);
	 	}
	    return codigoGerado;
	}
	
}