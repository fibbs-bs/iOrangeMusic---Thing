public class ListaCanciones{
  private int max;
  private int cant;
  private Cancion[] lista;

  public ListaCanciones(int max){
    lista = new Cancion[max];
    this.max=max;
    this.cant = 0;
  }
  public int getCant(){
    return cant;
  }

  public void setCant(int cant){
    this.cant = cant;
  }

  public int getMax(){
    return max;
  }


  public boolean agregarCancion(Cancion cancion) {
    if(cant<max) {
      lista[cant++] = cancion;
        return true;
    }
    return false;
  }
  public Cancion getCancion(int i) {
    if (i>=0 && i< cant) {
      return lista[i];
    }
    return null;
  }
  
  public Cancion buscarCancion(String codigo) {
   for(int i = 0; i<cant; i++) {
      if (lista[i].getCodigo().equals(codigo))
         return lista[i];
    }
   return null;
  }

}