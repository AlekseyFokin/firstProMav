package com.sniffsnirr.mavsearchdatainbase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sniffsnirr
 */
public class dtm extends DefaultTableModel {

public dtm (String SQL) 
{
 
 try {
      Connection_for_select cfs9=new Connection_for_select();  
      cfs9.Connect();
      ResultSet rs=cfs9.Get_RS(SQL);
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();
      for ( int i=0; i<columnCount; i++) {
                                          this.addColumn(rsmd.getColumnName(i+1));
                                         }
      while ( rs.next() ) {
                           Vector row = new Vector();
                           for ( int i=0; i<columnCount; i++) {row.add(rs.getString(i+1).replaceAll(" ", ""));System.out.print(rs.getString(i+1)+";");}
                           this.addRow(row);
                           System.out.println("");
                           //row.clear();
                          }
       rs.close();
       cfs9.Disconnect();
     }
 catch (Exception ex) {System.out.println("error:"+ex);  }                       
               
                       
}

}
