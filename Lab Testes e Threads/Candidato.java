public class Candidato {

	String nome;
	int numero;
	int qtde;
	String partido;
	
	Candidato (String nome, int numero, String partido) {
		this.nome = nome;
		this.numero = numero;
		this.partido = partido;
		qtde = 1;
	} 
	
	public void soma() {
		this.qtde++;
	} //fim metodo soma
	
	public boolean achouCandidato(String nome) {
		if (this.nome.equals(nome)) {
			return true;
		} else
			return false;
	} //fim metodo achouCandidato
} //fim Classe Candidato
