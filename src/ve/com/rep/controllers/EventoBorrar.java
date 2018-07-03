/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ve.com.generic.builder.Botonera;

/**
 *
 * @author salon2-2
 */
public class EventoBorrar implements ActionListener {

    Botonera botonesConf;
    Botonera botonesCRUD;
    public EventoBorrar(Botonera botonesConf, Botonera botonesCRUD) {
        this.botonesConf = botonesConf;
        this.botonesCRUD = botonesCRUD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        botonesConf.activarBoton(true, 0);
        botonesConf.activarBoton(true, 1);
        botonesCRUD.activarBoton(false,0);
        botonesCRUD.activarBoton(false,1);
        botonesCRUD.activarBoton(false,2);   
        Comando.nroComando = 2;        
    }
    
}
