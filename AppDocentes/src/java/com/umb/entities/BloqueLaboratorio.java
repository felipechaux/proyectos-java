/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.entities;

import java.util.Date;



/**
 *
 * @author Administrador
 */
public class BloqueLaboratorio {
    
    private int id,idLaboratorio;
    
    private Date fecha,bloqueInicio,bloqueFin;
    
    private String bloque,estado,nombreLaboratorio,nombreAsignaturaReserva;

    public String getNombreAsignaturaReserva() {
        return nombreAsignaturaReserva;
    }

    public void setNombreAsignaturaReserva(String nombreAsignaturaReserva) {
        this.nombreAsignaturaReserva = nombreAsignaturaReserva;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getBloqueInicio() {
        return bloqueInicio;
    }

    public void setBloqueInicio(Date bloqueInicio) {
        this.bloqueInicio = bloqueInicio;
    }

 
    public Date getBloqueFin() {
        return bloqueFin;
    }

    public void setBloqueFin(Date bloqueFin) {
        this.bloqueFin = bloqueFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    
}
