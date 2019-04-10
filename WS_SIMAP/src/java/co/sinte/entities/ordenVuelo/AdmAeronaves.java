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
public class AdmAeronaves {
    @XmlElement
    private Long idAeronave;
    @XmlElement
    private String matricula;
    @XmlElement
    private Long idEquipo;
    @XmlElement
    private String medida;
    @XmlElement
    private Long idUnidadAsignacion;
    @XmlElement
    private String skytracker,activo;
    @XmlElement
    private Long capacidadMaxTransportar,pesoVacio,gastoCombustibleCarreteo;
    @XmlElement
    private String usuarioCreador;
    @XmlElement
    private Date fechaCreacion;
    @XmlElement
    private String usuarioModificador;
    @XmlElement
    private Date fechaModificacion;
    @XmlElement
    private Long pncVersion,horasInicialAcum,idMisionAeronave,horasAcumuladas;
    @XmlElement
    private String centroCostos; 

    public String getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(String centroCostos) {
        this.centroCostos = centroCostos;
    }

    public Long getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(Long idAeronave) {
        this.idAeronave = idAeronave;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Long getIdUnidadAsignacion() {
        return idUnidadAsignacion;
    }

    public void setIdUnidadAsignacion(Long idUnidadAsignacion) {
        this.idUnidadAsignacion = idUnidadAsignacion;
    }

    public String getSkytracker() {
        return skytracker;
    }

    public void setSkytracker(String skytracker) {
        this.skytracker = skytracker;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getCapacidadMaxTransportar() {
        return capacidadMaxTransportar;
    }

    public void setCapacidadMaxTransportar(Long capacidadMaxTransportar) {
        this.capacidadMaxTransportar = capacidadMaxTransportar;
    }

    public Long getPesoVacio() {
        return pesoVacio;
    }

    public void setPesoVacio(Long pesoVacio) {
        this.pesoVacio = pesoVacio;
    }

    public Long getGastoCombustibleCarreteo() {
        return gastoCombustibleCarreteo;
    }

    public void setGastoCombustibleCarreteo(Long gastoCombustibleCarreteo) {
        this.gastoCombustibleCarreteo = gastoCombustibleCarreteo;
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

    public Long getHorasInicialAcum() {
        return horasInicialAcum;
    }

    public void setHorasInicialAcum(Long horasInicialAcum) {
        this.horasInicialAcum = horasInicialAcum;
    }

    public Long getIdMisionAeronave() {
        return idMisionAeronave;
    }

    public void setIdMisionAeronave(Long idMisionAeronave) {
        this.idMisionAeronave = idMisionAeronave;
    }

    public Long getHorasAcumuladas() {
        return horasAcumuladas;
    }

    public void setHorasAcumuladas(Long horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }
    
    
            
            
            
    

        

        
}
