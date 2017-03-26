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
		
		double pontosMonitoria = 0;
		double pontosPeDPETExt = 0;
		
		for (Participacao participacao : pessoa.getParticipacoes()) {
			if (participacao.getTipo().equalsIgnoreCase("Monitoria")) {
				pontosMonitoria += 1.5 * (int) (participacao.getProjeto().getDuracao() / 6);
			}
			
			else {
				pontosPeDPETExt += 2 * (int) (participacao.getProjeto().getDuracao() / 6); 
			}
		}
		
		if (pontosMonitoria >= 6) {pontosMonitoria = 6;}
		if (pontosPeDPETExt >= 8) {pontosPeDPETExt = 8;}
		
		return 0;
		//return pontosMonitoria + pontosPeDPETExt; //Tá dando 24 nos dois casos (27 e 55)
			
		}
	

}
