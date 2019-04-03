/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.bean;

import com.umb.entities.Lista;
import com.umb.dao.ListasDAO;
import java.io.Serializable;
import java.sql.Types;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "listas")
@ViewScoped
public class Listas implements Serializable {

    //listas:facultades,roles, docentes, laboratorios, materias, unidad academica(programas), asignaturas, grupos laboratorio
    private List<Lista> listaF, listaR, listaD, listaL, listaM, ListaUA, ListaUA2,listaG;

    public List<Lista> getListaG() {
        return listaG;
    }

    public void setListaG(List<Lista> listaG) {
        this.listaG = listaG;
    }

  
    public List<Lista> getListaUA2() {
        return ListaUA2;
    }

    public void setListaUA2(List<Lista> ListaUA2) {
        this.ListaUA2 = ListaUA2;
    }

    public List<Lista> getListaUA() {
        return ListaUA;
    }

    public void setListaUA(List<Lista> ListaUA) {
        this.ListaUA = ListaUA;
    }

    public List<Lista> getListaM() {
        return listaM;
    }

    public void setListaM(List<Lista> listaM) {
        this.listaM = listaM;
    }

    public List<Lista> getListaD() {
        return listaD;
    }

    public void setListaD(List<Lista> listaD) {
        this.listaD = listaD;
    }

    public List<Lista> getListaL() {
        return listaL;
    }

    public void setListaL(List<Lista> listaL) {
        this.listaL = listaL;
    }

    public List<Lista> getListaF() {
        return listaF;
    }

    public void setListaF(List<Lista> listaF) {
        this.listaF = listaF;
    }

    public List<Lista> getListaR() {
        return listaR;
    }

    public void setListaR(List<Lista> listaR) {
        this.listaR = listaR;
    }

    @PostConstruct
    public void init() {
//        System.out.println("listas..");
//        ListasDAO listas = new ListasDAO();
//
//        listaF = listas.getLista("LF", Types.INTEGER,null);
//        listaR = listas.getLista("LR",Types.INTEGER, null);

//        listaD = listas.getLista("LD");
//        listaL = listas.getLista("LL");
    }

    public void listasPrincipales(String param) {

        System.out.println("listas principales... " + param);
        ListasDAO listas = new ListasDAO();
        listaF = listas.getLista("LF", Types.INTEGER, "");
        listaR = listas.getLista("LR", Types.INTEGER, param);
    }

    public void listaUnidadesAcademicas(int facultad, String tipoPrograma) {
        System.out.println("facultad " + facultad);
        System.out.println("tipo " + tipoPrograma);
        ListasDAO listas = new ListasDAO();

        ListaUA = listas.getLista("LUA", facultad, tipoPrograma);

    }

}
