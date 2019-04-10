/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities.Listas.riesgos;

import java.util.List;
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
public class Riesgos {

    @XmlElement
    private List<COABOAngulo> coaboangulo;
    @XmlElement
    private List<COABOArea> coaboarea;
    @XmlElement
    private List<COABOArtNvg> coaboartnvg;
    @XmlElement
    private List<COABOBase> coabobase;
    @XmlElement
    private List<COABOClaseVuelo> coaboclasevuelo;
    @XmlElement
    private List<COABOCondiciones> coabocondiciones;
    @XmlElement
    private List<COABOControl> coabocontrol;
    @XmlElement
    private List<COABODescanso> coabodescanso;
    @XmlElement
    private List<COABODyn> coabodyn;
    @XmlElement
    private List<COABOHorasPcNvg> coabohoraspcnvg;
    @XmlElement
    private List<COABOHorasPiNvg> coabohoraspinvg;
    @XmlElement
    private List<COABOHorasTrabajadas> coabohorastrabajadas;
    @XmlElement
    private List<COABOInformacion> coaboinformacion;
    @XmlElement
    private List<COABOInstrumentos> coaboinstrumentos;
    @XmlElement
    private List<COABOMando> coabomando;
    @XmlElement
    private List<COABOMotoresFactopo> coabomotoresfactopo;
    @XmlElement
    private List<COABONivelHostilidad> coabonivelhostilidad;
    @XmlElement
    private List<COABONivelPc> coabonivelpc;
    @XmlElement
    private List<COABONivelPi> coabonivelpi;
    @XmlElement
    private List<COABONivelTm> coaboniveltm;
    @XmlElement
    private List<COABOPorcentaje> coaboporcentaje;
    @XmlElement
    private List<COABOTechoVisual> coabotechovisual;
    @XmlElement
    private List<COABOTerrenosFactopo> coaboterrenosfactopo;
    @XmlElement
    private List<COABOTipoMision> coabotipomision;
    @XmlElement
    private List<COABOTipoPista> coabotipopista;
    @XmlElement
    private List<COABOTripulacionEjecucionMision> coabotripulacionejecucionmision;
    @XmlElement
    private List<COABOTripulacionPcHorasEquipo> coabotripulacionpchorasequipo;
    @XmlElement
    private List<COABOTripulacionPcHorasTotales> coabotripulacionpchorastotales;
    @XmlElement
    private List<COABOTripulacionPiHorasEquipo> coabotripulacionpihorasequipo;
    @XmlElement
    private List<COABOTripulacionPiHorasTotales> coabotripulacionpihorastotales;
    @XmlElement
    private List<COABOTripulacionTmHorasEquipo> coabotripulaciontmhorasequipo;
    @XmlElement
    private List<COABOTripulacionTmHorasTotales> coabotripulaciontmhorastotales;
    @XmlElement
    private List<COAGYArea> coagyarea;
    @XmlElement
    private List<COAGYBase> coagybase;
    @XmlElement
    private List<COAGYCategoria> coagycategoria;
    @XmlElement
    private List<COAGYClaseVuelo> coagyclasevuelo;
    @XmlElement
    private List<COAGYCondiciones> coagycondiciones;
    @XmlElement
    private List<COAGYControl> coagycontrol;
    @XmlElement
    private List<COAGYDescanso> coagydescanso;
    @XmlElement
    private List<COAGYDias> coagydias;
    @XmlElement
    private List<COAGYDyn> coagydyn;
    @XmlElement
    private List<COAGYHorasEquipoTripulacionPc> coagyhorasequipotripulacionpc;
    @XmlElement
    private List<COAGYHorasEquipoTripulacionPi> coagyhorasequipotripulacionpi;
    @XmlElement
    private List<COAGYHorasEquipoTripulacionTec> coagyhorasequipotripulaciontec;
    @XmlElement
    private List<COAGYHorasTotalesTripulacionPc> coagyhorastotalestripulacionpc;
    @XmlElement
    private List<COAGYHorasTotalesTripulacionPi> coagyhorastotalestripulacionpi;
    @XmlElement
    private List<COAGYHorasTotalesTripulacionTec> coagyhorastotalestripulaciontec;
    @XmlElement
    private List<COAGYHorasTrabajadas> coagyhorastrabajadas;
    @XmlElement
    private List<COAGYInformacion> coagyinformacion;
    @XmlElement
    private List<COAGYInstrumentos> coagyinstrumentos;
    @XmlElement
    private List<COAGYLimites> coagylimites;
    @XmlElement
    private List<COAGYMando> coagymando;
    @XmlElement
    private List<COAGYMotor> coagymotor;
    @XmlElement
    private List<COAGYNivel> coagynivel;
    @XmlElement
    private List<COAGYPlan> coagyplan;
    @XmlElement
    private List<COAGYSyn> coagysyn;
    @XmlElement
    private List<COAGYTechoVisual> coagytechovisual;
    @XmlElement
    private List<COAGYTerrenoAproximacion> coagyterrenoaproximacion;
    @XmlElement
    private List<COAGYTerrenoDespegue> coagyterrenodespegue;
    @XmlElement
    private List<COAGYTerrenoReconocimiento> coagyterrenoreconocimiento;
    @XmlElement
    private List<COAGYTerrenoRuta> coagyterrenoruta;
    @XmlElement
    private List<COAGYTipoMision> coagytipomision;
    @XmlElement
    private List<COAGYTipoPista> coagytipopista;
    @XmlElement
    private List<EAFYARAngulo> eafyarangulo;
    @XmlElement
    private List<EAFYARAreaVuelo> eafyarareavuelo;
    @XmlElement
    private List<EAFYARAterrizaje> eafyaraterrizaje;
    @XmlElement
    private List<EAFYARBase> eafyarbase;
    @XmlElement
    private List<EAFYARClaseVuelo> eafyarclasevuelo;
    @XmlElement
    private List<EAFYARDescanso> eafyardescanso;
    @XmlElement
    private List<EAFYARDias> eafyardias;
    @XmlElement
    private List<EAFYAREntrenamiento> eafyarentrenamiento;
    @XmlElement
    private List<EAFYARHorasAreaOperaciones> eafyarhorasareaoperaciones;
    @XmlElement
    private List<EAFYARHorasEquipo> eafyarhorasequipo;
    @XmlElement
    private List<EAFYARHorasPilotoEstudianteLvn> eafyarhoraspilotoestudiantelvn;
    @XmlElement
    private List<EAFYARHorasPilotoInstructorLvn> eafyarhoraspilotoinstructorlvn;
    @XmlElement
    private List<EAFYARHorasPinPilotoInstructor> eafyarhoraspinpilotoinstructor;
    @XmlElement
    private List<EAFYARHorasTotalesPilotoEstudiante> eafyarhorastotalespilotoestudiante;
    @XmlElement
    private List<EAFYARHorasTotalesPilotoInstructor> eafyarhorastotalespilotoinstructor;
    @XmlElement
    private List<EAFYARHorasTotalesTsac> eafyarhorastotalestsac;
    @XmlElement
    private List<EAFYARHorasTrabajadas> eafyarhorastrabajadas;
    @XmlElement
    private List<EAFYARHorasTsacLvn> eafyarhorastsaclvn;
    @XmlElement
    private List<EAFYARInformacion> eafyarinformacion;
    @XmlElement
    private List<EAFYARMando> eafyarmando;
    @XmlElement
    private List<EAFYARModo> eafyarmodo;
    @XmlElement
    private List<EAFYARNivel> eafyarnivel;
    @XmlElement
    private List<EAFYARNp> eafyarnp;
    @XmlElement
    private List<EAFYARPlan> eafyarplan;
    @XmlElement
    private List<EAFYARPorcentaje> eafyarporcentaje;
    @XmlElement
    private List<EAFYARTechoVisual> eafyartechovisual;
    @XmlElement
    private List<EAFYARTerrenoInstruccion> eafyarterrenoinstruccion;
    @XmlElement
    private List<EAFYARTerrenoRuta> eafyarterrenoruta;
    @XmlElement
    private List<RALARAngulo> ralarangulo;
    @XmlElement
    private List<RALARArea> ralararea;
    @XmlElement
    private List<RALARBase> ralarbase;
    @XmlElement
    private List<RALARCav> ralarcav;
    @XmlElement
    private List<RALARClaseVuelo> ralarclasevuelo;
    @XmlElement
    private List<RALARDescanso> ralardescanso;
    @XmlElement
    private List<RALARDias> ralardias;
    @XmlElement
    private List<RALARHorasCopilotoLvn> ralarhorascopilotolvn;
    @XmlElement
    private List<RALARHorasEquipoCopiloto> ralarhorasequipocopiloto;
    @XmlElement
    private List<RALARHorasEquipoPiloto> ralarhorasequipopiloto;
    @XmlElement
    private List<RALARHorasEquipoTsac> ralarhorasequipotsac;
    @XmlElement
    private List<RALARHorasPilotoLvn> ralarhoraspilotolvn;
    @XmlElement
    private List<RALARHorasTotalesCopiloto> ralarhorastotalescopiloto;
    @XmlElement
    private List<RALARHorasTotalesPiloto> ralarhorastotalespiloto;
    @XmlElement
    private List<RALARHorasTotalesTsac> ralarhorastotalestsac;
    @XmlElement
    private List<RALARHorasTrabajadas> ralarhorastrabajadas;
    @XmlElement
    private List<RALARHorasTsacLvn> ralarhorastsaclvn;
    @XmlElement
    private List<RALARInformacion> ralarinformacion;
    @XmlElement
    private List<RALARMando> ralarmando;
    @XmlElement
    private List<RALARModo> ralarmodo;
    @XmlElement
    private List<RALARNivel> ralarnivel;
    @XmlElement
    private List<RALARPlan> ralarplan;
    @XmlElement
    private List<RALARPorcentaje> ralarporcentaje;
    @XmlElement
    private List<RALARTechoVisual> ralartechovisual;
    @XmlElement
    private List<RALARTerrenosFacamb> ralarterrenosfacamb;
    @XmlElement
    private List<RALARTipoMision> ralartipomision;
    @XmlElement
    private List<VPRARBaseHT> vprarbaseht;
    @XmlElement
    private List<VPRARBaseRendTrip> vprarbaserendtrip;
    @XmlElement
    private List<VPRARComplejidad> vprarcomplejidad;
    @XmlElement
    private List<VPRARDescanso> vprardescanso;
    @XmlElement
    private List<VPRARDiasEnTierra> vprardiasentierra;
    @XmlElement
    private List<VPRARDiasUltimoMtf> vprardiasultimomtf;
    @XmlElement
    private List<VPRARExperiencia> vprarexperiencia;
    @XmlElement
    private List<VPRARHoras> vprarhoras;
    @XmlElement
    private List<VPRARHorasExpMp> vprarhorasexpmp;
    @XmlElement
    private List<VPRARHorasTrabajadas> vprarhorastrabajadas;
    @XmlElement
    private List<VPRARLocalidad> vprarlocalidad;
    @XmlElement
    private List<VPRARMantenimiento> vprarmantenimiento;
    @XmlElement
    private List<VPRARNoDeTecMec> vprarnodetecmec;
    @XmlElement
    private List<VPRARNumeroDeTecnicos> vprarnumerodetecnicos;
    @XmlElement
    private List<VPRARTechoVisual> vprartechovisual;
    @XmlElement
    private List<VPRARTemperatura> vprartemperatura;
    @XmlElement
    private List<VPRARViento> vprarviento;

