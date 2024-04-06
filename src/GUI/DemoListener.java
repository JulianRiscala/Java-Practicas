package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoListener extends Frame{

	private Button boton;
	
	public DemoListener() {
		super("Demo");
		setLayout(new FlowLayout());
		
		boton = new Button("Boton");
		
		//Agrego un listener al boton
		boton.addActionListener(new EscuchaBoton());
		
		add(boton);
		
		setSize(500,500);
		setVisible(true);
	}
	
	class EscuchaBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Dimension de la ventana
			Dimension dimVentana = getSize();
			
			//Dimensaion de la pantalla
			Dimension dimScreen = getToolkit().getScreenSize();
			
			//Nuevas coordenadas (Aleatorias) para reubicar la ventana
			int x = (int) (Math.random() * (dimScreen.width-dimVentana.width));
			int y = (int) (Math.random() * (dimScreen.height-dimVentana.height));
			
			//Cambio la ubicacion de la ventana
			setLocation(x, y);
		}
	}
	
	public static void main(String[] args) {
		DemoListener demo = new DemoListener();
	}

}
