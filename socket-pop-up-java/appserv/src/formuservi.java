
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

public class formuservi extends JFrame implements Runnable {
	/**
	 * 
	 */

	Label hola;
	int ban = 1;
	int contador = 0;
	Timer t1 = new Timer(1500, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			contador++;
			if (contador >= 10) {
				t1.stop();
				dispose();

				contador = 0;
				index window = new index();
				window.frame.setVisible(true);
				contador = 0;

			}

			// if (ban==1){
			// t1.stop();

			// ban=0;

			// }

		}
	});

	Timer tiempo = new Timer(20, new ActionListener() {
		int cont2 = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cont2++;
			if (cont2 >= 1) {
				tiempo.stop();
				dispose();
			}

		}
	});

	public formuservi() {

		tiempo.start();
		setUndecorated(true);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);

		// hola.setBounds(400,120,20,10);
		// 400 120
		setSize(430, 120);

		Thread hilo = new Thread(this);
		hilo.start();

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// 3306//
		try {
			ServerSocket servidor = new ServerSocket(6667);
			Socket cli;
			while (true) {
				// aceptar el objeto que ha enviado el cliente//
				cli = servidor.accept();

				ObjectInputStream flujo = new ObjectInputStream(
						cli.getInputStream());

				// beanx recibe ip y orden//
				orden bin = (orden) flujo.readObject();

				// }else if (bin.getOrdenn().equals("D")){
				// setVisible(false);
				// }
				// else if (bin.getOrdenn().equals("I")){

				// }
				// else if (bin.getOrdenn().equals("C")){
				// comando para abrir ventana de windows//
				// Process r
				// =Runtime.getRuntime().exec("cmd.exe /c start cmd ");
				// }
				// else if (bin.getOrdenn().equals("A")){
				// Runtime r =Runtime.getRuntime();
				// r.exec("cmd.exe /c  shutdown -s -t 90");
				// }
				if (bin.getOrdenn().equals("trivia")) {
					t1.start();

					new mensaje().setVisible(true);

				}
				if (bin.getOrdenn().equals("party")) {

					new party().setVisible(true);

				}
                                if (bin.getOrdenn().equals("Adeherencia")) {

                			new app().setVisible(true);

				}
                                if (bin.getOrdenn().equals("Encuesta")) {

                			new encuesta().setVisible(true);

				}
                                else if (bin.getOrdenn().equals("close")) {
					tiempo.stop();
					t1.stop();
					servidor.close();
					break;

				}
				cli.close();
			}

		} catch (Exception e) {
			
			// TODO: handle exception
		}
		// TODO Auto-generated method stub

	}
}
