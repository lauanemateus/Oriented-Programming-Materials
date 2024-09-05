package Threads;

/*
 *  A aplica��o que cria inst�ncia de Thread deve  fornecer 
 *  o c�digo a ser executado na thread
 *  Implementando a Classe Runnable
 *	Passando um objeto Runnable 
 *  para o construtor  da classe Thread:
 */

public class Thread_Interface implements Runnable {  
public void run() {
	System.out.println("Ol� de uma thread implementada pela interface Runnable!");
}

public static void main(String args[]) {
	(new Thread(new Thread_Interface())).start();
} 
}
