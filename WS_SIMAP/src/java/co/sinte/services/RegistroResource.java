/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.services;

import co.sinte.data.RegistrosRiesgosDAO;
import co.sinte.data.RegistrosVuelosDAO;
import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.RegistroRiesgos;
import co.sinte.entities.RegistroVuelo.RegistrosVuelos;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosItinerarios;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosServicios;
import co.sinte.entities.RegistroVuelo.RegistrosVuelosTripulaciones;
import co.sinte.util.ConnectionDB;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DESARROLLO
 */
@Path("registro")
public class RegistroResource {

    @Context
    private UriInfo context;
    private final static Logger LOG_SIMAP = Logger.getLogger(RegistroResource.class.getName());

    /**
     * Creates a new instance of RegistroResource
     */
    public RegistroResource() {
        LOG_SIMAP.setLevel(Level.INFO);
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RegistrosVuelos getJson() {
        LOG_SIMAP.info("**********Empezando LOG RegistroResource GET RV************");
        LOG_SIMAP.info("***** SEGUIMIENTO 23: Antes de setear RV");
        RegistrosVuelos RV = new RegistrosVuelos();
        Date date = new Date();
        RV.setIdRegistroVuelo((long) 1);
        RV.setFecha(date);
        RV.setIdOrdenVuelo((long) 1);
        RV.setIdAeronave((long) 1);
        RV.setIdOrganizacion((long) 1);
        RV.setIdEstacion((long) 1);
        RV.setUsuarioCreador("usuarioCreador");
        RV.setFechaCreacion(date);
        RV.setUsuarioModificador("usuarioModificador");
        RV.setFechaModificacion(date);
        RV.setPncVersion((long) 0);

        ArrayList<RegistrosVuelosItinerarios> itinerarios = new ArrayList<RegistrosVuelosItinerarios>();
        RegistrosVuelosItinerarios itinerario1 = new RegistrosVuelosItinerarios();
        itinerario1.setIdRvItinerario((long) 1);
        itinerario1.setIdRvRegistroVuelo((long) 1);
        itinerario1.setNumeroVuelo((long) 1);
        itinerario1.setIdOrigen((long) 1);
        itinerario1.setHoraInicio(date);
        itinerario1.setHoraDespegue(date);
        itinerario1.setHoraArribo(date);
        itinerario1.setHoraFinal(date);
        itinerario1.setLogStd((long) 11);
        itinerario1.setAuto((long) 1);
        itinerario1.setStart1((long) 1);
        itinerario1.setStart2((long) 1);
        itinerario1.setIdMisionStd("idMisionStd");
        itinerario1.setMisConfig("misConfig");
        itinerario1.setEntity("entity");
        itinerario1.setLoadInt((long) 1);
        itinerario1.setLoadExt((long) 1);
        itinerario1.setLoadUnit("loadunit");
        itinerario1.setPax((long) 1);
        itinerario1.setCyc((long) 1);
        itinerario1.setHsf((long) 1);
        itinerario1.setEngine1((long) 1);
        itinerario1.setEngine2((long) 1);
        itinerario1.setApuStarts((long) 1);
        itinerario1.setApHr((long) 1);
        itinerario1.setHrMeterHrs("hrMeterHrs");
        itinerario1.setTotalAeronave((long) 1);
        itinerario1.setTotalTripulacion((long) 1);
        itinerario1.setUsuarioCreador("usuarioCreador");
        itinerario1.setFechaCreacion(date);
        itinerario1.setUsuarioModificador("usuarioModificador");
        itinerario1.setFechaModificacion(date);
        itinerario1.setPncVersion((long) 1);
        itinerario1.setIdDestino((long) 9);

        itinerarios.add(itinerario1);

        RegistrosVuelosItinerarios itinerario2 = new RegistrosVuelosItinerarios();
        itinerario2.setIdRvItinerario((long) 2);
        itinerario2.setIdRvRegistroVuelo((long) 2);
        itinerario2.setNumeroVuelo((long) 2);
        itinerario2.setIdOrigen((long) 2);
        itinerario2.setHoraInicio(date);
        itinerario2.setHoraDespegue(date);
        itinerario2.setHoraArribo(date);
        itinerario2.setHoraFinal(date);
        itinerario2.setLogStd((long) 112);
        itinerario2.setAuto((long) 12);
        itinerario2.setStart1((long) 12);
        itinerario2.setStart2((long) 12);
        itinerario2.setIdMisionStd("idMisionStd2");
        itinerario2.setMisConfig("misConfig2");
        itinerario2.setEntity("entity2");
        itinerario2.setLoadInt((long) 2);
        itinerario2.setLoadExt((long) 2);
        itinerario2.setLoadUnit("loadunit2");
        itinerario2.setPax((long) 2);
        itinerario2.setCyc((long) 2);
        itinerario2.setHsf((long) 2);
        itinerario2.setEngine1((long) 2);
        itinerario2.setEngine2((long) 2);
        itinerario2.setApuStarts((long) 2);
        itinerario2.setApHr((long) 2);
        itinerario2.setHrMeterHrs("hrMeterHrs2");
        itinerario2.setTotalAeronave((long) 2);
        itinerario2.setTotalTripulacion((long) 2);
        itinerario2.setUsuarioCreador("usuarioCreador2");
        itinerario2.setFechaCreacion(date);
        itinerario2.setUsuarioModificador("usuarioModificador2");
        itinerario2.setFechaModificacion(date);
        itinerario2.setPncVersion((long) 2);
        itinerario2.setIdDestino((long) 89);

        itinerarios.add(itinerario2);

        RV.setRegistrosVuelosItinerarios(itinerarios);

        ArrayList<RegistrosVuelosServicios> servicios = new ArrayList<RegistrosVuelosServicios>();
        RegistrosVuelosServicios servicio1 = new RegistrosVuelosServicios();
        servicio1.setIdRvServicio((long) 1);
        servicio1.setIdRegistroVuelo((long) 1);
        servicio1.setIdFuerza((long) 1);
        servicio1.setIdPuntoTanqueo((long) 1);
        servicio1.setIdLugar((long) 1);
        servicio1.setIdTipo((long) 1);
        servicio1.setIdUnidadTipo((long) 1);
        servicio1.setCantidad((long) 1);
        servicio1.setGradeTservicio("gradeTservicio");
        servicio1.setEnTanques((long) 1);
        servicio1.setPid("pid");
        servicio1.setNombreEspecialista("nombreEspe");
        servicio1.setCelular((long) 1);
        servicio1.setOrdenSuministro((long) 1);
        servicio1.setUsuarioCreador("usuarioCreador");
        servicio1.setFechaCreacion(date);
        servicio1.setUsuarioModificador("usuarioMod");
        servicio1.setFechaModificacion(date);
        servicio1.setPncVersion((long) 1);
        servicio1.setIdPersona((long) 1);
        servicio1.setIdTipoServicio((long) 1);
        servicios.add(servicio1);

        RegistrosVuelosServicios servicio2 = new RegistrosVuelosServicios();
        servicio2.setIdRvServicio((long) 2);
        servicio2.setIdRegistroVuelo((long) 2);
        servicio2.setIdFuerza((long) 2);
        servicio2.setIdPuntoTanqueo((long) 2);
        servicio2.setIdLugar((long) 2);
        servicio2.setIdTipo((long) 2);
        servicio2.setIdUnidadTipo((long) 2);
        servicio2.setCantidad((long) 2);
        servicio2.setGradeTservicio("gradeTservicio2");
        servicio2.setEnTanques((long) 2);
        servicio2.setPid("pid2");
        servicio2.setNombreEspecialista("nombreEspe2");
        servicio2.setCelular((long) 2);
        servicio2.setOrdenSuministro((long) 2);
        servicio2.setUsuarioCreador("usuarioCreador2");
        servicio2.setFechaCreacion(date);
        servicio2.setUsuarioModificador("usuarioMod2");
        servicio2.setFechaModificacion(date);
        servicio2.setPncVersion((long) 2);
        servicio2.setIdPersona((long) 2);
        servicio2.setIdTipoServicio((long) 2);
        servicios.add(servicio2);

        RV.setRegistrosVuelosServicios(servicios);

        ArrayList<RegistrosVuelosTripulaciones> RVtripulaciones = new ArrayList<>();
        RegistrosVuelosTripulaciones rvt1 = new RegistrosVuelosTripulaciones();
        rvt1.setFechaCreacion(date);
        rvt1.setFechaModificacion(date);
        rvt1.setGrado("CR");
        rvt1.setIdPersona((long) 1267);
        rvt1.setIdRegistroVuelo((long) 1);
        rvt1.setIdRvTripulacion((long) 767);
        rvt1.setImcFs((long) 45);
        rvt1.setImcHr((long) 685);
        rvt1.setImcS((long) 36);
        rvt1.setImsDs((long) 63);
        rvt1.setNocDs((long) 25);
        rvt1.setNocFs((long) 85);
        rvt1.setNocHr((long) 123);
        rvt1.setNocS((long) 47);
        rvt1.setNvgDs((long) 96);
        rvt1.setNvgFd((long) 74);
        rvt1.setNvgHr((long) 15);
        rvt1.setNvgS((long) 789);
        rvt1.setPid("pid");
        rvt1.setPncVersion((long) 1);
        rvt1.setUsuarioCreador("usuarioCreador");
        rvt1.setUsuarioModificador("usuarioModificador");
        rvt1.setVmcDs((long) 12);
        rvt1.setVmcFs((long) 67);
        rvt1.setVmcHr((long) 456);
        rvt1.setVmcS((long) 21);

        RVtripulaciones.add(rvt1);

        RegistrosVuelosTripulaciones rvt2 = new RegistrosVuelosTripulaciones();
        rvt2.setFechaCreacion(date);
        rvt2.setFechaModificacion(date);
        rvt2.setGrado("TL");
        rvt2.setIdPersona((long) 7);
        rvt2.setIdRegistroVuelo((long) 13);
        rvt2.setIdRvTripulacion((long) 7);
        rvt2.setImcFs((long) 4);
        rvt2.setImcHr((long) 685);
        rvt2.setImcS((long) 36);
        rvt2.setImsDs((long) 63);
        rvt2.setNocDs((long) 25);
        rvt2.setNocFs((long) 8);
        rvt2.setNocHr((long) 1893);
        rvt2.setNocS((long) 47);
        rvt2.setNvgDs((long) 6);
        rvt2.setNvgFd((long) 4);
        rvt2.setNvgHr((long) 5);
        rvt2.setNvgS((long) 78);
        rvt2.setPid("pid2");
        rvt2.setPncVersion((long) 658);
        rvt2.setUsuarioCreador("Creador");
        rvt2.setUsuarioModificador("Modificador");
        rvt2.setVmcDs((long) 2);
        rvt2.setVmcFs((long) 7);
        rvt2.setVmcHr((long) 6);
        rvt2.setVmcS((long) 1);

        RVtripulaciones.add(rvt2);

        RV.setRegistrosVuelosTripulaciones(RVtripulaciones);
        LOG_SIMAP.info("***** SEGUIMIENTO 24: Despues de setear RV");

        return RV;
        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeRespuesta putJson(RegistrosVuelos content) {
        LOG_SIMAP.info("**********Empezando LOG RegistroResource POST RegistroVuelo************");
        LOG_SIMAP.info("***** SEGUIMIENTO 17: Antes de llenar RegistroVuelo");
        RegistrosVuelosDAO dao = new RegistrosVuelosDAO();
        MensajeRespuesta respuesta = new MensajeRespuesta();
        respuesta.setCodigoError(0);
        LOG_SIMAP.info("***** SEGUIMIENTO 18: Antes de INSERT_DAO RegistroVuelo");
        dao.insertRegistrosVuelos(content, respuesta);
        LOG_SIMAP.info("***** SEGUIMIENTO 19: Despues de INSERT RegistroVuelo");
        return respuesta;
    }

    @Path("/riesgos")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeRespuesta putJson(RegistroRiesgos content) {
        LOG_SIMAP.info("**********Empezando LOG RegistroResource POST Riesgos************");
        LOG_SIMAP.info("***** SEGUIMIENTO 20: Antes de llenar Riesgos");
        RegistrosRiesgosDAO dao = new RegistrosRiesgosDAO();
        MensajeRespuesta respuesta = new MensajeRespuesta();
        respuesta.setCodigoError(0);
        LOG_SIMAP.info("***** SEGUIMIENTO 21: Antes de INSERT_DAO Riesgos");
        dao.insertRegistrosRiesgos(content, respuesta);
        LOG_SIMAP.info("***** SEGUIMIENTO 22: Despues de INSERT_DAO Riesgos");
        return respuesta;
    }
    
    @Path("/prueba")
    @GET
    public String registrar(){
        String query;
        String mensaje;
        mensaje="";
      

        PreparedStatement ps =null;
        Connection con = ConnectionDB.getJNDIConnection();

        query = " INSERT INTO pnc_adm_documentos(documento_id,nombre,mime,archivo,fecha_modificacion,descripcion)"
                + " VALUES(PNC_ADM_DOCUMENTOS_SEQ.nextval, ?, ?, ?, ?, ?)";

        try {
            Date date = new Date();
            FileInputStream a = new FileInputStream("C:\\Users\\DESARROLLO\\Downloads\\main.pdf");
            ps = con.prepareStatement(query);
            ps.setString(1,"mainpdf");
            ps.setString(2,"pdf");
            ps.setBinaryStream(3,a);
            ps.setDate(4,new java.sql.Date(date.getTime()));
            ps.setString(5, "descrpcc");
            
            
            ps.executeQuery();
            System.out.println("exitoso");
            mensaje="exitoso";
            //
            
            

        } catch (Exception e) {
           
            System.out.println("error");
            mensaje="error "+e.getMessage();
        }
        
        
        
        return mensaje;
    }
    
    
    
    

}
