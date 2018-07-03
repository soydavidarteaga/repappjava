package ve.com.generic.helpers;
import javax.swing.JOptionPane;
/**
 *
 * @author S2M6
 */
public class Cerrar {
    public static void cerrarAPP(){
        int respuesta;
        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la aplicacion?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
