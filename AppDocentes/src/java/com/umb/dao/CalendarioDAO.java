/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umb.dao;

import com.umb.entities.BloqueLaboratorio;
import com.umb.util.ConexionDB;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Administrador
 */
//persistencia a base de datos // disponibilidades, bloques laboratorio

public class CalendarioDAO {

    //consulta que captura la disponibilidad por laboratorios
    private String SELECT_B = "SELECT d.id_disponibilidad,d.fecha,d.bloque_ini,d.bloque_fin,d.id_laboratorio,l.nombre_laboratorio,estado FROM disponibilidad_laboratorio d JOIN laboratorios l ON d.id_laboratorio=l.id_laboratorio";
    //consulta que registra una disponibilidad
    private String INSERT_B = "INSERT INTO disponibilidad_laboratorio(fecha,bloque_ini,id_laboratorio) VALUES (?,?,?)";
    //consulta que registrar los datos del cargue masivo de bloques
    private String INSERT_IMPORT="INSERT INTO disponibilidad_laboratorio(fecha,bloque_ini,id_laboratorio) VALUES (?,?,?)";
    //consulta para modificar lun bloque
    private String UPDATE_B = "UPDATE disponibilidad_laboratorio SET fecha=?,bloque_ini=?,bloque_fin=?,id_laboratorio=? WHERE id_disponibilidad=? ";

    String message;

    ArrayList<BloqueLaboratorio> bloqueArr;

    BloqueLaboratorio breturn;

    SimpleDateFormat horaFormat;

