/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ve.com.generic.builder.Botonera;
import ve.com.generic.builder.GenerarForm;
import ve.com.generic.helpers.Cerrar;
import ve.com.rep.model.AgregarDatos;
import ve.com.rep.model.ActualizarDatos;
import ve.com.rep.model.BorrarDatos; 
import ve.com.rep.model.ConsultaSQL;
import ve.com.rep.model.DatosSQL;
import ve.com.rep.model.Nacional;

/**
 *
 * @author salon2-2
 */
public class EventoAceptar implements ActionListener {

    Botonera botonesCRUD;
    Botonera botonesConf;
    AgregarDatos agregarDatos;
    ActualizarDatos actualizarDatos;
    BorrarDatos borrarDatos;
    Nacional nacional;
    GenerarForm formulario;
    CargarDatos datos;
    ConsultaSQL consulta;
    DefaultTableModel tablaModelo;
    public EventoAceptar(Botonera botonesCRUD, Botonera botonesConf, GenerarForm formulario ,Nacional nacional,CargarDatos datos,DefaultTableModel tablaModelo) {
        this.botonesCRUD = botonesCRUD;
        this.botonesConf = botonesConf;
        this.nacional = nacional;
        this.formulario = formulario;
        this.datos = datos;
        this.tablaModelo = tablaModelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        botonesConf.activarBoton(false, 0);
        botonesConf.activarBoton(false, 1);
        botonesCRUD.activarBoton(true,0);
        botonesCRUD.activarBoton(true,1);
        botonesCRUD.activarBoton(true,2);  
        
        switch(Comando.nroComando){
            case 1:
                //JOptionPane.showMessageDialog(null,"Agregar registro nuevo a la base de datos","Aviso",JOptionPane.INFORMATION_MESSAGE);
                agregarDatos = new AgregarDatos();
                datosNuevos();
                agregarDatos.insertarDatos(DatosSQL.SQL_AGREGAR, nacional);
                refrescarDatos();
            break;
            case 2:
                //JOptionPane.showMessageDialog(null,"Borrar registro existente de la Base de datos","Aviso",JOptionPane.INFORMATION_MESSAGE);
                borrarDatos = new BorrarDatos();
                datosNuevos();
                try {
                    borrarDatos.borrarDatos(DatosSQL.SQL_ELIMINAR, nacional.getCedula());
                    refrescarDatos();
                } catch (SQLException ex) {
                    Logger.getLogger(EventoAceptar.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            case 3:
                //JOptionPane.showMessageDialog(null,"Modificar registro en la base de datos","Aviso",JOptionPane.INFORMATION_MESSAGE);   
                actualizarDatos = new ActualizarDatos();
                datosNuevos();
                actualizarDatos.modificarDatos(DatosSQL.SQL_ACTUALIZAR, nacional);
                refrescarDatos();
            break;
            case 4:
                //System.exit(0); 
            break;
          
        }
        
        tablaModelo.setRowCount(0);
        consulta = new ConsultaSQL();
        consulta.consultarDatos(DatosSQL.CONSULTA_SQL, DatosSQL.CAMPOS_NACIONAL, tablaModelo, Paginar.inicio, Paginar.fin);
        
    }
    private void refrescarDatos(){
        datos.cargaDatosTabla();
    }
    private void datosNuevos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        nacional.setNacionalidad(formulario.cuadrosTexto[0].getText());
        nacional.setCedula(formulario.cuadrosTexto[1].getText());
        nacional.setPrimerNombre(formulario.cuadrosTexto[2].getText());
        nacional.setSegundoNombre(formulario.cuadrosTexto[3].getText());
        nacional.setPrimerApellido(formulario.cuadrosTexto[4].getText());
        nacional.setSegundoApellido(formulario.cuadrosTexto[5].getText());
        nacional.setCodigoCentro(formulario.cuadrosTexto[6].getText());
    }
    
}
