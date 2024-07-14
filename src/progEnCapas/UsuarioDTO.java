package progEnCapas;

public class UsuarioDTO {

	private int ID;
	private int PersonaID;
	private String Codigo;
	private String Nick;
	private int ClaseID;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPersonaID() {
		return PersonaID;
	}
	public void setPersonaID(int personaID) {
		PersonaID = personaID;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNick() {
		return Nick;
	}
	public void setNick(String nick) {
		Nick = nick;
	}
	public int getClaseID() {
		return ClaseID;
	}
	public void setClaseID(int claseID) {
		ClaseID = claseID;
	}
	@Override
	public String toString() {
		return Codigo + "," + Nick + "," + ClaseID;
	}
	
}
