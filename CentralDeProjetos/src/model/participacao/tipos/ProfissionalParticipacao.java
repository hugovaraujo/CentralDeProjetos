package model.participacao.tipos;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class ProfissionalParticipacao extends Participacao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		if (valorTotal < 350) {
			return 350;
		}
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
		double pontuacao;
		
		if (cargo.equalsIgnoreCase("Pesquisador")){
			pontuacao = 6 * (projeto.getDuracao() / 12);
		}
		else if (cargo.equalsIgnoreCase("Gerente")){
			pontuacao = 9 * (projeto.getDuracao() / 12);
		}
		else{
			pontuacao = 5 * (projeto.getDuracao() / 12);
		}
		return pontuacao;
	}
	

}