    public List<COABOAngulo> getCoaboangulo() {
        return coaboangulo;
    }

    public void setCoaboangulo(List<COABOAngulo> coaboangulo) {
        this.coaboangulo = coaboangulo;
    }

    public List<COABOArea> getCoaboarea() {
        return coaboarea;
    }

    public void setCoaboarea(List<COABOArea> coaboarea) {
        this.coaboarea = coaboarea;
    }

    public List<COABOArtNvg> getCoaboartnvg() {
        return coaboartnvg;
    }

    public void setCoaboartnvg(List<COABOArtNvg> coaboartnvg) {
        this.coaboartnvg = coaboartnvg;
    }

    public List<COABOBase> getCoabobase() {
        return coabobase;
    }

    public void setCoabobase(List<COABOBase> coabobase) {
        this.coabobase = coabobase;
    }

    public List<COABOClaseVuelo> getCoaboclasevuelo() {
        return coaboclasevuelo;
    }

    public void setCoaboclasevuelo(List<COABOClaseVuelo> coaboclasevuelo) {
        this.coaboclasevuelo = coaboclasevuelo;
    }

    public List<COABOCondiciones> getCoabocondiciones() {
        return coabocondiciones;
    }

    public void setCoabocondiciones(List<COABOCondiciones> coabocondiciones) {
        this.coabocondiciones = coabocondiciones;
    }

