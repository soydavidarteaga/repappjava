/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ve.com.generic.builder.Botonera;
import ve.com.generic.builder.GenerarForm;
import ve.com.rep.model.Nacional;

/**
 *
 * @author salon2-2
 */
public class EventoCancelar implements ActionListener {

    Botonera botonesCRUD;
    Botonera botonesConf;
    GenerarForm formulario;
    Nacional nacional;
    public EventoCancelar(Botonera botonesCRUD, Botonera botonesConf,GenerarForm formulario,Nacional nacional) {
        this.botonesCRUD = botonesCRUD;
        this.botonesConf = botonesConf;
        this.formulario = formulario;
        this.nacional = nacional;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        botonesConf.activarBoton(false, 0);
        botonesConf.activarBoton(false, 1);        
        botonesCRUD.activarBoton(true,0);
        botonesCRUD.activarBoton(true,1);
        botonesCRUD.activarBoton(true,2);
        rellenarForm();
        formulario.activarForm(false);
    }
    
    public void rellenarForm(){
        formulario.cuadrosTexto[0].setText(nacional.getNacionalidad());
        formulario.cuadrosTexto[1].setText(nacional.getCedula());
        formulario.cuadrosTexto[2].setText(nacional.getPrimerNombre());
        formulario.cuadrosTexto[3].setText(nacional.getSegundoNombre());
        formulario.cuadrosTexto[4].setText(nacional.getPrimerApellido());
        formulario.cuadrosTexto[5].setText(nacional.getSegundoApellido());
        formulario.cuadrosTexto[6].setText(nacional.getCodigoCentro());
    }
    
}
