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
	
	@Override
	public boolean editaProjeto(String atributo, String valor) throws Exception {
		switch (atributo){
		case "Nome":
			setNome(valor);
			return true;
		case "Objetivo":
			setObjetivo(valor);
			return true;
		default:
			throw new Exception("Erro na atualizacao de projeto: Objetivo nao pode ser vazio ou nulo");
		}
	}
	
	@Override
	public boolean editaProjeto(String atributo, int valor) throws Exception {
		switch (atributo){
		case "Impacto":
			setImpacto(valor);
			return true;
		case "Duracao":
			setDuracao(valor);
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
		case "Objetivo":
			return getObjetivo();
		case "Impacto":
			return String.valueOf(getImpacto());
		case "Data de inicio":
			//TODO: Vê como faz essa parte.
		case "Duracao":
			return String.valueOf(getDuracao());
		default:
			throw new Exception("Erro na consulta de projeto: Atributo nulo ou invalido");
		}
	}
	
	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}




	
}
