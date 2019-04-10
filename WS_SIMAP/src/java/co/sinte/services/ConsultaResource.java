/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.services;

import co.sinte.data.BibliotecaDigitalDAO;
import co.sinte.data.Listas.ListasDAO;
import co.sinte.data.OrdenesVuelosDAO;
import co.sinte.entities.BibliotecaDigital;
import co.sinte.entities.Listas.Listas;
import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.ordenVuelo.OrdenesVuelos;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DESARROLLO
 */
@Path("consulta")
public class ConsultaResource {

    private final static Logger LOG_SIMAP = Logger.getLogger(ConsultaResource.class.getName());

    /**
     * Creates a new instance of ConsultaResource
     */
    public ConsultaResource() {
        LOG_SIMAP.setLevel(Level.INFO);
    }

    /**
     * Retrieves representation of an instance of
     * co.sinte.services.ConsultaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrdenesVuelos getJson(@QueryParam("orden") Long orden) {
        //TODO return proper representation object
        LOG_SIMAP.info("**********Empezando LOG ConsultaResource GET OrdenVuelo************");

        LOG_SIMAP.info("***** SEGUIMIENTO 7: Antes de cargar OrdenVuelo");
        OrdenesVuelos ordenVuelo = new OrdenesVuelos();
        MensajeRespuesta respuesta = new MensajeRespuesta();
        respuesta.setMensaje("sin error");
        OrdenesVuelosDAO ovDAO = new OrdenesVuelosDAO();
        ordenVuelo = ovDAO.OrdenesVuelos(orden, respuesta);
        LOG_SIMAP.info("***** SEGUIMIENTO 8: Cargar OrdenVuelo");
        return ordenVuelo;
    }
    
    @Path("/listas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Listas getJsonListas() {
        //TODO return proper representation object
        LOG_SIMAP.info("**********Empezando LOG ConsultaResource GET Listas************");

        LOG_SIMAP.info("***** SEGUIMIENTO 9: Antes de cargar Listas");
        Listas listas = new Listas();
        MensajeRespuesta respuesta = new MensajeRespuesta();
        respuesta.setMensaje("sin error");
        ListasDAO lDAO = new ListasDAO();
        listas = lDAO.Listas(respuesta);
        LOG_SIMAP.info("***** SEGUIMIENTO 10: Cargar Listas");
        return listas;
    }

    @Path("/biblioteca")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<BibliotecaDigital> getJsonBibliotecaDigital(@QueryParam("id") Long id) throws UnsupportedEncodingException {
        //TODO return proper representation object
        // BibliotecaDigital bd = new BibliotecaDigital();
        LOG_SIMAP.info("**********Empezando LOG ConsultaResource GET BibliotecaDigital************");

        LOG_SIMAP.info("***** SEGUIMIENTO 11: Antes de cargar Biblioteca");

        ArrayList< BibliotecaDigital> biblioteca = new ArrayList();
        MensajeRespuesta respuesta = new MensajeRespuesta();
        LOG_SIMAP.info("***** SEGUIMIENTO 12: Cargar Biblioteca");
        if (id != null) {
            LOG_SIMAP.info("***** SEGUIMIENTO 13: Antes de mostrar toda la Biblioteca");

            respuesta.setMensaje("sin error");
            BibliotecaDigitalDAO bdDAO = new BibliotecaDigitalDAO();
            biblioteca = bdDAO.Biblioteca(id, respuesta);
            LOG_SIMAP.info("***** SEGUIMIENTO 14: Mostrar toda la Biblioteca");

        } else {
            LOG_SIMAP.info("***** SEGUIMIENTO 15: Antes de mostrar un archivo de la Biblioteca");
            respuesta.setMensaje("sin error");
            BibliotecaDigitalDAO bdDAO = new BibliotecaDigitalDAO();
            biblioteca = bdDAO.Biblioteca(null, respuesta);
            LOG_SIMAP.info("***** SEGUIMIENTO 16: Mostrar un archivo de la Biblioteca");
        }

        return biblioteca;
    }

}
