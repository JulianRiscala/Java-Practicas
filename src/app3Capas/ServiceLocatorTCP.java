package app3Capas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;

import progEnCapas.PersonaDTO;
import progEnCapas.UsuarioDTO;

// Desarrollamos una clase que se ocupara de encapsular todo el codigo que implica conectarse con el servidor, enviar y recibir informarcion y desconectarse. 
// ServiceLocator tendra tantos métodos estaticos como servicios ofrece el servidor.

//Aca hacemos el trabajo sucio. Esta clase es analoga a la clase UConnection que utilizamos para encapsular el codigo con el que estableciamos la conexion con la base de datos.
// Ahora las pruebas podran tener un codigo mucho mas amigable y el hecho de que este se esté conectando con un servidor a traves de la red pasa a ser casi transparente.
public class ServiceLocatorTCP {

	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 5432;
	
	public static Collection<PersonaDTO> obtenerPersonas() {
		
		Socket s = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			// me conecto
			s = new Socket(SERVER_IP, SERVER_PORT);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			
			//Solicito servicio codigo 1 (ObtenerPersonas)
			dos.writeInt(1);
			
			//El server me indica cuantas personas me va a enviar
			int n = dis.readInt();
			
			Vector<PersonaDTO> ret = new Vector<PersonaDTO>();
			
			String aux;
			for (int i = 0; i<n; i++) {
				
				//Leo el i-esimo string
				aux = dis.readUTF();
				
				//Cada string que recibo, lo convierto a PersonaDTO y lo agrego a la coleccion de retorno
				ret.add(UDto.stringToPersonaDTO(aux));
			}
			return ret;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (dis != null) dis.close();
				if (dos != null) dos.close();
				if (s != null) s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	
	public static Collection<UsuarioDTO> obtenerUsuariosXPersona(int PersonaID){

		Socket s = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			// me conecto
			s = new Socket(SERVER_IP, SERVER_PORT);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			
			//Solicito servicio codigo 1 (ObtenerUsuariosxPersona)
			dos.writeInt(2);
			
			//Envio el ID de la persona
			dos.writeInt(PersonaID);
			
			//El server me indica cuantas personas me va a enviar
			int n = dis.readInt();
			
			Vector<UsuarioDTO> ret = new Vector<UsuarioDTO>();
			
			String aux;
			for (int i = 0; i<n; i++) {
				
				//Leo el i-esimo string
				aux = dis.readUTF();
				
				//Cada string que recibo, lo convierto a PersonaDTO y lo agrego a la coleccion de retorno
				ret.add(UDto.stringToUsuarioDTO(aux));
			}
			return ret;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (dis != null) dis.close();
				if (dos != null) dos.close();
				if (s != null) s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}

}
