import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import org.edisoncor.gui.panel.NewJFrame;
import org.edisoncor.gui.panel.PanelCurves;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class index extends JFrame {
	
	 ImageIcon imagen;
	  
	 JPanel contenedor;
	
	// ////////////////cronometro
	JLabel crono = new JLabel("00 :");
	JLabel ncro = new JLabel("00");
	int flox = 0;
	// ///////////////////////////////////time////////
	int xerox = 0;
	int xerox2 = 0;
	

	Timer cronometro = new Timer(500, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			xerox2++;
			if (xerox2 == 1) {
				ncro.setText("00");
			}
			if (xerox2 == 3) {
				ncro.setText("01");
			}
			if (xerox2 == 5) {
				ncro.setText("02");
			}
			if (xerox2 == 7) {
				ncro.setText("03");
			}
			if (xerox2 == 9) {
				ncro.setText("04");
			}
			if (xerox2 == 11) {
				ncro.setText("05");
			}
			if (xerox2 == 13) {
				ncro.setText("06");
			}
			if (xerox2 == 15) {
				ncro.setText("07");
			}
			if (xerox2 == 17) {
				ncro.setText("08");
			}
			if (xerox2 == 19) {
				ncro.setText("09");
			}
			if (xerox2 == 21) {
				ncro.setText("10");
			}
			if (xerox2 == 23) {
				ncro.setText("11");
			}
			if (xerox2 == 25) {
				ncro.setText("12");
			}
			if (xerox2 == 27) {
				ncro.setText("13");
			}
			if (xerox2 == 29) {
				ncro.setText("14");
			}
			if (xerox2 == 31) {
				ncro.setText("15");
			}
			if (xerox2 == 33) {
				ncro.setText("16");
			}
			if (xerox2 == 35) {
				ncro.setText("17");
			}
			if (xerox2 == 37) {
				ncro.setText("18");
			}
			if (xerox2 == 39) {
				ncro.setText("19");
			}
			if (xerox2 == 41) {
				ncro.setText("20");
			}
			if (xerox2 == 43) {
				ncro.setText("21");
			}
			if (xerox2 == 45) {
				ncro.setText("22");
			}
			if (xerox2 == 47) {
				ncro.setText("23");
			}
			if (xerox2 == 49) {
				ncro.setText("24");
			}
			if (xerox2 == 51) {
				ncro.setText("25");
			}
			if (xerox2 == 53) {
				ncro.setText("26");
			}
			if (xerox2 == 55) {
				ncro.setText("27");
			}
			if (xerox2 == 57) {
				ncro.setText("28");
			}
			if (xerox2 == 59) {
				ncro.setText("29");
			}
			if (xerox2 == 61) {
				ncro.setText("30");
			}
			if (xerox2 == 63) {
				ncro.setText("31");
			}
			if (xerox2 == 65) {
				ncro.setText("32");
			}
			if (xerox2 == 67) {
				ncro.setText("33");
			}
			if (xerox2 == 69) {
				ncro.setText("34");
			}
			if (xerox2 == 71) {
				ncro.setText("35");
			}
			if (xerox2 == 73) {
				ncro.setText("36");
			}
			if (xerox2 == 75) {
				ncro.setText("37");
			}
			if (xerox2 == 77) {
				ncro.setText("38");
			}
			if (xerox2 == 79) {
				ncro.setText("39");
			}
			if (xerox2 == 81) {
				ncro.setText("40");
			}
			if (xerox2 == 83) {
				ncro.setText("41");
			}
			if (xerox2 == 85) {
				ncro.setText("42");
			}
			if (xerox2 == 87) {
				ncro.setText("43");
			}
			if (xerox2 == 89) {
				ncro.setText("44");
			}
			if (xerox2 == 91) {
				ncro.setText("45");
			}
			if (xerox2 == 93) {
				ncro.setText("46");
			}
			if (xerox2 == 95) {
				ncro.setText("47");
			}
			if (xerox2 == 97) {
				ncro.setText("48");
			}
			if (xerox2 == 99) {
				ncro.setText("49");
			}
			if (xerox2 == 101) {
				ncro.setText("50");
			}
			if (xerox2 == 103) {
				ncro.setText("51");
			}
			if (xerox2 == 105) {
				ncro.setText("52");
			}
			if (xerox2 == 107) {
				ncro.setText("53");
			}
			if (xerox2 == 109) {
				ncro.setText("54");
			}
			if (xerox2 == 111) {
				ncro.setText("55");
			}
			if (xerox2 == 113) {
				ncro.setText("56");
			}
			if (xerox2 == 115) {
				ncro.setText("57");
			}
			if (xerox2 == 117) {
				ncro.setText("58");
			}
			if (xerox2 == 119) {
				ncro.setText("59");
			}
		}
	});
	

	Timer time = new Timer(600, new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			xerox++;

			cronometro.start();

			if (xerox == 100) {
				ncro.setText("00");
				crono.setText("01 :");

				xerox2 = 0;

			}
			if (xerox == 200) {
				ncro.setText("00");
				crono.setText("02 :");

				xerox2 = 0;

			}
			if (xerox == 300) {
				ncro.setText("00");
				crono.setText("03 :");

				xerox2 = 0;

			}
			if (xerox == 400) {

				ncro.setText("00");
				crono.setText("04 :");
				xerox2 = 0;
			}
			if (xerox == 500) {

				ncro.setText("00");
				crono.setText("05 :");
				xerox2 = 0;
			}
			if (xerox == 600) {

				ncro.setText("00");
				crono.setText("06 :");
				xerox2 = 0;
			}
			if (xerox == 700) {

				ncro.setText("00");
				crono.setText("07 :");
				xerox2 = 0;
			}
			if (xerox == 800) {

				ncro.setText("00");
				crono.setText("08 :");
				xerox2 = 0;
			}
			if (xerox == 900) {

				ncro.setText("00");
				crono.setText("09 :");
				xerox2 = 0;
			}
			if (xerox == 1000) {

				ncro.setText("00");
				crono.setText("10 :");
				xerox2 = 0;
			}
			if (xerox == 1100) {

				ncro.setText("00");
				crono.setText("11 :");
				xerox2 = 0;
			}
			if (xerox == 1200) {

				ncro.setText("00");
				crono.setText("12 :");
				xerox2 = 0;
			}
			if (xerox == 1300) {

				ncro.setText("00");
				crono.setText("13 :");
				xerox2 = 0;
			}
			if (xerox == 1400) {

				ncro.setText("00");
				crono.setText("14 :");
				xerox2 = 0;
			}
			if (xerox == 1500) {

				ncro.setText("00");
				crono.setText("15 :");
				xerox2 = 0;
			}
			if (xerox == 1600) {

				ncro.setText("00");
				crono.setText("16 :");
				xerox2 = 0;
			}
			if (xerox == 1700) {

				ncro.setText("00");
				crono.setText("17 :");
				xerox2 = 0;
			}
			if (xerox == 1800) {

				ncro.setText("00");
				crono.setText("18 :");
				xerox2 = 0;
			}
			if (xerox == 1900) {

				ncro.setText("00");
				crono.setText("19 :");
				xerox2 = 0;
			}
			if (xerox == 2000) {

				ncro.setText("00");
				crono.setText("20 :");
				xerox2 = 0;
			}
			if (xerox == 2100) {

				ncro.setText("00");
				crono.setText("21 :");
				xerox2 = 0;
			}
			if (xerox == 2200) {

				ncro.setText("00");
				crono.setText("22 :");
				xerox2 = 0;
			}
			if (xerox == 2300) {

				ncro.setText("00");
				crono.setText("23 :");
				xerox2 = 0;
			}
			if (xerox == 2400) {

				ncro.setText("00");
				crono.setText("24 :");
				xerox2 = 0;
			}
			if (xerox == 2500) {

				ncro.setText("00");
				crono.setText("25 :");
				xerox2 = 0;
			}
			if (xerox == 2600) {

				ncro.setText("00");
				crono.setText("26 :");
				xerox2 = 0;
			}
			if (xerox == 2700) {

				ncro.setText("00");
				crono.setText("27 :");
				xerox2 = 0;
			}
			if (xerox == 2800) {

				ncro.setText("00");
				crono.setText("28 :");
				xerox2 = 0;
			}
			if (xerox == 2900) {

				ncro.setText("00");
				crono.setText("29 :");
				xerox2 = 0;
			}
			if (xerox == 3000) {

				ncro.setText("00");
				crono.setText("30 :");
				xerox2 = 0;
			}
			if (xerox == 3100) {

				ncro.setText("00");
				crono.setText("31 :");
				xerox2 = 0;
			}
			if (xerox == 3200) {

				ncro.setText("00");
				crono.setText("32 :");
				xerox2 = 0;
			}
			if (xerox == 3300) {

				ncro.setText("00");
				crono.setText("33 :");
				xerox2 = 0;
			}
			if (xerox == 3400) {

				ncro.setText("00");
				crono.setText("34 :");
				xerox2 = 0;
			}
			if (xerox == 3500) {

				ncro.setText("00");
				crono.setText("35 :");

			}
			if (xerox == 3502) {
	
			//	JOptionPane.showMessageDialog(null,
				//		"Se Termino El Tiempo De La Trivia \n Gracias!");
				frame.dispose();
				xerox = 0;
				time.stop();
				new trivia_off().setVisible(true);

			}
		}
	});
	Object ax = System.getenv("username");
	String usuario = String.valueOf(ax);
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	int bandera = 0;
	int jola = 0;
	JFrame frame;

	// private JTextField usuario;

	String user = "";
	String sec = "";
	String nom = "";
	String carg = "";
	String id_pre = "";
	String pregunta = "";
	String rta_a = "";
	String rta_b = "";
	String rta_c = "";
	String rta_d = "";
	String rta_bd = "";
	JLabel pregunta_txt = new JLabel("No tiene preguntas actualmente");
	JLabel lblNewLabel_2 = new JLabel("C");
	JLabel lblNewLabel_3 = new JLabel("D");
	JCheckBox A = new JCheckBox("");
	JCheckBox B = new JCheckBox("");
	JCheckBox C = new JCheckBox("");
	JCheckBox D = new JCheckBox("");
	JButton Enviar = new JButton("Enviar");
	JLabel Rta = new JLabel("");
	JLabel Rta_2 = new JLabel("");
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	int pre = 0;
	private int limite = 12;
	private final JTextArea txt_pregunta = new JTextArea();
	private final JTextArea txt_A = new JTextArea();
	private final JTextArea txt_B = new JTextArea();
	private final JTextArea txt_C = new JTextArea();
	private final JTextArea txt_D = new JTextArea();
	PanelCurves iniciar = new PanelCurves();
	JLabel lblNewLabel_4 = new JLabel("Bienvenido al nuevo ");
	JLabel jazzquiz = new JLabel("");
	private final JLabel label = new JLabel("New label");
	JPanel panel_ini = new JPanel();
	JLabel jazzquiz_2 = new JLabel("");
	JLabel lblNewLabel = new JLabel("A");
	JLabel lblNewLabel_1 = new JLabel("B");

	JLabel logos = new JLabel("");
	JLabel fondo = new JLabel("");
	private final JLabel trans = new JLabel("Tiempo Transcurrido :");
	private final JLabel lblTienesMinutos = new JLabel(
			"Tienes 35 minutos Para Responder La Trivia.");

	/**
	 * Launch the application.
	 */
	/**
	 * 
	 * 
	 * 
	 * @author kristianEduardo
	 */
	// -----------------------------------------
	// -----------------------------------------
	// -----------------------------------------
	/**
	 * 
	 * @author kristianEduardo
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					index window = new index();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public index() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	// -------------------------------------------aca esta se hace la accion del
	// boton ---------------------------------------------
	// -------------------------------------------aca esta se hace la accion del
	// boton ---------------------------------------------
	// -------------------------------------------aca esta se hace la accion del
	// boton ---------------------------------------------
	@Override
	public Image getIconImage() {
		Image retValue = Toolkit.getDefaultToolkit().getImage(
				ClassLoader.getSystemResource("src/img/jazz1.png"));

		return retValue;
	}

	public void user() {
		con = conexion.ConnectDB();
		String sql = "SELECT * FROM nomina WHERE user_win =? ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			rs = pst.executeQuery();
			if (rs.next()) {
				
					
				
				sec = rs.getString("Sector");
				nom = rs.getString("Personal");
				carg = rs.getString("Cargo");
				user = rs.getString("user_win");
				
			}
			// JOptionPane.showMessageDialog(null, "Bienvenido: " + nom + "\n"

			// + "Tienes 35 Minutos Para Responder La Trivia");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally{
			
		}
	}

	void presionar() {
		con = conexion.ConnectDB();
		
		String sql = "SELECT * FROM nomina WHERE user_win =? ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			rs = pst.executeQuery();
			if (rs.next()) {
				sec = rs.getString("Sector");
				nom = rs.getString("Personal");
				carg = rs.getString("Cargo");
				user = rs.getString("user_win");
				bandera = 1;
				frame.setBounds(250, 250, 414, 445);
				frame.setLocationRelativeTo(null);
				lblNewLabel_4.setVisible(false);
				jazzquiz.setVisible(false);
				iniciar.setVisible(true);
				// aca inicia la carga de las preguntas
				// aca inicia la carga de las preguntas
				// aca inicia la carga de las preguntas

				if (bandera == 1) {

					logos.setVisible(false);
					panel_ini.setOpaque(false);
					panel_2.setOpaque(false);
					// color.setVisible(true);
					frame.setBounds(250, 250, 640, 565);
					frame.setLocationRelativeTo(null);
					iniciar.setVisible(false);
					panel_ini.setVisible(true);
					jazzquiz_2.setVisible(true);
					jazzquiz_2.setBounds(15, 11, 167, 51);
					panel_1.setVisible(false);
					panel_2.setVisible(true);
					con = conexion.ConnectDB();
					label.setVisible(false);
					fondo.setVisible(true);

					sql = "SELECT * FROM preguntas  WHERE Id_pregunta NOT IN (SELECT Id_pregunta FROM respuestas WHERE User_win='"
							+ user
							+ "')AND Sector='"
							+ sec
							+ "' ORDER BY RAND() LIMIT 1 ";

					try { // llave1
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						if (rs.next()) {

							trans.setVisible(true);
							crono.setVisible(true);
							ncro.setVisible(true);
							time.start();
							index.this.pregunta = rs.getString("pregunta");
							id_pre = rs.getString("Id_pregunta");
							rta_a = rs.getString("rta_a");
							rta_b = rs.getString("rta_b");
							rta_c = rs.getString("rta_c");
							rta_d = rs.getString("rta_d");
							rta_bd = rs.getString("rta_correcta");
							if ((rta_a.equals("Verdadero"))
									|| (rta_a.equals("VERDADERO"))
									|| (rta_a.equals("verdadero"))
									|| (rta_a.equals("falso"))
									|| (rta_a.equals("Falso"))
									|| (rta_a.equals("FALSO"))
									|| (rta_a.equals("SI"))
									|| (rta_a.equals("Si"))
									|| (rta_a.equals("Sí"))
									|| (rta_a.equals("si"))
									|| (rta_a.equals("sí"))
									|| (rta_a.equals("No"))
									|| (rta_a.equals("NO"))
									|| (rta_a.equals("no"))

							) {
								txt_A.setFont(new Font("Calibri", Font.PLAIN,
										16));
								txt_B.setFont(new Font("Calibri", Font.PLAIN,
										16));
								frame.setBounds(440, 200, 490, 364);
								panel_ini.setBounds(0, 0, 490, 71);
								panel_2.setBounds(0, 64, 490, 300);
								// /coordenadas cosos
								// color.setBounds(9, 6, 473, 70);
								C.setVisible(false);
								D.setVisible(false);
								lblNewLabel.setBounds(180, 142, 18, 14);

								lblNewLabel_1.setBounds(180, 182, 18, 14);
								txt_pregunta.setBounds(23, 12, 440, 150);
								txt_A.setBounds(230, 142, 535, 70);
								txt_B.setBounds(230, 182, 535, 70);
								A.setBounds(200, 142, 22, 16);
								B.setBounds(200, 182, 22, 16);
								jazzquiz_2.setBounds(15, 11, 167, 51);
								txt_C.setVisible(false);
								txt_D.setVisible(false);
								lblNewLabel_3.setVisible(false);
								lblNewLabel_2.setVisible(false);

								Enviar.setBounds(210, 232, 84, 25);

							}
							if (rta_d.equals("")) {

								frame.setBounds(250, 250, 640, 464);
								frame.setLocationRelativeTo(null);
								panel_2.setBounds(0, 64, 640, 400);
								D.setVisible(false);
								txt_D.setVisible(false);
								lblNewLabel_3.setVisible(false);
								Enviar.setBounds(290, 350, 84, 25);

							}
							txt_pregunta.setText(index.this.pregunta);

							if (txt_pregunta.getText().length() <= 100) {
								txt_pregunta.setFont(new Font("Calibri",
										Font.BOLD, 17));

							} else if (txt_pregunta.getText().length() > 100) {
								txt_pregunta.setFont(new Font("Calibri",
										Font.BOLD, 14));

							}
							pregunta_txt.setText(index.this.pregunta);
							txt_A.setText(rta_a);
							txt_B.setText(rta_b);
							txt_C.setText(rta_c);
							txt_D.setText(rta_d);
							Rta_2.setText(rta_bd);
							pre = Integer.parseInt(id_pre);

						}
					}// llave1
					
					catch (Exception ex) {
					
						JOptionPane.showMessageDialog(null,
								"Error para obtener su pregunta por favor cierre el aplicativo"
										+ "\n" + ex);
						ex.printStackTrace();
					}
finally{
						
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Tu Usuario :"+" "+usuario+"\n"+" Actualmente No Puede Contestar Ninguna Trivia.",
						null, JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				bandera = 3;
		
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en: " + e);
			e.printStackTrace();
		}finally{
			
		}
		if ((pregunta_txt.getText() == "No tiene preguntas actualmente")
				&& !(bandera == 3)) {

			A.setVisible(false);
			B.setVisible(false);
			C.setVisible(false);
			D.setVisible(false);
			Enviar.setVisible(false);

			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			JOptionPane.showMessageDialog(null,
					"No tienes preguntas actualmente" + "\n"
							+ "da clic en aceptar para cerrar el Jazzquiz");
			frame.dispose();
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @author kristianEduardo
	 */
	// -----------------------------------------
	// -----------------------------------------
	// -----------------------------------------
	/**
	 * 
	 * @author kristianEduardo
	 */
	Timer temp = new Timer(600, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			flox++;

			if (flox >= 20) {
				presionar();
				temp.stop();

			}

		}
	});

	private void initialize() {
		user();
		
		temp.start();

		frame = new JFrame("JazzQuiz");
		// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
		// index.class.getResource("src/img/logo_frame.png")));
		Image icono = Toolkit.getDefaultToolkit().getImage(
				"src/img/logo_frame.png");

		frame.setIconImage(icono);

		frame.setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.setBounds(250, 250, 490, 165);
		// panel_ini.setBounds(0, 0, 490, 69);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		jazzquiz_2.setVisible(false);

		iniciar.setBorder(new MatteBorder(8, 9, 0, 8, (Color) Color.BLACK));
		iniciar.setBounds(0, 0, 490, 69);
		frame.getContentPane().add(iniciar);
		iniciar.setLayout(null);
		lblNewLabel_4.setBounds(23, 22, 258, 27);
		lblNewLabel_4.setForeground(Color.BLACK);

		lblNewLabel_4.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 24));
		iniciar.add(lblNewLabel_4);
		jazzquiz.setBounds(274, 11, 167, 51);

		jazzquiz.setIcon(new ImageIcon("src/img/jazz1.png"));
		iniciar.add(jazzquiz);
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(0, 9, 8, 8, (Color) Color.BLACK));
		panel_1.setBounds(0, 64, 490, 101);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JLabel lblUsuario = new JLabel("" + nom);
		lblUsuario.setBounds(30, 24, 450, 19);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(lblUsuario);
		lblTienesMinutos.setForeground(Color.BLACK);
		lblTienesMinutos
				.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblTienesMinutos.setBounds(30, 54, 406, 19);

		panel_1.add(lblTienesMinutos);
		pregunta_txt.setBounds(23, 313, 46, 14);
		// usuario.setTransferHandler(null);
		pregunta_txt.setVisible(false);
		Rta_2.setBounds(97, 313, 46, 14);
		Rta_2.setVisible(false);
		Rta.setBounds(311, 235, 26, 14);
		Rta.setVisible(false);
		txt_A.setBounds(73, 107, 535, 70);
		txt_A.setForeground(Color.BLACK);
		txt_A.setEditable(false);
		txt_A.setFont(new Font("Calibri", Font.PLAIN, 14));
		txt_A.setLineWrap(true);
		txt_A.setWrapStyleWord(true);
		txt_A.setOpaque(false);
		panel_2.setBounds(0, 64, 640, 502);
		frame.getContentPane().add(panel_2);
		panel_2.setBackground(new Color(255, 250, 250));
		panel_2.setBorder(new MatteBorder(0, 9, 8, 8, (Color) Color.BLACK));
		panel_2.setVisible(false);
		panel_2.setLayout(null);
		panel_2.add(Rta);
		A.setBounds(47, 105, 22, 16);
		A.setOpaque(false);
		B.setBounds(47, 196, 22, 16);
		B.setOpaque(false);
		C.setBounds(47, 290, 22, 16);
		C.setOpaque(false);
		D.setBounds(47, 376, 22, 16);
		D.setOpaque(false);

		
		A.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (A.isSelected()) {
					B.setSelected(false);
					C.setSelected(false);
					D.setSelected(false);
					Rta.setText("A");
				} else {

					Rta.setText("");
				}
			}
		});
		panel_2.add(A);
		B.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (B.isSelected()) {
					D.setSelected(false);
					C.setSelected(false);
					A.setSelected(false);
					Rta.setText("B");
				} else {

					Rta.setText("");
				}
			}
		});
		panel_2.add(B);
		C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (C.isSelected()) {
					B.setSelected(false);
					D.setSelected(false);
					A.setSelected(false);
					Rta.setText("C");
				} else {

					Rta.setText("");
				}
			}
		});
		panel_2.add(C);
		D.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (D.isSelected()) {
					B.setSelected(false);
					C.setSelected(false);
					A.setSelected(false);
					Rta.setText("D");
				} else {
					Rta.setText("");
				}
			}
		});
		panel_2.add(D);
		Enviar.setBounds(280, 457, 84, 25);
		Enviar.setForeground(Color.BLACK);
		Enviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(Enviar);
		lblNewLabel.setBounds(23, 105, 18, 14);

		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		panel_2.add(lblNewLabel);
		lblNewLabel_1.setBounds(23, 192, 18, 14);

		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		panel_2.add(lblNewLabel_1);
		lblNewLabel_2.setBounds(23, 290, 18, 14);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		panel_2.add(lblNewLabel_2);
		lblNewLabel_3.setBounds(23, 376, 18, 14);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		panel_2.add(lblNewLabel_3);
		txt_pregunta.setBounds(23, 16, 585, 70);
		txt_pregunta.setForeground(Color.BLACK);
		panel_2.add(txt_pregunta);
		txt_pregunta.setEditable(false);
		txt_pregunta.setFont(new Font("Calibri", Font.BOLD, 14));
		txt_pregunta.setLineWrap(true);
		txt_pregunta.setWrapStyleWord(true);
		txt_pregunta.setOpaque(false);
		txt_pregunta.setText("No tiene preguntas actualmente");
		panel_2.add(txt_A);
		txt_B.setBounds(73, 198, 535, 70);
		txt_B.setForeground(Color.BLACK);
		txt_B.setWrapStyleWord(true);
		txt_B.setOpaque(false);
		txt_B.setLineWrap(true);
		txt_B.setFont(new Font("Calibri", Font.PLAIN, 14));
		txt_B.setEditable(false);

		panel_2.add(txt_B);
		txt_C.setBounds(73, 290, 535, 70);
		txt_C.setForeground(Color.BLACK);
		txt_C.setWrapStyleWord(true);
		txt_C.setOpaque(false);
		txt_C.setLineWrap(true);
		txt_C.setFont(new Font("Calibri", Font.PLAIN, 14));
		txt_C.setEditable(false);
		panel_2.add(txt_C);
		txt_D.setBounds(73, 376, 535, 70);
		txt_D.setBackground(Color.WHITE);
		txt_D.setForeground(Color.BLACK);
		txt_D.setWrapStyleWord(true);
		txt_D.setOpaque(false);
		txt_D.setLineWrap(true);
		txt_D.setFont(new Font("Calibri", Font.PLAIN, 14));
		txt_D.setEditable(false);
		panel_2.add(txt_D);
		panel_2.add(Rta_2);
		panel_2.add(pregunta_txt);
		panel_ini.setBackground(new Color(245, 245, 245));

		panel_ini.setBorder(new MatteBorder(8, 9, 0, 8, (Color) Color.BLACK));
		panel_ini.setLayout(null);
		panel_ini.setBounds(0, 0, 640, 71);
		frame.getContentPane().add(panel_ini);
		panel_ini.setOpaque(false);

		jazzquiz_2.setBounds(250, 11, 167, 51);
		jazzquiz_2.setIcon(new ImageIcon("src/img/jazz1.png"));
		panel_ini.add(jazzquiz_2);

		logos.setBounds(250, 6, 200, 55);
		logos.setVisible(false);
		panel_ini.add(logos);
		crono.setVisible(false);
		crono.setFont(new Font("Tahoma", Font.BOLD, 16));
		crono.setBounds(301, 40, 44, 22);

		panel_ini.add(crono);
		ncro.setVisible(false);
		ncro.setBounds(337, 40, 51, 22);
		panel_ini.add(ncro);
		ncro.setFont(new Font("Tahoma", Font.BOLD, 16));
		trans.setVisible(false);
		trans.setFont(new Font("Tahoma", Font.BOLD, 12));
		trans.setBounds(263, 6, 154, 42);

		panel_ini.add(trans);
		label.setBounds(0, 0, 640, 566);
		frame.getContentPane().add(label);
		label.setIcon(new ImageIcon("src/img/prueba_9_final.jpg"));
		fondo.setIcon(new ImageIcon("src/img/prueba_9_final.jpg"));
		fondo.setBounds(0, 0, 640, 566);

		frame.getContentPane().add(fondo);

		// aca esta el boton enviar//aca esta el boton enviar//aca esta el boton
		// enviar//aca esta el boton enviar
		// aca esta el boton enviar//aca esta el boton enviar//aca esta el boton
		// enviar//aca esta el boton enviar
		// aca esta el boton enviar//aca esta el boton enviar//aca esta el boton
		// enviar//aca esta el boton enviar

		
		
		
		
		
		Enviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (Rta.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"No seleccionaste ninguna opción", "",
							JOptionPane.ERROR_MESSAGE);
				} else if ((Rta_2.getText()).equals(Rta.getText())) {
					  contenedor=new JPanel();
                    
					 imagen=new ImageIcon("src/img/chulo.png");

					 
					  contenedor.add(new JLabel(imagen));


					  JOptionPane.showMessageDialog(null,contenedor,"Respuesta Correcta",JOptionPane.INFORMATION_MESSAGE,null);
			        
					//JOptionPane.showMessageDialog(null, "    Respuesta Correcta ",new ImageIcon(""));

					jola = 1;
					time.stop();
				try {
					con.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				} else if ((Rta_2.getText()) != (Rta.getText())) {
					  contenedor=new JPanel();
                      
					 imagen=new ImageIcon("src/img/error.png");

					 
					  contenedor.add(new JLabel(imagen));


					  JOptionPane.showMessageDialog(null,contenedor," Respuesta Incorrecta",JOptionPane.INFORMATION_MESSAGE,null);


//ow.ly/KNICZJOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Titulo", JOptionPane.DEFAULT_OPTION, icon);
					//JOptionPane.showMessageDialog(null, "    Respuesta Incorrecta ");
					jola = 2;
					time.stop();
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if (Rta.getText() == "") {
				} else {
					con = conexion.ConnectDB();
					String sql = "INSERT into respuestas(Sector,Cargo,Personal,User_Win,Rta_user,Id_pregunta,Evaluacion) VALUES (?,?,?,?,?,?,?)";
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, sec);
						pst.setString(2, carg);
						pst.setString(3, nom);
						pst.setString(4, user);
						pst.setString(5, Rta.getText());
						pst.setString(6, id_pre);
						pst.setString(7, " ");
						if (jola == 1) {
							pst.setString(7, "Aprobado");
						
						} else if (jola == 2) {
							pst.setString(7, "No Aprobado");
						
						}
						int n = pst.executeUpdate();
						if (n > 0) {
							// JOptionPane.showMessageDialog(null,"Respuesta Enviada");
							frame.dispose();
						}
					} catch (SQLException exe) {
						JOptionPane.showMessageDialog(null, "Error en exe"
								+ exe);
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						exe.printStackTrace();
					} catch (HeadlessException hd) {
						JOptionPane.showConfirmDialog(null, "Error en hd" + hd);
						hd.printStackTrace();
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}finally{
						
					}
					
					
				}
			}
		});

	}

	// aca se cierra el init components
}
/**
 * 
 * @author kristianEduardo
 */
// -----------------------------------------
// -----------------------------------------
// -----------------------------------------
/**
 * 
 * @author kristianEduardo
 */
