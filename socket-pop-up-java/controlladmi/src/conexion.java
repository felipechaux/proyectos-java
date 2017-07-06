

import java.sql.*;
import javax.swing.*;

public class conexion {
	
    Connection con=null;
    public static Connection ConnectDB(){
  
    	try{
    Class.forName("com.mysql.jdbc.Driver");
  
   //Connection con= DriverManager.getConnection("jdbc:mysql://172.16.58.202:2020/bd_jazzplat","root","");
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/bd_jazzplat","root","");
 
  // JOptionPane.showMessageDialog(null,"Conexion con base de datos exitosa");
    return con;
    }
    
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;
    }    
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
}
