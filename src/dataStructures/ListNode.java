package dataStructures;

class ListNode<T> {

	  public ListNode<T> next;
	  public ListNode<T> prev;
	  public T element;
	  

	  public ListNode(T element) {
	    this.element = element;
	    this.next = null;
	    this.prev = null;
	  }

	  public void setNext(ListNode<T> next) {
	    this.next = next;
	  }

	  public void setPrev(ListNode<T> prev) {
	    this.prev = prev;
	  }

}