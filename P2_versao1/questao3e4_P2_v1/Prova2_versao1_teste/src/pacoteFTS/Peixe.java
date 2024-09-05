package pacoteFTS;
public class Peixe extends Animal {

public Peixe (String nome) {
   super(nome);
}

public void mover (int x, int y) {
	setCoordenadas(x, y);
	System.out.println("Movimento de nado do Peixe.");
  }

}