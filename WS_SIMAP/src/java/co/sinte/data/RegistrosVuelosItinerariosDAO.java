/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosItinerarios;
import co.sinte.util.ConnectionDB;
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
public class RegistrosVuelosItinerariosDAO {

    private String INSERT_RVI = "insert into mlt_op_rv_itinerarios "
            + "  (id_rv_itinerario"
            + ", id_rv_registro_vuelo"
            + ", numero_vuelo"
            + ", id_origen"
            + ", id_destino"
            + ", hora_inicio"
            + ", hora_despegue"
            + ", hora_arribo"
            + ", hora_final"
            + ", log_std"
            + ", auto"
            + ", start1"
            + ", start2"
            + ", id_mision_std"
            + ", mis_config"
            + ", entity"
            + ", load_int"
            + ", load_ext"
            + ", load_unit"
            + ", pax"
            + ", cyc"
            + ", hsf"
            + ", engine1"
            + ", engine2"
            + ", apu_starts"
            + ", ap_hr"
            + ", hr_meter_hrs"
            + ", total_aeronave"
            + ", total_tripulacion"
            + ", usuario_creador"
            + ", fecha_creacion"
            + ", usuario_modificador"
            + ", fecha_modificacion"
            + ", pnc_version) values "
            + "  (mlt_op_rv_itinerarios_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
            + ", ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void insertRegistrosVuelosItinerarios(RegistrosVuelosItinerarios reg, MensajeRespuesta respuesta, Long primaryKeyEncabezado) {

