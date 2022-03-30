package models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Personne {
  @NotNull(message = "Name may not be null")
  @NotEmpty(message = "Name may not be empty")
  private Integer identifiant;
  @NotNull(message = "first name may not be null")
  @NotEmpty(message = "first name may not be empty")
  @Size(max = 30, message = "prenom dois moin que 300")
  @Size(min =2, message = "pernom doit etre plus que 2 lettre")
  private String prenom;
  @NotNull(message = "Name may not be null")
  @NotEmpty(message = "Name may not be empty")
  @Size(max = 30, message = "nom dois moin que 300")
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

  @Override
  public String toString() {
    return "{" +
      " identifiant='" + getIdentifiant() + "'" +
      ", prenom='" + getPrenom() + "'" +
      ", nom='" + getNom() + "'" +
      "}";
  }
}


