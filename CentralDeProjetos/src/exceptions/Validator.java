package exceptions;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.projeto.Categorias;

public class Validator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String FORMATO_CPF = "^[0-9]{3}(\\.[0-9]{3}){2}-[0-9]{2}$";
	static final String FORMATO_EMAIL = "^[A-Za-z0-9-_]+[A-Za-z0-9-_\\.]*[A-Za-z0-9-_]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,4}$";
	static final String FORMATO_DATA = "^(?:(?:31/(?:0[13578]|1[02]))/|(?:(?:29|30)/(?:0[1,3-9]|1[0-2])/))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29/(?:02)/(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0[1-9]|1\\d|2[0-8])/(?:(?:0[1-9])|(?:1[0-2]))/(?:(?:1[6-9]|[2-9]\\d)\\d{2})$";
	static final String FORMATO_PERIODO = "^[\\d]{4}\\.[1-2]$";

	
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
	
	public void verificaDuracao(int duracao) throws ParametroInvalidoException{
		if(duracao < 1){
			throw new ParametroInvalidoException("Duracao invalida"); 
		}
	}
	
   public void verificaCpf(String cpf) throws ParametroInvalidoException{
		Pattern padrao = Pattern.compile(FORMATO_CPF);
		Matcher matcher= padrao.matcher(cpf);
		if (!matcher.matches()){
			throw new ParametroInvalidoException("CPF invalido"); 
		}
	}
   
   public void verificaEmail(String email) throws ParametroInvalidoException{
		Pattern padrao = Pattern.compile(FORMATO_EMAIL);
		Matcher matcher= padrao.matcher(email);
		if (!matcher.matches()){
			throw new ParametroInvalidoException("Email invalido"); 
		}
	}
   
   public void verificaData(String dataInicio) throws ParametroInvalidoException{
	   Pattern padrao = Pattern.compile(FORMATO_DATA);
		Matcher matcher= padrao.matcher(dataInicio);
		if (!matcher.matches()){
			throw new ParametroInvalidoException("Formato de data invalido"); 
		}
	}
   
   public void verificaPeriodo(String dataInicio) throws ParametroInvalidoException{
	   Pattern padrao = Pattern.compile(FORMATO_PERIODO);
		Matcher matcher= padrao.matcher(dataInicio);
		if (!matcher.matches()){
			throw new ParametroInvalidoException("Periodo invalido"); 
		}
	}
   
   public void verificaImpacto(int impacto) throws ParametroInvalidoException{
		if (impacto < 1 || impacto > 6){
			throw new ParametroInvalidoException("Impacto invalido");
		}
   }
   
   public void verificaRendimento(int rendimento) throws ParametroInvalidoException{
		if (rendimento < 0 || rendimento > 100){
			throw new ParametroInvalidoException("Rendimento invalido");
		}
   }
   
   public void verificaMenorQueZero(int numero, String str) throws ParametroInvalidoException{
		if (numero < 0){
			throw new ParametroInvalidoException(str +" invalido");
		}
   }

   
   public void verificaNegativo(double numero) throws ParametroInvalidoException{
		if (numero < 0){
			throw new ParametroInvalidoException("valor negativo");
		}
   }
   
   
   public void verificaCategoria(String categoria) throws ParametroInvalidoException{
	   try {
		   Categorias.valueOf(categoria);
	} catch (Exception e) {
		throw new ParametroInvalidoException("Categoria invalida");
	}
	   
   }
   
   public boolean verificaAtributoContem(String atributo) throws ParametroInvalidoException{
		if (atributo.equals("Disciplina") | atributo.equals("Periodo") | atributo.equals("Rendimento") | atributo.equals("Producao tecnica") | atributo.equals("Producao academica") || atributo.equals("Patentes") || atributo.equals("Categoria") || atributo.equals("Impacto")){
			return true;
		}
		return false;
   }
	   
   
   
}
