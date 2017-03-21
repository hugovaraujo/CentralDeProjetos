package model.projeto.tipos;


import model.projeto.Projeto;
import exceptions.CadastroException;
import exceptions.FormatoInvalidoException;
import exceptions.StringInvalidaException;
import exceptions.Verificador;

public class Monitoria extends Projeto {
	
	private int rendimento;
	private String disciplina;
	private String periodo;
	private Verificador verificador = new Verificador();
	
	public Monitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio,int duracao) throws CadastroException, FormatoInvalidoException, StringInvalidaException {
		verificador.verificaString(nome, "Nome");
		verificador.verificaString(disciplina, "Disciplina");
		verificador.verificaString(objetivo, "Objetivo");
		verificador.verificaString(periodo, "Periodo");
		verificador.verificaString(dataInicio, "Data de inicio");
		verificador.verificaRendimento(rendimento);
		verificador.verificaPeriodo(periodo);
		verificador.verificaData(dataInicio);
		verificador.verificaDuracao(duracao);
		
		
		this.nome = nome;
		this.disciplina = disciplina;
		this.periodo = periodo;
		this.rendimento = rendimento;
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
			
		case "disciplina":
			verificador.verificaStringF(valor, "Disciplina");
			setDisciplina(valor);
			return true;
			
		case "periodo":
			verificador.verificaString(valor, "Periodo");
			setPeriodo(valor);
			verificador.verificaPeriodo(valor);
			return true;
			
		case "rendimento":
			verificador.verificaString(valor, "Rendimento");
			novoValor = Integer.parseInt(valor);
			verificador.verificaRendimento(novoValor);
			setRendimento(novoValor);
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
		case "disciplina":
			return getDisciplina();
		case "redimento":
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
			if (verificador.verificaContem(atributo)){
				throw new FormatoInvalidoException("Monitoria nao possui " + atributo);
			} else {
				throw new FormatoInvalidoException("Atributo nulo ou invalido");
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



	

}
