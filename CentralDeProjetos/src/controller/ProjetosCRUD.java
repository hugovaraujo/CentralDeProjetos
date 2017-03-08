package controller;

import java.util.Date;
import java.util.HashMap;

import factory.FactoryDoProjeto;
import model.Projeto;

public class ProjetosCRUD {
	
	private HashMap<Integer, Projeto> projetos;
	private FactoryDoProjeto factoryProjeto;
	
	public ProjetosCRUD(){
		
		projetos = new HashMap<>();
		factoryProjeto = new FactoryDoProjeto();
		
	}


	public void adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto já existe.");
			return;
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
		
	}
	
	public void adicionaExtensao(String nome, String objetivo, int impacto, Date dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaExtensao(nome, objetivo, impacto, dataInicio, duracao);
				
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto já existe.");
			return;
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
	}
	
	public void adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto já existe.");
			return;
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
	}
	
	public void adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date dataInicio, int duracao){
		
		Projeto projeto = factoryProjeto.criaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
		
		if(projetos.containsKey(projeto.getCodigo())){
			
			System.out.println("Projeto já existe.");
			return;
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
	}


	/**
	 * Remove um projeto do conjunto de projetos ja existentes.
	 * 
	 * @param projeto
	 * @return true se for removido com sucesso, falso se nao for possivel
	 *         remover.
	 */
	public boolean removeProjeto(Projeto projeto) {
		return false;
		// TODO: remover um projeto do BD
	}

	/**
	 * Edita um projeto enviado como parametro.
	 * 
	 * @param projeto
	 * @return retorna true se editar com sucesso, falso se nao for possivel
	 *         editar.
	 */
	public boolean editarProjeto(Projeto projeto) {
		return false;
		// TODO: procurar saber o que ï¿½ pra editar no projeto.
	}

	/**
	 * Procura um projeto no conjunto, usando o codigo de identificao unica do
	 * projeto.
	 * 
	 * @param codigoProjeto
	 * @return returna o projeto pertencente ao codigo ou null caso nao ache um
	 *         projeto.
	 */
	public Projeto getProjeto(String codigoProjeto) {
		return null;
		// TODO: recupera um projeto do BD
	}
}
