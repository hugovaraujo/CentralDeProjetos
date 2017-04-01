package exceptions;

public class ParametroInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor <b>StringInvalidaException</b>.
	 * 
	 * @param msg Nome do parametro que é invalido.
	 * 
	 */
	public ParametroInvalidoException(String msg){
		super(msg);
	}

}
