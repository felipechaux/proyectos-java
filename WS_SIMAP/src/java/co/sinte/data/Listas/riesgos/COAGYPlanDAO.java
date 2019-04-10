/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.COAGYHorasTotalesTripulacionPc;
import co.sinte.entities.Listas.riesgos.COAGYPlan;
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
public class COAGYPlanDAO {

    public String SELECT_HT = " SELECT v.id_riesgo_valores ID \n"
            + ", v.campo valor\n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "  AND p.id_formato = 451\n"
            + "AND p.seccion = 'PLANIFICACION DE LA MISION' \n"
            + "AND p.tipo = 'PLAN' \n"
            + "AND v.activo = 'S'\n"
            + "ORDER BY v.orden ASC ";

    COAGYPlan preturn = null;

    public ArrayList COAGYPlan(ArrayList coagyplan, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_HT);
                rs = ps.executeQuery();
                while (rs.next()) {

                    preturn = new COAGYPlan();

                    preturn.setId(rs.getLong(1));
                    preturn.setValor(rs.getString(2));

                    coagyplan.add(preturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(COAGYPlanDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(COAGYPlanDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return coagyplan;

    }
}