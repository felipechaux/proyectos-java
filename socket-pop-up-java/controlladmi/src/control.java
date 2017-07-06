import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

import org.edisoncor.gui.panel.PanelCurves;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import java.awt.Color;


public class control extends JFrame {
	private static final Component Pane = null;
	JComboBox minutos, ss, horas;
	private JPanel contentPane;

	JTextField orden;
	private JTextField ip;
	int band = 0;
	int band2 = 0;
	int band3 = 0;
	int band4 = 0;
	int band5 = 0;
	int band6 = 0;
	int band7 = 0;
	int band8 = 0;
	int band9 = 0;
	int band10 = 0;
	int band11 = 0;
	int band12 = 0;
	int band13 = 0;
	int band14 = 0;
	int band15 = 0;
	int band16 = 0;
	int band17 = 0;
	int band18 = 0;
	int band19 = 0;
	int band20 = 0;
	int band21 = 0;
	int band22 = 0;
	int band23 = 0;
	int band24 = 0;
	int band25 = 0;
	int band26 = 0;
	int band27 = 0;
	int band28 = 0;
	int band29 = 0;
	int band30 = 0;
	int band31 = 0;
	int band32 = 0;
	int band33 = 0;
	int band34 = 0;
	int band35 = 0;
	int band36 = 0;

	int cont1 = 0;
	int cont2 = 0;
	int contt3 = 0;
	int cont4 = 0;
	int cont5 = 0;
	int cont6 = 0;
	int cont7 = 0;
	int cont8 = 0;
	int cont9 = 0;
	int cont10 = 0;
	int cont11 = 0;
	int cont12 = 0;
	int cont13 = 0;
	int cont14 = 0;
	int cont15 = 0;
	int cont16 = 0;
	int cont17 = 0;
	int cont18 = 0;
	int cont19 = 0;
	int cont20 = 0;
	int cont21 = 0;
	int cont22 = 0;
	int cont23 = 0;
	int cont24 = 0;
	int cont25 = 0;
	int cont26 = 0;
	int cont27 = 0;
	int cont28 = 0;
	int cont29 = 0;
	int cont30 = 0;
	int cont31 = 0;
	int cont32 = 0;
	int cont33 = 0;
	int cont34 = 0;
	int cont35 = 0;
	int cont36 = 0;
	int env1 = 0;
	int env2 = 0;
	int env3 = 0;
	int env4 = 0;
	int env5 = 0;
	int env6 = 0;
	int env7 = 0;

	int rp1 = 0;
	int rp2 = 0;
	int rp3 = 0;
	int rp4 = 0;
	int rp5 = 0;
	int rp6 = 0;
	int rp7 = 0;
	Object hor1, hor2, hor3, hor4, hors, hors_f;
	String ho1, ho2, hos, ho3, ho4, hos_f;
	String co1 = "";
	String co2 = "";
	String co3 = "";
	int contadorx = 0;

	JTextArea area;

	String ips[];
	int contip;
	int contarrip;
	int cont3;
	JScrollPane scrollPane;
	String almaip;
	String normal = "";
	boolean bucl = true;
	int contador = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					control frame = new control();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reportex() {
		try {
			Socket cli = new Socket("", 0407);
			DataOutputStream flujo = new DataOutputStream(cli.getOutputStream());
			flujo.writeUTF(area.getText());
			cli.close();
		} catch (Exception e) {
			System.out.println("Error en Cliente" + e.getMessage());
			// TODO: handle exception

		}
	}

	public void tri() {
		orden.setText("trivia");
	}

