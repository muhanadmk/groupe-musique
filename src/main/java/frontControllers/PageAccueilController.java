/**
 * packge front contrôler qui contient tout les classes
 * qui contrôle les parties front-end de l'application.
 */
package frontControllers;



import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoPersonne;
import models.Personne;

public class PageAccueilController implements ICommand {
  private static final Logger LOGGER =   Logger.getLogger(PageAccueilController.class.getName());
  /**
   * Méthode pour aficher la page de Accueil.
   * @param request request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return le parm vers la page index de de la site
   * @throws Exception objet de classe Exception
   */
  public String execute(final HttpServletRequest request,
   final HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    if (session.getAttribute("compteurPage") == null) {
      session.setAttribute("compteurPage", 0);
    } else {
      Integer compteurPage = (Integer) session.getAttribute("compteurPage");
      compteurPage++;
      session.setAttribute("compteurPage", compteurPage);
    }
    Cookie cookie = new Cookie("prenom", "muhanad");
    cookie.setMaxAge(60*60*24);
    response.addCookie(cookie);
    return "index.jsp";
  }
}
