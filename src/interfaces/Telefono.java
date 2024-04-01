package interfaces;

public class Telefono {
	
	private String Marca;
	private String Modelo;
	private String Numero;
	
	Telefono(String marca, String modelo, String numero){
		this.Marca = marca;
		this.Modelo = modelo;
		this.Numero = numero;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	@Override
	public String toString() {
		return "Telefono [Marca=" + Marca + ", Modelo=" + Modelo + ", Numero=" + Numero + "]";
	}
	
	
}
