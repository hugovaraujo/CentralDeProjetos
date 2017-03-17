package model;


import exceptions.CadastroException;
import exceptions.FormatoInvalidoException;
import exceptions.StringInvalidaException;
import exceptions.Verificador;

public class PED extends Projeto {
	
	private String categoria;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	private Verificador verificador = new Verificador();
	
	public PED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) throws CadastroException, FormatoInvalidoException, StringInvalidaException {
		verificador.verificaString(nome, "Nome");
		verificador.verificaString(objetivo, "Objetivo");
		verificador.verificaString(dataInicio, "Data de inicio");
		verificador.verificaCategoria(categoria.toUpperCase());
		verificador.verificaNegativo(prodTecnica, "Numero de producoes tecnicas");
		verificador.verificaNegativo(prodAcademica, "Numero de producoes academicas");
		verificador.verificaNegativo(patentes, "Numero de patentes");
		verificador.verificaData(dataInicio);
		verificador.verificaDuracao(duracao);
		
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
	public boolean editaProjeto(String atributo, String valor) throws Exception {
		int novoValor = 0;
		switch (atributo.toLowerCase()){
		case "nome":
			verificador.verificaString(valor, "Nome");
			setNome(valor);
			return true;
		case "objetivo":
			verificador.verificaString(valor, "Objetivo");
			setObjetivo(valor);
			return true;
		case "categoria":
			verificador.verificaCategoria(valor.toUpperCase());
			setCategoria(valor);
			return true;
		case "producao tecnica":
			verificador.verificaString(valor, "Producao tecnica");
			novoValor = Integer.parseInt(valor);
			verificador.verificaNegativo(novoValor, "Numero de producoes tecnicas");
			setProdTecnica(novoValor);
			return true;
		case "producao academica":
			verificador.verificaString(valor, "Producoes academica");
			novoValor = Integer.parseInt(valor);
			verificador.verificaNegativo(novoValor, "Numero de producoes academicas");
			setProdAcademica(novoValor);
			return true;
		case "patentes":
			verificador.verificaString(valor, "Patentes");
			novoValor = Integer.parseInt(valor);
			verificador.verificaNegativo(novoValor, "Numero de patentes");
			setPatentes(novoValor);
			return true;
		case "data de inicio":
			verificador.verificaString(valor, "Data de inicio");
			verificador.verificaData(valor);
			setDataInicio(valor);
			return true;
		case "duracao":
			verificador.verificaStringF(valor, "Duracao");
			novoValor = Integer.parseInt(valor);
			verificador.verificaDuracao(novoValor);
			setDuracao(novoValor);
			return true;
		default:
			throw new FormatoInvalidoException("Atributo nulo ou invalido");
		}
	}
	
	
	@Override
	public String getInfoProjeto(String atributo) throws Exception {
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
			if (verificador.verificaContem(atributo)){
				throw new FormatoInvalidoException("PED nao possui " + atributo);
			} else {
				throw new FormatoInvalidoException("Atributo nulo ou invalido");
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
