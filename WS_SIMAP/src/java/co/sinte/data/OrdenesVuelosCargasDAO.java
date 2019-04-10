/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.ordenVuelo.OrdenesVuelosCargas;
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
public class OrdenesVuelosCargasDAO {

    private String SELECT_OVC = "SELECT * FROM vw_mlt_ov_cargas where id_ov_itinerario=?";
    
    OrdenesVuelosCargas ovcreturn = null;

    public ArrayList OrdenesVuelosCargas(ArrayList cargas, Long primaryKeyEncabezado, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_OVC);
                ps.setLong(1, primaryKeyEncabezado);
                rs=ps.executeQuery();
                
                while(rs.next())
                {
                    ovcreturn = new OrdenesVuelosCargas();
                    
                    ovcreturn.setIdOvCarga(rs.getLong(1));
                    ovcreturn.setIdOvItinerario(rs.getLong(2));
                    ovcreturn.setIdUnidad(rs.getLong(3));
                    ovcreturn.setNombreOrg(rs.getString(4));
                    ovcreturn.setDescripcion(rs.getString(5));
                    ovcreturn.setCarga(rs.getLong(6));
                    ovcreturn.setUsuarioCreador(rs.getString(7));
                    ovcreturn.setFechaCreacion(rs.getDate(8));
                    ovcreturn.setUsuarioModificador(rs.getString(9));
                    ovcreturn.setFechaModificacion(rs.getDate(10));
                    ovcreturn.setPncVersion(rs.getLong(11));
                    
                    cargas.add(ovcreturn);                    
                }
                
                //respuesta.setMensajeError("Insersion exitosa - en impacto vuelo");
            } catch (SQLException ex) {
                Logger.getLogger(OrdenesVuelosCargasDAO.class.getName()).log(Level.SEVERE, null, ex);
                //respuesta.setCodigoError(2);
                //respuesta.setMensajeError(ex.getMessage());

            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null){
                        rs.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(OrdenesVuelosCargasDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return cargas;
    }

}
