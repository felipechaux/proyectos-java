/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.entities;

/**
 *
 * @author Administrador
 */
public class NombreDisponibilidad {
    
    private String fecha,bloque,nombreLaboratorio,nombreAsignatura,nombrePersonaAsignada,emailPersonaAsignada;

    public String getEmailPersonaAsignada() {
        return emailPersonaAsignada;
    }

    public void setEmailPersonaAsignada(String emailPersonaAsignada) {
        this.emailPersonaAsignada = emailPersonaAsignada;
    }

    public String getNombrePersonaAsignada() {
        return nombrePersonaAsignada;
    }

    public void setNombrePersonaAsignada(String nombrePersonaAsignada) {
        this.nombrePersonaAsignada = nombrePersonaAsignada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    
}
