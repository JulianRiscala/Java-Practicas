package progEnCapas;

import java.util.Collection;
import java.util.Scanner;

public class ClienteTCP {

	public static void main(String[] args) {
		
		//Este ejemplo de Cliente vamos a hacerlo siguiendo con la interfaz Facade, el programa Cliente literal no se como va  aquedar a partir de aca...
		
		// PAG (260) Como ahora tenemos una interfaz Facade, la instanciamos a traves del factory method
		Facade facade = (Facade)UFactory.GetInstancia("FACADE");
		Collection<PersonaDTO> collPersonas = facade.obtenerPersonas();
		
		//Muestro las peronas
		_mostrarPersonas(collPersonas);
		
		//Pido al usuario que ingrese una persona:
		Scanner in = new Scanner(System.in);
		int PersonaID = in.nextInt();
		
		Collection<UsuarioDTO> collUsuarios = facade.BuscarXPersona(PersonaID);
		
		//Muestro los usuarios segun ID
		_mostrarUsuarios(collUsuarios);
	}
	
	private static void _mostrarPersonas(Collection<PersonaDTO> collPersonasLocal) {
		System.out.println("Personas registradas: ");
		System.out.println("--------------------------------------------->");
		for(PersonaDTO per: collPersonasLocal) {
			System.out.println(per.toString());
		}
		System.out.println("<---------------------------------------------");
		System.out.println("Ingrese un ID: ");
	}
	
	private static void _mostrarUsuarios(Collection<UsuarioDTO> collUsuarios) {
		if (!collUsuarios.isEmpty()) {
			System.out.println("Usuarios: ");
			System.out.println("--------------------------------------------->");
			for(UsuarioDTO per: collUsuarios) {
				System.out.println(per.toString());
			}
			System.out.println("<---------------------------------------------");
		} else System.out.println("No tiene usuarios.");
	}
}
