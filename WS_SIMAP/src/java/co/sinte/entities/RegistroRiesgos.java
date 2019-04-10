
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.entities;

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
public class RegistroRiesgos {

    @XmlElement
    private Long idCriesgoFormato,idCalculoRiesgo,
            idSMando,
            idSControl,
            idSDyn,
            idImInformacion,
            idTpcHrtot,
            idTpcHreq,
            idPpcNvl,
            idTpiHrtot,
            idTpiHreq,
            idPpiNvl,
            idTtmHrtot,
            idTtmHreq,
            idPtmNvl,
            idEumDias,
            idRtripDesc,
            idRtripHrs,
            idRtripBase,
            idCondmClasv,
            idCondmTmision,
            idHostilidadNvl,
            idCondpCond,
            idCondpTpista,
            idRmeteoTyv,
            idRmeteoInstru,
            idOperaArea,
            idFactopoMotor,
            idFactopoTdespe,
            idFactopoTruta,
            idFactopoTrecono,
            idFactopoTaprox,
            idSecpcNyvHr,
            idSecpiNyvHr,
            idSectecArtnyvHr,
            idInocPorcen,
            idAnguloLuna,
            idPlanmiInfo,
            idPlanmiPlan,
            idSeltriptecHrtot,
            idSeltriptecHreq,
            idCattripCat,
            idMcmSyn,
            idCommiClasv,
            idCommiTmision,
            idAvueloArea,
            idPlanrendLimit,
            idSelecPilHrtot,
            idSelecPilHreq,
            idSelecCopHrtot,
            idSelecCopHreq,
            idSelecTsacHrtot,
            idSelecTsacHreq,
            idTripCav,
            idFacambTopera,
            idFacambTruta,
            idSelecPilLvnHr,
            idSelecCopLvnHr,
            idSelecTsacLvnHr,
            idInocAngulo,
            idSelecPilinstHrtot,
            idSelecPilinstHreq,
            idSelecPilestuHrtot,
            idSelecPilestuHreq,
            idUtripEntreDias,
            idNvlPrepara,
            idComentreClasev,
            idComentreEntrena,
            idAterrizaAreav,
            idAterrizaAterrizaje,
            idFacambTinstru,
            idSelecPilinstLvnHr,
            idSelecPilestuLvnHr,
            idComvueComple,
            idComvueLocalidad,
            idHrtrabHrtrabajo,
            idHrtrabBase,
            idMambTyv,
            idMambViento,
            idTemperatura,
            idTecvueNumtec,
            idSelectripMpmeHoras,
            idSelectripMpmeDias,
            idSelectripPimpHoras,
            idExpTecmecNum,
            idExpTecmecExp,
            idFachumDiast,
            idFachumMtto,
            totalSupervision,
            totalInfoMision,
            totalSelecTripPc,
            totalNvlPrepPc,
            totalSelecTripPi,
            totalNvlPrepPi,
            totalSelecTripTm,
            totalNvlPrepTm,
            totalUtripMision,
            totalRendTrip,
            totalCondMision,
            totalRhostilidad,
            totalCondPista,
            totalRmetereo,
            totalAreaOpera,
            totalFactTopo,
            total,
            totalSelecPcnvg,
            totalSelecPinvg,
            totalSelecTecartnvg,
            totalIluminaNoct,
            totalAnguloLuna,
            totalNvg,
            totalPlaneaMision,
            totalSelecTripTec,
            totalCategoTrip,
            totalMisionManual,
            totalCompleMision,
            totalAreaVuelo,
            totalPlaneaRendi,
            totalSelecPil,
            totalSelecCpil,
            totalSelecTsac,
            totalTripCav,
            totalCondMeteoro,
            totalFactAmb,
            totalSelecPillvn,
            totalSelecCpillvn,
            totalSelecTsaclvn,
            totalLvn,
            totalSelecPilinst,
            totalSelecPilestu,
            totalUtripEntrena,
            totalNvlPrepEntrena,
            totalCompleEntrena,
            totalAreaAterrizaje,
            totalSelecPinlvn,
            totalSelecPiestlvn,
            totalCompleVuelo,
            totalHorasTrabajadas,
            totalMedioAmbiente,
            totalTemperatura,
            totalTecVuelo,
            totalSelecMpme,
            totalSelecPimp,
            totalExpTecmec,
            totalFactMtto,
            pncVersion,
            totalNvlPrepEst,
            idConmeteoTyv,
            idConmeteoModo,
            idFormatoRiesgo,
            idOrdenVuelo;
    
    @XmlElement
    private String usuarioCreador,usuarioModificador;
    @XmlElement
    private Date  fechaCreacion ,fechaModificacion;

