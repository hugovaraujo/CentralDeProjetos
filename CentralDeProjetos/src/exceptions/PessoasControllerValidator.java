package exceptions;

import java.io.Serializable;

public class PessoasControllerValidator implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Validator verificador;
	
	public PessoasControllerValidator(){
		this.verificador = new Validator();
	}
	
	public void validaCadastraPessoa(String cpf, String nome, String email, boolean contem) throws CadastroException{
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaString(cpf, "CPF");
			verificador.verificaString(email, "Email");
			verificador.verificaCpf(cpf);
			verificador.verificaEmail(email);
			if (contem){
				throw new Exception("Pessoa com mesmo CPF ja cadastrada");
			}
		} catch (Exception e) {
			throw new CadastroException("de pessoa: " + e.getMessage());
		}
	}
	
	public void validaEditaPessoa(String cpf, String atributo, String valor, boolean contem) throws AtualizacaoException{
		try {
			verificador.verificaString(cpf, "CPF");
			verificador.verificaCpf(cpf);
			
			if (contem) {
				throw new Exception("Pessoa nao encontrada");
			}
			if(atributo.equalsIgnoreCase("Cpf")){
				throw new Exception("CPF nao pode ser alterado");
			}
			if(atributo.equalsIgnoreCase("Nome")){
				verificador.verificaString(valor, "Nome");
			}
			if(atributo.equalsIgnoreCase("Email")){
				verificador.verificaString(valor, "Email");
				verificador.verificaEmail(valor);
			}
			
			
		} catch (Exception e) {
			throw new AtualizacaoException("de pessoa: " + e.getMessage());
		}
		
	}
	
	public void validaGetInfoPesso(boolean contem) throws ConsultaException{
		if (contem) {
			throw new ConsultaException("de pessoa: Pessoa nao encontrada");
		}
	}
	
	
}
