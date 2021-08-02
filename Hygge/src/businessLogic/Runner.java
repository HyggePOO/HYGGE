/**
 * 
 */
package businessLogic;

import data.ListaUsuarios;
import gui.Inicio;
import gui.Registro;
import gui.ui;
import data.Usuario;



/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
public class Runner {

	/**
	 * @param args
	 */
	static ListaUsuarios miembros = new ListaUsuarios();
	
	public static void main(String[] args) {
		
		ui ui = new ui();
		Inicio sesion1 =new Inicio();
		Registro registro1 =new Registro();
		
		miembros.loadUsers();
		sesion1.setVisible(true);
		int option = 0;
		while (option != 3) {
			ui.showMenu();
			option = ui.readOption();

			switch (option) {
			case 1: // show names
				for(Usuario u : miembros.getAllUsers()) {
					ui.showItem(u.toString());
					}
				break;
					
			case 2:
				System.exit(0);
				break;
				/*RegistroDeUsuario nuevoPerfil  = new RegistroDeUsuario();
				ManagerDeUsuario.registrandoUsuario(nuevoPerfil.registro());
				ManagerDeUsuario.RegistroDeUsuario();
				ui.showItem("Has sido registrado satisfactoriamente\n");*/
			default:
				ui.wrongOption();
			}
		}

	}
	
	public static void guardar(boolean verdadero) {
		if(verdadero == true) {
			miembros.saveUsers();
		}
	}

}
