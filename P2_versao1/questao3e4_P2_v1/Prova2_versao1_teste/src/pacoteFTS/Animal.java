package pacoteFTS;

public class Animal {
private String nome;
private int coordenadaX;
private int coordenadaY;

public Animal (String nome){
    this.nome = nome;
}

public Animal (){
    this.nome = "N�o identificado";
}

public String getNome(){
    return nome;
}

protected void setCoordenadas (int x, int y) {
	coordenadaX = x;
	coordenadaY = y;
}

public void mover (int x, int y) {
System.out.println("O animal se move, mas ainda n�o identificado qual deles.");
}
}