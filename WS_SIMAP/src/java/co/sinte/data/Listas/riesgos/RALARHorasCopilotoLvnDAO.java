/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.RALARHorasCopilotoLvn;
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
public class RALARHorasCopilotoLvnDAO {

    public String SELECT_RALAR_Horas_COP_Lvn = "SELECT v.id_riesgo_valores ID \n"
            + ", v.campo valor \n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "AND p.seccion = 'SELECCION COPILOTO LVN' \n"
            + "AND p.tipo = 'HORAS'\n"
            + "AND v.activo = 'S'\n"
            + "ORDER BY v.orden ASC";

    RALARHorasCopilotoLvn ralarHorasCopilotoLvnReturn = null;

    public ArrayList RALARHorasCopilotoLvn(ArrayList ralarHorasCopilotoLvn, MensajeRespuesta msj) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_RALAR_Horas_COP_Lvn);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ralarHorasCopilotoLvnReturn = new RALARHorasCopilotoLvn();
                    ralarHorasCopilotoLvnReturn.setId(rs.getLong(1));
                    ralarHorasCopilotoLvnReturn.setValor(rs.getString(2));
                    ralarHorasCopilotoLvn.add(ralarHorasCopilotoLvnReturn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RALARHorasCopilotoLvnDAO.class.getName()).log(Level.SEVERE, null, ex);
                msj.setMensaje(ex.getMessage());
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
                    Logger.getLogger(RALARHorasCopilotoLvnDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    msj.setMensaje(ex.getMessage());
                }
            }
        }
        return ralarHorasCopilotoLvn;
    }

}
