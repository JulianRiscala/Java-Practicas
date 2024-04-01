package interfaces;

public class TelefonoCelular extends Telefono implements Comunicador{

	 private String Empresa;
	 private String Dueño;
	 
	 TelefonoCelular(String marca, String modelo, String numero, String empresa, String dueño){
		 super(marca, modelo, numero);
		 this.Empresa = empresa;
		 this.Dueño = dueño;
	 }

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public String getDueño() {
		return Dueño;
	}

	public void setDueño(String dueño) {
		Dueño = dueño;
	}

	@Override
	public String toString() {
		String Cadena = super.toString() +  " -> TelefonoCelular [Empresa=" + Empresa + ", Dueño=" + Dueño + "]";
		return Cadena;
	}

	@Override
	public void EnviarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		
	}
}
