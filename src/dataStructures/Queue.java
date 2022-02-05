package dataStructures;

import java.util.LinkedList;

class Queue <T> extends LinkedList {

	  private QueueNode<T> head;

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
	  
	    return deletedNode;
	  }

	  public boolean isEmpty() {
	    return head == null;
	  }

	}