import java.util.Scanner;

class Menu {

  private DoubleLinkedList list;
  private DynamicArray list1;

  public Menu(DoubleLinkedList list,DynamicArray list1){
    
    // Clear screen block
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    // End cls sc
    
    this.list=list;
    this.list1=list1;
    Scanner sc = new Scanner(System.in);
    

    while(true){
      
      System.out.println("\n####= MENU =####\n Introduzca: \n 1 para el modo de testeo: \n 2 para buscar un elemento: \n 3 para eliminar un elemento:\n 4 para actualizar un elemento: \n -1 para salir");
      
      try {
        int n = sc.nextInt();

        switch (n){
          case 1: Test testobj = new Test(list,list1);
          break;
          case 2: Busqueda b = new Busqueda(list,list1);
          break;
          case 3: Eliminar e = new Eliminar(list,list1);
          break;
          case 4: Actualizar a = new Actualizar(list,list1);
          break;
          case -1: System.exit(0);
          break;
          default: System.out.println("Entrada inválida");
        }
      } catch(Exception e) {
        sc.nextLine();
        System.out.println("Entrada inválida");
      }  
    }

  }
}