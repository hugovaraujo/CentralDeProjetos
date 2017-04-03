package model.participacao.tipos;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class GraduandoParticipacao extends Participacao {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraduandoParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras, int duracao) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;

		
	}
	
	@Override
	public String getTipo() {
		
		return "GraduandoParticipacao";
	}


	@Override
	public double calculaPontuacaoPorParticipacao() {	
		if(projeto.getTipo().equals("Monitoria")){
			return 1.5 * (projeto.getDuracao() / 6);
			
		}
		else{
			 return 2 * (projeto.getDuracao() / 6);
			
		}
	}
	
	@Override
	public double calculaBolsa() {
		if (super.calculaBolsa() < 350) {
			return 350;
		}
		return super.calculaBolsa();
	}
	
}

