package persona;

public class MiColeccion<T> {
	private Object datos[]= null;
	private int len = 0;
	
	public MiColeccion (int capacidadInicial) {
		datos = new Object[capacidadInicial];
	}
	
	public void agregar (T elm) {  // Agrega un elemento al final de la coleccion
		insertar(elm, len);
	}

	public void insertar (T elm, int i) {  // inserta un elemento a la i-esima posicion
		if (len == datos.length) {
			Object aux[] = datos;
			datos = new Object[datos.length*2];
			for (int j= 0; j<len; j++) {
				datos[j] = aux[j];
			}
			aux = null;
		}
		for ( int j= len-1; j>=i; j--) {
			datos[j+1]= datos[j];
		}
		datos[i]= elm;
		len++;
	}
	
	public int buscar(T elm) {  // elimina y retorna el objeto en la i-esima posicion
		int i= 0;
		
		//Mientras no me pase del tope y mientras no encuentre...
		for ( ;i<len && !datos[i].equals(elm);i++);
		
		//Si no me pase entonces encontre, si no... no encontre
		return i<len?i:-1;
	}
	
	@SuppressWarnings("unchecked")  
	public T eliminar(int i) {	// busca la primera ocurrencia del objeto especificado y retorna la posicion donde lo encuentra o un valor negativo si el objeto no se encontro
		Object aux = datos[i];
		for( int j=i; j<len-1;j++) {
			datos[j]= datos[j+1];
		}
		len--;
		return (T)aux;
	}
	
	@SuppressWarnings("unchecked") 
	public T obtener(int i) {  // Retorna el i-esimo elemento de la coleccion
		return (T)datos[i];
	}
	
	public int cantidad() {
		return len;
	}
}
