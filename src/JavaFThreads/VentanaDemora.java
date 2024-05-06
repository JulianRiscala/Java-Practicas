package JavaFThreads;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDemora extends Frame{

	private Button boton;
	private Choice combo;
	
	public VentanaDemora() {
		setLayout(new FlowLayout());
		add (boton = new Button("Esto va a demorar..."));
		boton.addActionListener(new EscuchaBoton());
		
		add(combo = new Choice());
		combo.addItem("Item 1");
		combo.addItem("Item 2");
		combo.addItem("Item 3");
		
		setSize(500,500);
		setVisible(true);
	}
	
	
	// La solucion a este problema que parece que queda tildado, sera lanzar un thread que lleve a cabo la tarea que veniamos haciendo en el metodo ActionPerformed
	// Metodo que se envoca cuando se preciona el boton
	class EscuchaBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
//			try {
//				Thread.sleep(10000);
//				System.out.println("Termino la espera!");
//			} catch (Exception e2) {
//				e2.printStackTrace();
//				throw new RuntimeException(e2);
//			}			
			// Inhabilito el boton mientras dure el proceso
			boton.setEnabled(false);
			
			//instancio y lanzo el thread que lleva a cabo la tarea
			TareaBoton t = new TareaBoton();
			t.start();
		}
	}
	
	class TareaBoton extends Thread{
		public void run() {
			try {
				// Hago lo que antes hacia en el actionPerformed
				Thread.sleep(10000);
				System.out.println("Termino la espera!");
				
				//Cuando finalizo la tarea vuelvo a habilitar el boton
				boton.setEnabled(true);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) {
		VentanaDemora n = new VentanaDemora();

	}

}
