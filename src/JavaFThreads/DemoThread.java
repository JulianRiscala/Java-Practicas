package JavaFThreads;

//public class DemoThread extends Thread { // Esto esta bien, pero es mejor si implementamos la interface Runnable que implementa la clase Thread, permite mayor flexibilidad
public class DemoThread implements Runnable {
	
	private String Nombre;
	
	public DemoThread(String nombre) {
		this.Nombre = nombre;
	}
	
	public void run(){
		try {
			int x = (int) (Math.random()*5000);
			Thread.sleep(x);
			System.out.println("Soy: " + this.Nombre + " (" + x + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		DemoThread t1 = new DemoThread("Julian");
//		DemoThread t2 = new DemoThread("Elio");
//		DemoThread t3 = new DemoThread("Gabriela");
		//Esto ya no sirve...		
		
		Thread t1 = new Thread(new DemoThread("Julian"));
		Thread t2 = new Thread(new DemoThread("Elio"));
		Thread t3 = new Thread(new DemoThread("Gabriela"));
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Arrancan...");
		//Con esto vamos a esperar que finalicen los threads
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Final del programa!");
	}

}
