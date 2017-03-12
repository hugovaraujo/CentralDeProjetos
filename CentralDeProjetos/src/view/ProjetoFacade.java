package view;

import java.util.Date;

import controller.ProjetosCRUD;
import easyaccept.EasyAccept;

public class ProjetoFacade {
	
	ProjetosCRUD projetos;
	
	public ProjetoFacade(){
		
		projetos = new ProjetosCRUD();
		
	}
	
	// coloquei aqui tbm pra retornar o c�digo nesses metodos de adicionar
	
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date dataInicio, int duracao){
		
		return projetos.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
	
	}
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, Date dataInicio, int duracao){
		
		return projetos.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
		
	}
	
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date dataInicio, int duracao){
		
		return projetos.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		
	}
	
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date dataInicio, int duracao){
		
		return projetos.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
		
	}
	
	public void removeProjeto(int codigo) {
		
		projetos.removeProjeto(codigo);
		
	}

	public void editarProjeto(int codigo, String atributo, String valor) throws Exception{
		
		projetos.editarProjeto(codigo, atributo, valor);
		
	}

	public void editarProjeto(int codigo, String atributo, int valor) throws Exception{

		projetos.editarProjeto(codigo, atributo, valor);
		
	}
	
	// criei o getInfoProjetos de Facade
	
	public String getInfoProjeto(int codigo, String atributo) throws Exception{
		return projetos.getInfoProjeto(codigo, atributo); 
	}
	
	public static void main(String[] args) {
	    args = new String[] {"view.ProjetoFacade", "easyaccept/us2_test.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}

	
}
