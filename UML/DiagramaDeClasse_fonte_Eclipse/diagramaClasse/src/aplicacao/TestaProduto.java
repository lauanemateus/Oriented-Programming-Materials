package aplicacao;

import exemplo.Produto;

public class TestaProduto {

	public static void main(String[] args){
			
		
	    Produto p1 = new Produto("PC", 5009.0, 2); 
	    Produto p2 = new Produto("Teclado", 100.0, 5);
	    Produto p3 = new Produto("Smartphone", 1500.0, 20);
		

		double totalP1 = p1.total();
		System.out.println(totalP1);
		p1.adicionar(3);
		p1.remover(2);
		double totalP2 = p2.total();
		System.out.println(totalP2);
		p2.adicionar(4);
		p2.remover(3);
		
		double totalP3 = p3.total();
		System.out.println(totalP3);
		p3.adicionar(10);
		p3.remover(40);
	} //fim método main
} // fim classe TestaProduto
