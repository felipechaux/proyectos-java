/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.Name;
import co.sinte.entities.MensajeRespuesta;
import co.sinte.util.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DESARROLLO
 */
public class NameDAO {

    public String SELECT_N = " SELECT p.id_persona,p.nombre,p.cedula,tri.cargo,tri.grado "
            + "FROM PNC_OP_OV_TRIPULACIONES tri,PNC_ADM_PERSONAS p "
            + "WHERE tri.id_persona(+)=p.id_persona ";

    Name nreturn = null;

    public ArrayList Name(ArrayList name,MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_N);
                rs = ps.executeQuery();
                while (rs.next()) {
                    nreturn = new Name();
                    nreturn.setIdPersona(rs.getLong(1));
                    nreturn.setNombre(rs.getString(2));
                    nreturn.setCedula(rs.getString(3));
                    nreturn.setCargo(rs.getString(4));
                    nreturn.setGrado(rs.getString(5));
                    name.add(nreturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(NameDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta.setMensaje(ex.getMessage());
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NameDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return name;

    }
}
