package GUI;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DemoListener4 extends Frame{

	public DemoListener4(){
		super("Demo");
		
		//Relaciono un WindowListener con el Frame
		this.addWindowListener(new EscuchaVentana());
		
		setSize(200,150);
		setVisible(true);
	}
	
	class EscuchaVentana implements WindowListener{

		public void windowOpened(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
			//Para cerrar la ventana y cortar el programa son 3 pasos:
			//1 - Ocultar la ventana con SetVisisible(False);
			//2 - Liberarla con el metodo dispose
			//3 - Finalizar la aplicacion con System.exit
			
			System.out.println("Oculto...");
			setVisible(false);
			
			System.out.println("Libero");
			dispose();
			
			System.out.println("Chau chau adios...");
			System.exit(0);
		}
		public void windowClosed(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		
	}
	
	public static void main(String[] args) {
		
		DemoListener4 d = new DemoListener4();
		
	}
}
