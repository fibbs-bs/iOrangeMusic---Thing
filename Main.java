import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    iOrangeMusic system = new iOrangeMusicImpl();
    Lectura(system);
    Ejecucion(system);
  }
  public static void Ejecucion(iOrangeMusic system) {
    
    String opcion = "";
    Scanner scan = new Scanner(System.in);

    while (true){
      System.out.println("Ingrese una opción: ");
      opcion = scan.nextLine();
      try{
        if (opcion.equals("1")){//Crear playlist
          System.out.println("Ingrese el código de un usuario: ");
          String userCode = scan.nextLine();
          System.out.println("Ingrese el nombre de la playlist a crear: ");
          String nombre = scan.nextLine();
          system.ingresarAsociarPlaylist(userCode, nombre);
        }
        if (opcion.equals("2")){//Agregar cancion a playlist
          System.out.println("Ingrese el código de una playlist: ");
          String codigoPlaylist = scan.nextLine();
          System.out.println("Ingrese el código de una cancion a agregar a la playlist: ");
          String idCancion = scan.nextLine();
          system.asociarPlaylistCancion(codigoPlaylist, idCancion);
        }
        if (opcion.equals("3")){
          System.out.println(system.obtenerDatosUsuarioPlaylist()); 
        }
        if (opcion.equals("4")){
          System.out.println(system.obtenerDatosCancionPopular());
        }
        if (opcion.equals("5")){
          System.out.println("Ingrese el código de un usuario: ");
          String codigo = scan.nextLine();
          System.out.println(system.verificarPreferenciaVSGenerosMusicales(codigo));
        }
        if (opcion.equals("FIN")){
          System.out.println("Gracias por usar iOrangeMusic");
          break;
        }
      }
      catch (NullPointerException ex){
        System.out.println(ex.getMessage());
      }
    }
    

  }
  public static void Lectura(iOrangeMusic system){
    try{
      File file1 = new File("users.txt");
      Scanner scan = new Scanner (file1);
      while(scan.hasNextLine()){
        String banana = scan.nextLine();
        String [] partes = banana.split(",");
        String codigo = partes[0];
        String password = partes[1];
        String usertype = partes[2];
        String preference = partes[3];
        system.ingresarUsuario(codigo, password, usertype, preference);
      }
      File file2 = new File("songs.txt");
      Scanner scan2 = new Scanner (file2);
      while(scan2.hasNextLine()){
        String banana = scan2.nextLine();
        String [] partes = banana.split(",");
        String codigo = partes[0];
        String nombre = partes[1];
        String genero = partes[2];
        int duracion = Integer.parseInt(partes[3]);
        system.ingresarCancion(codigo, nombre, genero, duracion);
      }
    }
    catch(IOException  ex){
      System.out.println(ex.getMessage());
    }
    catch(NullPointerException ex){
      System.out.println(ex.getMessage());
    }
    catch(NumberFormatException ex){
      System.out.println(ex.getMessage());
    }
  }
} 