package persona;

//Instanciamos una pila de enteros sobre la que apilamos y desapilamos elementos para verificar que los ultimos en apilarse son los primeros que se desapilan

public class TestPila {

	public static void main(String[] args) {
		MiPila<Integer> c = new MiPila<Integer>();
		
		c.apilar(1);
		c.apilar(2);
		c.apilar(3);
		
		System.out.println(c.Desapilar()); //Saca el 3
		System.out.println(c.Desapilar()); //Saca el 2
		
		c.apilar(4);
		
		System.out.println(c.Desapilar()); //Saca el 4
		System.out.println(c.Desapilar()); //Saca el 1

	}

}
