package com.umb.bean;

import com.umb.dao.ReservaDAO;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class ScheduleView extends Reserva implements Serializable {

    private ScheduleModel eventModel;

    private ScheduleEvent event;

    SimpleDateFormat fechaFormat;

    ReservaDAO reserva;

    FacesMessage message = null;

    @Override
    public void init() {
        eventModel = new DefaultScheduleModel();
        event = new DefaultScheduleEvent();
//        eventModel = new DefaultScheduleModel();
//        ReservaDAO a = new ReservaDAO();
//
//        if (a.getDisponibilidadLaboratorio().size() > 0) {
//            for (int i = 0; i < a.getDisponibilidadLaboratorio().size(); i++) {
//                System.out.println("dates " + a.getDisponibilidadLaboratorio().get(i));
//                eventModel.addEvent(new DefaultScheduleEvent("DISPONIBLE", a.getDisponibilidadLaboratorio().get(i), new Date()));
//            }
//
//        }

        System.out.println("init ");
    }

    public void cargarDisponibilidadFechas(int idLaboratorio) {
        //System.out.println("id docente" +this.getIdPersona());
        System.out.println("cargue disponibilidadfechas");
        this.setBloques(null);
        eventModel.clear();
        RequestContext rc = RequestContext.getCurrentInstance();

        if (idLaboratorio != 0) {
            this.setIdLaboratorio(idLaboratorio);

            ReservaDAO d = new ReservaDAO();
            ArrayList<Date> disponibilidad = d.getDisponibilidadLaboratorio(idLaboratorio);

            if (disponibilidad.size() > 0) {
                rc.execute("PF('disponibilidadDialog').show()");
                for (int i = 0; i < disponibilidad.size(); i++) {
                    System.out.println("dates " + disponibilidad.get(i));
                    eventModel.addEvent(new DefaultScheduleEvent("DISPONIBLE", disponibilidad.get(i), new Date()));
                }

            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sin resultados", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }

    }

    public void cargarReservasCalendario() {

        System.out.println("cargue reservasCalendario");

        ReservaDAO d = new ReservaDAO();
        ArrayList<Date> disponibilidad = d.getFechaReservaCalendario();

        if (disponibilidad.size() > 0) {

            for (int i = 0; i < disponibilidad.size(); i++) {
                System.out.println("dates " + disponibilidad.get(i));
                eventModel.addEvent(new DefaultScheduleEvent("RESERVAS", disponibilidad.get(i), new Date()));
            }

        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sin resultados", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public Date getInitialDate() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(ActionEvent actionEvent) {
        System.out.println("add event cargado");
        if (event.getId() == null) {
            eventModel.addEvent(event);

        } else {
            eventModel.updateEvent(event);

        }

    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        //System.out.println("id que llega " + this.getIdLaboratorio());
        if (this.getIdLaboratorio() != 0) {
            fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
            reserva = new ReservaDAO();
            this.setBloques(reserva.getBloqueLaboratorio(fechaFormat.format(event.getStartDate()), this.getIdLaboratorio()));

        }

    }

    public void onEventSelectReservaCalendario(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        System.out.println("started " + event.getStartDate());
        if(event.getStartDate()!=null){
            System.out.println("accion calendario");
            fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
            reserva = new ReservaDAO();
            this.setReservasCalendario(reserva.getReservaCalendario(fechaFormat.format(event.getStartDate())));
        }

    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
