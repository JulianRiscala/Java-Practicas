package progEnCapasRMI;

import java.util.Collection;
import java.util.Vector;

import app3Capas.UDto;
import progEnCapas.Facade;
import progEnCapas.PersonaDTO;
import progEnCapas.UsuarioDTO;

public class FacadeRMIImple implements Facade {
	public FacadeRemoto remoto;
	public FacadeRMIImple() {
		remoto = (FacadeRemoto) ServiceLocatorRMI.lookup("FacadeRemoto");
	}
	
	public Collection<PersonaDTO> obtenerPersonas() {
		try {
			//Delego la llamada
			Collection<String> coll = remoto.obtenerPersonas();
			
			//Convierto la colleción
			Vector<PersonaDTO> ret = new Vector<PersonaDTO>();
			for (String s:coll) {
				ret.add(UDto.stringToPersonaDTO(s));
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Collection<UsuarioDTO> BuscarXPersona(int PersonaID) {
		try {
			//Delego la llamada
			Collection<String> coll = remoto.BuscarXPersona(PersonaID);
			
			//Convierto la colleción
			Vector<UsuarioDTO> ret = new Vector<UsuarioDTO>();
			for (String s:coll) {
				ret.add(UDto.stringToUsuarioDTO(s));
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
