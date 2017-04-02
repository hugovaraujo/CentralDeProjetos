package exceptions;

public class ObtencaoException extends ErroException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor <b>ObtencaoException</b>.
	 * 
	 * @param msg Mensagem relacionada ao objeto.
	 * 
	 */
	public ObtencaoException(String msg){
		super("na obtencao de codigo de projeto: " + msg);
	}
	
}