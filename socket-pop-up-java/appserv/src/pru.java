import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Panel;


public class pru extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pru frame = new pru();
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
	public pru() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 465, 646);
		setBounds(100, 100, 395, 561);
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton u1 = new JRadioButton("");
		u1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			JOptionPane.showMessageDialog(null, "");
			}
		});
		u1.setBackground(Color.BLACK);
		u1.setBounds(424, 163, 26, 23);
		contentPane.add(u1);
		
		JRadioButton u2 = new JRadioButton("");
		u2.setBackground(Color.BLACK);
		u2.setBounds(424, 194, 26, 23);
		contentPane.add(u2);
		
		JRadioButton u4 = new JRadioButton("");
		u4.setBackground(Color.BLACK);
		u4.setBounds(424, 254, 26, 23);
		contentPane.add(u4);
		
		JRadioButton u3 = new JRadioButton("");
		u3.setBackground(Color.BLACK);
		u3.setBounds(424, 223, 26, 23);
		contentPane.add(u3);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBackground(Color.BLACK);
		radioButton_2.setBounds(424, 320, 26, 14);
		contentPane.add(radioButton_2);
		
		JRadioButton u5 = new JRadioButton("");
		u5.setBackground(Color.BLACK);
		u5.setBounds(424, 289, 26, 14);
		contentPane.add(u5);
		
		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBackground(Color.BLACK);
		radioButton_4.setBounds(424, 383, 26, 14);
		contentPane.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBackground(Color.BLACK);
		radioButton_5.setBounds(424, 351, 26, 14);
		contentPane.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("");
		radioButton_6.setBackground(Color.BLACK);
		radioButton_6.setBounds(424, 415, 26, 14);
		contentPane.add(radioButton_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 504, 471, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(176, 0, 89, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(408, 0, 120, 585);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\EclipsePortableJava\\Data\\workspace\\party\\src\\img\\im1.jpg"));
		lblNewLabel.setBounds(0, -33, 398, 534);
		contentPane.add(lblNewLabel);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 480, 413, 67);
		contentPane.add(panel_2);
		
	

		setLocationRelativeTo(null);
		
	}
}
