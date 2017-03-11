package controller;

public class MainController {
	
	ParticipacaoController participacao;
	PessoasCRUD pessoas;
	ProjetosCRUD projetos;
	
	public MainController(){
		
		participacao = new ParticipacaoController();
		pessoas = new PessoasCRUD();
		projetos = new ProjetosCRUD();
		
	}
}
