
package ve.com.generic.builder;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;

/**
 *
 * @author S2M6-2
 */
public class BotonesOpcion extends JPanel{
    public JRadioButton[] botonesOpcion;
    public ButtonGroup grupoOpciones;
    private int nroOpciones;
    //constructor
    public BotonesOpcion(String[] nombreOpciones,int orientacion){
        crearOpciones(nombreOpciones,orientacion);
    }

    private void crearOpciones(String[] nombreOpciones, int orientacion) {
        nroOpciones = nombreOpciones.length;
        botonesOpcion = new JRadioButton[nroOpciones];
        this.setLayout(new BoxLayout(this,orientacion));
        grupoOpciones = new ButtonGroup();
        for (int i = 0; i < nroOpciones; i++) {
            botonesOpcion[i] = new JRadioButton(nombreOpciones[i]);
            grupoOpciones.add(botonesOpcion[i]);
            this.add(botonesOpcion[i]);
        }
    }
}
