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

import data.Negocio;
import data.NegocioBusqueda;
import data.Usuario;
import dataStructures.BinaryTree;
import dataStructures.DoubleLinkedList;




public class ManagerDeNegocio extends AdmUsuario{
	private String fileName;

	
	
	public ManagerDeNegocio(String fileName) {
		this.fileName= fileName;
	}
	
	static void registrandoNegocio(Negocio n) {
		negocio.add(n);
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
		String bname = sc.next().trim();
		String nombre = sc.next().trim();	
		String contraseña = sc.next().trim();
		double calificacion = Double.parseDouble(sc.next().trim());
		String categoriaUbicacion = sc.next().trim();
		String categoriaFuncion =sc.next().trim();
		String ciudad = sc.next().trim().toLowerCase();
		String direccion = sc.next().trim().toLowerCase();
		int numeroVotos = Integer.parseInt(sc.next().trim());
		int id = Integer.parseInt(sc.next().trim());
		sc.close();
		Negocio n = new Negocio(bname,nombre,contraseña,calificacion,categoriaUbicacion,categoriaFuncion,ciudad,direccion,numeroVotos, id);
		NegocioBusqueda nb = new NegocioBusqueda(nombre,categoriaFuncion,ciudad,calificacion,numeroVotos);
		negocioBus.add(nb);
		negocio.add(n);
		System.out.println("Negocio "+ bname + " añadido.");

	}

	public DoubleLinkedList<Negocio> getNegocios() {
		return negocio;

	}
	
	public ArrayList<NegocioBusqueda> getBuscadorNegocios() {
		return negocioBus;
	}
	
	public void writingRecords() throws Exception {
		try {
			FileWriter myWriter = new FileWriter("data/negocios/negocios.txt");
			//negocio.allPostOrder();
			for (int i  = 0; i< negocio.getSize();i++) {
				Negocio n = negocio.getElement(i);
				myWriter.write(n.toString());
				myWriter.write("\n");
			}
			myWriter.close();
		}
		catch (IOException e) {
			System.out.println("Error guardando la lista");
		}
	}
	
	public static void reiniciarNegocios() {
		negocio.clear();
	}
	
	public static void reiniciarNegociosBusqueda() {
		negocioBus.clear();
	}
	
	public static void registroNegocio(String bname,String nombre,String contraseña, double calificacion, String categoriaUbicacion,String categoriaFuncion, String ciudad,String direccion) {
		int id = negocio.getSize() + 1;
		int numeroVotos = 0;
		Negocio n = new Negocio(bname,nombre,contraseña,calificacion,categoriaUbicacion,categoriaFuncion,ciudad,direccion,numeroVotos, id);
		negocio.add(n);
	}
	
	public static boolean registro(String bname,String nombre, String contraseña, String categoriaU, String categoriaF, String ciudad) throws Exception {
		boolean bnameDuplicado = bnameDuplicado(bname);
		boolean nombreDuplicado = nombreDuplicado(nombre);
		boolean categoriaUCorrecta = true;
		boolean categoriaFCorrecta = true;
		boolean ciudadCorrecta = true;
		boolean contraseñaCorrecta = true;
		if(categoriaU == null) {
			categoriaUCorrecta = false;
		}
		if(categoriaF == null) {
			categoriaFCorrecta = false;
		}
		if(ciudad == null) {
			ciudadCorrecta = false;
		}
		if(contraseña ==null) {
			contraseñaCorrecta = false;
		}
		if(bnameDuplicado == true || nombreDuplicado == true || contraseñaCorrecta == false|| categoriaUCorrecta == false || categoriaFCorrecta == false || ciudadCorrecta == false) {
			return false;
		}
		return true;
	}
	
	public static void cambioLista(ArrayList<NegocioBusqueda> arr) {
		negocioBus = arr;
	}
	
	static Negocio getNegocioLog(String username) throws Exception {
		for (int i=0; i< negocio.getSize();i++) {
			if(((negocio.getElement(i).getbName()).equals(username))) {
				return negocio.getElement(i);
			}
		}
		return null;
	}
	
	static Negocio getNegocioL(String username) throws Exception {
		for (int i=0; i< negocio.getSize();i++) {
			if(((negocio.getElement(i).getNombre()).equals(username))) {
				return negocio.getElement(i);
			}
		}
		return null;
	}
	
	
	
	public static boolean loginNegocio(String username, String contraseña) throws Exception {
		boolean usuarioCorrecto = bnameDuplicado(username);
		int id = getId(username);
		boolean contraseñaCorrecta = contraseñaDuplicada(contraseña,id);
		if(usuarioCorrecto == true && contraseñaCorrecta == true) {
			return true;
		}
		return false;
	}
	
	public static boolean nombreDuplicado(String nombre) throws Exception{
		for (int i = 0; i < negocio.getSize(); i++) {
			if((negocio.getElement(i).getNombre().equals(nombre))){
				System.out.println(i);
				return true;			
			}
		}
		return false;
	}
	
	public static boolean bnameDuplicado(String bname) throws Exception {
		for (int i = 0; i < negocio.getSize(); i++) {
			if((negocio.getElement(i).getbName().equals(bname))){
				System.out.println(i);
				return true;			
			}
		}
		return false;
	}
	
	
	public static int getId(String username) throws Exception {
		for (int i = 0; i < negocio.getSize();i++){
			if(((negocio.getElement(i)).getbName()).equals(username)) {
				return i;
			}
		}
		return 0;
	}
	
	private static boolean contraseñaDuplicada(String contraseña, int id) throws Exception {
		if((negocio.getElement(id).getContraseña().equals(contraseña))) {
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
	
	public static boolean registroNegocioContraseña(String contraseña) {
		if (contraseña.length() < 5) {
			return false;
		}
		return true;
	}
	
	public static int getSize() {
		return negocio.getSize();
	}
	
	 /**
	  * Tomado de la pagina https://examples.javacodegeeks.com/core-java/io/file/4-ways-to-copy-file-in-java/
	  * @param ruta ruta de localizacion de la imagen
	  * @param usuario nombre del usuario al cual se le asignara la imagen
	  * @return si se ha guardado con exito
	  */
	
	public static boolean guardarImagen(String ruta,String usuario) {
		 File origin = new File(ruta);
	        File destination = new File("sources/imgNegocios/"+ usuario +".jpg");
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
	
	
	public static ArrayList<String> subirDescripcion(String ruta) {
		ArrayList<String> texto = new ArrayList<String>();
		String path = "data/negocios/descripciones/"+ ruta +".txt";
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
	


	public static void guardarDescripcion(String negocio,String descripcion) {
		try {
			FileWriter myWriter = new FileWriter("data/negocios/descripciones/"+negocio+".txt");
			myWriter.write(descripcion);
			myWriter.close();
		}
		catch (IOException e) {
			System.out.println("Error guardando");
		}
	}
}