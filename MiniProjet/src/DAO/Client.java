package DAO;

public class Client {

	
	private int id;
	private int version;
	private String titre;
	private String nom;
	private String prenom;
	
	
	public Client(int id, int version, String titre, String nom, String prenom) {
		this.setId(id);
		this.version = version;
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
