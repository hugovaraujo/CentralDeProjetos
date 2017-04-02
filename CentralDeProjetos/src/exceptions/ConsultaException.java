package exceptions;



public class ConsultaException extends ErroException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor <b>ConsultaException</b>.
	 * 
	 * @param msg Mensagem relacionada ao objeto.
	 * 
	 */
	public ConsultaException(String msg){
		super("na consulta " + msg);
	}
	
}
