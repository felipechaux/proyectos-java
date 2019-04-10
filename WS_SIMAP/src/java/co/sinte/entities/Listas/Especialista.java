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
public class Especialista {
    
     @XmlElement
     private String pidEspecialista;
     @XmlElement
     private Long celular;
     @XmlElement
     private String nombre;
     @XmlElement
     private Long idpersona;
     @XmlElement
     private Long idPuntoTanqueo;

    public String getPidEspecialista() {
        return pidEspecialista;
    }

    public void setPidEspecialista(String pidEspecialista) {
        this.pidEspecialista = pidEspecialista;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public Long getIdPuntoTanqueo() {
        return idPuntoTanqueo;
    }

    public void setIdPuntoTanqueo(Long idPuntoTanqueo) {
        this.idPuntoTanqueo = idPuntoTanqueo;
    }
     
     
      
      
      
     
     
     
}
