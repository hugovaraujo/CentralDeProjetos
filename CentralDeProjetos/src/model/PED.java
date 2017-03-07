package model;

import java.util.Date;

public class PED extends Projeto {
	
	private String categoria;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	
	public PED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date dataInicio, int duracao) {
		
		setNome(nome);
		this.categoria = categoria;
		this.prodTecnica = prodTecnica;
		this.prodAcademica = prodAcademica;
		this.patentes = patentes;
		setObjetivo(objetivo);
		setDataInicio(dataInicio);
		setDuracao(duracao);
		
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
