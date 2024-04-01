package interfaces;

public class ComunicadorManager {

	ComunicadorManager(){
		
	}
	
	public static Comunicador crearComunicador(){
		return new AvePalomaMensajera("a","a","a","a","a");
	}
}
