package exceptions;

public class FormatoInvalidoException extends Exception {
	
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
	public FormatoInvalidoException(String msg){
		super(msg +" invalido");
	}

}
