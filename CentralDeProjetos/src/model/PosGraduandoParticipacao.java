package model;

public class PosGraduandoParticipacao extends Participacao {
	
	private String tipoVinculo;
	
	
	public PosGraduandoParticipacao(Pessoa pessoa, Projeto projeto, String tipoVinculo, double valorHora, int qtdHoras, int duracao) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;
		this.tipoVinculo = tipoVinculo;

		
	}
	
	public String getTipoVinculo() {
		return tipoVinculo;
	}
	
	public void setTipoVinculo(String tipoVinculo) {
		this.tipoVinculo = tipoVinculo;
	}

	@Override
	public String getTipo() {
		
		return "PosGraduandoParticipacao";
	}

	@Override
	public double calculaPontuacaoPorParticipacao() {
		double pontuacao;
		pontuacao = 0;
		return pontuacao;
	}
	
	@Override
	public double calculaBolsa() {
		double adicional = 0;
		if (tipoVinculo.equalsIgnoreCase("Doutorado")) {
			adicional += super.calculaBolsa()/3;
		}
		double valorTotal = super.calculaBolsa() + adicional;
		
		if (valorTotal > 350) {
			return valorTotal;
		}
		
		return 350;
	}

	
	
	

}
