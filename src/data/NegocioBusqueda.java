/**
 * 
 */
package data;

public class NegocioBusqueda {
	private String nombre;
	private String categoriaFuncion;
	private String ciudad;

	public NegocioBusqueda(String nombre, String categoriaFuncion, String ciudad) {
		this.nombre= nombre;
		this.categoriaFuncion = categoriaFuncion;
		this.ciudad=ciudad;
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
	
	@Override
	public String toString() {
		return this.nombre +"~"+this.categoriaFuncion + "~" + this.ciudad;
	}


}