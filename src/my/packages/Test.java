import java.util.*;

class Test {
  
  private DoubleLinkedList list;
  private DynamicArray list1;

  public Test(DoubleLinkedList list,DynamicArray list1) {
    
    // Clear screen block
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    // End cls sc

    this.list = list;
    this.list1 = list1;
    this.display();
  }


  public void display() {
    System.out.println("\nIngresa el numero de elementos a agregar (-1 para volver al menú):");

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();


    if(n > 0) {
      
    // Clear screen block
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    // End cls sc

      this.testing(n);
    }
    Menu menu = new Menu(list,list1);

  }



  public void testing(int n) {
    
    //DoubleLinkedList list = new DoubleLinkedList();
    long startTime = System.nanoTime();
    for(int i = 0 ; i < n ; i++) {
      //Random random = new Random();
      String currentName = "Negocio"+i;
      /*random.ints(48,122+1)
      .filter(j -> (j<=57 || j >=65) && (j<=90 || j>=97)).limit(stringlength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();*/
      //Strings randoms
      String currentClave = "clave"+i; 
      /*random.ints(48,122+1)
      .filter(j -> (j<=57 || j >=65) && (j<=90 || j>=97)).limit(5)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();*/
      
      Negocio current = new Negocio(currentName, currentClave);
      
      list.add(current);
    }
    long endTime = System.nanoTime() - startTime ;

    System.out.println("Se agregaron " + n + " elementos a la lista doblemente enlazada!!!");
    
    //Conversion de nanosegundos a segundos
    double secTime = endTime / 1000000000.0;
    System.out.println("El tiempo de inserción es: "+String.format("%.6f", secTime)+" (s)");
    System.out.println("La lista tiene ahora " + list.getSize() + " elementos. \n");
    
    System.out.println("#=========================================#");
    //Arraglo dinamico
    long startTime1 = System.nanoTime();
    for(int i = 0 ; i < n ; i++) {
      //Random random = new Random();
      String currentName = "Negocio"+i;
      /*random.ints(48,122+1)
      .filter(j -> (j<=57 || j >=65) && (j<=90 || j>=97)).limit(stringlength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();*/
      //Strings randoms
      String currentClave = "clave"+i; 
      /*random.ints(48,122+1)
      .filter(j -> (j<=57 || j >=65) && (j<=90 || j>=97)).limit(5)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();*/
      
      Negocio current = new Negocio(currentName, currentClave);
      
      list1.insert(current);
    }
    long endTime1 = System.nanoTime() - startTime ;

    System.out.println("Se agregaron " + n + " elementos al array dinamico!!!");
    System.out.println("La lista dinamica tiene ahora " + list1.size() + " elementos.");
    //Conversion de nanosegundos a segundos
    double secTime1 = endTime1 / 1000000000.0;
    System.out.println("El tiempo de inserción es: "+String.format("%.6f", secTime1)+" (s)");
    System.out.println("La lista dinamica tiene ahora " + list1.size() + " elementos. \n");
    System.out.println();
    
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

    // Testeando busqueda
    Menu menu = new Menu(list,list1);
    //Busqueda b = new Busqueda(list);

    //printList(list);

  }

/*
  public void printList(DoubleLinkedList list) {
    
    System.out.println("\n **IMPRIMIENDO NOMBRES** \n");
    
    for(int i = 0 ; i < list.getSize() ; i++) {
      try {
        Negocio current = list.getElement(list.getSize() - i - 1);
        String name = current.getNombre();
        System.out.println(name);
        
      } catch(Exception e) {
        System.out.println("Exception");
      }
    }
  
    System.out.println("");
    System.out.println("#################");
    System.out.println("");
  
  }
*/


}