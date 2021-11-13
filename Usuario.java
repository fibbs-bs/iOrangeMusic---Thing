public class Usuario{
  private String codigo;
  private String contrasenna;
  private String tipo_usuario;
  private String preferencia;
  private ListaPlaylist listaplaylist;

  public Usuario(String codigo, String contrasena, String tipo_usuario, String preferencia){
    this.codigo = codigo;
    this.contrasenna = contrasena;
    this.tipo_usuario = tipo_usuario;
    this.preferencia = preferencia;
    if(tipo_usuario.equals("Free")){
      listaplaylist = new ListaPlaylist(2);
    }
    else{
      listaplaylist = new ListaPlaylist(5);
    }
  }
  public String getCodigo() {
        return codigo;
  }
  public void setCodigo(String codigo) {
        this.codigo = codigo;
  }
  public String getContraseña() {
        return contrasenna;
  }
  public void setContraseña(String contrasena) {
        this.contrasenna = contrasena;
  }
  public String getTipo_Usuario() {
        return tipo_usuario;
  }
  public void setTipo_Usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
  }
  public String getPreferencia() {
        return preferencia;
  }
  public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
  }
  public ListaPlaylist getListaPlaylist() {
        return listaplaylist;
  }
  public void setListaPlaylist(ListaPlaylist listaplaylist) {
        this.listaplaylist = listaplaylist;
  }
}