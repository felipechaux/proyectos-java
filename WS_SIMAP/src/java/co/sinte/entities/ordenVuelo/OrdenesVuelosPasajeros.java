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
public class OrdenesVuelosPasajeros {

    @XmlElement
    private Long idOvPasajero, idOvItinerario, idPasajero, idCargo;
    @XmlElement
    private String cargo, nombrePasajero, grado;
    @XmlElement
    private Long peso, pesoEquipaje;
    @XmlElement
    private String autoriza, rutaVuelo, usuarioCreador;
    @XmlElement
    private Date fechaCreacion;
    @XmlElement
    private String usuarioModificador;
    @XmlElement
    private Date fechaModificacion;
    @XmlElement
    private Long pncVersion, pesoTotal;

    public Long getIdOvPasajero() {
        return idOvPasajero;
    }

    public void setIdOvPasajero(Long idOvPasajero) {
        this.idOvPasajero = idOvPasajero;
    }

    public Long getIdOvItinerario() {
        return idOvItinerario;
    }

    public void setIdOvItinerario(Long idOvItinerario) {
        this.idOvItinerario = idOvItinerario;
    }

    public Long getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Long idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public Long getPesoEquipaje() {
        return pesoEquipaje;
    }

    public void setPesoEquipaje(Long pesoEquipaje) {
        this.pesoEquipaje = pesoEquipaje;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getRutaVuelo() {
        return rutaVuelo;
    }

    public void setRutaVuelo(String rutaVuelo) {
        this.rutaVuelo = rutaVuelo;
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

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public Long getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Long pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

}
