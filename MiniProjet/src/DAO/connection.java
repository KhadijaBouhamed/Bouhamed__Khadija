package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	

		private static Connection cnx ;
		
        static {
        	String url = "jdbc:sqlserver://USER-PC\\SQLEXPRESS;"+"databaseName=cabinetMedicale;integratedSecurity=true";

			try {
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 cnx = DriverManager.getConnection(url);
				 System.out.println("connecter avec succes");
			}
			catch (Exception e)
			{
				 System.out.println(e);
			}

        }
        
        public static Connection getConx() {
        	return cnx;
        }
		

}
