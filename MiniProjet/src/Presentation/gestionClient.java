package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Client;
import DAO.ClientDao;


public class gestionClient extends JPanel {


	private JTextField textField;
	private JTable table;
	/**
	 */
	public gestionClient() {
		
		this.setBounds(245, 47, 539, 388);
		this.setBackground(new Color(55, 139, 201));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chercher");
		lblNewLabel.setBounds(122, 25, 70, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(174, 23, 189, 17);
		add(textField);
		textField.setColumns(10);
		
		Object[] title = {"Id", "Version", "Titre", "Nom", "Prenom"};
		DefaultTableModel dtm = new DefaultTableModel();
	    dtm.setColumnIdentifiers(title);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 517, 228);
		add(scrollPane);
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		Addrows(table);
		
		ajouterClient ajouter = new ajouterClient();
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(21, 303, 89, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter.show();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Modefier");
		btnNewButton_1.setBounds(146, 303, 102, 23);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int i=-1;
				i = table.getSelectedRow();
				if(i != -1) {
				ClientDao clients = new ClientDao();
				Client c = new Client(Integer.parseInt(dtm.getValueAt(i, 0).toString()),Integer.parseInt(dtm.getValueAt(i, 1).toString()),dtm.getValueAt(i, 2).toString(),dtm.getValueAt(i, 3).toString(),dtm.getValueAt(i, 4).toString());
				clients.updateClient(c, Integer.parseInt(dtm.getValueAt(i, 0).toString()));
				Removerows(table);
				Addrows(table);
				JOptionPane.showMessageDialog(null,"Bien Modifier");
				}
				else {
					JOptionPane.showMessageDialog(null,"selecter une ligne");
				}
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(274, 303, 102, 23);
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int i=-1;
				i = table.getSelectedRow();
				if(i != -1) {
				ClientDao clients = new ClientDao();
				clients.deleteClient(Integer.parseInt(dtm.getValueAt(i, 0).toString()));
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
		
		JButton btnActualiser = new JButton("actualiser");
		btnActualiser.setBounds(397, 303, 89, 23);
		add(btnActualiser);
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Removerows(table);
				Addrows(table);
			}
			
		});

	}
	
	public void Addrows(JTable table1)
	{
		 DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
		 ClientDao C = new ClientDao();
		 List<Client> clients  = C.getAllClients();
		 Object rowData[] = new Object[6];
          
		 for(int i=0 ; i<clients.size();i++)
		 {   
			 
			 rowData[0]=clients.get(i).getId();
			 rowData[1]=clients.get(i).getVersion();
			 rowData[2]=clients.get(i).getTitre();
			 rowData[3]=clients.get(i).getNom();
			 rowData[4]=clients.get(i).getPrenom();
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
