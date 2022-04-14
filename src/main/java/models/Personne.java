package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "personne")
public class Personne {
  /**
   * identifiant may not be null.
   * identifiant may not be empty.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idpersonne")
  private Integer identifiant;
 /**
   * first name may not be null.
   * first name may not be empty.
   * size doit etre moins de 30 et puls 2.
   */
  @Column(name = "prenom" ,length = 30, nullable = false)
  @NotNull(message = "prenom dois pas etre null")
  @NotEmpty(message = "prenom dois pas etre empty")
  @Size(max = 30, message = "prenom dois moin que 30")
  @Size(min = 2, message = "pernom doit etre plus que 2 lettre")
  private String prenom;

  /**
   *  name may not be null.
   *  name may not be empty.
   * size doit etre moins de 30 et puls 2.
   */
  @Column(name = "nom" ,length = 30, nullable = false, unique = true)
  @NotNull(message = "nom dois pas etre null")
  @NotEmpty(message = "nom dois pas etre empty")
  @Size(max = 30, message = "nom dois moin que 30")
  @Size(min = 2, message = "nom doit etre plus que 2 lettre")
  private String nom;

/**
 * constructeur implicit.
 */
  public Personne() { }

  /**
   * constructeur de la classe personne.
   * @param nomPersonne String nom de Personne
   * @param prenomPersonne String prenom de Personne
   */
  public Personne(final String nomPersonne,
   final String prenomPersonne) {
    setNom(nomPersonne);
    setPrenom(prenomPersonne);
  }

  /**
   * pour set le nom.
   * @param nomPersonne String nom de Personne.
   */
  public void setNom(final String nomPersonne) {
    this.nom = nomPersonne;
  }
  /**
   * pour get le nom.
   * @return String nom de Personne.
   */
  public String getNom() {
    return nom;
  }

  /**
   * set id de Personne.
   * @param identifiantPersonne id de pour set le identifiant Personne.
   */
  public void setIdentifiant(final int identifiantPersonne) {
    this.identifiant = identifiantPersonne;
  }
  /**
   * get id de Personne.
   * @return id de Personne
   */

  public int getIdentifiant() {
    return identifiant;
  }
  /**
   * pour get le prenom.
   * @return String prenom de Personne.
   */

  public String getPrenom() {
    return prenom;
  }
  /**
   * pour set le prenom de Personne.
   * @param prenomPersonne de Personne
   */
  public void setPrenom(final String prenomPersonne) {
    this.prenom = prenomPersonne;
  }
  @Override
  public final String toString() {
    return "{"
    +  " identifiant='" + getIdentifiant()
    + ", prenom='" + getPrenom()
    + ", nom='" + getNom()
    +  "}";
  }
}


