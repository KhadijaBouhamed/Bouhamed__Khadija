package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.Client;
import DAO.ClientDao;
import DAO.Creneau;
import DAO.CreneauDao;
import DAO.MedecinDao;
import DAO.RV;
import DAO.RVDao;






public class RendzVous extends JPanel {
	private JTextField date;
	private JTable table;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Create the panel.
	 */
	public RendzVous() {

		this.setBounds(245, 47, 539, 388);
		this.setBackground(new Color(55, 139, 201));
		setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setFont(new Font("Arial", Font.PLAIN, 14));
		lblClient.setBounds(30, 24, 59, 14);
		add(lblClient);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 97, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblCreneau = new JLabel("Creneau");
		lblCreneau.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCreneau.setBounds(30, 52, 115, 14);
		add(lblCreneau);
		
		JButton btnNewButton = new JButton("Afficher tous les creneaux");
		btnNewButton.setBounds(272, 49, 173, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		
		ClientDao clients = new ClientDao();
		List<String> prenoms = clients.getNomClients();
		JComboBox client = new JComboBox();
		client.setBounds(99, 22, 104, 20);
		for(int i=0 ; i<prenoms.size();i++)
		{client.addItem(prenoms.get(i));}
		add(client);
		
		CreneauDao creneaux = new CreneauDao();
		List<Integer> ids = creneaux.getIds();
		JComboBox creneau = new JComboBox();
		creneau.setBounds(99, 50, 104, 20);
		for(int i=0 ; i<ids.size();i++)
		{
			creneau.addItem(ids.get(i));
		}
		add(creneau);
		
		date = new JTextField();
		date.setBounds(99, 95, 115, 20);
		add(date);
		date.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 46, 14);
		add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 126, 507, 251);
		panel.setBackground(new Color(55, 139, 201));
		add(panel);
		panel.setLayout(null);
		
		 Object[] title = {"IdRV", "Jour", "heure Debut","heure Fin", "Client", "Medecin"};
		 DefaultTableModel dtm = new DefaultTableModel();
	        dtm.setColumnIdentifiers(title); 
	        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 497, 195);
		panel.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		
		JButton btnSup = new JButton("Supprimer");
		btnSup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int i=-1;
				i = table.getSelectedRow();
				if(i != -1) {
					RVDao RVV = new RVDao();
					RVV.deleteRV(Integer.parseInt(dtm.getValueAt(i, 0).toString()));

				Removerows(table);
				Addrows(table);
				JOptionPane.showMessageDialog(null,"Bien supprimer");
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"selecter une ligne");
				}
			}
		});
		btnSup.setBounds(20, 217, 89, 23);
		panel.add(btnSup);
		
		
		JButton btnNewButton_1 = new JButton("Modéfier");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnNewButton_1.setBounds(157, 217, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(357, 217, 160, 23);
		panel.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientDao clients = new ClientDao();
				CreneauDao creneaux = new CreneauDao();
				RVDao rvs = new RVDao();
				String Client = client.getSelectedItem().toString();
				String Creneau = creneau.getSelectedItem().toString();
				String Date = date.getText();

				
                int idClient = clients.getClientByNom(Client).getId();
                int idCreneau = creneaux.getCreneauById(Integer.parseInt(Creneau)).getId();
                try {
					RV rv = new RV(rvs.getLastId()+1,sdf.parse(Date),idClient, idCreneau);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				date.setText("");
				Removerows(table);
				Addrows(table);
				JOptionPane.showMessageDialog(null,"Bien ajouter");
			}
		});

	}
	
	public void Addrows(JTable table1)
	{
		 DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
		 ClientDao C = new ClientDao();
		 CreneauDao CR = new CreneauDao();
		 MedecinDao M = new MedecinDao();
		 RVDao r = new RVDao();
		 List<Client> clients = C.getAllClients();
		 List<Creneau>  creneaux = CR.getAllCreneaux();
		 List<RV> rendezVous = r.getAllRVs();
		 List<String> prenoms = C.getNomClients();
		 Object rowData[] = new Object[7];
		 for(int i=0 ; i<rendezVous.size();i++)
		 {   
			 rowData[0]= rendezVous.get(i).getId();
			 rowData[1]= sdf.format(rendezVous.get(i).getJour());
			 rowData[2]= CR.getCreneauById(rendezVous.get(i).getId_Creneau()).gethDebut();
			 rowData[3]= CR.getCreneauById(rendezVous.get(i).getId_Creneau()).gethFin();
			 rowData[4]= C.getClientById(rendezVous.get(i).getId_Client()).getNom();
			 rowData[5]= "Doc. "+M.getMedecinById(CR.getCreneauById(rendezVous.get(i).getId_Creneau()).getId_Medecin()).getNom();

			 dtm.addRow(rowData);
			 
			 
		 }
	}
	
	public void Removerows(JTable table1)
	{
		DefaultTableModel dm = (DefaultTableModel) table1.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	
	

}
