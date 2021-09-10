
package data;

import java.util.ArrayList;

import businessLogic.ManagerDeNegocio;

/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
public class ListaNegocios {
	private ManagerDeNegocio lista;

	public ListaNegocios(){
		this.lista = new ManagerDeNegocio("data/negocios/negocios.txt");
	}

	public ArrayList<Negocio> getAllBuss() {
		return lista.getNegocios();
	}
	
	public ArrayList<NegocioBusqueda> getBuscadorBuss(){
		return lista.getBuscadorNegocios();
	}
	
	public void loadBuss() {
		this.lista.readData();
		
	}

	public void saveBuss() {
		this.lista.writingRecords();
		
	}
}