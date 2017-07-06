

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class mensaje extends JFrame {

	private JPanel contentPane;
	Timer t1 = new Timer(320,new ActionListener() {
		
		
		int cont=0;
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//int x,y;
			
			 //x= (int)(Math.random()*getWidth());
			 //y=(int)(Math.random()*getHeight());
			 cont++;
			 //setLocation(x,y);
		
		if (cont>=20){
			t1.stop();
			dispose();
		}
		
		}
	});
		
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mensaje frame = new mensaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mensaje() {
		setTitle("JazzQuiz");
		Image icono = Toolkit.getDefaultToolkit().getImage("src/img/logo_frame.png");

        setIconImage(icono);
		t1.start();
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 330, 91);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(255, 153, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 330, 91);
		contentPane.add(panel);
		
		JLabel lblEnPocosInstantes = new JLabel("Hoy es jueves de trivias       ! Suerte !  ");
		lblEnPocosInstantes.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblEnPocosInstantes.setBounds(20, 55, 375, 25);
		panel.add(lblEnPocosInstantes);
		
		JLabel logo_jazzplat = new JLabel("");
		logo_jazzplat.setIcon(new ImageIcon("src/img/logo_jazzplat.jpg"));
		logo_jazzplat.setBounds(64, 11, 203, 64);
		panel.add(logo_jazzplat);
		
		setLocationRelativeTo(null);
	}
}