    public List<COABOControl> getCoabocontrol() {
        return coabocontrol;
    }

    public void setCoabocontrol(List<COABOControl> coabocontrol) {
        this.coabocontrol = coabocontrol;
    }

    public List<COABODescanso> getCoabodescanso() {
        return coabodescanso;
    }

    public void setCoabodescanso(List<COABODescanso> coabodescanso) {
        this.coabodescanso = coabodescanso;
    }

    public List<COABODyn> getCoabodyn() {
        return coabodyn;
    }

    public void setCoabodyn(List<COABODyn> coabodyn) {
        this.coabodyn = coabodyn;
    }

    public List<COABOHorasPcNvg> getCoabohoraspcnvg() {
        return coabohoraspcnvg;
    }

    public void setCoabohoraspcnvg(List<COABOHorasPcNvg> coabohoraspcnvg) {
        this.coabohoraspcnvg = coabohoraspcnvg;
    }

    public List<COABOHorasPiNvg> getCoabohoraspinvg() {
        return coabohoraspinvg;
    }

    public void setCoabohoraspinvg(List<COABOHorasPiNvg> coabohoraspinvg) {
        this.coabohoraspinvg = coabohoraspinvg;
    }

    public List<COABOHorasTrabajadas> getCoabohorastrabajadas() {
        return coabohorastrabajadas;
    }

    public void setCoabohorastrabajadas(List<COABOHorasTrabajadas> coabohorastrabajadas) {
        this.coabohorastrabajadas = coabohorastrabajadas;
    }

    public List<COABOInformacion> getCoaboinformacion() {
        return coaboinformacion;
    }

    public void setCoaboinformacion(List<COABOInformacion> coaboinformacion) {
        this.coaboinformacion = coaboinformacion;
    }

    public List<COABOInstrumentos> getCoaboinstrumentos() {
        return coaboinstrumentos;
    }

    public void setCoaboinstrumentos(List<COABOInstrumentos> coaboinstrumentos) {
        this.coaboinstrumentos = coaboinstrumentos;
    }

    public List<COABOMando> getCoabomando() {
        return coabomando;
    }

    public void setCoabomando(List<COABOMando> coabomando) {
        this.coabomando = coabomando;
    }

    public List<COABOMotoresFactopo> getCoabomotoresfactopo() {
        return coabomotoresfactopo;
    }

    public void setCoabomotoresfactopo(List<COABOMotoresFactopo> coabomotoresfactopo) {
        this.coabomotoresfactopo = coabomotoresfactopo;
    }

    public List<COABONivelHostilidad> getCoabonivelhostilidad() {
        return coabonivelhostilidad;
    }

    public void setCoabonivelhostilidad(List<COABONivelHostilidad> coabonivelhostilidad) {
        this.coabonivelhostilidad = coabonivelhostilidad;
    }

    public List<COABONivelPc> getCoabonivelpc() {
        return coabonivelpc;
    }

    public void setCoabonivelpc(List<COABONivelPc> coabonivelpc) {
        this.coabonivelpc = coabonivelpc;
    }

    public List<COABONivelPi> getCoabonivelpi() {
        return coabonivelpi;
    }

    public void setCoabonivelpi(List<COABONivelPi> coabonivelpi) {
        this.coabonivelpi = coabonivelpi;
    }

    public List<COABONivelTm> getCoaboniveltm() {
        return coaboniveltm;
    }

    public void setCoaboniveltm(List<COABONivelTm> coaboniveltm) {
        this.coaboniveltm = coaboniveltm;
    }

    public List<COABOPorcentaje> getCoaboporcentaje() {
        return coaboporcentaje;
    }

    public void setCoaboporcentaje(List<COABOPorcentaje> coaboporcentaje) {
        this.coaboporcentaje = coaboporcentaje;
    }

    public List<COABOTechoVisual> getCoabotechovisual() {
        return coabotechovisual;
    }

    public void setCoabotechovisual(List<COABOTechoVisual> coabotechovisual) {
        this.coabotechovisual = coabotechovisual;
    }

    public List<COABOTerrenosFactopo> getCoaboterrenosfactopo() {
        return coaboterrenosfactopo;
    }

    public void setCoaboterrenosfactopo(List<COABOTerrenosFactopo> coaboterrenosfactopo) {
        this.coaboterrenosfactopo = coaboterrenosfactopo;
    }

    public List<COABOTipoMision> getCoabotipomision() {
        return coabotipomision;
    }

    public void setCoabotipomision(List<COABOTipoMision> coabotipomision) {
        this.coabotipomision = coabotipomision;
    }

    public List<COABOTipoPista> getCoabotipopista() {
        return coabotipopista;
    }

    public void setCoabotipopista(List<COABOTipoPista> coabotipopista) {
        this.coabotipopista = coabotipopista;
    }

    public List<COABOTripulacionEjecucionMision> getCoabotripulacionejecucionmision() {
        return coabotripulacionejecucionmision;
    }

    public void setCoabotripulacionejecucionmision(List<COABOTripulacionEjecucionMision> coabotripulacionejecucionmision) {
        this.coabotripulacionejecucionmision = coabotripulacionejecucionmision;
    }

    public List<COABOTripulacionPcHorasEquipo> getCoabotripulacionpchorasequipo() {
        return coabotripulacionpchorasequipo;
    }

