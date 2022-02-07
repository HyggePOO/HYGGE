package businessLogic;

import data.ListaNegocios;
import data.ListaUsuarios;
import data.Negocio;
import dataStructures.DoubleLinkedList;
import gui.Principal;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rincón
 * 
 */
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
		DoubleLinkedList<Negocio> o = negocios.getAllBuss();
		for(int i=0;i<o.getSize();i++) {
			System.out.println(o.getElement(i).getbName());
		}
		
	}
	
	public static void guardar() throws Exception {
			miembros.saveUsers();
			negocios.saveBuss();
	}
	
	public static void cargar() throws Exception {
		ManagerDeUsuario.reiniciarUsuarios();
		ManagerDeNegocio.reiniciarNegocios();
		miembros.loadUsers();
		negocios.loadBuss();
	}
	
}
