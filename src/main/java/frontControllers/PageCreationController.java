package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;
import utile.utilitaire;

public class PageCreationController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      if(request.getParameterMap().containsKey("nom") && 
      request.getParameterMap().containsKey("prenom") ){
        Personne personne = new Personne(request.getParameter("nom"), request.getParameter("prenom"));
        utilitaire.getPersonnes().add(personne);
      }
      return "creeEtModification.jsp";      
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getCause() + " calas is "+ e.getClass()
      + e.getStackTrace());
      return "erreur.jsp";
    }
  }
}
