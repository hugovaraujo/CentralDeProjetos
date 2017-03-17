package model;

public class GraduandoParticipacao extends Participacao {
	
	public GraduandoParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras, int duracao) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;

		
	}
	
	
	// Falta implementar:  us4
	@Override
	public double calculaPontos() {
		return 0;
	}


	@Override
	public String getTipo() {
		
		return "GraduandoParticipacao";
	}

}
