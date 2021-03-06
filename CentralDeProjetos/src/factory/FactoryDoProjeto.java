package factory;


import java.io.Serializable;

import model.projeto.tipos.Extensao;
import model.projeto.tipos.Monitoria;
import model.projeto.tipos.PED;
import model.projeto.tipos.PET;

public class FactoryDoProjeto implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Monitoria criaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) {
		 
		 return new Monitoria(nome,disciplina,rendimento,objetivo,periodo,dataInicio,duracao);
		 
	 }
	 
	 public Extensao criaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		
		 return new Extensao(nome,objetivo,impacto,dataInicio,duracao);
		 
	 }
	 
	 public PED criaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		 
		 return new PED(nome,categoria,prodTecnica,prodAcademica,patentes,objetivo,dataInicio,duracao);
		 
	 }
	 
	 public PET criaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		
		 return new PET(nome,objetivo,impacto,rendimento,prodTecnica,prodAcademica,patentes,dataInicio,duracao);
		 
	 }

}
