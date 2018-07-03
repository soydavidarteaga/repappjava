/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import ve.com.generic.builder.GenerarForm;
import ve.com.generic.builder.tabla;
import ve.com.rep.model.ConsultaCedula;
import ve.com.rep.model.DatosSQL;
import ve.com.rep.model.Nacional;

/**
 *
 * @author S2c1
 */
public class EventoSeleccionarRegistro implements MouseListener {
    
    tabla tableREP;
    Nacional nacional;
    GenerarForm formulario;
    int nroFila;
    String cedula;
    ConsultaCedula consultaCedula = new ConsultaCedula();

    public EventoSeleccionarRegistro(tabla tableREP, Nacional nacional,GenerarForm formulario) {
        this.tableREP = tableREP;
        this.nacional = nacional;
        this.formulario = formulario;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        nroFila = tableREP.table.getSelectedRow();
        cedula = String.valueOf(tableREP.table.getValueAt(nroFila, 0));
        //JOptionPane.showMessageDialog(null, "Numero de fila: "+nroFila+" Numero de cedula: "+cedula,"Aviso",JOptionPane.INFORMATION_MESSAGE);
        nacional = consultaCedula.consultaSQL(DatosSQL.SQL_BUSCAR_CEDULA, cedula);
        rellenarFormulario();
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private void rellenarFormulario() {
        formulario.cuadrosTexto[0].setText(nacional.getNacionalidad());
        formulario.cuadrosTexto[1].setText(nacional.getCedula());
        formulario.cuadrosTexto[2].setText(nacional.getPrimerNombre());
        formulario.cuadrosTexto[3].setText(nacional.getSegundoNombre());
        formulario.cuadrosTexto[4].setText(nacional.getPrimerApellido());
        formulario.cuadrosTexto[5].setText(nacional.getSegundoApellido());
        formulario.cuadrosTexto[6].setText(nacional.getCodigoCentro());
    }

    
}
