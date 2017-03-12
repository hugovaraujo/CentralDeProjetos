package controller;

/**
 * Classe que representa o controller do main
 * 
 * @author
 * 
 *
 */
public class MainController {
	
	ParticipacaoController participacao;
	PessoasCRUD pessoas;
	ProjetosCRUD projetos;
	
	/**
	 * Construtor de MainController 
	 */
	public MainController(){
		
		participacao = new ParticipacaoController();
		pessoas = new PessoasCRUD();
		projetos = new ProjetosCRUD();
		
	}
}
