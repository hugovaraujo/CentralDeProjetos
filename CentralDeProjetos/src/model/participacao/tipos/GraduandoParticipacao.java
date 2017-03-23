package model.participacao.tipos;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class GraduandoParticipacao extends Participacao {
	
	
	
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
		double pontuacao;
		
		if(projeto.getTipo().equals("Monitoria")){
			pontuacao = 1.5 * (projeto.getDuracao() / 6);
			
			if(pontuacao >= 6) return 6;
			else return pontuacao;
		}
		else{
			pontuacao = 2 * (projeto.getDuracao() / 6);
			if(pontuacao >= 8) return 8;
			else return pontuacao;
		}
	}
	

}
