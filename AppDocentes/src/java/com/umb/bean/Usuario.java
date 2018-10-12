/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.bean;

import com.umb.dao.UsuarioDAO;
import com.umb.entities.Persona;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "usuario")
@SessionScoped
public class Usuario extends Persona implements Serializable {

    FacesMessage message = null;

    ArrayList arrUsuario;

    UsuarioDAO usuario;

    private String url;

    private boolean permiso, permiso2,permiso3;

    public Usuario() {
        usuario = new UsuarioDAO();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPermiso3() {
        return permiso3;
    }

    public void setPermiso3(boolean permiso3) {
        this.permiso3 = permiso3;
    }

    public boolean isPermiso() {
        return permiso;
    }

    public void setPermiso(boolean permiso) {
        this.permiso = permiso;
    }

    public boolean isPermiso2() {
        return permiso2;
    }

    public void setPermiso2(boolean permiso2) {
        this.permiso2 = permiso2;
    }

    public void crearCuenta() {
        RequestContext rc = RequestContext.getCurrentInstance();

        if (this.getNombreUsuario() != null  && this.getId() != null && this.getClave() != null && this.getRol() != 0 && this.getEmail()!=null) {
            System.out.println("INSERT");
            try { //this.getTipoCargo()
                usuario.registrarUsuario(this.getId(), this.getClave(), this.getNombreUsuario(), this.getUnidadAcademica(), this.getRol(),this.getEmail());
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, usuario.getMessage(), null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                rc.execute("PF('dlg-usuario').hide()");
            } catch (Exception e) {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "error " + e.getMessage(), null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                // rc.execute("PF('dlg-usuario').hide()");
            }

        }
    }

    public void modificarCuenta() {
        System.out.println("modificar id " + this.getId());
        System.out.println("pass " + this.getClave());
        System.out.println("nombre " + this.getNombreUsuario());
        usuario.modificarUsuario(this.getId(), this.getClave(), this.getNombreUsuario(),this.getEmail());
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, usuario.getMessage(), null);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public String autenticar() throws InterruptedException {

        System.out.println("aunte");
        if (this.getId() != null && this.getClave() != null) {
            UsuarioDAO login = new UsuarioDAO();

            try {
                arrUsuario = new ArrayList();
                arrUsuario = login.autenticar(this.getId(), this.getClave());
                // System.out.println("sise " + arrUsuario.size());
                if (arrUsuario.size() > 0) {
                    //permisos roles
                    this.setSession(true);
                    Persona usr = (Persona) arrUsuario.get(0);
                    //this.setId(usr.getId());
                    this.setNombreUsuario(usr.getNombreUsuario());
                    this.setUnidadAcademica(usr.getUnidadAcademica());
                    this.setNombreRol(usr.getNombreRol());
                    this.setEmail(usr.getEmail());
                    this.setNombreUnidadAcademica(usr.getNombreUnidadAcademica());
                    
                    if (this.getNombreRol().equals("AUXILIAR DE LABORATORIO")) {
                        return "/pages/fingerprint?faces-redirect=true";
                    } else {

                        return "/pages/reserva?faces-redirect=true";
                    }

                } else {
                    this.setSession(false);
                    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales invalidas", null);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    return null;
                }
            } catch (Exception e) {
                System.out.println("Excepcion " + e.getMessage());
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "" + e.getMessage() + " " + login.getMessage(), null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }

        }

        return "index";
    }
    

    public String salir() {
        System.out.println("Log off");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public void validarSession() throws IOException {

        System.out.println("session -> " + this.isSession() + " nombrerol " + this.getNombreRol());
        if (this.isSession() == false) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("/AppDocentes/faces/index.xhtml");

        } else {
            //permisos
            switch (this.getNombreRol()) {
                case "DIRECTOR":
                    permiso3=true;
                    break;
                case "COORDINADOR":
                    System.out.println("permisos all");
                    permiso = true;
                    url = "../pages/reserva.xhtml?faces-redirect=true";
                    break;
                case "AUXILIAR DE LABORATORIO":
                    permiso = false;
                    permiso2=true;
                    url = "../pages/fingerprint.xhtml?faces-redirect=true";
                    break;
                case "DOCENTE":
                    permiso = false;
                    permiso2=false;
                    permiso3=false;
                    System.out.println("permisos1 "+permiso+" permiso2 "+permiso2+" permiso3 "+permiso3);
                    url = "../pages/reserva.xhtml?faces-redirect=true";
                    break;
            }

        }
    }

}
