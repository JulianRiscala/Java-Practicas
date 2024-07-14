package app3Capas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;

import progEnCapas.PersonaDTO;
import progEnCapas.UsuarioDTO;

public class TestSrv2 {

	public static void main(String[] args) throws Exception{
//		Socket s = new Socket("127.0.0.1",5432);
//		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//		DataInputStream dis = new DataInputStream(s.getInputStream());
//		
//		//Solicito servicio codigo 2
//		dos.writeInt(2);
//		
//		//Le mando la personaID
//		dos.writeInt(1);
//		
//		//El server me indica cuantas personas va a enviar.
//		int n = dis.readInt();
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(dis.readUTF());
//		}
//		
//		dis.close();
//		dos.close();
//		s.close();
		
		//Ahora con el ServiceLocator queda asi...
		Collection<UsuarioDTO> coll;
		int PersonaID = 1;
		coll = ServiceLocatorTCP.obtenerUsuariosXPersona(PersonaID);
		for(UsuarioDTO dto: coll) {
			System.out.println(dto);
		}
	}

}
