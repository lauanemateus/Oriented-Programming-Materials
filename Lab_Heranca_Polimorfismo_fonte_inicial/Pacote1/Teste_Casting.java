package Pacote1;

public class Teste_Casting {
	
	public static void apresentar (Animal a) {
		/*
		 * Um m�todo que recebe o animal, mostra seu nome 
		 * e o movimenta
		 */
		System.out.println(a.getNome());
		}

	public static void main(String args[]) {
		   
		   Object lista[]; //vetor de objetos
		   lista = new Object[3];
		   
		  
		   lista[0] = new Anfibio("Salamandra");
		   lista[1] = new Ave("Sabi�-laranjeira");
		   lista[2] = new Peixe("Dourado");
		 
		   
		 
		   for (int  i = 0; i < 3; i++) {
			   /*
				 * Antes de chamar o m�todo os objetos s�o transformados 
				 * em animais por casting de objetos
				 */
			apresentar ( (Animal) lista[i] );
			
		    }
		 }

}
