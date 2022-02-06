/**
 * 
 */
package businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Scanner;

import data.Usuario;
import dataStructures.DoubleLinkedList;


public class ManagerDeUsuario extends AdmUsuario{
	private String fileName;

	
	
	public ManagerDeUsuario(String fileName) {
		this.fileName= fileName;
	}
	
	static void registrandoUsuario(Usuario u) {
		usuario.add(u);
	}
	
	
	public void readData() {
		File inFile = new File(this.fileName);
		try {
			Scanner sc = new Scanner(inFile);
			readItem(sc);
			sc.close();
		} catch(FileNotFoundException e){
			System.out.println("Archivo no encontrado");
			System.exit(0);
		
		}
	}

	private void readItem(Scanner sc) {
		while(sc.hasNext()) {
			String line = sc.nextLine();
			processLine(line);
		}
	}

	private void processLine(String line) {
		Scanner sc = new Scanner(line);
		sc.useDelimiter("~");
		String username = sc.next().trim();	
		String contraseña = sc.next().trim();
		String nombre = sc.next().trim();
		int edad = Integer.parseInt(sc.next().trim());
		int id = Integer.parseInt(sc.next().trim());
		sc.close();
		Usuario u = new Usuario(username,contraseña,nombre,edad, id);
		usuario.add(u);
		usuarioH.set(contraseña, id);

	}

	public DoubleLinkedList<Usuario> getUsuarios() {
		return usuario;

	}
	
	public void writingRecords() throws Exception {
		try {
			FileWriter myWriter = new FileWriter("data/usuarios/usuarios.txt");
			for (int i  = 0; i<usuario.getSize();i++) {
				Usuario u = usuario.getElement(i);
				myWriter.write(u.toString());
				myWriter.write("\n");
			}
			myWriter.close();
		}
		catch (IOException e) {
			System.out.println("Error salvando el invetario");
		}
	}
	
	public static void reiniciarUsuarios() {
		usuario.clear();
	}
	
	public static boolean registroUsuarioUsername(String username) throws Exception {
		boolean usuarioCorrecto = nombreDuplicado(username);
		if (username.length() == 0 || usuarioCorrecto == true) {
			return false;
		}
		return true;
	}
	
	public static boolean registroUsuarioContraseña(String contraseña) {
		if (contraseña.length() < 5) {
			return false;
		}
		return true;
	}
	
	public static void registroUsuario(String username, String contraseña, String nombre, int edad) {
		int id = usuario.getSize() + 1;
		Usuario u = new Usuario(username,contraseña,nombre, edad, id);
		usuario.add(u);
	}
	
	public static boolean loginUsuario(String username, String contraseña) throws Exception {
		Usuario user = usuario.getUser(username);
		//System.out.println(usuarioH.get(contraseña));
		int id = user.getId();
		boolean usuarioCorrecto = nombreCorrecto(username,id);
		boolean contraseñaCorrecta = contraseñaCorrecta(contraseña,id);
		if(usuarioCorrecto == true && contraseñaCorrecta == true) {
			return true;
		}
		return false;
	}
	
	private static boolean nombreCorrecto(String username,int id) throws Exception {
		if(((usuario.getUserById(id)).getUsername()).equals(username)) {
			System.out.println(id);
			return true;
		}
		return false;
	}
	
	private static boolean nombreDuplicado(String username) throws Exception {
		for (int i=0; i< usuario.getSize();i++) {
			if(((usuario.getElement(i)).getUsername()).equals(username)) {
				System.out.println(i);
				return true;
			}
		}
		return false;
	}
	
	static Usuario getUsuarioLog(String username) throws Exception {
		for (int i = 0; i < usuario.getSize();i++){
			if(((usuario.getElement(i)).getUsername()).equals(username)) {
				return usuario.getElement(i);
			}
		}
		return null;
	}
	
	private static boolean contraseñaCorrecta(String contraseña,int id) throws Exception {
			if(((usuario.getUserById(id)).getContraseña()).equals(contraseña)) {
				return true;
			}
			System.out.println((usuario.getElement(id)).getContraseña());
		return false;
	}
	
	public static boolean cambioContraseña(String actualContraseña,String nuevaContraseña) {
		if (actualContraseña.equals(nuevaContraseña)) {
			return true;
		}
		return false;
	}
	
	 /**
	  * Tomado de la pagina https://examples.javacodegeeks.com/core-java/io/file/4-ways-to-copy-file-in-java/
	  * @param ruta ruta de localizacion de la imagen
	  * @param usuario nombre del usuario al cual se le asignara la imagen
	  * @return si se ha guardado con exito
	  */
	public static boolean guardarImagen(String ruta,String usuario) {
		 File origin = new File(ruta);
	        File destination = new File("sources/imgUsuarios/"+ usuario +".jpg");
	        if (origin.exists()) {
	            try {
	                InputStream in = new FileInputStream(origin);
	                OutputStream out = new FileOutputStream(destination);
	                // We use a buffer for the copy (Usamos un buffer para la copia).
	                byte[] buf = new byte[1024];
	                int len;
	                while ((len = in.read(buf)) > 0) {
	                    out.write(buf, 0, len);
	                }
	                in.close();
	                out.close();
	                return true;
	            } catch (IOException ioe) {
	                ioe.printStackTrace();
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	
	public static ArrayList<String> subirBiografia(String ruta) {
		ArrayList<String> texto = new ArrayList<String>();
		String path = "data/usuarios/biografias/"+ ruta +".txt";
		@SuppressWarnings("unused")
		File archivo = new File(path);

		FileReader fr = null;
		BufferedReader entrada = null;
		try {
			fr = new FileReader(path);
			entrada = new BufferedReader(fr);

			while(entrada.ready()){
				texto.add(entrada.readLine());
			}

		} catch(IOException e) {
			e.printStackTrace();
		}finally{
			try{                    
				if(null != fr){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}	
		}
		return texto;
	}
	


	public static void guardarBiografia(String usuario,String descripcion) {
		try {
			FileWriter myWriter = new FileWriter("data/usuarios/biografias/"+usuario+".txt");
			myWriter.write(descripcion);
			myWriter.close();
		}
		catch (IOException e) {
			System.out.println("Error guardando");
		}
	}

		
}