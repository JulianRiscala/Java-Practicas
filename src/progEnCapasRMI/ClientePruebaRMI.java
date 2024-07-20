package progEnCapasRMI;

import java.util.Collection;

public class ClientePruebaRMI {

	public static void main(String[] args) throws Exception {
		//Obtengo una referencia al objeto remoto
		FacadeRemoto f = (FacadeRemoto)ServiceLocatorRMI.lookup("FacadeRemoto");
		
		//invoco un metodo
		Collection<String> sPersonas = f.obtenerPersonas();
		for (String s:sPersonas) {
			System.out.println(s);
		}
		
		//invoco otro metodo
		Collection<String> sUsuarios = f.BuscarXPersona(1);
		for( String s: sUsuarios) {
			System.out.println(s);
		}
	}

}
