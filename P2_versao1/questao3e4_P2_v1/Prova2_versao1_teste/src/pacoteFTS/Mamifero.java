package pacoteFTS;

public class Mamifero extends Animal {

	public Mamifero (String nome) {
		   super(nome);
		}

		public void mover (int x, int y) {
			setCoordenadas(x, y);
			System.out.println("Movimento t�pico do Mam�fero.");
		  }


}
