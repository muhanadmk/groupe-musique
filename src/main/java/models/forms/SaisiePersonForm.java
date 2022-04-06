package models.forms;

import javax.servlet.http.HttpServletRequest;

public class SaisiePersonForm {
  private String resultat ="";

  public SaisiePersonForm() {
  }

  public void verifForm(HttpServletRequest request) {
    String nom = request.getParameter("nom"); 
    String prenom = request.getParameter("prenom"); 
    if (nom.toUpperCase().equals(prenom.toUpperCase())
      || nom.toLowerCase().equals(prenom.toLowerCase())
    ) {
      setResultat("le nom et le prénom ne doit pas etre identiques");
    }
  }

  public String getResultat() {
    return resultat;
  }

  public void setResultat(String resultat) {
    this.resultat = resultat;
  }

}
