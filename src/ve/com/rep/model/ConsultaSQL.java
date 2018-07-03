
package ve.com.rep.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class ConsultaSQL {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Object[] datos;
    int nroCampos;
    DefaultTableModel tablaModel;
    
    public ConsultaSQL(){
    }
    
    public void consultarDatos(String sentenciaSQL, String[] campos, DefaultTableModel tablaModel,int inicio,int fin){
        try{
            nroCampos = campos.length;
            datos = new Object[nroCampos];
            ConexionDB.abrirConexion();
            preparedStatement = ConexionDB.connection.prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1,inicio);
            preparedStatement.setInt(2,fin);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                for (int i = 0; i < nroCampos; i++) {
                    datos[i] = resultSet.getString(campos[i]);
                }
                tablaModel.addRow(datos);
            }
            resultSet.close();
            preparedStatement.close();
            ConexionDB.cerrarConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString(), "Atencion",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
