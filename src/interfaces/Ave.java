package interfaces;

public class Ave {

	private String Edad;
	private String Raza;

	Ave (String edad, String raza){
		this.Edad = edad;
		this.Raza = raza;
	}

	public String getEdad() {
		return Edad;
	}

	public void setEdad(String edad) {
		Edad = edad;
	}

	public String getRaza() {
		return Raza;
	}

	public void setRaza(String raza) {
		Raza = raza;
	}

	@Override
	public String toString() {
		return "Ave [Edad=" + Edad + ", Raza=" + Raza + "]";
	}
	
}
