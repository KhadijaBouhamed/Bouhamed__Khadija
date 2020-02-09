package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
	
private Connection cnx ;
	
	public ClientDao() {
		this.cnx = connection.getConx();

	}
	
	
	public List<Client> getAllClients()
	{
		 List<Client> clients = new ArrayList<Client>();
		
		String sql = "select * from client";
		try {

			Statement ps = cnx.createStatement() ;
			ResultSet rs = ps.executeQuery(sql);
			Client C;
			while(rs.next())
			{   
				C = new Client(rs.getInt("id"), rs.getInt("version"),rs.getString("titre"), rs.getString("nom"), rs.getString("prenom"));
				
					
			  clients.add(C);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
		
		return clients;
	}
	
	
	public void createClient(Client c)
	{ 
		//insert into data 
		String sql = "insert into client values ( '"+c.getVersion()+"','"+c.getTitre()+"','"+c.getNom()+"','"+c.getPrenom()+"')";
		try 
		{
			PreparedStatement ps=cnx.prepareStatement(sql);
			boolean b = ps.execute();
			if(b==true)
				System.out.println("bien ajouter");
			else
				System.out.println("erreur");
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
		
	}
	
	public void updateClient(Client cl,int Id) {
		String sql="update client set version=?, titre=?, nom=?, prenom=? where id=?";

	try {
		PreparedStatement pst=cnx.prepareStatement(sql);

		pst.setInt(1,cl.getVersion());
		pst.setString(2,cl.getTitre());
		
		pst.setString(3,cl.getNom());
		pst.setString(4,cl.getPrenom());
		pst.setLong(5, Id);
		pst.execute();

	}catch(Exception e) {System.out.println(e);
	}
	}
   
	public Client getClientByNom(String nom) {
		String sql="select * from client where nom=?";
	try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setString(1,nom);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				Client c=new Client(rs.getInt("id"), rs.getInt("version"), rs.getString("titre"),rs.getString("nom"),rs.getString("prenom"));
				return c;
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
		return null;	
	}
	
	public Client getClientById(int Id) {
		String sql="select * from client where id=?";
	try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				Client c=new Client(rs.getInt("id"), rs.getInt("version"), rs.getString("titre"),rs.getString("nom"),rs.getString("prenom"));
				return c;
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
		return null;	
	}
	
	public void deleteClient(int Id) {
		String sql="delete from client where Id=?";
		try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			pst.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public int getLastId() {
		
				
				String sql = "select * from client";
				try {

					Statement ps = cnx.createStatement() ;
					ResultSet rs = ps.executeQuery(sql);
					Client C=null;
					while(rs.next())
					{   
						C = new Client(rs.getInt("id"),rs.getInt("version"), rs.getString("titre"),rs.getString("nom"), rs.getString("prenom"));
						
		         
					}
					return C.getId();
					
				}
				catch (Exception e)
				{
					System.out.println(e);
					e.getStackTrace();
				}
				
				return 0;
			}
	
	
	public List<String> getNomClients()
	{
	     
		
		String sql = "select nom from client";
		List<String> prenom =  new ArrayList<String>();
		
		try {

			Statement ps = cnx.createStatement() ;
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next())
			{   
				prenom.add(rs.getString("nom"));
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
		
		return prenom;
	}
	

}
