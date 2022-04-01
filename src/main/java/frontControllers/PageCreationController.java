package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;
import utile.utilitaire;

public class PageCreationController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(request.getParameter("nom") != null && request.getParameter("prenom") != null ){
      Personne personne = new Personne(request.getParameter("nom"), request.getParameter("prenom"));
      utilitaire.getPersonnes().add(personne);
      request.setAttribute("personne", personne);
    }
    return "creation.jsp";
  }
}
