package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificador {
	
	static final String FORMATO_CPF = "^[0-9]{3}(\\.[0-9]{3}){2}-[0-9]{2}$";
	static final String FORMATO_EMAIL = "^[A-Za-z0-9-_]+[A-Za-z0-9-_\\.]*[A-Za-z0-9-_]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,4}$";
	static final String FORMATO_DATA = "^(?:(?:31/(?:0[13578]|1[02]))/|(?:(?:29|30)/(?:0[1,3-9]|1[0-2])/))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29/(?:02)/(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0[1-9]|1\\d|2[0-8])/(?:(?:0[1-9])|(?:1[0-2]))/(?:(?:1[6-9]|[2-9]\\d)\\d{2})$";
	
	public Verificador(){
		
	}
	
	public void verificaString(String str, String atributo) throws StringInvalidaException{
		if(str == null || str.trim().isEmpty()){
			throw new StringInvalidaException(atributo); 
		}
	}
	
   public void verificaCpf(String cpf) throws FormatoInvalidoException{
		Pattern padrao = Pattern.compile(FORMATO_CPF);
		Matcher matcher= padrao.matcher(cpf);
		if (!matcher.matches()){
			throw new FormatoInvalidoException("CPF"); 
		}
	}
   
   public void verificaEmail(String email) throws FormatoInvalidoException{
		Pattern padrao = Pattern.compile(FORMATO_EMAIL);
		Matcher matcher= padrao.matcher(email);
		if (!matcher.matches()){
			throw new FormatoInvalidoException("Email"); 
		}
	}
   
   public void verificaData(String dataInicio) throws FormatoInvalidoException{
	   Pattern padrao = Pattern.compile(FORMATO_DATA);
		Matcher matcher= padrao.matcher(dataInicio);
		if (!matcher.matches()){
			throw new FormatoInvalidoException("Formato de data"); 
		}
	}
   
}
