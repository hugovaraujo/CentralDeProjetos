	package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.CentralController;
import controller.PessoasController;
import controller.ProjetosController;
import easyaccept.EasyAccept;
import exceptions.AtualizacaoException;
import exceptions.CadastroException;
import exceptions.ConsultaException;
import exceptions.PersistenciaException;
import exceptions.RemocaoException;


public class ProjetosFacade {
	
CentralController centralController;
ProjetosController projetos;
PessoasController pessoas;

	public ProjetosFacade(){
		
		centralController = new CentralController();
		projetos = centralController.getProjetosController();
		pessoas = centralController.getPessoasController();
		
	}
	
	public void iniciaSistema() throws PersistenciaException{
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("arquivos_sistema/cpc_ufcg.dat");
			@SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			centralController = (CentralController) ois.readObject();
			projetos = (ProjetosController) ois.readObject();
			pessoas =  (PessoasController) ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			throw new PersistenciaException(e);
		}
	}
	
	public void fechaSistema() throws PersistenciaException{
		
		File file = new File("arquivos_sistema/cpc_ufcg.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(centralController);
			oos.writeObject(projetos);
			oos.writeObject(pessoas);
			
		} catch (IOException e) { throw new PersistenciaException(e); }
		finally { try { oos.close(); } catch (IOException e) { throw new PersistenciaException(e); }}

	
	}
	// PARTICIPACAO
	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) throws Exception {
		
		centralController.associaProfessor(cpfPessoa, codigoProjeto, coordenador, valorHora, qntHoras, 0);
	}

	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) throws Exception {
		
		centralController.associaProfissional(cpfPessoa, codigoProjeto, cargo, valorHora, qntHoras,0);
	}


	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) throws Exception {

		centralController.associaGraduando(cpfPessoa, codigoProjeto, valorHora, qntHoras,0);
		
	}
	
	public void associaPosGraduando(String cpfPessoa, int codigoProjeto, String nivel, double valorHora, int qntHoras) throws Exception {
		
		centralController.associaPosGraduando(cpfPessoa, codigoProjeto, nivel, valorHora, qntHoras,0);
	}

	public void removeParticipacao(String cpfPessoa, int codigoProjeto) throws Exception {
		
		centralController.removeParticipacao(cpfPessoa, codigoProjeto);
		
	}
	
	public String getInfoPessoa(String cpf, String atributo) throws Exception{
		
		return centralController.getInfoPessoa(cpf, atributo);
	}
	
	public String getInfoProjeto(int codigo, String atributo) throws Exception{
		
		return centralController.getInfoProjeto(codigo, atributo);
		
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
	
	public void removeProjeto(int codigo) throws RemocaoException {
		
		projetos.removeProjeto(codigo);
		
	}

	public void editaProjeto(int codigo, String atributo, String valor) throws Exception{
		
		projetos.editarProjeto(codigo, atributo, valor);
		
	}
	
	public int getCodigoProjeto(String nome)throws Exception{
		return projetos.getCodigoProjeto(nome);
	}
	
	public double getValorBolsa(String cpf){
		return centralController.getValorBolsa(cpf);
	}
	
	public double calculaPontuacaoPorParticipacao(String cpf) {
		return centralController.calculaPontuacaoPorParticipacao(cpf);
	}
	
	public void atualizaDespesasProjeto(String cod, double montanteBolsas, double montanteCusteio, double montanteCapital) throws AtualizacaoException{
		projetos.atualizaDespesas(cod, montanteBolsas, montanteCusteio, montanteCapital);
	}
	
	public double calculaColaboracaoUASC(String cod) throws ConsultaException{
		return centralController.calculaColaboracaoUASC(cod);
	}
	
	public double calculaColaboracaoTotalUASC(){
		return centralController.calculaColaboracaoTotalUASC();
	}
	
	public void diminuiReceita(double valor) throws AtualizacaoException{
		centralController.diminuiReceita(valor);
	}
	
	public double calculaTotalEmCaixaUASC(){
		return centralController.calculaTotalEmCaixa();
	}
	
	public static void main(String[] args) {
	    args = new String[] {"view.ProjetosFacade", "easyaccept/us1_test.txt", "easyaccept/us1_test_exception.txt","easyaccept/us2_test.txt", "easyaccept/us2_test_exception.txt","easyaccept/us3_test.txt", "easyaccept/us3_test_exception.txt","easyaccept/us4_test.txt", "easyaccept/us5_test.txt","easyaccept/us6_test.txt", "easyaccept/us6_test_exception.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	    
	}
}
