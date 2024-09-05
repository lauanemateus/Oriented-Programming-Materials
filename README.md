**Informações básicas de Java**

Para compilar uma classe em java pelo terminal: (obs: tem que estar dentro do pacote)

	`javac codigo.java`
	
Para compilar todas classes de um pacote

 `javac *.java`
	
Para executar uma classe em java pelo terminal:
* 1°: primeiro saia do pacote ( cd .. )
* 2° execute no terminal:
 
	`java codigo`
	
* Para mudar a configuração do Vs Code para aceitar caracteres especiais:
  * `File->Preferences->Settings`
  * Digite encoding e mude de UTF para windows 1252
  * Na hora de compilar os códigos tem que usar a flag -encoding windows-1252. Ex:

`javac -encoding windows-1252 *.java`
	

* Para baixar UMLet no Eclipse:
`Help -> Eclipse Marketplace -> Search -> UMLet > install`

* Abrir UMLet no Eclipse:
`File -> New -> Other -> UMLet diagram`

* JUnit -> testar código em Java
  * https://www.youtube.com/watch?v=FEFaiRGrnRo&t=201s
  * Clicar no botão direito em cima do pacote, selecionar new -> other -> pesquisar junit -> clicar e salvar

* Leitura em Java: https://www.devmedia.com.br/java-como-ler-e-apresentar-dados-com-os-comandos-de-entrada-e-saida/22266

* Não é permitido abrir e reabir mais de uma vez a classe Scanner em Java

* Usando o objeto Calendar em java: https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401 

```
Calendar c = Calendar.getInstance();
c.set(Calendar.DATE, 2);
c.set(Calendar.HOUR_OF_DAY, 1);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);
c.set(Calendar.MONTH, 10); 
c.set(Calendar.YEAR, 1995); 
c.set(Calendar.DAY_OF_WEEK, 20);
```

* Fazer leitura em Java, exemplo:
```Scanner input = new Scanner(System.in);
System.out.print("Escreva a sua matrícula: ");```
String matricula = input.next();

Fazer cobertura de teste:
https://www.youtube.com/watch?v=IIP56wEA1fs
clicar com botão direito no arquivo de teste -> Coverage as -> JUnit Test
