package Networking;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObtejoRemotoImple extends UnicastRemoteObject implements ObjetoRemoto {
	
	public ObtejoRemotoImple() throws RemoteException{
		super();
	}
	
	public String obtenerSaludo(String nombre) throws RemoteException{
		return "Hola mundo RMI - " + nombre;
	}
}
