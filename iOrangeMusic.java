public interface iOrangeMusic{
    
    public void ingresarUsuario(String codigoU, String password, String tipoUsuario, String preferencia);
   
    public void ingresarCancion(String codigoC, String nombreC, String tipoGenero, int Duracion);

    public void ingresarAsociarPlaylist(String codigoU, String nombrePlaylist);

    public void asociarPlaylistCancion(String codigoPlaylist, String idCancion);

    public String obtenerDatosUsuarioPlaylist();

    public String obtenerDatosCancionPopular();

    public String verificarPreferenciaVSGenerosMusicales(String codigoU);

}