package exceptions;

public class RemoverException extends ErroException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor <b>CadastroInvalidoException</b>.
	 * 
	 * @param msg Mensagem relacionada ao objeto.
	 * 
	 */
	public RemoverException(String msg){
		super("ao remover " + msg );
	}
	
}
