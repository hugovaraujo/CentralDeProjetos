package model;

import java.util.Date;

public class Extensao extends Projeto {
	
	private int impacto;

	public Extensao(String nome, String objetivo, int impacto, Date dataInicio, int duracao) {
		
		this.nome = nome;
		this.objetivo = objetivo;
		this.impacto = impacto;
		this.setDataInicio(dataInicio);
		this.setDuracao(duracao);
		
	}

	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}
	
}
