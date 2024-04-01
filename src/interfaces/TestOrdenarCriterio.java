package interfaces;
import interfaces.criterio.*;
public class TestOrdenarCriterio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno arr[] = {new Alumno("Alan",25,7.2),
						new Alumno("Roberto",23,5.1),
						new Alumno("Ezequiel",20,4.8) };
		
		Util.ordenarPorCriterio(arr, new CriterioAlumNombre());
		Util.Imprimir(arr);
		
		Util.ordenarPorCriterio(arr, new CriterioAlumNotaProm());
		Util.Imprimir(arr);
	}

}
