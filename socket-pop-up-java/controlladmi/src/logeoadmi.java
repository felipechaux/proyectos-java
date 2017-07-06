import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.Box;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.annotation.Target;

import org.edisoncor.gui.panel.PanelCurves;


public class logeoadmi extends JFrame {
	private JTextField user;
	private JPasswordField pass;
    int limit =20;
    private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logeoadmi frame = new logeoadmi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void press(){
	if((user.getText().equals("administrador")) && (pass.getText().equals("bogota2015"))  ){
		JOptionPane.showMessageDialog(null,"Bienvenido");
		dispose();
		new control().setVisible(true);
	}else{
		
		JOptionPane.showMessageDialog(null,"Acceso Denegado");
	}
}
	/**
	 * Create the frame.
	 */
	public logeoadmi() {
		setTitle("JazzQuiz_Logout");
		

		Image icono = Toolkit.getDefaultToolkit().getImage("src/img/logo_frame.png");

        this.setIconImage(icono);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(255, 140, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 341, 300);
		contentPane.add(panel);
		
		JButton btnGo = new JButton("Ir");
	
		btnGo.setBounds(271, 179, 48, 23);
		btnGo.setBackground(new Color(0, 191, 255));
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((user.getText().equals("administrador")) && (pass.getText().equals("bogota2015"))  ){
					JOptionPane.showMessageDialog(null,"Bienvenido");
					dispose();
					new control().setVisible(true);
				}else{
					
					JOptionPane.showMessageDialog(null,"Acceso Denegado");
				}
				
			}
		});
		
		JLabel label_5 = new JLabel("_____");
		label_5.setBounds(277, 25, 80, 14);
		label_5.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			dispose();
			}
		});
		panel.setLayout(null);
		label_5.setForeground(new Color(255, 255, 255));
		panel.add(label_5);
		
		JLabel lblNewLabel = new JLabel("Cerrar");
		lblNewLabel.setBounds(277, 21, 46, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		
		lblNewLabel.setForeground(new Color(250, 235, 215));
		panel.add(lblNewLabel);
		panel.add(btnGo);
		
		JLabel label = new JLabel("Usuario:");
		label.setBounds(76, 150, 118, 33);
		label.setForeground(new Color(245, 255, 250));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		panel.add(label);
		
		JLabel label_2 = new JLabel("Contrase\u00F1a:");
		label_2.setBounds(39, 194, 118, 33);
		label_2.setForeground(new Color(245, 255, 250));
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		panel.add(label_2);
		
		user = new JTextField();
		user.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent cha) {
				if (user.getText().length() == limit)

					cha.consume();
			}
			@Override
			public void keyPressed(KeyEvent evento) {
				if (evento.getKeyCode() == KeyEvent.VK_ENTER) {
					press();
				}
			}
		});
		user.setBounds(175, 159, 86, 20);
		user.setColumns(10);
		panel.add(user);
		
		pass = new JPasswordField();
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent argx) {
			if(pass.getText().length()==limit){
				
				argx.consume();
			}
			
			
			
			}
			@Override
			public void keyPressed(KeyEvent evnt1) {
				if (evnt1.getKeyCode() == KeyEvent.VK_ENTER) {
					press();
				}
			}
		});
		pass.setBounds(175, 203, 86, 20);
		panel.add(pass);
		
		PanelCurves panelCurves = new PanelCurves();
		panelCurves.setBackground(Color.CYAN);
		panelCurves.setBounds(10, 11, 321, 278);
		panel.add(panelCurves);
		panelCurves.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("src/img/admi2.jpg"));
		label_3.setBounds(50, 39, 301, 79);
		panelCurves.add(label_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(61, -66, 322, 277);
		panelCurves.add(label_1);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}