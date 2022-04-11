package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utile.utilitaire;

public class PageSuppressionController implements ICommand {
  /**
   * méthode pour Supprimer les personnes de  l'arrylist pour les afficher.
   * @param request request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return le parm vers la page jsp de suppression
   * @throws Exception objet de classe Exception
   */
  public String execute(final HttpServletRequest request,
   final HttpServletResponse response) throws Exception {
    try {
      HttpSession session = request.getSession();
      if (session.getAttribute("compteurPage") == null) {
        session.setAttribute("compteurPage", 0);
      } else {
        Integer compteurPage = (Integer) session.getAttribute("compteurPage");
        compteurPage++;
        session.setAttribute("compteurPage", compteurPage);
      }
      if (utilitaire.getPersonnes() != null
       || !utilitaire.getPersonnes().isEmpty()) {
        if (!request.getParameterMap().containsKey("personnes")) {
          request.setAttribute("personnes", utilitaire.getPersonnes());
        }
        if (request.getParameterMap().containsKey("idSelectPersonne")) {
          utilitaire.getPersonnes()
          .remove(Integer.parseInt(
          request.getParameter("idSelectPersonne"))-1);
        }
      }
      return "suppression.jsp";
    } catch (IndexOutOfBoundsException exception) {
      request.setAttribute("msgListIsvide",
      "vous avez pas des personnes a suprimer");
      return "suppression.jsp";
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getCause() + " calas is "
       + e.getClass());
      return "erreur.jsp";
    }

  }
}
