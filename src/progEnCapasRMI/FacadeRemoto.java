package progEnCapasRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface FacadeRemoto extends Remote {
	public Collection<String> obtenerPersonas() throws RemoteException;
	public Collection<String> BuscarXPersona(int PersonaID) throws RemoteException;
}
