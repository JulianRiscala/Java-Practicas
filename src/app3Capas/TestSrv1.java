package app3Capas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;

import progEnCapas.PersonaDTO;

public class TestSrv1 {
	//Estas son pruebas para probar los servicios
	public static void main(String[] args) throws Exception{
//		Socket s = new Socket("127.0.0.1",5432);
//		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//		DataInputStream dis = new DataInputStream(s.getInputStream());
//		
//		//Solicito servidio codigo 1
//		dos.writeInt(1);
//		System.out.println("Mandé el codigo...");
//		
//		//El server me indica cuantas personas va a enviar.
//		int n = dis.readInt();
//		System.out.println("Me mandó la cantidad de personas...");
//		
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(dis.readUTF());
//		}
//		
//		dis.close();
//		dos.close();
//		s.close();
		
		//Ahora con el ServiceLocator queda asi...
		Collection<PersonaDTO> coll;
		coll = ServiceLocatorTCP.obtenerPersonas();
		for(PersonaDTO dto: coll) {
			System.out.println(dto);
		}
		
	}

}
