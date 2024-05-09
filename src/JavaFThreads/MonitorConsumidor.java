package JavaFThreads;

public class MonitorConsumidor extends Thread{

	private Monitor buff;
	private int n;
	private int sleep;
	
	public MonitorConsumidor (Monitor b, int n, int s) {
		this.buff = b;
		this.n = n;
		this.sleep = s;
	}
	
	public void run() {
		try {
			char c;
			for (int i = 0; i < n; i++) {
				c =	buff.sacar();
				System.out.println("Consumí: " + c);
				sleep((int) (Math.random()*sleep));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
