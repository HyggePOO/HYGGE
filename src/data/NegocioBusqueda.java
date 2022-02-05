/**
 * 
 */
package data;

public class NegocioBusqueda {
	private String nombre;
	private String categoriaFuncion;
	private String ciudad;
	private double calificacion;
	private int numeroVotos;

	public NegocioBusqueda(String nombre, String categoriaFuncion, String ciudad, double calificacion, int num) {
		this.nombre= nombre;
		this.categoriaFuncion = categoriaFuncion;
		this.ciudad=ciudad;
		this.calificacion = calificacion;
		this.numeroVotos = num;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}

	public String getCategoriaFuncion() {
		return categoriaFuncion;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public double getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(double calificacion) {
		if(numeroVotos == 0) {
			this.calificacion = calificacion;
		}else {
			this.calificacion = Math.round(((this.calificacion + calificacion) / 2) * Math.pow(10, 1)) / Math.pow(10, 1);
		}
	}
	
	public void addVotaciones() {
		numeroVotos ++;
	}
	
	@Override
	public String toString() {
		return this.nombre +"~"+this.categoriaFuncion + "~" + this.ciudad;
	}


}