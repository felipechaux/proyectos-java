/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.bean;

import com.umb.dao.AsignaturaDAO;
import com.umb.dao.ListasDAO;
import com.umb.entities.AsignaturaE;
import java.io.Serializable;
import java.sql.Types;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "asignatura")
@ViewScoped
public class Asignatura extends AsignaturaE implements Serializable {

    private AsignaturaE selectedAsignatura;

    private List<AsignaturaE> asignaturas;

    FacesMessage msg;

    AsignaturaDAO asignatura;

    ListasDAO listas;

    public Asignatura() {
        asignatura = new AsignaturaDAO();

    }

    public AsignaturaE getSelectedAsignatura() {
        return selectedAsignatura;
    }

    public void setSelectedAsignatura(AsignaturaE selectedAsignatura) {
        this.selectedAsignatura = selectedAsignatura;
    }

    public List<AsignaturaE> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<AsignaturaE> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void crearAsignatura() {

        if (this.getNombreAsignatura() != null & this.getIdUnidad() != 0) {
            asignatura.registrarAsignatura(this.getNombreAsignatura(), this.getIdUnidad());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, asignatura.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //recargar asignaturas
            init();
        }

    }

    public void modificarAsignatura() {

        System.out.println("id unidad "+ this.getSelectedAsignatura().getIdUnidad());
        
        asignatura.modificarAsginatura(this.getSelectedAsignatura().getIdAsignatura(),this.getSelectedAsignatura().getNombreAsignatura(), this.getSelectedAsignatura().getIdUnidad());
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, asignatura.getMessage(), null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        //recargar asignaturas
        init();

    }

    @Override
    public void init() {

        listas = new ListasDAO();
        this.setListaUA2(listas.getLista("LUA2", Types.INTEGER, null));

        asignaturas = asignatura.getAsignaturas();

    }

}
