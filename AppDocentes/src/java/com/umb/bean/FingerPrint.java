package com.umb.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.suprema.ufe33.*;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.umb.entities.Huella;
import com.umb.dao.FingerPrintDAO;
import com.umb.dao.ReservaDAO;
import com.umb.dao.UsuarioDAO;
import com.umb.entities.BloqueLaboratorio;
import com.umb.entities.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "fingerPrint")
@ViewScoped
public class FingerPrint extends Persona implements Serializable {

    @ManagedProperty("#{usuario}")
    
    private Usuario usuario;

    FingerPrintDAO huella;

    ReservaDAO reserva;

    UFScannerClass libScanner = null;

    UFMatcherClass libMatcher = null;

    FacesMessage ms = null;

    BioMiniJniSDK p = null;

    RequestContext rc;

    ArrayList arrReserva;

    private List<BloqueLaboratorio> bloquesReserva;

    private BloqueLaboratorio selectedBloqueReserva;

    private byte[][] byteTemplateArray = null;

    private int[] intTemplateSizeArray = null;

    private final int MAX_TEMPLATE_SIZE = 384;

    private Pointer hMatcher = null;

    private String id2, observacionPrestamo, nombrePersonaFingerPrint;

    private PointerByReference refTemplateArray = null;

    int tempsize = 0;

    int idPersona;

    boolean respuesta;

