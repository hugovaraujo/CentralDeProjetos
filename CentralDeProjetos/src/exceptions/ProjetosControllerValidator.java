package exceptions;

import model.projeto.Projeto;
import model.projeto.tipos.PED;

public class ProjetosControllerValidator {
	
	private Validator verificador;
	
	public ProjetosControllerValidator() {
		this.verificador = new Validator();
	}

	
	public void validaAdicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) throws CadastroException{
		
		try {
			verificador.verificaString(nome, "Nome");
			verificador.verificaStringF(disciplina, "Disciplina");
			verificador.verificaString(objetivo, "Objetivo");
			verificador.verificaString(periodo, "Periodo");
			verificador.verificaStringF(dataInicio, "Data de inicio");
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
			verificador.verificaStringF(dataInicio, "Data de inicio");
			verificador.verificaCategoria(categoria.toUpperCase());
			verificador.verificaMenorQueZero(prodTecnica, "Numero de producoes tecnicas");
			verificador.verificaMenorQueZero(prodAcademica, "Numero de producoes academicas");
			verificador.verificaMenorQueZero(patentes, "Numero de patentes");
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
			verificador.verificaStringF(dataInicio, "Data de inicio");
			verificador.verificaImpacto(impacto);
			verificador.verificaRendimento(rendimento);
			verificador.verificaMenorQueZero(prodTecnica, "Numero de producoes tecnicas");
			verificador.verificaMenorQueZero(prodAcademica, "Numero de producoes academicas");
			verificador.verificaMenorQueZero(patentes, "Numero de patentes");
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
	
	public void validaAtualizaDespesas(String cod, double montanteBolsas, double montanteCusteio, double montanteCapital) throws AtualizacaoException{
		try {
			verificador.verificaString(cod, "codigo");
			verificador.verificaNegativo(montanteBolsas);
			verificador.verificaNegativo(montanteCapital);
			verificador.verificaNegativo(montanteCusteio);
					
		} catch (Exception e) {
			throw new AtualizacaoException("de projeto: " + e.getMessage());
		}
	}
	
	public void validaAtualizaDespesas(Projeto proj, double montanteBolsas, double montanteCusteio, double montanteCapital) throws AtualizacaoException{
		try {
			if (proj.getTipo().equals("Monitoria") && (montanteCusteio > 0.0 || montanteCapital > 0.0) ){
				throw new ProjetoPermissaoException("projeto do tipo monitoria nao permite despesas de custeio ou capital");
			}
			if (proj.getTipo().equals("PET") && montanteCapital > 0.0){
				throw new ProjetoPermissaoException("projeto do tipo PET nao permite despesas de capital");
			}
			if (proj.getTipo().equals("Extensao") && montanteCapital > 0.0){
				throw new ProjetoPermissaoException("projeto do tipo Extensao nao permite despesas de capital");
			}
			if (proj.getTipo().equals("PED")){
				if (((PED)proj).getCategoria().equals("PIBIC") || ((PED)proj).getCategoria().equals("PIBITI")){
					
					if (montanteBolsas <= 0.0){
						throw new ProjetoPermissaoException("projeto do tipo P&D - PIBIC ou PIBITI deve permitir despesas de bolsas");
					}
					if (montanteCusteio > 0.0 || montanteCapital > 0.0){
						throw new ProjetoPermissaoException("projeto do tipo P&D - PIBIC ou PIBITI nao permite despesas de custeio ou capital");
					}
				}
					
				if (((PED)proj).getCategoria().equals("COOP") && (montanteBolsas <= 0.0 || montanteCusteio <= 0.0 || montanteCapital <= 0.0)){
					throw new ProjetoPermissaoException("projeto do tipo Coop devem possuir todas as despesas");
				}
						
					
				}
					
		} catch (Exception e) {
			throw new AtualizacaoException("de projeto: " + e.getMessage());
		}
	}
	
}
