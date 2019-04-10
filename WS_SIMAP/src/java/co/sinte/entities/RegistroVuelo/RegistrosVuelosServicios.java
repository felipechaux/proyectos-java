/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities.RegistroVuelo;

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
public class RegistrosVuelosServicios {

    @XmlElement
    private Long idRvServicio, idRegistroVuelo, idFuerza, idPuntoTanqueo, idLugar,
            idTipo, idUnidadTipo, cantidad;

    @XmlElement
    private String gradeTservicio;

    @XmlElement
    private Long enTanques;

    @XmlElement
    private String pid, nombreEspecialista;

    @XmlElement
    private Long celular, ordenSuministro;

    @XmlElement
    private String usuarioCreador;

    @XmlElement
    private Date fechaCreacion;

    @XmlElement
    private String usuarioModificador;

    @XmlElement
    private Date fechaModificacion;

    @XmlElement
    private Long pncVersion, idPersona, idTipoServicio;

    public Long getIdPuntoTanqueo() {
        return idPuntoTanqueo;
    }

    public void setIdPuntoTanqueo(Long idPuntoTanqueo) {
        this.idPuntoTanqueo = idPuntoTanqueo;
    }

    public Long getIdRvServicio() {
        return idRvServicio;
    }

    public void setIdRvServicio(Long idRvServicio) {
        this.idRvServicio = idRvServicio;
    }

    public Long getIdRegistroVuelo() {
        return idRegistroVuelo;
    }

    public void setIdRegistroVuelo(Long idRegistroVuelo) {
        this.idRegistroVuelo = idRegistroVuelo;
    }

    public Long getIdFuerza() {
        return idFuerza;
    }

    public void setIdFuerza(Long idFuerza) {
        this.idFuerza = idFuerza;
    }

    public Long getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public Long getIdUnidadTipo() {
        return idUnidadTipo;
    }

    public void setIdUnidadTipo(Long idUnidadTipo) {
        this.idUnidadTipo = idUnidadTipo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPncVersion() {
        return pncVersion;
    }

    public void setPncVersion(Long pncVersion) {
        this.pncVersion = pncVersion;
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

    public String getGradeTservicio() {
        return gradeTservicio;
    }

    public void setGradeTservicio(String gradeTservicio) {
        this.gradeTservicio = gradeTservicio;
    }

    public Long getEnTanques() {
        return enTanques;
    }

    public void setEnTanques(Long enTanques) {
        this.enTanques = enTanques;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNombreEspecialista() {
        return nombreEspecialista;
    }

    public void setNombreEspecialista(String nombreEspecialista) {
        this.nombreEspecialista = nombreEspecialista;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Long getOrdenSuministro() {
        return ordenSuministro;
    }

    public void setOrdenSuministro(Long ordenSuministro) {
        this.ordenSuministro = ordenSuministro;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Long idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

}
