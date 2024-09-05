package arquivo;

/**
 * LEIA-ME ANTES DE USAR * 
 *  Este c�digo visa demonstrar diversos processos de leitura e escrita de arquivos.
 * O� um material complementar ao slide, portanto as fun��es complementam o material
 * mostrado l�. Antes de rodar o c�digo, verifique na fun��o main qual exemplo voc�
 * quer executar. Lembre-se tamb�m de verificar a exist�ncia e o estado dos arquivos
 * na pasta raiz do seu projeto, j� que para rodar os exemplos, alguns arquivos 
 * existir ou serem criados.
 * 
 */
import java.io.*;

public class Arquivos {
	
	/*
	 * Comente e descomente aqui o exemplo que deseja executar. 
	 * Recomendo usar um de cada vez.
	 */
	public static void main(String args[]) {
		exemplo1();
		//exemplo2();
		//exemplo3();
		//exemplo4();
		//exemplo5();
		//exemplo6();
	}
	
	/*
	 * Neste exemplo, vemos o uso da classe File e seus m�todos.
	 * A File � usada para criar refer�ncias para arquivos OU pastas.
	 * Ao chamarmos seu construtor, n�o estamos criando o conte�do,
	 * apenas apontando pra ele. O que significa que pode n�o existir
	 * ou seja, ainda est�o para ser criado.
	 */
	public static void exemplo1() {
		File pasta = new File("nova_pasta"); // Referencia um arquivo ou pasta na raiz desse projeto, chamado "nova_pasta"
		
		if ( !pasta.exists() || !pasta.isDirectory() ) { // Confirma que a pasta ainda n�o existe e nem � um diret�rio
			pasta.mkdir(); // Aqui cria-se de fato uma pasta.
			System.out.println("N�o encontrei esta pasta ent�o criei uma em " + pasta.getAbsolutePath() ); 
			// Veja no absolutePath o caminho completo para o seu projeto e onde os arquivos deste cógido serão criados.
		}

		// Criamos mais duas refer�ncias para arquivos. Com esta aqui, criamos uma pasta.
		// Note que estamos usando um segundo construtor de File, este espera como primeiro
		// par�metro o "parent", ou seja, a pasta onde estar�o contido o arquivo ou pasta.
		File outraPasta = new File(pasta, "outra_pasta");
		outraPasta.mkdir(); // Aqui cria-se de fato outra pasta.
		
		// Com esta aqui, criamos de fato um arquivo. O processo de criar arquivos pode demandar
		// Permiss�es especiais do SO, por isso lan�a uma IOException.
		File umArquivo = new File(pasta, "meu_arquivo.txt");
		try {
			umArquivo.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Obtem-se a lista do conte�do interno da nova_pasta
		String[] conteudoDaPasta = pasta.list();
		for (String coisas: conteudoDaPasta)
			System.out.println(coisas);
	}
	
	/**
	 * Neste exemplo, precisamos que exista um arquivo.txt na raiz do projeto para 
	 * podermos l�-lo. Fazemos nosso primeiro uso de InputStream (o fluxo de dados
	 * recebido em bytes) e InputStreamReader (a classe que nos ajuda a ler pelo
	 * menos uma sequ�ncia de caract�res em um arquivo). De cara, h� um trabalho 
	 * extra necess�rio para se tratar das exce��es. O construtor de FileInputStram
	 * usa da string "arquivo.txt" para criar um File, mas se n�o consegue achar
	 * este arquivo, lan�a uma FileNotFoundException. Mais adiante, ao tentarmos ler
	 * um dado com leitor.read(), precisamos tratar de uma IOException. Para evitar
	 * mais trys dentro de trys, podemos simplesmente concatenar os catches no mesmo
	 * try. A �nica exce��o o caso do finally, onde queremos garantir que os recursos
	 * usados foram fechados. Para isso ser poss�vel, precisamos incializar os objetos 
	 * como nulos fora do try e ainda de quebra fazer mais um try catch, pois o método
	 * close tamb�m lan�a IOException.
	 */
	public static void exemplo2() {
		
		// Deixamos nosso fluxo e leitor declarados aqui para poder referenci�-los no finally.
		InputStream fluxo = null;
		InputStreamReader leitor = null;
		
		try {
			
			// Aqui constru�mos o fluxo, que nos fornece um canal de leitura bruto em bytes.
			// Internamente ele cria um File a partir da string passada como nome ou caminho
			// do arquivo.
			fluxo = new FileInputStream("arquivo.txt");
			
			// O leitor recebe o fluxo para poder fazer seu trabalho de processar os dados de
			// uma forma mais intelig�vel para n�s. Com ele conseguimos acessar os bytes navegando
			// por caracteres, j� que a cada chamada de read, um cursor interno é incrementado.
			leitor = new InputStreamReader(fluxo);
			
			char c = (char) leitor.read();
			 // Se fosse int c = leitor.read();, como no in�cio do exemplo, vej�o o valor do caractere na Unicode.
			System.out.println(c);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Este exemplo � um complemento ao exemplo anterior. Desta
	 * vez, estamos utilizando uma "camada extra" de leitura de
	 * dados. O leitorComBuffer, faz um trabalho extra, usando o
	 * leitor que lhe � passado no seu construtor para nos oferecer
	 * m�todos mais poderosos de leitura de dados como o readLine().
	 */
	public static void exemplo3() {
		
		InputStream fluxo = null;
		InputStreamReader leitor = null;
		BufferedReader leitorComBuffer = null;
		
		try {
			fluxo = new FileInputStream("arquivo.txt");
			leitor = new InputStreamReader(fluxo);
			// Note aqui o uso do padr�o Decorator, onde um leitor possui um leitor, que possui fluxo, que possui um arquivo...
			leitorComBuffer = new BufferedReader(leitor); 
			
			String linha = leitorComBuffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = leitorComBuffer.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				leitorComBuffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Neste exemplo fazemos uma pequena modifica��es ao exemplo 3. 
	 * Ao inv�s de passarmos um InputStream criado a partir de um
	 * arquivo como fonte de dados para o leitor, passamos a fonte
	 * de dados de entrada padr�o do Java: o System.in, que vem a
	 * ser o fluxo de dados oriundos do teclado. Isso faz com que 
	 * este leitorComBuffer passe a se comportar de maneira similar
	 * ao nosso conhecido Scanner.
	 */
	public static void exemplo4() {
		InputStreamReader leitor = null;
		BufferedReader leitorComBuffer = null;

		try {
			leitor = new InputStreamReader(System.in);
			leitorComBuffer = new BufferedReader(leitor);
			String linha = leitorComBuffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = leitorComBuffer.readLine();
			}

		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				leitor.close();
				leitorComBuffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Neste exemplo mostramos como de maneira an�loga aos exemplos anteriores
	 * podemos fazer uma escrita em arquivo usando as classes de OutputStream
	 * e Writer. Com algumas diferen�as como a necessidade de se chamar o m�todo
	 * flush() para que a escrita de fato ocorra no arquivo.
	 */
	public static void exemplo5() {
		OutputStream fluxo = null;
		OutputStreamWriter escritor = null;
		BufferedWriter escritorComBuffer = null;
		
		try {
			fluxo = new FileOutputStream("arquivo.txt");
			escritor = new OutputStreamWriter(fluxo);
			escritorComBuffer = new BufferedWriter(escritor);
			
			escritorComBuffer.write("Ol�, tudo bem?");
			escritorComBuffer.flush();
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fluxo.close();
				escritor.close();
				escritorComBuffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Para fechar, temos um exemplo um pouco mais avan�ado que demonstra o uso
	 * dos Streams para uma opera��o usando apenas a leitura e escrita de dados
	 * em bytes. Nem sempre precisamos dos escritores e leitores para caracteres,
	 * pois podem haver situa��es como essas onde o processamento pode ser feito
	 * diretamente em bytes, o que � mais eficiente. Neste exemplo, estamos fazendo
	 * uma c�pia do conte�do de um arquivo para outro. Todos os bytes existentes do
	 * entrada.doc ser�o enviados para o saida.doc, fazendo uma c�pia exata. Note 
	 * que aqui estamos falando de bytes, portanto n�o importa o formato do arquivo
	 * poderia ser .mp3, .pdf, .odt...
	 */
	public static void exemplo6() {
		File arquivoDeEntrada = new File("entrada.doc");
        File arquivoDeSaida = new File("saida.doc ");
        FileInputStream fluxoDeEntrada = null;
        FileOutputStream fluxoDeSaida = null;
        
		try {
			fluxoDeEntrada = new FileInputStream(arquivoDeEntrada);
			
			if ( !arquivoDeSaida.exists() )
				arquivoDeSaida.createNewFile();
			
			fluxoDeSaida = new FileOutputStream(arquivoDeSaida);
	        
	        int c;
	        while ( (c = fluxoDeEntrada.read()) != -1 ) { 
	        	// Percorre byte a byte o arquivo de entrada, para escrever o mesmo byte no de sa�da.
	             fluxoDeSaida.write(c);
	        }
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
