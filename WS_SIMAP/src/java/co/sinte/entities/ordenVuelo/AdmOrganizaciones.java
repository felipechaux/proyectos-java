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
public class AdmOrganizaciones {
    @XmlElement
    private Long idOrganizacion;
    @XmlElement
    private String nombre,sigla,apoyada,activo;
    @XmlElement
    private Long idSector,idOrganizacionPadre;
    @XmlElement
    private String fuerza;
    @XmlElement
    private Long idPais,idDepartamento,idMunicipio;
    @XmlElement
    private String lugar,latitud;
    @XmlElement
    private Long gradoslat,minutoslat,segundoslat;
    @XmlElement
    private String longitud;
    @XmlElement
    private Long gradoslon,minutoslon,segundoslon;
    @XmlElement
    private String usuarioModificador;
    @XmlElement
    private Date fechaModificacion;
    @XmlElement
    private Long pncVersion;

    public Long getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Long idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getApoyada() {
        return apoyada;
    }

    public void setApoyada(String apoyada) {
        this.apoyada = apoyada;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getIdSector() {
        return idSector;
    }

    public void setIdSector(Long idSector) {
        this.idSector = idSector;
    }

    public Long getIdOrganizacionPadre() {
        return idOrganizacionPadre;
    }

    public void setIdOrganizacionPadre(Long idOrganizacionPadre) {
        this.idOrganizacionPadre = idOrganizacionPadre;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public Long getGradoslat() {
        return gradoslat;
    }

    public void setGradoslat(Long gradoslat) {
        this.gradoslat = gradoslat;
    }

    public Long getMinutoslat() {
        return minutoslat;
    }

    public void setMinutoslat(Long minutoslat) {
        this.minutoslat = minutoslat;
    }

    public Long getSegundoslat() {
        return segundoslat;
    }

    public void setSegundoslat(Long segundoslat) {
        this.segundoslat = segundoslat;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Long getGradoslon() {
        return gradoslon;
    }

    public void setGradoslon(Long gradoslon) {
        this.gradoslon = gradoslon;
    }

    public Long getMinutoslon() {
        return minutoslon;
    }

    public void setMinutoslon(Long minutoslon) {
        this.minutoslon = minutoslon;
    }

    public Long getSegundoslon() {
        return segundoslon;
    }

    public void setSegundoslon(Long segundoslon) {
        this.segundoslon = segundoslon;
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
