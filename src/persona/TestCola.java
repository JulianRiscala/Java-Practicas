package persona;

public class TestCola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiCola<Integer> c = new MiCola<Integer>();
		
		c.encolar(1);
		c.encolar(2);
		c.encolar(3);
		
		System.out.println(c.desencolar()); // Saca el 1
		System.out.println(c.desencolar()); // Saca el 2
		
		c.encolar(4);
		
		System.out.println(c.desencolar()); // Saca el 3
		System.out.println(c.desencolar()); // Saca el 4
	}

}
