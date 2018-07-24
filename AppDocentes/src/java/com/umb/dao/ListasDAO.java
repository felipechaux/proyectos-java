/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.Lista;
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
public class ListasDAO {

    private String SELECT_UA2 = "SELECT id_unidad,nombre_unidad FROM unidad_academica";

    private String SELECT_F = "SELECT * FROM facultades";

    private String SELECT_R_INDEX = "SELECT id_rol,nombre_rol FROM roles WHERE nombre_rol NOT IN ('COORDINADOR','DIRECTOR')";

    private String SELECT_R_ADMIN = "SELECT id_rol,nombre_rol FROM roles";

    private String SELECT_D = "SELECT id_persona,nombre_persona FROM personas WHERE id_rol = (SELECT id_rol FROM roles WHERE nombre_rol ='DOCENTE')";

    private String SELECT_L = "SELECT l.id_laboratorio,l.nombre_laboratorio FROM laboratorios l ";

    private String SELECT_M = "SELECT id_materia,nombre_materia FROM materias WHERE id_unidad=?";

    private String SELECT_UA = "SELECT id_unidad,nombre_unidad FROM unidad_academica WHERE id_facultad=? AND tipo_programa=? ";

    ArrayList<Lista> listaArr;

    Lista listareturn;

    public ArrayList getLista(String type, int value, String param) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                listaArr = new ArrayList<>();
                switch (type) {
                    case "LF": {
                        ps = con.prepareStatement(SELECT_F);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            listareturn = new Lista();
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            //System.out.println("facultades --> id: " + rs.getInt(1)+" value :"+rs.getString(2));
                            listaArr.add(listareturn);
                        }

                        break;
                    }
                    case "LR": {
                        switch (param) {
                            case "INDEX":
                                ps = con.prepareStatement(SELECT_R_INDEX);
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    listareturn = new Lista();
                                    listareturn.setId(rs.getInt(1));
                                    listareturn.setValor(rs.getString(2));
                                    listaArr.add(listareturn);
                                }
                                break;
                            case "ADMIN":
                                ps = con.prepareStatement(SELECT_R_ADMIN);
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    listareturn = new Lista();
                                    listareturn.setId(rs.getInt(1));
                                    listareturn.setValor(rs.getString(2));
                                    listaArr.add(listareturn);
                                }
                                break;
                        }

                        break;
                    }
                    case "LD": {
                        ps = con.prepareStatement(SELECT_D);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            listareturn = new Lista();
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            listaArr.add(listareturn);
                        }
                        break;
                    }
                    case "LL": {
                        ps = con.prepareStatement(SELECT_L);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            listareturn = new Lista();
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            listaArr.add(listareturn);
                        }
                        break;
                    }
                    case "LM": {
                        //materias
                        ps = con.prepareStatement(SELECT_M);
                        ps.setInt(1, value);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            listareturn = new Lista();
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            listaArr.add(listareturn);
                        }
                        break;
                    }
                    case "LUA": {
                        ps = con.prepareStatement(SELECT_UA);
                        ps.setInt(1, value);
                        ps.setString(2, param);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            listareturn = new Lista();
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            listaArr.add(listareturn);
                        }
                        break;
                    }
                    case "LUA2": {
                        ps = con.prepareStatement(SELECT_UA2);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            listareturn = new Lista();
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            listaArr.add(listareturn);
                        }
                        break;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(ListasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ListasDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return listaArr;
    }

}
