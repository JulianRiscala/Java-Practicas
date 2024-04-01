package interfaces;

import interfaces.criterio.Criterio;

public class Util {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void ordenar(Comparable arr[]) {
		boolean ordenado = false;
		while (!ordenado) {
			ordenado = true;
			for (int i = 0; i<arr.length-1; i++) {
				if (arr[i+1].compareTo(arr[i]) < 0) {
					Comparable aux = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = aux;
					ordenado = false;
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void ordenarPorCriterio (Object arr[], Criterio cr) {
		
		boolean ordenado = false;
		while (!ordenado) {
			ordenado = true;
			for( int i = 0; i<arr.length-1; i++) {
				//Ahora la decision sobre quien precede a quien la toma la instancia de Criterio cr
				if (cr.comparar(arr[i+1], arr[i]) < 0) {
					Object aux = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = aux;
					ordenado = false;
				}
			}
		}
	}
	
	public static void Imprimir(Object arr[]) {
		for (int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