    public Long getIdCriesgoFormato() {
        return idCriesgoFormato;
    }

    public void setIdCriesgoFormato(Long idCriesgoFormato) {
        this.idCriesgoFormato = idCriesgoFormato;
    }
    
    

    public Long getIdCalculoRiesgo() {
        return idCalculoRiesgo;
    }

    public void setIdCalculoRiesgo(Long idCalculoRiesgo) {
        this.idCalculoRiesgo = idCalculoRiesgo;
    }

    public Long getIdSMando() {
        return idSMando;
    }

    public void setIdSMando(Long idSMando) {
        this.idSMando = idSMando;
    }

    public Long getIdSControl() {
        return idSControl;
    }

    public void setIdSControl(Long idSControl) {
        this.idSControl = idSControl;
    }

    public Long getIdSDyn() {
        return idSDyn;
    }

    public void setIdSDyn(Long idSDyn) {
        this.idSDyn = idSDyn;
    }

    public Long getIdImInformacion() {
        return idImInformacion;
    }

    public void setIdImInformacion(Long idImInformacion) {
        this.idImInformacion = idImInformacion;
    }

    public Long getIdTpcHrtot() {
        return idTpcHrtot;
    }

    public void setIdTpcHrtot(Long idTpcHrtot) {
        this.idTpcHrtot = idTpcHrtot;
    }

    public Long getIdTpcHreq() {
        return idTpcHreq;
    }

    public void setIdTpcHreq(Long idTpcHreq) {
        this.idTpcHreq = idTpcHreq;
    }

    public Long getIdPpcNvl() {
        return idPpcNvl;
    }

    public void setIdPpcNvl(Long idPpcNvl) {
        this.idPpcNvl = idPpcNvl;
    }

    public Long getIdTpiHrtot() {
        return idTpiHrtot;
    }

    public void setIdTpiHrtot(Long idTpiHrtot) {
        this.idTpiHrtot = idTpiHrtot;
    }

    public Long getIdTpiHreq() {
        return idTpiHreq;
    }

    public void setIdTpiHreq(Long idTpiHreq) {
        this.idTpiHreq = idTpiHreq;
    }

    public Long getIdPpiNvl() {
        return idPpiNvl;
    }

    public void setIdPpiNvl(Long idPpiNvl) {
        this.idPpiNvl = idPpiNvl;
    }

    public Long getIdTtmHrtot() {
        return idTtmHrtot;
    }

    public void setIdTtmHrtot(Long idTtmHrtot) {
        this.idTtmHrtot = idTtmHrtot;
    }

    public Long getIdTtmHreq() {
        return idTtmHreq;
    }

    public void setIdTtmHreq(Long idTtmHreq) {
        this.idTtmHreq = idTtmHreq;
    }

    public Long getIdPtmNvl() {
        return idPtmNvl;
    }

    public void setIdPtmNvl(Long idPtmNvl) {
        this.idPtmNvl = idPtmNvl;
    }

    public Long getIdEumDias() {
        return idEumDias;
    }

    public void setIdEumDias(Long idEumDias) {
        this.idEumDias = idEumDias;
    }

    public Long getIdRtripDesc() {
        return idRtripDesc;
    }

    public void setIdRtripDesc(Long idRtripDesc) {
        this.idRtripDesc = idRtripDesc;
    }

    public Long getIdRtripHrs() {
        return idRtripHrs;
    }

    public void setIdRtripHrs(Long idRtripHrs) {
        this.idRtripHrs = idRtripHrs;
    }

    public Long getIdRtripBase() {
        return idRtripBase;
    }

    public void setIdRtripBase(Long idRtripBase) {
        this.idRtripBase = idRtripBase;
    }

    public Long getIdCondmClasv() {
        return idCondmClasv;
    }

    public void setIdCondmClasv(Long idCondmClasv) {
        this.idCondmClasv = idCondmClasv;
    }

    public Long getIdCondmTmision() {
        return idCondmTmision;
    }

    public void setIdCondmTmision(Long idCondmTmision) {
        this.idCondmTmision = idCondmTmision;
    }

    public Long getIdHostilidadNvl() {
        return idHostilidadNvl;
    }

    public void setIdHostilidadNvl(Long idHostilidadNvl) {
        this.idHostilidadNvl = idHostilidadNvl;
    }

    public Long getIdCondpCond() {
        return idCondpCond;
    }

    public void setIdCondpCond(Long idCondpCond) {
        this.idCondpCond = idCondpCond;
    }

    public Long getIdCondpTpista() {
        return idCondpTpista;
    }

    public void setIdCondpTpista(Long idCondpTpista) {
        this.idCondpTpista = idCondpTpista;
    }

