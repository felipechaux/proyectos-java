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
public class RegistrosVuelosTripulaciones {

    @XmlElement
    private Long idRvTripulacion, idRegistroVuelo, idPersona, vmcDs, vmcFs, vmcHr, vmcS, imsDs,
            imcFs, imcHr, imcS, nocDs, nocFs, nocHr, nocS, nvgDs, nvgFd, nvgHr, nvgS, pncVersion;

    @XmlElement
    private String grado, pid, usuarioCreador, usuarioModificador;

    @XmlElement
    private Date fechaCreacion, fechaModificacion;

    public Long getIdRvTripulacion() {
        return idRvTripulacion;
    }

    public void setIdRvTripulacion(Long idRvTripulacion) {
        this.idRvTripulacion = idRvTripulacion;
    }

    public Long getIdRegistroVuelo() {
        return idRegistroVuelo;
    }

    public void setIdRegistroVuelo(Long idRegistroVuelo) {
        this.idRegistroVuelo = idRegistroVuelo;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getVmcDs() {
        return vmcDs;
    }

    public void setVmcDs(Long vmcDs) {
        this.vmcDs = vmcDs;
    }

    public Long getVmcFs() {
        return vmcFs;
    }

    public void setVmcFs(Long vmcFs) {
        this.vmcFs = vmcFs;
    }

    public Long getVmcHr() {
        return vmcHr;
    }

    public void setVmcHr(Long vmcHr) {
        this.vmcHr = vmcHr;
    }

    public Long getVmcS() {
        return vmcS;
    }

    public void setVmcS(Long vmcS) {
        this.vmcS = vmcS;
    }

    public Long getImsDs() {
        return imsDs;
    }

    public void setImsDs(Long imsDs) {
        this.imsDs = imsDs;
    }

    public Long getImcFs() {
        return imcFs;
    }

    public void setImcFs(Long imcFs) {
        this.imcFs = imcFs;
    }

    public Long getImcHr() {
        return imcHr;
    }

    public void setImcHr(Long imcHr) {
        this.imcHr = imcHr;
    }

    public Long getImcS() {
        return imcS;
    }

    public void setImcS(Long imcS) {
        this.imcS = imcS;
    }

    public Long getNocDs() {
        return nocDs;
    }

    public void setNocDs(Long nocDs) {
        this.nocDs = nocDs;
    }

    public Long getNocFs() {
        return nocFs;
    }

    public void setNocFs(Long nocFs) {
        this.nocFs = nocFs;
    }

    public Long getNocHr() {
        return nocHr;
    }

    public void setNocHr(Long nocHr) {
        this.nocHr = nocHr;
    }

    public Long getNocS() {
        return nocS;
    }

    public void setNocS(Long nocS) {
        this.nocS = nocS;
    }

    public Long getNvgDs() {
        return nvgDs;
    }

    public void setNvgDs(Long nvgDs) {
        this.nvgDs = nvgDs;
    }

    public Long getNvgFd() {
        return nvgFd;
    }

    public void setNvgFd(Long nvgFd) {
        this.nvgFd = nvgFd;
    }

    public Long getNvgHr() {
        return nvgHr;
    }

    public void setNvgHr(Long nvgHr) {
        this.nvgHr = nvgHr;
    }

    public Long getNvgS() {
        return nvgS;
    }

    public void setNvgS(Long nvgS) {
        this.nvgS = nvgS;
    }

    public Long getPncVersion() {
        return pncVersion;
    }

    public void setPncVersion(Long pncVersion) {
        this.pncVersion = pncVersion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

}
