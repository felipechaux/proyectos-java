/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.bean;

import com.umb.dao.CalendarioDAO;
import com.umb.dao.Correo;
import com.umb.entities.BloqueLaboratorio;
import com.umb.entities.Lista;
import com.umb.util.ConexionDB;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "calendario")
@ViewScoped
public class Calendario extends BloqueLaboratorio implements Serializable {

    FacesMessage message;

    private InputStream file;

    private BloqueLaboratorio selectedBloque;

    private List<BloqueLaboratorio> bloques;

    CalendarioDAO bloqueCalendario;

    RequestContext rc;

    public Calendario() {
        bloqueCalendario = new CalendarioDAO();
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        file = event.getFile().getInputstream();

        FacesMessage msg = new FacesMessage("Carga Exitosa ", event.getFile().getFileName() + "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public List<BloqueLaboratorio> getBloques() {
        return bloques;
    }

    public void setBloques(List<BloqueLaboratorio> bloques) {
        this.bloques = bloques;
    }

    public BloqueLaboratorio getSelectedBloque() {
        return selectedBloque;
    }

    public void setSelectedBloque(BloqueLaboratorio selectedBloque) {
        this.selectedBloque = selectedBloque;
    }

    public void cargueMasivo() throws IOException, SQLException, ParseException {

        if (file != null) {
            bloqueCalendario.importar(file);

            FacesMessage msg = new FacesMessage(bloqueCalendario.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //recargar bloques
            init();

        } else {
            FacesMessage msg = new FacesMessage("Sin archivo", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void correo() throws Exception {
        System.out.println("correo!!");
        System.out.println("fecha : " + this.getFecha() + "; bloquei " + this.getBloqueInicio() + "; bloqueF " + this.getBloqueFin() + " lab" + this.getNombreLaboratorio());
        Correo correo = new Correo();
        correo.enviarCorreo(this.getFecha(), this.getBloqueInicio(), this.getNombreLaboratorio());
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, correo.getMessage(), null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void calendar() {
        System.out.println("hola calendar ");
    }

    public String getLabel(List<Lista> list, int idLaboratorio) {
        String label = "";
        System.out.println("id selection "+idLaboratorio);
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i).getId()+" ; valor - "+list.get(i).getValor());
            if(idLaboratorio==list.get(i).getId()){
                System.out.println("valor obtenido "+list.get(i).getValor());
                this.setNombreLaboratorio(list.get(i).getValor());
            }
        }


        return label;
    }

    public void crearBloque() throws Exception {
        rc = RequestContext.getCurrentInstance();
        System.out.println("registro bloque");
        System.out.println("fecha : " + this.getFecha() + "; bloquei " + this.getBloqueInicio() + "; bloqueF " + this.getBloqueFin() + " lab" + this.getNombreLaboratorio());

        if (this.getFecha() != null && this.getBloqueInicio() != null && this.getIdLaboratorio() != 0) {

            if (bloqueCalendario.registrarBloque(this.getFecha(), this.getBloqueInicio(), null, this.getIdLaboratorio())) {

                rc.execute("PF('confirm').show();");
            }

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, bloqueCalendario.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, message);

            //recargar bloques
            init();

        }
    }

    public void modificarBloque() {
        System.out.println("id " + this.getSelectedBloque().getId());
        System.out.println("id lab " + this.getSelectedBloque().getIdLaboratorio());
        System.out.println("modificar lab " + this.getSelectedBloque().getNombreLaboratorio());

        bloqueCalendario.modificarBloque(this.getSelectedBloque().getId(), this.getSelectedBloque().getFecha(), this.getSelectedBloque().getBloqueInicio(), this.getSelectedBloque().getBloqueFin(), this.getSelectedBloque().getIdLaboratorio());
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, bloqueCalendario.getMessage(), null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        //recargar bloques
        init();

    }

    @PostConstruct
    public void init() {
        System.out.println("cargue bloquesDATA ");
        CalendarioDAO bloque = new CalendarioDAO();
        bloques = bloque.getBloques();
    }

    public void verPDF(ActionEvent e) throws Exception {

        System.out.println("generar  ");

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/report1.jasper"));
        Map<String, Object> param = new HashMap<>();
        Connection con = ConexionDB.ConnectDB();
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, con);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        try (ServletOutputStream outStream = response.getOutputStream()) {
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
        }

        FacesContext.getCurrentInstance().responseComplete();

        System.out.println("termina");

    }

    public void exportarExcel(ActionEvent e) throws Exception {

        System.out.println("generar dsds ");

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/report1.jasper"));
        Map<String, Object> param = new HashMap<>();
        Connection con = ConexionDB.ConnectDB();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, con);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.xls");

        ServletOutputStream outStream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

        // exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "D:\\" + "prueba.xls");
//        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//        exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);

        exporter.exportReport();
        //enviar adjunto generado
        outStream.flush();
        // System.out.println("ruta " +response.getHeader("Content-disposition"));
        System.out.println("ruta " + exporter.getStringParameter(JRExporterParameter.OUTPUT_FILE_NAME, outStream.toString()));

        outStream.close();

        FacesContext.getCurrentInstance().responseComplete();

    }

}
