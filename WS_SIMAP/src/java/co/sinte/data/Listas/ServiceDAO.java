/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.Service;
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
public class ServiceDAO {

    public String SELECT_SERVICE = "SELECT val.id_valor_flexible,val.valor,val.sigla\n"
            + "FROM PNC_ADM_VALORES_FLEXIBLES val\n"
            + "WHERE val.activo='S' AND val.tipo='PNC_OP_SERVICIOS'";

    Service service = null;

    public ArrayList Service(ArrayList serv, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_SERVICE);
                rs = ps.executeQuery();
                while (rs.next()) {
                    service = new Service();
                    service.setIdValorFlexible(rs.getLong(1));
                    service.setValor(rs.getString(2));
                    service.setSigla(rs.getString(3));
                    serv.add(service);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return serv;
    }

}
