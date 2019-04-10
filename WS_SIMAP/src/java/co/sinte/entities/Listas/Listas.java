/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities.Listas;

import co.sinte.entities.Listas.riesgos.Riesgos;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DESARROLLO
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Listas {

    @XmlElement
    private List<Especialista> especialista;

    @XmlElement
    private List<Fuerza> fuerza;

    @XmlElement
    private List<Lugar> lugar;

    @XmlElement
    private List<MissionStd> missionStd;

    @XmlElement
    private List<Name> name;

    @XmlElement
    private List<OrdenVuelo> ordenVuelo;

    @XmlElement
    private List<Organizacion> organizacion;

    @XmlElement
    private List<PtoTanqueo> ptoTanqueo;

    @XmlElement
    private List<Service> service;

    @XmlElement
    private List<TipoService> tipoService;

    @XmlElement
    private List<Riesgos> riesgos;

    public List<Riesgos> getRiesgos() {
        return riesgos;
    }

    public void setRiesgos(List<Riesgos> riesgos) {
        this.riesgos = riesgos;
    }

    public List<Especialista> getEspecialista() {
        return especialista;
    }

    public void setEspecialista(List<Especialista> especialista) {
        this.especialista = especialista;
    }

    public List<Fuerza> getFuerza() {
        return fuerza;
    }

    public void setFuerza(List<Fuerza> fuerza) {
        this.fuerza = fuerza;
    }

    public List<Lugar> getLugar() {
        return lugar;
    }

    public void setLugar(List<Lugar> lugar) {
        this.lugar = lugar;
    }

    public List<MissionStd> getMissionStd() {
        return missionStd;
    }

    public void setMissionStd(List<MissionStd> missionStd) {
        this.missionStd = missionStd;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public List<OrdenVuelo> getOrdenVuelo() {
        return ordenVuelo;
    }

    public void setOrdenVuelo(List<OrdenVuelo> ordenVuelo) {
        this.ordenVuelo = ordenVuelo;
    }

    public List<Organizacion> getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(List<Organizacion> organizacion) {
        this.organizacion = organizacion;
    }

    public List<PtoTanqueo> getPtoTanqueo() {
        return ptoTanqueo;
    }

    public void setPtoTanqueo(List<PtoTanqueo> ptoTanqueo) {
        this.ptoTanqueo = ptoTanqueo;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public List<TipoService> getTipoService() {
        return tipoService;
    }

    public void setTipoService(List<TipoService> tipoService) {
        this.tipoService = tipoService;
    }

}
