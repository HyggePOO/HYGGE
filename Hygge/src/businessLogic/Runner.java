/**
 * 
 */
package businessLogic;

import data.ListaNegocios;
import data.ListaUsuarios;
import gui.Principal;

/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
public class Runner {

	/**
	 * @param args
	 */
	static ListaUsuarios miembros = new ListaUsuarios();
	static ListaNegocios negocios = new ListaNegocios();
	
	public static void main(String[] args) {
		Principal frame = new Principal(negocios);
		cargar();
		frame.setVisible(true);
	}
	
	public static void guardar() {
			miembros.saveUsers();
			negocios.saveBuss();
	}
	
	public static void cargar() {
		ManagerDeUsuario.reiniciarUsuarios();
		ManagerDeNegocio.reiniciarNegocios();
		ManagerDeNegocio.reiniciarNegociosBusqueda();
		miembros.loadUsers();
		negocios.loadBuss();
	}
	
}
