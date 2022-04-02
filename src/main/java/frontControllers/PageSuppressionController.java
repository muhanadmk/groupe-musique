package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utile.utilitaire;

public class PageSuppressionController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getParameterMap().containsKey("choisirPersonne")) {
      utilitaire.getPersonnes().remove(Integer.parseInt(request.getParameter("choisirPersonne")) -1);
    }if(!request.getParameterMap().containsKey("choisirPersonne")){
      request.setAttribute("personnes", utilitaire.getPersonnes());
    }
    return "suppression.jsp";
  }
}
