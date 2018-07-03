
package ve.com.rep.model;
//Importamos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB implements InterfaceDB, InterfaceDrive {
   public static Connection connection = null;
   
   public static void abrirConexion(){
       //Exepciones para las conexiones
       try{
           Class.forName(DRIVER_SQLITE);/*Para indicar como se llama el paqute donde estan las clases que utilizaremos
                                          en este caso utilizaremos SQLITE*/
           connection = DriverManager.getConnection(URL_EMBED, USUARIO, CLAVE);
           
           if (connection != null) {
               //JOptionPane.showMessageDialog(null, "¡La Conexion a la Base de Datos "
                            //+ BASE_DATOS.toUpperCase() + " fue Exitosa!", "Aviso", 
                            //+ JOptionPane.INFORMATION_MESSAGE);  
               System.out.println("La conexion a la Base de datos "+ BASE_DATOS.toUpperCase() + " Fue exitosa");
           }
           
       }catch(ClassNotFoundException | SQLException e){
           System.out.println(e.toString());
       }
   }
   public static void cerrarConexion(){
       try{
           if (connection != null) {
               connection.close();
               //JOptionPane.showMessageDialog(null, "Base de Datos Desconectada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("Base de Datos Desconectada");
               
           }
          
       }catch(SQLException e){
           System.out.println(e.toString());
       }
   }   
}
