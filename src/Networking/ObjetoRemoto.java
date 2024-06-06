package Networking;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface  ObjetoRemoto extends Remote  {
	public String obtenerSaludo(String nombre) throws RemoteException;
}