    public FingerPrint() {

        reserva = new ReservaDAO();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getObservacionPrestamo() {
        return observacionPrestamo;
    }

    public void setObservacionPrestamo(String observacionPrestamo) {
        this.observacionPrestamo = observacionPrestamo;
    }

    public BloqueLaboratorio getSelectedBloqueReserva() {
        return selectedBloqueReserva;
    }

    public void setSelectedBloqueReserva(BloqueLaboratorio selectedBloqueReserva) {
        this.selectedBloqueReserva = selectedBloqueReserva;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public List<BloqueLaboratorio> getBloquesReserva() {
        return bloquesReserva;
    }

    public void setBloquesReserva(List<BloqueLaboratorio> bloquesReserva) {
        this.bloquesReserva = bloquesReserva;
    }

    public String getNombrePersonaFingerPrint() {
        return nombrePersonaFingerPrint;
    }

    public void setNombrePersonaFingerPrint(String nombrePersonaFingerPrint) {
        this.nombrePersonaFingerPrint = nombrePersonaFingerPrint;
    }

    public Pointer GetCurrentScannerHandle() {
        Pointer hScanner = null;
        int nRes = 0;
        int nNumber = 0;
        try {

            libScanner = (UFScannerClass) Native.loadLibrary("UFScanner", UFScannerClass.class);
            libMatcher = (UFMatcherClass) Native.loadLibrary("UFMatcher", UFMatcherClass.class);
        } catch (Exception ex) {

            System.out.println("loadLlibrary : UFScanner,UFMatcher fail!!");
            System.out.println("loadLlibrary : UFScanner,UFMatcher fail!!");

        }

        PointerByReference refScanner = new PointerByReference();
        IntByReference refScannerNumber = new IntByReference();

//		�Ʒ� success!!//
        nRes = libScanner.UFS_GetScannerNumber(refScannerNumber);

        if (nRes == 0) {

            nNumber = refScannerNumber.getValue();

            if (nNumber <= 0) {

                return null;
            }

        } else {

            return null;
        }
        nRes = libScanner.UFS_GetScannerHandle(0, refScanner);

        hScanner = refScanner.getValue();

        if (nRes == 0 && hScanner != null) {
            return hScanner;
        }
        return null;
    }

    public void iniciar() {
        System.out.println("ini biomini");
        try {

            libScanner = (UFScannerClass) Native.loadLibrary("UFScanner", UFScannerClass.class);
            libMatcher = (UFMatcherClass) Native.loadLibrary("UFMatcher", UFMatcherClass.class);

        } catch (Exception ex) {

            System.out.println("loadLlibrary : UFScanner,UFMatcher fail!!");
            System.out.println("loadLlibrary : UFScanner,UFMatcher fail!!");

            return;
        }
        int nRes = 0;

        nRes = libScanner.UFS_Init();
        initArray(100, 1024);
        if (nRes == 0) {

            System.out.println("UFS_Init() success!!");

            System.out.println("UFS_Init() success,nInitFlag value set 1");
            System.out.println("Scanner Init success!!");
        }
//        demoUFEJavaJNI dmo = new demoUFEJavaJNI();
//        dmo.inicio();

    }

    public void prestamo(int idEncargado) {
        rc = RequestContext.getCurrentInstance();

        System.out.println("prestamo!!, id reserva " + getSelectedBloqueReserva().getId());

        if (reserva.validarPrestamo(getSelectedBloqueReserva().getId(), idEncargado,getSelectedBloqueReserva().getBloqueFin())) {
            //update
            ms = new FacesMessage(FacesMessage.SEVERITY_INFO, reserva.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, ms);
            System.out.println("update");
        } else {

            if (reserva.validarReserva(getSelectedBloqueReserva().getBloqueInicio(),"entrada")) {
                System.out.println(" a tiempo");
                rc.execute("PF('dlg-observacion').show();");
            } else {
                System.out.println(" tarde");
                ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "Bloque no disponible", null);
                FacesContext.getCurrentInstance().addMessage(null, ms);
            }

        }

    }

    public void registrarPrestamo(int idEncargado) {

        System.out.println("registar prestamo con id persona encargado  " + idEncargado);

        rc = RequestContext.getCurrentInstance();
        reserva.registrarPrestamo(getSelectedBloqueReserva().getId(), getSelectedBloqueReserva().getBloqueInicio(), observacionPrestamo, idEncargado);
        ms = new FacesMessage(FacesMessage.SEVERITY_WARN, reserva.getMessage(), null);
        FacesContext.getCurrentInstance().addMessage(null, ms);
        rc.execute("PF('dlg-observacion').hide();PF('dlg-reservas').hide();");
    }
    public String identificar(String param) {
        rc = RequestContext.getCurrentInstance();
        try {

            libScanner = (UFScannerClass) Native.loadLibrary("UFScanner", UFScannerClass.class);
            libMatcher = (UFMatcherClass) Native.loadLibrary("UFMatcher", UFMatcherClass.class);
        } catch (Exception ex) {

            System.out.println("loadLlibrary : UFScanner,UFMatcher fail!!");
            System.out.println("loadLlibrary : UFScanner,UFMatcher fail!!");

            return null;
        }
        PointerByReference refMatcher = new PointerByReference();
        Pointer hScanner = null;
        int nRes = libMatcher.UFM_Create(refMatcher);
        if (nRes == 0) {
            hMatcher = refMatcher.getValue();
        }
        hScanner = GetCurrentScannerHandle();
        if (hScanner == null) {
            System.out.println("getCurrentScannerHandle fail!! ");
            rc.execute("PF('dlg-fingerprint').hide();");
            return null;
        }
        libScanner.UFS_ClearCaptureImageBuffer(hScanner);

        System.out.println("Place a finger");

        nRes = libScanner.UFS_CaptureSingleImage(hScanner);

        if (nRes != 0) {
            System.out.println("capture single image fail!! " + nRes);
            rc.execute("PF('dlg-fingerprint').hide();");
            return null;
        }
        byte[] bTemplate = new byte[512];
        IntByReference refTemplateSize = new IntByReference();

        IntByReference refTemplateQuality = new IntByReference();

        IntByReference refVerify = new IntByReference();

        nRes = libScanner.UFS_Extract(hScanner, bTemplate, refTemplateSize, refTemplateQuality);
        if (nRes == 0) {
            try {
                huella = new FingerPrintDAO();
                for (int i = 0; i < huella.buscarhuella().size(); i++) {
                    Huella h = (Huella) huella.buscarhuella().get(i);
                    //System.out.println("persona " + h.getIdPersona() + " \n tamaños " + h.getTamaño() + "\n huella " + Arrays.toString(h.getHuella()));
                    nRes = libMatcher.UFM_Verify(hMatcher, bTemplate, refTemplateSize.getValue(), h.getHuella(), h.getTamaño(), refVerify);
                    if (nRes == 0) {
                        if (refVerify.getValue() == 1) {
                            System.out.println("hola!! " + h.getNombrePersona());
                            nombrePersonaFingerPrint = h.getNombrePersona();
                            idPersona = h.getIdPersona();
                            respuesta = true;
                            System.out.println("return page ");

                            if (param.equals("login")) {
                                usuario.setSession(true);
                                usuario.setId(String.valueOf(h.getIdPersona()));
                                usuario.setNombreUsuario(h.getNombrePersona());
                                usuario.setUnidadAcademica(h.getIdUnidad());
                                usuario.setNombreRol(h.getNombreRol());

                                if (usuario.getNombreRol().equals("AUXILIAR DE LABORATORIO")) {
                                    return "/pages/fingerprint?faces-redirect=true";
                                } else {
                                    return "/pages/reserva?faces-redirect=true";
                                }

                            }
                            break;
                        } else {
                            respuesta = false;
                            System.out.println("no coincidencia ");

                        }

                    }

                }

                //login
                //
                if (respuesta == true) {

                    //usuario identificado
                    if (!param.equals("login")) {
                        System.out.println("entra a diferente login");
                        arrReserva = new ArrayList<>();
                        arrReserva = reserva.consultarReserva(idPersona);
                        System.out.println("size " + arrReserva.size());

                        if (arrReserva.size() > 0) {
                            ms = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario con reservas ", null);
                            FacesContext.getCurrentInstance().addMessage(null, ms);
                            rc.execute("PF('dlg-reservas').show();");
                            //llenar datatable
                            bloquesReserva = arrReserva;

                        } else {
                            ms = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario sin reservas ", null);
                            FacesContext.getCurrentInstance().addMessage(null, ms);
                        }
                    }

                } else {
                    ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario no identificado", null);
                    FacesContext.getCurrentInstance().addMessage(null, ms);
                }

                rc.execute("PF('dlg-fingerprint').hide();");

            } catch (Exception ex) {
                System.out.println("" + ex.getMessage());
                ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error " + ex.getMessage(), null);
                FacesContext.getCurrentInstance().addMessage(null, ms);
//                rc.execute("PF('dlg-fingerprint').hide();");
            }

        } else {
            System.out.println("extract template fail!! " + nRes);
            ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al escanear " + nRes, null);
            FacesContext.getCurrentInstance().addMessage(null, ms);
            rc.execute("PF('dlg-fingerprint').hide();");

        }
        return "";
    }

    public void initArray(int nArrayCnt, int nMaxTemplateSize) {
        if (byteTemplateArray != null) {
            byteTemplateArray = null;

        }

        if (intTemplateSizeArray != null) {
            intTemplateSizeArray = null;

        }

        byteTemplateArray = new byte[nArrayCnt][MAX_TEMPLATE_SIZE];

        intTemplateSizeArray = new int[nArrayCnt];

        refTemplateArray = new PointerByReference();

    }

    public void enrolar(String id) {
        rc = RequestContext.getCurrentInstance();
        System.out.println("enrolar con id "+id);

        Pointer hScanner = null;

        hScanner = GetCurrentScannerHandle();

        if (hScanner != null) {

            int nRes = libScanner.UFS_ClearCaptureImageBuffer(hScanner);

            System.out.println("place a finger");

            nRes = libScanner.UFS_CaptureSingleImage(hScanner);

            System.out.println("capture single image");

            rc.execute("PF('dlg-fingerprint').hide();");

            if (nRes == 0) {
                byte[] bTemplate = new byte[512];
                IntByReference refTemplateSize = new IntByReference();

                IntByReference refTemplateQuality = new IntByReference();
                try {
                    nRes = libScanner.UFS_Extract(hScanner, bTemplate, refTemplateSize, refTemplateQuality);
                    if (nRes == 0) {

                        System.out.println("save template file template size:" + refTemplateSize.getValue() + " quality:" + refTemplateQuality.getValue());
                        System.out.println("template save " + Arrays.toString(bTemplate));

                        tempsize = refTemplateSize.getValue();

                        if (bTemplate != null && tempsize != 0) {
                            huella = new FingerPrintDAO();

                            huella.enrolar(id, bTemplate, tempsize);
                            ms = new FacesMessage(FacesMessage.SEVERITY_INFO, huella.getMessage(), null);
                            FacesContext.getCurrentInstance().addMessage(null, ms);

                        }
                    }
                } catch (Exception ex) {
                    ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "error " + ex.getMessage(), null);
                    FacesContext.getCurrentInstance().addMessage(null, ms);
                    rc.execute("PF('dlg-fingerprint').hide();");
                }
            }
        } else {
            rc.execute("PF('dlg-fingerprint').hide();");
        }
    }

