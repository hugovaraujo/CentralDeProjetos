package exceptions;

public class AtualizacaoException extends ErroException{
	
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
	public AtualizacaoException(String msg){
		super("na atualizacao " + msg);
	}
	
}
