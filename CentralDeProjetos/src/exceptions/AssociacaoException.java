package exceptions;

public class AssociacaoException extends ErroException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor <b>AssociacaoException</b>.
	 * 
	 * 
	 */
	public AssociacaoException(String msg) {
		super("na associacao de pessoa a projeto: " + msg);
	}
}