    public Long getIdRmeteoTyv() {
        return idRmeteoTyv;
    }

    public void setIdRmeteoTyv(Long idRmeteoTyv) {
        this.idRmeteoTyv = idRmeteoTyv;
    }

    public Long getIdRmeteoInstru() {
        return idRmeteoInstru;
    }

    public void setIdRmeteoInstru(Long idRmeteoInstru) {
        this.idRmeteoInstru = idRmeteoInstru;
    }

    public Long getIdOperaArea() {
        return idOperaArea;
    }

    public void setIdOperaArea(Long idOperaArea) {
        this.idOperaArea = idOperaArea;
    }

    public Long getIdFactopoMotor() {
        return idFactopoMotor;
    }

    public void setIdFactopoMotor(Long idFactopoMotor) {
        this.idFactopoMotor = idFactopoMotor;
    }

    public Long getIdFactopoTdespe() {
        return idFactopoTdespe;
    }

    public void setIdFactopoTdespe(Long idFactopoTdespe) {
        this.idFactopoTdespe = idFactopoTdespe;
    }

    public Long getIdFactopoTruta() {
        return idFactopoTruta;
    }

    public void setIdFactopoTruta(Long idFactopoTruta) {
        this.idFactopoTruta = idFactopoTruta;
    }

    public Long getIdFactopoTrecono() {
        return idFactopoTrecono;
    }

    public void setIdFactopoTrecono(Long idFactopoTrecono) {
        this.idFactopoTrecono = idFactopoTrecono;
    }

    public Long getIdFactopoTaprox() {
        return idFactopoTaprox;
    }

    public void setIdFactopoTaprox(Long idFactopoTaprox) {
        this.idFactopoTaprox = idFactopoTaprox;
    }

    public Long getIdSecpcNyvHr() {
        return idSecpcNyvHr;
    }

    public void setIdSecpcNyvHr(Long idSecpcNyvHr) {
        this.idSecpcNyvHr = idSecpcNyvHr;
    }

    public Long getIdSecpiNyvHr() {
        return idSecpiNyvHr;
    }

    public void setIdSecpiNyvHr(Long idSecpiNyvHr) {
        this.idSecpiNyvHr = idSecpiNyvHr;
    }

    public Long getIdSectecArtnyvHr() {
        return idSectecArtnyvHr;
    }

    public void setIdSectecArtnyvHr(Long idSectecArtnyvHr) {
        this.idSectecArtnyvHr = idSectecArtnyvHr;
    }

    public Long getIdInocPorcen() {
        return idInocPorcen;
    }

    public void setIdInocPorcen(Long idInocPorcen) {
        this.idInocPorcen = idInocPorcen;
    }

    public Long getIdAnguloLuna() {
        return idAnguloLuna;
    }

    public void setIdAnguloLuna(Long idAnguloLuna) {
        this.idAnguloLuna = idAnguloLuna;
    }

    public Long getIdPlanmiInfo() {
        return idPlanmiInfo;
    }

    public void setIdPlanmiInfo(Long idPlanmiInfo) {
        this.idPlanmiInfo = idPlanmiInfo;
    }

    public Long getIdPlanmiPlan() {
        return idPlanmiPlan;
    }

    public void setIdPlanmiPlan(Long idPlanmiPlan) {
        this.idPlanmiPlan = idPlanmiPlan;
    }

    public Long getIdSeltriptecHrtot() {
        return idSeltriptecHrtot;
    }

    public void setIdSeltriptecHrtot(Long idSeltriptecHrtot) {
        this.idSeltriptecHrtot = idSeltriptecHrtot;
    }

    public Long getIdSeltriptecHreq() {
        return idSeltriptecHreq;
    }

    public void setIdSeltriptecHreq(Long idSeltriptecHreq) {
        this.idSeltriptecHreq = idSeltriptecHreq;
    }

    public Long getIdCattripCat() {
        return idCattripCat;
    }

    public void setIdCattripCat(Long idCattripCat) {
        this.idCattripCat = idCattripCat;
    }

    public Long getIdMcmSyn() {
        return idMcmSyn;
    }

    public void setIdMcmSyn(Long idMcmSyn) {
        this.idMcmSyn = idMcmSyn;
    }

    public Long getIdCommiClasv() {
        return idCommiClasv;
    }

    public void setIdCommiClasv(Long idCommiClasv) {
        this.idCommiClasv = idCommiClasv;
    }

    public Long getIdCommiTmision() {
        return idCommiTmision;
    }

    public void setIdCommiTmision(Long idCommiTmision) {
        this.idCommiTmision = idCommiTmision;
    }

    public Long getIdAvueloArea() {
        return idAvueloArea;
    }

