import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class trivia_off extends JFrame {
 int trix=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
Timer tri = new Timer(600,new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		trix++;
		if(trix>=13){
			dispose();
			tri.stop();
		}
		
	}
});
		
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trivia_off frame = new trivia_off();
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
	public trivia_off() {
		setTitle("JazzQuiz");
	    tri.start();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 335, 111);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(255, 140, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeTerminoEl = new JLabel("Se Termino El Tiempo De La Trivia \r\n ");
		lblSeTerminoEl.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblSeTerminoEl.setBounds(34, 31, 280, 25);
		contentPane.add(lblSeTerminoEl);
		
		JLabel lblGracias = new JLabel("Gracias !");
		lblGracias.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblGracias.setBounds(135, 58, 289, 25);
		contentPane.add(lblGracias);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
