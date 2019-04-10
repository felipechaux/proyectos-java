/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.ordenVuelo.OrdenesVuelos;
import co.sinte.entities.ordenVuelo.OrdenesVuelosItinerarios;
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
public class OrdenesVuelosDAO {
    
    public String SELECT_OV = "SELECT * FROM vw_mlt_ordenes_vuelo "
            + " where id_orden_vuelo=?";
    
    OrdenesVuelos ovreturn = new OrdenesVuelos();
    OrdenesVuelosItinerariosDAO daoItinerarios = new OrdenesVuelosItinerariosDAO();
    OrdenesVuelosTripulacionesDAO daoTripulaciones = new OrdenesVuelosTripulacionesDAO();
    
    public OrdenesVuelos OrdenesVuelos(Long primaryKeyEncabezado, MensajeRespuesta respuesta) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();
        
        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_OV);
                ps.setLong(1, primaryKeyEncabezado);
                rs = ps.executeQuery();
                while (rs.next()) {
                    
                    ovreturn.setIdOrdenVuelo(rs.getLong(1));
                    ovreturn.setNumero(rs.getLong(2));
                    ovreturn.setIdProgramacion(rs.getLong(3));
                    ovreturn.setNumeroProgramacion(rs.getLong(4));
                    ovreturn.setIdAeronave(rs.getLong(5));
                    ovreturn.setMatriculaAeronave(rs.getString(6));
                    ovreturn.setTemperatura(rs.getLong(7));
                    ovreturn.setFechaHora(rs.getDate(8));
                    ovreturn.setIdDespachador(rs.getLong(9));
                    ovreturn.setDespachador(rs.getString(10));
                    ovreturn.setInstrucciones(rs.getString(11));
                    ovreturn.setObservaciones(rs.getString(12));
                    ovreturn.setNumeroBoletin(rs.getString(13));
                    ovreturn.setUsuarioCreador(rs.getString(14));
                    ovreturn.setFechaCreacion(rs.getDate(15));
                    ovreturn.setUsuarioModificador(rs.getString(16));
                    ovreturn.setFechaModificacion(rs.getDate(17));
                    ovreturn.setPncVersion(rs.getLong(18));
                    ovreturn.setEstado(rs.getString(19));
                    ovreturn.setAip(rs.getString(20));
                    ovreturn.setReporte(rs.getString(21));
                    ovreturn.setNotam(rs.getString(22));
                    ovreturn.setMedida(rs.getString(23));
                    ovreturn.setModelo(rs.getString(24));
                    ovreturn.setMarca(rs.getString(25));
                    
                }
                
                ArrayList<OrdenesVuelosItinerarios> itinerarios = new ArrayList();
                ovreturn.setOrdenesVuelosItinerarios(daoItinerarios.OrdenesVuelosItinerarios(itinerarios, primaryKeyEncabezado, respuesta));
                
                ArrayList<OrdenesVuelosTripulaciones> tripulaciones = new ArrayList();
                ovreturn.setOrdenesVuelosTripulaciones(daoTripulaciones.OrdenesVuelosTripulaciones(tripulaciones, primaryKeyEncabezado, respuesta));
                
            } catch (SQLException ex) {
                Logger.getLogger(OrdenesVuelosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(OrdenesVuelosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }
        
        return ovreturn;
        
    }
    
}
