package dataStructures;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rincón
 * 
 */
class QueueNode <T> {
	  private T data;
	  private QueueNode<T> next;

	  public QueueNode(T data) {
	    this.data = data;
	    next = null;
	  }

	  public T getData() {
	    return this.data;
	  }

	  public QueueNode<T> getNext() {
	    return this.next;
	  }

	  public void setData(T data) {
	    this.data = data;
	  }

	  public void setNext(QueueNode<T> next) {
	    this.next = next;
	  }


	}