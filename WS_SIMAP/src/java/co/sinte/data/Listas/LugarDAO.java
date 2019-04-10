/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.Lugar;
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
public class LugarDAO {

    public String SELECT_L = " SELECT l.id_lugar,l.iata,l.oaci,l.nombre_aeropuerto "
            + "FROM PNC_ADM_LUGARES l "
            + "WHERE l.activo='S' ";

    Lugar lreturn =null;

    public ArrayList Lugar(ArrayList lugar ,MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_L);
                rs = ps.executeQuery();
                while (rs.next()) {
                    lreturn= new Lugar();             
                    lreturn.setIdLugar(rs.getLong(1));
                    lreturn.setIata(rs.getString(2));
                    lreturn.setOaci(rs.getString(3));
                    lreturn.setNombreAeropuerto(rs.getString(4));
                    lugar.add(lreturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(LugarDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(LugarDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return lugar;

    }

}
