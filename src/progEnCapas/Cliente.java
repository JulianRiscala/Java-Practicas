package progEnCapas;

import java.util.*;

public class Cliente {

	public static void main(String[] args) {
		
		//Con el facade terminado, programamos el cliente. Todo el procesamiento de datos lo hace el facade, el Cliente se encarga de tomar y mostrar datos.
		Facade facade = new Facade();
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
	
	private static void _mostrarPersonas(Collection<PersonaDTO> collPersonas) {
		System.out.println("Personas registradas: ");
		System.out.println("--------------------------------------------->");
		for(PersonaDTO per: collPersonas) {
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
