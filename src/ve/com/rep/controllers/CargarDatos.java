/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import ve.com.generic.builder.GenerarForm;
import ve.com.generic.builder.tabla;
import ve.com.rep.model.ConsultaCedula;
import ve.com.rep.model.ConsultaSQL;
import ve.com.rep.model.DatosSQL;
import ve.com.rep.model.Nacional;

/**
 *
 * @author S2M6
 */
public class CargarDatos {
    tabla tableREP;
    GenerarForm formulario;
    ConsultaSQL consulta;
    Nacional nacional;
    String cedula;
    int nroFila;
    
    ConsultaCedula consultaCedula = new ConsultaCedula();
    
    public CargarDatos(GenerarForm formulario, tabla tableREP){
        this.formulario = formulario;
        this.tableREP = tableREP;
    }
    
    
    public void cargaDatosTabla(){
                //Consulta a la base de datos
        consulta = new ConsultaSQL();
        Paginar.inicio = 0;
        Paginar.fin = 125000;
        consulta.consultarDatos(DatosSQL.CONSULTA_SQL, DatosSQL.CAMPOS_NACIONAL, tableREP.tablaModel,Paginar.inicio,Paginar.fin);        
    }
    
    public void cargarFormulario(){
        //nroFila = tableREP.table.getSelectedRow();
        cedula = String.valueOf(tableREP.table.getValueAt(nroFila, 0));
        //JOptionPane.showMessageDialog(null, "Numero de fila: "+nroFila+" Numero de cedula: "+cedula,"Aviso",JOptionPane.INFORMATION_MESSAGE);
        nacional = consultaCedula.consultaSQL(DatosSQL.SQL_BUSCAR_CEDULA, cedula);
        rellenarFormulario();        
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
