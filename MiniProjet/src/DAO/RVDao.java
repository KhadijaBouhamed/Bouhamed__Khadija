package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RVDao {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Connection cnx ;
	
	public RVDao() {
		this.cnx = connection.getConx();
	}
	
	public List<RV> getAllRVs()
	{
		 List<RV> RVs = new ArrayList<RV>();
		
		String sql = "select * from rv";
		try {

			Statement ps = cnx.createStatement() ;
			ResultSet rs = ps.executeQuery(sql);
			RV rv;
			while(rs.next())
			{   
				rv = new RV(rs.getInt("id"),sdf.parse(rs.getString("jour")), rs.getInt("id_Client"), rs.getInt("id_Creneau"));
				RVs.add(rv);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
		
		return RVs;
	}
	
	
	public void createRV(RV rv)
	{ 
		//insert into data 
		String sql = "insert into rv values ( '"+sdf.format(rv.getJour())+"','"+rv.getId_Client()+"','"+rv.getId_Creneau()+"')";
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
	
	public void updateRV(RV rv,int Id) {
		String sql="update rv set jour=?, id_Client=?, id_Creneau=? where id=?";

	try {
		PreparedStatement pst=cnx.prepareStatement(sql);

		pst.setString(1,sdf.format(rv.getJour()));
		pst.setInt(2,rv.getId_Client());	
		pst.setInt(3,rv.getId_Creneau());
		pst.setLong(5, Id);
		pst.execute();

	}catch(Exception e) {System.out.println(e);
	}
	}
   
	public RV getRVById(int Id) {
		String sql="select * from rv where id=?";
	try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				RV rv=new RV(rs.getInt("id"), sdf.parse(rs.getString("jour")), rs.getInt("id_Client"), rs.getInt("id_Creneau"));
				return rv;
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
		return null;	
	}
	
	public void deleteRV(int Id) {
		String sql="delete from rv where Id=?";
		try {
			PreparedStatement pst=cnx.prepareStatement(sql);
			pst.setInt(1,Id);
			pst.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public int getLastId() {
	
				
				String sql = "select * from rv";
				try {

					Statement ps = cnx.createStatement() ;
					ResultSet rs = ps.executeQuery(sql);
					RV r=null;
					while(rs.next())
					{   
						r = new RV(rs.getInt("id"),sdf.parse(rs.getString("jour")), rs.getInt("id_Client"),rs.getInt("id_Creneau"));
						
		         
					}
					return r.getId();
					
				}
				catch (Exception e)
				{
					System.out.println(e);
					e.getStackTrace();
				}
				
				return 0;
			}
	
}
