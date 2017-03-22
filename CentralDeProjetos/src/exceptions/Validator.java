package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.projeto.Categorias;

public class Validator {
	
	static final String FORMATO_CPF = "^[0-9]{3}(\\.[0-9]{3}){2}-[0-9]{2}$";
	static final String FORMATO_EMAIL = "^[A-Za-z0-9-_]+[A-Za-z0-9-_\\.]*[A-Za-z0-9-_]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,4}$";
	static final String FORMATO_DATA = "^(?:(?:31/(?:0[13578]|1[02]))/|(?:(?:29|30)/(?:0[1,3-9]|1[0-2])/))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29/(?:02)/(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0[1-9]|1\\d|2[0-8])/(?:(?:0[1-9])|(?:1[0-2]))/(?:(?:1[6-9]|[2-9]\\d)\\d{2})$";
	static final String FORMATO_PERIODO = "^[\\d]{4}\\.[1-2]$";
	
	public Validator(){
		
	}
	
	public void verificaString(String str, String atributo) throws StringInvalidaException{
		if(str == null || str.trim().isEmpty()){
			throw new StringInvalidaException(atributo + " nulo ou vazio"); 
		}
	}
	public void verificaStringF(String str, String atributo) throws StringInvalidaException{
		if(str == null || str.trim().isEmpty()){
			throw new StringInvalidaException(atributo + " nula ou vazia"); 
		}
	}
	
	public void verificaDuracao(int duracao) throws FormatoInvalidoException{
		if(duracao < 1){
			throw new FormatoInvalidoException("Duracao invalida"); 
		}
	}
	
   public void verificaCpf(String cpf) throws FormatoInvalidoException{
		Pattern padrao = Pattern.compile(FORMATO_CPF);
		Matcher matcher= padrao.matcher(cpf);
		if (!matcher.matches()){
			throw new FormatoInvalidoException("CPF invalido"); 
		}
	}
   
   public void verificaEmail(String email) throws FormatoInvalidoException{
		Pattern padrao = Pattern.compile(FORMATO_EMAIL);
		Matcher matcher= padrao.matcher(email);
		if (!matcher.matches()){
			throw new FormatoInvalidoException("Email invalido"); 
		}
	}
   
   public void verificaData(String dataInicio) throws FormatoInvalidoException{
	   Pattern padrao = Pattern.compile(FORMATO_DATA);
		Matcher matcher= padrao.matcher(dataInicio);
		if (!matcher.matches()){
			throw new FormatoInvalidoException("Formato de data invalido"); 
		}
	}
   
   public void verificaPeriodo(String dataInicio) throws FormatoInvalidoException{
	   Pattern padrao = Pattern.compile(FORMATO_PERIODO);
		Matcher matcher= padrao.matcher(dataInicio);
		if (!matcher.matches()){
			throw new FormatoInvalidoException("Periodo invalido"); 
		}
	}
   
   public void verificaImpacto(int impacto) throws FormatoInvalidoException{
		if (impacto < 1 || impacto > 6){
			throw new FormatoInvalidoException("Impacto invalido");
		}
   }
   
   public void verificaRendimento(int rendimento) throws FormatoInvalidoException{
		if (rendimento < 0 || rendimento > 100){
			throw new FormatoInvalidoException("Rendimento invalido");
		}
   }
   
   public void verificaNegativo(int numero, String str) throws FormatoInvalidoException{
		if (numero < 0){
			throw new FormatoInvalidoException(str +" invalido");
		}
   }
   
   public void verificaCategoria(String categoria) throws FormatoInvalidoException{
	   try {
		   Categorias.valueOf(categoria);
	} catch (Exception e) {
		throw new FormatoInvalidoException("Categoria invalida");
	}
	   
   }
   
   public boolean verificaContem(String atributo) throws FormatoInvalidoException{
		if (atributo.equals("Disciplina") | atributo.equals("Periodo") | atributo.equals("Rendimento") | atributo.equals("Producao tecnica") | atributo.equals("Producao academica") || atributo.equals("Patentes") || atributo.equals("Categoria")){
			return true;
		}
		return false;
   }
	   
   
   
}
