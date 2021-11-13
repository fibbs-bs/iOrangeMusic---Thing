public class Playlist {
	private String codigo;
	private String nombre;
	private Usuario dueño;
	private ListaCanciones listaCanciones;

	public Playlist(String codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo(){
		return codigo;
	}

	public String getNombre(){
		return nombre;
	}

	public Usuario getDueño(){
		return dueño;
	}

	public ListaCanciones getListaCanciones(){
		return listaCanciones;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setDueño(Usuario dueño){
		this.dueño = dueño;
	}

	public void setPlaylist(ListaCanciones listaCanciones){
		this.listaCanciones = listaCanciones;
	}

}