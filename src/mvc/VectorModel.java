package mvc;

import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class VectorModel implements ListModel{

	private Vector<Object> datos;
	
	public VectorModel (Vector<Object> datos) {
		this.datos = datos;
	}
	
	public int getSize() {
		return datos.size();
	}

	@Override
	public Object getElementAt(int index) {
		return datos.get(index);
	}

	public void addListDataListener(ListDataListener l) {}
	public void removeListDataListener(ListDataListener l) {}
	
}