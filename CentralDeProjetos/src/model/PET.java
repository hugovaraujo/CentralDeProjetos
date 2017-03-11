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
		case "Producao tecnica":
			setProdTecnica(valor);
			return true;
		case "Producao academica":
			setProdAcademica(valor);
			return true;
		case "Patentes":
			setPatentes(valor);
			return true;
		case "Duracao":
			setDuracao(valor);
			return true;
		case "Impacto":
			setImpacto(valor);
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
