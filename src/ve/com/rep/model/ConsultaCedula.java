/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author salon2-2
 */
public class ConsultaCedula {
   PreparedStatement pStatement;
   ResultSet resultSet;
   Nacional nacional;
   
   public Nacional consultaSQL(String sentenciaSQL, String cedula){
       try{
           ConexionDB.abrirConexion();
           pStatement = ConexionDB.connection.prepareStatement(sentenciaSQL);
           pStatement.setString(1,cedula);
           resultSet = pStatement.executeQuery();
           nacional = new Nacional();
           nacional.setNacionalidad(resultSet.getString("nacionalidad"));
           nacional.setCedula(resultSet.getString("cedula"));
           nacional.setPrimerNombre(resultSet.getString("primer_nombre"));
           nacional.setSegundoNombre(resultSet.getString("segundo_nombre"));
           nacional.setPrimerApellido(resultSet.getString("primer_apellido"));
           nacional.setSegundoApellido(resultSet.getString("segundo_apellido"));
           nacional.setCodigoCentro(resultSet.getString("cod_centro"));
           resultSet.close();
           pStatement.close();
           ConexionDB.cerrarConexion();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e.toString(),"Atencion",JOptionPane.ERROR_MESSAGE);
       }
       return nacional;
   }
}
