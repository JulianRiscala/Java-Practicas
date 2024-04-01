package persona;

public class MiPila<T> {
	
	//capacidad hadcodeada
	private static final int capacidadInicial = 5;
	
	//instancia la coleccion que mantendra los datos de la pila
	private MiColeccion<T> coll = new MiColeccion<T>(capacidadInicial);
	
	//El metodo apilar recibe un parametro de tipo T
	public void apilar(T elm) {
		coll.insertar(elm, 0);
	}
	
	//El metodo desapilar retorna un elemento de tipo T
	public T Desapilar() {
		return coll.eliminar(0);
	}
}
