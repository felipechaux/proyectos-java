/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data.Listas;

import co.sinte.data.Listas.riesgos.RiesgosDAO;
import co.sinte.entities.Listas.Especialista;
import co.sinte.entities.Listas.Fuerza;
import co.sinte.entities.Listas.Listas;
import co.sinte.entities.Listas.Lugar;
import co.sinte.entities.Listas.MissionStd;
import co.sinte.entities.Listas.Name;
import co.sinte.entities.Listas.OrdenVuelo;
import co.sinte.entities.Listas.Organizacion;
import co.sinte.entities.Listas.PtoTanqueo;
import co.sinte.entities.Listas.Service;
import co.sinte.entities.Listas.TipoService;
import co.sinte.entities.Listas.riesgos.Riesgos;
import co.sinte.entities.MensajeRespuesta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DESARROLLO
 */
public class ListasDAO {
    
    Listas listas = new Listas();
    EspecialistaDAO daoEsp = new EspecialistaDAO();
    FuerzaDAO daoFuerza = new FuerzaDAO();
    LugarDAO daoLugar = new LugarDAO();
    MissionStdDAO daoMission = new MissionStdDAO();
    NameDAO daoName = new NameDAO();
    OrdenVueloDAO daoOV = new OrdenVueloDAO();
    OrganizacionDAO daoOrg = new OrganizacionDAO();
    PtoTanqueoDAO daoPtoTanqueo = new PtoTanqueoDAO();
    ServiceDAO daoService = new ServiceDAO();
    TipoServiceDAO daoTipService = new TipoServiceDAO();
    RiesgosDAO daoRiesgo = new RiesgosDAO();
    
    public Listas Listas(MensajeRespuesta respuesta) {
        
        try {
            ArrayList<Especialista> especialista = new ArrayList();
            ArrayList<Fuerza> fuerza = new ArrayList();
            ArrayList<Lugar> lugar = new ArrayList();
            ArrayList<MissionStd> missionStd = new ArrayList();
            ArrayList<Name> name = new ArrayList();
            ArrayList<OrdenVuelo> ordenVuelo = new ArrayList();
            ArrayList<Organizacion> organizacion = new ArrayList();
            ArrayList<PtoTanqueo> ptoTanqueo = new ArrayList();
            ArrayList<Service> service = new ArrayList();
            ArrayList<TipoService> tipoService = new ArrayList();
            ArrayList<Riesgos> riesgos = new ArrayList();
            
            listas.setEspecialista(daoEsp.Especialista(especialista, respuesta));
            listas.setFuerza(daoFuerza.Fuerza(fuerza, respuesta));
            listas.setLugar(daoLugar.Lugar(lugar, respuesta));
            listas.setMissionStd(daoMission.MissionStd(missionStd, respuesta));
            listas.setName(daoName.Name(name, respuesta));
            listas.setOrdenVuelo(daoOV.OrdenVuelo(ordenVuelo, respuesta));
            listas.setOrganizacion(daoOrg.Organizacion(organizacion, respuesta));
            listas.setPtoTanqueo(daoPtoTanqueo.PtoTanqueo(ptoTanqueo, respuesta));
            listas.setService(daoService.Service(service, respuesta));
            listas.setTipoService(daoTipService.TipoService(tipoService, respuesta));
            listas.setRiesgos(daoRiesgo.Riesgos(riesgos, respuesta));
            
        } catch (Exception ex) {
            Logger.getLogger(ListasDAO.class.getName()).log(Level.SEVERE, null, ex);
            respuesta.setMensaje(ex.getMessage());
        }
        
        return listas;
    }
    
}
