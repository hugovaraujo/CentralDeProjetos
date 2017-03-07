package factory;

import java.util.Date;

import model.Extensao;
import model.Monitoria;
import model.PED;
import model.PET;

public class FactoryDoProjeto {
	
	 public Monitoria adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date dataInicio, int duracao){
		 
		 return new Monitoria(nome,disciplina,rendimento,objetivo,periodo,dataInicio,duracao);
		 
	 }
	 
	 public Extensao adicionaExtensao(String nome, String objetivo, int impacto, Date dataInicio, int duracao){
		
		 return new Extensao(nome,objetivo,impacto,dataInicio,duracao);
		 
	 }
	 
	 public PED adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date dataInicio, int duracao){
		 
		 return new PED(nome,categoria,prodTecnica,prodAcademica,patentes,objetivo,dataInicio,duracao);
		 
	 }
	 
	 public PET adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date dataInicio, int duracao){
		
		 return new PET(nome,objetivo,impacto,rendimento,prodTecnica,prodAcademica,patentes,dataInicio,duracao);
		 
	 }

}
