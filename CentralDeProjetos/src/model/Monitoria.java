package model;

import java.util.Date;

public class Monitoria extends Projeto {
	
	private int rendimento;
	private String disciplina;
	private String periodo;
	
	public Monitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date dataInicio,int duracao) {
		
		this.nome = nome;
		this.disciplina = disciplina;
		this.periodo = periodo;
		this.rendimento = rendimento;
		this.objetivo = objetivo;
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
		case "Disciplina":
			setDisciplina(valor);
			return true;
		case "Periodo":
			setPeriodo(valor);
			return true;
		default:
			throw new Exception("Erro na atualizacao de projeto: Objetivo nao pode ser vazio ou nulo");
		}
	}
	
	@Override
	public boolean editaProjeto(String atributo, int valor) throws Exception {
		switch (atributo){
		case "Rendimento":
			setRendimento(valor);
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
		case "Disciplina":
			return getDisciplina();
		case "Redimento":
			return String.valueOf(getRendimento());
		case "Objetivo":
			return getObjetivo();
		case "Periodo":
			return getPeriodo();
		case "Data de inicio":
			//TODO: Vê como faz essa parte.
		case "Duracao":
			return String.valueOf(getDuracao());
		default:
			throw new Exception("Erro na consulta de projeto: Atributo nulo ou invalido");
		}
	}
	
	public int getRendimento() {
		return rendimento;
	}
	
	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}



	

}
