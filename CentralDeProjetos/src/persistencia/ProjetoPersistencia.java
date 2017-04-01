package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Set;

import model.projeto.Projeto;

public class ProjetoPersistencia {

	public void gerarRelatorio(HashMap<Integer, Projeto> projetos) throws Exception {

		File file = new File("arquivos_sistema/relatorios/cad_projetos.txt");
		BufferedWriter bw = null;

		try {
			
			OutputStream os = new FileOutputStream(file,true);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
           
            bw.write("Cadastro de Projetos: "+projetos.size()+" projetos registrados");
            
            Set<Integer> chaves = projetos.keySet();
            int aux = 1;
    		for (Integer chave : chaves){
    			
    			bw.write("==> Projeto "+aux+":");
                bw.newLine();
                bw.write(projetos.get(chave).toString());
                bw.newLine();
                aux++;
 	
    		}
            
            bw.close();
        
		} catch (IOException e) { throw new Exception(e); }
		finally { try { bw.close(); } catch (IOException e) { throw new Exception(e); }}
		
	}

}