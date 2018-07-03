
package ve.com.generic.helpers;
import java.io.File;
public interface InterfaceBotones {
    public char SEP = File.separatorChar;
    public final String[] NOMBRE_BOTONES = {
        "Agregar",
        "Borrar",
        "Modificar",
        "Cerrar"
    };
    public final char[]LETRAS = {'A',
                                 'E',
                                 'M',
                                 'C'
                                };        
    
   public final String[] ICONOS = { "imagenes" + SEP + "agregar.png",
                                    "imagenes" + SEP + "borrar1.png",
                                    "imagenes" + SEP + "editar1.png",
                                    "imagenes" + SEP + "salir3.png"
                                   };
    //BOTONES CRUD
   public final String[] BOTONES_CRUD = { "Agregar",
                                          "Borrar",
                                          "Modificar",
                                          "Cerrar"        
                                          };
    public final char[] LETRAS_CRUD = {'A',
                                       'B',
                                       'M',
                                       'C'
                                      };
    
    public String[] ICONOS_CRUD = { "imagenes" + SEP + "agregar.png",
                                    "imagenes" + SEP + "borrar1.png",
                                    "imagenes" + SEP + "editar1.png",
                                    "imagenes" + SEP + "salir3.png"
                                   };
    
    //BOTONES CONFIRMAR
    public final String[] BOTONES_CONF = { "Aceptar",
                                           "Cancelar"     
                                          };
    public final char[] LETRAS_CONF = {'A',                                       
                                       'C'
                                      };
    
    public String[] ICONOS_CONF = { "imagenes" + SEP + "aceptar.png",
                                    "imagenes" + SEP + "cancelar.png",                                    
                                   };   
    
    //Botones Paginar
    public final String[] BOTONES_PAGINAR = {
        "Anterior",
        "Siguiente"
    };
    public final char[] LETRAS_PAGINAR = {
        't',
        'g'
    };
    
    public final String[] ICONOS_PAGINAR = {
        "imagenes"+SEP+"anterior.png",
        "imagenes"+SEP+"siguiente.png"
    };
    
}
