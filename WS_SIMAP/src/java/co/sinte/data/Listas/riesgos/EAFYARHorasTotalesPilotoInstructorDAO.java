/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.EAFYARHorasTotalesPilotoInstructor;
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
public class EAFYARHorasTotalesPilotoInstructorDAO {

    public String SELECT_EAFYAR_HorasTotales = "SELECT v.id_riesgo_valores ID \n"
            + ", v.campo valor\n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "  AND p.id_formato = 787\n"
            + "AND p.seccion = 'SELECCION PILOTO INSTRUCTOR' \n"
            + "AND p.tipo = 'HORAS TOTALES' \n"
            + "AND v.activo = 'S'\n"
            + "ORDER BY v.orden ASC";

    EAFYARHorasTotalesPilotoInstructor eafyarHorasTotalesPIReturn = null;

    public ArrayList EAFYARHorasTotalesPilotoInstructor(ArrayList eafyarHorasTotalesPI, MensajeRespuesta msj) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_EAFYAR_HorasTotales);
                rs = ps.executeQuery();
                while (rs.next()) {
                    eafyarHorasTotalesPIReturn = new EAFYARHorasTotalesPilotoInstructor();
                    eafyarHorasTotalesPIReturn.setId(rs.getLong(1));
                    eafyarHorasTotalesPIReturn.setValor(rs.getString(2));
                    eafyarHorasTotalesPI.add(eafyarHorasTotalesPIReturn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EAFYARHorasTotalesPilotoInstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(EAFYARHorasTotalesPilotoInstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    msj.setMensaje(ex.getMessage());
                }
            }
        }

        return eafyarHorasTotalesPI;
    }

}
