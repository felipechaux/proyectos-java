/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.RALARClaseVuelo;
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
public class RALARClaseVueloDAO {

    public String SELECT_RALAR_Clase_Vuelo = "SELECT v.id_riesgo_valores ID \n"
            + ", v.campo valor \n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "AND p.seccion = 'COMPLEJIDAD DE LA MISION' \n"
            + "AND p.tipo = 'CLASE VUELO'\n"
            + "AND v.activo = 'S'\n"
            + "ORDER BY v.orden ASC";

    RALARClaseVuelo ralarClaseVueloReturn = null;

    public ArrayList RALARClaseVuelo(ArrayList ralarClaseVuelo, MensajeRespuesta msj) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_RALAR_Clase_Vuelo);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ralarClaseVueloReturn = new RALARClaseVuelo();
                    ralarClaseVueloReturn.setId(rs.getLong(1));
                    ralarClaseVueloReturn.setValor(rs.getString(2));
                    ralarClaseVuelo.add(ralarClaseVueloReturn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RALARClaseVueloDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RALARClaseVueloDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    msj.setMensaje(ex.getMessage());
                }
            }
        }
        return ralarClaseVuelo;
    }

}