    public void setIdAvueloArea(Long idAvueloArea) {
        this.idAvueloArea = idAvueloArea;
    }

    public Long getIdPlanrendLimit() {
        return idPlanrendLimit;
    }

    public void setIdPlanrendLimit(Long idPlanrendLimit) {
        this.idPlanrendLimit = idPlanrendLimit;
    }

    public Long getIdSelecPilHrtot() {
        return idSelecPilHrtot;
    }

    public void setIdSelecPilHrtot(Long idSelecPilHrtot) {
        this.idSelecPilHrtot = idSelecPilHrtot;
    }

    public Long getIdSelecPilHreq() {
        return idSelecPilHreq;
    }

    public void setIdSelecPilHreq(Long idSelecPilHreq) {
        this.idSelecPilHreq = idSelecPilHreq;
    }

    public Long getIdSelecCopHrtot() {
        return idSelecCopHrtot;
    }

    public void setIdSelecCopHrtot(Long idSelecCopHrtot) {
        this.idSelecCopHrtot = idSelecCopHrtot;
    }

    public Long getIdSelecCopHreq() {
        return idSelecCopHreq;
    }

    public void setIdSelecCopHreq(Long idSelecCopHreq) {
        this.idSelecCopHreq = idSelecCopHreq;
    }

    public Long getIdSelecTsacHrtot() {
        return idSelecTsacHrtot;
    }

    public void setIdSelecTsacHrtot(Long idSelecTsacHrtot) {
        this.idSelecTsacHrtot = idSelecTsacHrtot;
    }

    public Long getIdSelecTsacHreq() {
        return idSelecTsacHreq;
    }

    public void setIdSelecTsacHreq(Long idSelecTsacHreq) {
        this.idSelecTsacHreq = idSelecTsacHreq;
    }

    public Long getIdTripCav() {
        return idTripCav;
    }

    public void setIdTripCav(Long idTripCav) {
        this.idTripCav = idTripCav;
    }

    public Long getIdFacambTopera() {
        return idFacambTopera;
    }

    public void setIdFacambTopera(Long idFacambTopera) {
        this.idFacambTopera = idFacambTopera;
    }

    public Long getIdFacambTruta() {
        return idFacambTruta;
    }

    public void setIdFacambTruta(Long idFacambTruta) {
        this.idFacambTruta = idFacambTruta;
    }

    public Long getIdSelecPilLvnHr() {
        return idSelecPilLvnHr;
    }

    public void setIdSelecPilLvnHr(Long idSelecPilLvnHr) {
        this.idSelecPilLvnHr = idSelecPilLvnHr;
    }

    public Long getIdSelecCopLvnHr() {
        return idSelecCopLvnHr;
    }

    public void setIdSelecCopLvnHr(Long idSelecCopLvnHr) {
        this.idSelecCopLvnHr = idSelecCopLvnHr;
    }

    public Long getIdSelecTsacLvnHr() {
        return idSelecTsacLvnHr;
    }

    public void setIdSelecTsacLvnHr(Long idSelecTsacLvnHr) {
        this.idSelecTsacLvnHr = idSelecTsacLvnHr;
    }

    public Long getIdInocAngulo() {
        return idInocAngulo;
    }

    public void setIdInocAngulo(Long idInocAngulo) {
        this.idInocAngulo = idInocAngulo;
    }

    public Long getIdSelecPilinstHrtot() {
        return idSelecPilinstHrtot;
    }

    public void setIdSelecPilinstHrtot(Long idSelecPilinstHrtot) {
        this.idSelecPilinstHrtot = idSelecPilinstHrtot;
    }

    public Long getIdSelecPilinstHreq() {
        return idSelecPilinstHreq;
    }

    public void setIdSelecPilinstHreq(Long idSelecPilinstHreq) {
        this.idSelecPilinstHreq = idSelecPilinstHreq;
    }

    public Long getIdSelecPilestuHrtot() {
        return idSelecPilestuHrtot;
    }

    public void setIdSelecPilestuHrtot(Long idSelecPilestuHrtot) {
        this.idSelecPilestuHrtot = idSelecPilestuHrtot;
    }

    public Long getIdSelecPilestuHreq() {
        return idSelecPilestuHreq;
    }

    public void setIdSelecPilestuHreq(Long idSelecPilestuHreq) {
        this.idSelecPilestuHreq = idSelecPilestuHreq;
    }

    public Long getIdUtripEntreDias() {
        return idUtripEntreDias;
    }

    public void setIdUtripEntreDias(Long idUtripEntreDias) {
        this.idUtripEntreDias = idUtripEntreDias;
    }

    public Long getIdNvlPrepara() {
        return idNvlPrepara;
    }

