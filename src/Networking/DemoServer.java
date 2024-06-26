package Networking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {

	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		Socket s = null;
		ServerSocket ss = new ServerSocket(5432);
		
		while (true) {
			try {
				//El serverSocket me da el socket
				s = ss.accept();
				
				//Informacion en la consulta
				System.out.println("Se conectaron desde la IP: " + s.getInetAddress());
				
				//Enmascaro la entrada y salida de bytes
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				
				//Leo el nombre que envia el cliente
				String nom = (String) ois.readObject();
				
				//Armo el saludo personalizado que le quiero enviar
				String saludo = "Hola Mundo (" + nom + ") _ " + System.currentTimeMillis();
				
				//envio el saludo al cliente
				oos.writeObject(saludo);
				System.out.println("Saludo enviado...");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (oos != null) oos.close();
				if (ois != null) ois.close();
				if (s != null) s.close();
				System.out.println("Conexion cerrada");
			}
		}
	}
}
