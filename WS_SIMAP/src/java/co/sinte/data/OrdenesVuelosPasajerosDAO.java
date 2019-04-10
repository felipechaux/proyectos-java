/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.ordenVuelo.OrdenesVuelosPasajeros;
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
public class OrdenesVuelosPasajerosDAO {

    private String SELECT_OVP = "SELECT * FROM VW_MLT_OV_PASAJEROS WHERE id_ov_itinerario = ? ";

    private String UPDATE_OVP = " UPDATE pnc_op_ov_pasajeros  SET abordo=? where id_ov_pasajero= ?";

    OrdenesVuelosPasajeros ovtreturn = null;

    public ArrayList OrdenesVuelosPasajeros(ArrayList pasajeros, Long primaryKeyEncabezado, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_OVP);
                ps.setLong(1, primaryKeyEncabezado);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ovtreturn = new OrdenesVuelosPasajeros();

                    ovtreturn.setIdOvPasajero(rs.getLong(1));
                    ovtreturn.setIdOvItinerario(rs.getLong(2));
                    ovtreturn.setIdPasajero(rs.getLong(3));
                    ovtreturn.setIdCargo(rs.getLong(4));
                    ovtreturn.setCargo(rs.getString(5));
                    ovtreturn.setNombrePasajero(rs.getString(6));
                    ovtreturn.setGrado(rs.getString(7));
                    ovtreturn.setPeso(rs.getLong(8));
                    ovtreturn.setPesoEquipaje(rs.getLong(9));
                    ovtreturn.setAutoriza(rs.getString(10));
                    ovtreturn.setRutaVuelo(rs.getString(11));
                    ovtreturn.setUsuarioCreador(rs.getString(12));
                    ovtreturn.setFechaCreacion(rs.getDate(13));
                    ovtreturn.setUsuarioModificador(rs.getString(14));
                    ovtreturn.setFechaModificacion(rs.getDate(15));
                    ovtreturn.setPncVersion(rs.getLong(16));
                    ovtreturn.setPesoTotal(rs.getLong(17));
                    pasajeros.add(ovtreturn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrdenesVuelosPasajerosDAO.class.getName()).log(Level.SEVERE, null, ex);

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
                    Logger.getLogger(OrdenesVuelosPasajerosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return pasajeros;
    }

    public boolean PasajerosUpdate(Long id, String abordo) {
        
        
        boolean respuesta = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();
        
        System.out.println("PasajerosUpdate parametros id-->"+id +"; abb->"+abordo);

        if (con != null) {
            try {
                ps = con.prepareStatement(UPDATE_OVP);
                ps.setString(1, abordo);
                ps.setLong(2, id);

                ps.executeUpdate();

                System.out.println("Actualizacion exitosa de pasajero ");
                respuesta=true;
            } catch (SQLException ex) {
                Logger.getLogger(OrdenesVuelosPasajerosDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" " + ex.getMessage());
                 respuesta=false;

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
                    Logger.getLogger(OrdenesVuelosPasajerosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                     respuesta=false;
                }
            }
        }

        return respuesta;
    }

}
