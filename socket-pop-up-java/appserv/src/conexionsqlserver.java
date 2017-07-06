/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class conexionsqlserver {
    
    private static Connection cn;
  
    
    
    
    public static Connection getConnection(){
     
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          // cn=DriverManager.getConnection("jdbc:sqlserver://172.16.232.113:1433;databaseName=Reporting_Colombia","fabian","Colombia2017");
          cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Reporting_Colombia","felipe","6666");
           
           
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            cn=null;
        }
        return cn;
        
    }
    public static void main(String[]args){
        
        Connection pru = conexionsqlserver.getConnection();
        
        if(pru!=null){
          //  JOptionPane.showMessageDialog(null, "Conexion exitosa");
       }else{
            JOptionPane.showMessageDialog(null, "no hay conexion con SQLSERVER" +pru);
        }
             
        
        
    }
    
}
