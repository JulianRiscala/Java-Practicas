package progEnCapas;

import java.util.Collection;

public interface Facade {
	public Collection<PersonaDTO> obtenerPersonas();
	public Collection<UsuarioDTO> BuscarXPersona(int PersonaID);
}
