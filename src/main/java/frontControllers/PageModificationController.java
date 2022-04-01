package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;
import utile.utilitaire;

public class PageModificationController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getParameterMap().containsKey("idModifier")) {
      Personne personne = utilitaire.getPersonnes().get(Integer.parseInt(request.getParameter("idModifier")) -1);
      personne.setNom(request.getParameter("nom"));
      personne.setPrenom(request.getParameter("prenom"));
    }
    if (request.getParameterMap().containsKey("choisirPersonne")) {
      Personne personne = utilitaire.getPersonnes().get(Integer.parseInt(request.getParameter("choisirPersonne")) -1);
      request.setAttribute("personneselectionne", personne);
    }if(!request.getParameterMap().containsKey("idModifier") && !request.getParameterMap().containsKey("personneselectionne")
     && !request.getParameterMap().containsKey("choisirPersonne")){
      request.setAttribute("personnes", utilitaire.getPersonnes());
    }
    return "modification.jsp";
  }
}
