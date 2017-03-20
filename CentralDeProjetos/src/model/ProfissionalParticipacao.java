package model;

public class ProfissionalParticipacao extends Participacao {
	
	private String cargo;
	private int qtdDeParticipantes;
	
	public ProfissionalParticipacao(Pessoa pessoa, Projeto projeto, double valorHora, int qtdHoras, int duracao) {
		
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.valorHora = valorHora;
		this.qtdHoras = qtdHoras;
		this.duracao = duracao;
		this.qtdDeParticipantes = 0;
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
		if (getCargo().equalsIgnoreCase("Pesquisador") && projeto.getQuantidadeParticipantes() < 5 ) {
			adicional += 100 * projeto.getQuantidadeParticipantes() ;
		}
		if (getCargo().equalsIgnoreCase("Pesquisador") && projeto.getQuantidadeParticipantes() > 5 ) {
			adicional = 500;
		}
		if (getCargo().equalsIgnoreCase("Gerente") && projeto.getQuantidadeParticipantes() < 5 ) {
			adicional = 20 * projeto.getQuantidadeParticipantes();
		}
		if (getCargo().equalsIgnoreCase("Gerente") && projeto.getQuantidadeParticipantes() > 5 ) {
			adicional = 100;
		}
		
		return super.calculaBolsa() + adicional;
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
			pontuacao = 6 * (duracao % 12);
		}
		else if (cargo.equalsIgnoreCase("Gerente")){
			pontuacao = 9 * (duracao % 12);
		}
		else{
			pontuacao = 5 * (duracao % 12);
		}
		return pontuacao;
	}
	
	
	
	

}
