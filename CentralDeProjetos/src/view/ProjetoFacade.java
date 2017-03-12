package view;

import java.util.Date;

import controller.ProjetosCRUD;
import easyaccept.EasyAccept;

public class ProjetoFacade {
	
	ProjetosCRUD projetos;
	
	public ProjetoFacade(){
		
		projetos = new ProjetosCRUD();
		
	}
	
	public void adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date dataInicio, int duracao){
		
		projetos.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		
	}
	
	public void adicionaExtensao(String nome, String objetivo, int impacto, Date dataInicio, int duracao){
		
		projetos.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
		
	}
	
	public void adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date dataInicio, int duracao){
		
		projetos.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		
	}
	
	public void adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date dataInicio, int duracao){
		
		projetos.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
		
	}
	
	public void removeProjeto(String codigoProjeto) {
		
		projetos.removeProjeto(codigoProjeto);
		
	}

	public void editarProjeto(String codigoProjeto, String atributo, String valor) throws Exception{
		
		projetos.editarProjeto(codigoProjeto, atributo, valor);
		
	}

	public void editarProjeto(String codigoProjeto, String atributo, int valor) throws Exception{

		projetos.editarProjeto(codigoProjeto, atributo, valor);
		
	}

}
