package interfaces;

public class TelefonoCelular extends Telefono implements Comunicador{

	 private String Empresa;
	 private String Due�o;
	 
	 TelefonoCelular(String marca, String modelo, String numero, String empresa, String due�o){
		 super(marca, modelo, numero);
		 this.Empresa = empresa;
		 this.Due�o = due�o;
	 }

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public String getDue�o() {
		return Due�o;
	}

	public void setDue�o(String due�o) {
		Due�o = due�o;
	}

	@Override
	public String toString() {
		String Cadena = super.toString() +  " -> TelefonoCelular [Empresa=" + Empresa + ", Due�o=" + Due�o + "]";
		return Cadena;
	}

	@Override
	public void EnviarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		
	}
}
