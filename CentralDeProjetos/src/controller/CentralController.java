package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.AssociacaoException;
import exceptions.AtualizacaoException;
import exceptions.CentralControllerValidator;
import exceptions.ConsultaException;
import exceptions.PersistenciaException;
import exceptions.RemocaoException;
import model.participacao.Participacao;
import model.participacao.tipos.GraduandoParticipacao;
import model.participacao.tipos.PosGraduandoParticipacao;
import model.participacao.tipos.ProfessorParticipacao;
import model.participacao.tipos.ProfissionalParticipacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

/**
 * Classe que representa o controller de Participacao
 * 
 * @author
 *
 */

public class CentralController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<Participacao> participacoes;
	private Participacao controleQuantidade;
	PessoasController pessoasController;
	ProjetosController projetosController;
	private CentralControllerValidator validator;
	private double valorTotalUASC;
	private double valorEmCaixa;
	private double valorGasto;
	
	/**
	 * Construtor de MainController 
	 */
	public CentralController(){
		
		participacoes = new ArrayList<>();
		pessoasController = new PessoasController();
		projetosController = new ProjetosController();
		validator = new CentralControllerValidator();
		this.valorTotalUASC = 0;
		this.valorEmCaixa = 0;
		this.valorGasto = 0;
				
	}
	
	/**
	 * Metodo que associa um Professor a uma participacao.
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param coordenador
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 * @throws AssociacaoException 
	 */
	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras, int duracao) throws AssociacaoException{
		
		Pessoa pessoa = pessoasController.getPessoa(cpfPessoa); //TODO: CRIAR METODO getPessoa no CRUD de pessoas para substituir este metodo.
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaProfessor(pessoa, projeto, qntHoras, valorHora, participacoes, coordenador);
		
		ProfessorParticipacao participacao = new ProfessorParticipacao(pessoa, projeto, valorHora, qntHoras, coordenador,duracao);
		
		
		
		participacoes.add(participacao);
		pessoa.addParticipacao(participacao);
		projeto.addParticipacao(participacao);
		
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);
		
	}
	
	
	/**
	 * Metodo que associa um Profissional a uma participacao
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param cargo
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 * @throws AssociacaoException 
	 */
	
	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras, int duracao) throws AssociacaoException{
		Pessoa pessoa = pessoasController.getPessoa(cpfPessoa); 
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaProfissional(pessoa, projeto);
	
		ProfissionalParticipacao participacao = new ProfissionalParticipacao(pessoa, projeto, cargo, valorHora, qntHoras,duracao);
		
		participacoes.add(participacao);
		pessoa.addParticipacao(participacao);
		projeto.addParticipacao(participacao);
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);
		
	}

	/**
	 * Metodo que associa um graduando a uma participacao.
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 * @throws AssociacaoException 
	 */
	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras, int duracao) throws AssociacaoException{
		
		Pessoa pessoa = pessoasController.getPessoa(cpfPessoa); 
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaGraduando(pessoa, projeto, participacoes);

		GraduandoParticipacao participacao = new GraduandoParticipacao(pessoa, projeto, valorHora, qntHoras, duracao);
		
		participacoes.add(participacao);
		pessoa.addParticipacao(participacao);
		projeto.addParticipacao(participacao);
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);
		
	}
	
	
	/**
	 * Metodo que associa um  pos-graduando a uma participacao.
	 * 
	 * @param pessoa
	 * @param projeto
	 * @param valorHora
	 * @param qntHoras
	 * @param duracao
	 * @throws AssociacaoException 
	 */
	public void associaPosGraduando(String cpfPessoa, int codigoProjeto, String nivel, double valorHora, int qntHoras, int duracao) throws AssociacaoException{
		
		Pessoa pessoa = pessoasController.getPessoa(cpfPessoa); 
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaAssociaPosGraduando(pessoa, projeto);
	
		PosGraduandoParticipacao participacao = new PosGraduandoParticipacao(pessoa, projeto, nivel, valorHora, qntHoras,duracao);
		
		participacoes.add(participacao);
		pessoa.addParticipacao(participacao);
		projeto.addParticipacao(participacao);
		projeto.setQuantidadeParticipantes(projeto.getQuantidadeParticipantes() + 1);	
		
	}
	
	
	
	public boolean removeParticipacao(String cpfPessoa, int codigoProjeto) throws RemocaoException{
		
		Pessoa pessoa = pessoasController.getPessoa(cpfPessoa); 
		Projeto projeto = projetosController.getProjeto(codigoProjeto);
		
		validator.validaRemoveParticipacao(pessoa, projeto, participacoes);
		
		for (Participacao participacao : participacoes) {
			String cpfPessoa1 = participacao.getPessoa().getCpf();
			int codProjeto = participacao.getProjeto().getCodigo();
			
			if(cpfPessoa1.equals(pessoa.getCpf())&&(codProjeto == projeto.getCodigo())) {
				participacoes.remove(participacao);
				projeto.removeParticipacao(participacao);
				pessoa.removeParticipacao(participacao);
				return true;
			}
		
		}
		return false;
	}
	
	public String getInfoPessoa(String cpf, String atributo) throws ConsultaException{
		
		if(atributo.equals("Participacoes")){
			
			Pessoa pessoa = pessoasController.pessoas.get(cpf);
			
			if (pessoa == null) {
				throw new ConsultaException("de projeto: Pessoa nao existe");
			}
			
			return this.getPessoaParticipacao(pessoa);
			
		}else{
			 return pessoasController.getInfoPessoa(cpf, atributo);
		}
	}
	
	public String getInfoProjeto(int codigo, String atributo) throws ConsultaException{
		
		if(atributo.equals("Participacoes")){
			
			Projeto projeto = projetosController.projetos.get(codigo);
			
			if (projeto == null) {
				throw new ConsultaException("de projeto: Projeto nao encontrado");
			}
			
			return this.getProjetoParticipantes(projeto);
			
		}else{
			 return projetosController.getInfoProjeto(codigo, atributo);
		}
	}

	public String getPessoaParticipacao(Pessoa pessoa) {
		
		String projetos = "";
		
		for (Participacao participacao : participacoes) {
		
			if(pessoa.getCpf().equals(participacao.getPessoa().getCpf())){
				if(projetos.equals(""))
					projetos += participacao.getProjeto().getNome();
				else{
					projetos += ", "+ participacao.getProjeto().getNome();
				}
			}
			
		}
		
		return projetos;
	}

	public String getProjetoParticipantes(Projeto projeto) {
		
		ArrayList<String> listaParticipantes = new ArrayList<String>();
		String participantes = "";
		
		for (Participacao participacao : participacoes) {
			
		
			if(projeto.getCodigo() == participacao.getProjeto().getCodigo()){
				listaParticipantes.add(participacao.getPessoa().getNome());
			}
		}
		Collections.sort(listaParticipantes);
		for (int i = 0; i < listaParticipantes.size(); i++) {
			
			if(i==0)
				participantes += listaParticipantes.get(i);
			else{
				participantes += ", " + listaParticipantes.get(i); 
			}
			
		}
		
		return participantes;
	}
	
	public void gerarHistoricoColaboracoes() throws PersistenciaException{
		
		projetosController.gerarHistoricoColaboracoes(valorEmCaixa,valorGasto);
		
	}

	public Participacao getControleQuantidade() {
		return controleQuantidade;
	}

	public void setControleQuantidade(Participacao controleQuantidade) {
		this.controleQuantidade = controleQuantidade;
	}

	public PessoasController getPessoasController() {
		return pessoasController;
	}

	public ProjetosController getProjetosController() {
		return projetosController;
	}
	
	public double calculaPontuacaoPorParticipacao(String cpf) {
		double pontuacaoPorParticipacao = 0;
		double pontosMonitoria = 0;
		double pontosOutros = 0;
		Pessoa pessoa = pessoasController.getPessoa(cpf);
		for (Participacao participacao : pessoa.getParticipacoes()) {
			if (participacao.getTipo().equals("GraduandoParticipacao")){
				if (participacao.getProjeto().getTipo().equals("Monitoria")){
					pontosMonitoria += participacao.calculaPontuacaoPorParticipacao();
				} else {
					pontosOutros += participacao.calculaPontuacaoPorParticipacao();
				}
			} else {
				pontuacaoPorParticipacao += participacao.calculaPontuacaoPorParticipacao();
			}
			
		}
		
		if (pontosMonitoria > 6){
			pontosMonitoria = 6;
		}
		if (pontosOutros > 8){
			pontosOutros = 8;
		}
		return pontuacaoPorParticipacao + pontosMonitoria + pontosOutros;
	}
	
	public double getValorBolsa(String cpf){
		Pessoa pessoa = pessoasController.getPessoa(cpf);
		double valorBolsa = 0;
		for (Participacao participacao : pessoa.getParticipacoes()) {
			valorBolsa += participacao.calculaBolsa();
		}
		return valorBolsa;
	}
	
	public double calculaColaboracaoUASC(String cod) throws ConsultaException{
		validator.validaCalculaColaboracaoUASC(cod);
		Projeto proj = projetosController.getProjeto(Integer.valueOf(cod));
		valorTotalUASC += proj.montanteUASC();
		valorEmCaixa = valorTotalUASC;
		return proj.montanteUASC();
	}
	
	public double calculaColaboracaoTotalUASC(){
		return valorTotalUASC;
	}
	
	public void diminuiReceita(double valor) throws AtualizacaoException{
		validator.validaDiminuiReceita(valor, getValorEmCaixa());
		setValorEmCaixa(getValorEmCaixa() - valor);
		setValorGasto(getValorEmCaixa()+ valor);
		
	}
	
	public double calculaTotalEmCaixa(){
		return valorEmCaixa;
	}
	
	public List<Participacao> getParticipacoes() {
		return participacoes;
	}
	
	public double getValorEmCaixa() {
		return valorEmCaixa;
	}
	
	public void setValorEmCaixa(double valorEmCaixa) {
		this.valorEmCaixa = valorEmCaixa;
	}

	public double getValorGasto() {
		return valorGasto;
	}

	public void setValorGasto(double valorGasto) {
		this.valorGasto = valorGasto;
	}
	
	
}
