package model.participacao.tipos;

import java.util.Iterator;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class ProfissionalParticipacao extends Participacao {
	
	private String cargo;
	private int qtdDeParticipantes;
	
	public ProfissionalParticipacao(Pessoa pessoa, Projeto projeto, String cargo, double valorHora, int qtdHoras, int duracao) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;
		this.duracao = duracao;
		this.qtdDeParticipantes = 0;
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	@Override
	public double calculaBolsa() {
		double adicional = 0;
		if (getCargo().equalsIgnoreCase("Pesquisador")) {
			adicional += 100;
		}
		else if (getCargo().equalsIgnoreCase("Gerente") && projeto.getQuantidadeParticipantes() < 5 ) {
			adicional = 20 * projeto.getQuantidadeParticipantes();
		}
		else if (getCargo().equalsIgnoreCase("Gerente") && projeto.getQuantidadeParticipantes() > 5 ) {
			adicional = 100;
		}
		double valorTotal = super.calculaBolsa() + adicional;
		return valorTotal;
		
	}

	public int getQtdDeParticipantes() {
		return qtdDeParticipantes;
	}

	public void setQtdDeParticipantes(int qtdDeParticipantes) {
		this.qtdDeParticipantes = qtdDeParticipantes;
	}

	@Override
	public String getTipo() {

		return "ProfissionalParticipacao";
	}

	@Override
	public double calculaPontuacaoPorParticipacao() {
		
		double pontuacaoGerente = 0;
		double pontuacaoDesenvolvedor = 0;
		double pontuacaoPesquisador = 0;
		
		for (Participacao participacao : pessoa.getParticipacoes()) {
			if (getCargo().equalsIgnoreCase("Pesquisador")){
				pontuacaoPesquisador += 6 * (int)(projeto.getDuracao() / 12);		
			}
			else if (getCargo().equalsIgnoreCase("Gerente")){
				pontuacaoGerente = 9 * (int)(projeto.getDuracao() / 12);
			}
			else {
				pontuacaoDesenvolvedor = 5 * (int)(projeto.getDuracao() / 12);
			}
		}
		return 0;
		//return pontuacaoDesenvolvedor + pontuacaoGerente + pontuacaoPesquisador; // Metodo funciona corretamente. Não sei como............
	}
	

}
