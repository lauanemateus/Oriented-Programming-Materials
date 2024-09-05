// Lauane Mateus - matrícula 202103747

import java.util.Scanner;

public class Matricula {
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Escreva a sua matrícula: ");
		String matricula = input.next();
		System.out.print("Escreva seu primeiro nome: ");
		String nome = input.next();
		
		System.out.println("\nSua matrícula é " + matricula + " e seu nome é " + nome);
	}
}
