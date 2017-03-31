package controller;

import java.util.HashMap;

import exceptions.AtualizacaoException;
import exceptions.CadastroException;
import exceptions.ConsultaException;
import exceptions.ProjetosControllerValidator;
import factory.FactoryDoProjeto;
import model.projeto.Projeto;

/**
 * Classe que representa o controller de Projeto.
 * 
 * @author 
 *
 */
public class ProjetosController {
	
	public HashMap<Integer, Projeto> projetos;
	private FactoryDoProjeto factoryProjeto;
	private HashMap<String, Projeto> projetosNome;
	private ProjetosControllerValidator validator;
	private double valorTotalUASC;
	private double valorEmCaixa;
	
	/**
	 * Construtor de ProjetosCRUD
	 */
	public ProjetosController(){
		
		this.projetos = new HashMap<>();
		this.factoryProjeto = new FactoryDoProjeto();
		this.projetosNome = new HashMap<>();
		this.validator = new ProjetosControllerValidator();
		this.valorTotalUASC = 0;
		this.valorEmCaixa = 0;
	}
	
	/** Metodo que adiciona uma monitoria. Adiciona o projeto ao Map de projetos(que tem como chave o codigo do projeto) e adiciona tambem o projeto ao mapa de projetosNome( onde a chave � o nome do projeto).
	 * 
	 * @param nome
	 * @param disciplina
	 * @param rendimento
	 * @param objetivo
	 * @param periodo
	 * @param dataInicio
	 * @param duracao
	 * @return retorna o codigo do projeto adicionado
	 * @throws CadastroException 
	 */
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) throws CadastroException{
		


		validator.validaAdicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		
		Projeto projeto = factoryProjeto.criaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		
		validator.validaContemProjeto(projetos.containsKey(projeto.getCodigo()));

		projeto.setCodigo(projeto.geraCodigo());
		projetos.put(projeto.getCodigo(), projeto);
		System.out.println("adicionou projetooooo");
		projetosNome.put(projeto.getNome(), projeto);
		
		return projeto.getCodigo();
		
	}
	
	/**
	 * M�todo que adiciona um projeto de extensao. Com caracteristicas parecidas do metodo anterior.
	 * 
	 * @param nome
	 * @param objetivo
	 * @param impacto
	 * @param dataInicio
	 * @param duracao
	 * @return retorna o codigo do projeto.
	 * @throws CadastroException 
	 */
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) throws CadastroException{
		
		validator.validaAdicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
		
		Projeto projeto = factoryProjeto.criaExtensao(nome, objetivo, impacto, dataInicio, duracao);
				
		validator.validaContemProjeto(projetos.containsKey(projeto.getCodigo()));
		
		projeto.setCodigo(projeto.geraCodigo());
		projetos.put(projeto.getCodigo(), projeto);
		System.out.println("adicionou projetooooo");
		projetosNome.put(projeto.getNome(), projeto);
		
		return projeto.getCodigo();
		
	}
	
	/**
	 * Metodo que adiciona um projeto PED.
	 * 
	 * @param nome
	 * @param categoria
	 * @param prodTecnica
	 * @param prodAcademica
	 * @param patentes
	 * @param objetivo
	 * @param dataInicio
	 * @param duracao
	 * @return retorna o codigo do projeto
	 * @throws CadastroException 
	 */
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) throws CadastroException{
		
validator.validaAdicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		
		Projeto projeto = factoryProjeto.criaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		
		validator.validaContemProjeto(projetos.containsKey(projeto.getCodigo()));

		projeto.setCodigo(projeto.geraCodigo());
		projetos.put(projeto.getCodigo(), projeto);
		projetosNome.put(projeto.getNome(), projeto);
		
		return projeto.getCodigo();
	}
	
	/**
	 * M�todo que adiciona um Projeto PET. Com caracteristicas semelhantes com os m�todos anteriores.
	 * 
	 * @param nome
	 * @param objetivo
	 * @param impacto
	 * @param rendimento
	 * @param prodTecnica
	 * @param prodAcademica
	 * @param patentes
	 * @param dataInicio
	 * @param duracao
	 * @return retorna o codigo do projeto
	 * @throws CadastroException 
	 */
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) throws CadastroException{
		
		validator.validaAdicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
		
		Projeto projeto = factoryProjeto.criaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);

		validator.validaContemProjeto(projetos.containsKey(projeto.getCodigo()));
		
		projeto.setCodigo(projeto.geraCodigo());
		projetos.put(projeto.getCodigo(), projeto);
		projetosNome.put(projeto.getNome(), projeto);
		
		return projeto.getCodigo();
	}


	/**
	 * Remove um projeto do conjunto de projetos ja existentes.
	 * 
	 * @param projeto
	 * @return true se for removido com sucesso, falso se nao for possivel
	 *         remover.
	 */
	public boolean removeProjeto(int codigo) {
		projetos.remove(codigo);
		return false;
	}

	/**
	 * Edita um projeto enviado como parametro.
	 * 
	 * @param projeto
	 * @return retorna true se editar com sucesso, falso se nao for possivel
	 *         editar.
	 * @throws Exception 
	 */
	public void editarProjeto(int codigoProjeto, String atributo, String valor) throws AtualizacaoException {
		Projeto projeto = getProjeto(codigoProjeto);
		projeto.editaProjeto(atributo, valor);
			
	}
	
	
	/**
	 * Metodo que consulta uma informacao de um projeto, de acordo com o atributo
	 * 
	 * @param codigoProjeto
	 * @param atributo
	 * @return  retorna a informacao pedida no atributo
	 * @throws Exception
	 */
	public String getInfoProjeto(int codigoProjeto, String atributo) throws ConsultaException{
		Projeto projeto = getProjeto(codigoProjeto);
		
		validator.validaGetInfoProjeto(projeto);
		
		return projeto.getInfoProjeto(atributo);
		
	}
	
	/**
	 * M�todo que procura um projeto pelo nome
	 * 
	 * @param nome
	 * @return retorna o c�digo do projeto encontrado
	 * @throws Exception
	 */
	public int getCodigoProjeto(String nome)throws Exception{
		for (int i = 0; i < projetosNome.size(); i++) {
			if (!projetosNome.containsKey(nome)) {
				throw new Exception("Erro na obtencao de codigo de projeto: Projeto nao encontrado");
			}
		}
		return projetosNome.get(nome).getCodigo();
	}
	
	/**
	 * Procura um projeto no conjunto, usando o codigo de identificao unica do
	 * projeto.
	 * 
	 * @param codigoProjeto
	 * @return retorna o projeto pertencente ao codigo ou null caso nao ache um
	 *         projeto.
	 * @throws Exception 
	 */
	public Projeto getProjeto(int codigoProjeto){
		Projeto projeto = projetos.get(codigoProjeto);
		return projeto;
	}
	
	/**
	 * Metodo que atualiza os valores das despesas de um projeto
	 * 
	 * @param cod
	 * @param montanteBolsas
	 * @param montanteCusteio
	 * @param montanteCapital
	 */
	public void atualizaDespesas(int cod, double montanteBolsas, double montanteCusteio, double montanteCapital){
		Projeto proj = getProjeto(cod);
		proj.getDespesas().setMontanteBolsas(montanteBolsas);
		proj.getDespesas().setMontanteCapital(montanteCapital);
		proj.getDespesas().setMontanteCusteio(montanteCusteio);
	}
	
	public double calculaColaboracaoUASC(int cod){
		Projeto proj = getProjeto(cod);
		valorTotalUASC += proj.montanteUASC();
		return proj.montanteUASC();
	}
	
	public double calculaColaboracaoTotalUASC(){
		return valorTotalUASC;
	}
	
	public void diminuiReceita(double valor){
		valorEmCaixa = calculaColaboracaoTotalUASC() - valor;
	}
	
	public double calculaTotalEmCaixa(){
		return valorEmCaixa;
	}
		
}