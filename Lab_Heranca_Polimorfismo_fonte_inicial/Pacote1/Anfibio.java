package Pacote1;

public class Anfibio extends Animal {

public Anfibio (String nome) {
   super(nome);
}

public void mover (int x, int y) {
	setCoordenadas(x, y);
	System.out.println("Movimento típico do Anfíbio.");
  }

}