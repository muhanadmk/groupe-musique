package models.forms;

import javax.servlet.http.HttpServletRequest;

public class SaisiePersonForm {

  /**
   * propreté qui Stoke la msg de err ou reste vide.
   */
  private String resultat = "";

  /**
   * constructeur de la class.
   */
  public SaisiePersonForm() {
  }

  /**
   * Méthode vérifiée la saisie pour qu'ils ne soient pas
   * identiques pour le nom et le prénom.
   * s'il trouve identiques, il va appeler le méthode
   * setReuslat pour écrire le message d'erreur.
   * @param request objet de classe HttpServletRequest
   */
  public void verifForm(final HttpServletRequest request) {
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");
    if (nom.toUpperCase().equals(prenom.toUpperCase())
        || nom.toLowerCase().equals(prenom.toLowerCase())) {
      setResultat("le nom : ( " + nom + " ) et le prénom : ( " + prenom + " )"
          + " ne doit pas etre identiques");
    }
  }

  /**
   * Get msg err.
   * @return msg err String.
   */
  public final String getResultat() {
    return resultat;
  }

  /**
   * set msg err.
   * @param resultatPString set msg err.
   */
  public final void setResultat(final String resultatPString) {
    this.resultat = resultatPString;
  }

}
