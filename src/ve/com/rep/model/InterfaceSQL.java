/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.rep.model;

/**
 *
 * @author S2M6
 */
public interface InterfaceSQL {
    public final String CONSULTA_SQL = "Select cedula,primer_nombre || ' ' || segundo_nombre as nombres, primer_apellido || ' ' || "+
    "segundo_apellido as apellidos  from nacional limit ?,?";
    
    public final String[] CAMPOS_NACIONAL = {
      "cedula",
      "nombres",
      "apellidos"
    };
    
    public final String SQL_BUSCAR_CEDULA = "select * from nacional where cedula = ?";
    
    public final String SQL_AGREGAR = "insert into nacional"
            +"(nacionalidad,cedula,primer_apellido,segundo_apellido,primer_nombre,segundo_nombre,cod_centro)"
            +" values (?,?,?,?,?,?,?)";
    
    public final String SQL_ACTUALIZAR = "update nacional set "
            +"nacionalidad=?,primer_apellido=?,segundo_apellido=?,primer_nombre=?,segundo_nombre=?,cod_centro=?"
            +"where cedula=?";
    
    public final String SQL_ELIMINAR = "delete from nacional where cedula=?";
}
