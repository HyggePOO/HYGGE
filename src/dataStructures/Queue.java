package dataStructures;

import java.util.LinkedList;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rincón
 * 
 */
class Queue <T> extends LinkedList {

	  private QueueNode<T> head;
	  public int size;

	  public Queue() {
	    this.head = null;
	  }


	  public void enqueue(T data) {
	    QueueNode<T> newNode = new QueueNode(data);

	    if(head == null) {
	      head = newNode;
	    } else {
	      QueueNode<T> aux = head;
	      while(aux.getNext() != null) {
	        aux = aux.getNext();
	      }
	      aux.setNext(newNode);
	    }
	    size += 1;
	  }

	  public QueueNode<T> dequeue() throws Exception {
	    
	    QueueNode<T> deletedNode = head;
	    if(head == null) {
	      System.out.println("Null queue");
	      throw new Exception("Null queue");
	    } else {
	      head = head.getNext();
	      deletedNode.setNext(null);
	    }
	    size -= 1;
	    return deletedNode;
	  }

	  public boolean isEmpty() {
	    return head == null;
	  }
	  
	  public QueueNode<T> getValue(int index) {
		    if(isEmpty()) {
		      return null;
		    }

		    QueueNode<T> value = null;
		    QueueNode<T> aux = head;
		    int counter = 0;
		    while(aux != null) {
		      if(counter == index) {
		        value = aux;
		        break;
		      }
		      counter += 1;
		      aux = aux.getNext();
		    }

		    return value;
		  }

	}