/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities.Listas;

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
public class PtoTanqueo {

    @XmlElement
    private Long idPuntoTanqueo;

    @XmlElement
    private String nombrePtoTanqueo;

    public Long getIdPuntoTanqueo() {
        return idPuntoTanqueo;
    }

    public void setIdPuntoTanqueo(Long idPuntoTanqueo) {
        this.idPuntoTanqueo = idPuntoTanqueo;
    }

    public String getNombrePtoTanqueo() {
        return nombrePtoTanqueo;
    }

    public void setNombrePtoTanqueo(String nombrePtoTanqueo) {
        this.nombrePtoTanqueo = nombrePtoTanqueo;
    }

}
