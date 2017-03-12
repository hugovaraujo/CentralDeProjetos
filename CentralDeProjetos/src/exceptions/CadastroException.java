package exceptions;

public class CadastroException extends ErroException  {

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
	public CadastroException(String msg){
		super("no cadastro " + msg );
	}
	
}