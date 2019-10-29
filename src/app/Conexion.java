package app;

import java.sql.*;
import java.util.Scanner;

public class Conexion{
    private static final String CONEXION = "jdbc:mysql://diPnGMlN01:Sy8WnewH4t@remotemysql.com/diPnGMlN01";

    public static void buscarLibros(String titulo) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conect = DriverManager.getConnection(CONEXION);

            Statement sentencia = conect.createStatement();
            ResultSet resultado = sentencia.executeQuery(
                    " SELECT  b.book_id, a.name, b.title, b.price, b.year " +
                            " FROM books AS b " +
                            "JOIN authors AS a " +
                            "ON a.author_id = b.author_id " +
                            "WHERE b.title LIKE '%"+titulo+"%'"
            );
            while (resultado.next()) {

                String year =  resultado.getString("year");
                String id =  resultado.getString("book_id");
                String title = resultado.getString("title");
                String price = resultado.getString("price");
                System.out.println("ID: "+id+"\nTitulo: "+title+"\nAño de salida: "+year+"\nPrecio: "+price+"\n***************************************");
            }

            conect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void insertarLibro(int id_autor , String titulo, int year, String idioma, double precio, int copias ) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conect = DriverManager.getConnection(CONEXION);
            PreparedStatement preparedStatement = conect.prepareStatement(" INSERT INTO books (title, author_id, year, language, price, copies)" +
                    "VALUES ('"+titulo+"','"+id_autor+"', '"+year+"', '"+idioma+"', '"+precio+"', '"+copias+"')");
            preparedStatement.execute();
            System.out.println("Se ha añadido el libro correctamente");
            conect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void eliminarLibro(int id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conect = DriverManager.getConnection(CONEXION);
            PreparedStatement preparedStatement = conect.prepareStatement(
                    "DELETE FROM books " +
                            "WHERE book_id LIKE "+id);
            preparedStatement.execute();
            System.out.println("Se ha eliminado el libro correctamente");
            conect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static String menu(){
        System.out.println("*************** MENU *****************\n");
        System.out.println("1. BUSCAR libro en BD.\n");
        System.out.println("2. INSERTAR libro en la BD.\n");
        System.out.println("3. ELIMINAR libro en la BD.\n");
        System.out.println("4. SALIR.\n");
        Scanner scan= new Scanner(System.in);
        String eleccion = scan.nextLine();
        return eleccion;
    }
}