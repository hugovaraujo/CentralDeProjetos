package model;

import java.util.Date;

public class Extensao extends Projeto {
	
	private int impacto;

	public Extensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		
		this.nome = nome;
		this.objetivo = objetivo;
		this.impacto = impacto;
		this.setDataInicio(dataInicio);
		this.setDuracao(duracao);
		
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
		case "Impacto":
			novoValor = Integer.parseInt(valor);
			setImpacto(novoValor);
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
		case "Objetivo":
			return getObjetivo();
		case "Impacto":
			return String.valueOf(getImpacto());
		case "Data de inicio":
			return getDataInicio();
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
