package arquivo1;
import java.io.*;

public class Arquivo_doc {

	public static void main(String args[]) {
		testando_o_arquivo();
	}
	
		public static void testando_o_arquivo() {
		File arquivoDeEntrada = new File("arquivo1.doc");
        	File arquivoDeSaida = new File("arquivo2.doc");
        	FileInputStream fluxoDeEntrada = null;
        	FileOutputStream fluxoDeSaida = null;
        
		try {
			fluxoDeEntrada = new FileInputStream(arquivoDeEntrada);
			
			if ( !arquivoDeSaida.exists() )
				arquivoDeSaida.createNewFile();
			
			fluxoDeSaida = new FileOutputStream(arquivoDeSaida);
	        
	        int c;
	        while ( (c = fluxoDeEntrada.read()) != -1 ) { 
		             fluxoDeSaida.write(c);
	        }
	        System.out.println("\nTarefa Executada com sucesso.\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fluxoDeEntrada.close();
				fluxoDeSaida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    
	}

}
