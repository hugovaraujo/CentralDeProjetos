package model.projeto.tipos;


import model.projeto.Projeto;
import exceptions.AtualizacaoException;
import exceptions.ConsultaException;
import exceptions.FormatoInvalidoException;
import exceptions.Validator;

public class PED extends Projeto {
	
	private String categoria;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	private Validator verificador = new Validator();
	
	public PED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao){
		
		this.nome = nome;
		this.categoria = categoria;
		this.prodTecnica = prodTecnica;
		this.prodAcademica = prodAcademica;
		this.patentes = patentes;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		
	}

	@Override
	public void editaProjeto(String atributo, String valor) throws AtualizacaoException {
		try {
			int novoValor = 0;
			switch (atributo.toLowerCase()){
			case "nome":
				verificador.verificaString(valor, "Nome");
				setNome(valor);
				break;
				
			case "objetivo":
				verificador.verificaString(valor, "Objetivo");
				setObjetivo(valor);
				break;
				
			case "categoria":
				verificador.verificaCategoria(valor.toUpperCase());
				setCategoria(valor);
				break;
				
			case "producao tecnica":
				verificador.verificaString(valor, "Producao tecnica");
				novoValor = Integer.parseInt(valor);
				verificador.verificaNegativo(novoValor, "Numero de producoes tecnicas");
				setProdTecnica(novoValor);
				break;
				
			case "producao academica":
				verificador.verificaString(valor, "Producoes academica");
				novoValor = Integer.parseInt(valor);
				verificador.verificaNegativo(novoValor, "Numero de producoes academicas");
				setProdAcademica(novoValor);
				break;
				
			case "patentes":
				verificador.verificaString(valor, "Patentes");
				novoValor = Integer.parseInt(valor);
				verificador.verificaNegativo(novoValor, "Numero de patentes");
				setPatentes(novoValor);
				break;
				
			case "data de inicio":
				verificador.verificaString(valor, "Data de inicio");
				verificador.verificaData(valor);
				setDataInicio(valor);
				break;
				
			case "duracao":
				verificador.verificaStringF(valor, "Duracao");
				novoValor = Integer.parseInt(valor);
				verificador.verificaDuracao(novoValor);
				setDuracao(novoValor);
				break;
				
			default:
				throw new FormatoInvalidoException("Atributo nulo ou invalido");
			}
		} catch (Exception e) {
			throw new AtualizacaoException("de projeto: " + e.getMessage());
		}
	}
	
	
	@Override
	public String getInfoProjeto(String atributo) throws ConsultaException{
		switch (atributo.toLowerCase()){
		case "nome":
			return getNome();
		case "categoria":
			return getCategoria();
		case "producao tecnica":
			return String.valueOf(getProdTecnica());
		case "producao academica":
			return String.valueOf(getProdAcademica());
		case "patentes":
			return String.valueOf(getPatentes());
		case "objetivo":
			return getObjetivo();
		case "data de inicio":
			return getDataInicio();
		case "duracao":
			return String.valueOf(getDuracao());
		default:
			try {
				if (verificador.verificaAtributoContem(atributo)){
					throw new FormatoInvalidoException("PED nao possui " + atributo);
				} else {
					throw new FormatoInvalidoException("Atributo nulo ou invalido");
				}
			} catch (Exception e) {
				throw new ConsultaException("de projeto: " + e.getMessage());
			}

		}
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getProdTecnica() {
		return prodTecnica;
	}
	
	public void setProdTecnica(int prodTecnica) {
		this.prodTecnica = prodTecnica;
	}
	
	public int getProdAcademica() {
		return prodAcademica;
	}
	
	public void setProdAcademica(int prodAcademica) {
		this.prodAcademica = prodAcademica;
	}
	
	public int getPatentes() {
		return patentes;
	}
	
	public void setPatentes(int patentes) {
		this.patentes = patentes;
	}

	@Override
	public String getTipo() {
		
		return "PED";
	}




	
	

}
