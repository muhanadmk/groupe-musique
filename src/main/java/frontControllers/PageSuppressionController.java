package frontControllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoPersonne;

public class PageSuppressionController implements ICommand {
  public PageSuppressionController(){}

    /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
    PageSuppressionController.class.getName());

  /**
   * méthode pour Supprimer les personnes de l'arrylist pour les afficher.
   * @param request  request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return le parm vers la page jsp de suppression
   * @throws Exception objet de classe Exception
   */
  public String execute(final HttpServletRequest request,
      final HttpServletResponse response) throws Exception {
    try {
      if (!DaoPersonne.findAll().isEmpty()) {
          request.setAttribute("personnes", DaoPersonne.findAll());
          request.setAttribute("listSuprimVide", "");
        if (request.getParameterMap().containsKey("idSelectPersonne")) {
          DaoPersonne.delete(Integer.parseInt(
            request.getParameter("idSelectPersonne")));
          request.setAttribute("personnes", DaoPersonne.findAll());
          request.setAttribute("personnesSize", DaoPersonne.findAll().size());
          return "list.jsp";
        }
      } else {
        request.setAttribute("listSuprimVide",
         "Vous n'avez pas des adhérents à supprimer.");
      }
      return "suppression.jsp";
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getMessage());
      LOGGER.warning(e.getMessage());
      return "erreur.jsp";
    }
  }
}
