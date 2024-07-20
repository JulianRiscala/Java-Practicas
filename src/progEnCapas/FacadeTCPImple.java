package progEnCapas;

import java.util.Collection;

import app3Capas.ServiceLocatorTCP;

public class FacadeTCPImple implements Facade {

	public Collection<PersonaDTO> obtenerPersonas() {
		return ServiceLocatorTCP.obtenerPersonas();
	}

	public Collection<UsuarioDTO> BuscarXPersona(int PersonaID) {
		return ServiceLocatorTCP.obtenerUsuariosXPersona(PersonaID);
	}

}