    public void setCoabotripulacionpchorasequipo(List<COABOTripulacionPcHorasEquipo> coabotripulacionpchorasequipo) {
        this.coabotripulacionpchorasequipo = coabotripulacionpchorasequipo;
    }

    public List<COABOTripulacionPcHorasTotales> getCoabotripulacionpchorastotales() {
        return coabotripulacionpchorastotales;
    }

    public void setCoabotripulacionpchorastotales(List<COABOTripulacionPcHorasTotales> coabotripulacionpchorastotales) {
        this.coabotripulacionpchorastotales = coabotripulacionpchorastotales;
    }

    public List<COABOTripulacionPiHorasEquipo> getCoabotripulacionpihorasequipo() {
        return coabotripulacionpihorasequipo;
    }

    public void setCoabotripulacionpihorasequipo(List<COABOTripulacionPiHorasEquipo> coabotripulacionpihorasequipo) {
        this.coabotripulacionpihorasequipo = coabotripulacionpihorasequipo;
    }

    public List<COABOTripulacionPiHorasTotales> getCoabotripulacionpihorastotales() {
        return coabotripulacionpihorastotales;
    }

    public void setCoabotripulacionpihorastotales(List<COABOTripulacionPiHorasTotales> coabotripulacionpihorastotales) {
        this.coabotripulacionpihorastotales = coabotripulacionpihorastotales;
    }

    public List<COABOTripulacionTmHorasEquipo> getCoabotripulaciontmhorasequipo() {
        return coabotripulaciontmhorasequipo;
    }

    public void setCoabotripulaciontmhorasequipo(List<COABOTripulacionTmHorasEquipo> coabotripulaciontmhorasequipo) {
        this.coabotripulaciontmhorasequipo = coabotripulaciontmhorasequipo;
    }

    public List<COABOTripulacionTmHorasTotales> getCoabotripulaciontmhorastotales() {
        return coabotripulaciontmhorastotales;
    }

    public void setCoabotripulaciontmhorastotales(List<COABOTripulacionTmHorasTotales> coabotripulaciontmhorastotales) {
        this.coabotripulaciontmhorastotales = coabotripulaciontmhorastotales;
    }

    public List<COAGYArea> getCoagyarea() {
        return coagyarea;
    }

    public void setCoagyarea(List<COAGYArea> coagyarea) {
        this.coagyarea = coagyarea;
    }

    public List<COAGYBase> getCoagybase() {
        return coagybase;
    }

    public void setCoagybase(List<COAGYBase> coagybase) {
        this.coagybase = coagybase;
    }

    public List<COAGYCategoria> getCoagycategoria() {
        return coagycategoria;
    }

    public void setCoagycategoria(List<COAGYCategoria> coagycategoria) {
        this.coagycategoria = coagycategoria;
    }

    public List<COAGYClaseVuelo> getCoagyclasevuelo() {
        return coagyclasevuelo;
    }

    public void setCoagyclasevuelo(List<COAGYClaseVuelo> coagyclasevuelo) {
        this.coagyclasevuelo = coagyclasevuelo;
    }

    public List<COAGYCondiciones> getCoagycondiciones() {
        return coagycondiciones;
    }

    public void setCoagycondiciones(List<COAGYCondiciones> coagycondiciones) {
        this.coagycondiciones = coagycondiciones;
    }

    public List<COAGYControl> getCoagycontrol() {
        return coagycontrol;
    }

    public void setCoagycontrol(List<COAGYControl> coagycontrol) {
        this.coagycontrol = coagycontrol;
    }

    public List<COAGYDescanso> getCoagydescanso() {
        return coagydescanso;
    }

    public void setCoagydescanso(List<COAGYDescanso> coagydescanso) {
        this.coagydescanso = coagydescanso;
    }

    public List<COAGYDias> getCoagydias() {
        return coagydias;
    }

    public void setCoagydias(List<COAGYDias> coagydias) {
        this.coagydias = coagydias;
    }

    public List<COAGYDyn> getCoagydyn() {
        return coagydyn;
    }

    public void setCoagydyn(List<COAGYDyn> coagydyn) {
        this.coagydyn = coagydyn;
    }

    public List<COAGYHorasEquipoTripulacionPc> getCoagyhorasequipotripulacionpc() {
        return coagyhorasequipotripulacionpc;
    }

    public void setCoagyhorasequipotripulacionpc(List<COAGYHorasEquipoTripulacionPc> coagyhorasequipotripulacionpc) {
        this.coagyhorasequipotripulacionpc = coagyhorasequipotripulacionpc;
    }

    public List<COAGYHorasEquipoTripulacionPi> getCoagyhorasequipotripulacionpi() {
        return coagyhorasequipotripulacionpi;
    }

    public void setCoagyhorasequipotripulacionpi(List<COAGYHorasEquipoTripulacionPi> coagyhorasequipotripulacionpi) {
        this.coagyhorasequipotripulacionpi = coagyhorasequipotripulacionpi;
    }

    public List<COAGYHorasEquipoTripulacionTec> getCoagyhorasequipotripulaciontec() {
        return coagyhorasequipotripulaciontec;
    }

    public void setCoagyhorasequipotripulaciontec(List<COAGYHorasEquipoTripulacionTec> coagyhorasequipotripulaciontec) {
        this.coagyhorasequipotripulaciontec = coagyhorasequipotripulaciontec;
    }

    public List<COAGYHorasTotalesTripulacionPc> getCoagyhorastotalestripulacionpc() {
        return coagyhorastotalestripulacionpc;
    }

    public void setCoagyhorastotalestripulacionpc(List<COAGYHorasTotalesTripulacionPc> coagyhorastotalestripulacionpc) {
        this.coagyhorastotalestripulacionpc = coagyhorastotalestripulacionpc;
    }

    public List<COAGYHorasTotalesTripulacionPi> getCoagyhorastotalestripulacionpi() {
        return coagyhorastotalestripulacionpi;
    }

    public void setCoagyhorastotalestripulacionpi(List<COAGYHorasTotalesTripulacionPi> coagyhorastotalestripulacionpi) {
        this.coagyhorastotalestripulacionpi = coagyhorastotalestripulacionpi;
    }

