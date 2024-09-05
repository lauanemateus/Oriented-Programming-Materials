public class Gerente extends Funcionario{
	private int senha;

Gerente (String nome,String cpf, int senha){
	super(nome,cpf);
	this.senha = senha;
}
}