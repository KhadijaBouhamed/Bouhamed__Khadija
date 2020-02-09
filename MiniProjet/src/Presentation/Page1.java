package Presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.UserDao;

public class Page1 {
	private JPanel contentPane;
	private JFrame frame;
	private JTextField name;
	private JPasswordField pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 window= new Page1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 
	 */
	public Page1() {
		initialize();
	}
	
	public void initialize(){

		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(55, 139, 201));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		frame.setBounds(245, 47, 539, 388);
		frame.setBackground(new Color(55, 139, 201));
		frame.getContentPane().setLayout(null);
		
		UserDao user = new UserDao();
		
		JLabel lblSauthentifier = new JLabel("S'authentifier");
		lblSauthentifier.setForeground(Color.WHITE);
		lblSauthentifier.setFont(new Font("Impact", Font.PLAIN, 17));
		lblSauthentifier.setBounds(163, 77, 193, 33);
		frame.getContentPane().add(lblSauthentifier);
		
		name = new JTextField();
		name.setBounds(140, 133, 182, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(140, 187, 182, 20);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(44, 136, 86, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(44, 190, 86, 14);
		frame.getContentPane().add(lblPassword);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Acceuil acceuil = new Acceuil();
		ajouterClient ajouter = new ajouterClient();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(163, 249, 144, 23);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.Authentifier(name.getText(), pass.getText())) {
					
					frame.dispose();
					acceuil.show();
				}
				else
					JOptionPane.showMessageDialog(null,"Mot de passe ou nom est incorrect");
					
					
			}
		});
		
		JLabel logo = new JLabel("");
		logo.setBounds(332, 83, 197, 212);
		logo.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\Admin.png"));
		frame.getContentPane().add(logo);

		
		
	}

}
