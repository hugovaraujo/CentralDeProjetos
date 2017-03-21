package factory;

import exceptions.CadastroException;
import model.pessoa.Pessoa;


public class FactoryDePessoa {
	
	 public Pessoa criaPessoa(String cpf, String nome, String email) throws CadastroException{
			
		 return new Pessoa(cpf, nome, email);
	 }

}
