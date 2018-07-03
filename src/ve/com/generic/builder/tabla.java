
package ve.com.generic.builder;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class tabla extends JPanel  {
    public JTable table;
    public DefaultTableModel tablaModel;
    public TableRowSorter orderTabla;
    JScrollPane scrollTabla;
    
    public tabla(String[] nombreColumna, int nroFilas){
        crearTabla(nombreColumna, nroFilas);
    }

    private void crearTabla(String[] nombreColumna, int nroFilas) {
        this.setLayout(new BorderLayout());
        tablaModel = new DefaultTableModel(nombreColumna, nroFilas);//Tabla modelo
        orderTabla = new TableRowSorter(tablaModel);//Ordenar la tabla
        table = new JTable(tablaModel);
        table.setRowSorter(orderTabla);
        scrollTabla = new JScrollPane(table);
        this.add(scrollTabla);
    }                
}
