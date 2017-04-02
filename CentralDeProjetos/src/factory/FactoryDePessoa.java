package factory;

import java.io.Serializable;

import exceptions.CadastroException;
import model.pessoa.Pessoa;


public class FactoryDePessoa implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pessoa criaPessoa(String cpf, String nome, String email) throws CadastroException{
			
		 return new Pessoa(cpf, nome, email);
	 }

}
