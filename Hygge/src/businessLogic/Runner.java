/**
 * 
 */
package businessLogic;

import data.ListaUsuarios;
import gui.ui;
import data.Usuario;



/**
 * @author Mateo
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListaUsuarios store = new ListaUsuarios();
		ui ui = new ui();
		
		store.loadUsers();
		
		int option = 0;
		while (option != 3) {
			ui.showMenu();
			option = ui.readOption();

			switch (option) {
			case 1: // show names
				for(Usuario u : store.getAllUsers()) {
					ui.showItem(u.toString());
					}
				break;
					
			case 2:
				/*RegistroDeUsuario nuevoPerfil  = new RegistroDeUsuario();
				ManagerDeUsuario.registrandoUsuario(nuevoPerfil.registro());*/
				ManagerDeUsuario.RegistroDeUsuario();
				ui.showItem("Has sido registrado satisfactoriamente\n");
				break;
				
			case 3: // quit
				store.saveUsers();
				System.exit(0);
				break;
			default:
				ui.wrongOption();
			}
		}

	}

}