    public void crearCuenta() {
        rc = RequestContext.getCurrentInstance();

        System.out.println("Crear cuenta  ");

        if (this.getNombreUsuario() != null && this.getId() != null && this.getClave() != null && this.getRol() != 0) {
            System.out.println("INSERT");
            try {
                UsuarioDAO crear = new UsuarioDAO();

                if (crear.registrarUsuario(this.getId(), this.getClave(), this.getNombreUsuario(), this.getUnidadAcademica(), this.getRol()) == true) {
                    rc.execute("finger('crear')");

                }
                ms = new FacesMessage(FacesMessage.SEVERITY_INFO, crear.getMessage(), null);
                FacesContext.getCurrentInstance().addMessage(null, ms);
                rc.execute("PF('dlg-usuario').hide()");

            } catch (Exception e) {
                ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "error " + e.getMessage(), null);
                FacesContext.getCurrentInstance().addMessage(null, ms);
                rc.execute("PF('dlg-usuario').hide()");
            }

        }
    }

    public void consultarUsuario() {
        System.out.println("consultaUsuario  " + id2);
        if (id2 != null) {
            try {
                UsuarioDAO u = new UsuarioDAO();

                if (u.consultar(id2) == true) {
                    System.out.println("si existe ");
                    RequestContext rc = RequestContext.getCurrentInstance();
                    rc.execute("finger('enrol')");

                } else {
                    ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "No existe la cuenta", null);
                    FacesContext.getCurrentInstance().addMessage(null, ms);
                }
            } catch (Exception e) {
                ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "error " + e.getMessage(), null);
                FacesContext.getCurrentInstance().addMessage(null, ms);
            }

        }
    }

    public void pro() {
        System.out.println("prueba ajax");
    }

}

