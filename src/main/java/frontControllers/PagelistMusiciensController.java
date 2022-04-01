package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;
import utile.utilitaire;

public class PagelistMusiciensController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if ( utilitaire.getPersonnes().size() == 0 ) {
      Personne personne = new Personne( "mazen", "a");
      Personne personne2 = new Personne("ahmed", "b");
      Personne personne3 = new Personne("sham", "c");
      utilitaire.getPersonnes().add(personne);
      utilitaire.getPersonnes().add(personne2);
      utilitaire.getPersonnes().add(personne3);
      request.setAttribute("personnes", utilitaire.getPersonnes());
      request.setAttribute("personnesSize", utilitaire.getPersonnes().size());
    }else{
      request.setAttribute("personnes", utilitaire.getPersonnes());
      request.setAttribute("personnesSize", utilitaire.getPersonnes().size());
    }
    return "liste.jsp";
  }
}
