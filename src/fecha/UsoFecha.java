package fecha;

import java.util.Scanner;

public class UsoFecha {

	public static void main(String[] args) {
		Fecha F = new Fecha(25,04,23);
		System.out.println(F.toString());
		
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese una nueva fecha");
		System.out.println("Dia: ");
		int dia = in.nextInt();
		System.out.println("Mes: ");
		int mes = in.nextInt();
		System.out.println("Año: ");
		int anio = in.nextInt();
		Fecha OtraF = new Fecha(dia,mes,anio);
		
		if (F.equals(OtraF)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No son iguales");
		}
	}

}
