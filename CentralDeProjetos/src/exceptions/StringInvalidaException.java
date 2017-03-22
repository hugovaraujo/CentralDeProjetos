package exceptions;

public class StringInvalidaException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor <b>StringInvalidaException</b>.
	 * 
	 * @param msg Nome do parametro que � nulo ou vazio.
	 * 
	 */
	public StringInvalidaException(String msg){
		super(msg);
	}

	
}
