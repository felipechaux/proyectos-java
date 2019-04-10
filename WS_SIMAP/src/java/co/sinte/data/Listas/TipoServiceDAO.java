/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.TipoService;
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
public class TipoServiceDAO {

    public String SELECT_TIPOSERVICE = " SELECT val.id_valor_flexible,val.valor,val.sigla "
            + " FROM PNC_ADM_VALORES_FLEXIBLES val "
            + " WHERE val.activo='S' AND (val.tipo='PNC_OP_TIPOS_SERVICIOS' OR val.tipo = 'PNC_CO_TIPO_COMB')";

    TipoService tiposervice = null;

    public ArrayList TipoService(ArrayList tip_serv, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_TIPOSERVICE);
                rs = ps.executeQuery();
                while (rs.next()) {
                    tiposervice = new TipoService();
                    tiposervice.setIdValorFlexible(rs.getLong(1));
                    tiposervice.setValor(rs.getString(2));
                    tiposervice.setSigla(rs.getString(3)); 
                    tip_serv.add(tiposervice);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TipoServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(TipoServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return tip_serv;
    }

}
