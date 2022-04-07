package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Personne;
import models.forms.SaisiePersonForm;
import utile.utilitaire;

public class PageModificationController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    if (session.getAttribute("compteurPage") == null) {
      session.setAttribute("compteurPage", 0);
    }else{
      Integer compteurPage = (Integer) session.getAttribute("compteurPage");
      compteurPage++;
      session.setAttribute("compteurPage", compteurPage);
    }
    try {
      if (!request.getParameterMap().containsKey("personnes")
          && !request.getParameterMap().containsKey("idSelectPersonne")
          && !request.getParameterMap().containsKey("errSaisiePersonForm")) {
        request.setAttribute("personnes", utilitaire.getPersonnes());
      }
      if (request.getParameterMap().containsKey("idSelectPersonne")) {
        Personne personne = utilitaire.getPersonnes()
            .get(Integer.parseInt(request.getParameter("idSelectPersonne")) - 1);
        request.setAttribute("personneselectionne", personne);
      }
      if (request.getParameterMap().containsKey("idModifier")) {
        Personne personne = utilitaire.getPersonnes()
            .get(Integer.parseInt(request.getParameter("idModifier")) - 1);
        Personne personneAvantModif = personne;
        SaisiePersonForm saisiePersonForm = new SaisiePersonForm();
        saisiePersonForm.verifForm(request);
        String resultat = saisiePersonForm.getResultat();
        if (!resultat.trim().isEmpty()) {
          request.setAttribute("personneselectionne", personneAvantModif);
          request.setAttribute("errSaisiePersonForm", resultat);
        } else {
          personne.setNom(request.getParameter("nom"));
          personne.setPrenom(request.getParameter("prenom"));
          utilitaire.getPersonnes().add(personne);
        }
      }
      return "creeEtModification.jsp";
    } catch (Exception e) {
      request.setAttribute("msgErr ", e.getCause() + " calas is " + e.getClass());
      return "erreur.jsp";
    }
  }
}