    public CalendarioDAO() {
        horaFormat = new SimpleDateFormat("HH:mm");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void importar(InputStream file) throws IOException, SQLException, ParseException {

        PreparedStatement ps = null;
        Connection con = ConexionDB.ConnectDB();

        try {

            ArrayList<String> columnas = new ArrayList();
            columnas.add("fecha");
            columnas.add("bloque_ini");
            //columnas.add("bloque_fin");
            columnas.add("laboratorio");

            ps = con.prepareStatement(INSERT_IMPORT);

            Map<String, Integer> mapNombresColumnas = new HashMap<>();

            final int filaNombresColumnas = 0;

            HSSFWorkbook my_xls_workbook = new HSSFWorkbook(file);

            HSSFSheet sheet = my_xls_workbook.getSheetAt(0);
//acceder a la fila con los nombres de las columnas
            Row filaNombresColumna = sheet.getRow(filaNombresColumnas);

            for (Cell cell : filaNombresColumna) {
                String valorCelda = cell.getStringCellValue().trim();
                if (!valorCelda.isEmpty()) {
                    mapNombresColumnas.put(valorCelda, cell.getColumnIndex());
                }
//siguiente a la fila donde están los nombres de las columnas
                int indiceDatos = filaNombresColumnas + 1;

                Row filaDatos = null;
//recorrer todas las filas con datos
                while ((filaDatos = sheet.getRow(indiceDatos++)) != null) {
                    //se procesan solo las celdas en base a los "nombres" de esas columnas
                    for (String col : columnas) {

                        if (mapNombresColumnas.get(col) != null) {
                            int indice = mapNombresColumnas.get(col) + 1;

                            System.out.println("indice >>" + indice + " valor >> " + filaDatos.getCell(mapNombresColumnas.get(col)));
                            if (indice == 1) {
                                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                                //String dateInString = String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col)));
                                //ps.setDate(1, new java.sql.Date(new Date(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col)))).getTime()));
                                ps.setDate(1, new java.sql.Date(formatter.parse(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col)))).getTime()));
                            }
                            if (indice == 2) {
                                //System.out.println("tim1 " + horaFormat.parse(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col)))).getTime());
                                ps.setTime(2, new java.sql.Time(horaFormat.parse(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col)))).getTime()));

                            }
                            if (indice == 3) {

                                //System.out.println("tim2" + horaFormat.parse(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col)))).getTime());
                                // ps.setTime(3, new java.sql.Time(horaFormat.parse(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col)))).getTime()));
                                ps.setInt(3, ((Double) Double.parseDouble(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col))))).intValue());
                                System.out.println("query ");
                                ps.execute();
                            }
                            if (indice == 4) {
                                // 
                                // System.out.println("lab " + dou.intValue());
//                                ps.setInt(3, ((Double) Double.parseDouble(String.valueOf(filaDatos.getCell(mapNombresColumnas.get(col))))).intValue());
//                                System.out.println("query ");
//                                ps.execute();
                            }
                        }
                    }
                    // ps.execute();

                }
            }
            message = "Importacion exitosa ";
            con.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("error en sql" + e);
            message = "error en sql " + e.getMessage();
        } catch (IOException e) {
            System.out.println("error en columnas" + e);
            message = "error en columnas " + e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println("error en celdas " + e);
            message = "error en celdas " + e.getMessage();
        }

    }

    public boolean registrarBloque(Date fecha, Date bloqueInicio, Date bloqueFin, int idLaboratorio) {
        System.out.println("entra a registrar bloque");
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean respuesta = false;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(INSERT_B);
                ps.setDate(1, new java.sql.Date(fecha.getTime()));
                ps.setTime(2, new java.sql.Time(bloqueInicio.getTime()));
                // ps.setTime(3, new java.sql.Time(bloqueFin.getTime()));
                ps.setInt(3, idLaboratorio);
                ps.executeUpdate();
                respuesta = true;
                message = "Calendario registrado";
                System.out.println("insert exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(CalendarioDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(CalendarioDAO.class
                            .getName()).log(Level.SEVERE, null, ex);
                    message = "error " + ex.getMessage();
                }
            }

        }
        return respuesta;
    }

    public void modificarBloque(int idCalendario, Date fecha, Date bloqueInicio, Date bloqueFin, int idLaboratorio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();

        if (con != null) {
            try {
                ps = con.prepareStatement(UPDATE_B);
                ps.setDate(1, new java.sql.Date(fecha.getTime()));
                ps.setTime(2, new java.sql.Time(bloqueInicio.getTime()));
                ps.setTime(3, new java.sql.Time(bloqueFin.getTime()));
                ps.setInt(4, idLaboratorio);
                ps.setInt(5, idCalendario);
                ps.executeUpdate();

                message = "Bloque modificado";
                System.out.println("update exitoso");

            } catch (SQLException ex) {
                Logger.getLogger(CalendarioDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(CalendarioDAO.class
                            .getName()).log(Level.SEVERE, null, ex);
                    message = "error " + ex.getMessage();
                }
            }

        }

    }

    public ArrayList getBloques() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionDB.ConnectDB();
        if (con != null) {
            try {
                bloqueArr = new ArrayList<>();
                ps = con.prepareStatement(SELECT_B);

                rs = ps.executeQuery();

                while (rs.next()) {
                    breturn = new BloqueLaboratorio();
//
//                    System.out.println("id disponibilidad " + rs.getInt(1));
//                    System.out.println("fecha " + rs.getDate(2));
//                    System.out.println("bloque ini " + rs.getTime(3));
//                    System.out.println("bloque fin " + rs.getTime(4));
//                    System.out.println("id laboratorio " + rs.getInt(5));
//                    System.out.println("estado " + rs.getString(6));
                    breturn.setId(rs.getInt(1));
                    breturn.setFecha(rs.getDate(2));
                    breturn.setBloqueInicio(new java.sql.Time(rs.getTime(3).getTime()));
                    breturn.setBloqueFin(new java.sql.Time(rs.getTime(4).getTime()));
                    breturn.setIdLaboratorio(rs.getInt(5));
                    breturn.setNombreLaboratorio(rs.getString(6));
                    breturn.setEstado(rs.getString(7));
                    bloqueArr.add(breturn);

                }

            } catch (SQLException ex) {
                Logger.getLogger(CalendarioDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(CalendarioDAO.class
                            .getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return bloqueArr;

    }
}
