/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ve.com.generic.builder;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

/**
 *
 * @author S2M6-2
 */
public class MenuContexto extends JPopupMenu{
    JMenuItem[] menuItem;
    int nroMenuItem;
    public MenuContexto(String[] nombreMenuItem, String[] rutaIconos) {
        crearMenuContexto(nombreMenuItem,rutaIconos);
    }
    
    public void asignarOyente(ActionListener evento, int indiceMenu){
        if(indiceMenu >= 0 && indiceMenu < nroMenuItem){
            menuItem[indiceMenu].addActionListener(evento);
        }
    }
    
    private void crearMenuContexto(String [] nombreMenuItem, String[] rutaIconos){
        nroMenuItem = nombreMenuItem.length;
        menuItem = new JMenuItem[nroMenuItem];
        for (int i = 0; i < nroMenuItem; i++) {
            menuItem[i] = new JMenuItem(nombreMenuItem[i]);
            menuItem[i].setIcon(new ImageIcon(rutaIconos[i]));
            if(nombreMenuItem[i].equals("-")){
                this.add(new JSeparator());
            }else{
                this.add(menuItem[i]);
            }
        }
        
    }
    
}
