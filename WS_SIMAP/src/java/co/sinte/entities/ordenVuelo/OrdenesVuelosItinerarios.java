/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities.ordenVuelo;

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
public class OrdenesVuelosItinerarios {

    @XmlElement
    private Long idOvItinerario, idOrdenVuelo;
    
    @XmlElement
    private String numeroBoletin;
    @XmlElement
    private Long numeroVuelo, idOrigen, idDestino;
    @XmlElement
    private String oaciOrigen,oaciDestino,mision, nombreMision, origenVuelo, destinoVuelo, condicionVuelo, lugarAlternoVuelo;
    @XmlElement
    private Long pax, carga, combustibleOrigen, combustibleDestino;
    @XmlElement
    private String requerimientos;
    @XmlElement
    private Long idCondicionVueloAutorizada, velocidad, altitud;
    @XmlElement
    private String tiempoEstimado;
    @XmlElement
    private Long idAlterno;
    @XmlElement
    private String eteAlterno, usuarioCreador;
    @XmlElement
    private Date fechaCreacion;
    @XmlElement
    private String usuarioModificador;
    @XmlElement
    private Date fechaModificacion;
    @XmlElement
    private Long pncVersion;
    @XmlElement
    private String estado;

    @XmlElement
    private List<OrdenesVuelosCargas> ordenesVuelosCargas;

    @XmlElement
    private List<OrdenesVuelosPasajeros> ordenesVuelosPasajeros;

    public String getOaciOrigen() {
        return oaciOrigen;
    }

    public void setOaciOrigen(String oaciOrigen) {
        this.oaciOrigen = oaciOrigen;
    }

    public String getOaciDestino() {
        return oaciDestino;
    }

    public void setOaciDestino(String oaciDestino) {
        this.oaciDestino = oaciDestino;
    }
    
    

    public Long getIdOvItinerario() {
        return idOvItinerario;
    }

    public void setIdOvItinerario(Long idOvItinerario) {
        this.idOvItinerario = idOvItinerario;
    }

    public Long getIdOrdenVuelo() {
        return idOrdenVuelo;
    }

    public void setIdOrdenVuelo(Long idOrdenVuelo) {
        this.idOrdenVuelo = idOrdenVuelo;
    }

    public Long getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(Long numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public Long getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(Long idOrigen) {
        this.idOrigen = idOrigen;
    }

    public Long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public void setNombreMision(String nombreMision) {
        this.nombreMision = nombreMision;
    }

    public String getOrigenVuelo() {
        return origenVuelo;
    }

    public void setOrigenVuelo(String origenVuelo) {
        this.origenVuelo = origenVuelo;
    }

    public String getDestinoVuelo() {
        return destinoVuelo;
    }

    public void setDestinoVuelo(String destinoVuelo) {
        this.destinoVuelo = destinoVuelo;
    }

    public String getCondicionVuelo() {
        return condicionVuelo;
    }

    public void setCondicionVuelo(String condicionVuelo) {
        this.condicionVuelo = condicionVuelo;
    }

    public String getLugarAlternoVuelo() {
        return lugarAlternoVuelo;
    }

    public void setLugarAlternoVuelo(String lugarAlternoVuelo) {
        this.lugarAlternoVuelo = lugarAlternoVuelo;
    }

    public Long getPax() {
        return pax;
    }

    public void setPax(Long pax) {
        this.pax = pax;
    }

    public Long getCarga() {
        return carga;
    }

    public void setCarga(Long carga) {
        this.carga = carga;
    }

    public Long getCombustibleOrigen() {
        return combustibleOrigen;
    }

    public void setCombustibleOrigen(Long combustibleOrigen) {
        this.combustibleOrigen = combustibleOrigen;
    }

    public Long getCombustibleDestino() {
        return combustibleDestino;
    }

    public void setCombustibleDestino(Long combustibleDestino) {
        this.combustibleDestino = combustibleDestino;
    }

    public String getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(String requerimientos) {
        this.requerimientos = requerimientos;
    }

    public Long getIdCondicionVueloAutorizada() {
        return idCondicionVueloAutorizada;
    }

    public void setIdCondicionVueloAutorizada(Long idCondicionVueloAutorizada) {
        this.idCondicionVueloAutorizada = idCondicionVueloAutorizada;
    }

    public Long getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Long velocidad) {
        this.velocidad = velocidad;
    }

    public Long getAltitud() {
        return altitud;
    }

    public void setAltitud(Long altitud) {
        this.altitud = altitud;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public Long getIdAlterno() {
        return idAlterno;
    }

    public void setIdAlterno(Long idAlterno) {
        this.idAlterno = idAlterno;
    }

    public String getEteAlterno() {
        return eteAlterno;
    }

    public void setEteAlterno(String eteAlterno) {
        this.eteAlterno = eteAlterno;
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

    public List<OrdenesVuelosCargas> getOrdenesVuelosCargas() {
        return ordenesVuelosCargas;
    }

    public void setOrdenesVuelosCargas(List<OrdenesVuelosCargas> ordenesVuelosCargas) {
        this.ordenesVuelosCargas = ordenesVuelosCargas;
    }

    public List<OrdenesVuelosPasajeros> getOrdenesVuelosPasajeros() {
        return ordenesVuelosPasajeros;
    }

    public void setOrdenesVuelosPasajeros(List<OrdenesVuelosPasajeros> ordenesVuelosPasajeros) {
        this.ordenesVuelosPasajeros = ordenesVuelosPasajeros;
    }

    public String getNumeroBoletin() {
        return numeroBoletin;
    }

    public void setNumeroBoletin(String numeroBoletin) {
        this.numeroBoletin = numeroBoletin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
