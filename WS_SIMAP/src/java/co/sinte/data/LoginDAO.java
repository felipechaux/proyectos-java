/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DESARROLLO
 */
public class LoginDAO {

    private static final String pck_login = "{ ? = call user_exist(?,?)}";

    public void packageLogin(String user, String pass, MensajeRespuesta respuesta) {

        Connection con = ConnectionDB.getJNDIConnection();
        CallableStatement cs = null;
        if (con != null) {
            try {
                cs = con.prepareCall(pck_login);

                cs.registerOutParameter(1, Types.INTEGER);

                cs.setString(2, user);
                cs.setString(3, pass);

                // Ejecutar la sentencia
                cs.execute();
                // Verificar el resultado de la operacion
                //respuesta.setAutenticacion(cs.getBoolean(1));
                if (cs.getInt(1) == 1) {
                    respuesta.setAutenticacion(Boolean.TRUE);
                    respuesta.setMensaje("Confirmacion de la autenticacion");                    
                } else {
                    respuesta.setAutenticacion(Boolean.FALSE);
                    respuesta.setMensaje("Usuario invalido");                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }

        }
    }

}
