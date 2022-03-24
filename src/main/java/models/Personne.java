package models;

public class Personne {
  private int identifiant;
  private String prenom;
  private String nom;


  public Personne(){}

  public Personne(int identifiant, String nom, String prenom){
    setIdentifiant(identifiant);
    setNom(nom);
    setPrenom(prenom);
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
  public String getNom() {
    return nom;
  }
  public void setIdentifiant(int identifiant) {
    this.identifiant = identifiant;
  }
  public String getPrenom() {
    return prenom;
  }
  public int getIdentifiant() {
    return identifiant;
  }
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

}
