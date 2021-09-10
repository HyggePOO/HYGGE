/**
 * 
 */
package businessLogic;

import java.util.ArrayList;

import data.Negocio;
import data.NegocioBusqueda;
import data.Usuario;

/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
public class AdmUsuario {
	protected static String usuarioLogeado ="";
	protected static String usuarioLogeadoTipo;
	protected static ArrayList<Usuario> usuario;
	protected static ArrayList<Negocio> negocio;
	protected static ArrayList<NegocioBusqueda> negocioBus;
	protected static boolean logeado = false;
	
	public AdmUsuario() {
		usuario = new ArrayList<Usuario>();
		negocio = new ArrayList<Negocio>();
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
	
	
	public static Usuario getUsuarioLogeado() {
		return ManagerDeUsuario.getUsuarioLog(usuarioLogeado);
	}
	
	public static Negocio getNegocioLogeado() {
		return ManagerDeNegocio.getNegocioLog(usuarioLogeado);
	}
	
	public static Usuario getUsuario(String usuario) {
		return ManagerDeUsuario.getUsuarioLog(usuario);
	}
	
	public static Negocio getNegocio(String negocio) {
		return ManagerDeNegocio.getNegocioL(negocio);
	}

	public static String getUsuarioLogeadoTipo() {
		return usuarioLogeadoTipo;
	}
	
}

