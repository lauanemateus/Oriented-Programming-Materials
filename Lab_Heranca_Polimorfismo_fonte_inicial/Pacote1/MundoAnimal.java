package Pacote1;

public class MundoAnimal {

public static void main(String args[]) {
   
   Animal animalnaoIdentificado = new Animal();
   Animal reino[];
   reino = new Animal[3];
   reino[0] = new Anfibio("Salamandra");
   reino[1] = new Ave("Sabi�-laranjeira");
   reino[2] = new Peixe("Dourado");
   
   System.out.println("Testando os m�todos mover polim�rificos");
   
   animalnaoIdentificado.mover(0, 0);
   for (int  i = 0; i < 3; i++) {
	reino[i].mover(10, 10);
    }
 }
}