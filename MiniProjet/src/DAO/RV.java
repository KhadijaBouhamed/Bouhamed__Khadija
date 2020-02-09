package DAO;

import  java.util.Date;

public class RV {
	
	private int id;
	private Date jour;
	private int id_Client;
	private int id_Creneau;
	
	public RV(int id, Date jour, int id_Client, int id_Creneau) {
		this.id = id;
		this.jour = jour;
		this.id_Client = id_Client;
		this.id_Creneau = id_Creneau;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getJour() {
		return jour;
	}
	public void setJour(Date jour) {
		this.jour = jour;
	}
	public int getId_Client() {
		return id_Client;
	}
	public void setId_Client(int id_Client) {
		this.id_Client = id_Client;
	}
	public int getId_Creneau() {
		return id_Creneau;
	}
	public void setId_Creneau(int id_Creneau) {
		this.id_Creneau = id_Creneau;
	}
	
	

}
