package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {

	public static void main(String[] args) throws ParseException {
		 
		/*Medecin m = new Medecin(1, 678, "LFT" ,"Bouhamed", "khadija");
		MedecinDao cl1 = new MedecinDao();
        cl1.createMedecin(m);*/
		
		UserDao user = new UserDao();
		System.out.println(user.Authentifier("Bouhamed", "12345678"));
		
	}

}
