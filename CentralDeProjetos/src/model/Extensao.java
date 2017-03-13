package model;


import exceptions.CadastroException;
import exceptions.FormatoInvalidoException;
import exceptions.StringInvalidaException;
import exceptions.Verificador;

public class Extensao extends Projeto {
	
	private int impacto;
	private Verificador verificador = new Verificador();

	public Extensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) throws CadastroException, FormatoInvalidoException, StringInvalidaException {
		
		verificador.verificaString(nome, "Nome");
		verificador.verificaString(objetivo, "Objetivo");
		verificador.verificaStringF(dataInicio, "Data de inicio");
		verificador.verificaImpacto(impacto);
		verificador.verificaData(dataInicio);
		verificador.verificaDuracao(duracao);

		
		this.nome = nome;
		this.objetivo = objetivo;
		this.impacto = impacto;
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
		case "impacto":
			verificador.verificaString(valor, "Impacto");
			novoValor = Integer.parseInt(valor);
			verificador.verificaImpacto(novoValor);
			setImpacto(novoValor);
			return true;
		case "data de inicio":
			verificador.verificaStringF(valor, "Data de inicio");
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
		case "objetivo":
			return getObjetivo();
		case "impacto":
			return String.valueOf(getImpacto());
		case "data de inicio":
			return getDataInicio();
		case "duracao":
			return String.valueOf(getDuracao());
		default:
			if (verificador.verificaContem(atributo)){
				throw new FormatoInvalidoException("Extensao nao possui " + atributo);
			} else {
				throw new FormatoInvalidoException("Atributo nulo ou invalido");
			}
		}
	}
	
	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}




	
}
