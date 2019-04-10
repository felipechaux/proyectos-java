/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities.ordenVuelo;

import java.util.Date;
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
public class OrdenesVuelosCargas {

    @XmlElement
    private Long idOvCarga, idOvItinerario, idUnidad;
    @XmlElement
    private String Descripcion, nombreOrg;
    @XmlElement
    private Long carga;
    @XmlElement
    private String usuarioCreador;
    @XmlElement
    private Date fechaCreacion;
    @XmlElement
    private String usuarioModificador;
    @XmlElement
    private Date fechaModificacion;
    @XmlElement
    private Long pncVersion;

    public Long getIdOvCarga() {
        return idOvCarga;
    }

    public void setIdOvCarga(Long idOvCarga) {
        this.idOvCarga = idOvCarga;
    }

    public String getNombreOrg() {
        return nombreOrg;
    }

    public void setNombreOrg(String nombreOrg) {
        this.nombreOrg = nombreOrg;
    }

    public Long getIdOvItinerario() {
        return idOvItinerario;
    }

    public void setIdOvItinerario(Long idOvItinerario) {
        this.idOvItinerario = idOvItinerario;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Long getCarga() {
        return carga;
    }

    public void setCarga(Long carga) {
        this.carga = carga;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getPncVersion() {
        return pncVersion;
    }

    public void setPncVersion(Long pncVersion) {
        this.pncVersion = pncVersion;
    }

}
