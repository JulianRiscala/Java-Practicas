package JavaFThreads;

public class MonitorProductor extends Thread {

	private Monitor buff;
	private int n;
	private int sleep;
	
	public MonitorProductor (Monitor b, int n, int s) {
		//El monitor
		this.buff = b;
		
		//Cuantos caracteres debe producir
		this.n = n;
		
		//Cuanto tiempo va a dormir entre caracter y caracter
		this.sleep = s;
	}
	
	public void run() {
		try {
			char c;
			for (int i = 0; i < n; i++) {
				c = (char) ('A' + i);
				buff.poner(c);
				System.out.println("Produje: " + c);
				sleep((int) (Math.random()*sleep));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
