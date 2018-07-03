/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ve.com.generic.builder.Botonera;
import ve.com.generic.helpers.Cerrar;

/**
 *
 * @author S2M6
 */
public class EventoBotonCerrar implements ActionListener {

    public EventoBotonCerrar() {
    }
    Botonera botonesConf;
    public EventoBotonCerrar(Botonera botonesConf) {
        this.botonesConf = botonesConf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        botonesConf.activarBoton(true, 0);
        botonesConf.activarBoton(true, 1);
        Comando.nroComando = 4;
        
    }
    
}
