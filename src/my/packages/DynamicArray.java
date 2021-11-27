class DynamicArray {

	private Negocio arr[];
	private int count;


	public DynamicArray(int length){ 
    arr = new Negocio[length]; 
  }

  public DynamicArray(){
    arr = new Negocio[4];
  }
	public void printArray(){
		for (int i = 0; i < this.size(); i++) {
      try {
        Negocio current = this.get(this.size() - i - 1);
        String name = current.getNombre();
        System.out.println(name);

      } catch (Exception e) {
        System.out.println("Exception");
      }
    }
	}

	public void insert(Negocio element){

		if (arr.length == count) {
			Negocio newArr[] = new Negocio[2 * count];
			for (int i = 0; i < count; i++) {
				newArr[i] = arr[i];
      }
			arr = newArr;
		}
		arr[count++] = element;
	}
  public void Upgrade(int index, String Dato, int m){
    switch (m){
      case 1: this.get(index).setNombre(Dato);;
      break;
      case 2: this.get(index).setClave(Dato);
      break;
      default: System.out.println("No funciona :v");
    }
  }

  public int size(){
    return count;
  }

  public Negocio remove(int n){
    Negocio retorno = arr[n];
    if(size()!=0){
      for(int i=n; i<count;i++){
        arr[i] = arr[i+1];
      }
      //arr[count]=null;
      count--;
    }
    return retorno;
  }

  public Negocio get(int index){
    Negocio retorno = null;
    if(size()!=0 && index < count){
      retorno = arr[index];
    }
    return retorno;
    
  }
}
