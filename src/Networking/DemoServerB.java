package Networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServerB {

	private static final int BUFFER_LENGTH = 3;
	//Para respetar un protocolo estandar como un HTTP o un FTP, tendremos que manejarnos a bajo nivel y enviar y recibir Bytes
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Socket s = null;
		ServerSocket ss = new ServerSocket(5432);
		
		while(true) {
			try {
				//Espero la conexion
				System.out.println(s);
				s = ss.accept();
				System.out.println(s);
				//informacion en la consola
				System.out.println("Se conectaron desde la IP: " + s.getInetAddress());
				
				//Enmascaro la entrada y salida de bytes
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				bw = new BufferedWriter(new PrintWriter(s.getOutputStream()));
				
				//Definimos dos dar[], uno sera el buffer para recibir informacion (el nombnre que envia el cliente.
				//El otro buffer para enviar informacion (el saludo personalizado)
				char bEnviar[];
				char bRecibe[] = new char[BUFFER_LENGTH];
				
				StringBuffer sb = new StringBuffer();
				
				//Leo el nombre que envia el cliente, se leé hasta la cantidad de veces BUFFER_LENGTH, y vuelve a repetir si no se leyó el total
				int n;
				while ( (n = br.read(bRecibe)) == BUFFER_LENGTH) {
					sb.append(bRecibe);
				}
				sb.append(bRecibe, 0, n);
				
				//Armo el saludo personalizado que le quiero enviar
				String saludo = "Hola mundo (" + sb + ") _ " + System.currentTimeMillis(); 
				
				//Envio el saludo al cliente
				bEnviar = saludo.toCharArray();
				bw.write(bEnviar);
				bw.flush();
				System.out.println("Saludo enviado...");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bw != null ) bw.close();
				if (br != null ) br.close();
				if (s  != null ) s.close();
				System.out.println("Conexion cerrada");
			}
		}
	}

}
