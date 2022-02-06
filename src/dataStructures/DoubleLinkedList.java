package dataStructures;

import data.Negocio;
import data.Usuario;

public class DoubleLinkedList<T> {

	  private ListNode<T> head;
	  private ListNode<T> tail;
	  private int size;

	  public DoubleLinkedList() {
	    this.head = null;
	    this.tail = null;
	    size = 0;
	  }

	  public void add(T element) {

	    // Crear nodo
	    ListNode<T> newNode = new ListNode<T>(element);

	    // Verifica si la lista está vacía
	    if (this.isEmpty()) {
	      head = tail = newNode;
	    } else {

	      // Asigna el nuevo nodo al final de la lista
	      tail.setNext(newNode);
	      newNode.setPrev(tail);
	      tail = newNode;
	    }

	    size += 1;

	  }
	  /*
	  public void Upgrade(int index, String Dato, int m) throws Exception{
	    if (this.isEmpty()) {
	      throw new Exception("Empty List");
	    }
	    switch (m){
	      case 1: ((Usuario) this.getElement(index)).setNombre(Dato);;
	      break;
	      case 2: ((Usuario) this.getElement(index)).setContraseña(Dato);
	      break;
	      default: System.out.println("No funciona :v");
	    }
	  }*/

	  public boolean isEmpty() {
	    return size == 0;
	  }

	  public T getElement(int index) throws Exception {

	    if (this.isEmpty()) {
	      throw new Exception("Empty List");
	    }

	    ListNode<T> aux = null;
	    aux = head;

	    T currentElement = null;

	    int cont = 0;

	    while (aux != null) {
	      if (cont == index) {
	        currentElement =  aux.element;
	        break;
	      }
	      aux = aux.next;

	      cont += 1;
	    }

	    if (currentElement == null) {
	      throw new Exception("Not found");
	    }

	    return currentElement;

	  }

	  public int getSize() {
	    return size;
	  }

	  /*
	  public void printList() throws Exception {
	    for (int i = 0; i < this.getSize(); i++) {
	      try {
	        T current = this.getElement(this.getSize() - i - 1);
	        String name = ((Usuario) current).getNombre();
	        System.out.println(name);

	      } catch (Exception e) {
	        System.out.println("Exception");
	      }
	    }
	  }*/

	public T remove(int ind) throws Exception {
	    if (this.isEmpty()) {
	      throw new Exception("Empty list");
	    }
	    T DeletedElement = null;
	    ListNode<T> ayu = null;
	    ayu = head;
	    int pos = 0;
	    while (ayu != null) {
	      if (pos == ind) {
	        //System.out.println(ayu.element.getNombre());
	        DeletedElement =  ayu.element;
	        if (ayu.prev == null) {
	          head=head.next;
	          head.setPrev(null);
	        } else if (ayu.next == null) {
	          tail = ayu.prev;
	          ayu.prev.setNext(null);
	        } else {
	          ayu.prev.setNext(ayu.next);
	          ayu.next.setPrev(ayu.prev);
	        }
	        break;
	      }
	      ayu = ayu.next;
	      pos++;
	    }
	    size--;
	    return DeletedElement;
	  }
	
	public void clear() {
		this.size = 0;
	}
	
	public Usuario getUser(String user) throws Exception {
		if (this.isEmpty()) {
		      throw new Exception("Empty List");
		    }
		    ListNode<Usuario> aux = null;
		    aux = (ListNode<Usuario>) head;
		    Usuario currentElement = null;
		    int cont = 0;
		    while (aux != null) {
		      if (aux.element.getUsername().equals(user)) {
		        currentElement =  aux.element;
		        break;
		      }
		      aux = aux.next;
		      cont += 1;
		    }
		    if (currentElement == null) {
		      throw new Exception("Not found");
		    }
		    return currentElement;
	}
	
	public Negocio getNegocio(String negocio) throws Exception {
		if (this.isEmpty()) {
		      throw new Exception("Empty List");
		    }
		    ListNode<Negocio> aux = null;
		    aux = (ListNode<Negocio>) head;
		    Negocio currentElement = null;
		    int cont = 0;
		    while (aux != null) {
		      if (aux.element.getbName().equals(negocio)) {
		        currentElement =  aux.element;
		        break;
		      }
		      aux = aux.next;
		      cont += 1;
		    }
		    if (currentElement == null) {
		      throw new Exception("Not found");
		    }
		    return currentElement;
	}

	public Usuario getUserById(int id) throws Exception {
		if (this.isEmpty()) {
		      throw new Exception("Empty List");
		    }
		    ListNode<Usuario> aux = null;
		    aux = (ListNode<Usuario>) head;
		    Usuario currentElement = null;
		    int cont = 0;
		    while (aux != null) {
		      if (aux.element.getId()==id) {
		        currentElement =  aux.element;
		        break;
		      }
		      aux = aux.next;
		      cont += 1;
		    }
		    if (currentElement == null) {
		      throw new Exception("Not found");
		    }
		    return currentElement;
	}
	public Negocio getNegocioById(int id) throws Exception {
		if (this.isEmpty()) {
		      throw new Exception("Empty List");
		    }
		    ListNode<Negocio> aux = null;
		    aux = (ListNode<Negocio>) head;
		    Negocio currentElement = null;
		    int cont = 0;
		    while (aux != null) {
		      if (aux.element.getId()==id) {
		        currentElement =  aux.element;
		        break;
		      }
		      aux = aux.next;
		      cont += 1;
		    }
		    if (currentElement == null) {
		      throw new Exception("Not found");
		    }
		    return currentElement;
	}
	
}