package ve.com.generic.builder;
import javax.swing.JFrame;

/**
 *
 * @author salon2-2
 */

/**
 * 
 * 
 * Atributos Ventana Array
 * 1.- Titulo de la ventana
 * 2.- Ancho
 * 3.- Alto
 * 4.- Status
 */
public class Ventana extends JFrame{
    public Ventana(String[] atributosVentana){
        super(atributosVentana[0]);
        crearVentana(atributosVentana);
    }

    private void crearVentana(String[] atributosVentana) {
        this.setSize(Integer.parseInt(atributosVentana[1]),Integer.parseInt(atributosVentana[2]));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(Integer.parseInt(atributosVentana[3]));
        this.setVisible(true);
    }
}
