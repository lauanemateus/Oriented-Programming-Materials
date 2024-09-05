package pacoteFTS;

import java.util.Scanner;
public class MudoAnimal {
	 static int tipo = -1; //inicializado com um tipo que não existe
	 static Scanner sc = new Scanner(System.in);
	 static boolean flag = false;
	 
	public static void verifica() {
     while (flag == false) {
	     System.out.print("Digite 0 - Peixe, 1 - Mamífero, 2 - Sair:");
	     tipo = sc.nextInt();
	     System.out.println("tipo = " + tipo);
	     if ((tipo < 0) || (tipo > 2)) {
		    	  System.out.println("Número fora da faixa permitida.");
			      System.out.println("Entre com um número entre 0 e 2");
			   } 
		 else  { flag = true;   
		      		}  // fim if
		   } // fim flag
    
    } //fim método verifica
    
	public static void main (String args[]) {
		   Animal reino[];
		  
		   int limite = 100;
		   String nome;
		   reino = new Animal[limite];
		   reino[0] = new Peixe("");
		   reino[1] = new Mamifero("");
		   
		   System.out.println("Nome: Fulano de Tal e Silva");
		   System.out.println("Matrícula: 202301777");
		  		  
		   
			verifica();
			   
		   while (tipo != 2) {
			   
			   System.out.print("Entre com o nome do animal: ");
			   nome = sc.nextLine();
			   System.out.print("\n");
			   
			  // System.out.println("tipo = " + tipo);
			  // System.out.println("nome = " + nome);
			   switch (tipo) {
			   		case 1:
			   			reino[tipo] =  new Peixe(nome);
			   			break;
			 	   default:
			 		   reino[tipo] =   new Mamifero(nome);
			   } // fim switch
			   	limite++; 
			   	verifica();
			 } // fim while
		  
		   System.out.println("Sai do While"); 
		  
		   if (tipo == 2) { 
			   System.out.println("Usuário pediu para sair!"); 
			   System.out.println("Fim de Programa!"); 
			  } 
		   else {
		    for (int  i = 0; i < limite; i++) {
			   if (reino[i] instanceof Peixe) {
				   System.out.println("O nome do Peixe é: " 
			        +   ( (Peixe) reino[i]).getNome());
			       }// fim if
			   
			   if (reino[i] instanceof Mamifero) {
				   System.out.println("O nome do mamífero é: " 
			        +   ( (Mamifero) reino[i]).getNome());
			   }
		   }// fim for
		   } // fim else if 
		 } // fim método main

} // fim classe 
