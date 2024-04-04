package GUI;

import java.awt.*;

public class Ventana2 extends Frame {

	private Button bNorth, bSouth, bWest, bEast, bCenter;
	
	public Ventana2() {
		super("Esta es la ventana 2");
		
		bNorth = new Button("Norte");
		add(bNorth, BorderLayout.NORTH);
		
		bSouth = new Button("Sur");
		add(bSouth, BorderLayout.SOUTH);
		
		bWest = new Button("Oeste");
		add(bWest, BorderLayout.WEST);
		
		bEast = new Button("Este");
		add(bEast, BorderLayout.EAST);
		
		bCenter = new Button("Centro");
		add(bCenter, BorderLayout.CENTER);
		
		setSize(500, 500);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		
		Ventana2 v = new Ventana2();

	}

}
