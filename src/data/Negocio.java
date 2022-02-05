/**
 * 
 */
package data;


import miscelanea.Regiones;


public class Negocio {
	private String nombre;
	private String contraseña;
	private double calificacion;
	private int Id;
	private String categoriaUbicacion;
	private String categoriaFuncion;
	private String ciudad;
	private String bname;
	private int numeroVotos;
	private String direccion;
	
	@SuppressWarnings("unused")
	private String departamento;
	
	public Negocio(String bname,String nombre,String contraseña,double calificacion, String categoriaUbicacion, String categoriaFuncion, String ciudad, String direccion,int numeroVotos, int id) {
		this.nombre = nombre;
		this.bname = bname;
		this.contraseña = contraseña;
		this.calificacion = calificacion;
		Id = id;
		this.categoriaUbicacion = categoriaUbicacion;
		this.categoriaFuncion = categoriaFuncion;
		this.ciudad = ciudad;
		this.numeroVotos = numeroVotos;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public String getbName() {
		return bname;
	}
	
	public void setBName(String bname) {
		this.bname = bname;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña= contraseña;
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
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}

	public String getCategoriaUbicacion() {
		return categoriaUbicacion;
	}
	
	public void setCategoriaUbicacion(String categoriaUbicacion) {
		this.categoriaUbicacion= categoriaUbicacion;
	}
	
	public String getCategoriaFuncion() {
		return categoriaFuncion;
	}
	
	public void setCategoriaFuncion(String categoriaFuncion) {
		this.categoriaFuncion = categoriaFuncion;
	}

	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad= ciudad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getNumeroVotos() {
		return numeroVotos;
	}
	
	public String getDepartamento() {
		return Regiones.setDepartamento(ciudad);
	}
	
	@Override
	public String toString() {
		return this.bname + "~" + this.nombre +"~"+ this.contraseña +"~" + this.calificacion + "~" + this.categoriaUbicacion+ "~" + this.categoriaFuncion + "~" + this.ciudad + "~" + this.direccion + "~" + this.numeroVotos + "~" + this.Id ;
	}

	public int compareTo(Negocio n){
		if(this.nombre.equals(n.nombre)){
			return 1;
		}
		    return 0;
	}

	public int maxTo(Negocio n){
		return this.nombre.compareTo(n.nombre);
	}
	


}