/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nishan
 */
public class Table {
    
    private DefaultTableModel dtm;
    
    
    public static DefaultTableModel buildDataTable(ResultSet rs) {
        ResultSetMetaData metaData;
        Object[][] data = null;
        Object[] columnNames = null;
        try {
            metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            columnNames = new Object[columnCount];
            int index = 0;
            for (int column = 1; column <= columnCount; column++) {
                columnNames[index] = metaData.getColumnName(column).toUpperCase();
                index++;
            }
            rs.last();
            data = new Object[rs.getRow()][columnCount];
            rs.beforeFirst();
            while (rs.next()) {
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    data[rs.getRow() - 1][columnIndex - 1] = rs.getObject(columnIndex);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Something went wrong");
        }
        
        return new DefaultTableModel(data, columnNames);
    }
 }
