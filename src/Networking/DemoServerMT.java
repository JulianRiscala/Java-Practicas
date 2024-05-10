package Networking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServerMT {

	public static void main(String[] args) throws Exception {
		Socket s = null;
		ServerSocket ss = new ServerSocket(5432);
		
		while (true) {
			try {
				// Serversocket me da el socket
				s = ss.accept();
				//instancio un Thread
				(new Tarea(s)).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Tarea extends Thread{
		private Socket s = null;
		private ObjectInputStream ois = null;
		private ObjectOutputStream oos = null;
		
		public Tarea (Socket socket) {
			this.s = socket;
		}
		
		public void run() {
			try {
				//Informacion en la consola
				System.out.println("Se conectaron desde la IP: " + s.getInetAddress());
				
				//enmascaro la entrada y salida de bytes
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				
				//Leo el nombre que envia el cliente
				String nom = (String)ois.readObject();
				
				//Armo el saludo personalizado
				String saludo = "Hola Mundo (" + nom + ") _ " + System.currentTimeMillis();
				
				//Envio el saludo al cliente
				oos.writeObject(saludo);
				System.out.println("Saludo enviado...");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (oos != null) oos.close();
					if (ois != null) ois.close();
					if (s != null) s.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}

