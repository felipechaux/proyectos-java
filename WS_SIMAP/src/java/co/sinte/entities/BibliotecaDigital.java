/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities;

import java.io.InputStream;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DESARROLLO
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BibliotecaDigital {

    @XmlElement
    private Long idBibliotecaDigital;
    @XmlElement
    private String idTipoDocumento,archivo, descripcion, usuarioCreador, usuarioModificador;
    @XmlElement
    private Date fechaCreacion, fechaMoficacion;
    @XmlElement
    private Long pncVersion;
    @XmlElement
    private String documento;

    public BibliotecaDigital() {
    }

    

    public Long getIdBibliotecaDigital() {
        return idBibliotecaDigital;
    }

    public void setIdBibliotecaDigital(Long idBibliotecaDigital) {
        this.idBibliotecaDigital = idBibliotecaDigital;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaMoficacion() {
        return fechaMoficacion;
    }

    public void setFechaMoficacion(Date fechaMoficacion) {
        this.fechaMoficacion = fechaMoficacion;
    }

    public Long getPncVersion() {
        return pncVersion;
    }

    public void setPncVersion(Long pncVersion) {
        this.pncVersion = pncVersion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    
	/*public BibliotecaDigital(Long idBibliotecaDigital,Long idTipoDocumento,String archivo,String descripcion) {
		super();
		
	}*/

   

  
    

}
