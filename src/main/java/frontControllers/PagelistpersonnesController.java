package frontControllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Personne;
import utile.utilitaire;

public class PagelistpersonnesController implements ICommand {
  /**
   * Méthode pour télécharger les personnes et
   * les stocker dans arrylist pour les afficher.
   * @param request  request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return le parm vers la page jsp de liste de persoones
   * @throws Exception objet de classe Exception
   *
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
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("prenom")) {
          request.setAttribute("Monprenom", cookie.getValue());
        }
      }
    }
    if (utilitaire.getPersonnes().isEmpty()) {
      Personne personne = new Personne("mazen", "a");
      Personne personne2 = new Personne("ahmed", "b");
      Personne personne3 = new Personne("sham", "c");
      utilitaire.getPersonnes().add(personne);
      utilitaire.getPersonnes().add(personne2);
      utilitaire.getPersonnes().add(personne3);
      request.setAttribute("personnes", utilitaire.getPersonnes());
      request.setAttribute("personnesSize", utilitaire.getPersonnes().size());
    } else {
      request.setAttribute("personnes", utilitaire.getPersonnes());
      request.setAttribute("personnesSize", utilitaire.getPersonnes().size());
    }
    return "list.jsp";
  }
}
