package controller;

import java.util.Date;
import java.util.HashMap;

import factory.FactoryDoProjeto;
import model.Projeto;

public class ProjetosCRUD {
	
	private HashMap<Integer, Projeto> projetos;
	private FactoryDoProjeto factoryProjeto;
	private HashMap<String, Projeto> projetosNome;
	
	public ProjetosCRUD(){
		
		projetos = new HashMap<>();
		factoryProjeto = new FactoryDoProjeto();
		projetosNome = new HashMap<>();
		
	}

	// Modifiquei aqui os metodos de adicionar para retornar o codigo
	
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto ja existe.");
		}
		
		projeto.setCodigo(projeto.geraCodigo());
		projetos.put(projeto.getCodigo(), projeto);
		projetosNome.put(projeto.getNome(), projeto);
		
		return projeto.getCodigo();
		
	}
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaExtensao(nome, objetivo, impacto, dataInicio, duracao);
				
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto ja existe.");

		}
		
		projeto.setCodigo(projeto.geraCodigo());
		projetos.put(projeto.getCodigo(), projeto);
		projetosNome.put(projeto.getNome(), projeto);
		
		return projeto.getCodigo();
		
	}
	
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto ja existe.");
			
		}
		
		projeto.setCodigo(projeto.geraCodigo());
		projetos.put(projeto.getCodigo(), projeto);
		projetosNome.put(projeto.getNome(), projeto);
		
		return projeto.getCodigo();
	}
	
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
		
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto ja existe.");
		}
		
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
	public boolean editarProjeto(int codigoProjeto, String atributo, String valor) throws Exception {
		Projeto projeto = getProjeto(codigoProjeto);
		return projeto.editaProjeto(atributo, valor);	
	}
	
	public boolean editarProjeto(int codigoProjeto, String atributo, int valor) throws Exception {
		Projeto projeto = getProjeto(codigoProjeto);
		return projeto.editaProjeto(atributo, valor);	
	}
	
	public String getInfoProjeto(int codigoProjeto, String atributo) throws Exception{
		Projeto projeto = getProjeto(codigoProjeto);
		return projeto.getInfoProjeto(atributo);
		
	}
	
	public int getCodigoProjeto(String nome)throws Exception{
		for (int i = 0; i < projetosNome.size(); i++) {
			if (!projetosNome.containsKey(nome)) {
				throw new Exception("Erro na consulta de projeto: Projeto nao encontrado");
			}
		}
		return projetosNome.get(nome).getCodigo();
	}
	
	/**
	 * Procura um projeto no conjunto, usando o codigo de identificao unica do
	 * projeto.
	 * 
	 * @param codigoProjeto
	 * @return returna o projeto pertencente ao codigo ou null caso nao ache um
	 *         projeto.
	 * @throws Exception 
	 */
	public Projeto getProjeto(int codigoProjeto) throws Exception {
		Projeto projeto = projetos.get(codigoProjeto);
		if (projeto == null){
			throw new Exception("Erro na consulta de projeto: Projeto nao encontrado");
		};
		return projeto;
	}
}
