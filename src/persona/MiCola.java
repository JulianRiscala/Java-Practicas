package persona;

public class MiCola<T> {

	private static final int capacidadInicial = 5;
	private MiColeccion<T> coll = new MiColeccion<T>(capacidadInicial);
	
	//Agrega el elemento al final de la coleccion
	public void encolar(T elm) {
		coll.agregar(elm);
	}
	
	//Retorna y elimina de la coleccion el primer elemento
	public T desencolar() {
		return coll.eliminar(0);
	}
	
}
