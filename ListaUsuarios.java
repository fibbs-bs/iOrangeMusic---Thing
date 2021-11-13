public class ListaUsuarios{
  private int max;
  private int cant;
  private Usuario[] lista;

  public ListaUsuarios(int max){
    cant = 0 ;
    this.max = max;
    lista = new Usuario[max];
  }

  public int getMax() {
    return max;
  }
  public void setMax(int max) {
    this.max = max;
  }
  public int getCant() {
    return cant;
  }
  public void setCant(int cant) {
    this.cant = cant;
  }
  public Usuario[] getLista() {
    return lista;
  }
  public void setLista(Usuario[] lista) {
    this.lista = lista;
  }
  public boolean agregarUsuario(Usuario usuario) {
    if (cant<max) {
      lista[cant] = usuario;
      cant++;
      return true;
    }
    return false;
  }
  public Usuario getUsuario(int i) {
    if (i>=0 && i< cant) {
      return lista[i];
    } 
    return null;
  }
  public Usuario buscarUsuario(String codigo) {
   for(int i = 0; i<cant; i++) {
      if (lista[i].getCodigo().equals(codigo))
         return lista[i];
    }
   return null;
  }

}