/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.umb;

import co.entities.EntidadRespuesta;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Administrador
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of co.umb.GenericResource
     *
     * @param user
     * @param pass
     * @return an instance of java.lang.String
     */
    @Path("login")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public EntidadRespuesta getJson(@QueryParam("user") String user, @QueryParam("pass") String pass) {

        EntidadRespuesta ent = new EntidadRespuesta();

        if ((user != null) && (pass != null)) {

            if ((user.equals("umb")) && (pass.equals("umb"))) {

                ent.setMessage("Acceso otorgado");
                ent.setRespuesta(true);
            } else {
                ent.setMessage("Acceso Denegado");
                ent.setRespuesta(false);
            }
        }

        return ent;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
