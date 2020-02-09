package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.Client;
import DAO.ClientDao;


public class ajouterClient extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField version;
	private JTextField titre;
	private JTextField Nom;
	private JTextField Prenom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterClient frame = new ajouterClient();
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
	public ajouterClient() {
		
		setResizable(false);
		setType(Type.UTILITY);
		setBounds(100, 100, 500, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVER = new JLabel("Version");
		lblVER.setForeground(Color.GRAY);
		lblVER.setFont(new Font("Arial", Font.BOLD, 14));
		lblVER.setBounds(20, 59, 93, 14);
		contentPane.add(lblVER);
		
		version = new JTextField();
		version.setBounds(130, 57, 86, 20);
		contentPane.add(version);
		version.setColumns(10);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setForeground(Color.GRAY);
		lblTitre.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitre.setBounds(20, 100, 46, 14);
		contentPane.add(lblTitre);
		
		titre = new JTextField();
		titre.setBounds(130, 100, 86, 20);
		contentPane.add(titre);
		titre.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(Color.GRAY);
		lblNom.setFont(new Font("Arial", Font.BOLD, 14));
		lblNom.setBounds(20, 150, 86, 14);
		contentPane.add(lblNom);
		
		Nom = new JTextField();
		Nom.setBounds(130, 148, 86, 20);
		contentPane.add(Nom);
		Nom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Arial", Font.BOLD, 14));
		lblPrenom.setForeground(Color.GRAY);
		lblPrenom.setBounds(20, 201, 93, 14);
		contentPane.add(lblPrenom);
		
		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(130, 199, 86, 20);
		contentPane.add(Prenom);
		
		ClientDao clients = new ClientDao();
		
		id = new JTextField();
		id.setBounds(130, 17, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		id.setText(Integer.toString(clients.getLastId()+1));
		id.disable();;
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(Color.GRAY);
		lblId.setFont(new Font("Arial", Font.BOLD, 14));
		lblId.setBounds(20, 19, 46, 14);
		contentPane.add(lblId);
		

		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(27, 252, 189, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = id.getText(); 
				String Version = version.getText();
				String Titre = titre.getText();
				String nom = Nom.getText();
				String prenom = Prenom.getText();

				Client C = new Client(Integer.parseInt(Id),Integer.parseInt(Version),Titre,nom,prenom);
				ClientDao clients = new ClientDao();
				clients.createClient(C);
				JOptionPane.showMessageDialog(null,"bien ajouter");
				id.setText("");
				Nom.setText("");
				Prenom.setText("");
				version.setText("");
				titre.setText("");
				
				id.setText(Integer.toString(clients.getLastId()+1));
				id.enable();
				
									}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(261, 14, 223, 287);
		ImageIcon img = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\MicroProjet\\img\\clientLogo.jpg");
		Image img1 = img.getImage();
		Image img2 = img1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		label.setIcon(i);
		
		contentPane.add(label);
		contentPane.add(btnNewButton);
	}

}
