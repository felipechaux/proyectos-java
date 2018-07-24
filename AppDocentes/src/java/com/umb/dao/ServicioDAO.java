/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.Servicio;
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
public class ServicioDAO {

    private String SELECT_S = "SELECT s.id_servicio,s.nombre_servicio,s.cantidad,s.descripcion,s.id_laboratorio,l.nombre_laboratorio,s.tipo_servicio FROM servicios_tecnologicos s JOIN laboratorios l ON s.id_laboratorio=l.id_laboratorio ";

    private String INSERT_S = "INSERT INTO servicios_tecnologicos(nombre_servicio,cantidad,descripcion,id_laboratorio,tipo_servicio) VALUES (?,?,?,?,?)";

    private String UPDATE_S = "UPDATE servicios_tecnologicos SET nombre_servicio=?,cantidad=?,descripcion=?,id_laboratorio=?,tipo_servicio=? WHERE id_servicio=? ";

    Servicio sreturn;

    String message;

    ArrayList<Servicio> serviciosArr;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void registrarServicio(String nombre, int cantidad, String descripcion, int idLaboratorio, String tipoServicio) {
        PreparedStatement ps = null;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_S);
                ps.setString(1, nombre);
                ps.setInt(2, cantidad);
                ps.setString(3, descripcion);
                ps.setInt(4, idLaboratorio);
                ps.setString(5, tipoServicio);

                ps.executeUpdate();

                message = "Servicio registrado";
                System.out.println("insert exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    message = "error " + ex.getMessage();
                }
            }

        }
    }

    public void modificarServicio(int idServicio, String nombre, int cantidad, String descripcion, int idLaboratorio, String tipoServicio) {
        PreparedStatement ps = null;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(UPDATE_S);
                ps.setString(1, nombre);
                ps.setInt(2, cantidad);
                ps.setString(3, descripcion);
                ps.setInt(4, idLaboratorio);
                ps.setString(5, tipoServicio);
                ps.setInt(6, idServicio);

                ps.executeUpdate();

                message = "Servicio modificado";
                System.out.println("update exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    message = "error " + ex.getMessage();
                }
            }

        }
    }

    public ArrayList getServicios() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                serviciosArr = new ArrayList<>();

                ps = con.prepareStatement(SELECT_S);

                rs = ps.executeQuery();

                while (rs.next()) {
                    sreturn = new Servicio();
                    sreturn.setIdServicio(rs.getInt(1));
                    sreturn.setNombre(rs.getString(2));
                    sreturn.setCantidad(rs.getInt(3));
                    sreturn.setDescripcion(rs.getString(4));
                    sreturn.setIdLaboratorio(rs.getInt(5));
                    sreturn.setNombreLaboratorio(rs.getString(6));
                    sreturn.setTipoServicio(rs.getString(7));
                    serviciosArr.add(sreturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return serviciosArr;

    }

}
