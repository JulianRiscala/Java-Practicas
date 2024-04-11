package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class DemoListener5 extends Frame {

	private TextField tfItem;
	private TextField tfMensaje;
	private Button bAgregar;
	private List Lista;
	
	public DemoListener5() {
		super("Action Listener");
		
		//Defino el layout principal
		setLayout(new BorderLayout());
		
		//Norte
		Panel pN = _crearPNorte();
		add(pN, BorderLayout.NORTH);
		
		Lista = new List();
		add(Lista, BorderLayout.CENTER);
		
		//Listeners
		bAgregar.addActionListener(new EscucharAgregar());
		tfItem.addActionListener(new EscucharAgregar());
		Lista.addActionListener(new EscucharDobleClick());
		this.addWindowListener(new EscucharVentana());
		
		setSize(500,500);
		setVisible(true);
		 
		//El foco esta por defecto en el textfield
		tfItem.requestFocus();
	}
	
	class EscucharAgregar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!tfItem.getText().isEmpty()) {
				//Tomo el texto y lo agrego a la lista
				Lista.add(tfItem.getText());
				
				//Selecciono todo el texto en el textfield
				tfItem.setText("");
				
				//Seteo el foco en el textfield
				tfItem.requestFocus();
			}
		}
	}

	class EscucharDobleClick implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Lista.remove(Lista.getSelectedIndex());
			tfItem.requestFocus();
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
	
	private Panel _crearPNorte(){
		Panel p = new Panel (new BorderLayout());
		
		p.add(new Label("Item:"),BorderLayout.WEST);
		
		tfItem = new TextField(15);
		p.add(tfItem, BorderLayout.CENTER);
		
		bAgregar = new Button("Login");
		p.add(bAgregar, BorderLayout.EAST);
		
		return p;
	}

	public static void main(String[] args) {
		
		DemoListener5 chat = new DemoListener5();
	}

}
