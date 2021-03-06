/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas.riesgos;

import co.sinte.entities.Listas.riesgos.COAGYControl;
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
public class COAGYControlDAO {

    public String SELECT_C = " SELECT v.id_riesgo_valores ID -- campo que se guarda en el ID\n"
            + ", v.campo valor -- campo que se visualiza en el dsp\n"
            + "FROM pnc_op_riesgo_param p\n"
            + ", pnc_op_riesgo_valores v\n"
            + "WHERE p.id_riesgo_param = v.id_riesgo_param\n"
            + "AND p.id_formato = 765 -- R.EAFYAR -- es el id del formato que se esta realizando\n"
            + "AND p.seccion = 'SUPERVISION' -- es el bloque al que pertenece al secion remarcada en el formato\n"
            + "AND p.tipo = 'CONTROL' -- es el label del campo que se ve en el formato\n"
            + "AND v.activo = 'S'\n"
            + "ORDER BY v.orden ASC ";

    COAGYControl creturn = null;

    public ArrayList COAGYControl(ArrayList coagycontrol, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_C);
                rs = ps.executeQuery();
                while (rs.next()) {

                    creturn = new COAGYControl();

                    creturn.setId(rs.getLong(1));
                    creturn.setValor(rs.getString(2));

                    coagycontrol.add(creturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(COAGYMandoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(COAGYControlDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return coagycontrol;
    }
}
