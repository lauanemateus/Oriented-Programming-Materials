package arquivo;

/**
 * LEIA-ME ANTES DE USAR * 
 *  Este código visa demonstrar diversos processos de leitura e escrita de arquivos.
 * O‰ um material complementar ao slide, portanto as funções complementam o material
 * mostrado lá. Antes de rodar o código, verifique na função main qual exemplo você
 * quer executar. Lembre-se também de verificar a existência e o estado dos arquivos
 * na pasta raiz do seu projeto, já que para rodar os exemplos, alguns arquivos 
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
	 * Neste exemplo, vemos o uso da classe File e seus métodos.
	 * A File é usada para criar referências para arquivos OU pastas.
	 * Ao chamarmos seu construtor, não estamos criando o conteúdo,
	 * apenas apontando pra ele. O que significa que pode não existir
	 * ou seja, ainda estão para ser criado.
	 */
	public static void exemplo1() {
		File pasta = new File("nova_pasta"); // Referencia um arquivo ou pasta na raiz desse projeto, chamado "nova_pasta"
		
		if ( !pasta.exists() || !pasta.isDirectory() ) { // Confirma que a pasta ainda não existe e nem é um diretório
			pasta.mkdir(); // Aqui cria-se de fato uma pasta.
			System.out.println("Não encontrei esta pasta então criei uma em " + pasta.getAbsolutePath() ); 
			// Veja no absolutePath o caminho completo para o seu projeto e onde os arquivos deste cÃ³gido serÃ£o criados.
		}

		// Criamos mais duas referências para arquivos. Com esta aqui, criamos uma pasta.
		// Note que estamos usando um segundo construtor de File, este espera como primeiro
		// parâmetro o "parent", ou seja, a pasta onde estarão contido o arquivo ou pasta.
		File outraPasta = new File(pasta, "outra_pasta");
		outraPasta.mkdir(); // Aqui cria-se de fato outra pasta.
		
		// Com esta aqui, criamos de fato um arquivo. O processo de criar arquivos pode demandar
		// Permissões especiais do SO, por isso lança uma IOException.
		File umArquivo = new File(pasta, "meu_arquivo.txt");
		try {
			umArquivo.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Obtem-se a lista do conteúdo interno da nova_pasta
		String[] conteudoDaPasta = pasta.list();
		for (String coisas: conteudoDaPasta)
			System.out.println(coisas);
	}
	
	/**
	 * Neste exemplo, precisamos que exista um arquivo.txt na raiz do projeto para 
	 * podermos lê-lo. Fazemos nosso primeiro uso de InputStream (o fluxo de dados
	 * recebido em bytes) e InputStreamReader (a classe que nos ajuda a ler pelo
	 * menos uma sequência de caractéres em um arquivo). De cara, há um trabalho 
	 * extra necessário para se tratar das exceções. O construtor de FileInputStram
	 * usa da string "arquivo.txt" para criar um File, mas se não consegue achar
	 * este arquivo, lança uma FileNotFoundException. Mais adiante, ao tentarmos ler
	 * um dado com leitor.read(), precisamos tratar de uma IOException. Para evitar
	 * mais trys dentro de trys, podemos simplesmente concatenar os catches no mesmo
	 * try. A única exceção o caso do finally, onde queremos garantir que os recursos
	 * usados foram fechados. Para isso ser possível, precisamos incializar os objetos 
	 * como nulos fora do try e ainda de quebra fazer mais um try catch, pois o mÃ©todo
	 * close também lança IOException.
	 */
	public static void exemplo2() {
		
		// Deixamos nosso fluxo e leitor declarados aqui para poder referenciá-los no finally.
		InputStream fluxo = null;
		InputStreamReader leitor = null;
		
		try {
			
			// Aqui construímos o fluxo, que nos fornece um canal de leitura bruto em bytes.
			// Internamente ele cria um File a partir da string passada como nome ou caminho
			// do arquivo.
			fluxo = new FileInputStream("arquivo.txt");
			
			// O leitor recebe o fluxo para poder fazer seu trabalho de processar os dados de
			// uma forma mais inteligível para nós. Com ele conseguimos acessar os bytes navegando
			// por caracteres, já que a cada chamada de read, um cursor interno Ã© incrementado.
			leitor = new InputStreamReader(fluxo);
			
			char c = (char) leitor.read();
			 // Se fosse int c = leitor.read();, como no início do exemplo, vejão o valor do caractere na Unicode.
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
	 * Este exemplo é um complemento ao exemplo anterior. Desta
	 * vez, estamos utilizando uma "camada extra" de leitura de
	 * dados. O leitorComBuffer, faz um trabalho extra, usando o
	 * leitor que lhe é passado no seu construtor para nos oferecer
	 * métodos mais poderosos de leitura de dados como o readLine().
	 */
	public static void exemplo3() {
		
		InputStream fluxo = null;
		InputStreamReader leitor = null;
		BufferedReader leitorComBuffer = null;
		
		try {
			fluxo = new FileInputStream("arquivo.txt");
			leitor = new InputStreamReader(fluxo);
			// Note aqui o uso do padrão Decorator, onde um leitor possui um leitor, que possui fluxo, que possui um arquivo...
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
	 * Neste exemplo fazemos uma pequena modificações ao exemplo 3. 
	 * Ao invés de passarmos um InputStream criado a partir de um
	 * arquivo como fonte de dados para o leitor, passamos a fonte
	 * de dados de entrada padrão do Java: o System.in, que vem a
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
	 * Neste exemplo mostramos como de maneira análoga aos exemplos anteriores
	 * podemos fazer uma escrita em arquivo usando as classes de OutputStream
	 * e Writer. Com algumas diferenças como a necessidade de se chamar o método
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
			
			escritorComBuffer.write("Olá, tudo bem?");
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
	 * Para fechar, temos um exemplo um pouco mais avançado que demonstra o uso
	 * dos Streams para uma operação usando apenas a leitura e escrita de dados
	 * em bytes. Nem sempre precisamos dos escritores e leitores para caracteres,
	 * pois podem haver situações como essas onde o processamento pode ser feito
	 * diretamente em bytes, o que é mais eficiente. Neste exemplo, estamos fazendo
	 * uma cópia do conteúdo de um arquivo para outro. Todos os bytes existentes do
	 * entrada.doc serão enviados para o saida.doc, fazendo uma cópia exata. Note 
	 * que aqui estamos falando de bytes, portanto não importa o formato do arquivo
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
	        	// Percorre byte a byte o arquivo de entrada, para escrever o mesmo byte no de saída.
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
