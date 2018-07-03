
package ve.com.generic.builder;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class Botonera extends JPanel{
    JButton[] botones;
    int nroBotones;
    public Botonera(String[] nombreBotones, char[] letras, String[] iconos){
        crearBotones(nombreBotones,letras,iconos);
    }

    public void asignarOyente(ActionListener evento, int indiceBoton){
        if(indiceBoton >= 0 && indiceBoton < nroBotones){
            botones[indiceBoton].addActionListener(evento);
        }
    }
    private void crearBotones(String[] nombreBotones, char[] letras, String[] iconos) {
        this.setLayout(new FlowLayout());
        nroBotones = nombreBotones.length;
        botones = new JButton[nroBotones];
        for(int i=0;i<nroBotones;i++){
            botones[i] = new JButton(nombreBotones[i]);
            botones[i].setMnemonic(letras[i]);
            botones[i].setIcon(new ImageIcon(iconos[i]));
            this.add(botones[i]);
        }
    }
    
    public void verBoton(boolean estado,int indiceBoton){
        if(indiceBoton >= 0 && indiceBoton < nroBotones){
            botones[indiceBoton].setVisible(estado);
        }
    }
    
    public void activarBoton(boolean estado, int indiceBoton){
        if(indiceBoton >= 0 && indiceBoton < nroBotones){
            botones[indiceBoton].setEnabled(estado);
        }        
    }
}
