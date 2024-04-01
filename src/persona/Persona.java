package persona;

public class Persona {
	
	private String Nombre;
	private String Apellido;
	private String Edad;
	private String Nacionalidad;
	
	public Persona () {
	}

	public Persona(String nombre, String apellido, String edad, String nacionalidad) {
		this.Edad = edad;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Nacionalidad = nacionalidad;
	}
	
	public String getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		Edad = edad;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String toString() {
		return "Nombre y apellido: " + this.Nombre + " " + this.Apellido + " | Edad: " + this.Edad + " | Nacionalidad: " + this.Nacionalidad + ".";
	}
	

}
