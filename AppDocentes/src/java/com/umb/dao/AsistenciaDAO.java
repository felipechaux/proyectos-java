/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.Asistencia;
import com.umb.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class AsistenciaDAO {
    
    
    private String SELECT_A=" SELECT p.nombre_persona,m.nombre_materia,l.nombre_laboratorio,d.bloque_ini,d.bloque_fin,c.hora_entrada,c.hora_salida,c.observacion,pe1.nombre_persona,pe2.nombre_persona,r.tipo_reserva,g.nombre_grupo,d.fecha FROM control_prestamo c JOIN reservas r ON c.id_reserva=r.id_reserva JOIN personas p ON r.id_persona=p.id_persona JOIN materias m ON r.id_materia=m.id_materia JOIN disponibilidad_laboratorio d ON r.id_disponibilidad=d.id_disponibilidad JOIN laboratorios l ON d.id_laboratorio=l.id_laboratorio JOIN personas pe1 ON c.id_persona_encargada_e=pe1.id_persona JOIN personas pe2 ON c.id_persona_encargada_s=pe2.id_persona LEFT JOIN grupo_materia g ON r.id_grupo_materia=g.id_grupo_materia ";
    
    ArrayList<Asistencia> asistenciaArr;
    
    Asistencia areturn;
    
    
    
     public ArrayList reporteAsistencia() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                asistenciaArr = new ArrayList<>();

                ps = con.prepareStatement(SELECT_A);

                rs = ps.executeQuery();

                while (rs.next()) {
                    areturn = new Asistencia();
                    areturn.setNombrePersona(rs.getString(1));
                    areturn.setMateria(rs.getString(2));
                    areturn.setLaboratorio(rs.getString(3));
                    areturn.setBloque(rs.getString(4)+" - "+rs.getString(5));
                    areturn.setHoraEntrada(rs.getString(6));
                    areturn.setHoraSalida(rs.getString(7));
                    areturn.setObservacion(rs.getString(8));
                    areturn.setPersonaEncargadaEntrada(rs.getString(9));
                    areturn.setPersonaEncargadaSalida(rs.getString(10));
                    areturn.setTipoReserva(rs.getString(11));
                    areturn.setGrupoMateria(rs.getString(12));
                    areturn.setFecha(rs.getString(13));
                  
                    asistenciaArr.add(areturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return asistenciaArr;

    }
}
