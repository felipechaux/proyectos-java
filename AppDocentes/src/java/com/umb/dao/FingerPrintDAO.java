/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.Huella;
import com.umb.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class FingerPrintDAO {

    private String SELECT_H = "SELECT h.id_persona,p.nombre_persona,h.huella,h.tamaño,p.id_unidad,r.nombre_rol,p.email,u.nombre_unidad FROM huellas h JOIN personas p ON h.id_persona=p.id_persona JOIN roles r ON p.id_rol=r.id_rol JOIN unidad_academica u ON p.id_unidad=u.id_unidad ";
    private String INSERT_H = "INSERT INTO huellas (id_persona,huella,tamaño) VALUES (?,?,?)";

    Huella hreturn;
    ArrayList<Huella> arr;
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList buscarhuella() throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_H);

                rs = ps.executeQuery();
                arr = new ArrayList<>();
                while (rs.next()) {
                    hreturn = new Huella();
                    hreturn.setIdPersona(rs.getInt(1));
                    hreturn.setNombrePersona(rs.getString(2));
                    hreturn.setHuella(rs.getBytes(3));
                    hreturn.setTamaño(rs.getInt(4));
                    hreturn.setIdUnidad(rs.getInt(5));
                    hreturn.setNombreRol(rs.getString(6));
                    hreturn.setEmail(rs.getString(7));
                    hreturn.setNombreUnidadAcademica(rs.getString(8));

                    arr.add(hreturn);
                    //  System.out.println("consulta Result  id " + rs.getInt(1) + "\n persona" + rs.getInt(2) + "\n huella " + Arrays.toString(rs.getBytes(3)) + "\n tamaño" + rs.getInt(4));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FingerPrintDAO.class.getName()).log(Level.SEVERE, null, ex);

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
                    Logger.getLogger(FingerPrintDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }

        }

        return arr;

    }

    public void enrolar(String id, byte[] huella, int tamaño) throws SQLException {

        PreparedStatement ps = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {

            try {
                ps = con.prepareStatement(INSERT_H);
                ps.setInt(1, Integer.parseInt(id));
                ps.setBytes(2, huella);
                ps.setInt(3, tamaño);

                ps.executeUpdate();
                message = "Usuario enrolado ";
                System.out.println("usuario enrolado ");

            } catch (SQLException ex) {
                Logger.getLogger(FingerPrintDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(FingerPrintDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    message = "error " + ex.getMessage();
                }
            }

        }

    }

    public static void main(String[] args) throws SQLException {

        System.out.println("inicio");

        FingerPrintDAO f = new FingerPrintDAO();
        f.buscarhuella();

        for (int i = 0; i < f.buscarhuella().size(); i++) {
            System.out.println("size");
            Huella h = (Huella) f.buscarhuella().get(i);

            System.out.println("tamaños " + h.getTamaño() + "\n huella " + Arrays.toString(h.getHuella()));
        }

    }

}
