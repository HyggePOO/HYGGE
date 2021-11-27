class DoubleLinkedList {

  private ListNode head;
  private ListNode tail;
  private int size;

  public DoubleLinkedList() {
    this.head = null;
    this.tail = null;
    size = 0;
  }

  public void add(Negocio element) {

    // Crear nodo
    ListNode newNode = new ListNode(element);

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
  public void Upgrade(int index, String Dato, int m) throws Exception{
    if (this.isEmpty()) {
      throw new Exception("Empty List");
    }
    switch (m){
      case 1: this.getElement(index).setNombre(Dato);;
      break;
      case 2: this.getElement(index).setClave(Dato);
      break;
      default: System.out.println("No funciona :v");
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Negocio getElement(int index) throws Exception {

    if (this.isEmpty()) {
      throw new Exception("Empty List");
    }

    ListNode aux = null;
    aux = head;

    Negocio currentElement = null;

    int cont = 0;

    while (aux != null) {
      if (cont == index) {
        currentElement = aux.element;
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

  public void printList() throws Exception {
    for (int i = 0; i < this.getSize(); i++) {
      try {
        Negocio current = this.getElement(this.getSize() - i - 1);
        String name = current.getNombre();
        System.out.println(name);

      } catch (Exception e) {
        System.out.println("Exception");
      }
    }
  }

  public Negocio remove(int ind) throws Exception {
    if (this.isEmpty()) {
      throw new Exception("Empty list");
    }
    Negocio DeletedElement = null;
    ListNode ayu = null;
    ayu = head;
    int pos = 0;
    while (ayu != null) {
      if (pos == ind) {
        //System.out.println(ayu.element.getNombre());
        DeletedElement = ayu.element;
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
}