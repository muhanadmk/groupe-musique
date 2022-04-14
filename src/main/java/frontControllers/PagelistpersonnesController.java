package frontControllers;


import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoPersonne;
import models.Personne;

public class PagelistpersonnesController implements ICommand {
  private static final Logger LOGGER = Logger.getLogger(PagelistpersonnesController.class.getName());
  /**
   * Méthode pour télécharger les personnes et
   * les stocker dans arrylist pour les afficher.
   * 
   * @param request  request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return le parm vers la page jsp de liste de persoones
   * @throws Exception objet de classe Exception
   *
   */
  public String execute(final HttpServletRequest request,
      final HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    try {
    if (session.getAttribute("compteurPage") == null) {
      session.setAttribute("compteurPage", 0);
    } else {
      Integer compteurPage = (Integer) session.getAttribute("compteurPage");
      compteurPage++;
      session.setAttribute("compteurPage", compteurPage);
    }
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("prenom")) {
          request.setAttribute("Monprenom", cookie.getValue());
        }
      }
    }
    
      if (!DaoPersonne.findAll().isEmpty()) {
        request.setAttribute("personnes", DaoPersonne.findAll());
        request.setAttribute("personnesSize", DaoPersonne.findAll().size());
      }
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getMessage());
      LOGGER.warning(e.getMessage());
      return "erreur.jsp";
    }
    return "list.jsp";
  }
}
