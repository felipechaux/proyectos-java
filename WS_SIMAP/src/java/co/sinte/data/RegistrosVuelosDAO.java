/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.RegistroVuelo.RegistrosVuelos;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosItinerarios;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosServicios;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosTripulaciones;
import co.sinte.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DESARROLLO
 */
public class RegistrosVuelosDAO {

    Long primaryKeyEncabezado;
    private String INSERT_RV = "Insert into mlt_op_registros_vuelos"
            + "(id_registro_vuelo"
            + ",fecha"
            + ",id_orden_vuelo"
            + ",id_aeronave"
            + ",id_organizacion"
            + ",id_estacion"
            + ",usuario_creador"
            + ",fecha_creacion"
            + ",usuario_modificador"
            + ",fecha_modificacion"
            + ",pnc_version) values"
            + "(mlt_op_registros_vuelos_seq.nextval"
            + ",?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static Logger LOG_SIMAP = Logger.getLogger(RegistrosVuelosDAO.class.getName());

    private static final String validaMlt = "{CALL pkg_maletin_validaciones.pr_main(?,?,?,?)}";

    public void insertRegistrosVuelos(RegistrosVuelos reg, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        Connection con = ConnectionDB.getJNDIConnection();
        LOG_SIMAP.setLevel(Level.INFO);
        LOG_SIMAP.info("**********Empezando LOG InsertRV************");

        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_RV, new String[]{"id_registro_vuelo"});

                if (reg.getFecha() != null) {
                    ps.setDate(1, new java.sql.Date(reg.getFecha().getTime()));
                } else {
                    ps.setNull(1, Types.DATE);
                }
                if (reg.getIdOrdenVuelo() != null) {
                    ps.setLong(2, reg.getIdOrdenVuelo());
                } else {
                    ps.setNull(2, Types.LONGVARCHAR);
                }
                if (reg.getIdAeronave() != null) {
                    ps.setLong(3, reg.getIdAeronave());
                } else {
                    ps.setNull(3, Types.LONGVARCHAR);
                }
                if (reg.getIdOrganizacion() != null) {
                    ps.setLong(4, reg.getIdOrganizacion());
                } else {
                    ps.setNull(4, Types.LONGVARCHAR);
                }
                if (reg.getIdEstacion() != null) {
                    ps.setLong(5, reg.getIdEstacion());
                } else {
                    ps.setNull(5, Types.LONGVARCHAR);
                }
                if (reg.getUsuarioCreador() != null) {
                    ps.setString(6, reg.getUsuarioCreador());
                } else {
                    ps.setNull(6, Types.VARCHAR);
                }
                if (reg.getFechaCreacion() != null) {
                    ps.setDate(7, new java.sql.Date(reg.getFechaCreacion().getTime()));
                } else {
                    ps.setNull(7, Types.DATE);
                }
                if (reg.getUsuarioModificador() != null) {
                    ps.setString(8, reg.getUsuarioModificador());
                } else {
                    ps.setNull(8, Types.VARCHAR);
                }
                if (reg.getFechaModificacion() != null) {
                    ps.setDate(9, new java.sql.Date(reg.getFechaModificacion().getTime()));
                } else {
                    ps.setNull(9, Types.DATE);
                }
                if (reg.getPncVersion() != null) {
                    ps.setLong(10, reg.getPncVersion());
                } else {
                    ps.setNull(10, Types.VARCHAR);
                }

                ps.executeQuery();
                primaryKeyEncabezado = 0l;

                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (null != generatedKeys && generatedKeys.next()) {
                    primaryKeyEncabezado = generatedKeys.getLong(1);
                }
                respuesta.setCodigoError(0);
                respuesta.setMensaje("Insersion exitosa - en registro vuelo");

            } catch (SQLException ex) {
                Logger.getLogger(RegistrosVuelosDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta.setCodigoError(2);
                respuesta.setMensaje(ex.getMessage());

            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RegistrosVuelosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        if (respuesta.getCodigoError() != 2) {

            if (reg.getRegistrosVuelosItinerarios() != null && reg.getRegistrosVuelosItinerarios().size() > 0) {
                RegistrosVuelosItinerariosDAO daoItinerarios = new RegistrosVuelosItinerariosDAO();
                for (int i = 0; i < reg.getRegistrosVuelosItinerarios().size(); i++) {
                    RegistrosVuelosItinerarios itinerarios = (RegistrosVuelosItinerarios) reg.getRegistrosVuelosItinerarios().get(i);
                    daoItinerarios.insertRegistrosVuelosItinerarios(itinerarios, respuesta, primaryKeyEncabezado);
                }
            }

            if (reg.getRegistrosVuelosServicios() != null && reg.getRegistrosVuelosServicios().size() > 0) {
                RegistrosVuelosServiciosDAO daoServicios = new RegistrosVuelosServiciosDAO();
                for (int i = 0; i < reg.getRegistrosVuelosServicios().size(); i++) {
                    RegistrosVuelosServicios servicios = (RegistrosVuelosServicios) reg.getRegistrosVuelosServicios().get(i);
                    daoServicios.insertRegistrosVuelosServicios(servicios, respuesta, primaryKeyEncabezado);
                }
            }
            if (reg.getRegistrosVuelosTripulaciones() != null && reg.getRegistrosVuelosTripulaciones().size() > 0) {
                RegistrosVuelosTripulacionesDAO daoTripulaciones = new RegistrosVuelosTripulacionesDAO();
                for (int i = 0; i < reg.getRegistrosVuelosTripulaciones().size(); i++) {
                    RegistrosVuelosTripulaciones tripulaciones = (RegistrosVuelosTripulaciones) reg.getRegistrosVuelosTripulaciones().get(i);
                    daoTripulaciones.insertRegistrosVuelosTripulaciones(tripulaciones, respuesta, primaryKeyEncabezado);
                }
            }

            invocarProcedimiento(reg, respuesta);

        }

    }

    private void invocarProcedimiento(RegistrosVuelos reg, MensajeRespuesta respuesta) {
        Connection con = ConnectionDB.getJNDIConnection();
        CallableStatement cs = null;
        if (reg.getIdOrdenVuelo() != null) {
            if (con != null) {
                try {
                    cs = con.prepareCall(validaMlt);

                    cs.setLong(1, reg.getIdOrdenVuelo());

                    cs.registerOutParameter(2, Types.VARCHAR);
                    cs.registerOutParameter(3, Types.NUMERIC);
                    cs.registerOutParameter(4, Types.VARCHAR);
                    // Ejecutar la sentencia
                    cs.execute();
                    // Verificar el resultado de la operacion
                    String consecutivo = cs.getString(2);
                    int I_ERRCOD = cs.getInt(3);
                    String I_ERRBUF = cs.getString(4);

                    respuesta.setNumRegistroVuelos(consecutivo);
                    respuesta.setCodigoError(I_ERRCOD);
                    respuesta.setMensaje(I_ERRBUF);

                } catch (SQLException ex) {
                    Logger.getLogger(RegistrosVuelosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    respuesta.setCodigoError(2);
                    respuesta.setMensaje(ex.getMessage());
                } finally {
                    // Cerrar todas las conexiones. Limpiar los recursos
                    try {
                        if (cs != null) {
                            cs.close();
                        }
                        if (con != null) {
                            con.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrosVuelosDAO.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            respuesta.setCodigoError(2);
            respuesta.setMensaje("El Id de la Orden de vuelo es un campo requerido");

        }

    }

}
