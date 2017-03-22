package exceptions;

public class ErroException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroException(String msg){
		super("Erro " + msg );
	}
	

}
