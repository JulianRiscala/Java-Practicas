package JavaFThreads;

import java.util.Iterator;
import java.lang.Thread;

public class DemoThread3 {

	//Aca definimos una inner class que extiende a Thread, en cuyo metodo RUN ejecutamos un FOR que itera 5 veces. 
	//Por cada iteracion mostramos el numero de iteracion y el nombre (Que se recibe como parametro del onstructor) y cedemos (Con el metodo YIELD) el procesador al proximo thread que espera en la cola de listos.
	//Lueo en main instanciamos y ejecutamos dos instancias de MiThread.
	public static void main(String[] args) {
		MiThread t1 = new MiThread("Pablo");
		MiThread t2 = new MiThread("Juan");
		
		//Podemos setear la prioridades las prioridades de los hilos...
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();

		//Entonces vemos como Ahora Pablo se ejecuta y termina antes de invocar a Juan
	}

	static class MiThread extends Thread{
		String nom;
		
		public MiThread(String nom) {
			this.nom = nom;
		}
		
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(nom + " - " + i);
				Thread.yield();
			}
		}
	}
	
}
