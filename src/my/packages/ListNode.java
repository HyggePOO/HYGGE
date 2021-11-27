class ListNode {

  public ListNode next;
  public ListNode prev;
  public Negocio element;
  

  public ListNode(Negocio element) {
    this.element = element;
    this.next = null;
    this.prev = null;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public void setPrev(ListNode prev) {
    this.prev = prev;
  }


}