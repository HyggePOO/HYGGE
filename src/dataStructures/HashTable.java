package dataStructures;
import java.util.Random;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rincón
 * 
 */
public class HashTable {

  // La clase HashTable tiene como función consultar si una clave hace parte de un usuario
  // En cada casilla del array habrá un Queue<HashNode>
  
  // Se crearán dos HashTables, nombres de usuarios y claves. En el loggeo se comparará que la clave ingresada esté en el índice hash(clave), de tal modo que hash(clave) = hash(usuario_ingresado)

  // Para reparar la cardinalidad entre ambos hash's, hash_clave = hash(hash(usuario))

  // La clase contiene HashNodes, los cuales contienen Strings, ya sean de nombre de usuario o de clave

  // En teoría la clase ya debe funcionar, falta hacer pruebas con cadenas y después implementarla en el loggeo

  public GDynamicArray<Queue<HashNode>> map;
  public int cardinality;
  public int size;
  public int hashParameter;
  public int primeNum;
  final double LoadFactor =0.75;

  public HashTable(int cardinality) {
    // Creamos el hash table
    this.cardinality = cardinality;
    map = new GDynamicArray<Queue<HashNode>>(cardinality);
    for (int i=0;i<cardinality;i++){
        map.pushBack(new Queue());
    }
    // Establecer una función hash (Tomamos un número primo y un valor de x aleatorio: 1 <= x <= -1)
    
    primeNum = 10000019;
    Random randomGenerator = new Random();
    hashParameter = randomGenerator.nextInt(primeNum);
    size=0;
  }

  public int polyHash(String str) {
    // Función hash;
    int hash = 0;
    int strLength = str.length();
    for(int i = strLength - 1 ; i >= 0 ; i--) {
      hash = (hash*hashParameter + str.charAt(i))%primeNum;
    }
    return Math.abs(hash%cardinality);
  }


  public void set(String key, int value)  {
    
    // La función agrega elementos al HashMap
    
    // Pueden haber errores en este bloque (IndexOutOfBounds Exception) porque polyHash() quizás retorne un valor fuera del rango del array dinámico
    
    int hashValue = polyHash(key);
    Queue<HashNode> L = map.getValue(hashValue);

    // Recorremos la lista enlazada L presente en su correspondiente casilla
    int sizeQueue = 0;
    if(L!=null){
       sizeQueue = L.size; // Tamaño de la lista enlazada
    }else{
        map.setValue(hashValue, new Queue());
        L = map.getValue(hashValue);
    } // Tamaño de la lista enlazada
    for(int i = 0 ; i < sizeQueue ; i++) {
      
      
        HashNode currentHashNode = L.getValue(i).getData();
        // Comparamos que el nombre del negocio key esté en la lista
        if(key == currentHashNode.key) {
         currentHashNode.value = value;
         return;
        }
      
    }

    // En caso de que el elemento no esté en esta casilla del map, lo agregamos

    HashNode hashNode = new HashNode(key, value);
    L.enqueue(hashNode);
    this.size++;
    double loadFactor =(1.0*this.size)/cardinality;
    //System.out.println(loadFactor+" "+value);
    if(loadFactor>LoadFactor){
        rehash();
    }
  }
  public void rehash() {
      
      GDynamicArray<Queue<HashNode>> copia = map;
      
      map = new GDynamicArray<Queue<HashNode>>(cardinality*2);
      
      for(int i=0;i<cardinality*2;i++){
          map.pushBack(new Queue());
      }
      
      this.size=0;
      this.cardinality *=2;
      
      for(int i=0;i<copia.getSize();i++){
          Queue<HashNode> Copia2 = copia.getValue(i);
          int sizeQ=0;
          if(Copia2!=null){
              sizeQ=Copia2.size;
          }
          //System.out.println("Re-Insert");
          for (int j=0;j<sizeQ;j++){
              String key = Copia2.getValue(j).getData().key;
              int value = Copia2.getValue(j).getData().value;
              
              set(key,value);
          }
      }
  }
  public boolean hashKey(String key) {
    // Retorna true si se encuentra el elemento dentro del HashMap
    boolean found = false;    
    int hashValue = polyHash(key);
    Queue<HashNode> L = map.getValue(hashValue);
    if(L == null) {
    	return false;
    }
    int sizeQ = L.size;
    for(int i = 0 ; i < sizeQ ; i++) {
      
      try {
        HashNode currentHashNode = L.getValue(i).getData();
        // Comparamos que el nombre del negocio key esté en la lista
        if(key.equals(currentHashNode.key)) {
         found = true;
        }
      } catch(Exception e) {
        System.out.println(e);
      }
    }

    return found;
  }


  public int get(String key) throws Exception {
    // Retorna el valor del objeto buscado en caso de existir en el HashMap. Arroja una excepción si no existe el elemento.
    int value = -1;

    int hashValue = polyHash(key);
    Queue<HashNode> L = map.getValue(hashValue);

    int sizeQ = L.size;
    for(int i = 0 ; i < sizeQ ; i++) {
      
      try {
        HashNode currentHashNode = L.getValue(i).getData();
        // Comparamos que el nombre del negocio key esté en la lista
        if(key.equals(currentHashNode.key) ) {
          return currentHashNode.value;
        }
      } catch(Exception e) {
        System.out.println(e);
      }
    }
  
    if(value == -1) {
      throw new Exception("El elemento no existe");
    }
    return value;
  }
  
  public void delete(String key) throws Exception{
	    int borrar = get(key);
	    map.remove(borrar);
	    size--;
	  }
  
  public void clear() throws Exception{
	  while(size!=0) {
		  map.remove(size);
		  size--;
	  }
  }
  
}