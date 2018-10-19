/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.bean.Asignatura;
import com.umb.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
//persistencia a base de datos // asignaturas -> materias

public class AsignaturaDAO {
    //(materias)

    //conculta para listar asignaturas 
    private String SELECT_A = "SELECT m.id_materia,m.nombre_materia,m.id_unidad,u.nombre_unidad FROM materias m JOIN unidad_academica u ON m.id_unidad=u.id_unidad ";
   //consulta para registrar una asignatura
    private String INSERT_A = "INSERT INTO materias(nombre_materia,id_unidad) VALUES (?,?)";
    //consulta para modificar una asignatura
    private String UPDATE_A = "UPDATE materias SET nombre_materia=?,id_unidad=? WHERE id_materia=? ";

    Asignatura areturn;

    String message;

    ArrayList<Asignatura> asignaturasArr;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void registrarAsignatura(String nombre, int idUnidad) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_A);
                ps.setString(1, nombre);
                ps.setInt(2, idUnidad);

                ps.executeUpdate();

                message = "Asignatura registrada";
                System.out.println("insert exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                message = "error " + ex.getMessage();
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    message = "error " + ex.getMessage();
                }
            }

        }
    }

    public void modificarAsginatura(int idAsignatura,String nombre, int idUnidad) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(UPDATE_A);
                ps.setString(1, nombre);
                ps.setInt(2, idUnidad);
                ps.setInt(3, idAsignatura);

                ps.executeUpdate();

                message = "Asignatura modificada";
                System.out.println("update exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                message = "error " + ex.getMessage();
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    message = "error " + ex.getMessage();
                }
            }

        }

    }

    public ArrayList getAsignaturas() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                asignaturasArr = new ArrayList<>();

                ps = con.prepareStatement(SELECT_A);

                rs = ps.executeQuery();

                while (rs.next()) {
                    areturn = new Asignatura();
                    areturn.setIdAsignatura(rs.getInt(1));
                    areturn.setNombreAsignatura(rs.getString(2));
                    areturn.setIdUnidad(rs.getInt(3));
                    areturn.setNombreUnidad(rs.getString(4));

                    asignaturasArr.add(areturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return asignaturasArr;

    }

}
