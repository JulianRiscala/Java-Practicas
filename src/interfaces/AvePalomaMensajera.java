package interfaces;

public class AvePalomaMensajera extends Ave implements Comunicador{
	
	private String Mensaje;
	private String Emisor;
	private String Receptor;
	
	AvePalomaMensajera(String raza, String edad, String mensaje, String emisor, String receptor){
		super(edad,raza);
		this.Mensaje = mensaje;
		this.Emisor = emisor;
		this.Receptor = receptor;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public String getEmisor() {
		return Emisor;
	}

	public void setEmisor(String emisor) {
		Emisor = emisor;
	}

	public String getReceptor() {
		return Receptor;
	}

	public void setReceptor(String receptor) {
		Receptor = receptor;
	}

	@Override
	public String toString() {
		String Cadena = super.toString() + " -> AvePalomaMensajera [Mensaje=" + Mensaje + ", Emisor=" + Emisor + ", Receptor=" + Receptor + "]";
		return Cadena;
	}

	@Override
	public void EnviarMensaje(String mensaje) {
		// TODO Auto-generated method stub
	}
}
