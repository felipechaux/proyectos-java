/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.RALARHorasTrabajadas;
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
public class RALARHorasTrabajadasDAO {

    public String SELECT_RALAR_Horas_Trabajadas = "SELECT v.id_riesgo_valores ID \n"
            + ", v.campo valor \n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "AND p.seccion = 'RENDIMIENTO DE LA TRIPULACION' \n"
            + "AND p.tipo = 'HORAS TRABAJADAS'\n"
            + "AND v.activo = 'S'\n"
            + "ORDER BY v.orden ASC";

    RALARHorasTrabajadas ralarHorasTrabajadasReturn = null;

    public ArrayList RALARHorasTrabajadas(ArrayList ralarHorasTrabajadas, MensajeRespuesta msj) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_RALAR_Horas_Trabajadas);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ralarHorasTrabajadasReturn = new RALARHorasTrabajadas();
                    ralarHorasTrabajadasReturn.setId(rs.getLong(1));
                    ralarHorasTrabajadasReturn.setValor(rs.getString(2));
                    ralarHorasTrabajadas.add(ralarHorasTrabajadasReturn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RALARHorasTrabajadasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RALARHorasTrabajadasDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    msj.setMensaje(ex.getMessage());
                }
            }
        }
        return ralarHorasTrabajadas;
    }

}
