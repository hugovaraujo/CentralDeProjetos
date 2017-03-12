package model;

public class ProfessorParticipacao extends Participacao{
	
	private boolean coordenador;
	
	public ProfessorParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras, boolean coordenador) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;
		this.duracao = duracao;
		this.coordenador = coordenador;
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}

}
