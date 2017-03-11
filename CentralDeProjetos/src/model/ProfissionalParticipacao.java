package model;

public class ProfissionalParticipacao extends Participacao {
	
	private String cargo;
	
	public ProfissionalParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras, int duracao, String cargo) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;
		this.duracao = duracao;
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
