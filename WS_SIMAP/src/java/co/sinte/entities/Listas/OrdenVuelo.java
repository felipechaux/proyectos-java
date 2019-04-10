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
public class OrdenVuelo {

    @XmlElement
    private Long idOrdenVuelo;

    @XmlElement
    private String matricula, modelo, marca;
    
    @XmlElement
    private Long dspOrden;

    public Long getIdOrdenVuelo() {
        return idOrdenVuelo;
    }

    public Long getDspOrden() {
        return dspOrden;
    }

    public void setDspOrden(Long dspOrden) {
        this.dspOrden = dspOrden;
    }

    public void setIdOrdenVuelo(Long idOrdenVuelo) {
        this.idOrdenVuelo = idOrdenVuelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