    public List<COAGYHorasTotalesTripulacionTec> getCoagyhorastotalestripulaciontec() {
        return coagyhorastotalestripulaciontec;
    }

    public void setCoagyhorastotalestripulaciontec(List<COAGYHorasTotalesTripulacionTec> coagyhorastotalestripulaciontec) {
        this.coagyhorastotalestripulaciontec = coagyhorastotalestripulaciontec;
    }

    public List<COAGYHorasTrabajadas> getCoagyhorastrabajadas() {
        return coagyhorastrabajadas;
    }

    public void setCoagyhorastrabajadas(List<COAGYHorasTrabajadas> coagyhorastrabajadas) {
        this.coagyhorastrabajadas = coagyhorastrabajadas;
    }

    public List<COAGYInformacion> getCoagyinformacion() {
        return coagyinformacion;
    }

    public void setCoagyinformacion(List<COAGYInformacion> coagyinformacion) {
        this.coagyinformacion = coagyinformacion;
    }

    public List<COAGYInstrumentos> getCoagyinstrumentos() {
        return coagyinstrumentos;
    }

    public void setCoagyinstrumentos(List<COAGYInstrumentos> coagyinstrumentos) {
        this.coagyinstrumentos = coagyinstrumentos;
    }

    public List<COAGYLimites> getCoagylimites() {
        return coagylimites;
    }

    public void setCoagylimites(List<COAGYLimites> coagylimites) {
        this.coagylimites = coagylimites;
    }

    public List<COAGYMando> getCoagymando() {
        return coagymando;
    }

    public void setCoagymando(List<COAGYMando> coagymando) {
        this.coagymando = coagymando;
    }

    public List<COAGYMotor> getCoagymotor() {
        return coagymotor;
    }

    public void setCoagymotor(List<COAGYMotor> coagymotor) {
        this.coagymotor = coagymotor;
    }

    public List<COAGYNivel> getCoagynivel() {
        return coagynivel;
    }

    public void setCoagynivel(List<COAGYNivel> coagynivel) {
        this.coagynivel = coagynivel;
    }

    public List<COAGYPlan> getCoagyplan() {
        return coagyplan;
    }

    public void setCoagyplan(List<COAGYPlan> coagyplan) {
        this.coagyplan = coagyplan;
    }

    public List<COAGYSyn> getCoagysyn() {
        return coagysyn;
    }

    public void setCoagysyn(List<COAGYSyn> coagysyn) {
        this.coagysyn = coagysyn;
    }

    public List<COAGYTechoVisual> getCoagytechovisual() {
        return coagytechovisual;
    }

    public void setCoagytechovisual(List<COAGYTechoVisual> coagytechovisual) {
        this.coagytechovisual = coagytechovisual;
    }

    public List<COAGYTerrenoAproximacion> getCoagyterrenoaproximacion() {
        return coagyterrenoaproximacion;
    }

    public void setCoagyterrenoaproximacion(List<COAGYTerrenoAproximacion> coagyterrenoaproximacion) {
        this.coagyterrenoaproximacion = coagyterrenoaproximacion;
    }

    public List<COAGYTerrenoDespegue> getCoagyterrenodespegue() {
        return coagyterrenodespegue;
    }

    public void setCoagyterrenodespegue(List<COAGYTerrenoDespegue> coagyterrenodespegue) {
        this.coagyterrenodespegue = coagyterrenodespegue;
    }

    public List<COAGYTerrenoReconocimiento> getCoagyterrenoreconocimiento() {
        return coagyterrenoreconocimiento;
    }

    public void setCoagyterrenoreconocimiento(List<COAGYTerrenoReconocimiento> coagyterrenoreconocimiento) {
        this.coagyterrenoreconocimiento = coagyterrenoreconocimiento;
    }

    public List<COAGYTerrenoRuta> getCoagyterrenoruta() {
        return coagyterrenoruta;
    }

    public void setCoagyterrenoruta(List<COAGYTerrenoRuta> coagyterrenoruta) {
        this.coagyterrenoruta = coagyterrenoruta;
    }

    public List<COAGYTipoMision> getCoagytipomision() {
        return coagytipomision;
    }

    public void setCoagytipomision(List<COAGYTipoMision> coagytipomision) {
        this.coagytipomision = coagytipomision;
    }

    public List<COAGYTipoPista> getCoagytipopista() {
        return coagytipopista;
    }

    public void setCoagytipopista(List<COAGYTipoPista> coagytipopista) {
        this.coagytipopista = coagytipopista;
    }

    public List<EAFYARAngulo> getEafyarangulo() {
        return eafyarangulo;
    }

    public void setEafyarangulo(List<EAFYARAngulo> eafyarangulo) {
        this.eafyarangulo = eafyarangulo;
    }

    public List<EAFYARAreaVuelo> getEafyarareavuelo() {
        return eafyarareavuelo;
    }

    public void setEafyarareavuelo(List<EAFYARAreaVuelo> eafyarareavuelo) {
        this.eafyarareavuelo = eafyarareavuelo;
    }

    public List<EAFYARAterrizaje> getEafyaraterrizaje() {
        return eafyaraterrizaje;
    }

    public void setEafyaraterrizaje(List<EAFYARAterrizaje> eafyaraterrizaje) {
        this.eafyaraterrizaje = eafyaraterrizaje;
    }

    public List<EAFYARBase> getEafyarbase() {
        return eafyarbase;
    }

    public void setEafyarbase(List<EAFYARBase> eafyarbase) {
        this.eafyarbase = eafyarbase;
    }

    public List<EAFYARClaseVuelo> getEafyarclasevuelo() {
        return eafyarclasevuelo;
    }

    public void setEafyarclasevuelo(List<EAFYARClaseVuelo> eafyarclasevuelo) {
        this.eafyarclasevuelo = eafyarclasevuelo;
    }

    public List<EAFYARDescanso> getEafyardescanso() {
        return eafyardescanso;
    }

    public void setEafyardescanso(List<EAFYARDescanso> eafyardescanso) {
        this.eafyardescanso = eafyardescanso;
    }

    public List<EAFYARDias> getEafyardias() {
        return eafyardias;
    }

