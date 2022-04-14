package frontControllers;

import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import dao.DaoPersonne;
import models.Personne;
import models.forms.SaisiePersonForm;

public class PageCreationController implements ICommand {
  /**
   * Méthode pour Cree les personnes et les stocker dans arrylist.
   * 
   * @param request  request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return le parm vers la page jsp de creeEtModification
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
    try {
      if (request.getParameterMap().containsKey("nom")
          && request.getParameterMap().containsKey("prenom")) {
        Personne personne = new Personne(request.getParameter("nom"),
            request.getParameter("prenom"));
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = (Validator) factory.getValidator();
        Set<ConstraintViolation<Personne>> errorsValidation = validator.validate(personne);
        if (errorsValidation.isEmpty()) {
          SaisiePersonForm saisiePersonForm = new SaisiePersonForm();
          saisiePersonForm.verifForm(request);
          String resultat = saisiePersonForm.getResultat();
          if (!resultat.trim().isEmpty()) {
            request.setAttribute("personneselectionne", personne);
            request.setAttribute("errSaisiePersonForm", resultat);
          } else {
            DaoPersonne.save(personne);
          }
        } else {
          ArrayList<String> msgErrBeans= new ArrayList<String>();
          for (ConstraintViolation<Personne> errorValidation : errorsValidation) {
            msgErrBeans.add(
                          "(" + errorValidation.getInvalidValue() + ")" +
                          "" + errorValidation.getMessage());
          }
          request.setAttribute("personneselectionne", personne);
          msgErrBeans.toString().substring(1, msgErrBeans.toString().length() - 1);
          request.setAttribute("errSaisiePersonForm", msgErrBeans);
        }
      }
      request.setAttribute("creation", "creation");
      return "creeEtModification.jsp";
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getCause() + " calas is "
          + e.getClass());
      return "erreur.jsp";
    }
  }
}
