package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedecinDao {
	
	private Connection cnx ;
	
	public MedecinDao() {
		this.cnx = connection.getConx();
	}
	
	public List<Medecin> getAllMedecins()
	{
		 List<Medecin> medecins = new ArrayList<Medecin>();
		
		String sql = "select * from medecin";
		try {

			Statement ps = cnx.createStatement() ;
			ResultSet rs = ps.executeQuery(sql);
			Medecin M;
			while(rs.next())
			{   
				M = new Medecin(rs.getInt("id"), rs.getInt("version"),rs.getString("titre"), rs.getString("nom"), rs.getString("prenom"));
				medecins.add(M);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
		
		return medecins;
	}

	
	public void createMedecin(Medecin m)
	{ 
		//insert into data 
		String sql = "insert into medecin values ( '"+m.getVersion()+"','"+m.getTitre()+"','"+m.getNom()+"','"+m.getPrenom()+"')";
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
	
	public void updateMedecin(Medecin m,int Id) {
		String sql="update medecin set version=?, titre=?, nom=?, prenom=? where id=?";

	try {
		PreparedStatement pst=cnx.prepareStatement(sql);

		pst.setInt(1,m.getVersion());
		pst.setString(2,m.getTitre());
		
		pst.setString(3,m.getNom());
		pst.setString(4,m.getPrenom());
		pst.setLong(5, Id);
		pst.execute();

	}catch(Exception e) {System.out.println(e);
	}
	}
   
	public Medecin getMedecinByNom(String nom) {
		String sql="select * from medecin where nom=?";
	try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setString(1,nom);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				Medecin m=new Medecin(rs.getInt("id"), rs.getInt("version"), rs.getString("titre"),rs.getString("nom"),rs.getString("prenom"));
				return m;
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
		return null;	
	}
	
	public Medecin getMedecinById(int Id) {
		String sql="select * from medecin where id=?";
	try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				Medecin m=new Medecin(rs.getInt("id"), rs.getInt("version"), rs.getString("titre"),rs.getString("nom"),rs.getString("prenom"));
				return m;
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
		return null;	
	}
	
	public void deleteMedecin(int Id) {
		String sql="delete from medecin where Id=?";
		try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			pst.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
