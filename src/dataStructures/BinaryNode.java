package dataStructures;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rinc�n
 * 
 */
import data.Negocio;

class BinaryNode{
	  
	  public BinaryNode hIzq;
	  public BinaryNode hDer;
	  public Negocio dato; 

	  public BinaryNode(Negocio elemento){
	    this.dato = elemento;
	    this.hIzq = null;
	    this.hDer = null;
	  }  

}