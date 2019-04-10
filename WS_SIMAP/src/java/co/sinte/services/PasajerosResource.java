/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.services;

import co.sinte.data.OrdenesVuelosPasajerosDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DESARROLLO
 */
@Path("pasajero")
public class PasajerosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PasajerosResource
     */
    public PasajerosResource() {
    }

    /**
     * Retrieves representation of an instance of
     * co.sinte.services.PasajerosResource
     *
     * @return an instance of java.lang.String
     */
    @Path("param")
    @GET
    public boolean Update(@QueryParam("id") Long idOVPasajeros, @QueryParam("abb") String abordo) {
        //TODO return proper representation object

        
        boolean respuesta=false;
        
        OrdenesVuelosPasajerosDAO ovpd = new OrdenesVuelosPasajerosDAO();
        if (idOVPasajeros != null && abordo != null) {

            if (abordo.equals("1")) {

                System.out.println("actualizacion S");

                respuesta=ovpd.PasajerosUpdate(idOVPasajeros, "S");

                System.out.println("actualizacion S termino***");

            } else if (abordo.equals("0")) {

                System.out.println("actualizacion N");

                respuesta=ovpd.PasajerosUpdate(idOVPasajeros, "N");

                System.out.println("actualizacion N termino***");

            }

            //System.out.println("parametros ///// id ->" + idOVPasajeros + " abb-->" + abordo);
        }

        return respuesta;
    }
}
