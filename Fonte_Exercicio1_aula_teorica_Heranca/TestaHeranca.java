public class TestaHeranca{
  public static void main(String [] args){
	 Funcionario f = new Funcionario("Jose","23435678999");
	 Gerente g = new Gerente("Paulo","9949595595",3344);
	 System.out.println("Funcionario: " + f.nome);
	 System.out.println("Gerente: " + g.nome);
	}
}