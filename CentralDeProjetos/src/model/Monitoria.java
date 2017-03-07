package model;

import java.util.Date;

public class Monitoria extends Projeto {
	
	private int rendimento;
	private String disciplina;
	private String periodo;
	
	public Monitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date dataInicio,int duracao) {
		
		setNome(nome);
		this.disciplina = disciplina;
		this.periodo = periodo;
		this.rendimento = rendimento;
		setObjetivo(objetivo);
		setDataInicio(dataInicio);
		setDuracao(duracao);
		
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
