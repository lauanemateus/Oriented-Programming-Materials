package Threads;

public class ThreadHeranca extends Thread {  
public void run() {
	System.out.println("Alô herdei da classe thread!");
	}

public static void main(String args[]) {  
	(new ThreadHeranca()).start();
	}
}