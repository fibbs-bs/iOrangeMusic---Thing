public class Cancion {
  private String codigo;
  private String nombre;
  private String genero;
  private int duracion;
  private ListaPlaylist perteneceA;
  public Cancion(String codigo, String nombre, String genero, int duracion) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.genero = genero;
    this.duracion = duracion;
    perteneceA = new ListaPlaylist(100);
  }
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getGenero() {
    return genero;
  }
  public void setGenero(String genero) {
    this.genero = genero;
  }
  public int getDuracion() {
    return duracion;
  }
  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }
  public ListaPlaylist getPerteneceA() {
    return perteneceA;
  }
  public void setPerteneceA(ListaPlaylist perteneceA) {
    this.perteneceA = perteneceA;
  }

}