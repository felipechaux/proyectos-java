import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class interfaceinf extends JFrame {
	// create by felchax y Krstian
	/* DATOS PARA LA CONEXION */

	/** nombre de la base de datos */
	private String db = "bd_jazzplat";
	/** usuario */
	private String user = "root";
	/** contrase�a de MySql */
	private String password = "";
	/** Cadena de conexion */
	
	private String url = "jdbc:mysql://172.16.58.202:2020/" + db + user + password;
	/** variable para trabajar con la conexion a la base de datos */
	private Connection conn = null;
	/** ruta y archivo de destino */

	
	// File file = new File("reporte("+x+").xls");
	Object e, aa, b;
	DecimalFormat deci, deci_2;
	String recibe = "";
	String recibe_sum = "", recibe_sum_2 = "", recibe_sum_3 = "",
			recibe_porcentaje_aprobado = "",
			recibe_porcentaje_no_aprobado = "", recibe_total = "";

	int sum, sum_2, sum_3;
	double pro, pro_2, pro_3, porcentaje_aprobado, porcentaje_no_aprobado;
	int total[] = new int[70];

	int ACC_PRES, ACC_PRES_2, ACC_PRES_3, ACC_PRES_4, ACC_PRES_5, ACC_PRES_6,
			ACC_PRES_7;
	int ACC_OK, ACC_OK2, ACC_OK3, ACC_OK4, ACC_OK5, ACC_OK6, ACC_OK7; // ACC
	int ACC_KO, ACC_KO2, ACC_KO3, ACC_KO4, ACC_KO5, ACC_KO6, ACC_KO7;

	int RETENCI, RETENCI_2, RETENCI_3, RETENCI_4, RETENCI_5, RETENCI_6,
			RETENCI_7;
	int RETENCI_OK, RETENCI_OK_2, RETENCI_OK_3, RETENCI_OK_4, RETENCI_OK_5,
			RETENCI_OK_6, RETENCI_OK_7; // retencion
	int RETENCI_KO, RETENCI_KO_2, RETENCI_KO_3, RETENCI_KO_4, RETENCI_KO_5,
			RETENCI_KO_6, RETENCI_KO_7;

	int recla_press, recla_press2, recla_press3, recla_press4, recla_press5,
			recla_press6, recla_press7;
	int recla_ok, recla_ok2, recla_ok3, recla_ok4, recla_ok5, recla_ok6,
			recla_ok7; // reclamaciones
	int recla_ko, recla_ko2, recla_ko3, recla_ko4, recla_ko5, recla_ko6,
			recla_ko7;

	int ATC, ATC2, ATC3, ATC4, ATC5, ATC6, ATC7;
	int ATC_OK, ATC_OK2, ATC_OK3, ATC_OK4, ATC_OK5, ATC_OK6, ATC_OK7; // ATC
	int ATC_KO, ATC_KO2, ATC_KO3, ATC_KO4, ATC_KO5, ATC_KO6, ATC_KO7;

	int ven, ven2, ven3, ven4, ven5, ven6, ven7;
	int ven_ok, ven_ok2, ven_ok3, ven_ok4, ven_ok5, ven_ok6, ven_ok7; // ventas
	int ven_ko, ven_ko2, ven_ko3, ven_ko4, ven_ko5, ven_ko6, ven_ko7;

	// ACC_OK+RETENCI_OK+recla_ok+ATCK_OK+ven_ok+provi_ok+adls_ok+omv_ok+cobros_ok+tras_ok+bajas_ok+multi_ok+avv_ok
	int provi, provi2, provi3, provi4, provi5, provi6, provi7;
	int provi_ok, provi_ok2, provi_ok3, provi_ok4, provi_ok5, provi_ok6,
			provi_ok7; // provision
	int provi_ko, provi_ko2, provi_ko3, provi_ko4, provi_ko5, provi_ko6,
			provi_ko7;

	int adls, adls2, adls3, adls4, adls5, adls6, adls7;
	int adls_ok, adls_ok2, adls_ok3, adls_ok4, adls_ok5, adls_ok6, adls_ok7; // adls
	int adls_ko, adls_ko2, adls_ko3, adls_ko4, adls_ko5, adls_ko6, adls_ko7;

	int omv, omv2, omv3, omv4, omv5, omv6, omv7;
	int omv_ok, omv_ok2, omv_ok3, omv_ok4, omv_ok5, omv_ok6, omv_ok7; // movil
	int omv_ko, omv_ko2, omv_ko3, omv_ko4, omv_ko5, omv_ko6, omv_ko7;

	int cobros, cobros2, cobros3, cobros4, cobros5, cobros6, cobros7;
	int cobros_ok, cobros_ok2, cobros_ok3, cobros_ok4, cobros_ok5, cobros_ok6,
			cobros_ok7; // cobros
	int cobros_ko, cobros_ko2, cobros_ko3, cobros_ko4, cobros_ko5, cobros_ko6,
			cobros_ko7;

	int tras, tras2, tras3, tras4, tras5, tras6, tras7;
	int tras_ok, tras_ok2, tras_ok3, tras_ok4, tras_ok5, tras_ok6, tras_ok7; // traslados
	int tras_ko, tras_ko2, tras_ko3, tras_ko4, tras_ko5, tras_ko6, tras_ko7;

	int bajas, bajas2, bajas3, bajas4, bajas5, bajas6, bajas7;
	int bajas_ok, bajas_ok2, bajas_ok3, bajas_ok4, bajas_ok5, bajas_ok6,
			bajas_ok7;
	int bajas_ko, bajas_ko2, bajas_ko3, bajas_ko4, bajas_ko5, bajas_ko6,
			bajas_ko7;

	int multi, multi2, multi3, multi4, multi5, multi6, multi7;
	int multi_ok, multi_ok2, multi_ok3, multi_ok4, multi_ok5, multi_ok6,
			multi_ok7;
	int multi_ko, multi_ko2, multi_ko3, multi_ko4, multi_ko5, multi_ko6,
			multi_ko7;

	int avv, avv2, avv3, avv4, avv5, avv6, avv7;
	int avv_ok, avv_ok2, avv_ok3, avv_ok4, avv_ok5, avv_ok6, avv_ok7;
	int avv_ko, avv_ko2, avv_ko3, avv_ko4, avv_ko5, avv_ko6, avv_ko7;

	int xox;
	int dif, var;
	File filed;
	File mostrar;
	File file[];
	public String xx;
	// File files[];

	String a;
	// int cont,otra;

	JPanel contentPane;
	JComboBox comboBox;
	String variable;
	String sector[] = { "" };
	private JLabel lblSuInforme;
	private JLabel jazzquiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceinf frame = new interfaceinf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carg() {

		try {
			var = 1;
			file = new File[50];

			xox = 1;
			if (xox == 1) {

				file[1] = new File("reporte.xls");

				mostrar = file[1];
			}

			if (file[1].exists()) {
				file[2] = new File("reporte(1).xls");
				mostrar = file[2];
			}
			if ((file[2].exists()) && (file[1].exists())) {
				file[3] = new File("reporte(2).xls");
				mostrar = file[3];
			}
			if ((file[3].exists()) && (file[2].exists()) && (file[1].exists())) {
				file[4] = new File("reporte(3).xls");
				mostrar = file[4];
			}
			if ((file[4].exists()) && (file[3].exists()) && (file[2].exists())
					&& (file[1].exists())) {
				file[5] = new File("reporte(4).xls");
				mostrar = file[5];
			}
			if ((file[5].exists()) && (file[4].exists()) && (file[3].exists())
					&& (file[2].exists()) && (file[1].exists())) {
				file[6] = new File("reporte(5).xls");
				mostrar = file[6];
			}
			if ((file[6].exists()) && (file[5].exists()) && (file[4].exists())
					&& (file[3].exists()) && (file[2].exists())
					&& (file[1].exists())) {
				file[7] = new File("reporte(6).xls");
				mostrar = file[7];
			}
			if ((file[7].exists()) && (file[6].exists()) && (file[5].exists())
					&& (file[4].exists()) && (file[3].exists())
					&& (file[2].exists()) && (file[1].exists())) {
				file[8] = new File("reporte(7).xls");
				mostrar = file[8];
			}
			if ((file[8].exists()) && (file[7].exists()) && (file[6].exists())
					&& (file[5].exists()) && (file[4].exists())
					&& (file[3].exists()) && (file[2].exists())
					&& (file[1].exists())) {

				file[9] = new File("reporte(8).xls");
				mostrar = file[9];
			}

			// /////////////////////////////////////////limite---------8--
			// reportes
			if ((file[9].exists()) && (file[8].exists()) && (file[7].exists())
					&& (file[6].exists()) && (file[5].exists())
					&& (file[4].exists()) && (file[3].exists())
					&& (file[2].exists()) && (file[1].exists())) {
				JOptionPane
						.showMessageDialog(
								null,
								"Ha Alcanzado El Limite de Reportes \n Elimine uno o mas reportes para la Creacion de Uno Nuevo");

				file[8] = new File("");
				file[8].deleteOnExit();
				mostrar = file[8];

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * Create the frame.
	 */
	public void cargar_2() {

		try {
			var = 1;
			file = new File[50];

			xox = 1;
			if (xox == 1) {

				file[1] = new File("Reporte_final.xls");

				mostrar = file[1];
			}

			if (file[1].exists()) {
				file[2] = new File("Reporte_final(1).xls");
				mostrar = file[2];
			}
			if ((file[2].exists()) && (file[1].exists())) {
				file[3] = new File("Reporte_final(2).xls");
				mostrar = file[3];
			}
			if ((file[3].exists()) && (file[2].exists()) && (file[1].exists())) {
				file[4] = new File("Reporte_final(3).xls");
				mostrar = file[4];
			}
			if ((file[4].exists()) && (file[3].exists()) && (file[2].exists())
					&& (file[1].exists())) {
				file[5] = new File("Reporte_final(4).xls");
				mostrar = file[5];
			}
			if ((file[5].exists()) && (file[4].exists()) && (file[3].exists())
					&& (file[2].exists()) && (file[1].exists())) {
				file[6] = new File("Reporte_final(5).xls");
				mostrar = file[6];
			}
			if ((file[6].exists()) && (file[5].exists()) && (file[4].exists())
					&& (file[3].exists()) && (file[2].exists())
					&& (file[1].exists())) {
				file[7] = new File("Reporte_final(6).xls");
				mostrar = file[7];
			}
			if ((file[7].exists()) && (file[6].exists()) && (file[5].exists())
					&& (file[4].exists()) && (file[3].exists())
					&& (file[2].exists()) && (file[1].exists())) {
				file[8] = new File("Reporte_final(7).xls");
				mostrar = file[8];
			}
			if ((file[8].exists()) && (file[7].exists()) && (file[6].exists())
					&& (file[5].exists()) && (file[4].exists())
					&& (file[3].exists()) && (file[2].exists())
					&& (file[1].exists())) {

				file[9] = new File("Reporte_final(8).xls");
				mostrar = file[9];
			}

			// /////////////////////////////////////////limite---------8--
			// reportes
			if ((file[9].exists()) && (file[8].exists()) && (file[7].exists())
					&& (file[6].exists()) && (file[5].exists())
					&& (file[4].exists()) && (file[3].exists())
					&& (file[2].exists()) && (file[1].exists())) {
				JOptionPane
						.showMessageDialog(
								null,
								"Ha Alcanzado El Limite de Reportes Finales \n Elimine uno o mas reportes para la Creacion de Uno Nuevo");

				file[8] = new File("");
				file[8].deleteOnExit();
				mostrar = file[8];

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public interfaceinf() throws CloneNotSupportedException {
		setTitle("JazzQuiz_Informes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				interfaceinf.class.getResource("img/logo_frame.png")));
		// ////////////////////inicia conexion//
		this.url = "jdbc:mysql://172.16.58.202:2020/" + this.db;
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			// obtenemos la conexi�n
			conn = DriverManager.getConnection(this.url, this.user,
					this.password);
			if (conn != null) {
				// System.out.println("Conexi�n a la base de datos "+this.db+"...... Listo ");
				JOptionPane.showMessageDialog(null,
						"Conexion a la base de datos " + this.db
								+ "...... Listo ");
			}
		} catch (SQLException e) {
			Component panel = null;
			JOptionPane.showMessageDialog(panel,
					"Conexion Fallida Con Base De Datos", "",
					JOptionPane.ERROR_MESSAGE);
	
			clone();
		} catch (ClassNotFoundException e) {
			Component panel = null;
			JOptionPane.showMessageDialog(panel,
					"Conexion Fallida Con Base De Datos", "",
					JOptionPane.ERROR_MESSAGE);
	
			
		}

		setBackground(new Color(245, 245, 220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 244);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(
				255, 165, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Seleccione el sector del cual quiere obtener");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 78, 404, 23);
		contentPane.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.setBounds(145, 153, 175, 30);
		contentPane.add(comboBox);

		String co = "SELECT distinct Sector  FROM respuestas ";
		try {
			PreparedStatement pstm = conn.prepareStatement(co);
			ResultSet res = pstm.executeQuery();

			while (res.next()) {

				System.out.print("" + res.getString("Sector"));
				xx = res.getString("Sector");

				comboBox.addItem(xx);
			}

			// JOptionPane.showMessageDialog(null,"");
		} catch (Exception e) {
			// TODO: handle exception
		}

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carg();

				e = comboBox.getSelectedItem();

				variable = String.valueOf(e);

				JOptionPane.showMessageDialog(null, "Sector Seleccionado:   "
						+ variable);

				int row = 1;
				// formato fuente para el contenido contenido
				WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
						WritableFont.NO_BOLD);
				WritableCellFormat cf = new WritableCellFormat(wf);

				// Interfaz para una hoja de clculo
				WritableSheet excelSheet = null;
				WritableWorkbook workbook = null;

				// Establece la configuracin regional para generar la hoja de
				// clculo
				WorkbookSettings wbSettings = new WorkbookSettings();
				wbSettings.setLocale(new Locale("en", "EN"));

				try {

					workbook = Workbook.createWorkbook(mostrar, wbSettings);
					// hoja con nombre de la tabla
					workbook.createSheet("reporte", 0);
					excelSheet = workbook.getSheet(0);

					JOptionPane.showMessageDialog(null,
							"creando hoja excel.....Listo");

				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				}

				// Consulta SQL
				String sql = "SELECT * FROM respuestas WHERE Sector='"
						+ variable + "'";
				try {
					PreparedStatement pstm = conn.prepareStatement(sql);
					ResultSet res = pstm.executeQuery();

					while (res.next()) {
						excelSheet.addCell(new jxl.write.Label(0, 0, "Sector"));// A
						excelSheet.addCell(new jxl.write.Label(1, 0, "Cargo"));// B
						excelSheet.addCell(new jxl.write.Label(2, 0,
								"Nombre_Completo"));// C
						excelSheet
								.addCell(new jxl.write.Label(3, 0, "User_win"));// D
						excelSheet
								.addCell(new jxl.write.Label(4, 0, "Rta_User"));// E
						excelSheet.addCell(new jxl.write.Label(5, 0,
								"Id_pregunta"));// F
						excelSheet.addCell(new jxl.write.Label(6, 0, "Fecha"));// G
						excelSheet.addCell(new jxl.write.Label(7, 0,
								"Evaluacion"));// H

						Label se = new Label(0, row, res.getString("Sector"),
								cf);
						Label carg = new Label(1, row, res.getString("Cargo"),
								cf);
						Label pers = new Label(2, row, res
								.getString("Personal"), cf);
						Label use = new Label(3, row,
								res.getString("User_win"), cf);
						Label rta = new Label(4, row,
								res.getString("Rta_User"), cf);
						Label pre = new Label(5, row, res
								.getString("Id_pregunta"), cf);
						Label fecha = new Label(6, row, res.getString("fecha"),
								cf);
						Label evalua = new Label(7, row, res
								.getString("Evaluacion"), cf);

						row++;
						try {
							excelSheet.addCell(se);
							excelSheet.addCell(carg);
							excelSheet.addCell(pers);
							excelSheet.addCell(use);
							excelSheet.addCell(rta);
							excelSheet.addCell(pre);
							excelSheet.addCell(fecha);
							excelSheet.addCell(evalua);

						} catch (WriteException ex) {

							JOptionPane.showMessageDialog(null,
									"" + ex.getMessage());

						}
					}
					res.close();
				} catch (SQLException f) {

					JOptionPane.showMessageDialog(null, "" + f.getMessage());
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Escribe el archivo excel en disco
				try {
					workbook.write();
					workbook.close();

					JOptionPane.showMessageDialog(null, "Escribiendo ...Listo");
				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				} catch (WriteException ex) {
					System.err.println(ex.getMessage());
				}

				JOptionPane.showMessageDialog(null, "Proceso completado");
			}

		});
		btnGenerar.setBounds(29, 195, 89, 23);
		contentPane.add(btnGenerar);

		lblSuInforme = new JLabel("su informe");
		lblSuInforme.setForeground(Color.WHITE);
		lblSuInforme.setFont(new Font("Arial", Font.BOLD, 18));
		lblSuInforme.setBounds(165, 119, 148, 23);
		contentPane.add(lblSuInforme);

		jazzquiz = new JLabel("\r\n");
		jazzquiz.setIcon(new ImageIcon("src/img/jazz1.png"));
		jazzquiz.setBounds(29, 11, 164, 49);
		contentPane.add(jazzquiz);

		// /En esta parte se inicia el informe final
		// /En esta parte se inicia el informe final
		// /En esta parte se inicia el informe final

		JButton Informe = new JButton("Final");
		Informe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				cargar_2();
				WritableFont wr = new WritableFont(WritableFont.ARIAL, 10,
						WritableFont.NO_BOLD);
				WritableCellFormat crear = new WritableCellFormat(wr);

				// Interfaz para una hoja de clculo
				WritableSheet Sheet = null;
				WritableWorkbook book = null;

				// Establece la configuracin regional para generar la hoja de
				// clculo
				WorkbookSettings config = new WorkbookSettings();
				config.setLocale(new Locale("en", "EN"));

				try {

					book = Workbook.createWorkbook(mostrar, config);
					// hoja con nombre de la tabla
					book.createSheet("reporte final", 0);
					Sheet = book.getSheet(0);

					JOptionPane.showMessageDialog(null,
							"creando hoja excel.....Listo");

				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				}

				// Consulta SQL
				String sql = "SELECT * FROM respuestas ";
				try {
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					if (rs.next()) {
						Sheet.addCell(new jxl.write.Label(0, 3, "COMERCIAL"));// 3
						Sheet.addCell(new jxl.write.Label(0, 4, ""));// 4
						Sheet.addCell(new jxl.write.Label(0, 5, "RECLAMACIONES"));// 5
						Sheet.addCell(new jxl.write.Label(0, 6, "ATC"));// 6
						Sheet.addCell(new jxl.write.Label(0, 7, "VENTAS"));// 7
						Sheet.addCell(new jxl.write.Label(0, 8, "PROVISION"));// 8
						Sheet.addCell(new jxl.write.Label(0, 9, "SYC ADSL"));// 9
						Sheet.addCell(new jxl.write.Label(0, 10, "SYC OMV"));// 10
						Sheet.addCell(new jxl.write.Label(0, 11,
								"COBROS Y TRASLADOS"));// 11
						Sheet.addCell(new jxl.write.Label(0, 1, ""));// 12
						Sheet.addCell(new jxl.write.Label(0, 13, "AVR BAJAS"));// 13
						Sheet.addCell(new jxl.write.Label(0, 14,
								"AVR MULTISKILL"));// 14
						Sheet.addCell(new jxl.write.Label(0, 15, "VENTAS AVV"));// 15
						Sheet.addCell(new jxl.write.Label(1, 16,
								"TOTAL JAZZPLAT"));// 1,16
						Sheet.addCell(new jxl.write.Label(1, 2, "�REA"));// 1,B
						Sheet.addCell(new jxl.write.Label(2, 2, "Pres"));// 1,C
						Sheet.addCell(new jxl.write.Label(3, 2, "OK"));// 1,D
						Sheet.addCell(new jxl.write.Label(4, 2, "KO"));// 1,E
						Sheet.addCell(new jxl.write.Label(5, 2, "Pres"));// 1,F
						Sheet.addCell(new jxl.write.Label(6, 2, "OK"));// 1,G
						Sheet.addCell(new jxl.write.Label(7, 2, "KO"));// 1,H
						Sheet.addCell(new jxl.write.Label(8, 2, "Pres"));// 1,I
						Sheet.addCell(new jxl.write.Label(9, 2, "OK"));// 1,J
						Sheet.addCell(new jxl.write.Label(10, 2, "KO"));// 1,k
						Sheet.addCell(new jxl.write.Label(11, 2, "Pres"));// 1,L
						Sheet.addCell(new jxl.write.Label(12, 2, "OK"));// 1,M
						Sheet.addCell(new jxl.write.Label(13, 2, "KO"));// 1,N
						Sheet.addCell(new jxl.write.Label(14, 2, "Pres"));// 1,O
						Sheet.addCell(new jxl.write.Label(15, 2, "OK"));// 1,P
						Sheet.addCell(new jxl.write.Label(16, 2, "KO"));// 1,Q
						Sheet.addCell(new jxl.write.Label(17, 2, "Pres"));// 1,R
						Sheet.addCell(new jxl.write.Label(18, 2, "OK"));// 1,S
						Sheet.addCell(new jxl.write.Label(19, 2, "KO"));// 1,T
						Sheet.addCell(new jxl.write.Label(20, 2, "Pres"));// 1,U
						Sheet.addCell(new jxl.write.Label(21, 2, "OK"));// 1,W
						Sheet.addCell(new jxl.write.Label(22, 2, "KO"));// 1,X
						Sheet.addCell(new jxl.write.Label(1, 3, "ACC"));// 1,3
						Sheet.addCell(new jxl.write.Label(1, 4, "RETENCI�N"));// 1,4
						Sheet.addCell(new jxl.write.Label(1, 5, "RECLAMACIONES"));// 1,5
						Sheet.addCell(new jxl.write.Label(1, 6, "ATC"));// 1,6
						Sheet.addCell(new jxl.write.Label(1, 7, "VENTAS"));// 1,7
						Sheet.addCell(new jxl.write.Label(1, 8, "PROVISI�N"));// 1,8
						Sheet.addCell(new jxl.write.Label(1, 9, "SYC ADSL"));// 1,9
						Sheet.addCell(new jxl.write.Label(1, 10, "SYC OMV"));// 1,10
						Sheet.addCell(new jxl.write.Label(1, 11, "COBROS"));// 1,11
						Sheet.addCell(new jxl.write.Label(1, 12, "TRASLADOS"));// 1,12
						Sheet.addCell(new jxl.write.Label(1, 13, "AVR BAJAS"));// 1,13
						Sheet.addCell(new jxl.write.Label(1, 14,
								"AVR MULTISKILL"));// 1,14
						Sheet.addCell(new jxl.write.Label(1, 15, "VENTAS AVV"));// 1,15
						Sheet.addCell(new jxl.write.Label(23, 2, "Presento"));// 1,15
						Sheet.addCell(new jxl.write.Label(24, 2, "Aprob�"));// 1,15
						Sheet.addCell(new jxl.write.Label(25, 2, "Reprob�"));// 1,15
						Sheet.addCell(new jxl.write.Label(26, 2, "Aprob�"));// 1,15
						Sheet.addCell(new jxl.write.Label(27, 2, "Reprob�"));// 1,15

						// ---------------------------------------------ACC-------------------------------------
						// ---------------------------------------------ACC-------------------------------------
						// ---------------------------------------------ACC-------------------------------------
						// ---------------------------------------------ACC-------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='1'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_PRES = rs.getInt(1);
								recibe = Integer.toString(ACC_PRES);
							} else {
								ACC_PRES = 0;
								recibe = Integer.toString(ACC_PRES);
							}
							Sheet.addCell(new jxl.write.Label(2, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_PRES y pregunta 1" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='2'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_PRES_2 = rs.getInt(1);
								recibe = Integer.toString(ACC_PRES_2);

							} else {
								ACC_PRES_2 = 0;
								recibe = Integer.toString(ACC_PRES_2);
							}
							Sheet.addCell(new jxl.write.Label(5, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_PRES y pregunta 2" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='3'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_PRES_3 = rs.getInt(1);
								recibe = Integer.toString(ACC_PRES_3);
							} else {
								ACC_PRES_3 = 0;
								recibe = Integer.toString(ACC_PRES_3);
							}
							Sheet.addCell(new jxl.write.Label(8, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_PRES y pregunta 3" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='4'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_PRES_4 = rs.getInt(1);
								recibe = Integer.toString(ACC_PRES_4);

							} else {
								ACC_PRES_4 = 0;
								recibe = Integer.toString(ACC_PRES_4);
							}
							Sheet.addCell(new jxl.write.Label(11, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_PRES y pregunta 4" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='5'";
						//

						try {

							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_PRES_5 = rs.getInt(1);
								recibe = Integer.toString(ACC_PRES_5);

							} else {
								ACC_PRES_5 = 0;
								recibe = Integer.toString(ACC_PRES_5);
							}
							Sheet.addCell(new jxl.write.Label(14, 3, recibe));

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_PRES y pregunta 5" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='6'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_PRES_6 = rs.getInt(1);
								recibe = Integer.toString(ACC_PRES_6);

							} else {
								ACC_PRES_6 = 0;
								recibe = Integer.toString(ACC_PRES_6);
							}
							Sheet.addCell(new jxl.write.Label(17, 3, recibe));

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_PRES y pregunta 6" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='7'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_PRES_7 = rs.getInt(1);
								recibe = Integer.toString(ACC_PRES_7);

							} else {
								ACC_PRES_7 = 0;
								recibe = Integer.toString(ACC_PRES_7);
							}
							Sheet.addCell(new jxl.write.Label(20, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_PRES y pregunta 7" + ex);
						}
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='1' && Evaluacion='Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_OK = rs.getInt(1);
								recibe = Integer.toString(ACC_OK);
							} else {
								ACC_OK = 0;
								recibe = Integer.toString(ACC_OK);
							}
							Sheet.addCell(new jxl.write.Label(3, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='2' && Evaluacion='Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_OK2 = rs.getInt(1);
								recibe = Integer.toString(ACC_OK2);
							} else {
								ACC_OK2 = 0;
								recibe = Integer.toString(ACC_OK2);
							}
							Sheet.addCell(new jxl.write.Label(6, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK2 " + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='3' && Evaluacion='Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_OK3 = rs.getInt(1);
								recibe = Integer.toString(ACC_OK3);
							} else {
								ACC_OK3 = 0;
								recibe = Integer.toString(ACC_OK3);
							}
							Sheet.addCell(new jxl.write.Label(9, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK3" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='4' && Evaluacion='Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_OK4 = rs.getInt(1);
								recibe = Integer.toString(ACC_OK4);
							} else {
								ACC_OK4 = 0;
								recibe = Integer.toString(ACC_OK4);
							}
							Sheet.addCell(new jxl.write.Label(12, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK4" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='5' && Evaluacion='Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_OK5 = rs.getInt(1);
								recibe = Integer.toString(ACC_OK5);
							} else {
								ACC_OK5 = 0;
								recibe = Integer.toString(ACC_OK5);
							}
							Sheet.addCell(new jxl.write.Label(15, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK5" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='6' && Evaluacion='Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_OK6 = rs.getInt(1);
								recibe = Integer.toString(ACC_OK6);
							} else {
								ACC_OK6 = 0;
								recibe = Integer.toString(ACC_OK6);
							}
							Sheet.addCell(new jxl.write.Label(18, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK6" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='7' && Evaluacion='Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_OK7 = rs.getInt(1);
								recibe = Integer.toString(ACC_OK7);
							} else {
								ACC_OK7 = 0;
								recibe = Integer.toString(ACC_OK7);
							}
							Sheet.addCell(new jxl.write.Label(21, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK7" + ex);
						}

						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------
						// /-------------------------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='1' && Evaluacion='No Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_KO = rs.getInt(1);
								recibe = Integer.toString(ACC_KO);

							} else {
								ACC_KO = 0;
								recibe = Integer.toString(ACC_KO);
							}
							Sheet.addCell(new jxl.write.Label(4, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_KO" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='2' && Evaluacion='No Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_KO2 = rs.getInt(1);
								recibe = Integer.toString(ACC_KO2);

							} else {
								ACC_KO2 = 0;
								recibe = Integer.toString(ACC_KO2);
							}
							Sheet.addCell(new jxl.write.Label(7, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_KO2" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='3' && Evaluacion='No Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_KO3 = rs.getInt(1);
								recibe = Integer.toString(ACC_KO3);

							} else {
								ACC_KO3 = 0;
								recibe = Integer.toString(ACC_KO3);
							}
							Sheet.addCell(new jxl.write.Label(10, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_KO3" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='4' && Evaluacion='No Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_KO4 = rs.getInt(1);
								recibe = Integer.toString(ACC_KO4);

							} else {
								ACC_KO4 = 0;
								recibe = Integer.toString(ACC_KO4);
							}
							Sheet.addCell(new jxl.write.Label(13, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_KO4" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='5' && Evaluacion='No Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_KO5 = rs.getInt(1);
								recibe = Integer.toString(ACC_KO5);

							} else {
								ACC_KO5 = 0;
								recibe = Integer.toString(ACC_KO5);
							}
							Sheet.addCell(new jxl.write.Label(16, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_KO5" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='6' && Evaluacion='No Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_KO6 = rs.getInt(1);
								recibe = Integer.toString(ACC_KO6);

							} else {
								ACC_KO6 = 0;
								recibe = Integer.toString(ACC_KO6);
							}
							Sheet.addCell(new jxl.write.Label(19, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_KO6" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='7' && Evaluacion='No Aprobado'";
						//

						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ACC_KO7 = rs.getInt(1);
								recibe = Integer.toString(ACC_KO7);

							} else {
								ACC_KO7 = 0;
								recibe = Integer.toString(ACC_KO7);
							}
							Sheet.addCell(new jxl.write.Label(22, 3, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_KO7" + ex);
						}
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------

						sum = ACC_PRES + ACC_PRES_2 + ACC_PRES_3 + ACC_PRES_4
								+ ACC_PRES_5 + ACC_PRES_6 + ACC_PRES_7;

						// JOptionPane.showMessageDialog(null, "sum     "+sum);
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 3, recibe_sum));
						sum_2 = ACC_OK + ACC_OK2 + ACC_OK3 + ACC_OK4 + ACC_OK5
								+ ACC_OK6 + ACC_OK7;

						// JOptionPane.showMessageDialog(null,
						// "sum_2    "+sum_2);
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 3, recibe_sum_2));
						sum_3 = ACC_KO + ACC_KO2 + ACC_KO3 + ACC_KO4 + ACC_KO5
								+ ACC_KO6 + ACC_KO7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 3, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						String recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 3,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						String recibe_porcentaje_no_aprobado = String
								.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 3,
								recibe_porcentaje_no_aprobado + "%"));

						total[21] = sum;
						total[22] = sum_2;
						total[23] = sum_3;

						// -------------------------------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------------------------------
						// ----------------------------------------------------------------------RETENCION--------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='8'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI = rs.getInt(1);
								recibe = Integer.toString(RETENCI);
							} else {
								RETENCI = 0;
								recibe = Integer.toString(RETENCI);
							}
							Sheet.addCell(new jxl.write.Label(2, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCION y pregunta 8" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='9'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_2 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_2);
							} else {
								RETENCI_2 = 0;
								recibe = Integer.toString(RETENCI);
							}
							Sheet.addCell(new jxl.write.Label(5, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCION_2 y pregunta 9" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='10'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_3 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_3);
							} else {
								RETENCI_3 = 0;
								recibe = Integer.toString(RETENCI_3);
							}
							Sheet.addCell(new jxl.write.Label(8, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCION_3 y pregunta 10" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='11'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_4 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_4);
							} else {
								RETENCI_4 = 0;
								recibe = Integer.toString(RETENCI_4);
							}
							Sheet.addCell(new jxl.write.Label(11, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCION_4 y pregunta 11" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='12'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_5 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_5);
							} else {
								RETENCI_5 = 0;
								recibe = Integer.toString(RETENCI_5);
							}
							Sheet.addCell(new jxl.write.Label(14, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCION y pregunta 12" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='13'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_6 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_6);
							} else {
								RETENCI_6 = 0;
								recibe = Integer.toString(RETENCI_6);
							}
							Sheet.addCell(new jxl.write.Label(17, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCION y pregunta 13" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='14'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_7 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_7);
							} else {
								RETENCI_7 = 0;
								recibe = Integer.toString(RETENCI_7);
							}
							Sheet.addCell(new jxl.write.Label(20, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCION y pregunta 14" + ex);
						}

						// -----------------------------------------------------------------------
						// -----------------------------------------------------------------------
						// -----------------------------------------------------------------------
						// -----------------------------------------------------------------------
						// -----------------------------------------------------------------------
						// -----------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='8' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_OK = rs.getInt(1);
								recibe = Integer.toString(RETENCI_OK);
							} else {
								RETENCI_OK = 0;
								recibe = Integer.toString(RETENCI_OK);
							}
							Sheet.addCell(new jxl.write.Label(3, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCI_OK y pregunta 8" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='9' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_OK_2 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_OK_2);
							} else {
								RETENCI_OK_2 = 0;
								recibe = Integer.toString(RETENCI_OK_2);
							}
							Sheet.addCell(new jxl.write.Label(6, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCI_OK_2 y pregunta 8" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='10' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_OK_3 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_OK_3);
							} else {
								RETENCI_OK_3 = 0;
								recibe = Integer.toString(RETENCI_OK_3);
							}
							Sheet.addCell(new jxl.write.Label(9, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_OK_3 y pregunta 10"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='11' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_OK_4 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_OK_4);
							} else {
								RETENCI_OK_4 = 0;
								recibe = Integer.toString(RETENCI_OK_4);
							}
							Sheet.addCell(new jxl.write.Label(12, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_OK_4 y pregunta 11"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='12' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_OK_5 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_OK_5);
							} else {
								RETENCI_OK_5 = 0;
								recibe = Integer.toString(RETENCI_OK_5);
							}
							Sheet.addCell(new jxl.write.Label(15, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_OK_5 y pregunta 12"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='13' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_OK_6 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_OK_6);
							} else {
								RETENCI_OK_6 = 0;
								recibe = Integer.toString(RETENCI_OK_6);
							}
							Sheet.addCell(new jxl.write.Label(18, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_OK_6 y pregunta 13"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='14' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_OK_7 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_OK_7);
							} else {
								RETENCI_OK_7 = 0;
								recibe = Integer.toString(RETENCI_OK_7);
							}
							Sheet.addCell(new jxl.write.Label(21, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_OK_7 y pregunta 14"
													+ ex);
						}

						// /----------------------------------------------------------------------------------------------
						// /----------------------------------------------------------------------------------------------
						// /----------------------------------------------------------------------------------------------
						// /----------------------------------------------------------------------------------------------
						// /----------------------------------------------------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='8' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_KO = rs.getInt(1);
								recibe = Integer.toString(RETENCI_KO);

							} else {
								RETENCI_KO = 0;
								recibe = Integer.toString(RETENCI_KO);
							}
							Sheet.addCell(new jxl.write.Label(4, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCI_KO y pregunta 8" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='9' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_KO_2 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_KO_2);

							} else {
								RETENCI_KO_2 = 0;
								recibe = Integer.toString(RETENCI_KO_2);
							}
							Sheet.addCell(new jxl.write.Label(7, 4, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en RETENCI_KO_2 y pregunta 9" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='10' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_KO_3 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_KO_3);

							} else {
								RETENCI_KO_3 = 0;
								recibe = Integer.toString(RETENCI_KO_3);
							}
							Sheet.addCell(new jxl.write.Label(10, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_KO_3 y pregunta 10"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='11' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_KO_4 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_KO_4);

							} else {
								RETENCI_KO_4 = 0;
								recibe = Integer.toString(RETENCI_KO_4);
							}
							Sheet.addCell(new jxl.write.Label(13, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_KO_4 y pregunta 11"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='12' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_KO_5 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_KO_5);

							} else {
								RETENCI_KO_5 = 0;
								recibe = Integer.toString(RETENCI_KO_5);
							}
							Sheet.addCell(new jxl.write.Label(16, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_KO_5 y pregunta 12"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='13' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_KO_6 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_KO_6);

							} else {
								RETENCI_KO_6 = 0;
								recibe = Integer.toString(RETENCI_KO_6);
							}
							Sheet.addCell(new jxl.write.Label(19, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_KO_6 y pregunta 13"
													+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Retenci�n' && Id_pregunta='14' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								RETENCI_KO_7 = rs.getInt(1);
								recibe = Integer.toString(RETENCI_KO_7);

							} else {
								RETENCI_KO_7 = 0;
								recibe = Integer.toString(RETENCI_KO_7);
							}
							Sheet.addCell(new jxl.write.Label(22, 4, recibe));
						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(null,
											"error: en RETENCI_KO_7 y pregunta 14"
													+ ex);
						}
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------
						// -------------------------------------------------------------------------

						sum = RETENCI + RETENCI_2 + RETENCI_3 + RETENCI_4
								+ RETENCI_5 + RETENCI_6 + RETENCI_7;
						// JOptionPane.showMessageDialog(null, "sum     "+sum);
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 4, recibe_sum));
						sum_2 = RETENCI_OK + RETENCI_OK_2 + RETENCI_OK_3
								+ RETENCI_OK_4 + RETENCI_OK_5 + RETENCI_OK_6
								+ RETENCI_OK_7;
						// JOptionPane.showMessageDialog(null,
						// "sum_2    "+sum_2);
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 4, recibe_sum_2));
						sum_3 = RETENCI_KO + RETENCI_KO_2 + RETENCI_KO_3
								+ RETENCI_KO_4 + RETENCI_KO_5 + RETENCI_KO_6
								+ RETENCI_KO_7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 4, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 4,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 4,
								recibe_porcentaje_no_aprobado + "%"));

						total[24] = sum;
						total[25] = sum_2;
						total[26] = sum_3;

						// -------------------------------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------Reclamaciones-----------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='15'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_press = rs.getInt(1);
								recibe = Integer.toString(recla_press);
							} else {
								recla_press = 0;
								recibe = Integer.toString(recla_press);
							}
							Sheet.addCell(new jxl.write.Label(2, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Reclamaciones y pregunta 15"
											+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='16'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_press2 = rs.getInt(1);
								recibe = Integer.toString(recla_press2);
							} else {
								recla_press2 = 0;
								recibe = Integer.toString(recla_press2);
							}
							Sheet.addCell(new jxl.write.Label(5, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Reclamaciones y pregunta 16"
											+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='17'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_press3 = rs.getInt(1);
								recibe = Integer.toString(recla_press3);
							} else {
								recla_press3 = 0;
								recibe = Integer.toString(recla_press3);
							}
							Sheet.addCell(new jxl.write.Label(8, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Reclamaciones y pregunta 17"
											+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='18'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_press4 = rs.getInt(1);
								recibe = Integer.toString(recla_press4);
							} else {
								recla_press4 = 0;
								recibe = Integer.toString(recla_press4);
							}
							Sheet.addCell(new jxl.write.Label(11, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Reclamaciones y pregunta 18"
											+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='19'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_press5 = rs.getInt(1);
								recibe = Integer.toString(recla_press5);
							} else {
								recla_press5 = 0;
								recibe = Integer.toString(recla_press5);
							}
							Sheet.addCell(new jxl.write.Label(14, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Reclamaciones y pregunta 19"
											+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='20'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_press6 = rs.getInt(1);
								recibe = Integer.toString(recla_press6);
							} else {
								recla_press6 = 0;
								recibe = Integer.toString(recla_press6);
							}
							Sheet.addCell(new jxl.write.Label(17, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Reclamaciones y pregunta 20"
											+ ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='21'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_press7 = rs.getInt(1);
								recibe = Integer.toString(recla_press7);
							} else {
								recla_press7 = 0;
								recibe = Integer.toString(recla_press7);
							}
							Sheet.addCell(new jxl.write.Label(20, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Reclamaciones y pregunta 21"
											+ ex);
						}

						// ----------------------------------------------------------------------------------------------
						// ----------------------------------------------------------------------------------------------
						// ----------------------------------------------------------------------------------------------
						// ----------------------------------------------------------------------------------------------
						// ----------------------------------------------------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='15' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ok = rs.getInt(1);
								recibe = Integer.toString(recla_ok);
							} else {
								recla_ok = 0;
								recibe = Integer.toString(recla_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en reclaok y pregunta 15" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='16' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ok2 = rs.getInt(1);
								recibe = Integer.toString(recla_ok2);
							} else {
								recla_ok2 = 0;
								recibe = Integer.toString(recla_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en reclaok2 y pregunta 16" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='17' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ok3 = rs.getInt(1);
								recibe = Integer.toString(recla_ok3);
							} else {
								recla_ok3 = 0;
								recibe = Integer.toString(recla_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en reclaok3 y pregunta 17" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='18' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ok4 = rs.getInt(1);
								recibe = Integer.toString(recla_ok4);
							} else {
								recla_ok4 = 0;
								recibe = Integer.toString(recla_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en reclaok4 y pregunta 18" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='19' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ok5 = rs.getInt(1);
								recibe = Integer.toString(recla_ok5);
							} else {
								recla_ok5 = 0;
								recibe = Integer.toString(recla_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en reclaok5 y pregunta 19" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='20' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ok6 = rs.getInt(1);
								recibe = Integer.toString(recla_ok6);
							} else {
								recla_ok6 = 0;
								recibe = Integer.toString(recla_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en reclaok6 y pregunta 20" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='21' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ok7 = rs.getInt(1);
								recibe = Integer.toString(recla_ok7);
							} else {
								recla_ok7 = 0;
								recibe = Integer.toString(recla_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en reclaok7 y pregunta 21" + ex);
						}

						// ---------------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='15' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ko = rs.getInt(1);
								recibe = Integer.toString(recla_ko);

							} else {
								recla_ko = 0;
								recibe = Integer.toString(recla_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en recla_ko y pregunta 15" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='16' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ko2 = rs.getInt(1);
								recibe = Integer.toString(recla_ko2);

							} else {
								recla_ko2 = 0;
								recibe = Integer.toString(recla_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en recla_ko2 y pregunta 16" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='17' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ko3 = rs.getInt(1);
								recibe = Integer.toString(recla_ko3);

							} else {
								recla_ko3 = 0;
								recibe = Integer.toString(recla_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en recla_ko3 y pregunta 17" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='18' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ko4 = rs.getInt(1);
								recibe = Integer.toString(recla_ko4);

							} else {
								recla_ko4 = 0;
								recibe = Integer.toString(recla_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en recla_ko4 y pregunta 18" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='19' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ko5 = rs.getInt(1);
								recibe = Integer.toString(recla_ko5);

							} else {
								recla_ko5 = 0;
								recibe = Integer.toString(recla_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en recla_ko5 y pregunta 19" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='20' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ko6 = rs.getInt(1);
								recibe = Integer.toString(recla_ko6);

							} else {
								recla_ko6 = 0;
								recibe = Integer.toString(recla_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en recla_ko6 y pregunta 20" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Reclamaciones' && Id_pregunta='21' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								recla_ko7 = rs.getInt(1);
								recibe = Integer.toString(recla_ko7);

							} else {
								recla_ko7 = 0;
								recibe = Integer.toString(recla_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 5, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en recla_ko7 y pregunta 21" + ex);
						}
						// ----------------------------------------------------------------
						// ----------------------------------------------------------------
						// ----------------------------------------------------------------
						// ----------------------------------------------------------------
						// ----------------------------------------------------------------

						sum = recla_press + recla_press2 + recla_press3
								+ recla_press4 + recla_press5 + recla_press6
								+ recla_press7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 5, recibe_sum));
						sum_2 = recla_ok + recla_ok2 + recla_ok3 + recla_ok4
								+ recla_ok5 + recla_ok6 + recla_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 5, recibe_sum_2));
						sum_3 = recla_ko + recla_ko2 + recla_ko3 + recla_ko4
								+ recla_ko5 + recla_ko6 + recla_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 5, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 5,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 5,
								recibe_porcentaje_no_aprobado + "%"));
						total[27] = sum;
						total[28] = sum_2;
						total[29] = sum_3;

						// ---------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------
						// ---------------------------------------CO
						// ATC-------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='22'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC = rs.getInt(1);
								recibe = Integer.toString(ATC);
							} else {
								ATC = 0;
								recibe = Integer.toString(ATC);
							}
							Sheet.addCell(new jxl.write.Label(2, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC Y PREGUNTA 22" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='23'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC2 = rs.getInt(1);
								recibe = Integer.toString(ATC2);
							} else {
								ATC2 = 0;
								recibe = Integer.toString(ATC2);
							}
							Sheet.addCell(new jxl.write.Label(5, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO ATC y pregunta 23" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='24'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC3 = rs.getInt(1);
								recibe = Integer.toString(ATC3);
							} else {
								ATC3 = 0;
								recibe = Integer.toString(ATC3);
							}
							Sheet.addCell(new jxl.write.Label(8, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC y pregunta 24" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='25'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC4 = rs.getInt(1);
								recibe = Integer.toString(ATC4);
							} else {
								ATC4 = 0;
								recibe = Integer.toString(ATC4);
							}
							Sheet.addCell(new jxl.write.Label(11, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC y pregunta 25" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='26'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC5 = rs.getInt(1);
								recibe = Integer.toString(ATC5);
							} else {
								ATC5 = 0;
								recibe = Integer.toString(ATC5);
							}
							Sheet.addCell(new jxl.write.Label(14, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC y pregunta 26" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='27'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC6 = rs.getInt(1);
								recibe = Integer.toString(ATC6);
							} else {
								ATC6 = 0;
								recibe = Integer.toString(ATC6);
							}
							Sheet.addCell(new jxl.write.Label(17, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC y pregunta 27" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='28'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC7 = rs.getInt(1);
								recibe = Integer.toString(ATC7);
							} else {
								ATC7 = 0;
								recibe = Integer.toString(ATC7);
							}
							Sheet.addCell(new jxl.write.Label(20, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC y pregunta 28" + ex);
						}

						// ---------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='22' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_OK = rs.getInt(1);
								recibe = Integer.toString(ATC_OK);
							} else {
								ATC_OK = 0;
								recibe = Integer.toString(ATC_OK);
							}
							Sheet.addCell(new jxl.write.Label(3, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ACC_OK y pregunta 22" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='23' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_OK2 = rs.getInt(1);
								recibe = Integer.toString(ATC_OK2);
							} else {
								ATC_OK2 = 0;
								recibe = Integer.toString(ATC_OK2);
							}
							Sheet.addCell(new jxl.write.Label(6, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_OK2 y pregunta 23" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='24' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_OK3 = rs.getInt(1);
								recibe = Integer.toString(ATC_OK3);
							} else {
								ATC_OK3 = 0;
								recibe = Integer.toString(ATC_OK3);
							}
							Sheet.addCell(new jxl.write.Label(9, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_OK3 y pregunta 24" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='25' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_OK4 = rs.getInt(1);
								recibe = Integer.toString(ATC_OK4);
							} else {
								ATC_OK4 = 0;
								recibe = Integer.toString(ATC_OK4);
							}
							Sheet.addCell(new jxl.write.Label(12, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_OK4 y pregunta 25" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ACC' && Id_pregunta='26' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_OK5 = rs.getInt(1);
								recibe = Integer.toString(ATC_OK5);
							} else {
								ATC_OK5 = 0;
								recibe = Integer.toString(ATC_OK5);
							}
							Sheet.addCell(new jxl.write.Label(15, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_OK5 y pregunta 26" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='27' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_OK6 = rs.getInt(1);
								recibe = Integer.toString(ATC_OK6);
							} else {
								ATC_OK6 = 0;
								recibe = Integer.toString(ATC_OK6);
							}
							Sheet.addCell(new jxl.write.Label(18, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_OK6 y pregunta 27" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='28' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_OK7 = rs.getInt(1);
								recibe = Integer.toString(ATC_OK7);
							} else {
								ATC_OK7 = 0;
								recibe = Integer.toString(ATC_OK7);
							}
							Sheet.addCell(new jxl.write.Label(21, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_OK7 y pregunta 28" + ex);
						}

						// -------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='22' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_KO = rs.getInt(1);
								recibe = Integer.toString(ATC_KO);

							} else {
								ATC_KO = 0;
								recibe = Integer.toString(ATC_KO);
							}
							Sheet.addCell(new jxl.write.Label(4, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_KO y pregunta 22" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='23' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_KO2 = rs.getInt(1);
								recibe = Integer.toString(ATC_KO2);

							} else {
								ATC_KO2 = 0;
								recibe = Integer.toString(ATC_KO2);
							}
							Sheet.addCell(new jxl.write.Label(7, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_KO2 y pregunta 23" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='24' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_KO3 = rs.getInt(1);
								recibe = Integer.toString(ATC_KO3);

							} else {
								ATC_KO3 = 0;
								recibe = Integer.toString(ATC_KO3);
							}
							Sheet.addCell(new jxl.write.Label(10, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_KO3 y pregunta 24" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='25' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_KO4 = rs.getInt(1);
								recibe = Integer.toString(ATC_KO4);

							} else {
								ATC_KO4 = 0;
								recibe = Integer.toString(ATC_KO4);
							}
							Sheet.addCell(new jxl.write.Label(13, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_KO4 y pregunta 25" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='26' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_KO5 = rs.getInt(1);
								recibe = Integer.toString(ATC_KO5);

							} else {
								ATC_KO5 = 0;
								recibe = Integer.toString(ATC_KO5);
							}
							Sheet.addCell(new jxl.write.Label(16, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_KO5 y pregunta 26" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='27' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_KO6 = rs.getInt(1);
								recibe = Integer.toString(ATC_KO6);

							} else {
								ATC_KO6 = 0;
								recibe = Integer.toString(ATC_KO6);
							}
							Sheet.addCell(new jxl.write.Label(19, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_KO6 y pregunta 27" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO ATC' && Id_pregunta='28' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ATC_KO7 = rs.getInt(1);
								recibe = Integer.toString(ATC_KO7);

							} else {
								ATC_KO7 = 0;
								recibe = Integer.toString(ATC_KO7);
							}
							Sheet.addCell(new jxl.write.Label(22, 6, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ATC_KO7 y pregunta 28" + ex);
						}
						// ------------------------------------------------------------------------------------------
						// ------------------------------------------------------------------------------------------
						// ------------------------------------------------------------------------------------------
						// ------------------------------------------------------------------------------------------
						// ------------------------------------------------------------------------------------------
						sum = ATC + ATC2 + ATC3 + ATC4 + ATC5 + ATC6 + ATC7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 6, recibe_sum));
						sum_2 = ATC_OK + ATC_OK2 + ATC_OK3 + ATC_OK4 + ATC_OK5
								+ ATC_OK6 + ATC_OK7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 6, recibe_sum_2));
						sum_3 = ATC_KO + ATC_KO2 + ATC_KO3 + ATC_KO4 + ATC_KO5
								+ ATC_KO6 + ATC_KO7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 6, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 6,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 6,
								recibe_porcentaje_no_aprobado + "%"));

						total[30] = sum;
						total[31] = sum_2;
						total[32] = sum_3;

						// -------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------------
						// ----------------------------------------------VENTAS---VENTAS--------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='29'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven = rs.getInt(1);
								recibe = Integer.toString(ven);
							} else {
								ven = 0;
								recibe = Integer.toString(ven);
							}
							Sheet.addCell(new jxl.write.Label(2, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Ventas Y PREGUNTA 29" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='30'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven2 = rs.getInt(1);
								recibe = Integer.toString(ven2);
							} else {
								ven2 = 0;
								recibe = Integer.toString(ven2);
							}
							Sheet.addCell(new jxl.write.Label(5, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO Ventas y pregunta 31" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='31'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven3 = rs.getInt(1);
								recibe = Integer.toString(ven3);
							} else {
								ven3 = 0;
								recibe = Integer.toString(ven3);
							}
							Sheet.addCell(new jxl.write.Label(8, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Ventas y pregunta 31" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='32'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven4 = rs.getInt(1);
								recibe = Integer.toString(ven4);
							} else {
								ven4 = 0;
								recibe = Integer.toString(ven4);
							}
							Sheet.addCell(new jxl.write.Label(11, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Ventas y pregunta 32" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='33'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven5 = rs.getInt(1);
								recibe = Integer.toString(ven5);
							} else {
								ven5 = 0;
								recibe = Integer.toString(ven5);
							}
							Sheet.addCell(new jxl.write.Label(14, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Ventas y pregunta 33" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='34'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven6 = rs.getInt(1);
								recibe = Integer.toString(ven6);
							} else {
								ven6 = 0;
								recibe = Integer.toString(ven6);
							}
							Sheet.addCell(new jxl.write.Label(17, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Ventas y pregunta 34" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='35'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven7 = rs.getInt(1);
								recibe = Integer.toString(ven7);
							} else {
								ven7 = 0;
								recibe = Integer.toString(ven7);
							}
							Sheet.addCell(new jxl.write.Label(20, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en Ventas y pregunta 35" + ex);
						}

						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='29' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ok = rs.getInt(1);
								recibe = Integer.toString(ven_ok);
							} else {
								ven_ok = 0;
								recibe = Integer.toString(ven_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ok y pregunta 29" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='30' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ok2 = rs.getInt(1);
								recibe = Integer.toString(ven_ok2);
							} else {
								ven_ok2 = 0;
								recibe = Integer.toString(ven_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ok2 y pregunta 30" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='31' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ok3 = rs.getInt(1);
								recibe = Integer.toString(ven_ok3);
							} else {
								ven_ok3 = 0;
								recibe = Integer.toString(ven_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ok3 y pregunta 31" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='32' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ok4 = rs.getInt(1);
								recibe = Integer.toString(ven_ok4);
							} else {
								ven_ok4 = 0;
								recibe = Integer.toString(ven_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ok4 y pregunta 32" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='33' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ok5 = rs.getInt(1);
								recibe = Integer.toString(ven_ok5);
							} else {
								ven_ok5 = 0;
								recibe = Integer.toString(ven_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ok5 y pregunta 33" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='34' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ok6 = rs.getInt(1);
								recibe = Integer.toString(ven_ok6);
							} else {
								ven_ok6 = 0;
								recibe = Integer.toString(ven_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ok6 y pregunta 34" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='35' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ok7 = rs.getInt(1);
								recibe = Integer.toString(ven_ok7);
							} else {
								ven_ok7 = 0;
								recibe = Integer.toString(ven_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ok7 y pregunta 35" + ex);
						}

						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='29' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ko = rs.getInt(1);
								recibe = Integer.toString(ven_ko);

							} else {
								ven_ko = 0;
								recibe = Integer.toString(ven_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ko y pregunta 29" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='30' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ko2 = rs.getInt(1);
								recibe = Integer.toString(ven_ko2);

							} else {
								ven_ko2 = 0;
								recibe = Integer.toString(ven_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ko2 y pregunta 30" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='31' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ko3 = rs.getInt(1);
								recibe = Integer.toString(ven_ko3);

							} else {
								ven_ko3 = 0;
								recibe = Integer.toString(ven_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ko3 y pregunta 32" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='32' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ko4 = rs.getInt(1);
								recibe = Integer.toString(ven_ko4);

							} else {
								ven_ko4 = 0;
								recibe = Integer.toString(ven_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ko4 y pregunta 32" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='33' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ko5 = rs.getInt(1);
								recibe = Integer.toString(ven_ko5);

							} else {
								ven_ko5 = 0;
								recibe = Integer.toString(ven_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ko5 y pregunta 33" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='34' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ko6 = rs.getInt(1);
								recibe = Integer.toString(ven_ko6);

							} else {
								ven_ko6 = 0;
								recibe = Integer.toString(ven_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ko6 y pregunta 34" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas' && Id_pregunta='35' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ven_ko7 = rs.getInt(1);
								recibe = Integer.toString(ven_ko7);

							} else {
								ven_ko7 = 0;
								recibe = Integer.toString(ven_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 7, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en ven_ko7 y pregunta 35" + ex);
						}
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						sum = ven + ven2 + ven3 + ven4 + ven5 + ven6 + ven7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 7, recibe_sum));
						sum_2 = ven_ok + ven_ok2 + ven_ok3 + ven_ok4 + ven_ok5
								+ ven_ok6 + ven_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 7, recibe_sum_2));
						sum_3 = ven_ko + ven_ko2 + ven_ko3 + ven_ko4 + ven_ko5
								+ ven_ko6 + ven_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 7, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 7,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 7,
								recibe_porcentaje_no_aprobado + "%"));

						total[33] = sum;
						total[34] = sum_2;
						total[35] = sum_3;

						// --------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------
						// -------------------------------------------Provision--------------------------------------
						// --------------------------------------------Provision--------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='36'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi = rs.getInt(1);
								recibe = Integer.toString(provi);
							} else {
								provi = 0;
								recibe = Integer.toString(provi);
							}
							Sheet.addCell(new jxl.write.Label(2, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi Y PREGUNTA 36" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='37'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi2 = rs.getInt(1);
								recibe = Integer.toString(provi2);
							} else {
								provi2 = 0;
								recibe = Integer.toString(provi2);
							}
							Sheet.addCell(new jxl.write.Label(5, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO provi y pregunta 37" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='38'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi3 = rs.getInt(1);
								recibe = Integer.toString(provi3);
							} else {
								provi3 = 0;
								recibe = Integer.toString(provi3);
							}
							Sheet.addCell(new jxl.write.Label(8, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi y pregunta 38" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='39'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi4 = rs.getInt(1);
								recibe = Integer.toString(provi4);
							} else {
								provi4 = 0;
								recibe = Integer.toString(provi4);
							}
							Sheet.addCell(new jxl.write.Label(11, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi y pregunta 39" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='40'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi5 = rs.getInt(1);
								recibe = Integer.toString(provi5);
							} else {
								provi5 = 0;
								recibe = Integer.toString(provi5);
							}
							Sheet.addCell(new jxl.write.Label(14, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi y pregunta 40" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='41'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi6 = rs.getInt(1);
								recibe = Integer.toString(provi6);
							} else {
								provi6 = 0;
								recibe = Integer.toString(provi6);
							}
							Sheet.addCell(new jxl.write.Label(17, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi y pregunta 41" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='42'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi7 = rs.getInt(1);
								recibe = Integer.toString(provi7);
							} else {
								provi7 = 0;
								recibe = Integer.toString(provi7);
							}
							Sheet.addCell(new jxl.write.Label(20, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi y pregunta 42" + ex);
						}

						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='36' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ok = rs.getInt(1);
								recibe = Integer.toString(provi_ok);
							} else {
								provi_ok = 0;
								recibe = Integer.toString(provi_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ok y pregunta 36" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='37' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ok2 = rs.getInt(1);
								recibe = Integer.toString(provi_ok2);
							} else {
								provi_ok2 = 0;
								recibe = Integer.toString(provi_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ok2 y pregunta 37" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='38' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ok3 = rs.getInt(1);
								recibe = Integer.toString(provi_ok3);
							} else {
								provi_ok3 = 0;
								recibe = Integer.toString(provi_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ok3 y pregunta 38" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='39' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ok4 = rs.getInt(1);
								recibe = Integer.toString(provi_ok4);
							} else {
								provi_ok4 = 0;
								recibe = Integer.toString(provi_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ok4 y pregunta 39" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='40' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ok5 = rs.getInt(1);
								recibe = Integer.toString(provi_ok5);
							} else {
								provi_ok5 = 0;
								recibe = Integer.toString(provi_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ok5 y pregunta 40" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='41' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ok6 = rs.getInt(1);
								recibe = Integer.toString(provi_ok6);
							} else {
								provi_ok6 = 0;
								recibe = Integer.toString(provi_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ok6 y pregunta 41" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='42' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ok7 = rs.getInt(1);
								recibe = Integer.toString(provi_ok7);
							} else {
								provi_ok7 = 0;
								recibe = Integer.toString(provi_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ok7 y pregunta 42" + ex);
						}

						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='36' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ko = rs.getInt(1);
								recibe = Integer.toString(provi_ko);

							} else {
								provi_ko = 0;
								recibe = Integer.toString(provi_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ko y pregunta 36" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='37' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ko2 = rs.getInt(1);
								recibe = Integer.toString(provi_ko2);

							} else {
								provi_ko2 = 0;
								recibe = Integer.toString(provi_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ko2 y pregunta 37" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='38' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ko3 = rs.getInt(1);
								recibe = Integer.toString(provi_ko3);

							} else {
								provi_ko3 = 0;
								recibe = Integer.toString(provi_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ko3 y pregunta 38" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='39' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ko4 = rs.getInt(1);
								recibe = Integer.toString(provi_ko4);

							} else {
								provi_ko4 = 0;
								recibe = Integer.toString(provi_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ko4 y pregunta 39" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='40' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ko5 = rs.getInt(1);
								recibe = Integer.toString(provi_ko5);

							} else {
								provi_ko5 = 0;
								recibe = Integer.toString(provi_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ko5 y pregunta 40" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='41' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ko6 = rs.getInt(1);
								recibe = Integer.toString(provi_ko6);

							} else {
								provi_ko6 = 0;
								recibe = Integer.toString(provi_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ko6 y pregunta 41" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Provisi�n' && Id_pregunta='42' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								provi_ko7 = rs.getInt(1);
								recibe = Integer.toString(provi_ko7);

							} else {
								provi_ko7 = 0;
								recibe = Integer.toString(provi_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 8, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en provi_ko7 y pregunta 42" + ex);
						}
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sum = provi + provi2 + provi3 + provi4 + provi5
								+ provi6 + provi7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 8, recibe_sum));
						sum_2 = provi_ok + provi_ok2 + provi_ok3 + provi_ok4
								+ provi_ok5 + provi_ok6 + provi_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 8, recibe_sum_2));
						sum_3 = provi_ko + provi_ko2 + provi_ko3 + provi_ko4
								+ provi_ko5 + provi_ko6 + provi_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 8, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 8,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 8,
								recibe_porcentaje_no_aprobado + "%"));
						total[36] = sum;
						total[37] = sum_2;
						total[38] = sum_3;

						// --------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------
						// --------------------------------------------------------CO
						// SyC ADSL-------------------------------
						// --------------------------------------------------------CO
						// SyC ADSL-------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='43'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls = rs.getInt(1);
								recibe = Integer.toString(adls);
							} else {
								adls = 0;
								recibe = Integer.toString(adls);
							}
							Sheet.addCell(new jxl.write.Label(2, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls Y PREGUNTA 43" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='44'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls2 = rs.getInt(1);
								recibe = Integer.toString(adls2);
							} else {
								adls2 = 0;
								recibe = Integer.toString(adls2);
							}
							Sheet.addCell(new jxl.write.Label(5, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO adls y pregunta 44" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='45'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls3 = rs.getInt(1);
								recibe = Integer.toString(adls3);
							} else {
								adls3 = 0;
								recibe = Integer.toString(adls3);
							}
							Sheet.addCell(new jxl.write.Label(8, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls y pregunta 45" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='46'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls4 = rs.getInt(1);
								recibe = Integer.toString(adls4);
							} else {
								adls4 = 0;
								recibe = Integer.toString(adls4);
							}
							Sheet.addCell(new jxl.write.Label(11, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls y pregunta 46" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='47'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls5 = rs.getInt(1);
								recibe = Integer.toString(adls5);
							} else {
								adls5 = 0;
								recibe = Integer.toString(adls5);
							}
							Sheet.addCell(new jxl.write.Label(14, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls y pregunta 47" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='48'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls6 = rs.getInt(1);
								recibe = Integer.toString(adls6);
							} else {
								adls6 = 0;
								recibe = Integer.toString(adls6);
							}
							Sheet.addCell(new jxl.write.Label(17, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls y pregunta 48" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='49'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls7 = rs.getInt(1);
								recibe = Integer.toString(adls7);
							} else {
								adls7 = 0;
								recibe = Integer.toString(adls7);
							}
							Sheet.addCell(new jxl.write.Label(20, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls y pregunta 49" + ex);
						}

						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='43' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ok = rs.getInt(1);
								recibe = Integer.toString(adls_ok);
							} else {
								adls_ok = 0;
								recibe = Integer.toString(adls_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ok y pregunta 43" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='44' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ok2 = rs.getInt(1);
								recibe = Integer.toString(adls_ok2);
							} else {
								adls_ok2 = 0;
								recibe = Integer.toString(adls_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ok2 y pregunta 45" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='45' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ok3 = rs.getInt(1);
								recibe = Integer.toString(adls_ok3);
							} else {
								adls_ok3 = 0;
								recibe = Integer.toString(adls_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ok3 y pregunta 45" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='46' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ok4 = rs.getInt(1);
								recibe = Integer.toString(adls_ok4);
							} else {
								adls_ok4 = 0;
								recibe = Integer.toString(adls_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ok4 y pregunta 46" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='47' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ok5 = rs.getInt(1);
								recibe = Integer.toString(adls_ok5);
							} else {
								adls_ok5 = 0;
								recibe = Integer.toString(adls_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ok5 y pregunta 47" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='48' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ok6 = rs.getInt(1);
								recibe = Integer.toString(adls_ok6);
							} else {
								adls_ok6 = 0;
								recibe = Integer.toString(adls_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ok6 y pregunta 48" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='49' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ok7 = rs.getInt(1);
								recibe = Integer.toString(adls_ok7);
							} else {
								adls_ok7 = 0;
								recibe = Integer.toString(adls_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ok7 y pregunta 49" + ex);
						}

						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='43' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ko = rs.getInt(1);
								recibe = Integer.toString(adls_ko);

							} else {
								adls_ko = 0;
								recibe = Integer.toString(adls_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ko y pregunta 43" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='44' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ko2 = rs.getInt(1);
								recibe = Integer.toString(adls_ko2);

							} else {
								adls_ko2 = 0;
								recibe = Integer.toString(adls_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ko2 y pregunta 44" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='45' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ko3 = rs.getInt(1);
								recibe = Integer.toString(adls_ko3);

							} else {
								adls_ko3 = 0;
								recibe = Integer.toString(adls_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ko3 y pregunta 45" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='46' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ko4 = rs.getInt(1);
								recibe = Integer.toString(adls_ko4);

							} else {
								adls_ko4 = 0;
								recibe = Integer.toString(adls_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ko4 y pregunta 46" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='47' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ko5 = rs.getInt(1);
								recibe = Integer.toString(adls_ko5);

							} else {
								adls_ko5 = 0;
								recibe = Integer.toString(adls_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ko5 y pregunta 47" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='48' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ko6 = rs.getInt(1);
								recibe = Integer.toString(adls_ko6);

							} else {
								adls_ko6 = 0;
								recibe = Integer.toString(adls_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ko6 y pregunta 48" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC ADSL' && Id_pregunta='49' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								adls_ko7 = rs.getInt(1);
								recibe = Integer.toString(adls_ko7);

							} else {
								adls_ko7 = 0;
								recibe = Integer.toString(adls_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 9, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en adls_ko7 y pregunta 49" + ex);
						}

						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sum = adls + adls2 + adls3 + adls4 + adls5 + adls6
								+ adls7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 9, recibe_sum));
						sum_2 = adls_ok + adls_ok2 + adls_ok3 + adls_ok4
								+ adls_ok5 + adls_ok6 + adls_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 9, recibe_sum_2));
						sum_3 = adls_ko + adls_ko2 + adls_ko3 + adls_ko4
								+ adls_ko5 + adls_ko6 + adls_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 9, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 9,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 9,
								recibe_porcentaje_no_aprobado + "%"));
						total[39] = sum;
						total[40] = sum_2;
						total[41] = sum_3;

						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// --------------------------------------SyC
						// M�vil-----------------------------------------------
						// --------------------------------------SyC
						// M�vil-----------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='50'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv = rs.getInt(1);
								recibe = Integer.toString(omv);
							} else {
								omv = 0;
								recibe = Integer.toString(omv);
							}
							Sheet.addCell(new jxl.write.Label(2, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv Y PREGUNTA 50" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='51'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv2 = rs.getInt(1);
								recibe = Integer.toString(omv2);
							} else {
								omv2 = 0;
								recibe = Integer.toString(omv2);
							}
							Sheet.addCell(new jxl.write.Label(5, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO omv y pregunta 52" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='52'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv3 = rs.getInt(1);
								recibe = Integer.toString(omv3);
							} else {
								omv3 = 0;
								recibe = Integer.toString(omv3);
							}
							Sheet.addCell(new jxl.write.Label(8, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv y pregunta 52" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='53'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv4 = rs.getInt(1);
								recibe = Integer.toString(omv4);
							} else {
								omv4 = 0;
								recibe = Integer.toString(omv4);
							}
							Sheet.addCell(new jxl.write.Label(11, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv y pregunta 53" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='54'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv5 = rs.getInt(1);
								recibe = Integer.toString(omv5);
							} else {
								adls5 = 0;
								recibe = Integer.toString(adls5);
							}
							Sheet.addCell(new jxl.write.Label(14, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv y pregunta 54" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='55'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv6 = rs.getInt(1);
								recibe = Integer.toString(omv6);
							} else {
								omv6 = 0;
								recibe = Integer.toString(omv6);
							}
							Sheet.addCell(new jxl.write.Label(17, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv y pregunta 55" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='56'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv7 = rs.getInt(1);
								recibe = Integer.toString(omv7);
							} else {
								omv7 = 0;
								recibe = Integer.toString(omv7);
							}
							Sheet.addCell(new jxl.write.Label(20, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv y pregunta 56" + ex);
						}

						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='50' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ok = rs.getInt(1);
								recibe = Integer.toString(omv_ok);
							} else {
								omv_ok = 0;
								recibe = Integer.toString(omv_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ok y pregunta 50" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='51' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ok2 = rs.getInt(1);
								recibe = Integer.toString(omv_ok2);
							} else {
								omv_ok2 = 0;
								recibe = Integer.toString(omv_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ok2 y pregunta 51" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='52' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ok3 = rs.getInt(1);
								recibe = Integer.toString(omv_ok3);
							} else {
								omv_ok3 = 0;
								recibe = Integer.toString(omv_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ok3 y pregunta 52" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='53' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ok4 = rs.getInt(1);
								recibe = Integer.toString(omv_ok4);
							} else {
								omv_ok4 = 0;
								recibe = Integer.toString(omv_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ok4 y pregunta 53" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='54' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ok5 = rs.getInt(1);
								recibe = Integer.toString(omv_ok5);
							} else {
								omv_ok5 = 0;
								recibe = Integer.toString(omv_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ok5 y pregunta 54" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='55' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ok6 = rs.getInt(1);
								recibe = Integer.toString(omv_ok6);
							} else {
								omv_ok6 = 0;
								recibe = Integer.toString(omv_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ok6 y pregunta 55" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='56' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ok7 = rs.getInt(1);
								recibe = Integer.toString(omv_ok7);
							} else {
								omv_ok7 = 0;
								recibe = Integer.toString(omv_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ok7 y pregunta 56" + ex);
						}

						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='50' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ko = rs.getInt(1);
								recibe = Integer.toString(omv_ko);

							} else {
								omv_ko = 0;
								recibe = Integer.toString(omv_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ko y pregunta 50" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='51' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ko2 = rs.getInt(1);
								recibe = Integer.toString(omv_ko2);

							} else {
								omv_ko2 = 0;
								recibe = Integer.toString(omv_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ko2 y pregunta 51" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='52' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ko3 = rs.getInt(1);
								recibe = Integer.toString(omv_ko3);

							} else {
								omv_ko3 = 0;
								recibe = Integer.toString(omv_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ko3 y pregunta 52" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='53' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ko4 = rs.getInt(1);
								recibe = Integer.toString(omv_ko4);

							} else {
								omv_ko4 = 0;
								recibe = Integer.toString(omv_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ko4 y pregunta 53" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='54' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ko5 = rs.getInt(1);
								recibe = Integer.toString(omv_ko5);

							} else {
								omv_ko5 = 0;
								recibe = Integer.toString(omv_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ko5 y pregunta 54" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='55' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ko6 = rs.getInt(1);
								recibe = Integer.toString(omv_ko6);

							} else {
								omv_ko6 = 0;
								recibe = Integer.toString(omv_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ko6 y pregunta 55" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO SyC M�vil' && Id_pregunta='56' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								omv_ko7 = rs.getInt(1);
								recibe = Integer.toString(omv_ko7);

							} else {
								omv_ko7 = 0;
								recibe = Integer.toString(omv_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 10, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en omv_ko7 y pregunta 57" + ex);
						}
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sum = omv + omv2 + omv3 + omv4 + omv5 + omv6 + omv7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 10, recibe_sum));
						sum_2 = omv_ok + omv_ok2 + omv_ok3 + omv_ok4 + omv_ok5
								+ omv_ok6 + omv_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 10, recibe_sum_2));
						sum_3 = omv_ko + omv_ko2 + omv_ko3 + omv_ko4 + omv_ko5
								+ omv_ko6 + omv_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 10, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 10,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 10,
								recibe_porcentaje_no_aprobado + "%"));

						total[42] = sum;
						total[43] = sum_2;
						total[44] = sum_3;

						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// --------------------------------------Cobros-----------------------------------------------
						// --------------------------------------Cobros-----------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='57'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros = rs.getInt(1);
								recibe = Integer.toString(cobros);
							} else {
								cobros = 0;
								recibe = Integer.toString(cobros);
							}
							Sheet.addCell(new jxl.write.Label(2, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros Y PREGUNTA 57" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='58'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros2 = rs.getInt(1);
								recibe = Integer.toString(cobros2);
							} else {
								cobros2 = 0;
								recibe = Integer.toString(cobros2);
							}
							Sheet.addCell(new jxl.write.Label(5, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO cobros y pregunta 58" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='59'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros3 = rs.getInt(1);
								recibe = Integer.toString(cobros3);
							} else {
								cobros3 = 0;
								recibe = Integer.toString(cobros3);
							}
							Sheet.addCell(new jxl.write.Label(8, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros y pregunta 59" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='60'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros4 = rs.getInt(1);
								recibe = Integer.toString(cobros4);
							} else {
								cobros4 = 0;
								recibe = Integer.toString(cobros4);
							}
							Sheet.addCell(new jxl.write.Label(11, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros y pregunta 60" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='61'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros5 = rs.getInt(1);
								recibe = Integer.toString(cobros5);
							} else {
								cobros5 = 0;
								recibe = Integer.toString(cobros5);
							}
							Sheet.addCell(new jxl.write.Label(14, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros y pregunta 61" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='62'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros6 = rs.getInt(1);
								recibe = Integer.toString(cobros6);
							} else {
								cobros6 = 0;
								recibe = Integer.toString(cobros6);
							}
							Sheet.addCell(new jxl.write.Label(17, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros y pregunta 62" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='63'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros7 = rs.getInt(1);
								recibe = Integer.toString(cobros7);
							} else {
								cobros7 = 0;
								recibe = Integer.toString(cobros7);
							}
							Sheet.addCell(new jxl.write.Label(20, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros y pregunta 63" + ex);
						}

						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='57' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ok = rs.getInt(1);
								recibe = Integer.toString(cobros_ok);
							} else {
								cobros_ok = 0;
								recibe = Integer.toString(cobros_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ok y pregunta 57" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='58' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ok2 = rs.getInt(1);
								recibe = Integer.toString(cobros_ok2);
							} else {
								cobros_ok2 = 0;
								recibe = Integer.toString(cobros_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ok2 y pregunta 58" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='59' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ok3 = rs.getInt(1);
								recibe = Integer.toString(cobros_ok3);
							} else {
								cobros_ok3 = 0;
								recibe = Integer.toString(cobros_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ok3 y pregunta 59" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='60' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ok4 = rs.getInt(1);
								recibe = Integer.toString(cobros_ok4);
							} else {
								cobros_ok4 = 0;
								recibe = Integer.toString(cobros_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ok4 y pregunta 60" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='61' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ok5 = rs.getInt(1);
								recibe = Integer.toString(cobros_ok5);
							} else {
								cobros_ok5 = 0;
								recibe = Integer.toString(cobros_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ok5 y pregunta 61" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='62' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ok6 = rs.getInt(1);
								recibe = Integer.toString(cobros_ok6);
							} else {
								cobros_ok6 = 0;
								recibe = Integer.toString(cobros_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ok6 y pregunta 62" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='63' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ok7 = rs.getInt(1);
								recibe = Integer.toString(cobros_ok7);
							} else {
								cobros_ok7 = 0;
								recibe = Integer.toString(cobros_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ok7 y pregunta 63" + ex);
						}

						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='57' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ko = rs.getInt(1);
								recibe = Integer.toString(cobros_ko);

							} else {
								cobros_ko = 0;
								recibe = Integer.toString(cobros_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ko y pregunta 57" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='58' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ko2 = rs.getInt(1);
								recibe = Integer.toString(cobros_ko2);

							} else {
								cobros_ko2 = 0;
								recibe = Integer.toString(cobros_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ko2 y pregunta 58" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='59' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ko3 = rs.getInt(1);
								recibe = Integer.toString(cobros_ko3);

							} else {
								cobros_ko3 = 0;
								recibe = Integer.toString(cobros_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ko3 y pregunta 59" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='60' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ko4 = rs.getInt(1);
								recibe = Integer.toString(cobros_ko4);

							} else {
								cobros_ko4 = 0;
								recibe = Integer.toString(cobros_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ko4 y pregunta 60" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='61' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ko5 = rs.getInt(1);
								recibe = Integer.toString(cobros_ko5);

							} else {
								cobros_ko5 = 0;
								recibe = Integer.toString(cobros_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ko5 y pregunta 61" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='62' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ko6 = rs.getInt(1);
								recibe = Integer.toString(cobros_ko6);

							} else {
								cobros_ko6 = 0;
								recibe = Integer.toString(cobros_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ko6 y pregunta 62" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Cobros' && Id_pregunta='63' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								cobros_ko7 = rs.getInt(1);
								recibe = Integer.toString(cobros_ko7);

							} else {
								cobros_ko7 = 0;
								recibe = Integer.toString(cobros_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 11, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en cobros_ko7 y pregunta 63" + ex);
						}

						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sum = cobros + cobros2 + cobros3 + cobros4 + cobros5
								+ cobros6 + cobros7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 11, recibe_sum));
						sum_2 = cobros_ok + cobros_ok2 + cobros_ok3
								+ cobros_ok4 + cobros_ok5 + cobros_ok6
								+ cobros_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 11, recibe_sum_2));
						sum_3 = cobros_ko + cobros_ko2 + cobros_ko3
								+ cobros_ko4 + cobros_ko5 + cobros_ko6
								+ cobros_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 11, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 11,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 11,
								recibe_porcentaje_no_aprobado + "%"));
						total[45] = sum;
						total[46] = sum_2;
						total[47] = sum_3;

						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// --------------------------------------TRASLADOS-----------------------------------------------
						// --------------------------------------TRASLADOS-----------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='64'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras = rs.getInt(1);
								recibe = Integer.toString(tras);
							} else {
								tras = 0;
								recibe = Integer.toString(tras);
							}
							Sheet.addCell(new jxl.write.Label(2, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras Y PREGUNTA 64" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='65'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras2 = rs.getInt(1);
								recibe = Integer.toString(tras2);
							} else {
								tras2 = 0;
								recibe = Integer.toString(tras2);
							}
							Sheet.addCell(new jxl.write.Label(5, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO tras y pregunta 65" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='66'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras3 = rs.getInt(1);
								recibe = Integer.toString(tras3);
							} else {
								tras3 = 0;
								recibe = Integer.toString(tras3);
							}
							Sheet.addCell(new jxl.write.Label(8, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras y pregunta 66" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='67'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras4 = rs.getInt(1);
								recibe = Integer.toString(tras4);
							} else {
								tras4 = 0;
								recibe = Integer.toString(tras4);
							}
							Sheet.addCell(new jxl.write.Label(11, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras y pregunta 67" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='68'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras5 = rs.getInt(1);
								recibe = Integer.toString(tras5);
							} else {
								tras5 = 0;
								recibe = Integer.toString(tras5);
							}
							Sheet.addCell(new jxl.write.Label(14, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras y pregunta 68" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='69'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras6 = rs.getInt(1);
								recibe = Integer.toString(tras6);
							} else {
								tras6 = 0;
								recibe = Integer.toString(tras6);
							}
							Sheet.addCell(new jxl.write.Label(17, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras y pregunta 69" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='70'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras7 = rs.getInt(1);
								recibe = Integer.toString(tras7);
							} else {
								tras7 = 0;
								recibe = Integer.toString(tras7);
							}
							Sheet.addCell(new jxl.write.Label(20, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras y pregunta 70" + ex);
						}

						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='64' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ok = rs.getInt(1);
								recibe = Integer.toString(tras_ok);
							} else {
								tras_ok = 0;
								recibe = Integer.toString(tras_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok y pregunta 64" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='65' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ok2 = rs.getInt(1);
								recibe = Integer.toString(tras_ok2);
							} else {
								tras_ok2 = 0;
								recibe = Integer.toString(tras_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok2 y pregunta 65" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='66' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ok3 = rs.getInt(1);
								recibe = Integer.toString(tras_ok3);
							} else {
								tras_ok3 = 0;
								recibe = Integer.toString(tras_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok3 y pregunta 66" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='67' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ok4 = rs.getInt(1);
								recibe = Integer.toString(tras_ok4);
							} else {
								tras_ok4 = 0;
								recibe = Integer.toString(tras_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok4 y pregunta 67" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='68' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ok5 = rs.getInt(1);
								recibe = Integer.toString(tras_ok5);
							} else {
								tras_ok5 = 0;
								recibe = Integer.toString(tras_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok5 y pregunta 68" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='69' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ok6 = rs.getInt(1);
								recibe = Integer.toString(tras_ok6);
							} else {
								tras_ok6 = 0;
								recibe = Integer.toString(tras_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok6 y pregunta 69" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='70' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ok7 = rs.getInt(1);
								recibe = Integer.toString(tras_ok7);
							} else {
								tras_ok7 = 0;
								recibe = Integer.toString(tras_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok7 y pregunta 70" + ex);
						}

						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='64' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ko = rs.getInt(1);
								recibe = Integer.toString(tras_ko);

							} else {
								tras_ko = 0;
								recibe = Integer.toString(tras_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ko y pregunta 64" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='65' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ko2 = rs.getInt(1);
								recibe = Integer.toString(tras_ko2);

							} else {
								tras_ko2 = 0;
								recibe = Integer.toString(tras_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ko2 y pregunta 65" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='66' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ko3 = rs.getInt(1);
								recibe = Integer.toString(tras_ko3);

							} else {
								tras_ko3 = 0;
								recibe = Integer.toString(tras_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ko3 y pregunta 66" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='67' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ko4 = rs.getInt(1);
								recibe = Integer.toString(tras_ko4);

							} else {
								tras_ko4 = 0;
								recibe = Integer.toString(tras_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ko4 y pregunta 67" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='68' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ko5 = rs.getInt(1);
								recibe = Integer.toString(tras_ko5);

							} else {
								tras_ko5 = 0;
								recibe = Integer.toString(tras_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ko5 y pregunta 68" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='69' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ko6 = rs.getInt(1);
								recibe = Integer.toString(tras_ko6);

							} else {
								tras_ko6 = 0;
								recibe = Integer.toString(tras_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ko6 y pregunta 69" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO C.Titular - Traslado' && Id_pregunta='70' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								tras_ko7 = rs.getInt(1);
								recibe = Integer.toString(tras_ko7);

							} else {
								tras_ko7 = 0;
								recibe = Integer.toString(tras_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 12, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ko7 y pregunta 70" + ex);
						}

						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sum = tras + tras2 + tras3 + tras4 + tras5 + tras6
								+ tras7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 12, recibe_sum));
						sum_2 = tras_ok + tras_ok2 + tras_ok3 + tras_ok4
								+ tras_ok5 + tras_ok6 + tras_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 12, recibe_sum_2));
						sum_3 = tras_ko + tras_ko2 + tras_ko3 + tras_ko4
								+ tras_ko5 + tras_ko6 + tras_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 12, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 12,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 12,
								recibe_porcentaje_no_aprobado + "%"));

						total[48] = sum;
						total[49] = sum_2;
						total[50] = sum_3;

						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// --------------------------------------AVR
						// BAJAS----------------------------------------------
						// --------------------------------------AVR
						// BAJAS----------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='71'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas = rs.getInt(1);
								recibe = Integer.toString(bajas);
							} else {
								bajas = 0;
								recibe = Integer.toString(bajas);
							}
							Sheet.addCell(new jxl.write.Label(2, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas Y PREGUNTA 71" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='72'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas2 = rs.getInt(1);
								recibe = Integer.toString(bajas2);
							} else {
								bajas2 = 0;
								recibe = Integer.toString(bajas2);
							}
							Sheet.addCell(new jxl.write.Label(5, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO bajas y pregunta 72" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='73'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas3 = rs.getInt(1);
								recibe = Integer.toString(bajas3);
							} else {
								bajas3 = 0;
								recibe = Integer.toString(bajas3);
							}
							Sheet.addCell(new jxl.write.Label(8, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas y pregunta 73" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='74'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas4 = rs.getInt(1);
								recibe = Integer.toString(bajas4);
							} else {
								bajas4 = 0;
								recibe = Integer.toString(bajas4);
							}
							Sheet.addCell(new jxl.write.Label(11, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas y pregunta 74" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='75'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas5 = rs.getInt(1);
								recibe = Integer.toString(bajas5);
							} else {
								bajas5 = 0;
								recibe = Integer.toString(bajas5);
							}
							Sheet.addCell(new jxl.write.Label(14, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas y pregunta 75" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='76'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas6 = rs.getInt(1);
								recibe = Integer.toString(bajas6);
							} else {
								bajas6 = 0;
								recibe = Integer.toString(bajas6);
							}
							Sheet.addCell(new jxl.write.Label(17, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas y pregunta 76" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='77'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas7 = rs.getInt(1);
								recibe = Integer.toString(bajas7);
							} else {
								bajas7 = 0;
								recibe = Integer.toString(bajas7);
							}
							Sheet.addCell(new jxl.write.Label(20, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas y pregunta 77" + ex);
						}

						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='71' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ok = rs.getInt(1);
								recibe = Integer.toString(bajas_ok);
							} else {
								bajas_ok = 0;
								recibe = Integer.toString(bajas_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ok y pregunta 71" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='72' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ok2 = rs.getInt(1);
								recibe = Integer.toString(bajas_ok2);
							} else {
								bajas_ok2 = 0;
								recibe = Integer.toString(bajas_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ok2 y pregunta 72" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='73' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ok3 = rs.getInt(1);
								recibe = Integer.toString(bajas_ok3);
							} else {
								bajas_ok3 = 0;
								recibe = Integer.toString(bajas_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ok3 y pregunta 73" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='74' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ok4 = rs.getInt(1);
								recibe = Integer.toString(bajas_ok4);
							} else {
								bajas_ok4 = 0;
								recibe = Integer.toString(bajas_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ok4 y pregunta 74" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='75' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ok5 = rs.getInt(1);
								recibe = Integer.toString(bajas_ok5);
							} else {
								bajas_ok5 = 0;
								recibe = Integer.toString(bajas_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ok5 y pregunta 75" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='76' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ok6 = rs.getInt(1);
								recibe = Integer.toString(bajas_ok6);
							} else {
								bajas_ok6 = 0;
								recibe = Integer.toString(bajas_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok6 y pregunta 69" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='77' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ok7 = rs.getInt(1);
								recibe = Integer.toString(bajas_ok7);
							} else {
								bajas_ok7 = 0;
								recibe = Integer.toString(bajas_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en tras_ok7 y pregunta 70" + ex);
						}

						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='71' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ko = rs.getInt(1);
								recibe = Integer.toString(bajas_ko);

							} else {
								bajas_ko = 0;
								recibe = Integer.toString(bajas_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ko y pregunta 71" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='72' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ko2 = rs.getInt(1);
								recibe = Integer.toString(bajas_ko2);

							} else {
								bajas_ko2 = 0;
								recibe = Integer.toString(bajas_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ko2 y pregunta 72" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='73' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ko3 = rs.getInt(1);
								recibe = Integer.toString(bajas_ko3);

							} else {
								bajas_ko3 = 0;
								recibe = Integer.toString(bajas_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ko3 y pregunta 73" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='74' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ko4 = rs.getInt(1);
								recibe = Integer.toString(bajas_ko4);

							} else {
								bajas_ko4 = 0;
								recibe = Integer.toString(bajas_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ko4 y pregunta 74" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='75' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ko5 = rs.getInt(1);
								recibe = Integer.toString(bajas_ko5);

							} else {
								bajas_ko5 = 0;
								recibe = Integer.toString(bajas_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ko5 y pregunta 75" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='76' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ko6 = rs.getInt(1);
								recibe = Integer.toString(bajas_ko6);

							} else {
								bajas_ko6 = 0;
								recibe = Integer.toString(bajas_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ko6 y pregunta 76" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Bajas' && Id_pregunta='77' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								bajas_ko7 = rs.getInt(1);
								recibe = Integer.toString(bajas_ko7);

							} else {
								bajas_ko7 = 0;
								recibe = Integer.toString(bajas_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 13, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en bajas_ko7 y pregunta 77" + ex);
						}

						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sum = bajas + bajas2 + bajas3 + bajas4 + bajas5
								+ bajas6 + bajas7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 13, recibe_sum));
						sum_2 = bajas_ok + bajas_ok2 + bajas_ok3 + bajas_ok4
								+ bajas_ok5 + bajas_ok6 + bajas_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 13, recibe_sum_2));
						sum_3 = bajas_ko + bajas_ko2 + bajas_ko3 + bajas_ko4
								+ bajas_ko5 + bajas_ko6 + bajas_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 13, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 13,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 13,
								recibe_porcentaje_no_aprobado + "%"));

						total[51] = sum;
						total[52] = sum_2;
						total[53] = sum_3;
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// --------------------------------------AVR
						// Multiskill-----------------------------------------
						// --------------------------------------AVR
						// Multiskill-----------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='78'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi = rs.getInt(1);
								recibe = Integer.toString(multi);
							} else {
								multi = 0;
								recibe = Integer.toString(multi);
							}
							Sheet.addCell(new jxl.write.Label(2, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi Y PREGUNTA 78" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='79'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi2 = rs.getInt(1);
								recibe = Integer.toString(multi2);
							} else {
								multi2 = 0;
								recibe = Integer.toString(multi2);
							}
							Sheet.addCell(new jxl.write.Label(5, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en CO multi y pregunta 79" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='80'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi3 = rs.getInt(1);
								recibe = Integer.toString(multi3);
							} else {
								multi3 = 0;
								recibe = Integer.toString(multi3);
							}
							Sheet.addCell(new jxl.write.Label(8, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi y pregunta 80" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='81'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi4 = rs.getInt(1);
								recibe = Integer.toString(multi4);
							} else {
								multi4 = 0;
								recibe = Integer.toString(multi4);
							}
							Sheet.addCell(new jxl.write.Label(11, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi y pregunta 81" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='82'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi5 = rs.getInt(1);
								recibe = Integer.toString(multi5);
							} else {
								multi5 = 0;
								recibe = Integer.toString(multi5);
							}
							Sheet.addCell(new jxl.write.Label(14, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi y pregunta 82" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='83'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi6 = rs.getInt(1);
								recibe = Integer.toString(multi6);
							} else {
								multi6 = 0;
								recibe = Integer.toString(multi6);
							}
							Sheet.addCell(new jxl.write.Label(17, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi y pregunta 83" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='84'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi7 = rs.getInt(1);
								recibe = Integer.toString(multi7);
							} else {
								multi7 = 0;
								recibe = Integer.toString(multi7);
							}
							Sheet.addCell(new jxl.write.Label(20, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi y pregunta 84" + ex);
						}

						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='78' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ok = rs.getInt(1);
								recibe = Integer.toString(multi_ok);
							} else {
								multi_ok = 0;
								recibe = Integer.toString(multi_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ok y pregunta 78" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='79' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ok2 = rs.getInt(1);
								recibe = Integer.toString(multi_ok2);
							} else {
								multi_ok2 = 0;
								recibe = Integer.toString(multi_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ok2 y pregunta 79" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='80' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ok3 = rs.getInt(1);
								recibe = Integer.toString(multi_ok3);
							} else {
								multi_ok3 = 0;
								recibe = Integer.toString(multi_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ok3 y pregunta 80" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='81' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ok4 = rs.getInt(1);
								recibe = Integer.toString(multi_ok4);
							} else {
								multi_ok4 = 0;
								recibe = Integer.toString(multi_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ok4 y pregunta 81" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='82' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ok5 = rs.getInt(1);
								recibe = Integer.toString(multi_ok5);
							} else {
								multi_ok5 = 0;
								recibe = Integer.toString(multi_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ok5 y pregunta 82" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='83' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ok6 = rs.getInt(1);
								recibe = Integer.toString(multi_ok6);
							} else {
								multi_ok6 = 0;
								recibe = Integer.toString(multi_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ok6 y pregunta 83" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='84' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ok7 = rs.getInt(1);
								recibe = Integer.toString(multi_ok7);
							} else {
								multi_ok7 = 0;
								recibe = Integer.toString(multi_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ok7 y pregunta 84" + ex);
						}
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='78' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ko = rs.getInt(1);
								recibe = Integer.toString(multi_ko);

							} else {
								multi_ko = 0;
								recibe = Integer.toString(multi_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ko y pregunta 78" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='79' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ko2 = rs.getInt(1);
								recibe = Integer.toString(multi_ko2);

							} else {
								multi_ko2 = 0;
								recibe = Integer.toString(multi_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ko2 y pregunta 79" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='80' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ko3 = rs.getInt(1);
								recibe = Integer.toString(multi_ko3);

							} else {
								multi_ko3 = 0;
								recibe = Integer.toString(multi_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ko3 y pregunta 80" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='81' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ko4 = rs.getInt(1);
								recibe = Integer.toString(multi_ko4);

							} else {
								multi_ko4 = 0;
								recibe = Integer.toString(multi_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ko4 y pregunta 81" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='82' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ko5 = rs.getInt(1);
								recibe = Integer.toString(multi_ko5);

							} else {
								multi_ko5 = 0;
								recibe = Integer.toString(multi_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ko5 y pregunta 82" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='83' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ko6 = rs.getInt(1);
								recibe = Integer.toString(multi_ko6);

							} else {
								multi_ko6 = 0;
								recibe = Integer.toString(multi_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ko6 y pregunta 83" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO AVR Multiskill' && Id_pregunta='84' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								multi_ko7 = rs.getInt(1);
								recibe = Integer.toString(multi_ko7);

							} else {
								multi_ko7 = 0;
								recibe = Integer.toString(multi_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 14, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en multi_ko7 y pregunta 84" + ex);
						}
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						// -------------------------------------------------------------------------------------------
						sum = multi + multi2 + multi3 + multi4 + multi5
								+ multi6 + multi7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 14, recibe_sum));
						sum_2 = multi_ok + multi_ok2 + multi_ok3 + multi_ok4
								+ multi_ok5 + multi_ok6 + multi_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 14, recibe_sum_2));
						sum_3 = multi_ko + multi_ko2 + multi_ko3 + multi_ko4
								+ multi_ko5 + multi_ko6 + multi_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 14, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 14,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 14,
								recibe_porcentaje_no_aprobado + "%"));

						total[54] = sum;
						total[55] = sum_2;
						total[56] = sum_3;
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// ---------------------------------------------------------------------------------------------
						// --------------------------------------Ventas
						// AVV---------------------------------------------
						// --------------------------------------Ventas
						// AVV---------------------------------------------

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='85'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv = rs.getInt(1);
								recibe = Integer.toString(avv);
							} else {
								avv = 0;
								recibe = Integer.toString(avv);
							}
							Sheet.addCell(new jxl.write.Label(2, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv Y PREGUNTA 85" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='86'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv2 = rs.getInt(1);
								recibe = Integer.toString(avv2);
							} else {
								avv2 = 0;
								recibe = Integer.toString(avv2);
							}
							Sheet.addCell(new jxl.write.Label(5, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv y pregunta 86" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='87'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv3 = rs.getInt(1);
								recibe = Integer.toString(avv3);
							} else {
								avv3 = 0;
								recibe = Integer.toString(avv3);
							}
							Sheet.addCell(new jxl.write.Label(8, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv y pregunta 87" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='88'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv4 = rs.getInt(1);
								recibe = Integer.toString(avv4);
							} else {
								avv4 = 0;
								recibe = Integer.toString(avv4);
							}
							Sheet.addCell(new jxl.write.Label(11, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv y pregunta 88" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='89'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv5 = rs.getInt(1);
								recibe = Integer.toString(avv5);
							} else {
								avv5 = 0;
								recibe = Integer.toString(avv5);
							}
							Sheet.addCell(new jxl.write.Label(14, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv y pregunta 89" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='90'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv6 = rs.getInt(1);
								recibe = Integer.toString(avv6);
							} else {
								avv6 = 0;
								recibe = Integer.toString(avv6);
							}
							Sheet.addCell(new jxl.write.Label(17, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv y pregunta 90" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='91'";
						//
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv7 = rs.getInt(1);
								recibe = Integer.toString(avv7);
							} else {
								avv7 = 0;
								recibe = Integer.toString(avv);
							}
							Sheet.addCell(new jxl.write.Label(20, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv y pregunta 91" + ex);
						}

						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='85' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ok = rs.getInt(1);
								recibe = Integer.toString(avv_ok);
							} else {
								avv_ok = 0;
								recibe = Integer.toString(avv_ok);
							}
							Sheet.addCell(new jxl.write.Label(3, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ok y pregunta 85" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='86' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ok2 = rs.getInt(1);
								recibe = Integer.toString(avv_ok2);
							} else {
								avv_ok2 = 0;
								recibe = Integer.toString(avv_ok2);
							}
							Sheet.addCell(new jxl.write.Label(6, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ok2 y pregunta 86" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='87' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ok3 = rs.getInt(1);
								recibe = Integer.toString(avv_ok3);
							} else {
								avv_ok3 = 0;
								recibe = Integer.toString(avv_ok3);
							}
							Sheet.addCell(new jxl.write.Label(9, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ok3 y pregunta 87" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='88' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ok4 = rs.getInt(1);
								recibe = Integer.toString(avv_ok4);
							} else {
								avv_ok4 = 0;
								recibe = Integer.toString(avv_ok4);
							}
							Sheet.addCell(new jxl.write.Label(12, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ok4 y pregunta 88" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='89' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ok5 = rs.getInt(1);
								recibe = Integer.toString(avv_ok5);
							} else {
								avv_ok5 = 0;
								recibe = Integer.toString(avv_ok5);
							}
							Sheet.addCell(new jxl.write.Label(15, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ok5 y pregunta 89" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='90' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ok6 = rs.getInt(1);
								recibe = Integer.toString(avv_ok6);
							} else {
								avv_ok6 = 0;
								recibe = Integer.toString(avv_ok6);
							}
							Sheet.addCell(new jxl.write.Label(18, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ok6 y pregunta 90" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='91' && Evaluacion='Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ok7 = rs.getInt(1);
								recibe = Integer.toString(avv_ok7);
							} else {
								avv_ok7 = 0;
								recibe = Integer.toString(avv_ok7);
							}
							Sheet.addCell(new jxl.write.Label(21, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ok7 y pregunta 91" + ex);
						}

						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						// --------------------------------------------------------------------------------------------------------------
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='85' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ko = rs.getInt(1);
								recibe = Integer.toString(avv_ko);

							} else {
								avv_ko = 0;
								recibe = Integer.toString(avv_ko);
							}
							Sheet.addCell(new jxl.write.Label(4, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ko y pregunta 85" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='86' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ko2 = rs.getInt(1);
								recibe = Integer.toString(avv_ko2);

							} else {
								avv_ko2 = 0;
								recibe = Integer.toString(avv_ko2);
							}
							Sheet.addCell(new jxl.write.Label(7, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ko2 y pregunta 86" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='87' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ko3 = rs.getInt(1);
								recibe = Integer.toString(avv_ko3);

							} else {
								avv_ko3 = 0;
								recibe = Integer.toString(avv_ko3);
							}
							Sheet.addCell(new jxl.write.Label(10, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ko3 y pregunta 87" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='88' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ko4 = rs.getInt(1);
								recibe = Integer.toString(avv_ko4);

							} else {
								avv_ko4 = 0;
								recibe = Integer.toString(avv_ko4);
							}
							Sheet.addCell(new jxl.write.Label(13, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ko4 y pregunta 88" + ex);
						}
						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='89' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ko5 = rs.getInt(1);
								recibe = Integer.toString(avv_ko5);

							} else {
								avv_ko5 = 0;
								recibe = Integer.toString(avv_ko5);
							}
							Sheet.addCell(new jxl.write.Label(16, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ko5 y pregunta 89" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='90' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ko6 = rs.getInt(1);
								recibe = Integer.toString(avv_ko6);

							} else {
								avv_ko6 = 0;
								recibe = Integer.toString(avv_ko6);
							}
							Sheet.addCell(new jxl.write.Label(19, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ko6 y pregunta 90" + ex);
						}

						sql = "SELECT COUNT(*) FROM respuestas WHERE Sector='CO Ventas AVV' && Id_pregunta='91' && Evaluacion='No Aprobado'";
						try {
							pst = conn.prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								avv_ko7 = rs.getInt(1);
								recibe = Integer.toString(avv_ko7);

							} else {
								avv_ko7 = 0;
								recibe = Integer.toString(avv_ko7);
							}
							Sheet.addCell(new jxl.write.Label(22, 15, recibe));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"error: en avv_ko7 y pregunta 91" + ex);
						}
						sum = avv + avv2 + avv3 + avv4 + avv5 + avv6 + avv7;
						recibe_sum = Integer.toString(sum);
						Sheet.addCell(new jxl.write.Label(23, 15, recibe_sum));
						sum_2 = avv_ok + avv_ok2 + avv_ok3 + avv_ok4 + avv_ok5
								+ avv_ok6 + avv_ok7;
						recibe_sum_2 = Integer.toString(sum_2);
						Sheet.addCell(new jxl.write.Label(24, 15, recibe_sum_2));
						sum_3 = avv_ko + avv_ko2 + avv_ko3 + avv_ko4 + avv_ko5
								+ avv_ko6 + avv_ko7;
						// JOptionPane.showMessageDialog(null, sum_3);
						recibe_sum_3 = Integer.toString(sum_3);
						Sheet.addCell(new jxl.write.Label(25, 15, recibe_sum_3));

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 15,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 15,
								recibe_porcentaje_no_aprobado + "%"));
						total[57] = sum;
						total[58] = sum_2;
						total[59] = sum_3;
						// ----------------------------------------------------------------------------------------
						// ----------------------------------------------------------------------------------------
						// -----------------------------------------TOTAL------------------------------------------
						// -----------------------------------------TOTAL------------------------------------------

						total[0] = ACC_PRES + RETENCI + recla_press + ATC + ven
								+ provi + adls + omv + cobros + tras + bajas
								+ multi + avv;
						recibe_total = Integer.toString(total[0]);
						Sheet.addCell(new jxl.write.Label(2, 16, recibe_total));

						total[1] = ACC_PRES_2 + RETENCI_2 + recla_press2 + ATC2
								+ ven2 + provi2 + adls2 + omv2 + cobros2
								+ tras2 + bajas2 + multi2 + avv2;
						recibe_total = Integer.toString(total[1]);
						Sheet.addCell(new jxl.write.Label(5, 16, recibe_total));

						total[2] = ACC_PRES_3 + RETENCI_3 + recla_press3 + ATC3
								+ ven3 + provi3 + adls3 + omv3 + cobros3
								+ tras3 + bajas3 + multi3 + avv3;
						recibe_total = Integer.toString(total[2]);
						Sheet.addCell(new jxl.write.Label(8, 16, recibe_total));

						total[3] = ACC_PRES_4 + RETENCI_4 + recla_press4 + ATC4
								+ ven4 + provi4 + adls4 + omv4 + cobros4
								+ tras4 + bajas4 + multi4 + avv4;
						recibe_total = Integer.toString(total[3]);
						Sheet.addCell(new jxl.write.Label(11, 16, recibe_total));

						total[4] = ACC_PRES_5 + RETENCI_5 + recla_press5 + ATC5
								+ ven5 + provi5 + adls5 + omv5 + cobros5
								+ tras5 + bajas5 + multi5 + avv5;
						recibe_total = Integer.toString(total[4]);
						Sheet.addCell(new jxl.write.Label(14, 16, recibe_total));

						total[5] = ACC_PRES_6 + RETENCI_6 + recla_press6 + ATC6
								+ ven6 + provi6 + adls6 + omv6 + cobros6
								+ tras6 + bajas6 + multi6 + avv6;
						recibe_total = Integer.toString(total[5]);
						Sheet.addCell(new jxl.write.Label(17, 16, recibe_total));

						total[6] = ACC_PRES_7 + RETENCI_7 + recla_press7 + ATC7
								+ ven7 + provi7 + adls7 + omv7 + cobros7
								+ tras7 + bajas7 + multi7 + avv7;
						recibe_total = Integer.toString(total[6]);
						Sheet.addCell(new jxl.write.Label(20, 16, recibe_total));

						total[7] = ACC_OK + RETENCI_OK + recla_ok + ATC_OK
								+ ven_ok + provi_ok + adls_ok + omv_ok
								+ cobros_ok + tras_ok + bajas_ok + multi_ok
								+ avv_ok;
						recibe_total = Integer.toString(total[7]);
						Sheet.addCell(new jxl.write.Label(3, 16, recibe_total));

						total[8] = ACC_OK2 + RETENCI_OK_2 + recla_ok2 + ATC_OK2
								+ ven_ok2 + provi_ok2 + adls_ok2 + omv_ok2
								+ cobros_ok2 + tras_ok2 + bajas_ok2 + multi_ok2
								+ avv_ok2;
						recibe_total = Integer.toString(total[8]);
						Sheet.addCell(new jxl.write.Label(6, 16, recibe_total));

						total[9] = ACC_OK3 + RETENCI_OK_3 + recla_ok3 + ATC_OK3
								+ ven_ok3 + provi_ok3 + adls_ok3 + omv_ok3
								+ cobros_ok3 + tras_ok3 + bajas_ok3 + multi_ok3
								+ avv_ok3;
						recibe_total = Integer.toString(total[9]);
						Sheet.addCell(new jxl.write.Label(9, 16, recibe_total));

						total[10] = ACC_OK4 + RETENCI_OK_4 + recla_ok4
								+ ATC_OK4 + ven_ok4 + provi_ok4 + adls_ok4
								+ omv_ok4 + cobros_ok4 + tras_ok4 + bajas_ok4
								+ multi_ok4 + avv_ok4;
						recibe_total = Integer.toString(total[10]);
						Sheet.addCell(new jxl.write.Label(12, 16, recibe_total));

						total[11] = ACC_OK5 + RETENCI_OK_5 + recla_ok5
								+ ATC_OK5 + ven_ok5 + provi_ok5 + adls_ok5
								+ omv_ok5 + cobros_ok5 + tras_ok5 + bajas_ok5
								+ multi_ok5 + avv_ok5;
						recibe_total = Integer.toString(total[11]);
						Sheet.addCell(new jxl.write.Label(15, 16, recibe_total));

						total[12] = ACC_OK6 + RETENCI_OK_6 + recla_ok6
								+ ATC_OK6 + ven_ok6 + provi_ok6 + adls_ok6
								+ omv_ok6 + cobros_ok6 + tras_ok6 + bajas_ok6
								+ multi_ok6 + avv_ok6;
						recibe_total = Integer.toString(total[12]);
						Sheet.addCell(new jxl.write.Label(18, 16, recibe_total));

						total[13] = ACC_OK7 + RETENCI_OK_7 + recla_ok7
								+ ATC_OK7 + ven_ok7 + provi_ok7 + adls_ok7
								+ omv_ok7 + cobros_ok7 + tras_ok7 + bajas_ok7
								+ multi_ok7 + avv_ok7;
						recibe_total = Integer.toString(total[13]);
						Sheet.addCell(new jxl.write.Label(21, 16, recibe_total));

						total[14] = ACC_KO + RETENCI_KO + recla_ko + ATC_KO
								+ ven_ko + provi_ko + adls_ko + omv_ko
								+ cobros_ko + tras_ko + bajas_ko + multi_ko
								+ avv_ko;
						recibe_total = Integer.toString(total[14]);
						Sheet.addCell(new jxl.write.Label(4, 16, recibe_total));

						total[15] = ACC_KO2 + RETENCI_KO_2 + recla_ko2
								+ ATC_KO2 + ven_ko2 + provi_ko2 + adls_ko2
								+ omv_ko2 + cobros_ko2 + tras_ko2 + bajas_ko2
								+ multi_ko2 + avv_ko2;
						recibe_total = Integer.toString(total[15]);
						Sheet.addCell(new jxl.write.Label(7, 16, recibe_total));

						total[16] = ACC_KO3 + RETENCI_KO_3 + recla_ko3
								+ ATC_KO3 + ven_ko3 + provi_ko3 + adls_ko3
								+ omv_ko3 + cobros_ko3 + tras_ko3 + bajas_ko3
								+ multi_ko3 + avv_ko3;
						recibe_total = Integer.toString(total[16]);
						Sheet.addCell(new jxl.write.Label(10, 16, recibe_total));

						total[17] = ACC_KO4 + RETENCI_KO_4 + recla_ko4
								+ ATC_KO4 + ven_ko4 + provi_ko4 + adls_ko4
								+ omv_ko4 + cobros_ko4 + tras_ko4 + bajas_ko4
								+ multi_ko4 + avv_ko4;
						recibe_total = Integer.toString(total[17]);
						Sheet.addCell(new jxl.write.Label(13, 16, recibe_total));

						total[18] = ACC_KO5 + RETENCI_KO_5 + recla_ko5
								+ ATC_KO5 + ven_ko5 + provi_ko5 + adls_ko5
								+ omv_ko5 + cobros_ko5 + tras_ko5 + bajas_ko5
								+ multi_ko5 + avv_ko5;
						recibe_total = Integer.toString(total[18]);
						Sheet.addCell(new jxl.write.Label(16, 16, recibe_total));

						total[19] = ACC_KO6 + RETENCI_KO_6 + recla_ko6
								+ ATC_KO6 + ven_ko6 + provi_ko6 + adls_ko6
								+ omv_ko6 + cobros_ko6 + tras_ko6 + bajas_ko6
								+ multi_ko6 + avv_ko6;
						recibe_total = Integer.toString(total[19]);
						Sheet.addCell(new jxl.write.Label(19, 16, recibe_total));

						total[20] = ACC_KO7 + RETENCI_KO_7 + recla_ko7
								+ ATC_KO7 + ven_ko7 + provi_ko7 + adls_ko7
								+ omv_ko7 + cobros_ko7 + tras_ko7 + bajas_ko7
								+ multi_ko7 + avv_ko7;
						recibe_total = Integer.toString(total[20]);
						Sheet.addCell(new jxl.write.Label(22, 16, recibe_total));

						/*
						 * total[21]=
						 * total[0]+total[1]+total[2]+total[3]+total[4
						 * ]+total[5]+
						 * total[6]+total[7]+total[8]+total[9]+total[10]+
						 * total[11
						 * ]+total[12]+total[13]+total[14]+total[15]+total
						 * [16]+total[17]+total[18]+total[19]+total[20];
						 * recibe_total=Integer.toString(total[21]);
						 * Sheet.addCell(new
						 * jxl.write.Label(23,16,recibe_total));
						 */
						total[60] = total[21] + total[24] + total[27]
								+ total[30] + total[33] + total[36] + total[39]
								+ total[42] + total[45] + total[48] + total[51]
								+ total[54] + total[57];
						recibe_total = Integer.toString(total[60]);
						Sheet.addCell(new jxl.write.Label(23, 16, recibe_total));

						total[61] = total[22] + total[25] + total[28]
								+ total[31] + total[34] + total[37] + total[40]
								+ total[43] + total[46] + total[49] + total[52]
								+ total[55] + total[58];
						recibe_total = Integer.toString(total[61]);
						Sheet.addCell(new jxl.write.Label(24, 16, recibe_total));

						total[62] = total[23] + total[26] + total[29]
								+ total[32] + total[35] + total[38] + total[41]
								+ total[44] + total[47] + total[50] + total[53]
								+ total[56] + total[59];
						recibe_total = Integer.toString(total[62]);
						Sheet.addCell(new jxl.write.Label(25, 16, recibe_total));

						recibe_sum = Integer.toString(total[60]);
						recibe_sum_2 = Integer.toString(total[61]);
						recibe_sum_3 = Integer.toString(total[62]);

						pro = Double.parseDouble(recibe_sum);
						pro_2 = Double.parseDouble(recibe_sum_2);
						pro_3 = Double.parseDouble(recibe_sum_3);
						porcentaje_aprobado = (pro_2 / pro) * 100;
						deci = new DecimalFormat("0.00");

						aa = (deci.format(porcentaje_aprobado));
						recibe_porcentaje_aprobado = String.valueOf(aa);
						Sheet.addCell(new jxl.write.Label(26, 16,
								recibe_porcentaje_aprobado + "%"));

						porcentaje_no_aprobado = (pro_3 / pro) * 100;
						deci_2 = new DecimalFormat("0.00");

						b = (deci_2.format(porcentaje_no_aprobado));
						recibe_porcentaje_no_aprobado = String.valueOf(b);
						Sheet.addCell(new jxl.write.Label(27, 16,
								recibe_porcentaje_no_aprobado + "%"));
					}
					rs.close();
				} catch (SQLException n) {

					JOptionPane.showMessageDialog(null, "" + n.getMessage());
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Escribe el archivo excel en disco
				try {
					book.write();
					book.close();

					JOptionPane.showMessageDialog(null, "Escribiendo ...Listo");
				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				} catch (WriteException ex) {
					System.err.println(ex.getMessage());
				}

			}

		});
		Informe.setFont(new Font("Tahoma", Font.BOLD, 13));
		Informe.setBounds(204, 195, 109, 23);
		contentPane.add(Informe);
		
		JLabel label = new JLabel("Cerrar");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			dispose();
			}
		});
		label.setForeground(new Color(250, 235, 215));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label.setBounds(375, 21, 46, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("_____");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(375, 25, 80, 14);
		contentPane.add(label_1);
		setUndecorated(true);
		setLocationRelativeTo(null);

	}
}
