/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import ve.com.generic.builder.Botonera;
import ve.com.rep.model.ConsultaSQL;
import ve.com.rep.model.DatosSQL;

/**
 *
 * @author S2c1
 */
public class EventoSiguiente implements ActionListener {

    DefaultTableModel tablaModel;
    ConsultaSQL consulta;
    Botonera botonesPaginar;
    public EventoSiguiente(DefaultTableModel tablaModel,Botonera botonesPaginar) {
        this.tablaModel = tablaModel;
        this.botonesPaginar = botonesPaginar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tablaModel.setRowCount(0);
        consulta = new ConsultaSQL();
        Paginar.inicio += 125000;
        Paginar.fin += 125000;
        consulta.consultarDatos(DatosSQL.CONSULTA_SQL, DatosSQL.CAMPOS_NACIONAL, tablaModel, Paginar.inicio, Paginar.fin);   
        
        if(Paginar.inicio != 0){
            botonesPaginar.activarBoton(true, 0);
        }
    }
    
}