	public void tan1() {
		ips[contarrip] = "172.16.232." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void tan2() {
		ips[contarrip] = "172.16.233." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void tan3() {
		ips[contarrip] = "172.16.234." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void tan4() {
		ips[contarrip] = "172.16.235." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void tan5() {
		ips[contarrip] = "172.16.236." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void tan6() {
		ips[contarrip] = "172.16.237." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void tan7() {
		ips[contarrip] = "172.16.238." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void tan8() {
		ips[contarrip] = "172.16.58." + contip;
		almaip = ips[contarrip];
		// normal+="\n 172.16.233." + contip;
		area.append("\n Enviando a ip :" + almaip + ".......");
	}

	public void socket() {
		tri();
		try {
			Socket cli = new Socket(almaip, 6667);

			orden binario = new orden();

			binario.setOrdenn(orden.getText());

			ObjectOutputStream flujo = new ObjectOutputStream(
					cli.getOutputStream());
			flujo.writeObject(binario);
			// System.out.println("enviando trivias----ip --1 ");
			area.append("\n Trivia Enviada Exitosamente a :"
					+ cli.getInetAddress() + " : ");

			// tiempo.start();
			cli.close();
		} catch (Exception e) {
			area.append("Error..");
			// TODO: handle exception

		}

	}

	public void global37() {
		ips = new String[258];
		contip = 200;
		contarrip = 200;
		cont3 = 200;

		for (; contarrip < 254; contarrip++) {

			for (; cont3 < 254; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 254; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;
						// JOptionPane.showMessageDialog(null,
						// "contip"+contip+"/n"+"cont3"+cont3);
						if (contip == cont3) {
							tan8();
							socket();
						}

						if ((contip == 254) && (cont3 == 254)) {
							area.append("\n Tanda 37 Enviada");
							area.append("\n Envio de tandas Completado.");
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global36() {
		ips = new String[258];
		contip = 150;
		contarrip = 150;
		cont3 = 150;

		for (; contarrip < 200; contarrip++) {

			for (; cont3 < 200; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 200; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan8();
							socket();
						}

						if ((contip == 200) && (cont3 == 200)) {
							area.append("\n Tanda 36 Enviada");
							area.append("\n Enviando Tanda 37....");
							cont36 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global35() {
		ips = new String[258];
		contip = 100;
		contarrip = 100;
		cont3 = 100;

		for (; contarrip < 150; contarrip++) {

			for (; cont3 < 150; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 150; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan8();
							socket();
						}

						if ((contip == 150) && (cont3 == 150)) {
							area.append("\n Tanda 35 Enviada");
							area.append("\n Enviando Tanda 36....");
							cont35 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global34() {
		ips = new String[258];
		contip = 50;
		contarrip = 50;
		cont3 = 50;

		for (; contarrip < 100; contarrip++) {

			for (; cont3 < 100; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 100; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan8();
							socket();
						}

						if ((contip == 100) && (cont3 == 100)) {
							area.append("\n Tanda 34 Enviada");
							area.append("\n Enviando Tanda 35....");
							cont34 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global33() {
		ips = new String[258];
		contip = 0;
		contarrip = 0;
		cont3 = 0;

		for (; contarrip < 50; contarrip++) {

			for (; cont3 < 50; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 50; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan8();
							socket();
						}

						if ((contip == 50) && (cont3 == 50)) {
							area.append("\n Tanda 33 Enviada");
							area.append("\n Enviando Tanda 34....");
							cont33 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global32() {
		ips = new String[258];
		contip = 200;
		contarrip = 200;
		cont3 = 200;

		for (; contarrip < 254; contarrip++) {

			for (; cont3 < 254; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 254; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan7();
							socket();
						}

						if ((contip == 254) && (cont3 == 254)) {
							area.append("\n Tanda 32 Enviada");
							area.append("\n Enviando Tanda 33....");
							cont32 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global31() {
		area.append("\n Tanda 31 Enviada....");

		ips = new String[258];
		contip = 150;
		contarrip = 150;
		cont3 = 150;

		for (; contarrip < 200; contarrip++) {

			for (; cont3 < 200; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 200; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan7();
							socket();

						}

						if ((contip == 200) && (cont3 == 200)) {
							area.append("\n Tanda 31 Enviada");
							area.append("\n Enviando Tanda 32....");
							cont31 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global30() {
		ips = new String[258];
		contip = 100;
		contarrip = 100;
		cont3 = 100;

		for (; contarrip < 150; contarrip++) {

			for (; cont3 < 150; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 150; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan7();
							socket();

						}

						if ((contip == 150) && (cont3 == 150)) {
							area.append("\n Tanda 30 Enviada");
							area.append("\n Enviando Tanda 31....");
							cont30 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global29() {
		ips = new String[258];
		contip = 50;
		contarrip = 50;
		cont3 = 50;

		for (; contarrip < 100; contarrip++) {

			for (; cont3 < 100; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 100; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan7();
							socket();

						}

						if ((contip == 100) && (cont3 == 100)) {
							area.append("\n Tanda 29 Enviada");
							area.append("\n Enviando Tanda 30....");
							cont29 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global28() {
		ips = new String[258];
		contip = 0;
		contarrip = 0;
		cont3 = 0;

		for (; contarrip < 50; contarrip++) {

			for (; cont3 < 50; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 50; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan7();
							socket();

						}

						if ((contip == 50) && (cont3 == 50)) {
							area.append("\n Tanda 28 Enviada");
							area.append("\n Enviando Tanda 29....");
							cont28 = 1;
							reportex();
							break;
						}

					}
				}

			}
		}
	}

	public void global27() {
		ips = new String[258];
		contip = 200;
		contarrip = 200;
		cont3 = 200;

		for (; contarrip < 254; contarrip++) {

			for (; cont3 < 254; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 254; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan6();
							socket();
							reportex();

						}

						if ((contip == 254) && (cont3 == 254)) {
							area.append("\n Tanda 27 Enviada");
							area.append("\n Enviando Tanda 28....");
							cont27 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global26() {
		ips = new String[258];
		contip = 150;
		contarrip = 150;
		cont3 = 150;

		for (; contarrip < 200; contarrip++) {

			for (; cont3 < 200; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 200; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan6();
							socket();

						}

						if ((contip == 200) && (cont3 == 200)) {
							area.append("\n Tanda 26 Enviada");
							area.append("\n Enviando Tanda 27....");
							cont26 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global25() {
		ips = new String[258];
		contip = 100;
		contarrip = 100;
		cont3 = 100;

		for (; contarrip < 150; contarrip++) {

			for (; cont3 < 150; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 150; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan6();
							socket();

						}

						if ((contip == 150) && (cont3 == 150)) {
							area.append("\n Tanda 25 Enviada");
							area.append("\n Enviando Tanda 26....");
							cont25 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global24() {
		ips = new String[258];
		contip = 50;
		contarrip = 50;
		cont3 = 50;

		for (; contarrip < 100; contarrip++) {

			for (; cont3 < 100; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 100; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan6();
							socket();

						}

						if ((contip == 100) && (cont3 == 100)) {
							area.append("\n Tanda 24 Enviada");
							area.append("\n Enviando Tanda 25....");
							cont24 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global23() {
		ips = new String[258];
		contip = 0;
		contarrip = 0;
		cont3 = 0;

		for (; contarrip < 50; contarrip++) {

			for (; cont3 < 50; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 50; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan6();
							socket();

						}

						if ((contip == 50) && (cont3 == 50)) {
							area.append("\n Tanda 23 Enviada");
							area.append("\n Enviando Tanda 24....");
							cont23 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global22() {
		ips = new String[258];
		contip = 200;
		contarrip = 200;
		cont3 = 200;

		for (; contarrip < 254; contarrip++) {

			for (; cont3 < 254; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 254; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan5();
							socket();

						}

						if ((contip == 254) && (cont3 == 254)) {
							area.append("\n Tanda 22 Enviada");
							area.append("\n Enviando Tanda 23....");
							cont22 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global21() {
		ips = new String[258];
		contip = 150;
		contarrip = 150;
		cont3 = 150;

		for (; contarrip < 200; contarrip++) {

			for (; cont3 < 200; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 200; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan5();
							socket();

						}

						if ((contip == 200) && (cont3 == 200)) {
							area.append("\n Tanda 21 Enviada");
							area.append("\n Enviando Tanda 22....");
							cont21 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global20() {
		ips = new String[258];
		contip = 100;
		contarrip = 100;
		cont3 = 100;

		for (; contarrip < 150; contarrip++) {

			for (; cont3 < 150; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 150; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan5();
							socket();

						}

						if ((contip == 150) && (cont3 == 150)) {
							area.append("\n Tanda 20 Enviada");
							area.append("\n Enviando Tanda 21....");
							cont20 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global19() {
		ips = new String[258];
		contip = 50;
		contarrip = 50;
		cont3 = 50;

		for (; contarrip < 100; contarrip++) {

			for (; cont3 < 100; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 100; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan5();
							socket();

						}

						if ((contip == 100) && (cont3 == 100)) {
							area.append("\n Tanda 19 Enviada");
							area.append("\n Enviando Tanda 20....");
							cont19 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global18() {

		ips = new String[258];
		contip = 0;
		contarrip = 0;
		cont3 = 0;

		for (; contarrip < 50; contarrip++) {

			for (; cont3 < 50; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 50; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan5();
							socket();

						}

						if ((contip == 50) && (cont3 == 50)) {
							area.append("\n Tanda 18 Enviada");
							area.append("\n Enviando Tanda 19....");
							cont18 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global17() {
		ips = new String[258];
		contip = 200;
		contarrip = 200;
		cont3 = 200;

		for (; contarrip < 254; contarrip++) {

			for (; cont3 < 254; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 254; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan4();
							socket();

						}

						if ((contip == 254) && (cont3 == 254)) {
							area.append("\n Tanda 17 Enviada");
							area.append("\n Enviando Tanda 18....");
							cont17 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global16() {
		ips = new String[258];
		contip = 150;
		contarrip = 150;
		cont3 = 150;
		for (; contarrip < 200; contarrip++) {

			for (; cont3 < 200; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 200; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan4();
							socket();

						}

						if ((contip == 200) && (cont3 == 200)) {
							area.append("\n Tanda 16 Enviada");
							area.append("\n Enviando Tanda 17....");
							cont16 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global15() {
		ips = new String[258];
		contip = 100;
		contarrip = 100;
		cont3 = 100;

		for (; contarrip < 150; contarrip++) {

			for (; cont3 < 150; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 150; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan4();
							socket();

						}

						if ((contip == 150) && (cont3 == 150)) {
							area.append("\n Tanda 15 Enviada");
							area.append("\n Enviando Tanda 16....");
							cont15 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global14() {
		ips = new String[258];
		contip = 50;
		contarrip = 50;
		cont3 = 50;

		for (; contarrip < 100; contarrip++) {

			for (; cont3 < 100; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 100; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan4();
							socket();

						}

						if ((contip == 100) && (cont3 == 100)) {
							area.append("\n Tanda 14 Enviada");
							area.append("\n Enviando Tanda 15....");
							cont14 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global13() {
		ips = new String[258];
		contip = 0;
		contarrip = 0;
		cont3 = 0;

		for (; contarrip < 50; contarrip++) {

			for (; cont3 < 50; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 50; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan4();
							socket();

						}

						if ((contip == 50) && (cont3 == 50)) {
							area.append("\n Tanda 13 Enviada");
							area.append("\n Enviando Tanda 14....");
							cont13 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global12() {
		ips = new String[258];
		contip = 200;
		contarrip = 200;
		cont3 = 200;

		for (; contarrip < 254; contarrip++) {

			for (; cont3 < 254; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 254; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan3();
							socket();

						}

						if ((contip == 254) && (cont3 == 254)) {
							area.append("\n Tanda 12 Enviada");
							area.append("\n Enviando Tanda 13....");
							cont12 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global11() {

		ips = new String[258];
		contip = 150;
		contarrip = 150;
		cont3 = 150;

		for (; contarrip < 200; contarrip++) {

			for (; cont3 < 200; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 200; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan3();
							socket();

						}

						if ((contip == 200) && (cont3 == 200)) {
							area.append("\n Tanda 11 Enviada");
							area.append("\n Enviando Tanda 12....");
							cont11 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global10() {

		ips = new String[258];
		contip = 100;
		contarrip = 100;
		cont3 = 100;

		for (; contarrip < 150; contarrip++) {

			for (; cont3 < 150; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 150; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan3();
							socket();

						}

						if ((contip == 150) && (cont3 == 150)) {
							area.append("\n Tanda 10 Enviada");
							area.append("\n Enviando Tanda 11....");
							cont10 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global9() {

		ips = new String[258];
		contip = 50;
		contarrip = 50;
		cont3 = 50;

		for (; contarrip < 100; contarrip++) {

			for (; cont3 < 100; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 100; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan3();
							socket();

						}

						if ((contip == 100) && (cont3 == 100)) {
							area.append("\n Tanda 9 Enviada");
							area.append("\n Enviando Tanda 10....");
							cont9 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global8() {

		ips = new String[258];
		contip = 0;
		contarrip = 0;
		cont3 = 0;

		for (; contarrip < 50; contarrip++) {

			for (; cont3 < 50; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 50; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan3();
							socket();

						}

						if ((contip == 50) && (cont3 == 50)) {
							area.append("\n Tanda 8 Enviada");
							area.append("\n Enviando Tanda 9....");
							cont8 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global7() {

		ips = new String[258];
		contip = 200;
		contarrip = 200;
		cont3 = 200;

		for (; contarrip < 254; contarrip++) {

			for (; cont3 < 254; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 254; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan2();
							socket();

						}

						if ((contip == 254) && (cont3 == 254)) {
							area.append("\n Tanda 7 Enviada");
							area.append("\n Enviando Tanda 8....");
							cont7 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global6() {

		ips = new String[258];
		contip = 150;
		contarrip = 150;
		cont3 = 150;

		for (; contarrip < 200; contarrip++) {

			for (; cont3 < 200; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 200; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan2();
							socket();

						}

						if ((contip == 200) && (cont3 == 200)) {
							area.append("\n Tanda 6 Enviada");
							area.append("\n Enviando Tanda 7....");
							cont6 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global5() {

		ips = new String[258];
		contip = 100;
		contarrip = 100;
		cont3 = 100;

		for (; contarrip < 150; contarrip++) {

			for (; cont3 < 150; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 150; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan2();
							socket();

						}

						if ((contip == 150) && (cont3 == 150)) {
							area.append("\n Tanda 5 Enviada");
							area.append("\n Enviando Tanda 6....");
							cont5 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}

	}

	public void global4() {
		ips = new String[258];
		contip = 50;
		contarrip = 50;
		cont3 = 50;

		for (; contarrip < 100; contarrip++) {

			for (; cont3 < 100; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 100; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan2();
							socket();

						}

						if ((contip == 100) && (cont3 == 100)) {
							area.append("\n Tanda 4 Enviada");
							area.append("\n Enviando Tanda 5....");
							cont4 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global3() {
		ips = new String[258];
		contip = 0;
		contarrip = 0;
		cont3 = 0;

		for (; contarrip < 50; contarrip++) {

			for (; cont3 < 50; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 50; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan2();
							socket();

						}

						if ((contip == 50) && (cont3 == 50)) {
							area.append("\n Tanda 3 Enviada");
							// area.append("\n Enviando Tanda 4....");
							area.append("\n Enviando Tanda 4....");
							// area.append("\n Se Enviaran las Tandas nuevamente en un Minuto...");
							contt3 = 1;
							reportex();
							break;
						}
					}

				}
			}
		}
	}

	public void global2() {

		ips = new String[258];
		contip = 192;
		contarrip = 192;
		cont3 = 192;

		for (; contarrip < 251; contarrip++) {

			for (; cont3 < 251; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 251; contip++) {
					contarrip++;

					while (true) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan1();
							socket();

						}

						if ((contip == 251) && (cont3 == 251)) {
							area.append("\n Tanda 2 Enviada");
							area.append("\n Enviando Tanda 3....");

							cont2 = 1;
							reportex();
							break;
						}

					}

				}
			}
		}

	}

	public void global1() {

		ips = new String[258];
		contip = 128;
		contarrip = 128;
		cont3 = 128;

		for (; contarrip < 186; contarrip++) {

			for (; cont3 < 186; cont3++) {

				// normal += "\n 172.16.233." + contip;

				for (; contip < 186; contip++) {
					contarrip++;

					while (bucl) {
						contip++;
						cont3++;

						if (contip == cont3) {
							tan1();
							socket();

						}

						if ((contip == 186) && (cont3 == 186)) {
							area.append("\n Tanda 1 Enviada");
							area.append("\n Enviando Tanda 2....");
							cont1 = 1;
							reportex();
							break;

						}

					}

				}
			}
		}

	}

	public void encerrar() {
		hor1 = horas.getSelectedIndex();
		ho1 = String.valueOf(hor1);
		hor2 = minutos.getSelectedIndex();
		ho2 = String.valueOf(hor2);

		hors = ss.getSelectedIndex();
		hos = String.valueOf(hors);

	}

	// ///////////3600 /////35 min///// 3500

	// Timer repeatx=new Timer (600, new ActionListener() {

	// @Override
	// public void actionPerformed(ActionEvent arg0) {

	// if (cont2 == 1) {
	// rp2++;
	//
	// if (rp2 >= 3) {
	// area.append("\n reenviando....");
	// if(rp2>=4){
	// global1();
	// rp2=0;
	// repeatx.stop();
	// }
	// / while(true){
	// JOptionPane.showMessageDialog(null, "hola");
	// }
	// }
	// }

	// }
	// });

/**	Timer repeat = new Timer(600, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			rp1++;

			if (rp1 >= 3) {
				area.append("\n Incializando envio Programado en 1 minuto");

			}
			if (rp1 >= 1000) {
				area.append("\n Incializando envio Programado..");
				if (rp1 >= 3501) {
					global1();
					rp1 = 0;
					repeat.stop();
					// / while(true){
					// JOptionPane.showMessageDialog(null, "hola");
					// }
				}
			}

		}
	});*/

	// hilo.start();
	// JOptionPane.showMessageDialog(null, "mensaje segundo plano");

	// / while(true){
	// JOptionPane.showMessageDialog(null, "hola");

	/**Timer tm1 = new Timer(200, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (cont1 == 1) {
				band++;
				if (band >= 3) {

					global2();

					band = 0;
					cont1 = 0;
				}
			}

			if (cont2 == 1) {
				band2++;

				if (band2 >= 3) {

					global3();

					band2 = 0;
					cont2 = 0;

				}
			}
			if (contt3 == 1) {
				band3++;

				if (band3 >= 3) {

					global4();

					band3 = 0;
					contt3 = 0;

				}
			}
			if (cont4 == 1) {
				band4++;

				if (band4 >= 3) {

					global5();

					band4 = 0;
					cont4 = 0;

				}
			}
			if (cont5 == 1) {
				band5++;

				if (band5 >= 3) {

					global6();

					band5 = 0;
					cont5 = 0;

				}
			}
			if (cont6 == 1) {
				band6++;

				if (band6 >= 3) {

					global7();

					band6 = 0;
					cont6 = 0;

				}
			}
			if (cont7 == 1) {
				band7++;

				if (band7 >= 3) {

					global8();

					band7 = 0;
					cont7 = 0;

				}
			}
			if (cont8 == 1) {
				band8++;

				if (band8 >= 3) {

					global9();

					band8 = 0;
					cont8 = 0;

				}
			}
			if (cont9 == 1) {
				band9++;

				if (band9 >= 3) {

					global10();

					band9 = 0;
					cont9 = 0;

				}
			}
			if (cont10 == 1) {
				band10++;

				if (band10 >= 3) {

					global11();

					band10 = 0;
					cont10 = 0;

				}
			}
			if (cont11 == 1) {
				band11++;

				if (band11 >= 3) {

					global12();

					band11 = 0;
					cont11 = 0;

				}
			}
			if (cont12 == 1) {
				band12++;

				if (band12 >= 3) {

					global13();

					band12 = 0;
					cont12 = 0;

				}
			}
			if (cont13 == 1) {
				band13++;

				if (band13 >= 3) {

					global14();

					band13 = 0;
					cont13 = 0;

				}
			}
			if (cont14 == 1) {
				band14++;

				if (band14 >= 3) {

					global15();

					band14 = 0;
					cont14 = 0;

				}
			}
			if (cont15 == 1) {
				band15++;

				if (band15 >= 3) {

					global16();

					band15 = 0;
					cont15 = 0;

				}
			}
			if (cont16 == 1) {
				band16++;

				if (band16 >= 3) {

					global17();

					band16 = 0;
					cont16 = 0;

				}
			}
			if (cont17 == 1) {
				band17++;

				if (band17 >= 3) {

					global18();

					band17 = 0;
					cont17 = 0;

				}
			}
			if (cont18 == 1) {
				band18++;

				if (band18 >= 3) {

					global19();

					band18 = 0;
					cont18 = 0;

				}
			}
			if (cont19 == 1) {
				band19++;

				if (band19 >= 3) {

					global20();

					band19 = 0;
					cont19 = 0;

				}
			}
			if (cont20 == 1) {
				band20++;

				if (band20 >= 3) {

					global21();

					band20 = 0;
					cont20 = 0;

				}
			}
			if (cont21 == 1) {
				band21++;

				if (band21 >= 3) {

					global22();

					band21 = 0;
					cont21 = 0;

				}
			}
			if (cont22 == 1) {
				band22++;

				if (band22 >= 3) {

					global23();

					band22 = 0;
					cont22 = 0;

				}
			}
			if (cont23 == 1) {
				band23++;

				if (band23 >= 3) {

					global24();

					band23 = 0;
					cont23 = 0;

				}
			}
			if (cont24 == 1) {
				band24++;

				if (band24 >= 3) {

					global25();

					band24 = 0;
					cont24 = 0;

				}
			}
			if (cont25 == 1) {
				band25++;

				if (band25 >= 3) {

					global26();

					band25 = 0;
					cont25 = 0;

				}
			}
			if (cont26 == 1) {
				band26++;

				if (band26 >= 3) {

					global27();

					band26 = 0;
					cont26 = 0;

				}
			}
			if (cont27 == 1) {
				band27++;

				if (band27 >= 3) {

					global28();

					band27 = 0;
					cont27 = 0;

				}
			}
			if (cont28 == 1) {
				band28++;

				if (band28 >= 3) {

					global29();

					band28 = 0;
					cont28 = 0;

				}
			}
			if (cont29 == 1) {
				band29++;

				if (band29 >= 3) {

					global30();

					band29 = 0;
					cont29 = 0;

				}
			}
			if (cont30 == 1) {
				band30++;

				if (band30 >= 3) {

					global31();

					band30 = 0;
					cont30 = 0;

				}
			}
			if (cont31 == 1) {
				band31++;

				if (band31 >= 3) {

					global32();

					band31 = 0;
					cont31 = 0;

				}
			}
			if (cont32 == 1) {
				band32++;

				if (band32 >= 3) {

					global33();

					band32 = 0;
					cont32 = 0;

				}
			}
			if (cont33 == 1) {
				band33++;

				if (band33 >= 3) {

					global34();

					band33 = 0;
					cont33 = 0;

				}
			}
			if (cont34 == 1) {
				band34++;

				if (band34 >= 3) {

					global35();

					band34 = 0;
					cont34 = 0;

				}
			}
			if (cont35 == 1) {
				band35++;

				if (band35 >= 3) {

					global36();

					band35 = 0;
					cont35 = 0;

				}
			}
			if (cont36 == 1) {
				band36++;

				if (band36 >= 3) {

					global37();

					band36 = 0;
					cont36 = 0;
					repeat.start();

				}

			}
		}

	});*/

	public void abrirarchivo(String archivo) {

		try {

			File objetofile = new File(archivo);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			JOptionPane.showMessageDialog(Pane, "Error ", "",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	Timer repet = new Timer(600, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		
			rp1++;
			
			if(rp1>=100){
				try {
				//	Robot dron = new Robot();
					//dron.keyPress(KeyEvent.VK_F12);
				} catch (Exception e) {
					// TODO: handle exception
				}
			rp1=0;
			}
			
		}
	});
	Timer envpro = new Timer(600, new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			Calendar calendario = Calendar.getInstance();

			calendario = new GregorianCalendar();

			// String ampm =
			// calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";

			int h, m, s;
			h = calendario.get(Calendar.HOUR_OF_DAY);
			m = calendario.get(Calendar.MINUTE);
			s = calendario.get(Calendar.SECOND);

			co1 = String.valueOf(h);
			co1 = Integer.toString(h);

			co2 = String.valueOf(m);
			co2 = Integer.toString(m);

			co3 = String.valueOf(s);
			co3 = Integer.toString(s);

			encerrar();
			if ((co1.equals(ho1)) && (co2.equals(ho2)) && (co3.equals(hos))) {

				
				//tm1.start();

				//repeat.start();
				//
                new table().setVisible(true);
        		abrirarchivo("programacionx.rec");
			   envpro.stop();
			   repet.start();
			   
			}
		//	if ((co1.equals(ho3)) && (co2.equals(ho4)) && (co3.equals(hos_f))) {

			//	area.append("\n Envio Programado Detenido.");

				// while(true){
			//	tm1.stop();
				//envpro.stop();
			//	repeat.stop();

				// repeatx.stop();

				// }

			//}

		}
	});
	private JButton btnNewButton_1;

	public control() {
		setTitle("Control_JazzQuiz");

		Image icono = Toolkit.getDefaultToolkit().getImage(
				"src/img/logo_frame.png");

		this.setIconImage(icono);
		// Shape forma = new RoundRectangle2D.Double(0, 0,
		// this.getBounds().width, this.getBounds().height, 30, 30);

		// AWTUtilities.setWindowShape(this,forma) ;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("SplitPane.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(255, 140,
				0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 452, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);

		orden = new JTextField();
		orden.setVisible(false);
		orden.setBounds(329, 231, 86, 20);
		panel.add(orden);
		orden.setColumns(10);

		JLabel label_1 = new JLabel("_____");
		label_1.setBounds(395, 25, 80, 14);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		label_1.setForeground(Color.WHITE);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Cerrar");
		label_2.setBounds(395, 21, 46, 23);
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		label_2.setForeground(new Color(250, 235, 215));
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(label_2);

		area = new JTextArea();
		area.setEditable(false);

		area.setFont(new Font("Calibri", Font.PLAIN, 12));
		area.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 165,
				0)));
		area.setBackground(new Color(255, 255, 255));

		panel.add(area);

		PanelCurves panelCurves = new PanelCurves();
		panelCurves.setBounds(10, -19, 431, 308);
		panel.add(panelCurves);
		panelCurves.setLayout(null);

		JButton btnInformes = new JButton("Generar Informe");
		btnInformes.setBackground(new Color(255, 255, 255));
		btnInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new interfaceinf().setVisible(true);
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnInformes.setBounds(238, 216, 129, 23);
		panelCurves.add(btnInformes);

		JLabel label = new JLabel("");
		label.setBounds(10, 29, 405, 66);
		label.setIcon(new ImageIcon("src/img/sinf.png"));
		panelCurves.add(label);

		JButton btnEnviarTrivias = new JButton("Enviar Trivias");
		btnEnviarTrivias.setBackground(new Color(255, 255, 255));
		btnEnviarTrivias.setBounds(57, 216, 128, 23);
		panelCurves.add(btnEnviarTrivias);

		final JComboBox combo = new JComboBox();
		combo.setBackground(new Color(255, 255, 255));
		combo.setBounds(57, 193, 310, 20);
		panelCurves.add(combo);
		combo.setModel(new DefaultComboBoxModel(new String[] {
				"Seleccione Tanda...",
				"IP: 172.16.232.129 hasta IP: 172.16.232.186",
				"IP: 172.16.232.193 hasta IP: 172.16.232.251",
				"IP: 172.16.233.1 hasta IP: 172.16.233.50",
				"IP: 172.16.233.51 hasta IP: 172.16.233.100",
				"IP: 172.16.233.101 hasta IP: 172.16.233.150",
				"IP: 172.16.233.151 hasta IP: 172.16.233.200",
				"IP: 172.16.233.201 hasta IP: 172.16.233.254",
				"IP: 172.16.234.1 hasta IP: 172.16.234.50",
				"IP: 172.16.234.51 hasta IP: 172.16.234.100",
				"IP: 172.16.234.101 hasta IP: 172.16.234.150",
				"IP: 172.16.234.151 hasta IP: 172.16.234.200",
				"IP: 172.16.234.201 hasta IP: 172.16.234.254",
				"IP: 172.16.235.1 hasta IP: 172.16.235.50",
				"IP: 172.16.235.51 hasta IP: 172.16.235.100",
				"IP: 172.16.235.101 hasta IP: 172.16.235.150",
				"IP: 172.16.235.151 hasta IP: 172.16.235.200",
				"IP: 172.16.235.201 hasta IP: 172.16.235.254",
				"IP: 172.16.236.1 hasta IP: 172.16.236.50",
				"IP: 172.16.236.51 hasta IP: 172.16.236.100",
				"IP: 172.16.236.101 hasta IP: 172.16.236.150",
				"IP: 172.16.236.151 hasta IP: 172.16.236.200",
				"IP: 172.16.236.201 hasta IP: 172.16.236.254",
				"IP: 172.16.237.1 hasta IP: 172.16.237.50",
				"IP: 172.16.237.51 hasta IP: 172.16.237.100",
				"IP: 172.16.237.101 hasta IP: 172.16.237.150",
				"IP: 172.16.237.151 hasta IP: 172.16.237.200",
				"IP: 172.16.237.201 hasta IP: 172.16.237.254",
				"IP: 172.16.238.1 hasta IP: 172.16.238.50",
				"IP: 172.16.238.51 hasta IP: 172.16.238.100",
				"IP: 172.16.238.101 hasta IP: 172.16.238.150",
				"IP: 172.16.238.151 hasta IP: 172.16.238.200",
				"IP: 172.16.238.201 hasta IP: 172.16.238.254",
				"IP: 172.16.58.1 hasta IP: 172.16.58.50",
				"IP: 172.16.58.51 hasta IP: 172.16.58.100",
				"IP: 172.16.58.101 hasta IP: 172.16.58.150",
				"IP: 172.16.58.151 hasta IP: 172.16.58.200",
				"IP: 172.16.58.201 hasta IP: 172.16.58.254", }));

		JButton button = new JButton("->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tri();
				almaip = ip.getText();

				try {
					Socket cli = new Socket(almaip, 6667);

					orden binario = new orden();

					binario.setOrdenn(orden.getText());

					ObjectOutputStream flujo = new ObjectOutputStream(cli
							.getOutputStream());
					flujo.writeObject(binario);
					// System.out.println("enviando trivias----ip --1 ");
					area.append("\n" + "Trivia Enviada Exitosamente a :"
							+ cli.getInetAddress() + " : ");

					// tiempo.start();
					cli.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(Pane,
							"Error al Enviar la Trivia", "",
							JOptionPane.ERROR_MESSAGE);
				}
				// TODO: handle exception
			}

		});
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(353, 82, 45, 23);
		panelCurves.add(button);

		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				area.setText("");
				ip.setText("");
			}
		});
		btnNewButton.setBounds(383, 178, 38, 42);
		panelCurves.add(btnNewButton);
		JButton btnEnvioProgramadoGlobal = new JButton("Envio Programado");
		btnEnvioProgramadoGlobal.setBackground(new Color(255, 255, 255));
		minutos = new JComboBox();
		minutos.setBounds(325, 134, 42, 20);
		panelCurves.add(minutos);
		for (int i = 0; i < 10; i++) {

			minutos.addItem("0" + i);
			// minutos.addItem(+i);
		}
		for (int j = 10; j < 60; j++) {

			minutos.addItem(j);
		}

		ss = new JComboBox();
		ss.setBounds(370, 134, 45, 20);
		panelCurves.add(ss);
		for (int s1 = 0; s1 < 60; s1++) {
			ss.addItem(s1);
		}

		horas = new JComboBox();
		horas.setBounds(275, 134, 45, 20);
		panelCurves.add(horas);
		horas.addItem("0");
		horas.addItem("1");
		horas.addItem("2");
		horas.addItem("3");
		horas.addItem("4");
		horas.addItem("5");
		horas.addItem("6");
		horas.addItem("7");
		horas.addItem("8");
		horas.addItem("9");
		horas.addItem("10");
		horas.addItem("11");
		horas.addItem("12");
		horas.addItem("13");
		horas.addItem("14");
		horas.addItem("15");
		horas.addItem("16");
		horas.addItem("17");
		horas.addItem("18");
		horas.addItem("19");
		horas.addItem("20");
		horas.addItem("21");
		horas.addItem("22");
		horas.addItem("23");

		btnEnvioProgramadoGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// global1();

				if ((horas.getSelectedIndex() == 0)
						&& (minutos.getSelectedIndex() == 0)
						&& (ss.getSelectedIndex() == 0)) {
					JOptionPane
							.showMessageDialog(null,
									"No Se Elegio Una hora Permitida Para Iniciar El Envio ");
				} else {
					encerrar();
					JOptionPane.showMessageDialog(null, "Envio Programado : "
							+ ho1 + " horas con " + ho2 + " minutos" + " y "
							+ hos + " segundos");
					envpro.start();
				}
			}
		});

		btnEnvioProgramadoGlobal.setBounds(57, 152, 150, 20);
		panelCurves.add(btnEnvioProgramadoGlobal);

		JLabel lblInicio = new JLabel("Inicio :");
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setBounds(229, 137, 80, 14);
		panelCurves.add(lblInicio);

		JLabel lblIngreseIpprueba = new JLabel("Ingrese Ip (prueba)");
		lblIngreseIpprueba.setBounds(145, 74, 198, 33);
		panelCurves.add(lblIngreseIpprueba);
		lblIngreseIpprueba.setForeground(new Color(245, 255, 250));
		lblIngreseIpprueba.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				18));

		ip = new JTextField();
		ip.setBounds(20, 82, 115, 20);
		panelCurves.add(ip);
		ip.setFont(new Font("Calibri", Font.PLAIN, 12));
		ip.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 165, 0)));
		ip.setColumns(10);

		JLabel lblHh = new JLabel("hh");
		lblHh.setForeground(Color.WHITE);
		lblHh.setBounds(287, 116, 24, 14);
		panelCurves.add(lblHh);

		JLabel lblMm = new JLabel("mm");
		lblMm.setForeground(Color.WHITE);
		lblMm.setBounds(332, 116, 24, 14);
		panelCurves.add(lblMm);

		JLabel lblSs = new JLabel("ss");
		lblSs.setForeground(Color.WHITE);
		lblSs.setBounds(383, 116, 80, 14);
		panelCurves.add(lblSs);

		btnNewButton_1 = new JButton("Admin Encuesta");
		btnNewButton_1.setVisible(true);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			try {
				new adminencuesta().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnNewButton_1.setBounds(68, 118, 128, 23);
		panelCurves.add(btnNewButton_1);

		JLabel lblDetener = new JLabel("Detener:");
		lblDetener.setForeground(Color.WHITE);
		lblDetener.setBounds(230, 168, 50, 14);
		panelCurves.add(lblDetener);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirarchivo("controll2/controll2.jar");
			}
		});
		btnNewButton_2.setBounds(285, 165, 14, 17);
		panelCurves.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "" + area.getText());

				// JOptionPane.showMessageDialog(null,"sds");

				try {
					Socket cli = new Socket("", 0407);
					DataOutputStream flujo = new DataOutputStream(cli
							.getOutputStream());
					flujo.writeUTF(area.getText());
					cli.close();
				} catch (Exception e) {
					System.out.println("Error en Cliente" + e.getMessage());

					// TODO: handle exception

				}

			}
		});
		btnNewButton_3.setBounds(417, 262, 14, 23);
		panelCurves.add(btnNewButton_3);
		
		JButton btnEnvio = new JButton("Envio Copy Paste");
		btnEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new table().setVisible(true);
			}
		});
		btnEnvio.setBackground(Color.WHITE);
		btnEnvio.setBounds(193, 48, 150, 23);
		panelCurves.add(btnEnvio);

		btnEnviarTrivias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (combo.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Eliga Una Tanda");
				} else if (combo.getSelectedIndex() == 1) {

					ips = new String[258];
					contip = 129;
					contarrip = 129;

					for (; contarrip < 187; contarrip++) {

						// normal += "\n 172.16.233." + contip;

						for (; contip < 187; contip++) {
							contarrip++;

							if (contip == 129) {
								tan1();

								socket();

							}
							if (contip == 130) {
								tan1();

								socket();
							}
							if (contip == 131) {
								tan1();

								socket();

							}
							if (contip == 132) {
								tan1();

								socket();

							}
							if (contip == 133) {
								tan1();

								socket();

							}

							if (contip == 134) {
								tan1();

								socket();

							}

							if (contip == 135) {
								tan1();
								socket();

							}
							if (contip == 136) {
								tan1();
								socket();

							}
							if (contip == 137) {
								tan1();
								socket();

							}
							if (contip == 138) {
								tan1();
								socket();

							}
							if (contip == 139) {
								tan1();
								socket();

							}
							if (contip == 140) {
								tan1();
								socket();

							}
							if (contip == 141) {
								tan1();
								socket();

							}
							if (contip == 142) {
								tan1();
								socket();

							}
							if (contip == 143) {
								tan1();
								socket();

							}
							if (contip == 144) {
								tan1();
								socket();

							}
							if (contip == 145) {
								tan1();
								socket();

							}
							if (contip == 146) {
								tan1();
								socket();

							}
							if (contip == 147) {
								tan1();
								socket();

							}
							if (contip == 148) {
								tan1();
								socket();

							}
							if (contip == 149) {
								tan1();
								socket();

							}
							if (contip == 150) {
								tan1();
								socket();

							}
							if (contip == 151) {
								tan1();
								socket();

							}
							if (contip == 152) {
								tan1();
								socket();

							}
							if (contip == 153) {
								tan1();
								socket();

							}
							if (contip == 154) {
								tan1();
								socket();

							}
							if (contip == 155) {
								tan1();
								socket();

							}
							if (contip == 156) {
								tan1();
								socket();

							}
							if (contip == 157) {
								tan1();
								socket();

							}
							if (contip == 158) {
								tan1();
								socket();

							}
							if (contip == 159) {
								tan1();
								socket();

							}
							if (contip == 160) {
								tan1();
								socket();

							}
							if (contip == 161) {
								tan1();
								socket();

							}
							if (contip == 162) {
								tan1();
								socket();

							}
							if (contip == 163) {
								tan1();
								socket();

							}
							if (contip == 164) {
								tan1();
								socket();

							}
							if (contip == 165) {
								tan1();
								socket();

							}
							if (contip == 167) {
								tan1();
								socket();

							}
							if (contip == 168) {
								tan1();
								socket();

							}
							if (contip == 169) {
								tan1();
								socket();

							}
							if (contip == 170) {
								tan1();
								socket();

							}
							if (contip == 171) {
								tan1();
								socket();

							}
							if (contip == 172) {
								tan1();
								socket();

							}
							if (contip == 173) {
								tan1();
								socket();

							}
							if (contip == 174) {
								tan1();
								socket();

							}
							if (contip == 175) {
								tan1();
								socket();

							}
							if (contip == 176) {
								tan1();
								socket();

							}
							if (contip == 177) {
								tan1();
								socket();

							}
							if (contip == 178) {
								tan1();
								socket();

							}
							if (contip == 179) {
								tan1();
								socket();

							}
							if (contip == 180) {
								tan1();
								socket();

							}
							if (contip == 181) {
								tan1();
								socket();

							}
							if (contip == 182) {
								tan1();
								socket();

							}
							if (contip == 183) {
								tan1();
								socket();

							}
							if (contip == 184) {
								tan1();
								socket();

							}
							if (contip == 185) {
								tan1();
								socket();

							}
							if (contip == 186) {
								tan1();
								socket();
								area.append("\n Tanda 1 Enviada.");
							}

						}
					}

				} else if (combo.getSelectedIndex() == 2) {

					ips = new String[258];
					contip = 192;
					contarrip = 192;
					cont3 = 192;

					for (; contarrip < 251; contarrip++) {

						for (; cont3 < 251; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 251; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan1();
										socket();

									}

									if ((contip == 251) && (cont3 == 251)) {
										area.append("\n Tanda 2 Enviada.");
										break;
									}
								}

							}
						}
					}

				} else if (combo.getSelectedIndex() == 3) {

					ips = new String[258];
					contip = 0;
					contarrip = 0;
					cont3 = 0;

					for (; contarrip < 50; contarrip++) {

						for (; cont3 < 50; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 50; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan2();
										socket();

									}

									if ((contip == 50) && (cont3 == 50)) {
										area.append("\n Tanda 3 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 4) {

					ips = new String[258];
					contip = 50;
					contarrip = 50;
					cont3 = 50;

					for (; contarrip < 100; contarrip++) {

						for (; cont3 < 100; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 100; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan2();
										socket();

									}

									if ((contip == 100) && (cont3 == 100)) {
										area.append("\n Tanda 4 Enviada.");
										break;
									}
								}

							}
						}
					}

				} else if (combo.getSelectedIndex() == 5) {

					ips = new String[258];
					contip = 100;
					contarrip = 100;
					cont3 = 100;

					for (; contarrip < 150; contarrip++) {

						for (; cont3 < 150; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 150; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan2();
										socket();

									}

									if ((contip == 150) && (cont3 == 150)) {
										area.append("\n Tanda 5 Enviada.");
										break;
									}
								}

							}
						}
					}

				} else if (combo.getSelectedIndex() == 6) {

					ips = new String[258];
					contip = 150;
					contarrip = 150;
					cont3 = 150;

					for (; contarrip < 200; contarrip++) {

						for (; cont3 < 200; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 200; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan2();
										socket();

									}

									if ((contip == 200) && (cont3 == 200)) {
										area.append("\n Tanda 6 Enviada.");
										break;
									}
								}

							}
						}
					}

				} else if (combo.getSelectedIndex() == 7) {

					ips = new String[258];
					contip = 200;
					contarrip = 200;
					cont3 = 200;

					for (; contarrip < 254; contarrip++) {

						for (; cont3 < 254; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 254; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan2();
										socket();

									}

									if ((contip == 254) && (cont3 == 254)) {
										area.append("\n Tanda 7 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 8) {

					ips = new String[258];
					contip = 0;
					contarrip = 0;
					cont3 = 0;

					for (; contarrip < 50; contarrip++) {

						for (; cont3 < 50; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 50; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan3();
										socket();

									}

									if ((contip == 50) && (cont3 == 50)) {
										area.append("\n Tanda 8 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 9) {

					ips = new String[258];
					contip = 50;
					contarrip = 50;
					cont3 = 50;

					for (; contarrip < 100; contarrip++) {

						for (; cont3 < 100; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 100; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan3();
										socket();

									}

									if ((contip == 100) && (cont3 == 100)) {
										area.append("\n Tanda 9 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 10) {

					ips = new String[258];
					contip = 100;
					contarrip = 100;
					cont3 = 100;

					for (; contarrip < 150; contarrip++) {

						for (; cont3 < 150; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 150; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan3();
										socket();

									}

									if ((contip == 150) && (cont3 == 150)) {
										area.append("\n Tanda 10 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 11) {

					ips = new String[258];
					contip = 150;
					contarrip = 150;
					cont3 = 150;

					for (; contarrip < 200; contarrip++) {

						for (; cont3 < 200; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 200; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan3();
										socket();

									}

									if ((contip == 200) && (cont3 == 200)) {
										area.append("\n Tanda 11 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 12) {

					ips = new String[258];
					contip = 200;
					contarrip = 200;
					cont3 = 200;

					for (; contarrip < 254; contarrip++) {

						for (; cont3 < 254; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 254; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan3();
										socket();

									}

									if ((contip == 254) && (cont3 == 254)) {
										area.append("\n Tanda 12 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 13) {

					ips = new String[258];
					contip = 0;
					contarrip = 0;
					cont3 = 0;

					for (; contarrip < 50; contarrip++) {

						for (; cont3 < 50; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 50; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan4();
										socket();

									}

									if ((contip == 50) && (cont3 == 50)) {
										area.append("\n Tanda 13 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 14) {

					ips = new String[258];
					contip = 50;
					contarrip = 50;
					cont3 = 50;

					for (; contarrip < 100; contarrip++) {

						for (; cont3 < 100; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 100; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan4();
										socket();

									}

									if ((contip == 100) && (cont3 == 100)) {
										area.append("\n Tanda 14 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 15) {

					ips = new String[258];
					contip = 100;
					contarrip = 100;
					cont3 = 100;

					for (; contarrip < 150; contarrip++) {

						for (; cont3 < 150; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 150; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan4();
										socket();

									}

									if ((contip == 150) && (cont3 == 150)) {
										area.append("\n Tanda 15 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 16) {

					ips = new String[258];
					contip = 150;
					contarrip = 150;
					cont3 = 150;
					for (; contarrip < 200; contarrip++) {

						for (; cont3 < 200; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 200; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan4();
										socket();

									}

									if ((contip == 200) && (cont3 == 200)) {
										area.append("\n Tanda 16 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 17) {

					ips = new String[258];
					contip = 200;
					contarrip = 200;
					cont3 = 200;

					for (; contarrip < 254; contarrip++) {

						for (; cont3 < 254; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 254; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan4();
										socket();

									}

									if ((contip == 254) && (cont3 == 254)) {
										area.append("\n Tanda 17 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 18) {

					ips = new String[258];
					contip = 0;
					contarrip = 0;
					cont3 = 0;

					for (; contarrip < 50; contarrip++) {

						for (; cont3 < 50; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 50; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan5();
										socket();

									}

									if ((contip == 50) && (cont3 == 50)) {
										area.append("\n Tanda 18 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 19) {

					ips = new String[258];
					contip = 50;
					contarrip = 50;
					cont3 = 50;

					for (; contarrip < 100; contarrip++) {

						for (; cont3 < 100; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 100; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan5();
										socket();

									}

									if ((contip == 100) && (cont3 == 100)) {
										area.append("\n Tanda 19 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 20) {

					ips = new String[258];
					contip = 100;
					contarrip = 100;
					cont3 = 100;

					for (; contarrip < 150; contarrip++) {

						for (; cont3 < 150; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 150; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan5();
										socket();

									}

									if ((contip == 150) && (cont3 == 150)) {
										area.append("\n Tanda 20 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 21) {

					ips = new String[258];
					contip = 150;
					contarrip = 150;
					cont3 = 150;

					for (; contarrip < 200; contarrip++) {

						for (; cont3 < 200; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 200; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan5();
										socket();

									}

									if ((contip == 200) && (cont3 == 200)) {
										area.append("\n Tanda 21 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 22) {

					ips = new String[258];
					contip = 200;
					contarrip = 200;
					cont3 = 200;

					for (; contarrip < 254; contarrip++) {

						for (; cont3 < 254; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 254; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan5();
										socket();

									}

									if ((contip == 254) && (cont3 == 254)) {
										area.append("\n Tanda 22 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 23) {

					ips = new String[258];
					contip = 0;
					contarrip = 0;
					cont3 = 0;

					for (; contarrip < 50; contarrip++) {

						for (; cont3 < 50; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 50; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan6();
										socket();

									}

									if ((contip == 50) && (cont3 == 50)) {
										area.append("\n Tanda 23 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 24) {

					ips = new String[258];
					contip = 50;
					contarrip = 50;
					cont3 = 50;

					for (; contarrip < 100; contarrip++) {

						for (; cont3 < 100; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 100; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan6();
										socket();

									}

									if ((contip == 100) && (cont3 == 100)) {
										area.append("\n Tanda 24 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 25) {

					ips = new String[258];
					contip = 100;
					contarrip = 100;
					cont3 = 100;

					for (; contarrip < 150; contarrip++) {

						for (; cont3 < 150; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 150; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan6();
										socket();

									}

									if ((contip == 150) && (cont3 == 150)) {
										area.append("\n Tanda 25 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 26) {

					ips = new String[258];
					contip = 150;
					contarrip = 150;
					cont3 = 150;

					for (; contarrip < 200; contarrip++) {

						for (; cont3 < 200; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 200; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan6();
										socket();

									}

									if ((contip == 200) && (cont3 == 200)) {
										area.append("\n Tanda 26 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 27) {

					ips = new String[258];
					contip = 200;
					contarrip = 200;
					cont3 = 200;

					for (; contarrip < 254; contarrip++) {

						for (; cont3 < 254; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 254; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan6();
										socket();

									}

									if ((contip == 254) && (cont3 == 254)) {
										area.append("\n Tanda 27 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 28) {

					ips = new String[258];
					contip = 0;
					contarrip = 0;
					cont3 = 0;

					for (; contarrip < 50; contarrip++) {

						for (; cont3 < 50; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 50; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan7();
										socket();

									}

									if ((contip == 50) && (cont3 == 50)) {
										area.append("\n Tanda 28 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 29) {

					ips = new String[258];
					contip = 50;
					contarrip = 50;
					cont3 = 50;

					for (; contarrip < 100; contarrip++) {

						for (; cont3 < 100; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 100; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan7();
										socket();

									}

									if ((contip == 100) && (cont3 == 100)) {
										area.append("\n Tanda 29 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 30) {

					ips = new String[258];
					contip = 100;
					contarrip = 100;
					cont3 = 100;

					for (; contarrip < 150; contarrip++) {

						for (; cont3 < 150; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 150; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan7();
										socket();

									}

									if ((contip == 150) && (cont3 == 150)) {
										area.append("\n Tanda 30 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 31) {

					ips = new String[258];
					contip = 150;
					contarrip = 150;
					cont3 = 150;

					for (; contarrip < 200; contarrip++) {

						for (; cont3 < 200; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 200; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan7();
										socket();

									}

									if ((contip == 200) && (cont3 == 200)) {
										area.append("\n Tanda 31 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 32) {

					ips = new String[258];
					contip = 200;
					contarrip = 200;
					cont3 = 200;

					for (; contarrip < 254; contarrip++) {

						for (; cont3 < 254; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 254; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan7();
										socket();
									}

									if ((contip == 254) && (cont3 == 254)) {
										area.append("\n Tanda 32 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 33) {

					ips = new String[258];
					contip = 0;
					contarrip = 0;
					cont3 = 0;

					for (; contarrip < 50; contarrip++) {

						for (; cont3 < 50; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 50; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan8();
										socket();
									}

									if ((contip == 50) && (cont3 == 50)) {
										area.append("\n Tanda 33 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 34) {

					ips = new String[258];
					contip = 50;
					contarrip = 50;
					cont3 = 50;

					for (; contarrip < 100; contarrip++) {

						for (; cont3 < 100; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 100; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan8();
										socket();
									}

									if ((contip == 100) && (cont3 == 100)) {
										area.append("\n Tanda 34 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 35) {

					ips = new String[258];
					contip = 100;
					contarrip = 100;
					cont3 = 100;

					for (; contarrip < 150; contarrip++) {

						for (; cont3 < 150; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 150; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan8();
										socket();
									}

									if ((contip == 150) && (cont3 == 150)) {
										area.append("\n Tanda 35 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 36) {

					ips = new String[258];
					contip = 150;
					contarrip = 150;
					cont3 = 150;

					for (; contarrip < 200; contarrip++) {

						for (; cont3 < 200; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 200; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;

									if (contip == cont3) {
										tan8();
										socket();
									}

									if ((contip == 200) && (cont3 == 200)) {
										area.append("\n Tanda 36 Enviada.");
										break;
									}
								}

							}
						}
					}
				} else if (combo.getSelectedIndex() == 37) {

					ips = new String[258];
					contip = 200;
					contarrip = 200;
					cont3 = 200;

					for (; contarrip < 254; contarrip++) {

						for (; cont3 < 254; cont3++) {

							// normal += "\n 172.16.233." + contip;

							for (; contip < 254; contip++) {
								contarrip++;

								while (true) {
									contip++;
									cont3++;
									// JOptionPane.showMessageDialog(null,
									// "contip"+contip+"/n"+"cont3"+cont3);
									if (contip == cont3) {
										tan8();
										socket();
									}

									if ((contip == 254) && (cont3 == 254)) {
										area.append("\n Tanda 37 Enviada.");
										break;
									}
								}

							}
						}
					}
				}

			}

		});

	//	scrollPane = new JScrollPane();
		area.setColumns(20);
		area.setRows(1000000000);
		//scrollPane.setViewportView(area);
		//scrollPane.setBounds(37, 239, 378, 59);
		area.setBounds(37, 239, 378, 50);
		//panelCurves.add(scrollPane);
		PanelCurves panelCurves_1 = new PanelCurves();
		panelCurves_1.setLayout(null);
		panelCurves_1.setBounds(10, -136, 431, 242);
		panel.add(panelCurves_1);

	}
}