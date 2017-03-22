package exceptions;

import model.projeto.Projeto;

public class ProjetosControllerValidator {
	
	private Validator verificador;
	
	public ProjetosControllerValidator() {
		this.verificador = new Validator();
	}

	
	public void validaAdicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) throws CadastroException{
		
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaString(disciplina, "Disciplina");
			verificador.verificaString(objetivo, "Objetivo");
			verificador.verificaString(periodo, "Periodo");
			verificador.verificaString(dataInicio, "Data de inicio");
			verificador.verificaRendimento(rendimento);
			verificador.verificaPeriodo(periodo);
			verificador.verificaData(dataInicio);
			verificador.verificaDuracao(duracao);
		} catch (Exception e) {
			throw new CadastroException("de projeto: " + e.getMessage());
		}
	}
	
	public void validaAdicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) throws CadastroException{
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaString(objetivo, "Objetivo");
			verificador.verificaStringF(dataInicio, "Data de inicio");
			verificador.verificaImpacto(impacto);
			verificador.verificaData(dataInicio);
			verificador.verificaDuracao(duracao);
		} catch (Exception e) {
			throw new CadastroException("de projeto: " + e.getMessage());
		}
		
	}
	
	public void validaAdicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) throws CadastroException{
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaString(objetivo, "Objetivo");
			verificador.verificaString(dataInicio, "Data de inicio");
			verificador.verificaCategoria(categoria.toUpperCase());
			verificador.verificaNegativo(prodTecnica, "Numero de producoes tecnicas");
			verificador.verificaNegativo(prodAcademica, "Numero de producoes academicas");
			verificador.verificaNegativo(patentes, "Numero de patentes");
			verificador.verificaData(dataInicio);
			verificador.verificaDuracao(duracao);
		} catch (Exception e) {
			throw new CadastroException("de projeto: " + e.getMessage());
		}
	}
	
	
	public void validaAdicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) throws CadastroException{
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaString(objetivo, "Objetivo");
			verificador.verificaString(dataInicio, "Data de inicio");
			verificador.verificaImpacto(impacto);
			verificador.verificaRendimento(rendimento);
			verificador.verificaNegativo(prodTecnica, "Numero de producoes tecnicas");
			verificador.verificaNegativo(prodAcademica, "Numero de producoes academicas");
			verificador.verificaNegativo(patentes, "Numero de patentes");
			verificador.verificaData(dataInicio);
			verificador.verificaDuracao(duracao);
		} catch (Exception e) {
			throw new CadastroException("de projeto: " + e.getMessage());
		}
	}
	
	public void validaGetInfoProjeto(Projeto projeto) throws ConsultaException{
		try {
			if (projeto == null){
				throw new Exception("Projeto nao encontrado");
			}
		} catch (Exception e) {
			throw new ConsultaException("de projeto: " + e.getMessage());
		}

	}

	
	public void validaContemProjeto(boolean contem) throws CadastroException{
		try {
			if(contem){
				throw new Exception("Projeto ja existe.");
			}
		} catch (Exception e) {
			throw new CadastroException("de projeto: " + e.getMessage());
		}

	}
	
}
