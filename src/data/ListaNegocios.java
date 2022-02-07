
package data;

import java.util.ArrayList;

import businessLogic.ManagerDeNegocio;
import dataStructures.DoubleLinkedList;
import dataStructures.PriorityQueue;


public class ListaNegocios {
	private static ManagerDeNegocio lista;

	public ListaNegocios(){
		this.lista = new ManagerDeNegocio("data/negocios/negocios.txt");
	}

	public DoubleLinkedList<Negocio> getAllBuss() {
		return lista.getNegocios();
	}
	
	public ArrayList<NegocioBusqueda> getBuscadorBuss(){
		return lista.getBuscadorNegocios();
	}
	
	public void loadBuss() throws Exception {
		this.lista.readData();
		
	}

	public void saveBuss() throws Exception {
		this.lista.writingRecords();
		
	}

	public void priorizar() {
		ArrayList<NegocioBusqueda> entrada = getBuscadorBuss();
		ArrayList<NegocioBusqueda> salida = new ArrayList<NegocioBusqueda>();
		PriorityQueue cola = new PriorityQueue(lista.getSize());
		for(int i = 0; i <lista.getSize();i++) {
			NegocioBusqueda n = entrada.get(i);
			cola.insertItem(n);
		}
		for(int i = 0; i<lista.getSize();i++) {
			NegocioBusqueda n = cola.removeMax();
			System.out.print(n.getNombre() + ", ");
			salida.add(n);
		}
		lista.cambioLista(salida);

	}

	public static void eliminarUsuario(Negocio negocio) throws Exception {
		lista.elimia(negocio);
		
	}
}