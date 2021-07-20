/**
 * 
 */
package businessLogic;
import java.io.File;
import data.Usuario;
import businessLogic.ManagerDeUsuario;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Mateo
 *
 */
public class RegistroDeUsuario extends AdmUsuario{
	private static String username;
	private static String contraseña;
	private static String nombre;
	private static int id;
	private boolean correcto = false;
	
	public RegistroDeUsuario() {
		System.out.println("\n------------ REGISTRO ------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su nombre de usuario");
		username = sc.nextLine(); 
		System.out.println("Introduzca su contraseña");
		while (correcto == false) {
		contraseña = sc.nextLine(); 
			if (contraseña.length() < 5) {
				System.out.println("Contraseña demasiado corta, intente con una más seguridad");
				correcto = false;
			}else {
				correcto = true;
			}
		}
		System.out.println("Introduzca su nombre real");
		nombre = sc.nextLine(); 
		id = usuario.size() + 1;

	}
	
	protected Usuario registro() {
		Usuario u = new Usuario(username,contraseña,nombre, id);
		return u;
	}
	
	public String getUsuario() {
		return username;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
		
	
}
