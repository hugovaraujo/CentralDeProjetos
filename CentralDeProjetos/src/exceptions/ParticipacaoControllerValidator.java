
package exceptions;

import java.util.List;

import model.participacao.Participacao;
import model.participacao.tipos.ProfessorParticipacao;
import model.pessoa.Pessoa;
import model.projeto.Projeto;
import model.projeto.tipos.PED;;

public class ParticipacaoControllerValidator {
	
	public void validaAssociaProfessor(Pessoa pessoa, Projeto projeto, int qntHoras, double valorHora, List<Participacao> participacoes, boolean coordenador) throws Exception{
		
		try {
			if (pessoa == null) {
				throw new Exception("Pessoa nao encontrada");
			}
			if (projeto == null) {
				throw new Exception("Projeto nao encontrado");
			}
			
			if(qntHoras < 1){
				throw new Exception("Quantidade de horas invalida");
			}

			if(projeto.getTipo().equals("Monitoria")){
				if(valorHora>0){
					throw new Exception("Valor da hora de um professor da monitoria deve ser zero");
				}else if (valorHora < 0){
					throw new Exception("Valor da hora invalido");
				}
			} else{
				if(valorHora <= 0 ){
				throw new Exception("Valor da hora invalido");
			}
			}
					
			for (Participacao participacao : participacoes) {
				
				if(participacao.getProjeto().equals(projeto)){
						
					if((participacao.getTipo().equals("ProfessorParticipacao"))&&(projeto.getTipo().equals("Monitoria"))){
						throw new Exception("Monitoria nao pode ter mais de um professor");
					}
						
					else if((participacao.getTipo().equals("ProfessorParticipacao"))&&(projeto.getTipo().equals("PED"))){

						if (((ProfessorParticipacao)participacao).isCoordenador()&&(coordenador))
							throw new Exception("Projetos P&D nao podem ter mais de um coordenador");
						else 
							throw new Exception("Projetos P&D nao podem ter mais de um professor");
					}
						
				}		
			}
			
		} catch (Exception e) {
			throw new AssociacaoException(e.getMessage());
		}
		
	}
	
	public void validaAssociaGraduando(Pessoa pessoa, Projeto projeto, List<Participacao> participacoes) throws AssociacaoException{
		
		try {
			if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
			}
			
			if (projeto == null) {
				throw new Exception("Projeto nao existe");
			}
			
			for (Participacao participacao : participacoes) {
				
				if(participacao.getProjeto().equals(projeto)){
					
					if(participacao.getTipo().equals("GraduandoParticipacao")){
						
						if((participacao.getTipo().equals("GraduandoParticipacao"))&&(projeto.getTipo().equals("PED"))){
							if (((PED)projeto).getCategoria().equals("COOP")){
							
								if (participacao.getPessoa().equals(pessoa)){
									throw new Exception("Aluno ja esta cadastrado nesse projeto");	
							}
							} else {
								throw new Exception("Projetos P&D nao podem ter mais de um graduando");
							}
							
							
						}
							
						if(participacao.getPessoa().equals(pessoa))
							throw new Exception("Aluno ja esta cadastrado nesse projeto");
						
					
					}	
				}
					
				
			}
		} catch (Exception e) {
			throw new AssociacaoException(e.getMessage());
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

	public void validaAssociaPosGraduando(Pessoa pessoa, Projeto projeto) throws AssociacaoException {
		try {
			if (pessoa == null) {
			throw new Exception("Pessoa nao existe");
		}
		if (projeto == null) {
			throw new Exception("Projeto nao existe");
		}
		
		if (projeto.getTipo().equals("PET")|| (projeto.getTipo().equals("Monitoria"))){
			throw new Exception("Tipo de projeto invalido para pos graduando");
		}
		} catch (Exception e) {
			throw new AssociacaoException(e.getMessage());
		}
		
		
	}
	
	public void validaRemoveParticipacao(Pessoa pessoa, Projeto projeto, List<Participacao> participacoes) throws RemocaoException{
		
		try {
			if (pessoa == null) {
			throw new Exception("Pessoa nao encontrada");
			}
			if (projeto == null) {
				throw new Exception("Projeto nao encontrado");
			}
			
			boolean jaParticipa = false;
			
			for (Participacao participacao : participacoes) {
				
				if((participacao.getPessoa().equals(pessoa)&&(participacao.getProjeto().equals(projeto))))
					jaParticipa = true;
			}
			if(!jaParticipa)
				throw new Exception("Pessoa nao possui participacao no projeto indicado");
		} catch (Exception e) {
			throw new RemocaoException("de participacao: " + e.getMessage());
		}

		
	}

//Testing
}
