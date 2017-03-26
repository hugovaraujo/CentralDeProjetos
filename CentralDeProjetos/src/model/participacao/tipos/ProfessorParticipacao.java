package model.participacao.tipos;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

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
		double pontuacao = 0;
		
		for (Participacao participacao : pessoa.getParticipacoes()) {
			pontuacao += 4 * (int) (participacao.getProjeto().getDuracao() / 12);
			
			if (!participacao.getProjeto().getTipo().equalsIgnoreCase("Monitoria")) {
				pontuacao += participacao.getProjeto().getQuantidadeAlunos();
				}
			}
			
		return pontuacao;
	}

}
