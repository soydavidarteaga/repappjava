
package ve.com.rep.model;

public interface InterfaceDB {
    public final String BASE_DATOS = "rep.db",
                        USUARIO = "",
                        CLAVE = "",
                        HOSTNAME = "",
                        PUERTO = "",
                        URL_EMBED = "jdbc:sqlite:" + BASE_DATOS,
                        URL_SERVER = "jdbc:mysql://" + HOSTNAME + ":" + PUERTO 
                        + "/" + BASE_DATOS;//URL para conectarnos a la base de datos
                        
            
    
}