    public void setEafyardias(List<EAFYARDias> eafyardias) {
        this.eafyardias = eafyardias;
    }

    public List<EAFYAREntrenamiento> getEafyarentrenamiento() {
        return eafyarentrenamiento;
    }

    public void setEafyarentrenamiento(List<EAFYAREntrenamiento> eafyarentrenamiento) {
        this.eafyarentrenamiento = eafyarentrenamiento;
    }

    public List<EAFYARHorasAreaOperaciones> getEafyarhorasareaoperaciones() {
        return eafyarhorasareaoperaciones;
    }

    public void setEafyarhorasareaoperaciones(List<EAFYARHorasAreaOperaciones> eafyarhorasareaoperaciones) {
        this.eafyarhorasareaoperaciones = eafyarhorasareaoperaciones;
    }

    public List<EAFYARHorasEquipo> getEafyarhorasequipo() {
        return eafyarhorasequipo;
    }

    public void setEafyarhorasequipo(List<EAFYARHorasEquipo> eafyarhorasequipo) {
        this.eafyarhorasequipo = eafyarhorasequipo;
    }

    public List<EAFYARHorasPilotoEstudianteLvn> getEafyarhoraspilotoestudiantelvn() {
        return eafyarhoraspilotoestudiantelvn;
    }

    public void setEafyarhoraspilotoestudiantelvn(List<EAFYARHorasPilotoEstudianteLvn> eafyarhoraspilotoestudiantelvn) {
        this.eafyarhoraspilotoestudiantelvn = eafyarhoraspilotoestudiantelvn;
    }

    public List<EAFYARHorasPilotoInstructorLvn> getEafyarhoraspilotoinstructorlvn() {
        return eafyarhoraspilotoinstructorlvn;
    }

    public void setEafyarhoraspilotoinstructorlvn(List<EAFYARHorasPilotoInstructorLvn> eafyarhoraspilotoinstructorlvn) {
        this.eafyarhoraspilotoinstructorlvn = eafyarhoraspilotoinstructorlvn;
    }

    public List<EAFYARHorasPinPilotoInstructor> getEafyarhoraspinpilotoinstructor() {
        return eafyarhoraspinpilotoinstructor;
    }

    public void setEafyarhoraspinpilotoinstructor(List<EAFYARHorasPinPilotoInstructor> eafyarhoraspinpilotoinstructor) {
        this.eafyarhoraspinpilotoinstructor = eafyarhoraspinpilotoinstructor;
    }

    public List<EAFYARHorasTotalesPilotoEstudiante> getEafyarhorastotalespilotoestudiante() {
        return eafyarhorastotalespilotoestudiante;
    }

    public void setEafyarhorastotalespilotoestudiante(List<EAFYARHorasTotalesPilotoEstudiante> eafyarhorastotalespilotoestudiante) {
        this.eafyarhorastotalespilotoestudiante = eafyarhorastotalespilotoestudiante;
    }

    public List<EAFYARHorasTotalesPilotoInstructor> getEafyarhorastotalespilotoinstructor() {
        return eafyarhorastotalespilotoinstructor;
    }

    public void setEafyarhorastotalespilotoinstructor(List<EAFYARHorasTotalesPilotoInstructor> eafyarhorastotalespilotoinstructor) {
        this.eafyarhorastotalespilotoinstructor = eafyarhorastotalespilotoinstructor;
    }

    public List<EAFYARHorasTotalesTsac> getEafyarhorastotalestsac() {
        return eafyarhorastotalestsac;
    }

    public void setEafyarhorastotalestsac(List<EAFYARHorasTotalesTsac> eafyarhorastotalestsac) {
        this.eafyarhorastotalestsac = eafyarhorastotalestsac;
    }

    public List<EAFYARHorasTrabajadas> getEafyarhorastrabajadas() {
        return eafyarhorastrabajadas;
    }

    public void setEafyarhorastrabajadas(List<EAFYARHorasTrabajadas> eafyarhorastrabajadas) {
        this.eafyarhorastrabajadas = eafyarhorastrabajadas;
    }

    public List<EAFYARHorasTsacLvn> getEafyarhorastsaclvn() {
        return eafyarhorastsaclvn;
    }

    public void setEafyarhorastsaclvn(List<EAFYARHorasTsacLvn> eafyarhorastsaclvn) {
        this.eafyarhorastsaclvn = eafyarhorastsaclvn;
    }

    public List<EAFYARInformacion> getEafyarinformacion() {
        return eafyarinformacion;
    }

    public void setEafyarinformacion(List<EAFYARInformacion> eafyarinformacion) {
        this.eafyarinformacion = eafyarinformacion;
    }

    public List<EAFYARMando> getEafyarmando() {
        return eafyarmando;
    }

    public void setEafyarmando(List<EAFYARMando> eafyarmando) {
        this.eafyarmando = eafyarmando;
    }

    public List<EAFYARModo> getEafyarmodo() {
        return eafyarmodo;
    }

    public void setEafyarmodo(List<EAFYARModo> eafyarmodo) {
        this.eafyarmodo = eafyarmodo;
    }

    public List<EAFYARNivel> getEafyarnivel() {
        return eafyarnivel;
    }

    public void setEafyarnivel(List<EAFYARNivel> eafyarnivel) {
        this.eafyarnivel = eafyarnivel;
    }

    public List<EAFYARNp> getEafyarnp() {
        return eafyarnp;
    }

    public void setEafyarnp(List<EAFYARNp> eafyarnp) {
        this.eafyarnp = eafyarnp;
    }

    public List<EAFYARPlan> getEafyarplan() {
        return eafyarplan;
    }

    public void setEafyarplan(List<EAFYARPlan> eafyarplan) {
        this.eafyarplan = eafyarplan;
    }

    public List<EAFYARPorcentaje> getEafyarporcentaje() {
        return eafyarporcentaje;
    }

    public void setEafyarporcentaje(List<EAFYARPorcentaje> eafyarporcentaje) {
        this.eafyarporcentaje = eafyarporcentaje;
    }

    public List<EAFYARTechoVisual> getEafyartechovisual() {
        return eafyartechovisual;
    }

