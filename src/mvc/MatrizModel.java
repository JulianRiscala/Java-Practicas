package mvc;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MatrizModel implements TableModel {

	private Object[][] datos;
	
	public MatrizModel(Object[][] datos) {
		this.datos = datos;
	}
	
	public int getRowCount() {
		// cantidad de filas, que sera uno menos que el length porque la primera contiene los headers
		return datos.length - 1;
	}

	public int getColumnCount() {
		// cantidad de columnas
		return datos[0].length;
	}

	public String getColumnName(int columnIndex) {
		// retorna el titulo (header) de la columna
		return datos[0][columnIndex].toString();
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// la fila 0 correspojnde a los headers, por eso le sumamos 1
		return datos[rowIndex + 1][columnIndex];
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}
	public void addTableModelListener(TableModelListener l) {}
	public void removeTableModelListener(TableModelListener l) {}
}
