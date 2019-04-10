/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosServicios;
import co.sinte.util.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DESARROLLO
 */
public class RegistrosVuelosServiciosDAO {

    private String INSERT_RVS = "insert into mlt_op_rv_servicios\n"
            + "  (id_rv_servicio, "
            + "id_registro_vuelo, "
            + "id_fuerza, "
            + "id_punto_tanqueo, "
            + "id_lugar, "
            + "id_tipo, "
            + "id_unidad_tipo, "
            + "cantidad, "
            + "grade_tservicio, "
            + "en_tanques, "
            + "pid, "
            + "nombre_especialista, "
            + "celular, "
            + "orden_suministro, "
            + "usuario_creador, "
            + "fecha_creacion, "
            + "usuario_modificador, "
            + "fecha_modificacion, "
            + "pnc_version, "
            + "id_persona, "
            + "id_tipo_servicio)\n"
            + "values\n"
            + " (MLT_OP_RV_SERVICIOS_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public void insertRegistrosVuelosServicios(RegistrosVuelosServicios reg, MensajeRespuesta msj, Long primaryKeyEncabezado) {

        PreparedStatement ps = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_RVS);

                ps.setLong(1, primaryKeyEncabezado);

                if (reg.getIdFuerza() != null) {
                    ps.setLong(2, reg.getIdFuerza());
                } else {
                    ps.setNull(2, Types.LONGVARCHAR);
                }
                if (reg.getIdPuntoTanqueo() != null) {
                    ps.setLong(3, reg.getIdPuntoTanqueo());
                } else {
                    ps.setNull(3, Types.LONGVARCHAR);
                }
                if (reg.getIdLugar() != null) {
                    ps.setLong(4, reg.getIdLugar());
                } else {
                    ps.setNull(4, Types.LONGVARCHAR);
                }
                if (reg.getIdTipo() != null) {
                    ps.setLong(5, reg.getIdTipo());
                } else {
                    ps.setNull(5, Types.LONGVARCHAR);
                }
                if (reg.getIdUnidadTipo() != null) {
                    ps.setLong(6, reg.getIdUnidadTipo());
                } else {
                    ps.setNull(6, Types.LONGVARCHAR);
                }
                if (reg.getCantidad() != null) {
                    ps.setLong(7, reg.getCantidad());
                } else {
                    ps.setNull(7, Types.LONGVARCHAR);
                }
                if (reg.getGradeTservicio() != null) {
                    ps.setString(8, reg.getGradeTservicio());
                } else {
                    ps.setNull(8, Types.VARCHAR);
                }
                if (reg.getEnTanques() != null) {
                    ps.setLong(9, reg.getEnTanques());
                } else {
                    ps.setNull(9, Types.LONGVARCHAR);
                }
                if (reg.getPid() != null) {
                    ps.setString(10, reg.getPid());
                } else {
                    ps.setNull(10, Types.VARCHAR);
                }
                if (reg.getNombreEspecialista() != null) {
                    ps.setString(11, reg.getNombreEspecialista());
                } else {
                    ps.setNull(11, Types.VARCHAR);
                }
                if (reg.getCelular() != null) {
                    ps.setLong(12, reg.getCelular());
                } else {
                    ps.setNull(12, Types.LONGVARCHAR);
                }
                if (reg.getOrdenSuministro() != null) {
                    ps.setLong(13, reg.getOrdenSuministro());
                } else {
                    ps.setNull(13, Types.LONGVARCHAR);
                }
                if (reg.getUsuarioCreador() != null) {
                    ps.setString(14, reg.getUsuarioCreador());
                } else {
                    ps.setNull(14, Types.VARCHAR);
                }
                if (reg.getFechaCreacion() != null) {
                    ps.setDate(15, new java.sql.Date(reg.getFechaCreacion().getTime()));
                } else {
                    ps.setNull(15, Types.DATE);
                }
                if (reg.getUsuarioModificador() != null) {
                    ps.setString(16, reg.getUsuarioModificador());
                } else {
                    ps.setNull(16, Types.VARCHAR);
                }
                if (reg.getFechaModificacion() != null) {
                    ps.setDate(17, new java.sql.Date(reg.getFechaModificacion().getTime()));
                } else {
                    ps.setNull(17, Types.DATE);
                }
                if (reg.getPncVersion() != null) {
                    ps.setLong(18, reg.getPncVersion());
                } else {
                    ps.setNull(18, Types.LONGVARCHAR);
                }
                if (reg.getIdPersona() != null) {
                    ps.setLong(19, reg.getIdPersona());
                } else {
                    ps.setNull(19, Types.LONGVARCHAR);
                }
                if (reg.getIdTipoServicio() != null) {
                    ps.setLong(20, reg.getIdTipoServicio());
                } else {
                    ps.setNull(20, Types.LONGVARCHAR);
                }
                ps.executeQuery();
                msj.setCodigoError(0);
                msj.setMensaje("Insersion exitosa - en Registros Vuelos Servicios");

            } catch (SQLException ex) {
                Logger.getLogger(RegistrosVuelosServiciosDAO.class.getName()).log(Level.SEVERE, null, ex);
                msj.setCodigoError(2);
                msj.setMensaje(ex.getMessage());
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
                    Logger.getLogger(RegistrosVuelosServiciosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }

    }

}
