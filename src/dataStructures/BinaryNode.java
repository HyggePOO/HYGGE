package dataStructures;

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