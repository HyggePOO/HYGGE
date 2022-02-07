package dataStructures;

import java.util.Arrays;
/**
 * @author Valentina Colmenares, Daniel Lozano & Kevin Rinc�n
 * 
 */
public class HashMap {
	
	private String [] arreglo;
	private int tama�o;
	private int contador;
	
	public HashMap(int tam) {
		tama�o=tam;
		arreglo= new String[tam];
		Arrays.fill(arreglo,"-1");
	}
	
	public void funcionHash(String[] cadenaArreglo, String[] arreglo) {
		for (int i=0;i<cadenaArreglo.length;i++) {
			String elemento = cadenaArreglo[i];
			char[] cadenaChars = new char[elemento.length()];
			/*for (int j=0; j<elemento.length(); j++) {
				cadenaChars[i] = elemento.charAt(i); 
			}*/
			int indiceArreglo = Integer.parseInt(elemento)%7;
			System.out.println("El indice es "+ indiceArreglo);
			while(arreglo[indiceArreglo]!="-1") {
				indiceArreglo++;
				System.out.println("Ocurrio una colision en " +indiceArreglo);
				indiceArreglo %=tama�o;
			}
			arreglo[indiceArreglo] = elemento;
		}
		
	}

}
