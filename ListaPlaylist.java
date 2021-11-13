public class ListaPlaylist{
  	private int max;
  	private int cant;
  	private Playlist[] lista;

  	public ListaPlaylist(int max){
	  	this.max = max;
	  	this.cant = 0;
	  	lista = new Playlist[max];
  	}

	public int getCant(){
		return cant;
	}

	public Playlist getPlaylistI(int i) {
    	if (i>=0 && i< cant) {
      		return lista[i];
    	} 
    	return null;
  	}

	public Playlist buscarPlaylist(String codigo) {
   		for(int i = 0; i<cant; i++) {
      		if (lista[i].getCodigo().equals(codigo)){
         		return lista[i];
		   	}
		}
		return null;
  	}

	
	public boolean agregarPlaylist(Playlist playlist) {
    	if(cant<max) {
      		lista[cant] = playlist;
			cant++;
        	return true;
    	}
    	return false;
  	}

  


}