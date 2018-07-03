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
public class AgregarDatos {
    PreparedStatement pStatement;
    int nroRegistro;
    
    public void insertarDatos(String sentenciaSQL,Nacional nacional){
        try{
            ConexionDB.abrirConexion();
            pStatement = ConexionDB.connection.prepareStatement(sentenciaSQL);
             JOptionPane.showMessageDialog(null,nacional.getCedula(),"Aviso", JOptionPane.INFORMATION_MESSAGE);
            pStatement.setString(1, nacional.getNacionalidad());
            pStatement.setString(2, nacional.getCedula());
            pStatement.setString(3, nacional.getPrimerApellido());
            pStatement.setString(4,nacional.getSegundoApellido());
            pStatement.setString(5,nacional.getPrimerNombre());
            pStatement.setString(6, nacional.getSegundoNombre());
            pStatement.setString(7,nacional.getCodigoCentro());
            nroRegistro = pStatement.executeUpdate();
            if(nroRegistro > 0){
                JOptionPane.showMessageDialog(null,"Datos del elector agregados","Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.toString(),"Aviso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.toString());
        }
    }
}