    public void setEafyartechovisual(List<EAFYARTechoVisual> eafyartechovisual) {
        this.eafyartechovisual = eafyartechovisual;
    }

    public List<EAFYARTerrenoInstruccion> getEafyarterrenoinstruccion() {
        return eafyarterrenoinstruccion;
    }

    public void setEafyarterrenoinstruccion(List<EAFYARTerrenoInstruccion> eafyarterrenoinstruccion) {
        this.eafyarterrenoinstruccion = eafyarterrenoinstruccion;
    }

    public List<EAFYARTerrenoRuta> getEafyarterrenoruta() {
        return eafyarterrenoruta;
    }

    public void setEafyarterrenoruta(List<EAFYARTerrenoRuta> eafyarterrenoruta) {
        this.eafyarterrenoruta = eafyarterrenoruta;
    }


    public List<RALARAngulo> getRalarangulo() {
        return ralarangulo;
    }

    public void setRalarangulo(List<RALARAngulo> ralarangulo) {
        this.ralarangulo = ralarangulo;
    }

    public List<RALARArea> getRalararea() {
        return ralararea;
    }

    public void setRalararea(List<RALARArea> ralararea) {
        this.ralararea = ralararea;
    }

    public List<RALARBase> getRalarbase() {
        return ralarbase;
    }

    public void setRalarbase(List<RALARBase> ralarbase) {
        this.ralarbase = ralarbase;
    }

    public List<RALARCav> getRalarcav() {
        return ralarcav;
    }

    public void setRalarcav(List<RALARCav> ralarcav) {
        this.ralarcav = ralarcav;
    }

    public List<RALARClaseVuelo> getRalarclasevuelo() {
        return ralarclasevuelo;
    }

    public void setRalarclasevuelo(List<RALARClaseVuelo> ralarclasevuelo) {
        this.ralarclasevuelo = ralarclasevuelo;
    }

    public List<RALARDescanso> getRalardescanso() {
        return ralardescanso;
    }

    public void setRalardescanso(List<RALARDescanso> ralardescanso) {
        this.ralardescanso = ralardescanso;
    }

    public List<RALARDias> getRalardias() {
        return ralardias;
    }

    public void setRalardias(List<RALARDias> ralardias) {
        this.ralardias = ralardias;
    }

    public List<RALARHorasCopilotoLvn> getRalarhorascopilotolvn() {
        return ralarhorascopilotolvn;
    }

    public void setRalarhorascopilotolvn(List<RALARHorasCopilotoLvn> ralarhorascopilotolvn) {
        this.ralarhorascopilotolvn = ralarhorascopilotolvn;
    }

    public List<RALARHorasEquipoCopiloto> getRalarhorasequipocopiloto() {
        return ralarhorasequipocopiloto;
    }

    public void setRalarhorasequipocopiloto(List<RALARHorasEquipoCopiloto> ralarhorasequipocopiloto) {
        this.ralarhorasequipocopiloto = ralarhorasequipocopiloto;
    }

    public List<RALARHorasEquipoPiloto> getRalarhorasequipopiloto() {
        return ralarhorasequipopiloto;
    }

    public void setRalarhorasequipopiloto(List<RALARHorasEquipoPiloto> ralarhorasequipopiloto) {
        this.ralarhorasequipopiloto = ralarhorasequipopiloto;
    }

    public List<RALARHorasEquipoTsac> getRalarhorasequipotsac() {
        return ralarhorasequipotsac;
    }

    public void setRalarhorasequipotsac(List<RALARHorasEquipoTsac> ralarhorasequipotsac) {
        this.ralarhorasequipotsac = ralarhorasequipotsac;
    }

    public List<RALARHorasPilotoLvn> getRalarhoraspilotolvn() {
        return ralarhoraspilotolvn;
    }

    public void setRalarhoraspilotolvn(List<RALARHorasPilotoLvn> ralarhoraspilotolvn) {
        this.ralarhoraspilotolvn = ralarhoraspilotolvn;
    }

    public List<RALARHorasTotalesCopiloto> getRalarhorastotalescopiloto() {
        return ralarhorastotalescopiloto;
    }

    public void setRalarhorastotalescopiloto(List<RALARHorasTotalesCopiloto> ralarhorastotalescopiloto) {
        this.ralarhorastotalescopiloto = ralarhorastotalescopiloto;
    }

    public List<RALARHorasTotalesPiloto> getRalarhorastotalespiloto() {
        return ralarhorastotalespiloto;
    }

    public void setRalarhorastotalespiloto(List<RALARHorasTotalesPiloto> ralarhorastotalespiloto) {
        this.ralarhorastotalespiloto = ralarhorastotalespiloto;
    }

    public List<RALARHorasTotalesTsac> getRalarhorastotalestsac() {
        return ralarhorastotalestsac;
    }

    public void setRalarhorastotalestsac(List<RALARHorasTotalesTsac> ralarhorastotalestsac) {
        this.ralarhorastotalestsac = ralarhorastotalestsac;
    }

    public List<RALARHorasTrabajadas> getRalarhorastrabajadas() {
        return ralarhorastrabajadas;
    }

    public void setRalarhorastrabajadas(List<RALARHorasTrabajadas> ralarhorastrabajadas) {
        this.ralarhorastrabajadas = ralarhorastrabajadas;
    }

    public List<RALARHorasTsacLvn> getRalarhorastsaclvn() {
        return ralarhorastsaclvn;
    }

    public void setRalarhorastsaclvn(List<RALARHorasTsacLvn> ralarhorastsaclvn) {
        this.ralarhorastsaclvn = ralarhorastsaclvn;
    }

    public List<RALARInformacion> getRalarinformacion() {
        return ralarinformacion;
    }

    public void setRalarinformacion(List<RALARInformacion> ralarinformacion) {
        this.ralarinformacion = ralarinformacion;
    }

    public List<RALARMando> getRalarmando() {
        return ralarmando;
    }

    public void setRalarmando(List<RALARMando> ralarmando) {
        this.ralarmando = ralarmando;
    }

    public List<RALARModo> getRalarmodo() {
        return ralarmodo;
    }

