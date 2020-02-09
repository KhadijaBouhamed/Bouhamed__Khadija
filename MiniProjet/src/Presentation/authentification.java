package Presentation;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DAO.UserDao;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class authentification extends JPanel {
	private JTextField name;
	private JTextField pass;

	/**
	 * Create the panel.
	 */
	
	public authentification() {
		this.setBounds(245, 47, 539, 388);
		this.setBackground(new Color(55, 139, 201));
		setLayout(null);
		
		UserDao user = new UserDao();
		
		JLabel lblSauthentifier = new JLabel("S'authentifier");
		lblSauthentifier.setForeground(Color.WHITE);
		lblSauthentifier.setFont(new Font("Impact", Font.PLAIN, 17));
		lblSauthentifier.setBounds(163, 77, 193, 33);
		add(lblSauthentifier);
		
	    name = new JTextField();
		name.setBounds(140, 133, 182, 20);
		add(name);
		name.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(140, 187, 182, 20);
		add(pass);
		pass.setColumns(10);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(44, 136, 86, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(44, 190, 86, 14);
		add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(55, 139, 201));
		btnLogin.setBounds(163, 249, 144, 23);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					
			}
		});
		
		JLabel logo = new JLabel("");
		logo.setBounds(332, 83, 197, 212);
		logo.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\Admin.png"));
		add(logo);

	}
}
