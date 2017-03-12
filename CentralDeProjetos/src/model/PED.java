package model;

import java.util.Date;

public class PED extends Projeto {
	
	private String categoria;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	
	public PED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		
		this.nome = nome;
		this.categoria = categoria;
		this.prodTecnica = prodTecnica;
		this.prodAcademica = prodAcademica;
		this.patentes = patentes;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		
	}

	@Override
	public boolean editaProjeto(String atributo, String valor) throws Exception {
		int novoValor = 0;
		switch (atributo){
		case "Nome":
			setNome(valor);
			return true;
		case "Objetivo":
			setObjetivo(valor);
			return true;
		case "Categoria":
			setCategoria(valor);
			return true;
		case "Producao tecnica":
			novoValor = Integer.parseInt(valor);
			setProdTecnica(novoValor);
			return true;
		case "Producao academica":
			novoValor = Integer.parseInt(valor);
			setProdAcademica(novoValor);
			return true;
		case "Patentes":
			novoValor = Integer.parseInt(valor);
			setPatentes(novoValor);
			return true;
		case "Duracao":
			novoValor = Integer.parseInt(valor);
			setDuracao(novoValor);
			return true;
		default:
			throw new Exception("Erro na atualizacao de projeto: Objetivo nao pode ser vazio ou nulo");
		}
	}
	
	
	@Override
	public String getInfoProjeto(String atributo) throws Exception {
		switch (atributo){
		case "Nome":
			return getNome();
		case "Categoria":
			return getCategoria();
		case "Producao tecnica":
			return String.valueOf(getProdTecnica());
		case "Producao academica":
			return String.valueOf(getProdAcademica());
		case "Patentes":
			return String.valueOf(getPatentes());
		case "Objetivo":
			return getObjetivo();
		case "Data de inicio":
			return getDataInicio();
		case "Duracao":
			return String.valueOf(getDuracao());
		default:
			throw new Exception("Erro na consulta de projeto: Atributo nulo ou invalido");
		}
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getProdTecnica() {
		return prodTecnica;
	}
	
	public void setProdTecnica(int prodTecnica) {
		this.prodTecnica = prodTecnica;
	}
	
	public int getProdAcademica() {
		return prodAcademica;
	}
	
	public void setProdAcademica(int prodAcademica) {
		this.prodAcademica = prodAcademica;
	}
	
	public int getPatentes() {
		return patentes;
	}
	
	public void setPatentes(int patentes) {
		this.patentes = patentes;
	}




	
	

}
