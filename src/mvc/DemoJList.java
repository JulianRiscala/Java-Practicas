package mvc;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class DemoJList extends JFrame {

	public DemoJList() {
		super("Demo Jlist");
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		//Obtengo el vector con los datos que vamos a mostrar
		Vector<Object> datos = _obtenerVectorDatos();
		
		//El constructor de JList recibe una instancia de Listmodel
		JList lista = new JList(new VectorModel(datos));
		
		//El scrollPane agrega barras de scroll si es necesario
		JScrollPane scrollLista = new JScrollPane(lista);
		
		content.add(scrollLista,BorderLayout.CENTER);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	private Vector<Object> _obtenerVectorDatos(){
		Vector<Object> v = new Vector<Object>();
		v.add("John Lennon");
		v.add("Paul McCartney");
		v.add("George Harrison");
		v.add("Ringo Star");
		v.add("Sandro (Roberto Sanchez)");
		v.add("Charly Garcia");
		v.add("Caetano Veloso");
		return v;
		
	}
	
	public static void main(String[] args) {
		DemoJList j = new DemoJList();

	}
}


