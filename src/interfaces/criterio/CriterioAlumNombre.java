package interfaces.criterio;
import interfaces.*;

public class CriterioAlumNombre extends Criterio<Alumno> {

	@Override
	public int comparar(Alumno a, Alumno b) {
		return a.getNombre().compareTo(b.getNombre());
	}
	
}
