package interfaces;

public class TestOrdenar {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		
		Alumno arr[] = { new Alumno("Juan",20,8.5),
						 new Alumno("Pedro",18,5.3),
						 new Alumno("Alberto",19,4.6)
		};

		String[] arr2 = { "Pablo","Andres","Marcelo"};
		
		Integer[] arr3 = { new Integer(5),
						   new Integer(9),
						   new Integer(1)};
		
		Util.ordenar(arr);
		muestraArray(arr);
		
		Util.ordenar(arr2);
		muestraArray(arr2);
		
		Util.ordenar(arr3);
		muestraArray(arr3);


	}
	
	@SuppressWarnings("rawtypes")
	private static void muestraArray(Comparable arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
