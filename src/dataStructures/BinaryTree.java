package dataStructures;

import java.util.ArrayList;

import data.Negocio;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rincón
 * 
 */
public class BinaryTree{

	  private BinaryNode root;
	  public int numeroNodos;
	  private ArrayList<Negocio> arrayNegocio = new ArrayList<Negocio>();
	  
	  
	  public BinaryTree(){
	    this.root = null;
	    this.numeroNodos = 0;
	  }

	  
	  public void insertBST(Negocio negocio){
	    root = insert(negocio,root);
	  }

	  private BinaryNode insert(Negocio n,BinaryNode p){
	    if(p==null){
	      p = new BinaryNode(n);
	      arrayNegocio.add(n);
	      numeroNodos++;
	      //p = nodo;
	    }else{
	      if(n.maxTo(p.dato)<0){
	        p.hIzq=insert(n,p.hIzq);
	      }else{
	        p.hDer=insert(n,p.hDer);
	      }
	    }
	    return p;
	  }

	  public void removeBST(Negocio negocio){
	    root = remove(negocio, root);
	  }

	  private BinaryNode remove(Negocio n,BinaryNode p){
	    if(p!=null){
	      if(n.maxTo(p.dato)<0){
	        p.hIzq = remove(n,p.hIzq);
	      }else{
	        if(n.maxTo(p.dato)>0){
	          p.hDer = remove(n,p.hDer);
	        }else{
	          if(p.hIzq == null && p.hDer == null){
	            p = null;
	          }else{
	            if(p.hIzq==null){
	              p=p.hDer;
	            }else{
	              if(p.hDer==null){
	                p=p.hIzq;
	              }else{
	                BinaryNode t = findMin(p.hDer);
	                p.dato = t.dato;
	                p.hDer = remove(p.dato,p.hDer);
	              }
	            }
	          }
	        }
	      }
	    }
	    return p;
	  }

	  private BinaryNode findMin(BinaryNode p){
	    if(p!=null){
	      while(p.hIzq !=null){
	        p= p.hIzq;
	      }
	    }
	    return p;
	  }

	  private BinaryNode findMax(BinaryNode p){
	    if(p!=null){
	      while(p.hDer != null){
	        p = p.hDer;
	      }
	    }
	    return p;
	  }

	  

	  
	  public void allTraverse(){
		  if (root !=null){
		      traverse(root); 
		    }
	  }
	  
	  public void traverse(BinaryNode p){
	    if(p.hIzq != null){
	      traverse(p.hIzq);
	    }
	    System.out.println(" " +p.dato.getNombre());
	    if(p.hDer !=null){
	      traverse(p.hDer);
	    }
	  }

	  public ArrayList<Negocio> allPrintB(){
		  return arrayNegocio;
	  }
	  
	  
	  public void allPostOrder() {
		  if(root!=null) {
			  postOrder(root);
		  }
	  }
	  
	    public void postOrder(BinaryNode node){
	        if (node == null) {
	            return;
	        }
	        postOrder(node.hIzq);
	        postOrder(node.hDer);
	        System.out.print(node.dato.getbName() + " ");
	    }
	  
	  public void limpiarArray() {
		  this.arrayNegocio.clear();
	  }
	  
	  

	  public void findItem(Negocio negocio){
	    if(root!=null){
	      find(negocio,root);
	    }
	  }

	  public Negocio find(Negocio negocio,BinaryNode p){
	    if(p.hIzq!=null){
	      if(negocio.equals(p.hIzq.dato)){
	        return negocio;
	      }
	      find(negocio,p.hIzq);
	    }
	    if(p.hDer !=null){
	      if(negocio.equals(p.hDer.dato)){
	        return negocio;
	      }
	      find(negocio, p.hDer);
	    }
	    return negocio;
	  }

	    public Negocio traverseFindbName(String valor,BinaryNode p){
	      if (p==null || p.dato.getbName().equals(valor)){ 
	        return p.dato; 
	      }
	        if (p.dato.getbName().compareTo(valor)>0){
	            return traverseFindbName(valor, p.hIzq); 
	        }
	        return traverseFindbName(valor, p.hDer); 
	  }

	  public Negocio allTraverseFindbName(String negocio){
	    Negocio currentNegocio = null;
	    if(root!=null){
	      currentNegocio = traverseFindbName(negocio,root);
	    }
	    if(currentNegocio == null) {
	    	return null;
	    }
	    return currentNegocio;
	  }

	  public Negocio removeElement(String valor){
	    Negocio currentNegocio = allTraverseFindbName(valor);
	    removeBST(currentNegocio);
	    numeroNodos--;
	    return currentNegocio;
	  }
	  
	    public Negocio traverseFindName(String valor,BinaryNode p){
		      if (p==null || p.dato.getNombre().equals(valor)){ 
		        return p.dato; 
		      }
		        if (p.dato.getNombre().compareTo(valor)>0){
		            return traverseFindName(valor, p.hIzq); 
		        }
		        return traverseFindName(valor, p.hDer); 
		  }

		  public Negocio allTraverseFindName(String negocio){
		    Negocio currentNegocio = null;
		    if(root!=null){
		      currentNegocio = traverseFindName(negocio,root);
		    }
		    if(currentNegocio == null) {
		    	return null;
		    }
		    return currentNegocio;
		  }

		  
		    public Negocio traverseFindPassword(String valor,BinaryNode p){
			      if (p==null || p.dato.getContraseña().equals(valor)){ 
			        return p.dato; 
			      }
			        if (p.dato.getContraseña().compareTo(valor)>0){
			            return traverseFindPassword(valor, p.hIzq); 
			        }
			        return traverseFindPassword(valor, p.hDer); 
			  }

			  public Negocio allTraverseFindPassword(String negocio){
			    Negocio currentNegocio = null;
			    if(root!=null){
			      currentNegocio = traverseFindPassword(negocio,root);
			    }
			    if(currentNegocio == null) {
			    	return null;
			    }
			    return currentNegocio;
			  }
	  /*public void Upgrade(int index, String Dato, int m){ 
	    String btf = "Negocio"+ String.valueOf(index);
	    switch (m){
	      case 1:this.allTraverseFind(btf).setNombre(Dato);
	      break;
	      case 2: this.allTraverseFind(btf).setClave(Dato);
	      break;
	      default: System.out.println("No funciona :v");
	    }
	  }*/

	  public boolean isEmpty() {
	    return root == null;
	  }
	  
	  public int size(){
	    return numeroNodos;
	  }


	public void clear() {
		root = null;
		
	}



	}