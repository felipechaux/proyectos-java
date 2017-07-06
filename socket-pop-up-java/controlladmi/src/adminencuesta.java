import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class adminencuesta extends JFrame {

	private JPanel contentPane;
	private JTextField name_encuesta;
	int limite_name = 50;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JComboBox sector;
	private JTextField p1r1;
	private JTextField p1r2;
	private JTextField p1r3;
	private JTextField p1r4;
	private JTextField p1r5;
	private JTextField p1r6;
	private JTextField p2r1;
	private JTextField p2r2;
	private JTextField p2r3;
	private JTextField p2r4;
	private JTextField p2r5;
	private JTextField p2r6;
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p3r1;
	private JTextField p3r2;
	private JTextField p3r3;
	private JTextField p3r4;
	private JTextField p3r5;
	private JTextField p3r6;
	private JTextField p4;
	private JTextField p5;
	private JTextField p4r1;
	private JTextField p4r2;
	private JTextField p4r3;
	private JTextField p4r4;
	private JTextField p4r5;
	private JTextField p4r6;
	private JTextField p5r6;
	private JTextField p5r5;
	private JTextField p5r4;
	private JTextField p5r3;
	private JTextField p5r2;
	private JTextField p5r1;
	private JTextField p6;
	private JLabel label_5;
	private JTextField p6r1;
	private JTextField p6r2;
	private JTextField p6r3;
	private JTextField p6r4;
	private JTextField p6r5;
	private JTextField p6r6;
	int b1, b2, b3, b4, b5, b6,b7;
	String pr1, pr2, pr3, pr4, pr5, pr6,pr7, sectorvalue;
	Object sec;
	ButtonGroup buttonGroup1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminencuesta frame = new adminencuesta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public adminencuesta() throws SQLException {

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1323, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1320, 682);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCerrar = new JLabel("Cerrar");
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblCerrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCerrar.setForeground(Color.BLACK);
		lblCerrar.setBounds(1184, 16, 89, 28);
		panel.add(lblCerrar);

		JLabel name = new JLabel("Administrador de encuesta");
		name.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(10, 11, 309, 39);
		panel.add(name);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNombre.setBounds(10, 83, 76, 18);
		panel.add(lblNombre);

		name_encuesta = new JTextField();
		name_encuesta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (name_encuesta.getText().length() == limite_name)

					e.consume();

			}
		});
		name_encuesta.setBounds(105, 84, 140, 20);
		panel.add(name_encuesta);
		name_encuesta.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sec = sector.getSelectedItem();
				sectorvalue = String.valueOf(sec);
				
				con = (Connection) conexion.ConnectDB();
				String sql = "UPDATE preguntas_enc set nombre_enc='"
						+ name_encuesta.getText() + "' where Sector ='"+sectorvalue+"'  ";
				try {
					pst = (PreparedStatement) con.prepareStatement(sql);
					int n = pst.executeUpdate();
					if (n > 0) {
						JOptionPane.showMessageDialog(null,
								"actualizacion realizada");
					}
					else{
						JOptionPane.showMessageDialog(null,
								"No existe encuesta/preguntas para el sector "+sectorvalue);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "error " + e1);
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnModificar.setBounds(416, 106, 89, 23);
		panel.add(btnModificar);

		JLabel lblSeleccioneUnSector = new JLabel("Seleccione un sector :");
		lblSeleccioneUnSector.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblSeleccioneUnSector.setBounds(10, 144, 180, 18);
		panel.add(lblSeleccioneUnSector);

		sector = new JComboBox();
		sector.setBounds(196, 129, 200, 33);
		panel.add(sector);

		JLabel lblCampoDeTexto = new JLabel("Campo de texto :");
		lblCampoDeTexto.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblCampoDeTexto.setBounds(10, 192, 180, 18);
		panel.add(lblCampoDeTexto);

		final JRadioButton tsi = new JRadioButton("Si");
		tsi.setBounds(159, 192, 46, 23);
		panel.add(tsi);

		final JRadioButton tno = new JRadioButton("No");
		tno.setBounds(211, 192, 46, 23);
		panel.add(tno);

		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(tsi);
		buttonGroup1.add(tno);
		JLabel label = new JLabel("1 .");
		label.setFont(new Font("Arial Black", Font.ITALIC, 14));
		label.setBounds(10, 268, 39, 18);
		panel.add(label);

		JLabel label_1 = new JLabel("2 .");
		label_1.setFont(new Font("Arial Black", Font.ITALIC, 14));
		label_1.setBounds(267, 268, 39, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("3 .");
		label_2.setFont(new Font("Arial Black", Font.ITALIC, 14));
		label_2.setBounds(521, 268, 39, 18);
		panel.add(label_2);

		JLabel lblPreguntasYRespuestas = new JLabel("Preguntas y respuestas :");
		lblPreguntasYRespuestas
				.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblPreguntasYRespuestas.setBounds(10, 239, 209, 18);
		panel.add(lblPreguntasYRespuestas);

		p1r1 = new JTextField();
		p1r1.setBounds(42, 307, 86, 20);
		panel.add(p1r1);
		p1r1.setColumns(10);

		p1r2 = new JTextField();
		p1r2.setColumns(10);
		p1r2.setBounds(42, 327, 86, 20);
		panel.add(p1r2);

		p1r3 = new JTextField();
		p1r3.setColumns(10);
		p1r3.setBounds(42, 348, 86, 20);
		panel.add(p1r3);

		p1r4 = new JTextField();
		p1r4.setColumns(10);
		p1r4.setBounds(42, 368, 86, 20);
		panel.add(p1r4);

		p1r5 = new JTextField();
		p1r5.setColumns(10);
		p1r5.setBounds(42, 389, 86, 20);
		panel.add(p1r5);

		p1r6 = new JTextField();
		p1r6.setColumns(10);
		p1r6.setBounds(42, 411, 86, 20);
		panel.add(p1r6);

		p2r1 = new JTextField();
		p2r1.setColumns(10);
		p2r1.setBounds(302, 307, 86, 20);
		panel.add(p2r1);

		p2r2 = new JTextField();
		p2r2.setColumns(10);
		p2r2.setBounds(302, 327, 86, 20);
		panel.add(p2r2);

		p2r3 = new JTextField();
		p2r3.setColumns(10);
		p2r3.setBounds(302, 348, 86, 20);
		panel.add(p2r3);

		p2r4 = new JTextField();
		p2r4.setColumns(10);
		p2r4.setBounds(302, 368, 86, 20);
		panel.add(p2r4);

		p2r5 = new JTextField();
		p2r5.setColumns(10);
		p2r5.setBounds(302, 389, 86, 20);
		panel.add(p2r5);

		p2r6 = new JTextField();
		p2r6.setColumns(10);
		p2r6.setBounds(302, 411, 86, 20);
		panel.add(p2r6);

		p1 = new JTextField();
		p1.setColumns(10);
		p1.setBounds(42, 265, 203, 28);
		panel.add(p1);

		p2 = new JTextField();
		p2.setColumns(10);
		p2.setBounds(302, 265, 203, 28);
		panel.add(p2);

		p3 = new JTextField();
		p3.setColumns(10);
		p3.setBounds(550, 265, 203, 28);
		panel.add(p3);

		p3r1 = new JTextField();
		p3r1.setColumns(10);
		p3r1.setBounds(550, 307, 86, 20);
		panel.add(p3r1);

		p3r2 = new JTextField();
		p3r2.setColumns(10);
		p3r2.setBounds(550, 327, 86, 20);
		panel.add(p3r2);

		p3r3 = new JTextField();
		p3r3.setColumns(10);
		p3r3.setBounds(550, 348, 86, 20);
		panel.add(p3r3);

		p3r4 = new JTextField();
		p3r4.setColumns(10);
		p3r4.setBounds(550, 368, 86, 20);
		panel.add(p3r4);

		p3r5 = new JTextField();
		p3r5.setColumns(10);
		p3r5.setBounds(550, 389, 86, 20);
		panel.add(p3r5);

		p3r6 = new JTextField();
		p3r6.setColumns(10);
		p3r6.setBounds(550, 411, 86, 20);
		panel.add(p3r6);

		JLabel label_3 = new JLabel("4 .");
		label_3.setFont(new Font("Arial Black", Font.ITALIC, 14));
		label_3.setBounds(777, 268, 39, 18);
		panel.add(label_3);

		p4 = new JTextField();
		p4.setColumns(10);
		p4.setBounds(805, 265, 203, 28);
		panel.add(p4);

		JLabel label_4 = new JLabel("5 .");
		label_4.setFont(new Font("Arial Black", Font.ITALIC, 14));
		label_4.setBounds(1026, 268, 39, 18);
		panel.add(label_4);

		p5 = new JTextField();
		p5.setColumns(10);
		p5.setBounds(1054, 265, 203, 28);
		panel.add(p5);

		p4r1 = new JTextField();
		p4r1.setColumns(10);
		p4r1.setBounds(805, 307, 86, 20);
		panel.add(p4r1);

		p4r2 = new JTextField();
		p4r2.setColumns(10);
		p4r2.setBounds(805, 327, 86, 20);
		panel.add(p4r2);

		p4r3 = new JTextField();
		p4r3.setColumns(10);
		p4r3.setBounds(805, 348, 86, 20);
		panel.add(p4r3);

		p4r4 = new JTextField();
		p4r4.setColumns(10);
		p4r4.setBounds(805, 368, 86, 20);
		panel.add(p4r4);

		p4r5 = new JTextField();
		p4r5.setColumns(10);
		p4r5.setBounds(805, 389, 86, 20);
		panel.add(p4r5);

		p4r6 = new JTextField();
		p4r6.setColumns(10);
		p4r6.setBounds(805, 411, 86, 20);
		panel.add(p4r6);

		p5r6 = new JTextField();
		p5r6.setColumns(10);
		p5r6.setBounds(1054, 411, 86, 20);
		panel.add(p5r6);

		p5r5 = new JTextField();
		p5r5.setColumns(10);
		p5r5.setBounds(1054, 389, 86, 20);
		panel.add(p5r5);

		p5r4 = new JTextField();
		p5r4.setColumns(10);
		p5r4.setBounds(1054, 368, 86, 20);
		panel.add(p5r4);

		p5r3 = new JTextField();
		p5r3.setColumns(10);
		p5r3.setBounds(1054, 348, 86, 20);
		panel.add(p5r3);

		p5r2 = new JTextField();
		p5r2.setColumns(10);
		p5r2.setBounds(1054, 327, 86, 20);
		panel.add(p5r2);

		p5r1 = new JTextField();
		p5r1.setColumns(10);
		p5r1.setBounds(1054, 307, 86, 20);
		panel.add(p5r1);

		p6 = new JTextField();
		p6.setColumns(10);
		p6.setBounds(42, 470, 203, 28);
		panel.add(p6);

		label_5 = new JLabel("6 .");
		label_5.setFont(new Font("Arial Black", Font.ITALIC, 14));
		label_5.setBounds(10, 473, 39, 18);
		panel.add(label_5);

		p6r1 = new JTextField();
		p6r1.setColumns(10);
		p6r1.setBounds(42, 512, 86, 20);
		panel.add(p6r1);

		p6r2 = new JTextField();
		p6r2.setColumns(10);
		p6r2.setBounds(42, 532, 86, 20);
		panel.add(p6r2);

		p6r3 = new JTextField();
		p6r3.setColumns(10);
		p6r3.setBounds(42, 553, 86, 20);
		panel.add(p6r3);

		p6r4 = new JTextField();
		p6r4.setColumns(10);
		p6r4.setBounds(42, 573, 86, 20);
		panel.add(p6r4);

		p6r5 = new JTextField();
		p6r5.setColumns(10);
		p6r5.setBounds(42, 594, 86, 20);
		panel.add(p6r5);

		p6r6 = new JTextField();
		p6r6.setColumns(10);
		p6r6.setBounds(42, 616, 86, 20);
		panel.add(p6r6);

		JButton btnEnviarEncuesta = new JButton("Guardar encuesta");
		btnEnviarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1 = 0;
				b2 = 0;
				b3 = 0;
				b4 = 0;
				b5 = 0;
				b6 = 0;
				b7 = 0;

				pr1 = "";
				pr2 = "";
				pr3 = "";
				pr4 = "";
				pr5 = "";
				pr6 = "";
				pr7 = "";

				sec = sector.getSelectedItem();
				sectorvalue = String.valueOf(sec);

				if ((tsi.isSelected() == false) && (tno.isSelected() == false)) {
					JOptionPane
							.showMessageDialog(null,
									"Por favor , seleccione si desea o no mostrar la caja de comentario ");
				}else if(name_encuesta.getText().equals("")){
					JOptionPane
					.showMessageDialog(null,
							"Por favor , ingrese un nombre para la encuesta ");
				}
				else {

					try {

						Statement std;
						std = conexion.ConnectDB().createStatement();

						if (( (p1.getText().equals("")) || (p1r1.getText()
								.equals("")))
								&& ((p1.getText().equals("")) || (p1r2
										.getText().equals("")))
								&& ((p1.getText().equals("")) || (p1r2
										.getText().equals("")))
								&& ((p1.getText().equals("")) || (p1r3
										.getText().equals("")))
								&& ((p1.getText().equals("")) || (p1r4
										.getText().equals("")))
								&& ((p1.getText().equals("")) || (p1r5
										.getText().equals("")))
								&& ((p1.getText().equals("")) || (p1r6
										.getText().equals("")))) {
						} else {
							Statement std1 = conexion.ConnectDB()
									.createStatement();
							ResultSet rs1 = std1
									.executeQuery("SELECT distinct Sector FROM preguntas_enc WHERE Sector ='"
											+ sectorvalue
											+ "' AND id_pregunta ='1' ");

							if (rs1.next() == true) {
								JOptionPane.showMessageDialog(null,
										"Ya existe una pregunta 1. asociada al sector : "
												+ sectorvalue);
							} else {

								std.executeUpdate("INSERT INTO preguntas_enc(id_pregunta,nombre_enc,pregunta,r1,r2,r3,r4,r5,r6,Sector) VALUES ('1','"
										+ name_encuesta.getText()
										+ "','"
										+ "1. "
										+ p1.getText()
										+ "','"
										+ p1r1.getText()
										+ "','"
										+ p1r2.getText()
										+ "','"
										+ p1r3.getText()
										+ "','"
										+ p1r4.getText()
										+ "','"
										+ p1r5.getText()
										+ "','"
										+ p1r6.getText()
										+ "','"
										+ sectorvalue
										+ "') ");
								b1 = 1;
								pr1 = "Pregunta 1 \n";
							}
						}

						if (((p2.getText().equals("")) || (p2r1.getText()
								.equals("")))
								&& ((p2.getText().equals("")) || (p2r2
										.getText().equals("")))
								&& ((p2.getText().equals("")) || (p2r2
										.getText().equals("")))
								&& ((p2.getText().equals("")) || (p2r3
										.getText().equals("")))
								&& ((p2.getText().equals("")) || (p2r4
										.getText().equals("")))
								&& ((p2.getText().equals("")) || (p2r5
										.getText().equals("")))
								&& ((p2.getText().equals("")) || (p2r6
										.getText().equals("")))) {
						} else {
							Statement std1 = conexion.ConnectDB()
									.createStatement();
							ResultSet rs1 = std1
									.executeQuery("SELECT distinct Sector FROM preguntas_enc WHERE Sector ='"
											+ sectorvalue
											+ "' AND id_pregunta ='2' ");

							if (rs1.next() == true) {
								JOptionPane.showMessageDialog(null,
										"Ya existe una pregunta 2. asociada al sector : "
												+ sectorvalue);
							} else {
								
							std.executeUpdate("INSERT INTO preguntas_enc(id_pregunta,nombre_enc,pregunta,r1,r2,r3,r4,r5,r6,Sector) VALUES ('2','"+name_encuesta.getText()+"','"
									+ "2. "
									+ p2.getText()
									+ "','"
									+ p2r1.getText()
									+ "','"
									+ p2r2.getText()
									+ "','"
									+ p2r3.getText()
									+ "','"
									+ p2r4.getText()
									+ "','"
									+ p2r5.getText()
									+ "','"
									+ p2r6.getText()
									+ "','"
									+ sectorvalue + "') ");
							b2 = 1;
							pr2 = "Pregunta 2 \n";
						}
						}

						if (((p3.getText().equals("")) || (p3r1.getText()
								.equals("")))
								&& ((p3.getText().equals("")) || (p3r2
										.getText().equals("")))
								&& ((p3.getText().equals("")) || (p3r2
										.getText().equals("")))
								&& ((p3.getText().equals("")) || (p3r3
										.getText().equals("")))
								&& ((p3.getText().equals("")) || (p3r4
										.getText().equals("")))
								&& ((p3.getText().equals("")) || (p3r5
										.getText().equals("")))
								&& ((p3.getText().equals("")) || (p3r6
										.getText().equals("")))) {
						} else {
							Statement std1 = conexion.ConnectDB()
									.createStatement();
							ResultSet rs1 = std1
									.executeQuery("SELECT distinct Sector FROM preguntas_enc WHERE Sector ='"
											+ sectorvalue
											+ "' AND id_pregunta ='3' ");

							if (rs1.next() == true) {
								JOptionPane.showMessageDialog(null,
										"Ya existe una pregunta 3. asociada al sector : "
												+ sectorvalue);
							} else {
							std.executeUpdate("INSERT INTO preguntas_enc(id_pregunta,nombre_enc,pregunta,r1,r2,r3,r4,r5,r6,Sector) VALUES ('3','"+name_encuesta.getText()+"','"
									+ "3. "
									+ p3.getText()
									+ "','"
									+ p3r1.getText()
									+ "','"
									+ p3r2.getText()
									+ "','"
									+ p3r3.getText()
									+ "','"
									+ p3r4.getText()
									+ "','"
									+ p3r5.getText()
									+ "','"
									+ p3r6.getText()
									+ "','"
									+ sectorvalue + "') ");
							b3 = 1;
							pr3 = "Pregunta 3 \n";
						}
						}
						if (((p4.getText().equals("")) || (p4r1.getText()
								.equals("")))
								&& ((p4.getText().equals("")) || (p4r2
										.getText().equals("")))
								&& ((p4.getText().equals("")) || (p4r2
										.getText().equals("")))
								&& ((p4.getText().equals("")) || (p4r3
										.getText().equals("")))
								&& ((p4.getText().equals("")) || (p4r4
										.getText().equals("")))
								&& ((p4.getText().equals("")) || (p4r5
										.getText().equals("")))
								&& ((p4.getText().equals("")) || (p4r6
										.getText().equals("")))) {
						} else {
							Statement std1 = conexion.ConnectDB()
									.createStatement();
							ResultSet rs1 = std1
									.executeQuery("SELECT distinct Sector FROM preguntas_enc WHERE Sector ='"
											+ sectorvalue
											+ "' AND id_pregunta ='4' ");

							if (rs1.next() == true) {
								JOptionPane.showMessageDialog(null,
										"Ya existe una pregunta 4. asociada al sector : "
												+ sectorvalue);
							} else {
								
							std.executeUpdate("INSERT INTO preguntas_enc(id_pregunta,nombre_enc,pregunta,r1,r2,r3,r4,r5,r6,Sector) VALUES ('4','"+name_encuesta.getText()+"','"
									+ "4. "
									+ p4.getText()
									+ "','"
									+ p4r1.getText()
									+ "','"
									+ p4r2.getText()
									+ "','"
									+ p4r3.getText()
									+ "','"
									+ p4r4.getText()
									+ "','"
									+ p4r5.getText()
									+ "','"
									+ p4r6.getText()
									+ "','"
									+ sectorvalue + "') ");
							b4 = 1;
							pr4 = "Pregunta 4 \n";
						}
						}
						if (((p5.getText().equals("")) || (p5r1.getText()
								.equals("")))
								&& ((p5.getText().equals("")) || (p5r2
										.getText().equals("")))
								&& ((p5.getText().equals("")) || (p5r2
										.getText().equals("")))
								&& ((p5.getText().equals("")) || (p5r3
										.getText().equals("")))
								&& ((p5.getText().equals("")) || (p5r4
										.getText().equals("")))
								&& ((p5.getText().equals("")) || (p5r5
										.getText().equals("")))
								&& ((p5.getText().equals("")) || (p5r6
										.getText().equals("")))) {
						} else {
							Statement std1 = conexion.ConnectDB()
									.createStatement();
							ResultSet rs1 = std1
									.executeQuery("SELECT distinct Sector FROM preguntas_enc WHERE Sector ='"
											+ sectorvalue
											+ "' AND id_pregunta ='5' ");

							if (rs1.next() == true) {
								JOptionPane.showMessageDialog(null,
										"Ya existe una pregunta 5. asociada al sector : "
												+ sectorvalue);
							} else {
								
				
							std.executeUpdate("INSERT INTO preguntas_enc(id_pregunta,nombre_enc,pregunta,r1,r2,r3,r4,r5,r6,Sector) VALUES ('5','"+name_encuesta.getText()+"','"
									+ "5. "
									+ p5.getText()
									+ "','"
									+ p5r1.getText()
									+ "','"
									+ p5r2.getText()
									+ "','"
									+ p5r3.getText()
									+ "','"
									+ p5r4.getText()
									+ "','"
									+ p5r5.getText()
									+ "','"
									+ p5r6.getText()
									+ "','"
									+ sectorvalue + "') ");
							b5 = 1;
							pr5 = "Pregunta 5 \n";
						}
						}
						if (((p6.getText().equals("")) || (p6r1.getText()
								.equals("")))
								&& ((p6.getText().equals("")) || (p6r2
										.getText().equals("")))
								&& ((p6.getText().equals("")) || (p6r2
										.getText().equals("")))
								&& ((p6.getText().equals("")) || (p6r3
										.getText().equals("")))
								&& ((p6.getText().equals("")) || (p6r4
										.getText().equals("")))
								&& ((p6.getText().equals("")) || (p6r5
										.getText().equals("")))
								&& ((p6.getText().equals("")) || (p6r6
										.getText().equals("")))) {
						} else {
							Statement std1 = conexion.ConnectDB()
									.createStatement();
							ResultSet rs1 = std1
									.executeQuery("SELECT distinct Sector FROM preguntas_enc WHERE Sector ='"
											+ sectorvalue
											+ "' AND id_pregunta ='6' ");

							if (rs1.next() == true) {
								JOptionPane.showMessageDialog(null,
										"Ya existe una pregunta 6. asociada al sector : "
												+ sectorvalue);
							} else {
							std.executeUpdate("INSERT INTO preguntas_enc(id_pregunta,nombre_enc,pregunta,r1,r2,r3,r4,r5,r6,Sector) VALUES ('6','"+name_encuesta.getText()+"','"
									+ "6. "
									+ p6.getText()
									+ "','"
									+ p6r1.getText()
									+ "','"
									+ p6r2.getText()
									+ "','"
									+ p6r3.getText()
									+ "','"
									+ p6r4.getText()
									+ "','"
									+ p6r5.getText()
									+ "','"
									+ p6r6.getText()
									+ "','"
									+ sectorvalue + "') ");
							b6 = 1;
							pr6 = "Pregunta 6 \n";
						}
						}
						
						if (tsi.isSelected()) {
							Statement std1 = conexion.ConnectDB()
									.createStatement();
							ResultSet rs1 = std1
									.executeQuery("SELECT distinct Sector FROM preguntas_enc WHERE Sector ='"
											+ sectorvalue
											+ "' AND id_pregunta ='7' ");

							if (rs1.next() == true) {
								JOptionPane.showMessageDialog(null,
										"Ya existe una pregunta 7 ( caja de comentario ) asociada al sector : "
												+ sectorvalue);
							}else{
								std.executeUpdate("INSERT INTO preguntas_enc(id_pregunta,nombre_enc,pregunta,Sector) VALUES ('7','"+name_encuesta.getText()+"','comentario','"
										+ sectorvalue + "')");
								b7 = 1;
								pr7 = "Pregunta 7 ( caja de comentario )  \n";
							}
							
							
						}

						if ((b1 == 1) || (b2 == 1) || (b3 == 1) || (b4 == 1)
								|| (b5 == 1) || (b6 == 1)|| (b7 == 1)) {
							JOptionPane.showMessageDialog(null,
									"Encuesta guardada \n Preguntas alojadas : \n"
											+ " " + pr1 + "" + " " + pr2 + ""
											+ " " + pr3 + "" + " " + pr4 + ""
											+ " " + pr5 + "" + " " + pr6 + ""
											+ " " + pr7 + "" 
											+ "");
							
						} else {
							JOptionPane
									.showMessageDialog(null,
											"Por favor , Ingrese por lo menos una pregunta y una respuesta con sector valido ");

						}

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "error " + e1);
						e1.printStackTrace();
					}
				}

			}
		});
		btnEnviarEncuesta.setBounds(393, 572, 140, 23);
		panel.add(btnEnviarEncuesta);
		setLocationRelativeTo(null);

		cargarData();
	}

	public void cargarData() throws SQLException {
		Statement std = conexion.ConnectDB().createStatement();
		ResultSet rs2 = std
				.executeQuery("SELECT distinct Sector  FROM nomina ");
		while (rs2.next()) {

			// System.out.print("" + res.getString("Sector"));
			sec = rs2.getString("Sector");
			sector.addItem(sec);
		}

	}
}
