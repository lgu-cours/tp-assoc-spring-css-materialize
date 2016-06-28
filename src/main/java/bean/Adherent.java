package bean;

public class Adherent {
	
	private String nom ;
	private String prenom ;
	
	private String adresse ;
	private String codepost ;
	private String ville ;
	private String codepays ;
	
	private String ident ;
	private String motpasse ;

	public Adherent(String nom, String prenom, String adresse, String codepost, String ville, String codepays) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codepost = codepost;
		this.codepays = codepays;
	}

	public Adherent(String nom, String prenom, String adresse, String codepost, String ville, String codepays, String ident, String motpasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codepost = codepost;
		this.ville = ville;
		this.codepays = codepays;
		this.ident = ident;
		this.motpasse = motpasse;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodepays() {
		return codepays;
	}
	public void setCodepays(String codepays) {
		this.codepays = codepays;
	}
	public String getCodepost() {
		return codepost;
	}
	public void setCodepost(String codepost) {
		this.codepost = codepost;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String v) {
		this.ident = v;
	}
	public String getMotpasse() {
		return motpasse;
	}
	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	
}
