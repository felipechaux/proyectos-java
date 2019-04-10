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
public class RegistrosVuelosItinerarios {

    @XmlElement
    private Long idRvItinerario, idRvRegistroVuelo, numeroVuelo, idOrigen, idDestino,
            logStd, auto, start1, start2, loadInt, loadExt, pax, cyc, hsf, engine1,
            engine2, apuStarts, apHr, totalAeronave, totalTripulacion, pncVersion;

    @XmlElement
    private Date horaInicio, horaDespegue, horaArribo,
            horaFinal, fechaCreacion, fechaModificacion;

    @XmlElement
    private String idMisionStd, misConfig, entity, loadUnit,
            hrMeterHrs, usuarioCreador, usuarioModificador;

    public Long getIdRvItinerario() {
        return idRvItinerario;
    }

    public void setIdRvItinerario(Long idRvItinerario) {
        this.idRvItinerario = idRvItinerario;
    }

    public Long getIdRvRegistroVuelo() {
        return idRvRegistroVuelo;
    }

    public void setIdRvRegistroVuelo(Long idRvRegistroVuelo) {
        this.idRvRegistroVuelo = idRvRegistroVuelo;
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

    public Long getLogStd() {
        return logStd;
    }

    public void setLogStd(Long logStd) {
        this.logStd = logStd;
    }

    public Long getAuto() {
        return auto;
    }

    public void setAuto(Long auto) {
        this.auto = auto;
    }

    public Long getStart1() {
        return start1;
    }

    public void setStart1(Long start1) {
        this.start1 = start1;
    }

    public Long getStart2() {
        return start2;
    }

    public void setStart2(Long start2) {
        this.start2 = start2;
    }

    public Long getLoadInt() {
        return loadInt;
    }

    public void setLoadInt(Long loadInt) {
        this.loadInt = loadInt;
    }

    public Long getLoadExt() {
        return loadExt;
    }

    public void setLoadExt(Long loadExt) {
        this.loadExt = loadExt;
    }

    public Long getPax() {
        return pax;
    }

    public void setPax(Long pax) {
        this.pax = pax;
    }

    public Long getCyc() {
        return cyc;
    }

    public void setCyc(Long cyc) {
        this.cyc = cyc;
    }

    public Long getHsf() {
        return hsf;
    }

    public void setHsf(Long hsf) {
        this.hsf = hsf;
    }

    public Long getEngine1() {
        return engine1;
    }

    public void setEngine1(Long engine1) {
        this.engine1 = engine1;
    }

    public Long getEngine2() {
        return engine2;
    }

    public void setEngine2(Long engine2) {
        this.engine2 = engine2;
    }

    public Long getApuStarts() {
        return apuStarts;
    }

    public void setApuStarts(Long apuStarts) {
        this.apuStarts = apuStarts;
    }

    public Long getApHr() {
        return apHr;
    }

    public void setApHr(Long apHr) {
        this.apHr = apHr;
    }

    public Long getTotalAeronave() {
        return totalAeronave;
    }

    public void setTotalAeronave(Long totalAeronave) {
        this.totalAeronave = totalAeronave;
    }

    public Long getTotalTripulacion() {
        return totalTripulacion;
    }

    public void setTotalTripulacion(Long totalTripulacion) {
        this.totalTripulacion = totalTripulacion;
    }

    public Long getPncVersion() {
        return pncVersion;
    }

    public void setPncVersion(Long pncVersion) {
        this.pncVersion = pncVersion;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraDespegue() {
        return horaDespegue;
    }

    public void setHoraDespegue(Date horaDespegue) {
        this.horaDespegue = horaDespegue;
    }

    public Date getHoraArribo() {
        return horaArribo;
    }

    public void setHoraArribo(Date horaArribo) {
        this.horaArribo = horaArribo;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
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

    public String getIdMisionStd() {
        return idMisionStd;
    }

    public void setIdMisionStd(String idMisionStd) {
        this.idMisionStd = idMisionStd;
    }

    public String getMisConfig() {
        return misConfig;
    }

    public void setMisConfig(String misConfig) {
        this.misConfig = misConfig;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getLoadUnit() {
        return loadUnit;
    }

    public void setLoadUnit(String loadUnit) {
        this.loadUnit = loadUnit;
    }

    public String getHrMeterHrs() {
        return hrMeterHrs;
    }

    public void setHrMeterHrs(String hrMeterHrs) {
        this.hrMeterHrs = hrMeterHrs;
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

}
