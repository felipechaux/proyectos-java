/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.Cifrado;
import com.umb.entities.Persona;
import com.umb.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class UsuarioDAO {

    private String INSERT = "INSERT INTO personas(id_persona,password,nombre_persona,id_unidad,id_rol,email) VALUES(?,?,?,?,?,?)";

    private String SELECT_P = "SELECT p.id_persona,p.nombre_persona,p.id_unidad,r.nombre_rol,p.email,u.nombre_unidad FROM personas p JOIN roles r ON p.id_rol=r.id_rol LEFT JOIN unidad_academica u ON p.id_unidad=u.id_unidad WHERE id_persona=? AND password=?";

    private String UPDATE_P = "UPDATE personas SET nombre_persona=?,password=?,email=? WHERE id_persona=?  ";

    private String EXISTENCIA_CUENTA = "SELECT * FROM personas WHERE id_persona=?";

    String message;
    Persona usuarioreturn;
    ArrayList<Persona> arrusuario;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean consultar(String id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean respuesta = false;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(EXISTENCIA_CUENTA);
                ps.setInt(1, Integer.parseInt(id));
                rs = ps.executeQuery();

                if (rs.next()) {
                    //System.out.println("cuenta existente");
                    respuesta = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

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
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }

        }
        return respuesta;
    }

    public ArrayList autenticar(String user, String pass) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        //boolean respuesta = false;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                Cifrado cifrar = new Cifrado();
                ps = con.prepareStatement(SELECT_P);
                ps.setInt(1, Integer.parseInt(user));
                ps.setString(2, cifrar.Encriptar(pass));

                rs = ps.executeQuery();
                arrusuario = new ArrayList<>();

                if (rs.next()) {
                    usuarioreturn = new Persona();
//                    usuarioreturn.setId(rs.getString(1));
                    usuarioreturn.setNombreUsuario(rs.getString(2) + " ");
                    usuarioreturn.setUnidadAcademica(rs.getInt(3));
                    usuarioreturn.setNombreRol(rs.getString(4));
                    usuarioreturn.setEmail(rs.getString(5));
                    usuarioreturn.setNombreUnidadAcademica(rs.getString(6));
                    //usuarioreturn.setSession(true);
                    System.out.println("id usuario " + rs.getString(1));
                    System.out.println("login usuario-> " + rs.getInt(1));
                    System.out.println("unidad academica " + rs.getInt(3));
                    System.out.println("rol es --> " + rs.getString(4));
                    System.out.println("email " + rs.getString(5));
//                    System.out.println(" get unidad  " + usuarioreturn.getUnidadAcademica());
                    arrusuario.add(usuarioreturn);
                    // respuesta = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

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
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }

        } else {
            message = "Conexion fallida con BD";
        }
        return arrusuario;
    }

    public boolean registrarUsuario(String idPersona, String clave, String nombre, int unidadAcademica, int rol, String email) {

        System.out.println("entra registrar");
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean respuesta = false;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                Cifrado cifrar = new Cifrado();
                ps = con.prepareStatement(INSERT);
                ps.setInt(1, Integer.parseInt(idPersona));
                ps.setString(2, cifrar.Encriptar(clave));
                ps.setString(3, nombre);
                if (unidadAcademica != 0) {
                    ps.setInt(4, unidadAcademica);
                } else {
                    ps.setNull(4, Types.INTEGER);
                }
                ps.setInt(5, rol);
                ps.setString(6, email);
                ps.executeUpdate();
                respuesta = true;
                message = "Cuenta creada";
                System.out.println("insert exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
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
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    message = "error " + ex.getMessage();
                }
            }

        }

        return respuesta;
    }

    public void modificarUsuario(String idPersona, String clave, String nombre, String email) {
        System.out.println("entra update");
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                Cifrado cifrar = new Cifrado();
                ps = con.prepareStatement(UPDATE_P);
                ps.setString(1, nombre);
                if (!clave.equals("")) {
                    ps.setString(2, cifrar.Encriptar(clave));
                } else {
                    ps.setNull(2, Types.VARCHAR);
                }
                ps.setString(3, email);
                ps.setInt(4, Integer.parseInt(idPersona));

                ps.executeUpdate();
                message = "Cambios realizados";
                System.out.println("update exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    message = "error " + ex.getMessage();
                }
            }

        }
    }

}