    public void setIdNvlPrepara(Long idNvlPrepara) {
        this.idNvlPrepara = idNvlPrepara;
    }

    public Long getIdComentreClasev() {
        return idComentreClasev;
    }

    public void setIdComentreClasev(Long idComentreClasev) {
        this.idComentreClasev = idComentreClasev;
    }

    public Long getIdComentreEntrena() {
        return idComentreEntrena;
    }

    public void setIdComentreEntrena(Long idComentreEntrena) {
        this.idComentreEntrena = idComentreEntrena;
    }

    public Long getIdAterrizaAreav() {
        return idAterrizaAreav;
    }

    public void setIdAterrizaAreav(Long idAterrizaAreav) {
        this.idAterrizaAreav = idAterrizaAreav;
    }

    public Long getIdAterrizaAterrizaje() {
        return idAterrizaAterrizaje;
    }

    public void setIdAterrizaAterrizaje(Long idAterrizaAterrizaje) {
        this.idAterrizaAterrizaje = idAterrizaAterrizaje;
    }

    public Long getIdFacambTinstru() {
        return idFacambTinstru;
    }

    public void setIdFacambTinstru(Long idFacambTinstru) {
        this.idFacambTinstru = idFacambTinstru;
    }

    public Long getIdSelecPilinstLvnHr() {
        return idSelecPilinstLvnHr;
    }

    public void setIdSelecPilinstLvnHr(Long idSelecPilinstLvnHr) {
        this.idSelecPilinstLvnHr = idSelecPilinstLvnHr;
    }

    public Long getIdSelecPilestuLvnHr() {
        return idSelecPilestuLvnHr;
    }

    public void setIdSelecPilestuLvnHr(Long idSelecPilestuLvnHr) {
        this.idSelecPilestuLvnHr = idSelecPilestuLvnHr;
    }

    public Long getIdComvueComple() {
        return idComvueComple;
    }

    public void setIdComvueComple(Long idComvueComple) {
        this.idComvueComple = idComvueComple;
    }

    public Long getIdComvueLocalidad() {
        return idComvueLocalidad;
    }

    public void setIdComvueLocalidad(Long idComvueLocalidad) {
        this.idComvueLocalidad = idComvueLocalidad;
    }

    public Long getIdHrtrabHrtrabajo() {
        return idHrtrabHrtrabajo;
    }

    public void setIdHrtrabHrtrabajo(Long idHrtrabHrtrabajo) {
        this.idHrtrabHrtrabajo = idHrtrabHrtrabajo;
    }

    public Long getIdHrtrabBase() {
        return idHrtrabBase;
    }

    public void setIdHrtrabBase(Long idHrtrabBase) {
        this.idHrtrabBase = idHrtrabBase;
    }

    public Long getIdMambTyv() {
        return idMambTyv;
    }

    public void setIdMambTyv(Long idMambTyv) {
        this.idMambTyv = idMambTyv;
    }

    public Long getIdMambViento() {
        return idMambViento;
    }

    public void setIdMambViento(Long idMambViento) {
        this.idMambViento = idMambViento;
    }

    public Long getIdTemperatura() {
        return idTemperatura;
    }

    public void setIdTemperatura(Long idTemperatura) {
        this.idTemperatura = idTemperatura;
    }

    public Long getIdTecvueNumtec() {
        return idTecvueNumtec;
    }

    public void setIdTecvueNumtec(Long idTecvueNumtec) {
        this.idTecvueNumtec = idTecvueNumtec;
    }

    public Long getIdSelectripMpmeHoras() {
        return idSelectripMpmeHoras;
    }

    public void setIdSelectripMpmeHoras(Long idSelectripMpmeHoras) {
        this.idSelectripMpmeHoras = idSelectripMpmeHoras;
    }

    public Long getIdSelectripMpmeDias() {
        return idSelectripMpmeDias;
    }

    public void setIdSelectripMpmeDias(Long idSelectripMpmeDias) {
        this.idSelectripMpmeDias = idSelectripMpmeDias;
    }

    public Long getIdSelectripPimpHoras() {
        return idSelectripPimpHoras;
    }

    public void setIdSelectripPimpHoras(Long idSelectripPimpHoras) {
        this.idSelectripPimpHoras = idSelectripPimpHoras;
    }

    public Long getIdExpTecmecNum() {
        return idExpTecmecNum;
    }

    public void setIdExpTecmecNum(Long idExpTecmecNum) {
        this.idExpTecmecNum = idExpTecmecNum;
    }

    public Long getIdExpTecmecExp() {
        return idExpTecmecExp;
    }

