package Pacote1;
public class Teste_Instanceof {
	public static void main(String args[]) {
		   Animal reino[];
		   reino = new Animal[4];
		   reino[0] = new Anfibio("Salamandra");
		   reino[1] = new Ave("Sabi�-laranjeira");
		   reino[2] = new Peixe("Dourado");
		   reino[3] = new Peixe("Salm�o");
		   
		   System.out.println("Testando o Operador instanceof.");
		 
		   for (int  i = 0; i < 4; i++) {
			   if (reino[i] instanceof Peixe) {
				   System.out.println("O nome do peixe �  " 
			        +   ( (Peixe) reino[i]).getNome());
			   }
		   }
		 }
}
