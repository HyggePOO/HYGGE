/**
 * 
 */
package businessLogic;

import java.util.ArrayList;
import dataStructures.*;

import data.Negocio;
import data.NegocioBusqueda;
import data.Usuario;


public class AdmUsuario {
	
	protected static DoubleLinkedList<Usuario> usuario;
	protected static DoubleLinkedList<Negocio> negocio;
	protected static String usuarioLogeado ="";
	protected static String usuarioLogeadoTipo;
	protected static ArrayList<NegocioBusqueda> negocioBus;
	protected static boolean logeado = false;
	
	public AdmUsuario() {
		usuario = new DoubleLinkedList<Usuario>();
		negocio = new DoubleLinkedList<Negocio>();
		negocioBus = new ArrayList<NegocioBusqueda>();
	}
	
	public static boolean isLogeado() {
		return logeado;
	}
	
	public static void setUsuarioLogeado(String usuario, String tipo) {
		usuarioLogeado = usuario;
		usuarioLogeadoTipo = tipo;
		logeado = true;
		
	}
	
	public static void cerrarSesion() {
		usuarioLogeado = "";
		usuarioLogeadoTipo = "";
		logeado = false;
	}
	
	
	public static Usuario getUsuarioLogeado() throws Exception {
		return ManagerDeUsuario.getUsuarioLog(usuarioLogeado);
	}
	
	public static Negocio getNegocioLogeado() throws Exception {
		return ManagerDeNegocio.getNegocioLog(usuarioLogeado);
	}
	
	public static Usuario getUsuario(String usuario) throws Exception {
		return ManagerDeUsuario.getUsuarioLog(usuario);
	}
	
	public static Negocio getNegocio(String negocio) throws Exception {
		return ManagerDeNegocio.getNegocioL(negocio);
	}

	public static String getUsuarioLogeadoTipo() {
		return usuarioLogeadoTipo;
	}
	
}

