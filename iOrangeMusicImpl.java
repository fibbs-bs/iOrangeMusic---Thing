public class iOrangeMusicImpl implements iOrangeMusic {

    private ListaUsuarios usuarios;
    private ListaPlaylist playlists;
    private ListaCanciones canciones;

    public iOrangeMusicImpl(){
        usuarios = new ListaUsuarios (100);
        playlists = new ListaPlaylist (150);
        canciones = new ListaCanciones (1000);
    }

    @Override
    public void ingresarUsuario(String codigoU, String password, String tipoUsuario, String preferencia) {
        Usuario usuario = new Usuario(codigoU, password, tipoUsuario, preferencia);
        if (!usuarios.agregarUsuario(usuario)){
            throw new NullPointerException("El usuario no pudo ser ingresado.");
        }
    }

    @Override
    public void ingresarCancion(String codigoC, String nombreC, String tipoGenero, int Duracion) {
        Cancion cancion = new Cancion(codigoC,nombreC,tipoGenero,Duracion);
        if (!canciones.agregarCancion(cancion)){
            throw new NullPointerException("La canción no pudo ser ingresada.");
        }
    }

    @Override
    public void ingresarAsociarPlaylist(String codigoU, String nombrePlaylist) {
        //Savka
        Usuario u = usuarios.buscarUsuario(codigoU);
        if (u!=null){
            Playlist p = new Playlist(String.valueOf(playlists.getCant()), nombrePlaylist);
            if (playlists.agregarPlaylist(p)){
                p.setDueño(u);
            }
            else{
                throw new NullPointerException("Jaja no hay espacio xDLOL:_:XDOL");
            }
        }
        else{
            throw new NullPointerException("No se pudo ingresar la playlist ya que el usuario CLARAMENTE no existe.");
        }
        //Jose

    }

    @Override
    public void asociarPlaylistCancion(String codigoPlaylist, String idCancion) {
        //Jose
        Playlist p = playlists.buscarPlaylist(codigoPlaylist);
        Cancion c = canciones.buscarCancion(idCancion);
        if (p==null || c==null){
            throw new NullPointerException("No existe playliste Ó no existe cancion");
        }
        if (!c.getPerteneceA().agregarPlaylist(p)) throw new NullPointerException("La biblioteca está llena.");
        if (!p.getListaCanciones().agregarCancion(c)) throw new NullPointerException("La playlist está llena");
        //Savka

        
    }

    @Override
    public String obtenerDatosUsuarioPlaylist() {
        //Felipe
        //Cristo
        //Sebastian
        String sex;
        sex = "El id del usuario que posee la playlist mas larga en duracion: ";
        int max = -1;
        Usuario mayor = null;
        for (int i = 0; i < usuarios.getCant(); i++){
            Usuario u = usuarios.getUsuario(i);
            for (int j = 0; j < u.getListaPlaylist().getCant(); j++) {
                int sopadecocos = 0;
                Playlist p = u.getListaPlaylist().getPlaylistI(i);
                for (int k = 0; k < p.getListaCanciones().getCant(); k++) {
                    Cancion c = p.getListaCanciones().getCancion(i);
                    sopadecocos+=c.getDuracion();
                }
                if (sopadecocos>max){
                    max = sopadecocos;
                    mayor = u;
                }
            }
        }
        return sex+=mayor.getCodigo()+ "con una duración de "+max+" segundos.";
    }

    @Override
    public String obtenerDatosCancionPopular() {
        int max = -1;
        Cancion cancionPopular = null;
        for (int i = 0; i< canciones.getCant(); i++){
            Cancion current = canciones.getCancion(i);
            if (current.getPerteneceA().getCant()>max){
                max=current.getPerteneceA().getCant();
                cancionPopular=current;
            }
        }
        return "El nombre de la canción mas popular es: "+cancionPopular.getNombre()+" y está presente en "+max+" listas de reproducción.";
    }

    @Override
    public String verificarPreferenciaVSGenerosMusicales(String codigoU) {
        Usuario u = usuarios.buscarUsuario(codigoU);
        if (u==null){
            throw new NullPointerException("El usuario no existe en el sistema");
        }
        {{{{{{{{{{{{{{{{{{{
            double cont = 0;
            double totales = 0;
            String genero = u.getPreferencia();
            for(int i = 0; i<u.getListaPlaylist().getCant(); i++){
                Playlist p = u.getListaPlaylist().getPlaylistI(i);
                totales+=p.getListaCanciones().getCant();
                for (int j = 0; j< p.getListaCanciones().getCant();j++){
                    Cancion current = p.getListaCanciones().getCancion(i);
                    if (current.getGenero().equals(genero)){
                        cont++;
                    }
                }
            }
            double mitad = totales/2;
            if (cont>=mitad){
                return "El usuario "+u.getCodigo()+" es fiel a sus preferencias";
            }
            else{
                return "El usuario "+u.getCodigo()+" no es fiel a sus preferencias";
            }
        }}}}}}}}}}}}}}}}}}}
    }

}