    public void setIdExpTecmecExp(Long idExpTecmecExp) {
        this.idExpTecmecExp = idExpTecmecExp;
    }

    public Long getIdFachumDiast() {
        return idFachumDiast;
    }

    public void setIdFachumDiast(Long idFachumDiast) {
        this.idFachumDiast = idFachumDiast;
    }

    public Long getIdFachumMtto() {
        return idFachumMtto;
    }

    public void setIdFachumMtto(Long idFachumMtto) {
        this.idFachumMtto = idFachumMtto;
    }

    public Long getTotalSupervision() {
        return totalSupervision;
    }

    public void setTotalSupervision(Long totalSupervision) {
        this.totalSupervision = totalSupervision;
    }

    public Long getTotalInfoMision() {
        return totalInfoMision;
    }

    public void setTotalInfoMision(Long totalInfoMision) {
        this.totalInfoMision = totalInfoMision;
    }

    public Long getTotalSelecTripPc() {
        return totalSelecTripPc;
    }

    public void setTotalSelecTripPc(Long totalSelecTripPc) {
        this.totalSelecTripPc = totalSelecTripPc;
    }

    public Long getTotalNvlPrepPc() {
        return totalNvlPrepPc;
    }

    public void setTotalNvlPrepPc(Long totalNvlPrepPc) {
        this.totalNvlPrepPc = totalNvlPrepPc;
    }

    public Long getTotalSelecTripPi() {
        return totalSelecTripPi;
    }

    public void setTotalSelecTripPi(Long totalSelecTripPi) {
        this.totalSelecTripPi = totalSelecTripPi;
    }

    public Long getTotalNvlPrepPi() {
        return totalNvlPrepPi;
    }

    public void setTotalNvlPrepPi(Long totalNvlPrepPi) {
        this.totalNvlPrepPi = totalNvlPrepPi;
    }

    public Long getTotalSelecTripTm() {
        return totalSelecTripTm;
    }

    public void setTotalSelecTripTm(Long totalSelecTripTm) {
        this.totalSelecTripTm = totalSelecTripTm;
    }

    public Long getTotalNvlPrepTm() {
        return totalNvlPrepTm;
    }

    public void setTotalNvlPrepTm(Long totalNvlPrepTm) {
        this.totalNvlPrepTm = totalNvlPrepTm;
    }

    public Long getTotalUtripMision() {
        return totalUtripMision;
    }

    public void setTotalUtripMision(Long totalUtripMision) {
        this.totalUtripMision = totalUtripMision;
    }

    public Long getTotalRendTrip() {
        return totalRendTrip;
    }

    public void setTotalRendTrip(Long totalRendTrip) {
        this.totalRendTrip = totalRendTrip;
    }

    public Long getTotalCondMision() {
        return totalCondMision;
    }

    public void setTotalCondMision(Long totalCondMision) {
        this.totalCondMision = totalCondMision;
    }

    public Long getTotalRhostilidad() {
        return totalRhostilidad;
    }

    public void setTotalRhostilidad(Long totalRhostilidad) {
        this.totalRhostilidad = totalRhostilidad;
    }

    public Long getTotalCondPista() {
        return totalCondPista;
    }

    public void setTotalCondPista(Long totalCondPista) {
        this.totalCondPista = totalCondPista;
    }

    public Long getTotalRmetereo() {
        return totalRmetereo;
    }

    public void setTotalRmetereo(Long totalRmetereo) {
        this.totalRmetereo = totalRmetereo;
    }

    public Long getTotalAreaOpera() {
        return totalAreaOpera;
    }

    public void setTotalAreaOpera(Long totalAreaOpera) {
        this.totalAreaOpera = totalAreaOpera;
    }

    public Long getTotalFactTopo() {
        return totalFactTopo;
    }

