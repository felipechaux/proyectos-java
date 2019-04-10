/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.MissionStd;
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
public class MissionStdDAO {

    public String SELECT_MS = " SELECT m.id_mision,m.sigla,m.mision,m.observaciones "
            + " FROM PNC_ADM_MISIONES m "
            + " WHERE m.activo='S' ";

    MissionStd msreturn = null;

    public ArrayList MissionStd(ArrayList missionStd, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_MS);
                rs = ps.executeQuery();
                while (rs.next()) {
                    msreturn = new MissionStd();
                    msreturn.setIdMision(rs.getLong(1));
                    msreturn.setSigla(rs.getString(2));
                    msreturn.setMision(rs.getString(3));
                    msreturn.setObservaciones(rs.getString(4));
                    missionStd.add(msreturn);
                    

                }

            } catch (SQLException ex) {
                Logger.getLogger(MissionStdDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(MissionStdDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return missionStd;

    }
}
