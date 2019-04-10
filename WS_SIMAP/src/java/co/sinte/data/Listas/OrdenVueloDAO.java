/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.OrdenVuelo;
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
public class OrdenVueloDAO {
    
    public String SELECT_OV = "SELECT o.id_orden_vuelo,a.matricula,e.modelo,e.marca,o.id_orden_vuelo dsp_orden"
            + " FROM PNC_OP_ORDENES_VUELOS o,PNC_ADM_AERONAVES a,PNC_ADM_EQUIPOS e"
            + " WHERE o.id_aeronave=a.id_aeronave"
            + " AND a.id_equipo=e.id_equipo"
            + " AND a.activo='S'";
    
    OrdenVuelo ordenvuelo = null;
    
    public ArrayList OrdenVuelo(ArrayList ov,MensajeRespuesta respuesta) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();
        
        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_OV);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ordenvuelo = new OrdenVuelo();
                    ordenvuelo.setIdOrdenVuelo(rs.getLong(1));
                    ordenvuelo.setMatricula(rs.getString(2));
                    ordenvuelo.setModelo(rs.getString(3));
                    ordenvuelo.setMarca(rs.getString(4));
                    ordenvuelo.setDspOrden(rs.getLong(5));
                    ov.add(ordenvuelo);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrdenVueloDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(OrdenVueloDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }
        
        return ov;
    }
    
}
