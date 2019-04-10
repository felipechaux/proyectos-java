/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.ordenVuelo.OrdenesVuelosCargas;
import co.sinte.entities.ordenVuelo.OrdenesVuelosItinerarios;
import co.sinte.entities.ordenVuelo.OrdenesVuelosPasajeros;
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
public class OrdenesVuelosItinerariosDAO {

    private String SELECT_OVI = "SELECT * FROM vw_mlt_ov_itinerarios  "
            + " where id_orden_vuelo=?";

    OrdenesVuelosItinerarios ovireturn = null;
    OrdenesVuelosCargasDAO daoCargas = new OrdenesVuelosCargasDAO();
    OrdenesVuelosPasajerosDAO daoPasajeros = new OrdenesVuelosPasajerosDAO();

    public ArrayList OrdenesVuelosItinerarios(ArrayList itinerarios, Long primaryKeyEncabezado, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_OVI);
                ps.setLong(1, primaryKeyEncabezado);
                rs = ps.executeQuery();

                while (rs.next()) {
                    ovireturn = new OrdenesVuelosItinerarios();

                    ovireturn.setIdOvItinerario(rs.getLong(1));
                    ovireturn.setIdOrdenVuelo(rs.getLong(2));
                    ovireturn.setNumeroBoletin(rs.getString(3));
                    ovireturn.setNumeroVuelo(rs.getLong(4));
                    ovireturn.setIdOrigen(rs.getLong(5));
                    ovireturn.setOaciOrigen(rs.getString(6));
                    ovireturn.setOrigenVuelo(rs.getString(7));
                    ovireturn.setIdDestino(rs.getLong(8));
                    ovireturn.setOaciDestino(rs.getString(9));
                    ovireturn.setDestinoVuelo(rs.getString(10));
                    ovireturn.setMision(rs.getString(11));
                    ovireturn.setNombreMision(rs.getString(12));
                    ovireturn.setPax(rs.getLong(13));
                    ovireturn.setCarga(rs.getLong(14));
                    ovireturn.setCombustibleOrigen(rs.getLong(15));
                    ovireturn.setCombustibleDestino(rs.getLong(16));
                    ovireturn.setRequerimientos(rs.getString(17));
                    ovireturn.setIdCondicionVueloAutorizada(rs.getLong(18));
                    ovireturn.setCondicionVuelo(rs.getString(19));
                    ovireturn.setVelocidad(rs.getLong(20));
                    ovireturn.setAltitud(rs.getLong(21));
                    ovireturn.setTiempoEstimado(rs.getString(22));
                    ovireturn.setIdAlterno(rs.getLong(23));
                    ovireturn.setLugarAlternoVuelo(rs.getString(24));
                    ovireturn.setEteAlterno(rs.getString(25));
                    ovireturn.setUsuarioCreador(rs.getString(26));
                    ovireturn.setFechaCreacion(rs.getDate(27));
                    ovireturn.setUsuarioModificador(rs.getString(28));
                    ovireturn.setFechaModificacion(rs.getDate(29));
                    ovireturn.setPncVersion(rs.getLong(30));
                    ovireturn.setEstado(rs.getString(31));

                    ArrayList<OrdenesVuelosCargas> cargas = new ArrayList();
                    ovireturn.setOrdenesVuelosCargas(daoCargas.OrdenesVuelosCargas(cargas, rs.getLong(1), respuesta));

                    ArrayList<OrdenesVuelosPasajeros> pasajeros = new ArrayList();
                    ovireturn.setOrdenesVuelosPasajeros(daoPasajeros.OrdenesVuelosPasajeros(pasajeros, rs.getLong(1), respuesta));

                    itinerarios.add(ovireturn);
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
                    if (rs != null) {
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
        return itinerarios;
    }
}
