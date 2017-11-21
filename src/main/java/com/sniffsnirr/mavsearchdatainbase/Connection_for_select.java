package com.sniffsnirr.mavsearchdatainbase;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Фокин
 */
public class Connection_for_select extends Connection_for{
     private ResultSet rs;
    

    @Override
    TreeSet<String> Get_TreeSet(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String Get_String(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

         public ResultSet Get_RS(String SQL)
  {
        try {
            rs = stmt.executeQuery(SQL);
            } catch (SQLException ex) {System.out.println(ex);}
        return rs;
        
  }

    @Override
    ArrayList Get_Row_Array(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
