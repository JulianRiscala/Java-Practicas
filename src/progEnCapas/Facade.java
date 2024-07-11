package progEnCapas;

import java.util.Collection;

public class Facade {
	
	public Collection<PersonaDTO> obtenerPersonas(){
//		PersonaDAO personaDao = new PersonaDAO(); // Ahora no se puede hacer esto porque es abstracta
//		PersonaDAO personaDao = new PersonaDAOsqlServerImple();
		PersonaDAO personaDao =  (PersonaDAO) UFactory.GetInstancia("PERSONAS");
		return personaDao.buscarTodos();
	}
	
	public Collection<UsuarioDTO> BuscarXPersona(int PersonaID){
//		UsuarioDAO usuarioDao = new UsuarioDAO(); // Ahora no se puede hacer esto porque es abstracta
//		UsuarioDAO usuarioDao = new UsuarioDAOsqlServerImple();
		UsuarioDAO usuarioDao = (UsuarioDAO) UFactory.GetInstancia("USUARIOS");
		return usuarioDao.BuscarXPersona(PersonaID);
	}
}
