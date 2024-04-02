package progEnCapas;

import java.util.Collection;

public class Facade {
	
	public Collection<PersonaDTO> obtenerPersonas(){
		PersonaDAO personaDao = new PersonaDAO();
		return personaDao.buscarTodos();
	}
	
	public Collection<UsuarioDTO> BuscarXPersona(int PersonaID){
		UsuarioDAO usuarioDao = new UsuarioDAO();
		return usuarioDao.BuscarXPersona(PersonaID);
	}
}
