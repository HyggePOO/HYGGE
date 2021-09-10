
package data;

import java.util.ArrayList;

import businessLogic.ManagerDeUsuario;

/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
public class ListaUsuarios {
	private ManagerDeUsuario lista;

	public ListaUsuarios(){
		this.lista = new ManagerDeUsuario("data/usuarios/usuarios.txt");
	}

	public ArrayList<Usuario> getAllUsers() {
		return lista.getUsuarios();
	}
	
	public void loadUsers() {
		this.lista.readData();
		
	}

	public void saveUsers() {
		this.lista.writingRecords();
		
	}
}