    public void setTotalFactTopo(Long totalFactTopo) {
        this.totalFactTopo = totalFactTopo;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalSelecPcnvg() {
        return totalSelecPcnvg;
    }

    public void setTotalSelecPcnvg(Long totalSelecPcnvg) {
        this.totalSelecPcnvg = totalSelecPcnvg;
    }

    public Long getTotalSelecPinvg() {
        return totalSelecPinvg;
    }

    public void setTotalSelecPinvg(Long totalSelecPinvg) {
        this.totalSelecPinvg = totalSelecPinvg;
    }

    public Long getTotalSelecTecartnvg() {
        return totalSelecTecartnvg;
    }

    public void setTotalSelecTecartnvg(Long totalSelecTecartnvg) {
        this.totalSelecTecartnvg = totalSelecTecartnvg;
    }

    public Long getTotalIluminaNoct() {
        return totalIluminaNoct;
    }

    public void setTotalIluminaNoct(Long totalIluminaNoct) {
        this.totalIluminaNoct = totalIluminaNoct;
    }

    public Long getTotalAnguloLuna() {
        return totalAnguloLuna;
    }

    public void setTotalAnguloLuna(Long totalAnguloLuna) {
        this.totalAnguloLuna = totalAnguloLuna;
    }

    public Long getTotalNvg() {
        return totalNvg;
    }

    public void setTotalNvg(Long totalNvg) {
        this.totalNvg = totalNvg;
    }

    public Long getTotalPlaneaMision() {
        return totalPlaneaMision;
    }

    public void setTotalPlaneaMision(Long totalPlaneaMision) {
        this.totalPlaneaMision = totalPlaneaMision;
    }

    public Long getTotalSelecTripTec() {
        return totalSelecTripTec;
    }

    public void setTotalSelecTripTec(Long totalSelecTripTec) {
        this.totalSelecTripTec = totalSelecTripTec;
    }

    public Long getTotalCategoTrip() {
        return totalCategoTrip;
    }

    public void setTotalCategoTrip(Long totalCategoTrip) {
        this.totalCategoTrip = totalCategoTrip;
    }

    public Long getTotalMisionManual() {
        return totalMisionManual;
    }

    public void setTotalMisionManual(Long totalMisionManual) {
        this.totalMisionManual = totalMisionManual;
    }

    public Long getTotalCompleMision() {
        return totalCompleMision;
    }

    public void setTotalCompleMision(Long totalCompleMision) {
        this.totalCompleMision = totalCompleMision;
    }

    public Long getTotalAreaVuelo() {
        return totalAreaVuelo;
    }

    public void setTotalAreaVuelo(Long totalAreaVuelo) {
        this.totalAreaVuelo = totalAreaVuelo;
    }

    public Long getTotalPlaneaRendi() {
        return totalPlaneaRendi;
    }

    public void setTotalPlaneaRendi(Long totalPlaneaRendi) {
        this.totalPlaneaRendi = totalPlaneaRendi;
    }

    public Long getTotalSelecPil() {
        return totalSelecPil;
    }

    public void setTotalSelecPil(Long totalSelecPil) {
        this.totalSelecPil = totalSelecPil;
    }

    public Long getTotalSelecCpil() {
        return totalSelecCpil;
    }

    public void setTotalSelecCpil(Long totalSelecCpil) {
        this.totalSelecCpil = totalSelecCpil;
    }

    public Long getTotalSelecTsac() {
        return totalSelecTsac;
    }

    public void setTotalSelecTsac(Long totalSelecTsac) {
        this.totalSelecTsac = totalSelecTsac;
    }

    public Long getTotalTripCav() {
        return totalTripCav;
    }

    public void setTotalTripCav(Long totalTripCav) {
        this.totalTripCav = totalTripCav;
    }

    public Long getTotalCondMeteoro() {
        return totalCondMeteoro;
    }

    public void setTotalCondMeteoro(Long totalCondMeteoro) {
        this.totalCondMeteoro = totalCondMeteoro;
    }

    public Long getTotalFactAmb() {
        return totalFactAmb;
    }

    public void setTotalFactAmb(Long totalFactAmb) {
        this.totalFactAmb = totalFactAmb;
    }

    public Long getTotalSelecPillvn() {
        return totalSelecPillvn;
    }

    public void setTotalSelecPillvn(Long totalSelecPillvn) {
        this.totalSelecPillvn = totalSelecPillvn;
    }

    public Long getTotalSelecCpillvn() {
        return totalSelecCpillvn;
    }

    public void setTotalSelecCpillvn(Long totalSelecCpillvn) {
        this.totalSelecCpillvn = totalSelecCpillvn;
    }

    public Long getTotalSelecTsaclvn() {
        return totalSelecTsaclvn;
    }

    public void setTotalSelecTsaclvn(Long totalSelecTsaclvn) {
        this.totalSelecTsaclvn = totalSelecTsaclvn;
    }

    public Long getTotalLvn() {
        return totalLvn;
    }

    public void setTotalLvn(Long totalLvn) {
        this.totalLvn = totalLvn;
    }

    public Long getTotalSelecPilinst() {
        return totalSelecPilinst;
    }

    public void setTotalSelecPilinst(Long totalSelecPilinst) {
        this.totalSelecPilinst = totalSelecPilinst;
    }

    public Long getTotalSelecPilestu() {
        return totalSelecPilestu;
    }

    public void setTotalSelecPilestu(Long totalSelecPilestu) {
        this.totalSelecPilestu = totalSelecPilestu;
    }

    public Long getTotalUtripEntrena() {
        return totalUtripEntrena;
    }

    public void setTotalUtripEntrena(Long totalUtripEntrena) {
        this.totalUtripEntrena = totalUtripEntrena;
    }

    public Long getTotalNvlPrepEntrena() {
        return totalNvlPrepEntrena;
    }

    public void setTotalNvlPrepEntrena(Long totalNvlPrepEntrena) {
        this.totalNvlPrepEntrena = totalNvlPrepEntrena;
    }

    public Long getTotalCompleEntrena() {
        return totalCompleEntrena;
    }

    public void setTotalCompleEntrena(Long totalCompleEntrena) {
        this.totalCompleEntrena = totalCompleEntrena;
    }

    public Long getTotalAreaAterrizaje() {
        return totalAreaAterrizaje;
    }

    public void setTotalAreaAterrizaje(Long totalAreaAterrizaje) {
        this.totalAreaAterrizaje = totalAreaAterrizaje;
    }

    public Long getTotalSelecPinlvn() {
        return totalSelecPinlvn;
    }

    public void setTotalSelecPinlvn(Long totalSelecPinlvn) {
        this.totalSelecPinlvn = totalSelecPinlvn;
    }

    public Long getTotalSelecPiestlvn() {
        return totalSelecPiestlvn;
    }

    public void setTotalSelecPiestlvn(Long totalSelecPiestlvn) {
        this.totalSelecPiestlvn = totalSelecPiestlvn;
    }

    public Long getTotalCompleVuelo() {
        return totalCompleVuelo;
    }

    public void setTotalCompleVuelo(Long totalCompleVuelo) {
        this.totalCompleVuelo = totalCompleVuelo;
    }

    public Long getTotalHorasTrabajadas() {
        return totalHorasTrabajadas;
    }

    public void setTotalHorasTrabajadas(Long totalHorasTrabajadas) {
        this.totalHorasTrabajadas = totalHorasTrabajadas;
    }

    public Long getTotalMedioAmbiente() {
        return totalMedioAmbiente;
    }

    public void setTotalMedioAmbiente(Long totalMedioAmbiente) {
        this.totalMedioAmbiente = totalMedioAmbiente;
    }

    public Long getTotalTemperatura() {
        return totalTemperatura;
    }

    public void setTotalTemperatura(Long totalTemperatura) {
        this.totalTemperatura = totalTemperatura;
    }

    public Long getTotalTecVuelo() {
        return totalTecVuelo;
    }

    public void setTotalTecVuelo(Long totalTecVuelo) {
        this.totalTecVuelo = totalTecVuelo;
    }

    public Long getTotalSelecMpme() {
        return totalSelecMpme;
    }

    public void setTotalSelecMpme(Long totalSelecMpme) {
        this.totalSelecMpme = totalSelecMpme;
    }

    public Long getTotalSelecPimp() {
        return totalSelecPimp;
    }

    public void setTotalSelecPimp(Long totalSelecPimp) {
        this.totalSelecPimp = totalSelecPimp;
    }

    public Long getTotalExpTecmec() {
        return totalExpTecmec;
    }

    public void setTotalExpTecmec(Long totalExpTecmec) {
        this.totalExpTecmec = totalExpTecmec;
    }

    public Long getTotalFactMtto() {
        return totalFactMtto;
    }

    public void setTotalFactMtto(Long totalFactMtto) {
        this.totalFactMtto = totalFactMtto;
    }

    public Long getPncVersion() {
        return pncVersion;
    }

    public void setPncVersion(Long pncVersion) {
        this.pncVersion = pncVersion;
    }

    public Long getTotalNvlPrepEst() {
        return totalNvlPrepEst;
    }

    public void setTotalNvlPrepEst(Long totalNvlPrepEst) {
        this.totalNvlPrepEst = totalNvlPrepEst;
    }

    public Long getIdConmeteoTyv() {
        return idConmeteoTyv;
    }

    public void setIdConmeteoTyv(Long idConmeteoTyv) {
        this.idConmeteoTyv = idConmeteoTyv;
    }

    public Long getIdConmeteoModo() {
        return idConmeteoModo;
    }

    public void setIdConmeteoModo(Long idConmeteoModo) {
        this.idConmeteoModo = idConmeteoModo;
    }

    public Long getIdFormatoRiesgo() {
        return idFormatoRiesgo;
    }

    public void setIdFormatoRiesgo(Long idFormatoRiesgo) {
        this.idFormatoRiesgo = idFormatoRiesgo;
    }

    public Long getIdOrdenVuelo() {
        return idOrdenVuelo;
    }

    public void setIdOrdenVuelo(Long idOrdenVuelo) {
        this.idOrdenVuelo = idOrdenVuelo;
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

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    
           
    
    
}
