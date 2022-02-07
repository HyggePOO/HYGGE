package dataStructures;

import data.Negocio;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rincón
 * 
 */
class AVLNode {
	  
	  public AVLNode hIzq;
	  public AVLNode hDer;
	  public AVLNode parent;
	  public Negocio dato;
	  public int height;

	  public AVLNode(Negocio elemento){
	    this.dato = elemento;
	    this.hIzq = null;
	    this.hDer = null;
	    this.height = 1;
	  }

	  public void appropiateChild(AVLNode node) {
	    
	    if(node.dato.maxTo(this.dato) > 0) {
	      this.hIzq = node;
	    }
	    if(node.dato.maxTo(this.dato) < 0) {
	      this.hDer = node;
	    }
	  }

	}