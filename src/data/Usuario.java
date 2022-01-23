package data;

public class Usuario {
	private String username;
	private String contraseña;
	private String nombre;
	private int Id;
	private int edad;
	
	public Usuario(String username,String contraseña,String nombre, int edad, int id) {
		this.username= username;
		this.contraseña=contraseña;
		this.nombre = nombre;
		Id = id;
		this.edad = edad;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username= username;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña=contraseña;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	@Override
	public String toString() {
		return this.username +"~"+ this.contraseña +"~" + this.nombre + "~" + this.edad + "~" + this.Id ;
	}
}