    public void setRalarmodo(List<RALARModo> ralarmodo) {
        this.ralarmodo = ralarmodo;
    }

    public List<RALARNivel> getRalarnivel() {
        return ralarnivel;
    }

    public void setRalarnivel(List<RALARNivel> ralarnivel) {
        this.ralarnivel = ralarnivel;
    }

    public List<RALARPlan> getRalarplan() {
        return ralarplan;
    }

    public void setRalarplan(List<RALARPlan> ralarplan) {
        this.ralarplan = ralarplan;
    }

    public List<RALARPorcentaje> getRalarporcentaje() {
        return ralarporcentaje;
    }

    public void setRalarporcentaje(List<RALARPorcentaje> ralarporcentaje) {
        this.ralarporcentaje = ralarporcentaje;
    }

    public List<RALARTechoVisual> getRalartechovisual() {
        return ralartechovisual;
    }

    public void setRalartechovisual(List<RALARTechoVisual> ralartechovisual) {
        this.ralartechovisual = ralartechovisual;
    }

    public List<RALARTerrenosFacamb> getRalarterrenosfacamb() {
        return ralarterrenosfacamb;
    }

    public void setRalarterrenosfacamb(List<RALARTerrenosFacamb> ralarterrenosfacamb) {
        this.ralarterrenosfacamb = ralarterrenosfacamb;
    }

    public List<RALARTipoMision> getRalartipomision() {
        return ralartipomision;
    }

    public void setRalartipomision(List<RALARTipoMision> ralartipomision) {
        this.ralartipomision = ralartipomision;
    }

    public List<VPRARBaseHT> getVprarbaseht() {
        return vprarbaseht;
    }

    public void setVprarbaseht(List<VPRARBaseHT> vprarbaseht) {
        this.vprarbaseht = vprarbaseht;
    }

    public List<VPRARBaseRendTrip> getVprarbaserendtrip() {
        return vprarbaserendtrip;
    }

    public void setVprarbaserendtrip(List<VPRARBaseRendTrip> vprarbaserendtrip) {
        this.vprarbaserendtrip = vprarbaserendtrip;
    }

    public List<VPRARComplejidad> getVprarcomplejidad() {
        return vprarcomplejidad;
    }

    public void setVprarcomplejidad(List<VPRARComplejidad> vprarcomplejidad) {
        this.vprarcomplejidad = vprarcomplejidad;
    }

    public List<VPRARDescanso> getVprardescanso() {
        return vprardescanso;
    }

    public void setVprardescanso(List<VPRARDescanso> vprardescanso) {
        this.vprardescanso = vprardescanso;
    }

    public List<VPRARDiasEnTierra> getVprardiasentierra() {
        return vprardiasentierra;
    }

    public void setVprardiasentierra(List<VPRARDiasEnTierra> vprardiasentierra) {
        this.vprardiasentierra = vprardiasentierra;
    }

    public List<VPRARDiasUltimoMtf> getVprardiasultimomtf() {
        return vprardiasultimomtf;
    }

    public void setVprardiasultimomtf(List<VPRARDiasUltimoMtf> vprardiasultimomtf) {
        this.vprardiasultimomtf = vprardiasultimomtf;
    }

    public List<VPRARExperiencia> getVprarexperiencia() {
        return vprarexperiencia;
    }

    public void setVprarexperiencia(List<VPRARExperiencia> vprarexperiencia) {
        this.vprarexperiencia = vprarexperiencia;
    }

    public List<VPRARHoras> getVprarhoras() {
        return vprarhoras;
    }

    public void setVprarhoras(List<VPRARHoras> vprarhoras) {
        this.vprarhoras = vprarhoras;
    }

    public List<VPRARHorasExpMp> getVprarhorasexpmp() {
        return vprarhorasexpmp;
    }

    public void setVprarhorasexpmp(List<VPRARHorasExpMp> vprarhorasexpmp) {
        this.vprarhorasexpmp = vprarhorasexpmp;
    }

    public List<VPRARHorasTrabajadas> getVprarhorastrabajadas() {
        return vprarhorastrabajadas;
    }

    public void setVprarhorastrabajadas(List<VPRARHorasTrabajadas> vprarhorastrabajadas) {
        this.vprarhorastrabajadas = vprarhorastrabajadas;
    }

    public List<VPRARLocalidad> getVprarlocalidad() {
        return vprarlocalidad;
    }

    public void setVprarlocalidad(List<VPRARLocalidad> vprarlocalidad) {
        this.vprarlocalidad = vprarlocalidad;
    }

    public List<VPRARMantenimiento> getVprarmantenimiento() {
        return vprarmantenimiento;
    }

    public void setVprarmantenimiento(List<VPRARMantenimiento> vprarmantenimiento) {
        this.vprarmantenimiento = vprarmantenimiento;
    }

    public List<VPRARNoDeTecMec> getVprarnodetecmec() {
        return vprarnodetecmec;
    }

    public void setVprarnodetecmec(List<VPRARNoDeTecMec> vprarnodetecmec) {
        this.vprarnodetecmec = vprarnodetecmec;
    }

    public List<VPRARNumeroDeTecnicos> getVprarnumerodetecnicos() {
        return vprarnumerodetecnicos;
    }

    public void setVprarnumerodetecnicos(List<VPRARNumeroDeTecnicos> vprarnumerodetecnicos) {
        this.vprarnumerodetecnicos = vprarnumerodetecnicos;
    }

    public List<VPRARTechoVisual> getVprartechovisual() {
        return vprartechovisual;
    }

    public void setVprartechovisual(List<VPRARTechoVisual> vprartechovisual) {
        this.vprartechovisual = vprartechovisual;
    }

    public List<VPRARTemperatura> getVprartemperatura() {
        return vprartemperatura;
    }

    public void setVprartemperatura(List<VPRARTemperatura> vprartemperatura) {
        this.vprartemperatura = vprartemperatura;
    }

    public List<VPRARViento> getVprarviento() {
        return vprarviento;
    }

    public void setVprarviento(List<VPRARViento> vprarviento) {
        this.vprarviento = vprarviento;
    }

}
