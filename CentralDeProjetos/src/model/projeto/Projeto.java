package model.projeto;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import exceptions.AtualizacaoException;
import exceptions.ConsultaException;

public abstract class Projeto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int codigo;
	protected String nome;
	protected String objetivo;
	protected String dataInicio;
	protected int duracao;
	protected Despesa despesas = new Despesa();
	protected int custoTotal;
	protected List<Participacao> participacoes;
	private int quantidadeParticipantes;
	
	public abstract void editaProjeto(String atributo, String valor) throws AtualizacaoException;

	public abstract String getInfoProjeto(String atributo) throws ConsultaException;
	
	public abstract String getTipo();
	
	public abstract double montanteUASC();
	
	public int getCodigo(){ 
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomeProjeto) {
		this.nome = nomeProjeto;
	}
	
	public String getObjetivo() {
		return objetivo;
	}
	
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public Despesa getDespesas() {
		return despesas;
	}
	
	public void setDespesas(Despesa despesas) {
		this.despesas = despesas;
	}
	
	public int getCustoTotal() {
		return custoTotal;
	}
	
	public void setCustoTotal(int custoTotal) {
		this.custoTotal = custoTotal;
	}
	
	public int getQuantidadeParticipantes() {
		return quantidadeParticipantes;
	}
	
	public void setQuantidadeParticipantes(int quantidadeParticipantes) {
		this.quantidadeParticipantes = quantidadeParticipantes;
	}
	
	public int geraCodigo(){
		int codigoGerado = 0;
		Random gerador = new Random();
	    for (int i = 0; i < 10; i++) {
			codigoGerado = gerador.nextInt(150000000);
	 	}
	    return codigoGerado;
	}

	public void addParticipacao(Participacao participacao) {
		
		this.participacoes.add(participacao);

		
	}
	
	public void removeParticipacao(Participacao participacao){
		this.participacoes.remove(participacao);
	}
	
	public boolean emAndamento() throws ParseException{
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse(dataInicio);
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, duracao);
		
		return (Calendar.getInstance().before(calendar));
		
	}
	
	public List<Pessoa> getParticipantes() {
		
		List<Pessoa> participantes = new ArrayList<Pessoa>();
		
		for (Participacao participacao : participacoes) {
			
			participantes.add(participacao.getPessoa());
			
		}
		
		return participantes;
	}
	
	public int getGraduandos(){
		
		int graduandos = 0;
		
		for (Participacao participacao : participacoes) {
			
			if(participacao.getTipo().equals("GraduandoParticipacao"))
				graduandos++;
			
		}
		
		return graduandos;
		
	}
	
	public int getPosGraduandos(){
		
		int posgraduandos = 0;
		
		for (Participacao participacao : participacoes) {
			
			if(participacao.getTipo().equals("PosGraduandoParticipacao"))
				posgraduandos++;
			
		}
		
		return posgraduandos;
		
	}

	public int getProfissionais(){
	
	int profissionais = 0;
	
	for (Participacao participacao : participacoes) {
		
		if(participacao.getTipo().equals("ProfissionalParticipacao"))
			profissionais++;
		
	}
	
	return profissionais;
	
	}
	
	public double custoTotal(){
		return despesas.getMontanteBolsas() + despesas.getMontanteCapital() + despesas.getMontanteCusteio();
	}
	

	@Override
	public String toString() {
		
		String situacao = null;
		try {
			if(emAndamento())
				situacao = "Em andamento.";
			else{
				situacao = "Finalizado.";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "Nome: "+ nome+"\n"+"Data de inicio: "+ dataInicio+"\n"+"Coordenador:"+"\n"+"Situacao: "+situacao+"\n";
	}
	
	
	
	
	
}