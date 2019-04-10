/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.entities.Listas.Especialista;
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
public class EspecialistaDAO {

    public String SELECT_E = " SELECT e.pid_especialista,e.celular,p.nombre,e.id_persona,t.id_punto_tanqueo "
            + " FROM PNC_CO_PTO_ESPECIALISTAS e,PNC_CO_PTO_TANQUEO t,PNC_ADM_PERSONAS p "
            + " WHERE e.id_punto=t.id_punto_tanqueo "
            + " AND e.id_persona=p.id_persona "
            + " AND e.activo='S' ";

    Especialista ereturn =null;

    public ArrayList Especialista(ArrayList especialista, MensajeRespuesta respuesta) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                ps = con.prepareStatement(SELECT_E);
                rs = ps.executeQuery();
                while (rs.next()) {
                    
                    ereturn = new Especialista();

                    ereturn.setPidEspecialista(rs.getString(1));
                    ereturn.setCelular(rs.getLong(2));
                    ereturn.setNombre(rs.getString(3));
                    ereturn.setIdpersona(rs.getLong(4));
                    ereturn.setIdPuntoTanqueo(rs.getLong(5));
                    especialista.add(ereturn);

                }


            } catch (SQLException ex) {
                Logger.getLogger(EspecialistaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(EspecialistaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return especialista;

    }
}
