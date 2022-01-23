package businessLogic;

import data.ListaNegocios;
import data.ListaUsuarios;
import gui.Principal;

public class Runner {

	/**
	 * @param args
	 */
	static ListaUsuarios miembros = new ListaUsuarios();
	static ListaNegocios negocios = new ListaNegocios();
	
	public static void main(String[] args) throws Exception {
		Principal frame = new Principal(negocios);
		cargar();
		frame.setVisible(true);
	}
	
	public static void guardar() throws Exception {
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
