package exemplo;
public class Produto{
	private String nome;
	private double preco;
	private int quantidade; 

	//Método Construtor
	public Produto(String nome, double preco, int quantidade){
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public double total(){
		return this.preco * this.quantidade;
	}

	public void adicionar (int quantia) {
		this.quantidade = this.quantidade + quantia;
		System.out.println(this.quantidade);
	}

	public void remover(int quantia){
		if(this.quantidade >= quantia){
			this.quantidade = this.quantidade - quantia;
			System.out.println(this.quantidade);
			}
		else
			System.out.println("Quantidade menor que a quantia passada");
		}
} //fim classe Produto
		