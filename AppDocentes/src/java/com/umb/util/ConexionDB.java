/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */

//conexion a base de datos
public class ConexionDB {

    public static Connection ConnectDB() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bd_app_docentes", "root", "Xrock666");

            // JOptionPane.showMessageDialog(null, "Conexion con base de datos exitosa");
        } catch (ClassNotFoundException e1) {
            System.out.println("ERROR:No encuentro el driver de la BD: " + e1.getMessage());
        } catch (SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: " + e2.getMessage());
        }
        return con;

    }

}
