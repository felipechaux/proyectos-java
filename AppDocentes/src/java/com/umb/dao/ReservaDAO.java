/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.BloqueLaboratorio;
import com.umb.entities.ReservaCalendario;
import com.umb.entities.Servicio;
import com.umb.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ReservaDAO {

    private String INSERT = "INSERT INTO reservas(id_persona,id_disponibilidad,tipo_reserva,id_materia,observacion,cantidad_estudiantes,id_grupo_laboratorio) VALUES(?,?,?,?,?,?,?)";

    private String UPDATE_R="update reservas SET id_persona=?,tipo_reserva=?,id_materia=?,cantidad_estudiantes=? WHERE id_reserva=? ";
    
    private String INSERT_P = "INSERT INTO control_prestamo(id_reserva,hora_entrada,observacion,id_persona_encargada_e) VALUES(?,?,?,?)";
    //grupo laboratorio
    private String INSERT_G = "INSERT INTO grupo_laboratorio(nombre_grupo,id_laboratorio) VALUES (?,?)";

    private String VALIDACION_INSERT_P = "SELECT * FROM control_prestamo WHERE id_reserva=? AND hora_entrada IS NOT NULL AND hora_salida IS NULL";

    private String UPDATE_P = "UPDATE control_prestamo SET hora_salida=?,id_persona_encargada_s=? WHERE id_reserva=?";

    private String VALIDACION_INSERT = "SELECT estado from disponibilidad_laboratorio WHERE id_disponibilidad =?";

    private String SELECT_S = "SELECT nombre_servicio,cantidad,descripcion,tipo_servicio FROM servicios_tecnologicos WHERE id_laboratorio=? AND tipo_servicio=?";

    private String SELECT_DL = "SELECT DISTINCT(fecha) FROM disponibilidad_laboratorio WHERE id_laboratorio=? AND estado='ACTIVO' AND fecha >=CURDATE()";

    private String SELECT_BL = "SELECT id_disponibilidad,bloque_ini,bloque_fin FROM disponibilidad_laboratorio WHERE fecha=? AND id_laboratorio=? AND estado='ACTIVO' ORDER BY bloque_ini,bloque_fin ASC ";

    private String SELECT_R = "SELECT r.id_reserva,d.fecha,d.bloque_ini,d.bloque_fin,l.nombre_laboratorio,m.nombre_materia FROM reservas r JOIN disponibilidad_laboratorio d ON r.id_disponibilidad=d.id_disponibilidad JOIN laboratorios l ON d.id_laboratorio=l.id_laboratorio JOIN materias m ON r.id_materia=m.id_materia WHERE r.id_persona=? ";
    //all reservas calendario
    private String SELECT_RC = "SELECT DISTINCT(d.fecha) FROM reservas r JOIN disponibilidad_laboratorio d ON r.id_disponibilidad=d.id_disponibilidad WHERE d.fecha >=CURDATE()";
    //reserva persona
    private String SELECT_RP = "SELECT p.nombre_persona,d.bloque_ini,d.bloque_fin,l.nombre_laboratorio,m.nombre_materia,r.tipo_reserva,r.observacion,r.cantidad_estudiantes FROM reservas r JOIN disponibilidad_laboratorio d ON r.id_disponibilidad=d.id_disponibilidad JOIN personas p ON r.id_persona=p.id_persona JOIN materias m ON r.id_materia=m.id_materia  JOIN laboratorios l ON d.id_laboratorio=l.id_laboratorio WHERE d.fecha=?";

    private String SELECT_RESERVAS = "SELECT p.nombre_persona,d.bloque_ini,d.bloque_fin,l.nombre_laboratorio,m.nombre_materia,r.tipo_reserva,r.observacion,r.cantidad_estudiantes,r.id_reserva FROM reservas r JOIN disponibilidad_laboratorio d ON r.id_disponibilidad=d.id_disponibilidad JOIN personas p ON r.id_persona=p.id_persona JOIN materias m ON r.id_materia=m.id_materia  JOIN laboratorios l ON d.id_laboratorio=l.id_laboratorio";

    Date fechaActual;

    String message;

    Servicio sreturn;

    BloqueLaboratorio breturn;

    ReservaCalendario rcreturn;

    ArrayList<Servicio> serviciosArr;

    ArrayList<BloqueLaboratorio> bloqueArr;

    ArrayList<ReservaCalendario> reservaCalendarioArr;

    ArrayList<Date> fechaArr;

    Calendar calendario;

    SimpleDateFormat añoFormat, mesFormat, diaFormat, tiempoFormat, fechaFormat, horaFormat, minutoFormat;

    public ReservaDAO() {
        tiempoFormat = new SimpleDateFormat("HH:mm");
        horaFormat = new SimpleDateFormat("HH");
        minutoFormat = new SimpleDateFormat("mm");

        añoFormat = new SimpleDateFormat("yyyy");
        mesFormat = new SimpleDateFormat("MM");
        diaFormat = new SimpleDateFormat("dd");

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean registrarGrupoLaboratorio(String nombreGrupo, int idLaboratorio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean respuesta = false;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {

                ps = con.prepareStatement(INSERT_G);
                ps.setString(1, nombreGrupo);
                ps.setInt(2, idLaboratorio);
                ps.executeUpdate();
                message = "Grupo creado";
                System.out.println("insert exitoso");
                respuesta = true;

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                message = "error " + ex.getMessage();
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
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    message = "error " + ex.getMessage();
                }
            }

        }

        return respuesta;
    }

    public boolean registrarReserva(int idPersona, int idDisponibilidad, int idMateria, String r, String observacion, int cantidadEstudiantes, int idGrupoLaboratorio) {
        System.out.println("entra a reservar");
        PreparedStatement ps = null;
        PreparedStatement vl = null;
        ResultSet rs = null;
        boolean respuesta = false;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                vl = con.prepareStatement(VALIDACION_INSERT);
                vl.setInt(1, idDisponibilidad);
                rs = vl.executeQuery();
                if (rs.next()) {
                    // System.out.println("estado resultante " + rs.getString(1));
                    switch (rs.getString(1)) {
                        case "ACTIVO":
                            ps = con.prepareStatement(INSERT);
                            ps.setInt(1, idPersona);
                            ps.setInt(2, idDisponibilidad);
                            ps.setString(3, r);
                            ps.setInt(4, idMateria);
                            ps.setString(5, observacion);
                            ps.setInt(6, cantidadEstudiantes);

                            if (idGrupoLaboratorio != 0) {
                                ps.setInt(7, idGrupoLaboratorio);
                            } else {
                                ps.setNull(7, Types.INTEGER);
                            }

                            ps.executeUpdate();
                            message = "Reserva realizada";
                            System.out.println("insert exitoso");
                            respuesta = true;
                            break;
                        case "INACTIVO":
                            message = "El bloque seleccionado ya se encuentra reservado";
                            break;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                message = "error " + ex.getMessage();
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
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    message = "error " + ex.getMessage();
                }
            }

        }
        return respuesta;
    }

    public void modificarReserva(int idPersona,String tipoReserva, int idMateria, int cantidadEstudiantes, int idReserva) {
        System.out.println("entra a modificar reserva");
        PreparedStatement ps = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {

                ps = con.prepareStatement(UPDATE_R);
                ps.setInt(1,idPersona);
                ps.setString(2,tipoReserva);
                ps.setInt(3, idMateria);
                ps.setInt(4, cantidadEstudiantes);
                
                ps.setInt(5, idReserva);

                ps.executeUpdate();
                message = "Modificacion realizada";
                System.out.println("update exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                message = "error " + ex.getMessage();
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
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    message = "error " + ex.getMessage();
                }
            }

        }
    }

    public ArrayList getDetalleServicios(int idLaboratorio, String tipoServicio) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                serviciosArr = new ArrayList<>();

                ps = con.prepareStatement(SELECT_S);
                ps.setInt(1, idLaboratorio);
                ps.setString(2, tipoServicio);

                rs = ps.executeQuery();

                while (rs.next()) {
                    sreturn = new Servicio();
                    sreturn.setNombre(rs.getString(1));
                    sreturn.setCantidad(rs.getInt(2));
                    sreturn.setDescripcion(rs.getString(3));
                    //sreturn.setTipoServicio(rs.getString(4));
                    serviciosArr.add(sreturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return serviciosArr;

    }

    public ArrayList<Date> getDisponibilidadLaboratorio(int idLaboratorio) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                fechaArr = new ArrayList<>();

                ps = con.prepareStatement(SELECT_DL);
                ps.setInt(1, idLaboratorio);

                rs = ps.executeQuery();

                while (rs.next()) {

                    calendario = Calendar.getInstance();
                    // System.out.println("fechas -> " + rs.getDate(1));
//                    System.out.println("año " + Integer.parseInt(añoFormat.format(rs.getDate(1))));
//                    System.out.println("mes " + Integer.parseInt(mesFormat.format(rs.getDate(1))));
//                    System.out.println("dia  " + Integer.parseInt(diaFormat.format(rs.getDate(1))));

                    calendario.set(Integer.parseInt(añoFormat.format(rs.getDate(1))), Integer.parseInt(mesFormat.format(rs.getDate(1))) - 1, Integer.parseInt(diaFormat.format(rs.getDate(1))));
                    fechaArr.add(calendario.getTime());

                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }

        return fechaArr;
    }

    public ArrayList<Date> getFechaReservaCalendario() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                fechaArr = new ArrayList<>();

                ps = con.prepareStatement(SELECT_RC);

                rs = ps.executeQuery();

                while (rs.next()) {

                    calendario = Calendar.getInstance();
                    // System.out.println("fechas -> " + rs.getDate(1));
//                    System.out.println("año " + Integer.parseInt(añoFormat.format(rs.getDate(1))));
//                    System.out.println("mes " + Integer.parseInt(mesFormat.format(rs.getDate(1))));
//                    System.out.println("dia  " + Integer.parseInt(diaFormat.format(rs.getDate(1))));

                    calendario.set(Integer.parseInt(añoFormat.format(rs.getDate(1))), Integer.parseInt(mesFormat.format(rs.getDate(1))) - 1, Integer.parseInt(diaFormat.format(rs.getDate(1))));
                    fechaArr.add(calendario.getTime());

                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }

        return fechaArr;
    }

    public ArrayList getReservaCalendario(String fecha) {
        System.out.println("cargar r");
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                reservaCalendarioArr = new ArrayList<>();
                if (fecha != null) {
                    ps = con.prepareStatement(SELECT_RP);
                    ps.setString(1, fecha);
                } else {
                    ps = con.prepareStatement(SELECT_RESERVAS);
                }
                rs = ps.executeQuery();

                while (rs.next()) {
                    rcreturn = new ReservaCalendario();

                    rcreturn.setNombreUsuario(rs.getString(1));
                    rcreturn.setBloque(tiempoFormat.format(rs.getTime(2)) + " - " + tiempoFormat.format(rs.getTime(3)));
                    rcreturn.setNombreLaboratorio(rs.getString(4));
                    rcreturn.setNombreMateria(rs.getString(5));
                    rcreturn.setTipoReserva(rs.getString(6));
                    rcreturn.setObservacion(rs.getString(7));
                    rcreturn.setCantidadEstudiantes(rs.getInt(8));
                    if (fecha == null) {
                        rcreturn.setIdReserva(rs.getInt(9));
                    }
                    reservaCalendarioArr.add(rcreturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return reservaCalendarioArr;

    }

    public ArrayList getBloqueLaboratorio(String fecha, int idLaboratorio) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                bloqueArr = new ArrayList<>();
                ps = con.prepareStatement(SELECT_BL);
                ps.setString(1, fecha);
                ps.setInt(2, idLaboratorio);

                rs = ps.executeQuery();

                while (rs.next()) {
                    breturn = new BloqueLaboratorio();

//                    System.out.println("id bloque "+rs.getInt(1));
//                    System.out.println("bloque ini "+rs.getString(2));
//                    System.out.println("bloque new "+tiempoFormat.format(rs.getTime(2)));
                    breturn.setId(rs.getInt(1));
                    breturn.setBloque(tiempoFormat.format(rs.getTime(2)) + " - " + tiempoFormat.format(rs.getTime(3)));
                    bloqueArr.add(breturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return bloqueArr;

    }

    public ArrayList consultarReserva(int idPersona) {

        fechaActual = new Date();
        fechaFormat = new SimpleDateFormat("yyyy-dd-MM");

        System.out.println("fecha actual " + fechaActual);

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                bloqueArr = new ArrayList<>();
                ps = con.prepareStatement(SELECT_R);
                ps.setInt(1, idPersona);

                rs = ps.executeQuery();

                while (rs.next()) {

                    System.out.println("result reservas ");

//                    System.out.println("fecha bd "+fechaFormat.format(rs.getDate(1)));
//                    System.out.println("fecha actual "+fechaFormat.format(fechaActual));
                    if (fechaFormat.format(rs.getDate(2)).equals(fechaFormat.format(fechaActual))) {

                        System.out.println("tiene reservas para hoy");
//                        System.out.println("reserva N° " + rs.getInt(1));
//                        System.out.println("fecha " + rs.getDate(2));
//                        System.out.println(" bloque ini " + rs.getString(3) + " bloque fin " + rs.getString(4));
//                        System.out.println("laboratorio " + rs.getString(5));
//                        System.out.println("materia " + rs.getString(6));
                        breturn = new BloqueLaboratorio();
                        breturn.setId(rs.getInt(1));
                        breturn.setFecha(rs.getDate(2));
                        //llenar los bloques  ini y fin
                        breturn.setBloqueInicio(rs.getTime(3));
                        breturn.setBloqueFin(rs.getTime(4));
                        breturn.setBloque(rs.getString(3) + " - " + rs.getString(4));
                        breturn.setNombreLaboratorio(rs.getString(5));
                        breturn.setNombreAsignaturaReserva(rs.getString(6));
                        bloqueArr.add(breturn);

                        //
                        //
                    } else {
                        System.out.println("no hay reservas para hoy");
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }

        return bloqueArr;

    }

    public void registrarPrestamo(int idReserva, Date horaEntrada, String observacion, int idEncargado) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {

                ps = con.prepareStatement(INSERT_P);
                ps.setInt(1, idReserva);
                ps.setTime(2, new java.sql.Time(new Date().getTime()));
                if (observacion != null) {
                    ps.setString(3, observacion);
                } else {
                    ps.setNull(3, Types.VARCHAR);
                }
                ps.setInt(4, idEncargado);
                ps.executeUpdate();

                message = "Prestamo registrado";

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                message = "error " + ex.getMessage();
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
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    message = "error " + ex.getMessage();
                }
            }

        }
    }

    public boolean validarReserva(Date bloqueInicio, String param) {

        fechaActual = new Date();
//        System.out.println("fecha ini " + bloqueInicio);
//        System.out.println("h1 " + horaFormat.format(bloqueInicio));
//        System.out.println("m2 " + minutoFormat.format(bloqueInicio));
//
//        System.out.println("fecha actual ");
//        System.out.println("h1 " + horaFormat.format(fechaActual));
//        System.out.println("m2 " + minutoFormat.format(fechaActual));

        int hora1 = Integer.parseInt(horaFormat.format(bloqueInicio));
        int min1 = Integer.parseInt(minutoFormat.format(bloqueInicio));

        int hora2 = Integer.parseInt(horaFormat.format(fechaActual));
        int min2 = Integer.parseInt(minutoFormat.format(fechaActual));

        int horamin1 = hora1 * 60 + min1;
        int horamin2 = hora2 * 60 + min2;

        int totalminutos = 0;

        switch (param) {
            case "entrada":
                totalminutos = horamin2 - horamin1;
                break;
            case "salida":
                totalminutos = horamin1 - horamin2;
                break;
        }

        if (totalminutos < 0) {
            totalminutos += 60 * 24; // intervalo corta medianoche
        }
        //horas -> totalminutos > h * 60
        System.out.println("minutos transcurridos  -> " + totalminutos);
        return totalminutos <= 15;

    }

    public boolean validarPrestamo(int idReserva, int idEncargado, Date bloqueFin) {

        System.out.println("idEncargado update " + idEncargado);
        PreparedStatement ps = null, psu = null;
        ResultSet rs = null;
        boolean respuesta = false;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {

                ps = con.prepareStatement(VALIDACION_INSERT_P);
                ps.setInt(1, idReserva);

                rs = ps.executeQuery();

                if (rs.next()) {
                    respuesta = true;
                    System.out.println("si update ");

                    if (validarReserva(bloqueFin, "salida")) {
                        System.out.println("si salida");
                        psu = con.prepareStatement(UPDATE_P);
                        psu.setTime(1, new java.sql.Time(new Date().getTime()));
                        psu.setInt(2, idEncargado);
                        psu.setInt(3, idReserva);

                        psu.executeUpdate();
                        message = "Entrega realizada";
                    } else {
                        System.out.println("no salida");
                        message = "Debe entregar en el tiempo estimado, (Entrega no realizada)";
                    }
//                   

                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar todas las conexiones. Limpiar los recursos
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }

        }
        return respuesta;
    }

}
