package interfaces.criterio;
import interfaces.*;
public class CriterioAlumNotaProm extends Criterio<Alumno> {

	@Override
	public int comparar(Alumno a, Alumno b) {
		double diff = a.getNotaPromedio()-b.getNotaPromedio();
		return diff > 0? 1: diff < 0? -1 : 0;
	}
	
}
