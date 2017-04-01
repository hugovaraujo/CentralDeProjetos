package model.projeto.tipos;


import java.util.ArrayList;

import model.participacao.Participacao;
import model.projeto.Projeto;
import exceptions.AtualizacaoException;
import exceptions.ConsultaException;
import exceptions.ParametroInvalidoException;
import exceptions.Validator;

public class Extensao extends Projeto {
	
	private int impacto;
	private Validator verificador = new Validator();

	public Extensao(String nome, String objetivo, int impacto, String dataInicio, int duracao){
		
		this.nome = nome;
		this.objetivo = objetivo;
		this.impacto = impacto;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.participacoes = new ArrayList<Participacao>();
		
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

			case "impacto":
				verificador.verificaString(valor, "Impacto");
				novoValor = Integer.parseInt(valor);
				verificador.verificaImpacto(novoValor);
				setImpacto(novoValor);
				break;

			case "data de inicio":
				verificador.verificaStringF(valor, "Data de inicio");
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
				throw new ParametroInvalidoException("Atributo nulo ou invalido");
			}
		} catch (Exception e) {
			throw new AtualizacaoException("de projeto: " + e.getMessage());
		}
		
	}
	
	@Override
	public String getInfoProjeto(String atributo) throws ConsultaException {
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
			try {
				if (verificador.verificaAtributoContem(atributo)){
					throw new ParametroInvalidoException("Extensao nao possui " + atributo);
				} else {
					throw new ParametroInvalidoException("Atributo nulo ou invalido");
				}
			} catch (Exception e) {
				throw new ConsultaException("de projeto: " + e.getMessage());
			}

		}
	}
	
	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}

	@Override
	public String getTipo() {
		
		return "Extensao";
	}

	@Override
	public double montanteUASC() {
		double percentual = 0.1;
		if (despesas.getMontanteCapital() <= 10000.0 && despesas.getMontanteCusteio() <= 10000.0) {
			return 0;
		}
		if (impacto > 0) {
			percentual -= impacto*(0.005);
		}
		
		return custoTotal() * percentual;
	}




	
}
