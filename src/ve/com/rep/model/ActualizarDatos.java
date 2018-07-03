/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author S2c1
 */
public class ActualizarDatos {
     PreparedStatement pStatement;
    int nroRegistro;
    
    public void modificarDatos(String sentenciaSQL,Nacional nacional){
        try{
            ConexionDB.abrirConexion();
            pStatement = ConexionDB.connection.prepareStatement(sentenciaSQL);
            pStatement.setString(1, nacional.getNacionalidad());
            pStatement.setString(2, nacional.getPrimerApellido());
            pStatement.setString(3,nacional.getSegundoApellido());
            pStatement.setString(4,nacional.getPrimerNombre());
            pStatement.setString(5, nacional.getSegundoNombre());
            pStatement.setString(6,nacional.getCodigoCentro());
            pStatement.setString(7, nacional.getCedula());
            nroRegistro = pStatement.executeUpdate();
            if(nroRegistro > 0){
                JOptionPane.showMessageDialog(null,"Datos del elector actualizados","Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }   
}
