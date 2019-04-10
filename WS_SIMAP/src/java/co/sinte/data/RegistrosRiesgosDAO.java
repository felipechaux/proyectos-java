/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sinte.data;

import co.sinte.entities.MensajeRespuesta;
import co.sinte.entities.RegistroRiesgos;
import co.sinte.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DESARROLLO
 */
public class RegistrosRiesgosDAO {
    
    Long primaryKeyEncabezado;
    private String INSERT_R = "Insert into mlt_op_criesgo_formatos\n"
            + "  (id_criesgo_formato, id_calculo_riesgo, id_s_mando, id_s_control, id_s_dyn"
            + ", id_im_informacion, id_tpc_hrtot, id_tpc_hreq, id_ppc_nvl, id_tpi_hrtot"
            + ", id_tpi_hreq, id_ppi_nvl, id_ttm_hrtot, id_ttm_hreq, id_ptm_nvl"
            + ", id_eum_dias, id_rtrip_desc, id_rtrip_hrs, id_rtrip_base"
            + ", id_condm_clasv, id_condm_tmision, id_hostilidad_nvl"
            + ", id_condp_cond, id_condp_tpista, id_rmeteo_tyv"
            + ", id_rmeteo_instru, id_opera_area, id_factopo_motor"
            + ", id_factopo_tdespe, id_factopo_truta, id_factopo_trecono"
            + ", id_factopo_taprox, id_secpc_nyv_hr, id_secpi_nyv_hr"
            + ", id_sectec_artnyv_hr, id_inoc_porcen, id_angulo_luna"
            + ", id_planmi_info, id_planmi_plan, id_seltriptec_hrtot"
            + ", id_seltriptec_hreq, id_cattrip_cat, id_mcm_syn"
            + ", id_commi_clasv, id_commi_tmision, id_avuelo_area"
            + ", id_planrend_limit, id_selec_pil_hrtot"
            + ", id_selec_pil_hreq, id_selec_cop_hrtot, id_selec_cop_hreq"
            + ", id_selec_tsac_hrtot, id_selec_tsac_hreq, id_trip_cav"
            + ", id_facamb_topera, id_facamb_truta, id_selec_pil_lvn_hr"
            + ", id_selec_cop_lvn_hr, id_selec_tsac_lvn_hr, id_inoc_angulo"
            + ", id_selec_pilinst_hrtot, id_selec_pilinst_hreq"
            + ", id_selec_pilestu_hrtot, id_selec_pilestu_hreq"
            + ", id_utrip_entre_dias, id_nvl_prepara, id_comentre_clasev"
            + ", id_comentre_entrena, id_aterriza_areav, id_aterriza_aterrizaje"
            + ", id_facamb_tinstru, id_selec_pilinst_lvn_hr, id_selec_pilestu_lvn_hr"
            + ", id_comvue_comple, id_comvue_localidad, id_hrtrab_hrtrabajo, id_hrtrab_base"
            + ", id_mamb_tyv, id_mamb_viento, id_temperatura, id_tecvue_numtec"
            + ", id_selectrip_mpme_horas, id_selectrip_mpme_dias, id_selectrip_pimp_horas"
            + ", id_exp_tecmec_num, id_exp_tecmec_exp, id_fachum_diast, id_fachum_mtto"
            + ", total_supervision, total_info_mision, total_selec_trip_pc, total_nvl_prep_pc"
            + " , total_selec_trip_pi, total_nvl_prep_pi, total_selec_trip_tm, total_nvl_prep_tm"
            + ", total_utrip_mision, total_rend_trip, total_cond_mision, total_rhostilidad"
            + ", total_cond_pista, total_rmetereo, total_area_opera, total_fact_topo, total"
            + ", total_selec_pcnvg, total_selec_pinvg, total_selec_tecartnvg, total_ilumina_noct"
            + ", total_angulo_luna, total_nvg, total_planea_mision, total_selec_trip_tec"
            + ", total_catego_trip, total_mision_manual, total_comple_mision,"
            + " total_area_vuelo, total_planea_rendi, total_selec_pil, total_selec_cpil"
            + ", total_selec_tsac, total_trip_cav, total_cond_meteoro, total_fact_amb"
            + ", total_selec_pillvn, total_selec_cpillvn, total_selec_tsaclvn, total_lvn"
            + ", total_selec_pilinst, total_selec_pilestu, total_utrip_entrena"
            + ", total_nvl_prep_entrena, total_comple_entrena, total_area_aterrizaje"
            + ", total_selec_pinlvn, total_selec_piestlvn, total_comple_vuelo"
            + ", total_horas_trabajadas, total_medio_ambiente, total_temperatura"
            + ", total_tec_vuelo, total_selec_mpme, total_selec_pimp, total_exp_tecmec"
            + ", total_fact_mtto, usuario_creador, fecha_creacion, usuario_modificador"
            + ", fecha_modificacion, pnc_version, total_nvl_prep_est, id_conmeteo_tyv"
            + ", id_conmeteo_modo, id_formato_riesgo, id_orden_vuelo)\n"
            + "values\n"
            + "  (pnc_op_criesgo_formatos_seq.nextval,?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "? )";
    
    private static final String validaRiesgos = "{CALL pkg_maletin_riesgo.pr_main(?,?,?,?)}";
    
    public void insertRegistrosRiesgos(RegistroRiesgos reg, MensajeRespuesta respuesta) {
        
        PreparedStatement ps = null;
        Connection con = ConnectionDB.getJNDIConnection();
        
        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_R,new String[]{"id_criesgo_formato"});
                
                run:
                if (reg.getIdCalculoRiesgo() != null) {
                    ps.setLong(1, reg.getIdCalculoRiesgo());
                } else {
                    ps.setNull(1, Types.LONGVARCHAR);
                }
                if (reg.getIdSMando() != null) {
                    ps.setLong(2, reg.getIdSMando());
                } else {
                    ps.setNull(2, Types.LONGVARCHAR);
                }
                if (reg.getIdSControl() != null) {
                    ps.setLong(3, reg.getIdSControl());
                } else {
                    ps.setNull(3, Types.LONGVARCHAR);
                }
                if (reg.getIdSDyn() != null) {
                    ps.setLong(4, reg.getIdSDyn());
                } else {
                    ps.setNull(4, Types.LONGVARCHAR);
                }
                if (reg.getIdImInformacion() != null) {
                    ps.setLong(5, reg.getIdImInformacion());
                } else {
                    ps.setNull(5, Types.LONGVARCHAR);
                }
                if (reg.getIdTpcHrtot() != null) {
                    ps.setLong(6, reg.getIdTpcHrtot());
                } else {
                    ps.setNull(6, Types.LONGVARCHAR);
                }
                if (reg.getIdTpcHreq() != null) {
                    ps.setLong(7, reg.getIdTpcHreq());
                } else {
                    ps.setNull(7, Types.LONGVARCHAR);
                }
                if (reg.getIdPpcNvl() != null) {
                    ps.setLong(8, reg.getIdPpcNvl());
                } else {
                    ps.setNull(8, Types.LONGVARCHAR);
                }
                if (reg.getIdTpiHrtot() != null) {
                    ps.setLong(9, reg.getIdTpiHrtot());
                } else {
                    ps.setNull(9, Types.LONGVARCHAR);
                }
                if (reg.getIdTpiHreq() != null) {
                    ps.setLong(10, reg.getIdTpiHreq());
                } else {
                    ps.setNull(10, Types.LONGVARCHAR);
                }
                if (reg.getIdPpiNvl() != null) {
                    ps.setLong(11, reg.getIdPpiNvl());
                } else {
                    ps.setNull(11, Types.LONGVARCHAR);
                }
                if (reg.getIdTtmHrtot() != null) {
                    ps.setLong(12, reg.getIdTtmHrtot());
                } else {
                    ps.setNull(12, Types.LONGVARCHAR);
                }
                if (reg.getIdTtmHreq() != null) {
                    ps.setLong(13, reg.getIdTtmHreq());
                } else {
                    ps.setNull(13, Types.LONGVARCHAR);
                }
                if (reg.getIdPtmNvl() != null) {
                    ps.setLong(14, reg.getIdPtmNvl());
                } else {
                    ps.setNull(14, Types.LONGVARCHAR);
                }
                if (reg.getIdEumDias() != null) {
                    ps.setLong(15, reg.getIdEumDias());
                } else {
                    ps.setNull(15, Types.LONGVARCHAR);
                }
                if (reg.getIdRtripDesc() != null) {
                    ps.setLong(16, reg.getIdRtripDesc());
                } else {
                    ps.setNull(16, Types.LONGVARCHAR);
                }
                if (reg.getIdRtripHrs() != null) {
                    ps.setLong(17, reg.getIdRtripHrs());
                } else {
                    ps.setNull(17, Types.LONGVARCHAR);
                }
                if (reg.getIdRtripBase() != null) {
                    ps.setLong(18, reg.getIdRtripBase());
                } else {
                    ps.setNull(18, Types.LONGVARCHAR);
                }
                if (reg.getIdCondmClasv() != null) {
                    ps.setLong(19, reg.getIdCondmClasv());
                } else {
                    ps.setNull(19, Types.LONGVARCHAR);
                }
                if (reg.getIdCondmTmision() != null) {
                    ps.setLong(20, reg.getIdCondmTmision());
                } else {
                    ps.setNull(20, Types.LONGVARCHAR);
                }
                if (reg.getIdHostilidadNvl() != null) {
                    ps.setLong(21, reg.getIdHostilidadNvl());
                } else {
                    ps.setNull(21, Types.LONGVARCHAR);
                }
                if (reg.getIdCondpCond() != null) {
                    ps.setLong(22, reg.getIdCondpCond());
                } else {
                    ps.setNull(22, Types.LONGVARCHAR);
                }
                if (reg.getIdCondpTpista() != null) {
                    ps.setLong(23, reg.getIdCondpTpista());
                } else {
                    ps.setNull(23, Types.LONGVARCHAR);
                }
                if (reg.getIdRmeteoTyv() != null) {
                    ps.setLong(24, reg.getIdRmeteoTyv());
                } else {
                    ps.setNull(24, Types.LONGVARCHAR);
                }
                if (reg.getIdRmeteoInstru() != null) {
                    ps.setLong(25, reg.getIdRmeteoInstru());
                } else {
                    ps.setNull(25, Types.LONGVARCHAR);
                }
                if (reg.getIdOperaArea() != null) {
                    ps.setLong(26, reg.getIdOperaArea());
                } else {
                    ps.setNull(26, Types.LONGVARCHAR);
                }
                if (reg.getIdFactopoMotor() != null) {
                    ps.setLong(27, reg.getIdFactopoMotor());
                } else {
                    ps.setNull(27, Types.LONGVARCHAR);
                }
                if (reg.getIdFactopoTdespe() != null) {
                    ps.setLong(28, reg.getIdFactopoTdespe());
                } else {
                    ps.setNull(28, Types.LONGVARCHAR);
                }
                if (reg.getIdFactopoTruta() != null) {
                    ps.setLong(29, reg.getIdFactopoTruta());
                } else {
                    ps.setNull(29, Types.LONGVARCHAR);
                }
                if (reg.getIdFactopoTrecono() != null) {
                    ps.setLong(30, reg.getIdFactopoTrecono());
                } else {
                    ps.setNull(30, Types.LONGVARCHAR);
                }
                if (reg.getIdFactopoTaprox() != null) {
                    ps.setLong(31, reg.getIdFactopoTaprox());
                } else {
                    ps.setNull(31, Types.LONGVARCHAR);
                }
                if (reg.getIdSecpcNyvHr() != null) {
                    ps.setLong(32, reg.getIdSecpcNyvHr());
                } else {
                    ps.setNull(32, Types.LONGVARCHAR);
                }
                if (reg.getIdSecpiNyvHr() != null) {
                    ps.setLong(33, reg.getIdSecpiNyvHr());
                } else {
                    ps.setNull(33, Types.LONGVARCHAR);
                }
                if (reg.getIdSectecArtnyvHr() != null) {
                    ps.setLong(34, reg.getIdSectecArtnyvHr());
                } else {
                    ps.setNull(34, Types.LONGVARCHAR);
                }
                if (reg.getIdInocPorcen() != null) {
                    ps.setLong(35, reg.getIdInocPorcen());
                } else {
                    ps.setNull(35, Types.LONGVARCHAR);
                }
                if (reg.getIdAnguloLuna() != null) {
                    ps.setLong(36, reg.getIdAnguloLuna());
                } else {
                    ps.setNull(36, Types.LONGVARCHAR);
                }
                if (reg.getIdPlanmiInfo() != null) {
                    ps.setLong(37, reg.getIdPlanmiInfo());
                } else {
                    ps.setNull(37, Types.LONGVARCHAR);
                }
                if (reg.getIdPlanmiPlan() != null) {
                    ps.setLong(38, reg.getIdPlanmiPlan());
                } else {
                    ps.setNull(38, Types.LONGVARCHAR);
                }
                if (reg.getIdSeltriptecHrtot() != null) {
                    ps.setLong(39, reg.getIdSeltriptecHrtot());
                } else {
                    ps.setNull(39, Types.LONGVARCHAR);
                }
                if (reg.getIdSeltriptecHreq() != null) {
                    ps.setLong(40, reg.getIdSeltriptecHreq());
                } else {
                    ps.setNull(40, Types.LONGVARCHAR);
                }
                if (reg.getIdCattripCat() != null) {
                    ps.setLong(41, reg.getIdCattripCat());
                } else {
                    ps.setNull(41, Types.LONGVARCHAR);
                }
                if (reg.getIdMcmSyn() != null) {
                    ps.setLong(42, reg.getIdMcmSyn());
                } else {
                    ps.setNull(42, Types.LONGVARCHAR);
                }
                if (reg.getIdCommiClasv() != null) {
                    ps.setLong(43, reg.getIdCommiClasv());
                } else {
                    ps.setNull(43, Types.LONGVARCHAR);
                }
                if (reg.getIdCommiTmision() != null) {
                    ps.setLong(44, reg.getIdCommiTmision());
                } else {
                    ps.setNull(44, Types.LONGVARCHAR);
                }
                if (reg.getIdAvueloArea() != null) {
                    ps.setLong(45, reg.getIdAvueloArea());
                } else {
                    ps.setNull(45, Types.LONGVARCHAR);
                }
                if (reg.getIdPlanrendLimit() != null) {
                    ps.setLong(46, reg.getIdPlanrendLimit());
                } else {
                    ps.setNull(46, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilHrtot() != null) {
                    ps.setLong(47, reg.getIdSelecPilHrtot());
                } else {
                    ps.setNull(47, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilHreq() != null) {
                    ps.setLong(48, reg.getIdSelecPilHreq());
                } else {
                    ps.setNull(48, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecCopHrtot() != null) {
                    ps.setLong(49, reg.getIdSelecCopHrtot());
                } else {
                    ps.setNull(49, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecCopHreq() != null) {
                    ps.setLong(50, reg.getIdSelecCopHreq());
                } else {
                    ps.setNull(50, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecTsacHrtot() != null) {
                    ps.setLong(51, reg.getIdSelecTsacHrtot());
                } else {
                    ps.setNull(51, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecTsacHreq() != null) {
                    ps.setLong(52, reg.getIdSelecTsacHreq());
                } else {
                    ps.setNull(52, Types.LONGVARCHAR);
                }
                if (reg.getIdTripCav() != null) {
                    ps.setLong(53, reg.getIdTripCav());
                } else {
                    ps.setNull(53, Types.LONGVARCHAR);
                }
                if (reg.getIdFacambTopera() != null) {
                    ps.setLong(54, reg.getIdFacambTopera());
                } else {
                    ps.setNull(54, Types.LONGVARCHAR);
                }
                if (reg.getIdFacambTruta() != null) {
                    ps.setLong(55, reg.getIdFacambTruta());
                } else {
                    ps.setNull(55, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilLvnHr() != null) {
                    ps.setLong(56, reg.getIdSelecPilLvnHr());
                } else {
                    ps.setNull(56, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecCopLvnHr() != null) {
                    ps.setLong(57, reg.getIdSelecCopLvnHr());
                } else {
                    ps.setNull(57, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecTsacLvnHr() != null) {
                    ps.setLong(58, reg.getIdSelecTsacLvnHr());
                } else {
                    ps.setNull(58, Types.LONGVARCHAR);
                }
                if (reg.getIdInocAngulo() != null) {
                    ps.setLong(59, reg.getIdInocAngulo());
                } else {
                    ps.setNull(59, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilinstHrtot() != null) {
                    ps.setLong(60, reg.getIdSelecPilinstHrtot());
                } else {
                    ps.setNull(60, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilinstHreq() != null) {
                    ps.setLong(61, reg.getIdSelecPilinstHreq());
                } else {
                    ps.setNull(61, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilestuHrtot() != null) {
                    ps.setLong(62, reg.getIdSelecPilestuHrtot());
                } else {
                    ps.setNull(62, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilestuHreq() != null) {
                    ps.setLong(63, reg.getIdSelecPilestuHreq());
                } else {
                    ps.setNull(63, Types.LONGVARCHAR);
                }
                if (reg.getIdUtripEntreDias() != null) {
                    ps.setLong(64, reg.getIdUtripEntreDias());
                } else {
                    ps.setNull(64, Types.LONGVARCHAR);
                }
                if (reg.getIdNvlPrepara() != null) {
                    ps.setLong(65, reg.getIdNvlPrepara());
                } else {
                    ps.setNull(65, Types.LONGVARCHAR);
                }
                if (reg.getIdComentreClasev() != null) {
                    ps.setLong(66, reg.getIdComentreClasev());
                } else {
                    ps.setNull(66, Types.LONGVARCHAR);
                }
                if (reg.getIdComentreEntrena() != null) {
                    ps.setLong(67, reg.getIdComentreEntrena());
                } else {
                    ps.setNull(67, Types.LONGVARCHAR);
                }
                if (reg.getIdAterrizaAreav() != null) {
                    ps.setLong(68, reg.getIdAterrizaAreav());
                } else {
                    ps.setNull(68, Types.LONGVARCHAR);
                }
                if (reg.getIdAterrizaAterrizaje() != null) {
                    ps.setLong(69, reg.getIdAterrizaAterrizaje());
                } else {
                    ps.setNull(69, Types.LONGVARCHAR);
                }
                if (reg.getIdFacambTinstru() != null) {
                    ps.setLong(70, reg.getIdFacambTinstru());
                } else {
                    ps.setNull(70, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilinstLvnHr() != null) {
                    ps.setLong(71, reg.getIdSelecPilinstLvnHr());
                } else {
                    ps.setNull(71, Types.LONGVARCHAR);
                }
                if (reg.getIdSelecPilestuLvnHr() != null) {
                    ps.setLong(72, reg.getIdSelecPilestuLvnHr());
                } else {
                    ps.setNull(72, Types.LONGVARCHAR);
                }
                if (reg.getIdComvueComple() != null) {
                    ps.setLong(73, reg.getIdComvueComple());
                } else {
                    ps.setNull(73, Types.LONGVARCHAR);
                }
                if (reg.getIdComvueLocalidad() != null) {
                    ps.setLong(74, reg.getIdComvueLocalidad());
                } else {
                    ps.setNull(74, Types.LONGVARCHAR);
                }
                if (reg.getIdHrtrabHrtrabajo() != null) {
                    ps.setLong(75, reg.getIdHrtrabHrtrabajo());
                } else {
                    ps.setNull(75, Types.LONGVARCHAR);
                }
                if (reg.getIdHrtrabBase() != null) {
                    ps.setLong(76, reg.getIdHrtrabBase());
                } else {
                    ps.setNull(76, Types.LONGVARCHAR);
                }
                if (reg.getIdMambTyv() != null) {
                    ps.setLong(77, reg.getIdMambTyv());
                } else {
                    ps.setNull(77, Types.LONGVARCHAR);
                }
                if (reg.getIdMambViento() != null) {
                    ps.setLong(78, reg.getIdMambViento());
                } else {
                    ps.setNull(78, Types.LONGVARCHAR);
                }
                if (reg.getIdTemperatura() != null) {
                    ps.setLong(79, reg.getIdTemperatura());
                } else {
                    ps.setNull(79, Types.LONGVARCHAR);
                }
                if (reg.getIdTecvueNumtec() != null) {
                    ps.setLong(80, reg.getIdTecvueNumtec());
                } else {
                    ps.setNull(80, Types.LONGVARCHAR);
                }
                if (reg.getIdSelectripMpmeHoras() != null) {
                    ps.setLong(81, reg.getIdSelectripMpmeHoras());
                } else {
                    ps.setNull(81, Types.LONGVARCHAR);
                }
                if (reg.getIdSelectripMpmeDias() != null) {
                    ps.setLong(82, reg.getIdSelectripMpmeDias());
                } else {
                    ps.setNull(82, Types.LONGVARCHAR);
                }
                if (reg.getIdSelectripPimpHoras() != null) {
                    ps.setLong(83, reg.getIdSelectripPimpHoras());
                } else {
                    ps.setNull(83, Types.LONGVARCHAR);
                }
                if (reg.getIdExpTecmecNum() != null) {
                    ps.setLong(84, reg.getIdExpTecmecNum());
                } else {
                    ps.setNull(84, Types.LONGVARCHAR);
                }
                if (reg.getIdExpTecmecExp() != null) {
                    ps.setLong(85, reg.getIdExpTecmecExp());
                } else {
                    ps.setNull(85, Types.LONGVARCHAR);
                }
                if (reg.getIdFachumDiast() != null) {
                    ps.setLong(86, reg.getIdFachumDiast());
                } else {
                    ps.setNull(86, Types.LONGVARCHAR);
                }
                if (reg.getIdFachumMtto() != null) {
                    ps.setLong(87, reg.getIdFachumMtto());
                } else {
                    ps.setNull(87, Types.LONGVARCHAR);
                }
                if (reg.getTotalSupervision() != null) {
                    ps.setLong(88, reg.getTotalSupervision());
                } else {
                    ps.setNull(88, Types.LONGVARCHAR);
                }
                if (reg.getTotalInfoMision() != null) {
                    ps.setLong(89, reg.getTotalInfoMision());
                } else {
                    ps.setNull(89, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecTripPc() != null) {
                    ps.setLong(90, reg.getTotalSelecTripPc());
                } else {
                    ps.setNull(90, Types.LONGVARCHAR);
                }
                if (reg.getTotalNvlPrepPc() != null) {
                    ps.setLong(91, reg.getTotalNvlPrepPc());
                } else {
                    ps.setNull(91, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecTripPi() != null) {
                    ps.setLong(92, reg.getTotalSelecTripPi());
                } else {
                    ps.setNull(92, Types.LONGVARCHAR);
                }
                if (reg.getTotalNvlPrepPi() != null) {
                    ps.setLong(93, reg.getTotalNvlPrepPi());
                } else {
                    ps.setNull(93, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecTripTm() != null) {
                    ps.setLong(94, reg.getTotalSelecTripTm());
                } else {
                    ps.setNull(94, Types.LONGVARCHAR);
                }
                if (reg.getTotalNvlPrepTm() != null) {
                    ps.setLong(95, reg.getTotalNvlPrepTm());
                } else {
                    ps.setNull(95, Types.LONGVARCHAR);
                }
                if (reg.getTotalUtripMision() != null) {
                    ps.setLong(96, reg.getTotalUtripMision());
                } else {
                    ps.setNull(96, Types.LONGVARCHAR);
                }
                if (reg.getTotalRendTrip() != null) {
                    ps.setLong(97, reg.getTotalRendTrip());
                } else {
                    ps.setNull(97, Types.LONGVARCHAR);
                }
                if (reg.getTotalCondMision() != null) {
                    ps.setLong(98, reg.getTotalCondMision());
                } else {
                    ps.setNull(98, Types.LONGVARCHAR);
                }
                if (reg.getTotalRhostilidad() != null) {
                    ps.setLong(99, reg.getTotalRhostilidad());
                } else {
                    ps.setNull(99, Types.LONGVARCHAR);
                }
                if (reg.getTotalCondPista() != null) {
                    ps.setLong(100, reg.getTotalCondPista());
                } else {
                    ps.setNull(100, Types.LONGVARCHAR);
                }
                if (reg.getTotalRmetereo() != null) {
                    ps.setLong(101, reg.getTotalRmetereo());
                } else {
                    ps.setNull(101, Types.LONGVARCHAR);
                }
                if (reg.getTotalAreaOpera() != null) {
                    ps.setLong(102, reg.getTotalAreaOpera());
                } else {
                    ps.setNull(102, Types.LONGVARCHAR);
                }
                if (reg.getTotalFactTopo() != null) {
                    ps.setLong(103, reg.getTotalFactTopo());
                } else {
                    ps.setNull(103, Types.LONGVARCHAR);
                }
                if (reg.getTotal() != null) {
                    ps.setLong(104, reg.getTotal());
                } else {
                    ps.setNull(104, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPcnvg() != null) {
                    ps.setLong(105, reg.getTotalSelecPcnvg());
                } else {
                    ps.setNull(105, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPinvg() != null) {
                    ps.setLong(106, reg.getTotalSelecPinvg());
                } else {
                    ps.setNull(106, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecTecartnvg() != null) {
                    ps.setLong(107, reg.getTotalSelecTecartnvg());
                } else {
                    ps.setNull(107, Types.LONGVARCHAR);
                }
                if (reg.getTotalIluminaNoct() != null) {
                    ps.setLong(108, reg.getTotalIluminaNoct());
                } else {
                    ps.setNull(108, Types.LONGVARCHAR);
                }
                if (reg.getTotalAnguloLuna() != null) {
                    ps.setLong(109, reg.getTotalAnguloLuna());
                } else {
                    ps.setNull(109, Types.LONGVARCHAR);
                }
                if (reg.getTotalNvg() != null) {
                    ps.setLong(110, reg.getTotalNvg());
                } else {
                    ps.setNull(110, Types.LONGVARCHAR);
                }
                if (reg.getTotalPlaneaMision() != null) {
                    ps.setLong(111, reg.getTotalPlaneaMision());
                } else {
                    ps.setNull(111, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecTripTec() != null) {
                    ps.setLong(112, reg.getTotalSelecTripTec());
                } else {
                    ps.setNull(112, Types.LONGVARCHAR);
                }
                if (reg.getTotalCategoTrip() != null) {
                    ps.setLong(113, reg.getTotalCategoTrip());
                } else {
                    ps.setNull(113, Types.LONGVARCHAR);
                }
                if (reg.getTotalMisionManual() != null) {
                    ps.setLong(114, reg.getTotalMisionManual());
                } else {
                    ps.setNull(114, Types.LONGVARCHAR);
                }
                if (reg.getTotalCompleMision() != null) {
                    ps.setLong(115, reg.getTotalCompleMision());
                } else {
                    ps.setNull(115, Types.LONGVARCHAR);
                }
                if (reg.getTotalAreaVuelo() != null) {
                    ps.setLong(116, reg.getTotalAreaVuelo());
                } else {
                    ps.setNull(116, Types.LONGVARCHAR);
                }
                if (reg.getTotalPlaneaRendi() != null) {
                    ps.setLong(117, reg.getTotalPlaneaRendi());
                } else {
                    ps.setNull(117, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPil() != null) {
                    ps.setLong(118, reg.getTotalSelecPil());
                } else {
                    ps.setNull(118, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecCpil() != null) {
                    ps.setLong(119, reg.getTotalSelecCpil());
                } else {
                    ps.setNull(119, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecTsac() != null) {
                    ps.setLong(120, reg.getTotalSelecTsac());
                } else {
                    ps.setNull(120, Types.LONGVARCHAR);
                }
                if (reg.getTotalTripCav() != null) {
                    ps.setLong(121, reg.getTotalTripCav());
                } else {
                    ps.setNull(121, Types.LONGVARCHAR);
                }
                if (reg.getTotalCondMeteoro() != null) {
                    ps.setLong(122, reg.getTotalCondMeteoro());
                } else {
                    ps.setNull(122, Types.LONGVARCHAR);
                }
                if (reg.getTotalFactAmb() != null) {
                    ps.setLong(123, reg.getTotalFactAmb());
                } else {
                    ps.setNull(123, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPillvn() != null) {
                    ps.setLong(124, reg.getTotalSelecPillvn());
                } else {
                    ps.setNull(124, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecCpillvn() != null) {
                    ps.setLong(125, reg.getTotalSelecCpillvn());
                } else {
                    ps.setNull(125, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecTsaclvn() != null) {
                    ps.setLong(126, reg.getTotalSelecTsaclvn());
                } else {
                    ps.setNull(126, Types.LONGVARCHAR);
                }
                if (reg.getTotalLvn() != null) {
                    ps.setLong(127, reg.getTotalLvn());
                } else {
                    ps.setNull(127, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPilinst() != null) {
                    ps.setLong(128, reg.getTotalSelecPilinst());
                } else {
                    ps.setNull(128, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPilestu() != null) {
                    ps.setLong(129, reg.getTotalSelecPilestu());
                } else {
                    ps.setNull(129, Types.LONGVARCHAR);
                }
                if (reg.getTotalUtripEntrena() != null) {
                    ps.setLong(130, reg.getTotalUtripEntrena());
                } else {
                    ps.setNull(130, Types.LONGVARCHAR);
                }
                if (reg.getTotalNvlPrepEntrena() != null) {
                    ps.setLong(131, reg.getTotalNvlPrepEntrena());
                } else {
                    ps.setNull(131, Types.LONGVARCHAR);
                }
                if (reg.getTotalCompleEntrena() != null) {
                    ps.setLong(132, reg.getTotalCompleEntrena());
                } else {
                    ps.setNull(132, Types.LONGVARCHAR);
                }
                if (reg.getTotalAreaAterrizaje() != null) {
                    ps.setLong(133, reg.getTotalAreaAterrizaje());
                } else {
                    ps.setNull(133, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPinlvn() != null) {
                    ps.setLong(134, reg.getTotalSelecPinlvn());
                } else {
                    ps.setNull(134, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPiestlvn() != null) {
                    ps.setLong(135, reg.getTotalSelecPiestlvn());
                } else {
                    ps.setNull(135, Types.LONGVARCHAR);
                }
                if (reg.getTotalCompleVuelo() != null) {
                    ps.setLong(136, reg.getTotalCompleVuelo());
                } else {
                    ps.setNull(136, Types.LONGVARCHAR);
                }
                if (reg.getTotalHorasTrabajadas() != null) {
                    ps.setLong(137, reg.getTotalHorasTrabajadas());
                } else {
                    ps.setNull(137, Types.LONGVARCHAR);
                }
                if (reg.getTotalMedioAmbiente() != null) {
                    ps.setLong(138, reg.getTotalMedioAmbiente());
                } else {
                    ps.setNull(138, Types.LONGVARCHAR);
                }
                if (reg.getTotalTemperatura() != null) {
                    ps.setLong(139, reg.getTotalTemperatura());
                } else {
                    ps.setNull(139, Types.LONGVARCHAR);
                }
                if (reg.getTotalTecVuelo() != null) {
                    ps.setLong(140, reg.getTotalTecVuelo());
                } else {
                    ps.setNull(140, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecMpme() != null) {
                    ps.setLong(141, reg.getTotalSelecMpme());
                } else {
                    ps.setNull(141, Types.LONGVARCHAR);
                }
                if (reg.getTotalSelecPimp() != null) {
                    ps.setLong(142, reg.getTotalSelecPimp());
                } else {
                    ps.setNull(142, Types.LONGVARCHAR);
                }
                if (reg.getTotalExpTecmec() != null) {
                    ps.setLong(143, reg.getTotalExpTecmec());
                } else {
                    ps.setNull(143, Types.LONGVARCHAR);
                }
                if (reg.getTotalFactMtto() != null) {
                    ps.setLong(144, reg.getTotalFactMtto());
                } else {
                    ps.setNull(144, Types.LONGVARCHAR);
                }
                if (reg.getUsuarioCreador() != null) {
                    ps.setString(145, reg.getUsuarioCreador());
                } else {
                    ps.setNull(145, Types.VARCHAR);
                }
                if (reg.getFechaCreacion() != null) {
                    ps.setDate(146, new java.sql.Date(reg.getFechaCreacion().getTime()));
                } else {
                    ps.setNull(146, Types.DATE);
                }
                if (reg.getUsuarioModificador() != null) {
                    ps.setString(147, reg.getUsuarioModificador());
                } else {
                    ps.setNull(147, Types.VARCHAR);
                }
                if (reg.getFechaModificacion() != null) {
                    ps.setDate(148, new java.sql.Date(reg.getFechaModificacion().getTime()));
                } else {
                    ps.setNull(148, Types.DATE);
                }
                if (reg.getPncVersion() != null) {
                    ps.setLong(149, reg.getPncVersion());
                } else {
                    ps.setNull(149, Types.LONGVARCHAR);
                }
                if (reg.getTotalNvlPrepEst() != null) {
                    ps.setLong(150, reg.getTotalNvlPrepEst());
                } else {
                    ps.setNull(150, Types.LONGVARCHAR);
                }
                if (reg.getIdConmeteoTyv() != null) {
                    ps.setLong(151, reg.getIdConmeteoTyv());
                } else {
                    ps.setNull(151, Types.LONGVARCHAR);
                }
                if (reg.getIdConmeteoModo() != null) {
                    ps.setLong(152, reg.getIdConmeteoModo());
                } else {
                    ps.setNull(152, Types.LONGVARCHAR);
                }
                if (reg.getIdFormatoRiesgo() != null) {
                    ps.setLong(153, reg.getIdFormatoRiesgo());
                } else {
                    ps.setNull(153, Types.LONGVARCHAR);
                }
                if (reg.getIdOrdenVuelo() != null) {
                    ps.setLong(154, reg.getIdOrdenVuelo());
                } else {
                    ps.setNull(154, Types.LONGVARCHAR);
                }
                
                ps.executeQuery();
                 primaryKeyEncabezado = 0l;

                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (null != generatedKeys && generatedKeys.next()) {
                    primaryKeyEncabezado = generatedKeys.getLong(1);
                    reg.setIdCriesgoFormato(primaryKeyEncabezado);
                }
                
                
                respuesta.setCodigoError(0);
                respuesta.setMensaje("inserción exitosa - en riesgos ");
                
            } catch (SQLException ex) {
                Logger.getLogger(RegistrosRiesgosDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta.setCodigoError(2);
                respuesta.setMensaje(ex.getMessage());
                
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RegistrosRiesgosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        if (respuesta.getCodigoError() != 2) {
            
            invocarPKG(reg, respuesta);
            
        }
        
    }
    
    public void invocarPKG(RegistroRiesgos reg, MensajeRespuesta respuesta) {
        Connection con = ConnectionDB.getJNDIConnection();
        CallableStatement cs = null;
        if (reg.getIdCriesgoFormato() != null) {
            if (con != null) {
                try {
                    cs = con.prepareCall(validaRiesgos);
                    
                    /*cs.setLong(1, reg.getIdOrdenVuelo());
                    cs.setLong(2, reg.getIdFormatoRiesgo());
                    
                    cs.registerOutParameter(3, Types.VARCHAR);
                    cs.registerOutParameter(4, Types.NUMERIC);
                    cs.registerOutParameter(5, Types.VARCHAR);*/
                    
                    
                    cs.setLong(1, primaryKeyEncabezado);        
                    cs.registerOutParameter(2, Types.VARCHAR);
                    cs.registerOutParameter(3, Types.NUMERIC);
                    cs.registerOutParameter(4, Types.VARCHAR);
                    
                    
                    // Ejecutar la sentencia
                    cs.execute();
                    // Verificar el resultado de la operacion
                    String riesgo = cs.getString(2);
                    int I_ERRCOD = cs.getInt(3);
                    String I_ERRBUF = cs.getString(4);
                    
                    respuesta.setNivelRiesgo(riesgo);
                    respuesta.setCodigoError(I_ERRCOD);
                    respuesta.setMensaje(I_ERRBUF);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(RegistrosRiesgosDAO.class.getName()).log(Level.SEVERE, null, ex);
                    respuesta.setCodigoError(2);
                    respuesta.setMensaje(ex.getMessage());
                } finally {
                    // Cerrar todas las conexiones. Limpiar los recursos
                    try {
                        if (cs != null) {
                            cs.close();
                        }
                        if (con != null) {
                            con.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrosRiesgosDAO.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            respuesta.setCodigoError(2);
            respuesta.setMensaje("El Id del Riesgo Formato es un campo requerido");
            
        }
    }
    
}
