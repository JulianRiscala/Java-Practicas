package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import GUI.DemoListener5.EscucharVentana;

public class DemoListener6 extends Frame{

	private TextField tfMensaje;
	private Label label;
	
	public DemoListener6(){
		super("Key listeners");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(new Label("Ingrese texto:"));
		
		tfMensaje = new TextField(20);
		this.add(tfMensaje);
		
		label = new Label();
		this.add(label);
		
		tfMensaje.addKeyListener(new EscucharTecla());
		tfMensaje.addActionListener(new EscucharEnter());
		
		setSize(600, 150);
		setVisible(true);
		
		this.addWindowListener(new EscucharVentana());
	}
	
	class EscucharTecla implements KeyListener{

		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			label.setText(Character.toString(c));
		}
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		
	}
	
	class EscucharEnter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(tfMensaje.getText());
			
			// refresco los componentes de la ventana
			validate();
			//Esto es para que haga el refresco gráfico de todos los componentes de la ventana
			//Si esto lo omitimos, el texto del label queda trunco
			
			tfMensaje.setText(tfMensaje.getText().toUpperCase());
			tfMensaje.selectAll();
		}
		
	}
	
	class EscucharVentana implements WindowListener{

		public void windowOpened(WindowEvent e) {}
		public void windowClosing(WindowEvent e) { setVisible(false); dispose(); System.exit(0);}
		public void windowClosed(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoListener6 kl = new DemoListener6();
	}

}
