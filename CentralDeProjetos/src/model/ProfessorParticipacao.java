package model;

public class ProfessorParticipacao extends Participacao{
	
	private boolean coordenador;
	
	public ProfessorParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras, boolean coordenador, int duracao) {
		
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

	
	// Falta implementar:  us4
	@Override
	public double calculaPontos() {
		return 0;
	}

	@Override
	public double calculaBolsa() {
		if (coordenador) {
			return super.calculaBolsa() * 0.4;
		}
		return super.calculaBolsa();
	}

}
