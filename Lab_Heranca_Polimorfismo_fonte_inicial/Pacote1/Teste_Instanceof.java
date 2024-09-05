package Pacote1;
public class Teste_Instanceof {
	public static void main(String args[]) {
		   Animal reino[];
		   reino = new Animal[4];
		   reino[0] = new Anfibio("Salamandra");
		   reino[1] = new Ave("Sabiá-laranjeira");
		   reino[2] = new Peixe("Dourado");
		   reino[3] = new Peixe("Salmão");
		   
		   System.out.println("Testando o Operador instanceof.");
		 
		   for (int  i = 0; i < 4; i++) {
			   if (reino[i] instanceof Peixe) {
				   System.out.println("O nome do peixe é  " 
			        +   ( (Peixe) reino[i]).getNome());
			   }
		   }
		 }
}
