import java.util.Scanner;

public class MainCode {
	public static void main(String[] args) {
		int i, j, k, n, x = 1;
		double totalMor, totalConsumo, consumoMedio;
		System.out.println("testando");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		while (n != 0) {
			Tipo[] v = new Tipo[n];
	        totalMor = 0;
	        totalConsumo = 0;
	        consumoMedio = 0;
	        for (i = 0; i < n; i++) {
	        	v[i] = new Tipo();
	        	v[i].qntMor = input.nextInt();
	        	v[i].consumoTotal = input.nextInt();
	        	v[i].consumopMor = v[i].consumoTotal / v[i].qntMor;
	            totalMor += v[i].qntMor;
	            totalConsumo += v[i].consumoTotal;
	        }
	        for (i = 0; i < n - 1; i++) {
	            for (j = i + 1; j < n; j++) {
	                if (v[i].consumopMor == v[j].consumopMor) {
	                    v[i].qntMor += v[j].qntMor;
	                    for (k = j; k < n-1; k++) {
	                        v[k].consumopMor = v[k + 1].consumopMor;
	                        v[k].consumoTotal = v[k + 1].consumoTotal;
	                        v[k].qntMor = v[k + 1].qntMor;
	                    }
	                    n--;
	                    j--;
	                }
	            }
	        }
	        consumoMedio = totalConsumo / totalMor;
	        ordena(v, n);
	        System.out.println();
	        System.out.println("Cidade# " + x + ":");
	        for (i = 0; i < n; i++) {
	        	System.out.println(v[i].qntMor + "-" + v[i].consumopMor);
	        }
	        System.out.printf("\nConsumo medio: %.2f m3.\n", consumoMedio);
	        x++;
	        n = input.nextInt();
		}
	}
	
	public static void ordena(Tipo []a, int b) {
		int c, d, e;
	    double f;
	    for (c = 0; c < b; c++) {
	        f = a[c].consumopMor;
	        e = c;
	        for (d = 0; d < (b - 1); d++) {
	            if (a[d].consumopMor > f) {
	                f = a[d].consumopMor;
	                e = d;
	                troca(a, c, e);
	            }
	        }
	    }
	}
	
	public static void troca(Tipo []a, int i, int j) {
		System.out.println("trocando "+i +" e "+j);
		Tipo c = new Tipo();
	    c = a[i];
	    a[i] = a[j];
	    a[j] = c;
	}
}