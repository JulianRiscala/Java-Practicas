package Networking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DemoCliente {

	public static void main(String[] args) throws Exception{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Socket s = null;
		
		try {
			//inscancio el server con la IP y el PORT
			s = new Socket("127.0.0.1",5432);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			//Envio el nombre
			oos.writeObject("Pablo");
			
			// recibo la respuesta (El saludo personalizado)
			String ret = (String)ois.readObject();
			
			//Muestro la respuesta que envio el server
			System.out.println(ret + ". Posta funciona!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) ois.close();
			if (oos != null) oos.close();
			if (s != null) s.close();
		}

	}

}
