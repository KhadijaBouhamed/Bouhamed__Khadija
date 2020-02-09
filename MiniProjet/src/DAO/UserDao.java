package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
private Connection cnx ;
	
	public UserDao() {
		
		this.cnx = connection.getConx();
	}
	
	public boolean Authentifier(String name,String pass) {
		
		String sql="select userName,password from Admin where userName=?";
		try {
				PreparedStatement pst=cnx.prepareStatement(sql);
				pst.setString(1,name);
				ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					return rs.getString("password").equals(pass);
					
				}
			}catch(Exception e) {
				System.out.println(e);
			}	
			return false;	
	}

}