        PreparedStatement ps = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_RVI);
                ps.setLong(1, primaryKeyEncabezado);

                if (reg.getNumeroVuelo() != null) {
                    ps.setLong(2, reg.getNumeroVuelo());
                } else {
                    ps.setNull(2, Types.LONGVARCHAR);
                }
                if (reg.getIdOrigen() != null) {
                    ps.setLong(3, reg.getIdOrigen());
                } else {
                    ps.setNull(3, Types.LONGVARCHAR);
                }
                if (reg.getIdDestino() != null) {
                    ps.setLong(4, reg.getIdDestino());
                } else {
                    ps.setNull(4, Types.LONGVARCHAR);
                }
                if (reg.getHoraInicio() != null) {
                    ps.setDate(5, new java.sql.Date(reg.getHoraInicio().getTime()));
                } else {
                    ps.setNull(5, Types.DATE);
                }
                if (reg.getHoraDespegue() != null) {
                    ps.setDate(6, new java.sql.Date(reg.getHoraDespegue().getTime()));
                } else {
                    ps.setNull(6, Types.DATE);
                }
                if (reg.getHoraArribo() != null) {
                    ps.setDate(7, new java.sql.Date(reg.getHoraArribo().getTime()));
                } else {
                    ps.setNull(7, Types.DATE);
                }
                if (reg.getHoraFinal() != null) {
                    ps.setDate(8, new java.sql.Date(reg.getHoraFinal().getTime()));
                } else {
                    ps.setNull(8, Types.DATE);
                }
                if (reg.getLogStd() != null) {
                    ps.setLong(9, reg.getLogStd());
                } else {
                    ps.setNull(9, Types.LONGVARCHAR);
                }
                if (reg.getAuto() != null) {
                    ps.setLong(10, reg.getAuto());
                } else {
                    ps.setNull(10, Types.LONGVARCHAR);
                }
                if (reg.getStart1() != null) {
                    ps.setLong(11, reg.getStart1());
                } else {
                    ps.setNull(11, Types.LONGVARCHAR);
                }
                if (reg.getStart2() != null) {
                    ps.setLong(12, reg.getStart2());
                } else {
                    ps.setNull(12, Types.LONGVARCHAR);
                }
                if (reg.getIdMisionStd() != null) {
                    ps.setString(13, reg.getIdMisionStd());
                } else {
                    ps.setNull(13, Types.VARCHAR);
                }
                if (reg.getMisConfig() != null) {
                    ps.setString(14, reg.getMisConfig());
                } else {
                    ps.setNull(14, Types.VARCHAR);
                }
                if (reg.getEntity() != null) {
                    ps.setString(15, reg.getEntity());
                } else {
                    ps.setNull(15, Types.VARCHAR);
                }
                if (reg.getLoadInt() != null) {
                    ps.setLong(16, reg.getLoadInt());
                } else {
                    ps.setNull(16, Types.LONGVARCHAR);
                }
                if (reg.getLoadExt() != null) {
                    ps.setLong(17, reg.getLoadExt());
                } else {
                    ps.setNull(17, Types.LONGVARCHAR);
                }
                if (reg.getLoadUnit() != null) {
                    ps.setString(18, reg.getLoadUnit());
                } else {
                    ps.setNull(18, Types.VARCHAR);
                }
                if (reg.getPax() != null) {
                    ps.setLong(19, reg.getPax());
                } else {
                    ps.setNull(19, Types.LONGVARCHAR);
                }
                if (reg.getCyc() != null) {
                    ps.setLong(20, reg.getCyc());
                } else {
                    ps.setNull(20, Types.LONGVARCHAR);
                }
                if (reg.getHsf() != null) {
                    ps.setLong(21, reg.getHsf());
                } else {
                    ps.setNull(21, Types.LONGVARCHAR);
                }
                if (reg.getEngine1() != null) {
                    ps.setLong(22, reg.getEngine1());
                } else {
                    ps.setNull(22, Types.LONGVARCHAR);
                }
                if (reg.getEngine2() != null) {
                    ps.setLong(23, reg.getEngine2());
                } else {
                    ps.setNull(23, Types.LONGVARCHAR);
                }
                if (reg.getApuStarts() != null) {
                    ps.setLong(24, reg.getApuStarts());
                } else {
                    ps.setNull(24, Types.LONGVARCHAR);
                }
                if (reg.getApHr() != null) {
                    ps.setLong(25, reg.getApHr());
                } else {
                    ps.setNull(25, Types.LONGVARCHAR);
                }
                if (reg.getHrMeterHrs() != null) {
                    ps.setString(26, reg.getHrMeterHrs());
                } else {
                    ps.setNull(26, Types.VARCHAR);
                }
                if (reg.getTotalAeronave() != null) {
                    ps.setLong(27, reg.getTotalAeronave());
                } else {
                    ps.setNull(27, Types.LONGVARCHAR);
                }
                if (reg.getTotalTripulacion() != null) {
                    ps.setLong(28, reg.getTotalTripulacion());
                } else {
                    ps.setNull(28, Types.LONGVARCHAR);
                }
                if (reg.getUsuarioCreador() != null) {
                    ps.setString(29, reg.getUsuarioCreador());
                } else {
                    ps.setNull(29, Types.VARCHAR);
                }
                if (reg.getFechaCreacion() != null) {
                    ps.setDate(30, new java.sql.Date(reg.getFechaCreacion().getTime()));
                } else {
                    ps.setNull(30, Types.DATE);
                }
                if (reg.getUsuarioModificador() != null) {
                    ps.setString(31, reg.getUsuarioModificador());
                } else {
                    ps.setNull(31, Types.VARCHAR);
                }
                if (reg.getFechaModificacion() != null) {
                    ps.setDate(32, new java.sql.Date(reg.getFechaModificacion().getTime()));
                } else {
                    ps.setNull(32, Types.DATE);
                }
                if (reg.getPncVersion() != null) {
                    ps.setLong(33, reg.getPncVersion());
                } else {
                    ps.setNull(33, Types.LONGVARCHAR);
                }

                ps.executeQuery();
                respuesta.setCodigoError(0);
                respuesta.setMensaje("Insersion exitosa - en Registro vuelo itinerario");
            } catch (SQLException ex) {
                Logger.getLogger(RegistrosVuelosItinerariosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RegistrosVuelosItinerariosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
    }

}
