/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import ve.com.generic.builder.BotonesOpcion;
import ve.com.generic.builder.GenerarForm;
import ve.com.generic.builder.tabla;

/**
 *
 * @author S2c1
 */
public class EventoBusquedaProgresiva implements KeyListener {
    
    GenerarForm formBuscar;
    BotonesOpcion opcionesBuscar;
    tabla tableREP;

    public EventoBusquedaProgresiva(GenerarForm formBuscar, BotonesOpcion opcionesBuscar, tabla tableREP) {
        this.formBuscar = formBuscar;
        this.opcionesBuscar = opcionesBuscar;
        this.tableREP = tableREP;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(opcionesBuscar.grupoOpciones.getSelection() == null){
            e.consume();
            JOptionPane.showMessageDialog(null, "Usted debe seleccionar una opcion de busqueda","Atencion",JOptionPane.ERROR_MESSAGE);
        }
        filtroTabla();
    }
    
    private void filtroTabla(){
        String filtroTexto;
        int columna;
        filtroTexto = formBuscar.cuadrosTexto[0].getText().toUpperCase();
        if(opcionesBuscar.botonesOpcion[0].isSelected()){
            columna = 0;
            tableREP.orderTabla.setRowFilter(RowFilter.regexFilter(filtroTexto, columna));
        }else if(opcionesBuscar.botonesOpcion[1].isSelected()){
            columna = 1;
            tableREP.orderTabla.setRowFilter(RowFilter.regexFilter(filtroTexto, columna));
        }else if(opcionesBuscar.botonesOpcion[2].isSelected()){
            columna = 2;
            tableREP.orderTabla.setRowFilter(RowFilter.regexFilter(filtroTexto, columna));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
