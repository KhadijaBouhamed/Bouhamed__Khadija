package DAO;

public class Creneau {
	  
	private int id;
	private int version;
	private int hDebut;
	private int mDebut;
	private int hFin;
	private int mFin;
	private int id_Medecin;
	
	public Creneau(int id, int version, int hDebut, int mDebut, int hFin, int mFin, int Medecin) {
		
		this.id= id;
		this.version = version;
		this.hDebut = hDebut;
		this.mDebut = mDebut;
		this.hFin = hFin;
		this.mFin = mFin;
		this.id_Medecin = Medecin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int gethDebut() {
		return hDebut;
	}
	public void sethDebut(int hDebut) {
		this.hDebut = hDebut;
	}
	public int getmDebut() {
		return mDebut;
	}
	public void setmDebut(int mDebut) {
		this.mDebut = mDebut;
	}
	public int gethFin() {
		return hFin;
	}
	public void sethFin(int hFin) {
		this.hFin = hFin;
	}
	public int getId_Medecin() {
		return id_Medecin;
	}
	public void setId_Medecin(int id_Medecin) {
		this.id_Medecin = id_Medecin;
	}
	public int getmFin() {
		return mFin;
	}
	public void setmFin(int mFin) {
		this.mFin = mFin;
	}

}
