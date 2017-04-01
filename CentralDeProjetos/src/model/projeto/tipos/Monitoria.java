package model.projeto.tipos;


import java.util.ArrayList;

import model.participacao.Participacao;
import model.projeto.Projeto;
import exceptions.AtualizacaoException;
import exceptions.ConsultaException;
import exceptions.ParametroInvalidoException;
import exceptions.Validator;

public class Monitoria extends Projeto {
	
	private int rendimento;
	private String disciplina;
	private String periodo;
	private Validator verificador = new Validator();
	
	public Monitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio,int duracao){
		this.nome = nome;
		this.disciplina = disciplina;
		this.periodo = periodo;
		this.rendimento = rendimento;
		this.objetivo = objetivo;
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
				
			case "disciplina":
				verificador.verificaStringF(valor, "Disciplina");
				setDisciplina(valor);
				break;
				
			case "periodo":
				verificador.verificaString(valor, "Periodo");
				verificador.verificaPeriodo(valor);
				setPeriodo(valor);
				break;
				
			case "rendimento":
				verificador.verificaString(valor, "Rendimento");
				novoValor = Integer.parseInt(valor);
				verificador.verificaRendimento(novoValor);
				setRendimento(novoValor);
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
		case "disciplina":
			return getDisciplina();
		case "rendimento":
			return String.valueOf(getRendimento());
		case "objetivo":
			return getObjetivo();
		case "periodo":
			return getPeriodo();
		case "data de inicio":
			return getDataInicio();
		case "duracao":
			return String.valueOf(getDuracao());
		default:
			try {
				if (verificador.verificaAtributoContem(atributo)){
					throw new ParametroInvalidoException("Monitoria nao possui " + atributo);
				} else {
					throw new ParametroInvalidoException("Atributo nulo ou invalido");
				}
			} catch (Exception e) {
				throw new ConsultaException("de projeto: " + e.getMessage());
			}

		}
	}
	
	public int getRendimento() {
		return rendimento;
	}
	
	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String getTipo() {
		
		return "Monitoria";
	}

	@Override
	public double montanteUASC() {
		return 0;
	}



	

}
