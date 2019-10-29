package app;
import app.Conexion;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean exitLoop = false;

        while (!exitLoop) {
            String eleccion = Conexion.menu();
            switch (eleccion) {
                case "1":
                    System.out.println("Introduce el titulo del libro que deseas buscar-->");
                    Scanner titulo = new Scanner(System.in);
                    String cadena = titulo.nextLine();
                    Conexion.buscarLibros(cadena);
                    break;
                case "2":
                    System.out.println("Introduce el titulo del libro ->");
                    Scanner tit = new Scanner(System.in);
                    String titin = tit.nextLine();
                    System.out.println("Introduce el id_autor ->");
                    Scanner aut = new Scanner(System.in);
                    String autin = aut.nextLine();
                    int id_autor = Integer.parseInt(autin);
                    System.out.println("Introduce el año de salida ->");
                    Scanner anyo = new Scanner(System.in);
                    String anyoin = anyo.nextLine();
                    int anyo_salida = Integer.parseInt(anyoin);
                    System.out.println("Introduce el idioma del libro ->");
                    Scanner idi = new Scanner(System.in);
                    String idin = idi.nextLine();
                    System.out.println("Introduce el precio->");
                    Scanner pre = new Scanner(System.in);
                    String prein = pre.nextLine();
                    double precio = Double.parseDouble(prein);
                    System.out.println("Introduce las copias que hay->");
                    Scanner cop = new Scanner(System.in);
                    String copin = cop.nextLine();
                    int copias = Integer.parseInt(copin);
                    Conexion.insertarLibro(id_autor, titin, anyo_salida, idin, precio, copias);
                    break;
                case "3":
                    System.out.println("Introduce el id de el libro que quieres eliminar-->");
                    Scanner scan = new Scanner(System.in);
                    String id = scan.nextLine();
                    int id_libro = Integer.parseInt(id);
                    Conexion.eliminarLibro(id_libro);
                    break;
                case "4":
                    exitLoop = true;
                    break;
            }
        }
    }
}
