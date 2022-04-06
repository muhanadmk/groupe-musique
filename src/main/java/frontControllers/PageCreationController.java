package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;
import models.forms.SaisiePersonForm;
import utile.utilitaire;

public class PageCreationController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      if(request.getParameterMap().containsKey("nom") && 
      request.getParameterMap().containsKey("prenom") ){
        Personne personne = new Personne(request.getParameter("nom"), request.getParameter("prenom"));
        SaisiePersonForm saisiePersonForm = new SaisiePersonForm();
        saisiePersonForm.verifForm(request);
        String resultat = saisiePersonForm.getResultat();
        if (resultat != null) {
          request.setAttribute("personneselectionne", personne);
          request.setAttribute("errSaisiePersonForm", resultat);
        }else{   
          utilitaire.getPersonnes().add(personne);
        }
      }
      request.setAttribute("creation", "creation");
      return "creeEtModification.jsp";      
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getCause() + " calas is "+ e.getClass()
      + e.getStackTrace());
      return "erreur.jsp";
    }
  }
}
