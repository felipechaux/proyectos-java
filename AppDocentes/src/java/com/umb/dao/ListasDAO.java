/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.Lista;
import com.umb.entities.NombreDisponibilidad;
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
//persistencia a base de datos // listas

public class ListasDAO {

    //consulta para capturar informacion de la lista unidad academica
    private String SELECT_UA2 = "SELECT id_unidad,nombre_unidad FROM unidad_academica";
    //consulta para capturar informacion de la lista unidad academica con campo reserva(si es posible reservar --> 0 no tiene permisos, 1 si tiene permisos) 
    private String SELECT_UA3 = "SELECT id_unidad,nombre_unidad,reserva FROM unidad_academica";
    //consulta para capturar informacion de la lista facultades
    private String SELECT_F = "SELECT * FROM facultades";
    //consulta para capturar informacion de los roles que se pueden visualizar en el login
    private String SELECT_R_INDEX = "SELECT id_rol,nombre_rol FROM roles WHERE nombre_rol NOT IN ('COORDINADOR','DIRECTOR')";
    //consulta para capturar informacion de los roles que se peuden visualizar por un usuario administrativo
    private String SELECT_R_ADMIN = "SELECT id_rol,nombre_rol FROM roles";
    //consulta para capturar informacion de la lista usuarios con rol docente
    private String SELECT_D = "SELECT id_persona,nombre_persona FROM personas WHERE id_rol = (SELECT id_rol FROM roles WHERE nombre_rol ='DOCENTE')";
    //consulta para capturar informacion de la lista laboratorios
    private String SELECT_L = "SELECT l.id_laboratorio,l.nombre_laboratorio,l.cantidad_pcs FROM laboratorios l ";
    //consulta para capturar informacion de la lista facultades
    private String SELECT_M = "SELECT id_materia,nombre_materia FROM materias WHERE id_unidad=? ORDER BY nombre_materia";
    //consulta para capturar informacion de la lista unidad academica (programas)
    private String SELECT_UA = "SELECT id_unidad,nombre_unidad FROM unidad_academica WHERE id_facultad=? AND tipo_programa=? ";
    //consulta para capturar nombres de la disponibilidad laboratorio para el envio de correo
    private String SELECT_NOMBRES_DISPONIBILIDAD_LABORATORIO = "SELECT d.fecha,d.bloque_ini,d.bloque_fin,l.nombre_laboratorio,m.nombre_materia,p.nombre_persona,p.email \n"
            + " from disponibilidad_laboratorio d\n"
            + " JOIN laboratorios l\n"
            + " ON \n"
            + " d.id_laboratorio=l.id_laboratorio\n"
            + " JOIN reservas r\n"
            + " ON d.id_disponibilidad=r.id_disponibilidad\n"
            + " JOIN materias m\n"
            + " ON r.id_materia=m.id_materia\n"
            + "JOIN personas p\n"
            + " ON r.id_persona=p.id_persona"
            + " where d.id_disponibilidad=?";

    //consulta para capturar informacion de la lista gupos laboratorio
    private String SELECT_G = " SELECT id_grupo_materia,nombre_grupo FROM grupo_materia WHERE id_materia=? ";

    ArrayList<Lista> listaArr;

    ArrayList<NombreDisponibilidad> nombreDisponibilidadArr;

    NombreDisponibilidad nombredisponibilidadreturn;

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
                            listareturn.setCantidad(rs.getInt(3));
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
                    case "LUA3": {
                        ps = con.prepareStatement(SELECT_UA3);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            listareturn = new Lista();
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            if (rs.getInt(3) == 1) {
                                listareturn.setReserva(true);
                            } else {
                                listareturn.setReserva(false);
                            }
                            listaArr.add(listareturn);
                        }
                        break;
                    }
                    // grupos materia
                    case "LGM": {
                        ps = con.prepareStatement(SELECT_G);
                        ps.setInt(1, value);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            System.out.println("grupos ---");
                            listareturn = new Lista();
                            System.out.println("id " + rs.getInt(1) + " nombre " + rs.getString(2));
                            listareturn.setId(rs.getInt(1));
                            listareturn.setValor(rs.getString(2));
                            listaArr.add(listareturn);
                        }
                        break;
                    }
                    case "NOMBRES_D": {
                        nombreDisponibilidadArr = new ArrayList();
                        ps = con.prepareStatement(SELECT_NOMBRES_DISPONIBILIDAD_LABORATORIO);
                        ps.setInt(1, value);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            System.out.println("nombres disponibilidad");
                            //System.out.println("fecha :"+rs.getString(1)+"  bloque :"+rs.getString(2)+" - "+rs.getString(3)+" Laboratorio :"+rs.getString(4)+" Asignatura: "+rs.getString(5));
                            nombredisponibilidadreturn = new NombreDisponibilidad();
                            nombredisponibilidadreturn.setFecha(rs.getString(1));
                            nombredisponibilidadreturn.setBloque(rs.getString(2) + " - " + rs.getString(3));
                            nombredisponibilidadreturn.setNombreLaboratorio(rs.getString(4));
                            nombredisponibilidadreturn.setNombreAsignatura(rs.getString(5));
                            nombredisponibilidadreturn.setNombrePersonaAsignada(rs.getString(6));
                            nombredisponibilidadreturn.setEmailPersonaAsignada(rs.getString(7));
                            nombreDisponibilidadArr.add(nombredisponibilidadreturn);
                        }
                        return nombreDisponibilidadArr;
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
