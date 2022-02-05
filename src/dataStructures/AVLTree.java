package dataStructures;

import java.util.*;

import data.Negocio;

public class AVLTree{
  public static AVLNode root;
  public static int size;

  
  public AVLTree() {
    root = null;
    size = 0;
  }


  public static void printInOrder(AVLNode node) {
    if(node == null) {
      return;
    }
    printInOrder(node.hIzq);
    System.out.print(node.dato + " ");
    printInOrder(node.hDer);
  }

  public static void printBreadthFirst(AVLNode node) {
    // Imprime los nombres por niveles
    
    if(node == null) {
      return;
    }
    Queue<AVLNode> q = new Queue<AVLNode>();
    q.enqueue(node);
    while(!q.isEmpty()) {
      try {
        AVLNode currentNode = q.dequeue().getData();
        System.out.print(currentNode.dato.getNombre() + " ");
        
        if(currentNode.hIzq != null) {
          q.enqueue(currentNode.hIzq);
        }
        if(currentNode.hDer != null) {
          q.enqueue(currentNode.hDer);
        }
      } catch(Exception e) {
        System.out.println("Exception in LevelTraversal");
      }
    }
    System.out.println();
  }

  public Negocio AVLfind(Negocio negocio){
    if(root!=null){
      AVLNode encontrado = find(negocio,root);
      return encontrado.dato;
    }
    return null;
  }

  public static AVLNode find(Negocio negocio, AVLNode node) {
    
    if(node!= null) {
      if(node.dato.maxTo(negocio) == 0) {
        return node;
      }
      else if(node.dato.maxTo(negocio) < 0) {
        if(node.hIzq != null) {
          return find(negocio, node.hIzq);
        }
      }
      else if(node.dato.maxTo(negocio) > 0) {
        if(node.hDer != null) {
          return find(negocio, node.hDer);
        }
      }
    }
    return node;
  }

  // Next Block

  public static AVLNode next(AVLNode node) {
  
    if(node != null) {
      if(node.hDer != null) {
        return leftDescendant(node.hDer);
      } else {
        return rightAncestor(node);
      }
    }

    return null;
  }

  public static AVLNode leftDescendant(AVLNode node) {
    if(node.hIzq == null) {
      return node;
    } else {
      return leftDescendant(node.hIzq);
    }
  }

  public static AVLNode rightAncestor(AVLNode node) {
    if(node.dato.maxTo(node.parent.dato) < 0) {
      return node.parent;
    } else {
      return rightAncestor(node.parent);
    }
  }

  // End of Next Block

  // Prev Block

  public static AVLNode prev(AVLNode node) {
    if(node != null) {
      if(node.hIzq != null) {
        return rightDescendant(node.hIzq);
      } else {
        return leftAncestor(node);
      }
    }
    return null;
  }

  public static AVLNode rightDescendant(AVLNode node) {
    if(node.hDer == null) {
      return node;
    } else {
      return rightDescendant(node.hDer);
    }
  }

  public static AVLNode leftAncestor(AVLNode node) {
    if(node.dato.maxTo(node.parent.dato) > 0) {
      return node.parent;
    } else {
      return leftAncestor(node.parent);
    }
  }

  // End of Prev Block

  public static void insert(Negocio negocio) {
    AVLNode P = find(negocio, root);
    AVLNode node = new AVLNode(negocio);
    
    if(P == null) {
      root = node;
    } else {
      if(P.dato.maxTo(negocio) > 0) {
        P.hDer = node;
      }
      else if(P.dato.maxTo(negocio) < 0) {
        P.hIzq = node;
      }
      node.parent = P;
    }

    size += 1;
  }

  public static AVLNode delete(AVLNode node){

    // Deletes node and returns the parent of the node replacing node (if exists)
    // En el caso de no existir replaceParent (Eliminación nodo sin hijos, nodo con un solo hijo) retornamos null. 
    
    // 
    AVLNode replaceParent = null;

    if(root == null) {
      System.out.print("Null BST");
    }

    if(node == null) {
      System.out.print("Node not found");
    } else {
      // If no child nodes
      if(node.hIzq == null && node.hDer == null) {

        // Delete this node (not replaced)
        if(node.parent != null) {
          if(node.dato.maxTo(node.parent.dato) <= 0) {
            node.parent.hIzq = null;
          } else {
            node.parent.hDer = null;
          }
        }
        node.parent = null;
      } else if(node.hIzq == null || node.hDer == null) {
        // If just one child node
        if(node.hIzq != null) {
          // right node is null
          // Delete node an replace by left child
          if(node.parent != null) {
            node.hIzq.parent = node.parent;
            node.parent.appropiateChild(node.hIzq);
          }
          node.parent = null;
          node.hIzq = null;
        } else {
          // left node is null
          // Delete node an replace by right child
          if(node.parent != null) {
            node.hDer.parent = node.parent;
            node.parent.appropiateChild(node.hDer);
          }
          node.parent = null;
          node.hDer = null;
        }
      } else {
        // Two nodes available
        // Delete node and replace by inorder succesor node
        // Finding the inorder succesor
        
        AVLNode inorderSucesor = prev(node);
        if(inorderSucesor == null) {
          inorderSucesor = next(node);
        }
        // Deleting and replacing
        node.dato = inorderSucesor.dato;
        replaceParent = inorderSucesor.parent;
      
        delete(inorderSucesor);
      
        if(replaceParent==null){
          System.out.println("Error");
        }
      
      }
    }

    size -= 1;

    return replaceParent;
  }



