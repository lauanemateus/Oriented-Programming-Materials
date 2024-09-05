package arquivo1;
import java.io.*;

public class Arquivo_doc {

	public static void main(String args[]) {
		testando_o_arquivo();
	}
	
		public static void testando_o_arquivo() {
			File pasta = new File("pasta"); 
			
			
			if ( !pasta.exists() || !pasta.isDirectory() ) { 
				pasta.mkdir(); 
				System.out.println("Não encontrei esta pasta então criei uma em " + pasta.getAbsolutePath() ); 
				
			}

			
			File outraPasta = new File(pasta, "pasta");
			outraPasta.mkdir(); 
			
			
			File umArquivo = new File(pasta, "arquivo.txt");
			try {
				umArquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			String[] conteudoDaPasta = pasta.list();
			for (String coisas: conteudoDaPasta)
				System.out.println(coisas);
    
	}

}
