
package ve.com.generic.builder;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 *
 * @author David Arteaga
 */
public class BarraHerramientas extends JToolBar{
   JButton[] botones;
   int nroBotones;

    public BarraHerramientas(String name, int orientation,String[] toolTipTextBarra,String[] rutaIconos) {
        super(name, orientation);
        crearBarra(toolTipTextBarra,rutaIconos);
    }

    public void asignarOyente(ActionListener evento, int indiceBoton){
        if(indiceBoton >= 0 && indiceBoton < nroBotones){
            botones[indiceBoton].addActionListener(evento);
        }
    }
    
    private void crearBarra(String[] toolTipTextBarra, String[] rutaIconos) {
        nroBotones = toolTipTextBarra.length;
        botones = new JButton[nroBotones];
        for (int i = 0; i < nroBotones; i++) {
            botones[i] = new JButton();
            botones[i].setToolTipText(toolTipTextBarra[i]);
            botones[i].setIcon(new ImageIcon(rutaIconos[i]));
            if (toolTipTextBarra[i].equals("-")) {
                this.addSeparator();
            }else{
                this.add(botones[i]);
            }
        }
    }
   
}
