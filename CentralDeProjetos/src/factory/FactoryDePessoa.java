package factory;

import model.Pessoa;


public class FactoryDePessoa {
	
	 public Pessoa criaPessoa(String cpf, String nome, String email){
			
		 return new Pessoa(cpf, nome, email);
		 
	 }

}
