package exceptions;

public class ParametroInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor <b>ParametroInvalidoException</b>.
	 * 
	 * @param msg Nome do parametro que é invalido.
	 * 
	 */
	public ParametroInvalidoException(String msg){
		super(msg);
	}

}
