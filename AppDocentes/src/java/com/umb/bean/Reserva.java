/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.bean;

import com.umb.dao.Correo;
import com.umb.dao.ListasDAO;
import com.umb.dao.ReservaDAO;
import com.umb.entities.BloqueLaboratorio;
import com.umb.entities.ReservaCalendario;
import com.umb.entities.Servicio;
import java.io.Serializable;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "reserva")
@SessionScoped
public class Reserva extends Listas implements Serializable {

    FacesMessage message = null;

    private Date fecha;

    private int idPersona, idLaboratorio, idMateria;

    private List<Servicio> servicios;

    private String tipoServicio;

    private List<BloqueLaboratorio> bloques;

    private List<ReservaCalendario> reservasCalendario;

    public List<ReservaCalendario> getReservasCalendario() {
        return reservasCalendario;
    }

    public void setReservasCalendario(List<ReservaCalendario> reservasCalendario) {
        this.reservasCalendario = reservasCalendario;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public List<BloqueLaboratorio> getBloques() {
        return bloques;
    }

    public void setBloques(List<BloqueLaboratorio> bloques) {
        this.bloques = bloques;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }


    public void reservar(int idDisponibilidad, String permiso, String id,String usuario) {

        System.out.println("permiso reserva " + permiso + " id persona " + id);
        switch (permiso) {

            case "DIRECTOR": {
                System.out.println("case director");
                if (idPersona != 0 && idDisponibilidad != 0) {
                    try {
                        ReservaDAO reserva = new ReservaDAO();
                        reserva.registrarReserva(idPersona, idDisponibilidad, idMateria, "NO");
                        
                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, reserva.getMessage(), null);
                        FacesContext.getCurrentInstance().addMessage(null, message);
                        enviarReserva(idPersona,idDisponibilidad,"NO",usuario);
                        //recargar listas
                        init();
                    } catch (Exception e) {
                        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "error " + e.getMessage(), null);
                        FacesContext.getCurrentInstance().addMessage(null, message);
                    }
                }

                break;
            }
            case "DOCENTE": {
                System.out.println("case docente");
                //reposision

                if (Integer.parseInt(id) != 0 && idDisponibilidad != 0) {
                    try {
                        ReservaDAO reserva = new ReservaDAO();
                        reserva.registrarReserva(Integer.parseInt(id), idDisponibilidad, idMateria, "SI");
                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, reserva.getMessage(), null);
                        FacesContext.getCurrentInstance().addMessage(null, message);
                        enviarReserva(Integer.parseInt(id),idDisponibilidad,"SI",usuario);
                        //recargar listas
                        init();
                    } catch (Exception e) {
                        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "error " + e.getMessage(), null);
                        FacesContext.getCurrentInstance().addMessage(null, message);
                    }
                }

                break;
            }
            default:
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Permisos insuficientes ", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                break;
        }

    }

    public void enviarReserva(int idPersona, int idDisponibilidad,String reposicion,String usuarioReserva) throws Exception {
        //persona, laboratorio, materia
        //llamada a listasDAO
        System.out.println("correo reserva!!");

        System.out.println("persona: "+idPersona+" Materia: "+idMateria+" Laboratorio : "+idDisponibilidad+" Reposicion "+reposicion+" bloque "+""+" Usuario reservo "+usuarioReserva);
        Correo correo = new Correo();
        correo.enviarReserva();

       // message = new FacesMessage(FacesMessage.SEVERITY_INFO, correo.getMessage(), null);
       // FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void pro(int idDisponibilidad) {
        System.out.println("persona " + idPersona);
        System.out.println("disponobilidad " + idDisponibilidad);
    }

    @Override
    public void init() {
        System.out.println("cargue listas reserva ");
        System.out.println("");
        ListasDAO listas = new ListasDAO();

        this.setListaD(listas.getLista("LD", Types.INTEGER, null));
        this.setListaL(listas.getLista("LL", Types.INTEGER, null));
        // this.setListaM(listas.getLista("LM",Types.INTEGER,null));

    }

    public void cargarMaterias(int idUnidad) {

        if (idUnidad != 0) {
            ListasDAO listas = new ListasDAO();
            this.setListaM(listas.getLista("LM", idUnidad, null));
        }

    }

    public void cargarServicios(int idLaboratorio) {
        System.out.println("cargue servicios ");
        System.out.println("id" + idLaboratorio + " tipo" + tipoServicio);
        if (idLaboratorio != 0 && tipoServicio != null) {
            System.out.println("entra ");
            ReservaDAO detalle = new ReservaDAO();
            servicios = detalle.getDetalleServicios(idLaboratorio, tipoServicio);
        }

    }

}
