
package data;

import businessLogic.ManagerDeUsuario;
import dataStructures.DoubleLinkedList;

public class ListaUsuarios {
	private ManagerDeUsuario lista;

	public ListaUsuarios(){
		this.lista = new ManagerDeUsuario("data/usuarios/usuarios.txt");
	}

	public DoubleLinkedList<Usuario> getAllUsers() {
		return lista.getUsuarios();
	}
	
	public void loadUsers() {
		this.lista.readData();
		
	}

	public void saveUsers() throws Exception {
		this.lista.writingRecords();
		
	}
}