/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.COAGYDyn;
import co.sinte.entities.Listas.riesgos.COAGYTerrenoReconocimiento;
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
public class COAGYTerrenoReconocimientoDAO {

    public String SELECT_D = " SELECT v.id_riesgo_valores ID \n"
            + ", SUBSTR(v.campo,6)  valor\n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "  AND p.id_formato = 451\n"
            + "AND p.seccion = 'FACTORES TOPOGRAFICOS' \n"
            + "AND p.tipo = 'TIPO TERRENO' \n"
            + "AND V.ACTIVO = 'S' ";

    COAGYTerrenoReconocimiento sreturn = null;

    public ArrayList COAGYTerrenoReconocimiento(ArrayList coagyterrenoreconocimiento, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_D);
                rs = ps.executeQuery();
                while (rs.next()) {

                    sreturn = new COAGYTerrenoReconocimiento();

                    sreturn.setId(rs.getLong(1));
                    sreturn.setValor(rs.getString(2));

                    coagyterrenoreconocimiento.add(sreturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(COAGYTerrenoReconocimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(COAGYTerrenoReconocimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return coagyterrenoreconocimiento;

    }

}
