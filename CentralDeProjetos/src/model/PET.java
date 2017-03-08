package model;

import java.util.Date;

public class PET extends Projeto {
	
	private int impacto;
	private int rendimento;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	
	public PET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date dataInicio, int duracao) {
		
		this.nome = nome;
		this.objetivo = objetivo;
		this.impacto = impacto;
		this.rendimento = rendimento;
		this.prodTecnica = prodTecnica;
		this.prodAcademica = prodAcademica;
		this.patentes = patentes;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		
	}

	public int getImpacto() {
		return impacto;
	}
	
	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}
	
	public int getRendimento() {
		return rendimento;
	}
	
	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
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
