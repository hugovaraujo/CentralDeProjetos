package exceptions;

public class ProjetoPermissao extends Exception{
	
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
	public ProjetoPermissao(String msg){
		super(msg);
	}

}
