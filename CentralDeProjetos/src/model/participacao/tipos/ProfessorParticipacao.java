package model.participacao.tipos;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class ProfessorParticipacao extends Participacao{
	
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
		if (!projeto.getTipo().equals("PET")){
			pontuacao += projeto.getQuantidadeParticipantes();
		}
		return pontuacao;
	}

}
