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
		
		
		//Aca vamos a armar la lista pero desde un Array
		Object[] datos2 = _obtenerArrayDatos();
		JList lista2 = new JList(new ArrayModel(datos2));
		JScrollPane scrollLista2 = new JScrollPane(lista2);
		
		content.add(scrollLista,BorderLayout.WEST);
		content.add(scrollLista2, BorderLayout.EAST);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	private Object[] _obtenerArrayDatos() {
		Object arr[] = {"Pappo",
						"Spinetta",
						"Charly",
						"Luca Prodan",
						"El loco Mason"};
		
		return arr;
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


