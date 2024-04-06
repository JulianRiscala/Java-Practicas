package GUI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DemoListener3 extends Frame {

	private Button boton;
	
	public DemoListener3 () {
		super("Demo");
		setLayout(new FlowLayout());
		
		//Quien genera el evento es el frame
		addMouseMotionListener(new EscuchaMouse());
		
		boton = new Button("Boton");
		add(boton);
		
		setSize(200,150);
		setVisible(true);
	}
	
	class EscuchaMouse implements MouseMotionListener{
		public void mouseMoved(MouseEvent e) {
			int distancia = 10;
			Point pMouse = e.getPoint();
			
			Dimension dimBoton = boton.getSize();
			Point pBoton = boton.getLocation();
			
			int difX1 = Math.abs(pBoton.x - pMouse.x);
			int difX2 = Math.abs((pBoton.x + dimBoton.width) - pMouse.x);
			
			int difY1 = Math.abs(pBoton.y - pMouse.y);
			int difY2 = Math.abs((pBoton.y + dimBoton.width) - pMouse.y);
			
			if (difX1 < distancia || difX2 < distancia || difY1 < distancia || difY2 < distancia) {
				//Dimension de la ventana
				Dimension dimVentana = getSize();
				
				//Dimension de la pantalla
				Dimension dimScreen = getToolkit().getScreenSize();
				
				//Nuevas coordenadas para la ventana
				int y = (int) (Math.random() * (dimScreen.height - dimVentana.height));
				int x = (int) (Math.random() * (dimScreen.width - dimVentana.width));
				
				setLocation(x,y);
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) {
		DemoListener3 d = new DemoListener3();

	}

}
