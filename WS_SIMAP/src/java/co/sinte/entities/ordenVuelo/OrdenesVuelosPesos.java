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
public class OrdenesVuelosPesos {

    @XmlElement
    private Long idOvPeso, idOrdenVuelo, pesoTotalCombustible, pesoTotalTripulacion, pesoTotalCarga, pesoTotalTransportar;

    @XmlElement
    private String usuarioCreador;

    @XmlElement
    private Date fechaCreacion;

    @XmlElement
    private String usuarioModificador;

    @XmlElement
    private Date fechaModificacion;

    @XmlElement
    private Long pncVersion, dispSobrecarga, pesoTotalPasajeros;

    public Long getIdOvPeso() {
        return idOvPeso;
    }

    public void setIdOvPeso(Long idOvPeso) {
        this.idOvPeso = idOvPeso;
    }

    public Long getIdOrdenVuelo() {
        return idOrdenVuelo;
    }

    public void setIdOrdenVuelo(Long idOrdenVuelo) {
        this.idOrdenVuelo = idOrdenVuelo;
    }

    public Long getPesoTotalCombustible() {
        return pesoTotalCombustible;
    }

    public void setPesoTotalCombustible(Long pesoTotalCombustible) {
        this.pesoTotalCombustible = pesoTotalCombustible;
    }

    public Long getPesoTotalTripulacion() {
        return pesoTotalTripulacion;
    }

    public void setPesoTotalTripulacion(Long pesoTotalTripulacion) {
        this.pesoTotalTripulacion = pesoTotalTripulacion;
    }

    public Long getPesoTotalCarga() {
        return pesoTotalCarga;
    }

    public void setPesoTotalCarga(Long pesoTotalCarga) {
        this.pesoTotalCarga = pesoTotalCarga;
    }

    public Long getPesoTotalTransportar() {
        return pesoTotalTransportar;
    }

    public void setPesoTotalTransportar(Long pesoTotalTransportar) {
        this.pesoTotalTransportar = pesoTotalTransportar;
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

    public Long getDispSobrecarga() {
        return dispSobrecarga;
    }

    public void setDispSobrecarga(Long dispSobrecarga) {
        this.dispSobrecarga = dispSobrecarga;
    }

    public Long getPesoTotalPasajeros() {
        return pesoTotalPasajeros;
    }

    public void setPesoTotalPasajeros(Long pesoTotalPasajeros) {
        this.pesoTotalPasajeros = pesoTotalPasajeros;
    }

}
