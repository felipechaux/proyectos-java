/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities;

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
public class MensajeRespuesta {

    @XmlElement
    private Boolean autenticacion;
    @XmlElement
    private String mensaje;
    @XmlElement
    private Integer CodigoError;
    @XmlElement
    private String numRegistroVuelos;
    @XmlElement
    private String nivelRiesgo;

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getNumRegistroVuelos() {
        return numRegistroVuelos;
    }

    public void setNumRegistroVuelos(String numRegistroVuelos) {
        this.numRegistroVuelos = numRegistroVuelos;
    }

    public Integer getCodigoError() {
        return CodigoError;
    }

    public void setCodigoError(Integer CodigoError) {
        this.CodigoError = CodigoError;
    }

    public Boolean getAutenticacion() {
        return autenticacion;
    }

    public void setAutenticacion(Boolean autenticacion) {
        this.autenticacion = autenticacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
