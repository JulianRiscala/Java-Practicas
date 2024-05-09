package JavaFThreads;

public class MonitorTest {

	public static void main(String[] args) {
		Monitor m = new  Monitor(3);
		MonitorProductor p = new MonitorProductor(m, 6, 2000);
		MonitorConsumidor c = new MonitorConsumidor(m, 6, 4000);
		p.start();
		c.start();

	}

}
