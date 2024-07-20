package progEnCapasRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

import progEnCapas.PersonaDAO;
import progEnCapas.PersonaDTO;
import progEnCapas.UFactory;
import progEnCapas.UsuarioDAO;
import progEnCapas.UsuarioDTO;

public class FacadeRemotoImple extends UnicastRemoteObject implements FacadeRemoto {
	
	public FacadeRemotoImple() throws RemoteException{
		super();
	}
	
	public Collection<String> obtenerPersonas() throws RemoteException{
		PersonaDAO dao = (PersonaDAO) UFactory.GetInstancia("PERSONAS");
		Collection<PersonaDTO> coll = dao.buscarTodos();
		
		Vector<String> ret = new Vector<String>();
		for(PersonaDTO dto: coll) {
			ret.add(dto.toString());
		}
		return ret;
	}
	
	public Collection<String> BuscarXPersona(int PersonaID) throws RemoteException{
		UsuarioDAO dao = (UsuarioDAO) UFactory.GetInstancia("USUARIOS");
		Collection<UsuarioDTO> coll = dao.BuscarXPersona(PersonaID);
		
		Vector<String> ret = new Vector<String>();
		for(UsuarioDTO dto: coll) {
			ret.add(dto.toString());
		}
		return ret;
	}
}
