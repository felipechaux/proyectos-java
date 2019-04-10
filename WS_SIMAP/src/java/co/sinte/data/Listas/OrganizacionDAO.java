/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.Organizacion;
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
public class OrganizacionDAO {

    public String SELECT_ORG = "SELECT o.id_organizacion,o.nombre,o.sigla\n"
            + "FROM PNC_ADM_ORGANIZACIONES o\n"
            + "WHERE o.activo='S'";

    Organizacion organizacion = null;

    public ArrayList Organizacion(ArrayList org, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_ORG);
                rs = ps.executeQuery();
                while (rs.next()) {
                    organizacion = new Organizacion();
                    organizacion.setIdOrganizacion(rs.getLong(1));
                    organizacion.setNombre(rs.getString(2));
                    organizacion.setSigla(rs.getString(3));
                    org.add(organizacion);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrganizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta.setMensaje(ex.getMessage());
            } finally {
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
                    Logger.getLogger(OrganizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return org;
    }

}
