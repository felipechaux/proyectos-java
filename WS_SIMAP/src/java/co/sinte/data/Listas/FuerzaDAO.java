/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.Fuerza;
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
public class FuerzaDAO {

    public String SELECT_F = " SELECT val.id_valor_flexible,val.valor,val.sigla "
            + " FROM PNC_ADM_VALORES_FLEXIBLES val "
            + " WHERE val.activo='S' AND val.tipo='PNC_ADM_TIPOS_FUERZAS' ";

    Fuerza freturn = null;

    public ArrayList Fuerza(ArrayList fuerza,MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_F);
                rs = ps.executeQuery();
                while (rs.next()) {
                    freturn = new Fuerza();
                    freturn.setIdValorFlexible(rs.getLong(1));
                    freturn.setValor(rs.getString(2));
                    freturn.setSigla(rs.getString(3));
                    fuerza.add(freturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(FuerzaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(FuerzaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return fuerza;

    }

}
