package interfaces;

public class Principal {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Comunicador c1 = new TelefonoCelular("Motorola", "G51", "(011) 2401-9044", "Movistar", "Riscala");
		Comunicador c2 = new AvePalomaMensajera("Paloma blanca", "3", "Este es un mensaje", "Osvaldo", "Maria");
		
		Comunicador c3 = ComunicadorManager.crearComunicador();
		c3.EnviarMensaje("Este es otro mensaje");
		System.out.println(c3.toString());
	}

}
