package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groupes")
public class Groupe {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idgroupe")
  private Integer id;

  @Column(name = "nomgroupe",nullable=false)
  private String nomGroupe;


  // @OneToMany(cascade = CascadeType.ALL)
  // private List<Personne> personnes = new ArrayList<Personne>();  

  public Groupe() {
  }


  public Groupe(Integer id, String nomGroupe) {
    //this.id = id;
    this.nomGroupe = nomGroupe;
  }

  // public Groupe(Integer id, String nomGroupe, List<Personne> personnes) {
  //  // this.id = id;
  //   this.nomGroupe = nomGroupe;
  //   this.personnes = personnes;
  // }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNomGroupe() {
    return this.nomGroupe;
  }

  public void setNomGroupe(String nomGroupe) {
    this.nomGroupe = nomGroupe;
  }

  // public List<Personne> getPersonnes() {
  //   return this.personnes;
  // }

  // public void setPersonnes(List<Personne> personnes) {
  //   this.personnes = personnes;
  // }

  

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nomGroupe='" + getNomGroupe() + "'" +
      "}";
  }
  

}
