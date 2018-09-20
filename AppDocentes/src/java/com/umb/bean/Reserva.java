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
import com.umb.entities.Lista;
import com.umb.entities.NombreDisponibilidad;
import com.umb.entities.ReservaCalendario;
import com.umb.entities.Servicio;
import java.io.Serializable;
import java.sql.Types;
import java.util.ArrayList;
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

    private int idPersona, idLaboratorio, idMateria, cantidadEquipos, cantidadEstudiantes, idGrupoLaboratorio;

    private List<Servicio> servicios;

    private String tipoServicio, tipoReserva, observacion, nombreGrupo;

    private List<BloqueLaboratorio> bloques;

    private List<ReservaCalendario> reservasCalendario;

    private List<ReservaCalendario> selectedReservas;

    ReservaDAO reserva;

    public Reserva() {
        reserva = new ReservaDAO();
    }

    public List<ReservaCalendario> getSelectedReservas() {
        return selectedReservas;
    }

    public void setSelectedReservas(List<ReservaCalendario> selectedReservas) {
        this.selectedReservas = selectedReservas;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public int getIdGrupoLaboratorio() {
        return idGrupoLaboratorio;
    }

    public void setIdGrupoLaboratorio(int idGrupoLaboratorio) {
        this.idGrupoLaboratorio = idGrupoLaboratorio;
    }

    public List<ReservaCalendario> getReservasCalendario() {
        return reservasCalendario;
    }

    public void setReservasCalendario(List<ReservaCalendario> reservasCalendario) {
        this.reservasCalendario = reservasCalendario;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
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

    public void crearGrupo() {
        System.out.println("hola creacion grupo idlab : " + idLaboratorio + " nombre grupo : " + nombreGrupo);
        if (idLaboratorio != 0 && nombreGrupo != null) {
            reserva.registrarGrupoLaboratorio(nombreGrupo, idLaboratorio);

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, reserva.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, message);

            //recargar 
            cargarGruposLaboratorio();
        }
    }

    public void reservar(int idDisponibilidad, String permiso, String id, String usuario) {

        System.out.println("permiso reserva " + permiso + " id persona " + id);
        switch (permiso) {
            case "COORDINADOR":
            case "DIRECTOR": {
                System.out.println("case director");
                if (idPersona != 0 && idDisponibilidad != 0) {
                    try {

                        if (reserva.registrarReserva(idPersona, idDisponibilidad, idMateria, tipoReserva, observacion, cantidadEstudiantes, idGrupoLaboratorio)) {
                            // enviarReserva(idDisponibilidad, "NO", usuario);
                            //envio de correo 
                            ListasDAO l = new ListasDAO();
                            NombreDisponibilidad d = (NombreDisponibilidad) l.getLista("NOMBRES_D", idDisponibilidad, "").get(0);
                            System.out.println("resultado nombres; fecha " + d.getFecha() + " bloque " + d.getBloque() + " laboratorio " + d.getNombreLaboratorio() + " asignatura " + d.getNombreAsignatura());

                            Correo c = new Correo();
                            c.correoReserva(usuario, d.getFecha(), d.getBloque(), d.getNombreLaboratorio(), d.getNombreAsignatura(), d.getNombrePersonaAsignada(), d.getEmailPersonaAsignada());

                            message = new FacesMessage(FacesMessage.SEVERITY_INFO, c.getMessage(), null);
                            FacesContext.getCurrentInstance().addMessage(null, message);
                        }

                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, reserva.getMessage(), null);
                        FacesContext.getCurrentInstance().addMessage(null, message);

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
                        //restringir tipos de reservas!!
                        if (reserva.registrarReserva(Integer.parseInt(id), idDisponibilidad, idMateria, tipoReserva, observacion, cantidadEstudiantes, idGrupoLaboratorio)) {
                            //enviarReserva(idDisponibilidad, "SI", usuario);
                            //envio de correo 
                            ListasDAO l = new ListasDAO();
                            NombreDisponibilidad d = (NombreDisponibilidad) l.getLista("NOMBRES_D", idDisponibilidad, "").get(0);
                            System.out.println("resultado nombres; fecha " + d.getFecha() + " bloque " + d.getBloque() + " laboratorio " + d.getNombreLaboratorio() + " asignatura " + d.getNombreAsignatura());

                            Correo c = new Correo();
                            c.correoReserva(usuario, d.getFecha(), d.getBloque(), d.getNombreLaboratorio(), d.getNombreAsignatura(), d.getNombrePersonaAsignada(), d.getEmailPersonaAsignada());

                            message = new FacesMessage(FacesMessage.SEVERITY_INFO, c.getMessage(), null);
                            FacesContext.getCurrentInstance().addMessage(null, message);

                        }

                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, reserva.getMessage(), null);
                        FacesContext.getCurrentInstance().addMessage(null, message);

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

    @Override
    public void init() {
        System.out.println("cargue listas reserva ");
        System.out.println("");
        ListasDAO listas = new ListasDAO();

        this.setListaD(listas.getLista("LD", Types.INTEGER, null));
        this.setListaL(listas.getLista("LL", Types.INTEGER, null));
        // this.setListaM(listas.getLista("LM",Types.INTEGER,null));

    }

    public void modificarReserva() {

        System.out.println("update id ; " + idPersona + " ; tipo de reserva " + tipoReserva + " ; idmateria " + idMateria + " ; cantidad estudiantes " + cantidadEstudiantes);

        for (ReservaCalendario selectedReserva : selectedReservas) {
            reserva.modificarReserva(idPersona, tipoReserva, idMateria, cantidadEstudiantes, selectedReserva.getIdReserva());
            System.out.println("salida : id " + selectedReserva.getIdReserva() + " ; user " + selectedReserva.getNombreUsuario());
        }
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, reserva.getMessage(), null);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void cargarReservas() {

        setReservasCalendario(reserva.getReservaCalendario(null));

    }

    public void cargarGruposLaboratorio() {
        ListasDAO listas = new ListasDAO();

        if (idLaboratorio != 0) {
            this.setListaG(listas.getLista("LGL", idLaboratorio, null));
        }

    }

    public void cargarMaterias(int idUnidad) {
        System.out.println("listas materias");

        if (idUnidad != 0) {
            ListasDAO listas = new ListasDAO();
            this.setListaM(listas.getLista("LM", idUnidad, null));
        }

    }

    public void cargarCantidad(int id) {
        ListasDAO listas = new ListasDAO();
        ArrayList lab = listas.getLista("LL", Types.INTEGER, null);

        for (Object item : lab) {
            Lista l = (Lista) item;
            if (id == l.getId()) {
                System.out.println(" cantidad " + l.getCantidad());
                cantidadEquipos = l.getCantidad();
            }

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
