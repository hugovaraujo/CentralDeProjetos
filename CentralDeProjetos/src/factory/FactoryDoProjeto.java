package factory;

import exceptions.CadastroException;
import exceptions.FormatoInvalidoException;
import exceptions.StringInvalidaException;
import model.Extensao;
import model.Monitoria;
import model.PED;
import model.PET;

public class FactoryDoProjeto {
	
	 public Monitoria criaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) throws CadastroException, FormatoInvalidoException, StringInvalidaException{
		 
		 return new Monitoria(nome,disciplina,rendimento,objetivo,periodo,dataInicio,duracao);
		 
	 }
	 
	 public Extensao criaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) throws CadastroException, FormatoInvalidoException, StringInvalidaException{
		
		 return new Extensao(nome,objetivo,impacto,dataInicio,duracao);
		 
	 }
	 
	 public PED criaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) throws CadastroException, FormatoInvalidoException, StringInvalidaException{
		 
		 return new PED(nome,categoria,prodTecnica,prodAcademica,patentes,objetivo,dataInicio,duracao);
		 
	 }
	 
	 public PET criaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) throws CadastroException, FormatoInvalidoException, StringInvalidaException{
		
		 return new PET(nome,objetivo,impacto,rendimento,prodTecnica,prodAcademica,patentes,dataInicio,duracao);
		 
	 }

}
