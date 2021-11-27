import java.util.*;

class Eliminar {
  
  private DoubleLinkedList list;
  private DynamicArray list1;
  
  public Eliminar(DoubleLinkedList list,DynamicArray list1){
    
    // Clear screen block
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    // End cls sc

    this.list=list;
    this.list1=list1;
    this.Display();
  }
  public void Display(){
    
    if(list.isEmpty()){
      System.out.println("La lista está vacia\n");
      

      Scanner scan = new Scanner(System.in);
      // Continue block
      System.out.println("\nDigite cualquier tecla para continuar...");
      try {
        int input = scan.nextInt();
      } catch (Exception e){
          try {
            if(!scan.hasNext()) {
              scan.nextLine();
            }
            String input = scan.nextLine();
          } catch (Exception e1){
          }
      }
      // End of Continue block
      
      Menu menu = new Menu(list,list1);
    }

    System.out.println("\nDigite el indice del elemento a eliminar (-1 para salir):");

    Scanner scan = new Scanner(System.in);

    int index = scan.nextInt();
    if (index < 0){
      Menu menu = new Menu(list,list1);
    }
    if (index >= list.getSize()){
      System.out.println("++El tamaño de la lista es más pequeño que la posición ingresada");
      Display();
    } 
    
    // Clear screen block
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    // End cls sc
    
    try {
      long startTime = System.nanoTime();
      Negocio element = list.remove(index); 
      long endTime = System.nanoTime() - startTime ;
      System.out.println("Imprimiendo info para elemento " + index + " utilizando una lista doblemente enlazada \n");
      displayElement(element,endTime);
      System.out.println("La lista doblemente enlazada ahora tiene " + list.getSize() + " elementos.\n");

      System.out.println("#=========================================#");
      //Mostrando info del arreglo dinamico
      long startTime1 = System.nanoTime();
      Negocio element1 = list1.remove(index); 
      long endTime1 = System.nanoTime() - startTime1 ;
      System.out.println("Imprimiendo info para elemento " + index + " utilizando un arreglo dinámico \n");
      displayElement(element1,endTime1);
      System.out.println("La lista dinámica ahora tiene " + list1.size() + " elementos.\n");

      // Continue block
      System.out.println("\nDigite cualquier tecla para continuar...");
      try {
        int input = scan.nextInt();
      } catch (Exception e){
          try {
            if(!scan.hasNext()) {
              scan.nextLine();
            }
            String input = scan.nextLine();
          } catch (Exception e1){
          }
      }
      // End of Continue block

      Menu menu = new Menu(list,list1);

    }catch(Exception e) {
      System.out.println("Entrada inválida");
    }
  }
  public void displayElement(Negocio element,long time){
    double secTime = time / 1000000000.0;
    System.out.println("INFORMACIÓN del elemento borrado:");

    System.out.println("Nombre del negocio:\t" + element.getNombre());
    System.out.println("Clave del negocio:\t" + element.getClave());
    // Tiempo de prueba para busqueda en segundos
    System.out.println("El tiempo de busqueda es: "+String.format("%.6f", secTime)+" (s)");
    System.out.println();
    //System.out.println(list.getSize());
    /*try{
      list.printList();
    }catch(Exception e){
      System.out.println("Error");
    }*/
  }
}