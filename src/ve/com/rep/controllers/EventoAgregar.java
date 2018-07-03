/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ve.com.generic.builder.Botonera;
import ve.com.generic.builder.GenerarForm;
import ve.com.rep.model.Nacional;

/**
 *
 * @author salon2-2
 */
public class EventoAgregar implements ActionListener {

    Botonera botonesConf;
    Botonera botonesCRUD;
    GenerarForm formulario;
    Nacional nacional;
    public EventoAgregar(Botonera botonesConf,Botonera botonesCRUD,GenerarForm formulario) {
        this.botonesConf = botonesConf;
        this.botonesCRUD = botonesCRUD;
        this.formulario = formulario;
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        botonesConf.activarBoton(true, 0);
        botonesConf.activarBoton(true, 1);
        botonesCRUD.activarBoton(false,0);
        botonesCRUD.activarBoton(false,1);
        botonesCRUD.activarBoton(false,2);   
        formulario.activarForm(true);
        formulario.limpiarForm();
        formulario.cuadrosTexto[0].requestFocus();
        Comando.nroComando = 1;
    }
    
}
