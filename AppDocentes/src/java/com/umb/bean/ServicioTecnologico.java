/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.bean;

import com.umb.dao.ServicioDAO;
import com.umb.entities.Servicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "servicio")
@ViewScoped
public class ServicioTecnologico extends Servicio implements Serializable {

    private List<Servicio> servicios;

    private Servicio selectedServicio;

    ServicioDAO servicio;

    FacesMessage msg;

    public ServicioTecnologico() {
        servicio = new ServicioDAO();
    }

    public Servicio getSelectedServicio() {
        return selectedServicio;
    }

    public void setSelectedServicio(Servicio selectedServicio) {
        this.selectedServicio = selectedServicio;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void crearServicio() {

        if (this.getNombre() != null && this.getIdLaboratorio() != 0 && this.getTipoServicio()!=null) {
            servicio.registrarServicio(this.getNombre(), this.getCantidad(), this.getDescripcion(), this.getIdLaboratorio(),this.getTipoServicio());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, servicio.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //recargar servicios
            init();
        }

    }

    public void modificarServicio() {

        servicio.modificarServicio(this.getSelectedServicio().getIdServicio(),this.getSelectedServicio().getNombre(), this.getSelectedServicio().getCantidad(), this.getSelectedServicio().getDescripcion(), this.getSelectedServicio().getIdLaboratorio(),this.getSelectedServicio().getTipoServicio());
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, servicio.getMessage(), null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        //recargar servicios
        init();

    }

    @PostConstruct
    public void init() {
        System.out.println("cargue ServiciosDATA ");
        servicios = servicio.getServicios();
    }

}
