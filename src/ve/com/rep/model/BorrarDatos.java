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
public class BorrarDatos {
    PreparedStatement pStatement;
    int nroRegistro;
    int respuesta;
    
    public void borrarDatos(String sentenciaSQL,String cedula) throws SQLException{
        try{
            ConexionDB.abrirConexion();
            pStatement = ConexionDB.connection.prepareStatement(sentenciaSQL);
            pStatement.setString(1, cedula);
            respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar los datos del elector: "+cedula, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta == JOptionPane.YES_OPTION){
                nroRegistro = pStatement.executeUpdate();
                if(nroRegistro > 0){
                    JOptionPane.showMessageDialog(null,"Datos del elector eliminados","Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(SQLException e){
            
        }
    }
}
