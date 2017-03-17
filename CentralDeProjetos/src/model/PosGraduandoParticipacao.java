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

	
	
	

}
