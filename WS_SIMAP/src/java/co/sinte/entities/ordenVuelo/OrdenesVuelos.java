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
public class OrdenesVuelos {

    @XmlElement
    private Long idOrdenVuelo, numero, idProgramacion, numeroProgramacion, idAeronave;
    @XmlElement
    private String matriculaAeronave, estado;
    @XmlElement
    private Long temperatura;
    @XmlElement
    private Date fechaHora;
    @XmlElement
    private Long idDespachador;
    @XmlElement
    private String despachador;
    @XmlElement
    private String instrucciones, observaciones, numeroBoletin, usuarioCreador;
    @XmlElement
    private Date fechaCreacion;
    @XmlElement
    private String usuarioModificador;
    @XmlElement
    private Date fechaModificacion;
    @XmlElement
    private Long pncVersion;
    @XmlElement
    private String aip, reporte, notam, medida, modelo, marca;
    @XmlElement
    private List<OrdenesVuelosItinerarios> ordenesVuelosItinerarios;
    @XmlElement
    private List<OrdenesVuelosTripulaciones> ordenesVuelosTripulaciones;

    public List<OrdenesVuelosItinerarios> getOrdenesVuelosItinerarios() {
        return ordenesVuelosItinerarios;
    }

    public void setOrdenesVuelosItinerarios(List<OrdenesVuelosItinerarios> ordenesVuelosItinerarios) {
        this.ordenesVuelosItinerarios = ordenesVuelosItinerarios;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public List<OrdenesVuelosTripulaciones> getOrdenesVuelosTripulaciones() {
        return ordenesVuelosTripulaciones;
    }

    public void setOrdenesVuelosTripulaciones(List<OrdenesVuelosTripulaciones> ordenesVuelosTripulaciones) {
        this.ordenesVuelosTripulaciones = ordenesVuelosTripulaciones;
    }

    public String getAip() {
        return aip;
    }

    public void setAip(String aip) {
        this.aip = aip;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getNotam() {
        return notam;
    }

    public void setNotam(String notam) {
        this.notam = notam;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdOrdenVuelo() {
        return idOrdenVuelo;
    }

    public void setIdOrdenVuelo(Long idOrdenVuelo) {
        this.idOrdenVuelo = idOrdenVuelo;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Long idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Long getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(Long idAeronave) {
        this.idAeronave = idAeronave;
    }

    public Long getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Long temperatura) {
        this.temperatura = temperatura;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Long getIdDespachador() {
        return idDespachador;
    }

    public void setIdDespachador(Long idDespachador) {
        this.idDespachador = idDespachador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNumeroBoletin() {
        return numeroBoletin;
    }

    public void setNumeroBoletin(String numeroBoletin) {
        this.numeroBoletin = numeroBoletin;
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

    public Long getNumeroProgramacion() {
        return numeroProgramacion;
    }

    public void setNumeroProgramacion(Long numeroProgramacion) {
        this.numeroProgramacion = numeroProgramacion;
    }

    public String getMatriculaAeronave() {
        return matriculaAeronave;
    }

    public void setMatriculaAeronave(String matriculaAeronave) {
        this.matriculaAeronave = matriculaAeronave;
    }

    public String getDespachador() {
        return despachador;
    }

    public void setDespachador(String despachador) {
        this.despachador = despachador;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
}
