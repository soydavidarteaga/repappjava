
package ve.com.generic.builder;
import javax.swing.JInternalFrame;

public class VentanaInterna extends JInternalFrame{

    public VentanaInterna(String title, int ancho, int alto ,boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        crearVentanaInterna(ancho,alto);
    }

    private void crearVentanaInterna(int ancho, int alto) {
        this.setSize(ancho, alto);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
}
