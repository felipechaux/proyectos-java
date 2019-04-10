/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.BibliotecaDigital;
import co.sinte.entities.MensajeRespuesta;
import co.sinte.util.ConnectionDB;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DESARROLLO
 */
public class BibliotecaDigitalDAO {

    //select d.documento_id,d.archivo,d.mime from pnc_adm_documentos d
    private String SELECT_BD = "SELECT bd.documento_id,bd.nombre,bd.descripcion,bd.fecha_creacion,bd.fecha_modificacion FROM pnc_adm_documentos bd"
            + "                 WHERE (bd.mime='pdf' OR bd.mime='txt') AND bd.tabla='PNC_OP_BIBLIOTECAS_DIGITALES' ";

    private String SELECT_BLOB = "Select bd.documento_id,bd.mime,bd.archivo from pnc_adm_documentos bd "
            + "where  bd.documento_id= ? ";

    private ArrayList< BibliotecaDigital> biblioteca = new ArrayList();

    BibliotecaDigital bd = new BibliotecaDigital();

    public ArrayList Biblioteca(Long id, MensajeRespuesta respuesta) throws UnsupportedEncodingException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConnectionDB.getJNDIConnection();

        if (con != null) {
            try {
                if (id != null) {
                    ps = con.prepareStatement(SELECT_BLOB);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {

                        bd.setIdBibliotecaDigital(rs.getLong(1));
                        bd.setIdTipoDocumento(rs.getString(2));
                        Blob blob = rs.getBlob(3);
                        byte[] data = blob.getBytes(1, (int) blob.length());
                        bd.setDocumento(cifrarBase64Byte(data));
                        biblioteca.add(bd);
                    }

                } else {
                    ps = con.prepareStatement(SELECT_BD);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        bd = new BibliotecaDigital();
                        bd.setIdBibliotecaDigital(rs.getLong(1));
                        bd.setArchivo(rs.getString(2));
                        bd.setDescripcion(rs.getString(3));
                        bd.setFechaCreacion(rs.getDate(4));
                        bd.setFechaMoficacion(rs.getDate(5));

                        biblioteca.add(bd);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(BibliotecaDigitalDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(BibliotecaDigitalDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    respuesta.setMensaje(ex.getMessage());
                }
            }
        }

        return biblioteca;
    }

    public static String cifrarBase64Byte(byte[] src) {

        Base64.Encoder encoder = Base64.getEncoder();
        String texto64 = encoder.encodeToString(src);
        return texto64;
    }
}
