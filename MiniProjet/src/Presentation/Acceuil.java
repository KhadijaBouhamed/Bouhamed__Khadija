package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class Acceuil extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window= new Acceuil();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 
	 */
	public Acceuil() {
		initialize();
	}
	
	public void initialize(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(Color.PINK);
		setBounds(100, 100, 800, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gestionClient GC = new gestionClient();
		RendzVous RV = new RendzVous();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#2375a4"));
		panel.setBounds(245, 0, 539, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(245, 47, 539, 388);
		panel_2.setBackground(new Color(55, 139, 201));
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#2375a4"));
		panel_3.setBounds(0, 0, 529, 37);
		panel.add(panel_3);
		
		JButton btnNewButton = new JButton("D\u00E9connecter");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Vrinda", Font.PLAIN, 12));
		panel_3.add(btnNewButton);
		
		
		JLabel lblBienvenue = new JLabel();
		lblBienvenue.setText("Bienvenue");
		lblBienvenue.setForeground(Color.decode("#ecd2ec"));
		lblBienvenue.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 25));
		panel_3.add(lblBienvenue);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#ffffff"));
		panel_1.setBounds(0, 0, 247, 478);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(10, 11, 237, 212);
		logo.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\cabinetLogo.jpg"));
		panel_1.add(logo);
		
		JButton acceuil = new JButton("Acceuil");
		JButton Clients = new JButton("Clients");
		JButton Medecins = new JButton("Medecins");
		JButton RVs = new JButton("Rendez-vous");
		
		acceuil.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\acceuil.png"));
		acceuil.setBorderPainted(false);
		acceuil.setForeground(Color.WHITE);
		acceuil.setFont(new Font("Arial", Font.PLAIN, 18));
		acceuil.setBounds(10, 234, 227, 27);
		panel_1.add(acceuil);
		acceuil.setBackground(Color.decode("#2375a4"));
		acceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceuil.setBackground(Color.decode("#9ca0a3"));
				Clients.setBackground(Color.decode("#2375a4"));
				Medecins.setBackground(Color.decode("#2375a4"));
				RVs.setBackground(Color.decode("#2375a4"));	
				panel_2.show();
				GC.hide();
				RV.hide();
			}
		});
		
		Clients.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\acceuil.png"));
		Clients.setBorderPainted(false);
		Clients.setForeground(Color.WHITE);
		Clients.setFont(new Font("Arial", Font.PLAIN, 18));
		Clients.setBounds(10, 279, 227, 27);
		panel_1.add(Clients);
		Clients.setBackground(Color.decode("#2375a4"));
		Clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceuil.setBackground(Color.decode("#2375a4"));
				Clients.setBackground(Color.decode("#9ca0a3"));
				Medecins.setBackground(Color.decode("#2375a4"));
				RVs.setBackground(Color.decode("#2375a4"));	
				panel_2.hide();
				GC.show();
				RV.hide();
				
			}
		});
		
		
		Medecins.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\acceuil.png"));
		Medecins.setBorderPainted(false);
		Medecins.setForeground(Color.WHITE);
		Medecins.setFont(new Font("Arial", Font.PLAIN, 18));
		Medecins.setBounds(10, 333, 227, 27);
		panel_1.add(Medecins);
		Medecins.setBackground(Color.decode("#2375a4"));
		Medecins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceuil.setBackground(Color.decode("#2375a4"));
				Clients.setBackground(Color.decode("#2375a4"));
				Medecins.setBackground(Color.decode("#9ca0a3"));
				RVs.setBackground(Color.decode("#2375a4"));	
			}
		});
		
		
		RVs.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\acceuil.png"));
		RVs.setBorderPainted(false);
		RVs.setForeground(Color.WHITE);
		RVs.setFont(new Font("Arial", Font.PLAIN, 18));
		RVs.setBounds(10, 386, 227, 27);
		panel_1.add(RVs);
		RVs.setBackground(Color.decode("#2375a4"));
		RVs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceuil.setBackground(Color.decode("#2375a4"));
				Clients.setBackground(Color.decode("#2375a4"));
				Medecins.setBackground(Color.decode("#2375a4"));
				RVs.setBackground(Color.decode("#9ca0a3"));
				panel_2.hide();
				GC.hide();
				RV.show();
			}
		});
		
		
		panel_2.show();
		GC.hide();
		RV.hide();
		getContentPane().add(panel_2);
		getContentPane().add(GC);
		getContentPane().add(RV);
		
	}
}
