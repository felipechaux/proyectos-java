/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.bean;

import com.umb.dao.AsistenciaDAO;
import com.umb.entities.Asistencia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "asistencia")
@ViewScoped
public class rAsistencia implements Serializable{

    private List<Asistencia> asistencias;

    AsistenciaDAO asistencia;

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public rAsistencia() {
        asistencia = new AsistenciaDAO();
    }

    @PostConstruct
    public void init() {
        System.out.println("init asis");
        asistencias=asistencia.reporteAsistencia();
    }

}
