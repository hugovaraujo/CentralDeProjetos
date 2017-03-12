package model;

import java.util.Date;

public class PET extends Projeto {
	
	private int impacto;
	private int rendimento;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	
	public PET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		
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
		case "Impacto":
			novoValor = Integer.parseInt(valor);
			setImpacto(novoValor);
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
		case "Redimento":
			return String.valueOf(getRendimento());
		case "Producao tecnica":
			return String.valueOf(getProdTecnica());
		case "Producao academica":
			return String.valueOf(getProdAcademica());
		case "Patentes":
			return String.valueOf(getPatentes());
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
