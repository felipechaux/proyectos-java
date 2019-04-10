/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosTripulaciones;
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
public class RegistrosVuelosTripulacionesDAO {

    private String INSERT_RVT = "insert into mlt_op_rv_tripulaciones\n"
            + "  (id_rv_tripulacion, "
            + "id_registro_vuelo, "
            + "id_persona, grado, "
            + "pid, "
            + "vmc_ds, "
            + "vmc_fs, "
            + "vmc_hr, "
            + "vmc_s, "
            + "ims_ds, "
            + "imc_fs, "
            + "imc_hr, "
            + "imc_s, "
            + "noc_ds, "
            + "noc_fs, "
            + "noc_hr, "
            + "noc_s, "
            + "nvg_ds, "
            + "nvg_fd, "
            + "nvg_hr, "
            + "nvg_s, " 
            + "usuario_creador, "
            + "fecha_creacion, "
            + "usuario_modificador, "
            + "fecha_modificacion, "
            + "pnc_version)\n"
            + "values\n"
            + "  (MLT_OP_RV_TRIPULACIONES_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public void insertRegistrosVuelosTripulaciones(RegistrosVuelosTripulaciones reg, MensajeRespuesta msj, Long primaryKeyEncabezado) {

        PreparedStatement ps = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_RVT);

                ps.setLong(1, primaryKeyEncabezado);

                if (reg.getIdPersona() != null) {
                    ps.setLong(2, reg.getIdPersona());
                } else {
                    ps.setNull(2, Types.LONGVARCHAR);
                }
                if (reg.getGrado() != null) {
                    ps.setString(3, reg.getGrado());
                } else {
                    ps.setNull(3, Types.VARCHAR);
                }
                if (reg.getPid() != null) {
                    ps.setString(4, reg.getPid());
                } else {
                    ps.setNull(4, Types.VARCHAR);
                }
                if (reg.getVmcDs() != null) {
                    ps.setLong(5, reg.getVmcDs());
                } else {
                    ps.setNull(5, Types.LONGVARCHAR);
                }
                if (reg.getVmcFs() != null) {
                    ps.setLong(6, reg.getVmcFs());
                } else {
                    ps.setNull(6, Types.LONGVARCHAR);
                }
                if (reg.getVmcHr() != null) {
                    ps.setLong(7, reg.getVmcHr());
                } else {
                    ps.setNull(7, Types.LONGVARCHAR);
                }
                if (reg.getVmcS() != null) {
                    ps.setLong(8, reg.getVmcS());
                } else {
                    ps.setNull(8, Types.LONGVARCHAR);
                }
                if (reg.getImsDs() != null) {
                    ps.setLong(9, reg.getImsDs());
                } else {
                    ps.setNull(9, Types.LONGVARCHAR);
                }
                if (reg.getImcFs() != null) {
                    ps.setLong(10, reg.getImcFs());
                } else {
                    ps.setNull(10, Types.LONGVARCHAR);
                }
                if (reg.getImcHr() != null) {
                    ps.setLong(11, reg.getImcHr());
                } else {
                    ps.setNull(11, Types.LONGVARCHAR);
                }
                if (reg.getImcS() != null) {
                    ps.setLong(12, reg.getImcS());
                } else {
                    ps.setNull(12, Types.LONGVARCHAR);
                }
                if (reg.getNocDs() != null) {
                    ps.setLong(13, reg.getNocDs());
                } else {
                    ps.setNull(13, Types.LONGVARCHAR);
                }
                if (reg.getNocFs() != null) {
                    ps.setLong(14, reg.getNocFs());
                } else {
                    ps.setNull(14, Types.LONGVARCHAR);
                }
                if (reg.getNocHr() != null) {
                    ps.setLong(15, reg.getNocHr());
                } else {
                    ps.setNull(15, Types.LONGVARCHAR);
                }
                if (reg.getNocS() != null) {
                    ps.setLong(16, reg.getNocS());
                } else {
                    ps.setNull(16, Types.LONGVARCHAR);
                }
                if (reg.getNvgDs() != null) {
                    ps.setLong(17, reg.getNvgDs());
                } else {
                    ps.setNull(17, Types.LONGVARCHAR);
                }
                if (reg.getNvgFd() != null) {
                    ps.setLong(18, reg.getNvgFd());
                } else {
                    ps.setNull(18, Types.LONGVARCHAR);
                }
                if (reg.getNvgHr() != null) {
                    ps.setLong(19, reg.getNvgHr());
                } else {
                    ps.setNull(19, Types.LONGVARCHAR);
                }
                if (reg.getNvgS() != null) {
                    ps.setLong(20, reg.getNvgS());
                } else {
                    ps.setNull(20, Types.LONGVARCHAR);
                }
                if (reg.getUsuarioCreador() != null) {
                    ps.setString(21, reg.getUsuarioCreador());
                } else {
                    ps.setNull(21, Types.VARCHAR);
                }
                if (reg.getFechaCreacion() != null) {
                    ps.setDate(22, new java.sql.Date(reg.getFechaCreacion().getTime()));
                } else {
                    ps.setNull(22, Types.DATE);
                }
                if (reg.getUsuarioModificador() != null) {
                    ps.setString(23, reg.getUsuarioModificador());
                } else {
                    ps.setNull(23, Types.VARCHAR);
                }
                if (reg.getFechaModificacion() != null) {
                    ps.setDate(24, new java.sql.Date(reg.getFechaModificacion().getTime()));
                } else {
                    ps.setNull(24, Types.DATE);
                }
                if (reg.getPncVersion() != null) {
                    ps.setLong(25, reg.getPncVersion());
                } else {
                    ps.setNull(25, Types.LONGVARCHAR);
                }

                ps.executeQuery();
                msj.setCodigoError(0);
                msj.setMensaje("Insersion exitosa - en Registros Vuelos Tripulaciones");

            } catch (SQLException ex) {
                Logger.getLogger(RegistrosVuelosTripulacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RegistrosVuelosTripulacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }

    }

}