  // AVL methods

  public void AVLInsert(Negocio negocio) {
    insert(negocio);
    AVLNode node = find(negocio, root);
    rebalance(node);
  }


  public Negocio AVLDelete(Negocio negocio) {      
    
    // P toma valores nulos cuando eliminamos un nodo sin hijos o un nodo con un solo hijo
    AVLNode P = find(negocio, root);
    rebalance(delete(P));
    
    return P.dato;
  }


  // Rebalance Block

  public static void rebalance(AVLNode node) {
    AVLNode p=null;
    if(node!=null){
      p = node.parent;
    }
    
    if(node.hIzq == null || node.hDer == null) {
      if(node.hIzq != null) {
        if(node.hIzq.height > 1) {
          rebalanceRight(node);
        }
      } else if(node.hDer != null) {
        if(node.hDer.height > 1) {
          rebalanceLeft(node);
        }
      }
    } else {
      if(node.hIzq.height > node.hDer.height + 1) {
        rebalanceRight(node);
      } else if(node.hDer.height > node.hIzq.height + 1) {
        rebalanceLeft(node);
      }
    }

    adjustHeight(node);
  
    if(p != null) {
      rebalance(p);
    }
  }


  public static void fixHeight(AVLNode node) {
    // This function uses post-order for adjusting height after a first rotation (left-right, right-left case)

    if(node == null) {
      return;
    }else{
      fixHeight(node.hIzq);
      fixHeight(node.hDer);
      adjustHeight(node);
    }

    
  }


  public static void rebalanceLeft(AVLNode node) {
    AVLNode m = node.hDer;
    if(m.hIzq != null) {   
      if(m.hDer == null) {
        rotateRight(m);
        fixHeight(m.parent);        
      } else {
        if(m.hIzq.height > m.hDer.height) {
          rotateRight(m);
          fixHeight(m.parent);
        }
      }
    }
    rotateLeft(node);
  }

  public static void rebalanceRight(AVLNode node) {
    AVLNode m = node.hIzq;
    if(m.hDer != null) {
      if(m.hIzq == null) {
        rotateLeft(m);
        fixHeight(m.parent);
      } else {
        if(m.hDer.height > m.hIzq.height) {
          rotateLeft(m);
          fixHeight(m.parent);
        }
      }
    }
    rotateRight(node);
  }

  public static void rotateLeft(AVLNode node) {
    AVLNode p = node.parent;
    AVLNode y = node.hDer;
    AVLNode b = y.hIzq;
    y.parent = p;
    if(p != null) {
      p.appropiateChild(y);
    } else {
      root = y;
    }
    node.parent = y;
    y.hIzq = node;
    if(b != null) {
      b.parent = node;
    }
    node.hDer = b;
  }

  public static void rotateRight(AVLNode node) {
    AVLNode p = node.parent;
    AVLNode y = node.hIzq;
    AVLNode b = y.hDer;
    y.parent = p;
    if(p != null) {
      p.appropiateChild(y);
    } else {
      root = y;
    }
    node.parent = y;
    y.hDer = node;
    if(b != null) {
      b.parent = node;
    }
    node.hIzq = b;
  }


  public static void adjustHeight(AVLNode node) {
    if(node.hIzq == null || node.hDer == null) {
      if(node.hIzq != null) {
        node.height = 1 + node.hIzq.height;
      } else if(node.hDer != null) {
        node.height = 1 + node.hDer.height;
      } else {
        node.height = 1;
      }
    } else {
        node.height = (int) 1 + Math.max(node.hIzq.height, node.hDer.height);
    }
  }


  

  public Negocio traverseFind(String valor, AVLNode p){
      if (p==null || p.dato.getNombre().equals(valor)){ 
        return p.dato; 
      }
        if (p.dato.getNombre().compareTo(valor)>0){
            return traverseFind(valor, p.hIzq); 
        }
        return traverseFind(valor, p.hDer); 
  }

  public Negocio allTraverseFind(String negocio){
    Negocio currentNegocio = null;
    if(root!=null){
      currentNegocio = traverseFind(negocio,root);
    }
    return currentNegocio;
  }
/*
  public void Upgrade(int index, String Dato, int m){ 
    String btf = "Negocio"+ String.valueOf(index);
    switch (m){
      case 1: String newClave = this.allTraverseFind(btf).getClave();
      this.AVLDelete(this.allTraverseFind(btf));
      this.AVLInsert(new Negocio(Dato, newClave));
      break;
      case 2: this.allTraverseFind(btf).setClave(Dato);
      break;
      default: System.out.println("No funciona :v");
    }
  }
*/
  
  // End of Rebalance Block

}