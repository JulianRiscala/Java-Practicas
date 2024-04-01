package interfaces;

public class Alumno implements Comparable<Alumno> {
	
	private String Nombre;
	private int Edad;
	private double NotaPromedio;
	
	public Alumno(String nombre, int edad, double notaPromedio) {
		this.Nombre = nombre;
		this.Edad = edad;
		this.NotaPromedio = notaPromedio;
	}
	
	public String toString() {
		return "Alumno: " + this.Nombre + ", edad: " + this.Edad + ", nota promedio: " + this.NotaPromedio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public double getNotaPromedio() {
		return NotaPromedio;
	}

	public void setNotaPromedio(double notaPromedio) {
		NotaPromedio = notaPromedio;
	}

	@Override
	public int compareTo(Alumno o) {
		// si retorna positivo, thisAlumno es mayor a otroAlumno
		return this.Edad - o.Edad;
	}
	
}
