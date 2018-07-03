/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.generic.builder;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
/**
 *
 * @author S2M6-2
 */
public class GenerarForm extends JPanel{
    public JTextField[] cuadrosTexto;
    public JLabel[] etiquetas;
    private int nroEtiquetas;
    //Constructor
    public GenerarForm(String[] nombreEtiquetas,String titulo,int ordenar){
        crearForm(nombreEtiquetas,titulo,ordenar);
    }

    private void crearForm(String[] nombreEtiquetas, String titulo,int ordenar) {
       /*
        ordenar en la misma linea etiqueta e input entonces:
            ordenar=0 -> Inline
            ordenar=1 -> box
        */
        nroEtiquetas = nombreEtiquetas.length;
        switch(ordenar){
            case 0:
                this.setLayout(new GridLayout(nroEtiquetas,2,5,5));
            break;
            case 1:
                this.setLayout(new GridLayout(nroEtiquetas * 2,1,5,5));
            break;
            default:
                JOptionPane.showMessageDialog(null, "Numero de ordenar no valido", "Atención", JOptionPane.ERROR_MESSAGE);
        }
        
        cuadrosTexto = new JTextField[nroEtiquetas];
        etiquetas = new JLabel[nroEtiquetas];
        
        
        for (int i = 0; i < nroEtiquetas; i++) {
            etiquetas[i] = new JLabel(nombreEtiquetas[i],JLabel.LEFT);
            this.add(etiquetas[i]);
            cuadrosTexto[i] = new JTextField();
            this.add(cuadrosTexto[i]);
        }
        if(titulo != null){
            this.setBorder(BorderFactory.createTitledBorder(titulo));
        }
        
    }
    
    public void activarForm(boolean estado){
        for (int i = 0; i < nroEtiquetas; i++) {
            cuadrosTexto[i].setEditable(estado);
        }
    }
    public void limpiarForm(){
        for (int i = 0; i < nroEtiquetas; i++) {
            cuadrosTexto[i].setText(null);
        }
    }
}
