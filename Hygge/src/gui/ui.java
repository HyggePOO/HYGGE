/**
 * 
 */
package gui;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author Mateo Ortiz & Andres Moreno
 *
 */
public class ui {

	public void showMenu() {
		System.out.println("\n------------ MENU DE OPCIONES ------------");
		System.out.printf(" 1. Ver lista de %s \n 2. Registrarse \n 3. Salir\n", "Usuarios Registrados");
		System.out.print("\n Por favor escriba el número de la opción deseada ==> ");
		
	}

	public int readOption() {
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine().trim());
	}

	public void showItem(String s) {
		System.out.println(s);
		
	}

	public void wrongOption() {
		System.out.println("Opción Incorrecta");
	}
}