package model;

public class GraduandoParticipacao extends Participacao {
	
	public GraduandoParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;

		
	}

}
