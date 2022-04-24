/**
 * packge front contrôler qui contient tout les classes
 * qui contrôle les parties front-end de l'application.
 */
package frontControllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoPersonne;
import utile.TokenHelper;

public class PageAccueilController implements ICommand {
  public PageAccueilController(){}
  /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
      PageAccueilController.class.getName());

  /**
   * Méthode pour aficher la page de Accueil.
   * 
   * @param request  request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return le parm vers la page index de de la site
   * @throws Exception objet de classe Exception
   */
  public String execute(final HttpServletRequest request,
      final HttpServletResponse response) throws Exception {
        
    try {
      if (!request.getParameterMap().containsKey("personnes")) {
        request.setAttribute("personnes", DaoPersonne.findAll());
        request.setAttribute("personnesSize", DaoPersonne.findAll().size());
      }
      request.setAttribute("token", TokenHelper.getC_token());
      return "list.jsp";
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getMessage());
      LOGGER.warning(e.getMessage());
      return "erreur.jsp";
    }
  }

}
