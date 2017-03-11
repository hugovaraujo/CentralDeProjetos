package view;

import controller.PessoasCRUD;
import easyaccept.EasyAccept;

public class PessoaFacade {
	
	PessoasCRUD pessoas;
	
	public PessoaFacade(){
		
		pessoas = new PessoasCRUD();
		
	}
	
	public void cadastraPessoa(String cpf, String nome, String email) throws Exception {
		
		pessoas.cadastraPessoa(cpf, nome, email);

	}

	public void removePessoa(String cpf) throws Exception {
		
		pessoas.removerPessoa(cpf);	
		
	}
	
	public void getInfoPessoa(String cpf) {

		pessoas.getInfoPessoa(cpf);
		
	}

	public static void main(String[] args) {
	    args = new String[] {"view.PessoaFacade", "easyaccept/us1_test.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}

}
