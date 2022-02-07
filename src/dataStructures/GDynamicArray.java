package dataStructures;

// Array dinámico genérico para map en hash
/**
 * @author Valentina Colmenares, Daniel Lozano & Kevin Rincón
 * 
 */
class GDynamicArray <T> {
  
  private T[] staticArray;
  private int size;
  private int capacity;
  
  public GDynamicArray(int initSize) {
    staticArray = (T[]) new Object[initSize];
    size = initSize;
    capacity = initSize;
  }

  public void pushBack(T value) {
    if(size == capacity) {
      T[] newArray = (T[]) new Object[2*capacity];
      for(int i = 0 ; i < capacity ; i++) {
        newArray[i] = staticArray[i];
      }
      capacity *= 2;
      staticArray = newArray;
    }

    staticArray[size] = value;
    size += 1;
  }

  public void popBack() throws Exception {
    if(size == 0) {
      throw new Exception("Null Array");
    }
    size -= 1;
  }

  public T popFront() throws Exception {
    T removedValue = null;
    if(size == 0) {
      throw new Exception("Null Array");
    }
    try {
      removedValue = remove(0);
    } catch(Exception e) {
      System.out.println(e);
    }
    return removedValue;
  }


  public T remove(int index) throws Exception {
    if(size == 0) {
      throw new Exception("Null Array");
    }
    T removedValue = staticArray[index];
    for(int i = index ; i < size - 1; i ++) {
      staticArray[i] = staticArray[i + 1];
    }
    size -= 1;
    return removedValue;
  }

  public void deleteValue(T value) throws Exception {
    boolean found = false;
    for(int i = 0 ; i < size ; i ++) {
      T currentValue = staticArray[i];
      if(currentValue == value) {
        found = true;
        try {
          remove(i);
        } catch(Exception e) {
          System.out.println(e);
        }
      }
    }

    if(!found) {
      throw new Exception("Element not found");
    }
  }

  public T getValue(int index) {
    return staticArray[index];
  }

  public void setValue(int index, T value) {
    staticArray[index] = value;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}