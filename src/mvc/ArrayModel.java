package mvc;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ArrayModel implements ListModel{
	private Object[] datos;
	
	public ArrayModel(Object[] datos) {
		this.datos = datos;
	}
	
	public Object getElementAt(int index) {
		return datos[index];
	}
	
	public int getSize() {
		return datos.length;
	}

	
	public void addListDataListener(ListDataListener l) {}
	public void removeListDataListener(ListDataListener l) {}

}
