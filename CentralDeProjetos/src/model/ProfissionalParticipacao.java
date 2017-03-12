package model;

public class ProfissionalParticipacao extends Participacao {
	
	private String cargo;
	
	public ProfissionalParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
