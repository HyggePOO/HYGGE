class Negocio {

  private String nombre;
  private String clave;

  public Negocio(String nombre, String clave) {
    this.nombre = nombre;
    this.clave = clave;
  }

  public void setNombre(String name){
    this.nombre=name;
  }
  public void setClave(String cl){
    this.clave= cl;
  }
  public String getNombre() {
    return this.nombre;
  }

  public String getClave() {
    return this.clave;
  }

  public int compareTo(Negocio n){
    if(this.nombre.equals(n.nombre)){
      return 1;
    }
    return 0;
  }

}