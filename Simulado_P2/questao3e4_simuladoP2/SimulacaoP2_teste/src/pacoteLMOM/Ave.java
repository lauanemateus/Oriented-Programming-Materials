package pacoteFTS;
public class Ave extends Animal {

public Ave(String nome) {
   super(nome);
}

public void mover (int x, int y) {
	setCoordenadas(x, y);
	System.out.println("Movimento típico da Ave.");
  }

}