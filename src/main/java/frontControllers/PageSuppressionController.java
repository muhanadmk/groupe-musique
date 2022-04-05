package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utile.utilitaire;

public class PageSuppressionController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      if (utilitaire.getPersonnes() != null || !utilitaire.getPersonnes().isEmpty() ) {
        if (!request.getParameterMap().containsKey("personnes")) {
          request.setAttribute("personnes", utilitaire.getPersonnes());
        }
        if (request.getParameterMap().containsKey("idSelectPersonne")) {
          utilitaire.getPersonnes().remove
         (Integer.parseInt(request.getParameter("idSelectPersonne")) - 1);
        }
      }
      return "suppression.jsp";
    }catch(IndexOutOfBoundsException exception){
      request.setAttribute("msgListIsvide", "vous avez pas des personnes a suprimer");
      return "suppression.jsp";
    }
     catch (Exception e) {
      request.setAttribute("msgErr ", e.getCause() + " calas is " + e.getClass());
      return "erreur.jsp";
    }

  }
}
