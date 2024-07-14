package app3Capas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

import progEnCapas.PersonaDAO;
import progEnCapas.PersonaDTO;
import progEnCapas.UFactory;
import progEnCapas.UsuarioDAO;
import progEnCapas.UsuarioDTO;

public class ServerTCP extends Thread {
	
	public static final int OBTENER_PERSONAS = 1;
	public static final int OBTENER_USUARIOS = 2;
	
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	public ServerTCP (Socket s) {
		this.socket = s;
	}
	
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(5432);
		Socket s;
		
		while (true) {
			s = ss.accept();
			new ServerTCP(s).start();
		}
	}
	
	public void run() {
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			int codSvr = dis.readInt();
			System.out.println("Leo el codigo..." + codSvr);
			switch(codSvr) {
				case OBTENER_PERSONAS:
					_obtenerPersonas(dis,dos);
					break;
				case OBTENER_USUARIOS:
					_obtenerUsuarios(dis,dos);
					break;
				default:
					System.out.println("Codigo no reconocido");
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException( "Error en el servidor" + e);
		} finally {
			try {
				if (dos != null) dos.close();
				if (dis != null) dis.close();
				if (socket != null) socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	
	private void _obtenerPersonas(DataInputStream dis, DataOutputStream dos) {
		try {
			PersonaDAO dao = (PersonaDAO) UFactory.GetInstancia("PERSONAS");
			
			//Obtengo la coleccion de personas
			Collection<PersonaDTO> coll = dao.buscarTodos();
			
			//Envio el size al cliente
			int size = coll.size();
			dos.writeInt(size);
			
			//Envio la collecion de Personas
			for (PersonaDTO dto: coll) {
				dos.writeUTF(dto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private void _obtenerUsuarios(DataInputStream dis, DataOutputStream dos) {
		try {
			UsuarioDAO dao = (UsuarioDAO) UFactory.GetInstancia("USUARIOS");
			
			//leo la persona
			int persona = dis.readInt();
			
			//Obtengo la coleccion de usuarios
			Collection<UsuarioDTO> coll = dao.BuscarXPersona(persona);
			
			//Envio el size al cliente
			int size = coll.size();
			dos.writeInt(size);
			
			//Envio la collecion de Personas
			for (UsuarioDTO dto: coll) {
				dos.writeUTF(dto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
