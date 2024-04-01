package persona;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String Edad;
		String Nombre;
		String Apellido;
		String Nacionalidad;
		MiColeccion<Persona> mc = new MiColeccion<Persona>(5);
		Persona miPersona = new Persona();
		
		System.out.println("Ingrese un nombre o FIN para terminar");
		Nombre = scanner.nextLine();
		
		while ( !Nombre.equalsIgnoreCase("FIN")) {
			//Obtengo los datos
			System.out.println("Ingrese un apellido");
			Apellido = scanner.nextLine();
			System.out.println("Ingrese una edad");
			Edad = scanner.nextLine();
			while (!Edad.matches("\\d+")) {
				System.out.println("La edad solo puede contener numeros! Ingrese nuevamente");
				Edad = scanner.nextLine();
			}
			System.out.println("Ingrese una nacionalidad");
			Nacionalidad = scanner.nextLine();
			
			miPersona = new Persona(Nombre, Apellido, Edad, Nacionalidad);
			mc.insertar(miPersona, 0);
			
			System.out.println("Ingrese un nombre o FIN para terminar");
			Nombre = scanner.nextLine();
		}
		
		Persona aux;
		for (int i = 0; i<mc.cantidad(); i++) {
			aux = mc.obtener(i);
			System.out.println(aux);
		}
			
	}

}
