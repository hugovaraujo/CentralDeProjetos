package view;

import controller.PessoasCRUD;
import easyaccept.EasyAccept;

public class PessoaFacade {
	
	PessoasCRUD pessoas;
	
	public PessoaFacade(){
		
		pessoas = new PessoasCRUD();
		
	}
	
	public String cadastraPessoa(String cpf, String nome, String email) throws Exception {
		
		return pessoas.cadastraPessoa(cpf, nome, email);

	}

	public void removePessoa(String cpf) throws Exception {
		
		pessoas.removePessoa(cpf);	
		
	}
	
	public String getInfoPessoa(String cpf, String atributo) throws Exception{
		return pessoas.getInfoPessoa(cpf, atributo);
		
	}
	
	public void editaPessoa(String cpf, String atributo, String valor) throws Exception{
		pessoas.editaPessoa(cpf, atributo, valor);
		
	}

	public static void main(String[] args) {
	    args = new String[] {"view.PessoaFacade", "easyaccept/us1_test.txt", "easyaccept/us1_test_exception.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}

}
