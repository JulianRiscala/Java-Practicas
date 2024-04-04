package GUI;

import java.awt.*;

public class Ventana1 extends Frame {

	private Button b1,b2,b3;
	
	public Ventana1(){
		//El constructor del padre recibe el titulo de la ventana
		super("Esta es la ventana 1");
		
		//setel el layout
		setLayout(new FlowLayout());
		
		//Tiro los botones a la izq
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//Inicializo y añado los botones
		b1 = new Button("Boton 1");
		add(b1);
		
		b2 = new Button("Boton 2");
		add(b2);
		
		b3 = new Button("Boton 3");
		add(b3);
		
		//Seteo el size y la hago visible
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Ventana1 v1= new Ventana1();

	}

}
