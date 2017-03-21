package exceptions;

import java.util.List;

import model.participacao.Participacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;

public class ParticipacaoControllerValidator {
	
	public void validaAssociaProfessor(Pessoa pessoa, Projeto projeto, int qntHoras, double valorHora, List<Participacao> participacoes) throws Exception{
		
		if (pessoa == null) {
			throw new Exception("Erro na associacao de pessoa a projeto: Pessoa nao encontrada");
		}
		if (projeto == null) {
			throw new Exception("Erro na associacao de pessoa a projeto: Projeto nao encontrado");
		}
		if(qntHoras < 1){
			throw new Exception("Erro na associacao de pessoa a projeto: Quantidade de horas invalida");
		}
		if(valorHora < 0){
			throw new Exception("Erro na associacao de pessoa a projeto: Valor da hora invalido");
		}
		if(projeto.getTipo().equals("Monitoria"))
			if(valorHora!=0)
				throw new Exception("Erro na associacao de pessoa a projeto: Valor da hora de um professor da monitoria deve ser zero");
		
		for (Participacao participacao : participacoes) {
			
			if(participacao.getProjeto().equals(projeto)){
				if((participacao.getTipo().equals("ProfessorParticipacao"))&&(projeto.getTipo().equals("Monitoria")))
					throw new Exception("Erro na associacao de pessoa a projeto: Monitoria nao pode ter mais de um professor");
				else if((participacao.getTipo().equals("ProfessorParticipacao"))&&(projeto.getTipo().equals("PED")))
					throw new Exception("Erro na associacao de pessoa a projeto: Projetos P&D nao podem ter mais de um professor");
			}		
		}
	}
	
	public void validaAssociaGraduando(Pessoa pessoa, Projeto projeto, List<Participacao> participacoes) throws Exception{
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		for (Participacao participacao : participacoes) {
			
			if(participacao.getProjeto().equals(projeto)){
				if(participacao.getPessoa().equals(pessoa))
					throw new Exception("Erro na associacao de pessoa a projeto: Aluno ja esta cadastrado nesse projeto");
				if((participacao.getTipo().equals("GraduandoParticipacao"))&&(projeto.getTipo().equals("PED")))
					throw new Exception("Erro na associacao de pessoa a projeto: Projetos P&D nao podem ter mais de um graduando");
			}	
			
		}
	}
	
	public void validaAssociaProfissional(Pessoa pessoa, Projeto projeto) throws Exception{
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
	}

	public void validaAssociaPosGraduando(Pessoa pessoa, Projeto projeto) throws Exception {
		
		if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
	}
	
	public void validaRemoveParticipacao(Pessoa pessoa, Projeto projeto, List<Participacao> participacoes) throws Exception{

		if (pessoa == null) {
			throw new Exception("Erro na remocao de participacao: Pessoa nao encontrada");
		}
		if (projeto == null) {
			throw new Exception("Erro na remocao de participacao: Projeto nao encontrado");
		}
		
		boolean jaParticipa = false;
		
		for (Participacao participacao : participacoes) {
			
			if((participacao.getPessoa().equals(pessoa)&&(participacao.getProjeto().equals(projeto))))
				jaParticipa = true;
		}
		if(!jaParticipa)
			throw new Exception("Erro na remocao de participacao: Pessoa nao possui participacao no projeto indicado");
	}

//Testing
}
