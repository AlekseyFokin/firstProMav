package com.sniffsnirr.mavsearchdatainbase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author USER
 */
public abstract class Connection_for {
   /// ResultSet rs;
    Connection conn=null;
    Statement stmt;
    
      
    
  public void Connect() {
       
  String out="";
  //String strURL="jdbc:firebirdsql:localhost/3050:"+form1.path;
  String strURL="jdbc:firebirdsql:127.0.0.1/3050:"+SearchDataInBase.PathDB+"?lc_ctype=WIN1251";
  String strUser="SYSDBA";		// Логин
  String strPassword="masterkey"; 	// Пароль
     
  try {Class.forName("org.firebirdsql.jdbc.FBDriver");}
        catch (Exception e) { System.out.println("Unable to load driver: " + e);}
  
   conn=null;
   try
      {
       conn = DriverManager.getConnection(strURL,strUser, strPassword);//������ ����������� � ���� ������
       
       if (conn==null)
         {System.out.println("Could not connect to database");}
       
       else {
             System.out.println("Connection enable");
             stmt = conn.createStatement();// ������ �����, � ������� �������� ����� ����������� SQL �������.
            }
       }
	 catch(Exception ex)  { System.out.println(": "+strURL); }
    }
    
   
   abstract TreeSet<String> Get_TreeSet(String SQL);
   
   abstract String Get_String(String SQL);
   
   abstract ResultSet Get_RS(String SQL);
   abstract ArrayList Get_Row_Array(String SQL);
   
   public void Disconnect()
  {
      //  try {
      //      rs.close();
      //      } 
     //   catch (SQLException ex) {logger.error(ex); }
        try {
            stmt.close();
        } catch (SQLException ex) {System.out.println(ex); }
        try {
            conn.close();
        } catch (SQLException ex) {System.out.println(ex); }
  }
  
    
}
