/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.ordenVuelo.OrdenesVuelosTripulaciones;
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
public class OrdenesVuelosTripulacionesDAO {
    
    private String SELECT_OVT = "SELECT * FROM VW_MLT_OV_TRIPULACIONES where id_orden_vuelo=?";
    
    OrdenesVuelosTripulaciones ovtreturn = null;
    
    public ArrayList OrdenesVuelosTripulaciones(ArrayList tripulacion, Long primaryKeyEncabezado, MensajeRespuesta respuesta) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();
        
        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_OVT);
                ps.setLong(1, primaryKeyEncabezado);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ovtreturn = new OrdenesVuelosTripulaciones();
                    
                    ovtreturn.setIdOvTripulacion(rs.getLong(1));
                    ovtreturn.setIdOrdenVuelo(rs.getLong(2));
                    ovtreturn.setNumeroOv(rs.getLong(3));
                    ovtreturn.setCargo(rs.getString(4));
                    ovtreturn.setDescripcionCargo(rs.getString(5));
                    ovtreturn.setGrado(rs.getString(6));
                    ovtreturn.setIdPersona(rs.getLong(7));
                    ovtreturn.setNombrePersona(rs.getString(8));
                    ovtreturn.setPid(rs.getString(9));
                    ovtreturn.setPeso(rs.getLong(10));
                    ovtreturn.setAsiento(rs.getString(11));
                    ovtreturn.setUsuarioCreador(rs.getString(12));
                    ovtreturn.setFechaCreacion(rs.getDate(13));
                    ovtreturn.setUsuarioModificador(rs.getString(14));
                    ovtreturn.setFechaModificacion(rs.getDate(15));
                    ovtreturn.setPncVersion(rs.getLong(16));
                    
                    tripulacion.add(ovtreturn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrdenesVuelosTripulacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
                
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
                    Logger.getLogger(OrdenesVuelosTripulacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return tripulacion;
        
    }
    
}
