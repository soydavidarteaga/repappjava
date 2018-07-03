package ve.com.generic.builder;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

/**
 *
 * @author David Arteaga
 */
public class Menues extends JMenuBar{
     JMenu[] menu;
     JMenuItem[] menuItem;
     int nroMenu;
     int nroMenuItem;
     
     //Constructor
     public Menues(String[] nombreMenues,char[] letras){
         crearMenu(nombreMenues,letras);
     }

    private void crearMenu(String[] nombreMenues, char[] letras) {
      nroMenu = nombreMenues.length;
      menu = new JMenu[nroMenu];
        for (int i = 0; i < nroMenu; i++) {
            menu[i] = new JMenu(nombreMenues[i]);
            menu[i].setMnemonic(letras[i]);
            this.add(menu[i]);
        }
    }
    
    public void asignarOyente(ActionListener evento, int indiceMenu){
        if(indiceMenu >= 0 && indiceMenu < nroMenuItem){
            menuItem[indiceMenu].addActionListener(evento);
        }
    }
    
    public void rellenarMenuItem(String[] nombreMenuItem,char[] letras,String[] rutaIcono,int indiceMenu){
         if(indiceMenu >= 0 && indiceMenu < nroMenu){
             nroMenuItem = nombreMenuItem.length;
             menuItem  = new JMenuItem[nroMenuItem];
             for (int i = 0; i < nroMenuItem; i++) {
                   menuItem[i] = new JMenuItem(nombreMenuItem[i]);
                   menuItem[i].setMnemonic(letras[i]);
                   menuItem[i].setIcon(new ImageIcon(rutaIcono[i]));
                   if(nombreMenuItem[i].equals("-")){
                       menu[indiceMenu].add(new JSeparator());
                   }else{
                       menu[indiceMenu].add(menuItem[i]);
                   }
             }
         }
    }
}
