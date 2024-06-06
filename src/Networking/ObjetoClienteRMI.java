package Networking;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ObjetoClienteRMI {

	public static void main(String[] args) throws Exception {
		//Obtengo referencia a la registry del servidor(IP + PORT)
		Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
		
		//Ubico el objeto remoto identificado por "OBJRemoto"
		ObjetoRemoto objRemoto;
		objRemoto = (ObjetoRemoto)reg.lookup("OBJRemoto");
		
		//Invoco sus metodos como lo hao con ncualquier objeto
		String saludo = objRemoto.obtenerSaludo("pablo");
		System.out.println(saludo);
	}

}
