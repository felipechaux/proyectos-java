/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.services;

import co.sinte.data.LoginDAO;
import co.sinte.entities.MensajeRespuesta;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DESARROLLO
 */
@Path("login")
public class Login {

    @Context
    private UriInfo context;
    private final static Logger LOG_SIMAP = Logger.getLogger(Login.class.getName());

    /**
     * Creates a new instance of Login
     */
    public Login() {
        LOG_SIMAP.setLevel(Level.INFO);
    }

    /**
     * Retrieves representation of an instance of co.sinte.services.Login
     *
     * @return an instance of java.lang.String
     */
    @Path("respuesta")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeRespuesta getJson(@QueryParam("usuario") String usuario,
            @QueryParam("password") String password) {

        MensajeRespuesta respuesta = new MensajeRespuesta();
        //LoginDAO loginDAO = new LoginDAO();        

        LOG_SIMAP.info("**********Empezando LOG Login************");

        if (usuario != null && password != null) {
            if ((usuario.equals("sinte")) && (password.equals("sinte"))) {
                LOG_SIMAP.info("***** SEGUIMIENTO 1: Antes de la confirmacion de la autenticacion");
                respuesta.setAutenticacion(Boolean.TRUE);
                respuesta.setMensaje("Confirmacion de la autenticacion");
                LOG_SIMAP.info("***** SEGUIMIENTO 2: Confirmacion de la autenticacion");
            } else {
                LOG_SIMAP.info("***** SEGUIMIENTO 3: Antes de usuario invalido");
                respuesta.setAutenticacion(Boolean.FALSE);
                respuesta.setMensaje("Usuario Invalido");
                LOG_SIMAP.info("***** SEGUIMIENTO 4: Usuario invalido");
            }
            LOG_SIMAP.info("***** SEGUIMIENTO 1: Antes de la confirmacion de la autenticacion");
           // loginDAO.packageLogin(usuario, password, respuesta);   
            LOG_SIMAP.info("***** SEGUIMIENTO 2: Despues de la confirmacion de la autenticacion");
        } else {
            LOG_SIMAP.info("***** SEGUIMIENTO 5: Antes de campos requeridos");
            respuesta.setAutenticacion(Boolean.FALSE);
            respuesta.setMensaje("Campos Requeridos");
            LOG_SIMAP.info("***** SEGUIMIENTO 6: Campos requeridos");
        }
        return respuesta;
    }

    /**
     * PUT method for updating or creating an instance of Login
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
