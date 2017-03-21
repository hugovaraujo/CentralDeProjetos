package model;

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
		double adicional = 0;
		if (coordenador) {
			adicional += super.calculaBolsa() * 0.4;
		}
		double valorTotal = super.calculaBolsa() + adicional;
		
		if (valorTotal > 350) {
			return valorTotal;
		}
		
		return 350;
	}

	@Override
	public String getTipo() {
		
		return "ProfessorParticipacao";
	}

	@Override
	public double calculaPontuacaoPorParticipacao() {
		double pontuacao;
		pontuacao = DEFAULT_POINT * (duracao % 12);
		if (!projeto.getTipo().equals("PET")){
			pontuacao += projeto.quantidadeParticipantes;
		}
		return pontuacao;
	}

}
