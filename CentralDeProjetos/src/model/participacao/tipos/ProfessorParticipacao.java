package model.participacao.tipos;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class ProfessorParticipacao extends Participacao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean coordenador;
	private final double DEFAULT_POINT = 4;
	
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


	@Override
	public double calculaBolsa() {
		if (coordenador) {
			valorHora += valorHora*0.4;
		}
		if (projeto.getTipo().equalsIgnoreCase("Monitoria")) {
			return 0;
		}
		if (super.calculaBolsa() < 350) {
			return 350;
		}
		return super.calculaBolsa();
	}

	@Override
	public String getTipo() {
		
		return "ProfessorParticipacao";
	}

	@Override
	public double calculaPontuacaoPorParticipacao() {
		double pontuacao;
		pontuacao = DEFAULT_POINT * (projeto.getDuracao() / 12);
		if (!projeto.getTipo().equals("Monitoria")){
			pontuacao +=  projeto.getGraduandos() + projeto.getPosGraduandos();
		}
		
		return pontuacao;
	}

}
