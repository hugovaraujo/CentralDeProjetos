package view;

import controller.MainController;
import controller.PessoasCRUD;
import controller.ProjetosCRUD;
import easyaccept.EasyAccept;
import exceptions.CadastroException;


public class ProjetosFacade {
	
MainController main;
ProjetosCRUD projetos;
PessoasCRUD pessoas;

	public ProjetosFacade(){
		
		main = new MainController();
		projetos = main.getProjetosController();
		pessoas = main.getPessoasController();
		
	}
	
	public void iniciaSistema(){
		
	}
	
	public void fechaSistema(){
		
	}
	// PARTICIPACAO
	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) throws Exception {
		
		main.associaProfessor(cpfPessoa, codigoProjeto, coordenador, valorHora, qntHoras);
	}

	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) throws Exception {
		
		main.associaProfissional(cpfPessoa, codigoProjeto, cargo, valorHora, qntHoras);
	}


	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) throws Exception {

		main.associaGraduando(cpfPessoa, codigoProjeto, valorHora, qntHoras);
		
	}

	public void removeParticipacao(String cpfPessoa, int codigoProjeto) throws Exception {
		
		main.removeParticipacao(cpfPessoa, codigoProjeto);
		
	}
	
	public String getInfoPessoa(String cpf, String atributo) throws Exception{
		
		return main.getInfoPessoa(cpf, atributo);
	}
	
	public String getInfoProjeto(int codigo, String atributo) throws Exception{
		
		return main.getInfoProjeto(codigo, atributo);
		
	}
	
	
	// PESSOA
	public String cadastraPessoa(String cpf, String nome, String email) throws Exception {
		
		return pessoas.cadastraPessoa(cpf, nome, email);

	}

	public void removePessoa(String cpf) throws Exception {
		
		pessoas.removePessoa(cpf);	
		
	}

	public void editaPessoa(String cpf, String atributo, String valor) throws Exception{
		pessoas.editaPessoa(cpf, atributo, valor);
		
	}
	// PROJETO
	
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) throws CadastroException{
		
		return projetos.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
	
	}
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) throws CadastroException{
		
		return projetos.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
		
	}
	
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) throws CadastroException{
		
		return projetos.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		
	}
	
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) throws CadastroException{
		
		return projetos.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
		
	}
	
	public void removeProjeto(int codigo) {
		
		projetos.removeProjeto(codigo);
		
	}

	public void editaProjeto(int codigo, String atributo, String valor) throws Exception{
		
		projetos.editarProjeto(codigo, atributo, valor);
		
	}
	
	public int getCodigoProjeto(String nome)throws Exception{
		return projetos.getCodigoProjeto(nome);
	}
	
	public static void main(String[] args) {
	    args = new String[] {"view.ProjetosFacade", "easyaccept/us1_test.txt", "easyaccept/us1_test_exception.txt","easyaccept/us2_test.txt", "easyaccept/us2_test_exception.txt","easyaccept/us3_test.txt", "easyaccept/us3_test_exception.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}
}
