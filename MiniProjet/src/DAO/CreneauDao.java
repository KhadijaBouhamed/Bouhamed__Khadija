package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreneauDao {
private Connection cnx ;
	
	public CreneauDao() {
		
		this.cnx = connection.getConx();
	}
	
	public List<Creneau> getAllCreneaux()
	{
		 List<Creneau> Creneaux = new ArrayList<Creneau>();
		
		String sql = "select * from creneau";
		try {

			Statement ps = cnx.createStatement() ;
			ResultSet rs = ps.executeQuery(sql);
			Creneau c;
			while(rs.next())
			{   
				c = new Creneau(rs.getInt("id"), rs.getInt("version"),rs.getInt("hDebut"), rs.getInt("mDebut"), rs.getInt("hFin"), rs.getInt("mFin"), rs.getInt("id_Medecin"));
				Creneaux.add(c);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
		
		return Creneaux;
	}
	
	
	public void createCreneau(Creneau c)
	{ 
		//insert into data 
		String sql = "insert into creneau values ( '"+c.getVersion()+"','"+c.gethDebut()+"','"+c.getmDebut()+"','"+c.gethFin()+"','"+c.getmFin()+"','"+c.getId_Medecin()+"')";
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

	
	public void updateCreneau(Creneau c,int Id) {
		String sql="update creneau set version=?, hDebut=?, mDebut=?, hFin=?, mDebut=?, id_Medecin=? where id=?";

	try {
		PreparedStatement pst=cnx.prepareStatement(sql);

		pst.setInt(1,c.getVersion());
		pst.setInt(2,c.gethDebut());
		pst.setInt(3,c.getmDebut());
		pst.setInt(4,c.gethFin());
		pst.setInt(5,c.getmFin());
		pst.setInt(6,c.getId_Medecin());
		pst.setLong(7, Id);
		pst.execute();

	}catch(Exception e) {System.out.println(e);
	}
	}
  
	public Creneau getCreneauById(int Id) {
		String sql="select * from creneau where id=?";
	try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				Creneau c=new Creneau(rs.getInt("id"), rs.getInt("version"),rs.getInt("hDebut"), rs.getInt("mDebut"), rs.getInt("hFin"), rs.getInt("mFin"), rs.getInt("id_Medecin"));
				return c;
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
		return null;	
	}
	
	public void deleteCreneau(int Id) {
		String sql="delete from creneau where Id=?";
		try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			pst.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public List<Integer> getIds()
	{
	     
		
		String sql = "select id from creneau";
		List<Integer> ids =  new ArrayList<Integer>();
		
		try {

			Statement ps = cnx.createStatement() ;
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next())
			{   
				int id = rs.getInt("id");
				ids.add(id);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
		
		return ids;
	}
	
	
	public Creneau getCreneauByPeriode(String per) {
		String[] debutFin = per.split("-");
		String sql="select hDebut, hFin from client where hDebut=? and hFin=?";
	try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Integer.parseInt(debutFin[0]));
			pst.setInt(2,Integer.parseInt(debutFin[1]));
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				Creneau c=new Creneau(rs.getInt("id"), rs.getInt("version"), rs.getInt("hDebut"),rs.getInt("mDebut"),rs.getInt("hFin"), rs.getInt("mFin"), rs.getInt("id_Medecin"));
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
}
