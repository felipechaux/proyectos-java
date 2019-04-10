/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.PtoTanqueo;
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
public class PtoTanqueoDAO {

    public String SELECT_PTO_TANQUEO = "SELECT t.id_punto_tanqueo,t.nombre_pto_tanqueo\n"
            + "FROM PNC_CO_PTO_TANQUEO t\n"
            + "WHERE t.activo='S'";

    PtoTanqueo ptotanqueo = null;

    public ArrayList PtoTanqueo(ArrayList ptotanq, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_PTO_TANQUEO);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ptotanqueo = new PtoTanqueo();
                    ptotanqueo.setIdPuntoTanqueo(rs.getLong(1));
                    ptotanqueo.setNombrePtoTanqueo(rs.getString(2));
                    ptotanq.add(ptotanqueo);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PtoTanqueoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(PtoTanqueoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return ptotanq;
    }

}
