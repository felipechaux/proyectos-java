/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.COAGYHorasEquipoTripulacionTec;
import co.sinte.entities.Listas.riesgos.COAGYHorasTotalesTripulacionTec;
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
public class COAGYHorasEquipoTripulacionTecDAO {

    public String SELECT_HE = "SELECT v.id_riesgo_valores ID \n"
            + ", v.campo valor\n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "  AND p.id_formato = 451\n"
            + "AND p.seccion = 'SELECCION TRIPULACION TEC' \n"
            + "AND p.tipo = 'HORAS EQUIPO' \n"
            + "AND v.activo = 'S'\n"
            + "ORDER BY v.orden ASC ";

    COAGYHorasEquipoTripulacionTec hereturn = null;

    public ArrayList COAGYHorasEquipoTripulacionTec(ArrayList coagyhorasequipo, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_HE);
                rs = ps.executeQuery();
                while (rs.next()) {

                    hereturn = new COAGYHorasEquipoTripulacionTec();

                    hereturn.setId(rs.getLong(1));
                    hereturn.setValor(rs.getString(2));

                    coagyhorasequipo.add(hereturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(COAGYHorasEquipoTripulacionTecDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta.setMensaje(ex.getMessage());
            } finally {
                // Cerrar todas las conexiones. Limtecar los recursos
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
                    Logger.getLogger(COAGYHorasEquipoTripulacionTecDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return coagyhorasequipo;

    }
}
