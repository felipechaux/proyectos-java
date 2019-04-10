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
public class Fuerza {
    
    @XmlElement
    private Long idValorFlexible;
    @XmlElement
    private String valor,sigla;

    public Long getIdValorFlexible() {
        return idValorFlexible;
    }

    public void setIdValorFlexible(Long idValorFlexible) {
        this.idValorFlexible = idValorFlexible;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    
    
}
