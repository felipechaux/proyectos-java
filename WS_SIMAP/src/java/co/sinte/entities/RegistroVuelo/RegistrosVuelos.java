/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities.RegistroVuelo;

import java.util.Date;
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
public class RegistrosVuelos {

    @XmlElement
    private Long idRegistroVuelo, idOrdenVuelo, idAeronave, idOrganizacion, idEstacion, pncVersion;

    @XmlElement
    private Date fecha, fechaCreacion, fechaModificacion;

    @XmlElement
    private String usuarioCreador, usuarioModificador;
    
    @XmlElement
    private List<RegistrosVuelosItinerarios> registrosVuelosItinerarios;
    
    @XmlElement
    private List<RegistrosVuelosServicios> registrosVuelosServicios;
    
    @XmlElement
    private List<RegistrosVuelosTripulaciones> registrosVuelosTripulaciones;
    

    public Long getIdRegistroVuelo() {
        return idRegistroVuelo;
    }

    public void setIdRegistroVuelo(Long idRegistroVuelo) {
        this.idRegistroVuelo = idRegistroVuelo;
    }

    public Long getIdOrdenVuelo() {
        return idOrdenVuelo;
    }

    public void setIdOrdenVuelo(Long idOrdenVuelo) {
        this.idOrdenVuelo = idOrdenVuelo;
    }

    public Long getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(Long idAeronave) {
        this.idAeronave = idAeronave;
    }

    public Long getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Long idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public Long getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(Long idEstacion) {
        this.idEstacion = idEstacion;
    }

    public Long getPncVersion() {
        return pncVersion;
    }

    public void setPncVersion(Long pncVersion) {
        this.pncVersion = pncVersion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public List<RegistrosVuelosItinerarios> getRegistrosVuelosItinerarios() {
        return registrosVuelosItinerarios;
    }

    public void setRegistrosVuelosItinerarios(List<RegistrosVuelosItinerarios> registrosVuelosItinerarios) {
        this.registrosVuelosItinerarios = registrosVuelosItinerarios;
    }

    public List<RegistrosVuelosServicios> getRegistrosVuelosServicios() {
        return registrosVuelosServicios;
    }

    public void setRegistrosVuelosServicios(List<RegistrosVuelosServicios> registrosVuelosServicios) {
        this.registrosVuelosServicios = registrosVuelosServicios;
    }

    public List<RegistrosVuelosTripulaciones> getRegistrosVuelosTripulaciones() {
        return registrosVuelosTripulaciones;
    }

    public void setRegistrosVuelosTripulaciones(List<RegistrosVuelosTripulaciones> registrosVuelosTripulaciones) {
        this.registrosVuelosTripulaciones = registrosVuelosTripulaciones;
    }
    
    

}
