/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author DESARROLLO
 */
public class ConnectionDB {
    
    public static Connection getJNDIConnection() {
        
        Connection conn = null;
            try {
               Context initialContext = new InitialContext();
               Context envContext = (Context) initialContext.lookup("java:/comp/env");
               javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/simap");
               if (ds != null) {
                   conn = ds.getConnection();   
               }               
            } catch (NamingException ex) {
                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {                    
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return conn;  
    }    
    
}
