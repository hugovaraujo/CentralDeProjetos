package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Set;

import exceptions.PersistenciaException;
import model.projeto.Projeto;

public class ProjetoPersistencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void gerarRelatorio(HashMap<Integer, Projeto> projetos) throws PersistenciaException {

		File file = new File("arquivos_sistema/relatorios/cad_projetos.txt");
		BufferedWriter bw = null;
		int projetosFinalizados = 0;
		int graduandos = 0;
		int posgraduandos = 0;
		int profissionais = 0;

		try {
			
			OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
           
            bw.write("Cadastro de Projetos: "+projetos.size()+" projetos registrados");
            bw.newLine();
            
            Set<Integer> chaves = projetos.keySet();
            int aux = 1;
    		for (Integer chave : chaves){
    			
    			Projeto projeto = projetos.get(chave);
    			
    			graduandos += projeto.getGraduandos();
    			posgraduandos += projeto.getPosGraduandos();
    			profissionais += projeto.getProfissionais();
    			
    			if(!projeto.emAndamento())
    				projetosFinalizados++;
    			
    			bw.write("==> Projeto "+aux+":");
                bw.newLine();
                bw.write(projeto.toString());
                bw.newLine();
                aux++;
 	
    		}
    		
    		bw.write("Total de projetos concluidos: "+projetosFinalizados+" finalizados.");
    		bw.newLine();
    		bw.write("% Participacao da graduacao: "+graduandos);
    		bw.newLine();
    		bw.write("% Participacao da pos-graduacao: "+posgraduandos);
    		bw.newLine();
    		bw.write("% Participacao de profissionais: "+profissionais);
    		    
            bw.close();
        
		} catch (IOException e) { throw new PersistenciaException(e); } catch (ParseException e) {
			e.printStackTrace();
		}
		finally { try { bw.close(); } catch (IOException e) { throw new PersistenciaException(e); }}
		
	}
	
	public void gerarHistoricoColaboracoes(HashMap<Integer, Projeto> projetos, double valorEmCaixa, double valorGasto) throws PersistenciaException{
		
		File file = new File("arquivos_sistema/relatorios/cad_colaboracoes.txt");
		BufferedWriter bw = null;
		double totalColaboracoesAcumulado = 0;

		try {
			
			OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
 
            Set<Integer> chaves = projetos.keySet();
            
            
            bw.write("Historico das colaboracoes: "+"\n");
            bw.newLine();
    		for (Integer chave : chaves){
    			
    			Projeto projeto = projetos.get(chave);

    			double colaboracao = projeto.montanteUASC();
    			totalColaboracoesAcumulado += colaboracao;
    			bw.write("==> Nome: "+projeto.getNome()+"\n"+" Data de inicio: "+projeto.getDataInicio()+"\n"+" Valor colaborado: R$ "+colaboracao+"\n");
                bw.newLine();
    		}
    		
    		bw.write("\n"+"Total acumulado com colaboracoes: R$ "+totalColaboracoesAcumulado);
    		bw.newLine();
    		bw.write("Total gasto: R$ "+valorGasto);
    		bw.newLine();
    		bw.write("Total em caixa: R$ "+valorEmCaixa);
    		
        
		} catch (IOException e) { throw new PersistenciaException(e); }
		finally { try { bw.close(); } catch (IOException e) { throw new PersistenciaException(e); }}		
		
	}

}