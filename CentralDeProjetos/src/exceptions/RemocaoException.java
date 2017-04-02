package exceptions;

public class RemocaoException extends ErroException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor <b>RemocaoException</b>.
	 * 
	 * @param msg Mensagem relacionada ao objeto.
	 * 
	 */
	public RemocaoException(String msg){
		super("na remocao " + msg );
	}
	
}
