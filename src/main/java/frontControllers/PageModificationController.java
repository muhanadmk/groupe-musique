package frontControllers;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

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

public class PageModificationController implements ICommand {
  public PageModificationController(){}

    /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
    PageModificationController.class.getName());

  /**
   * Méthode pour modifier les personnes et les stocker dans arrylist.
   *
   * @param request  request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return return le parm vers la page jsp de liste de creeEtModification
   * @throws Exception objet de classe Exception
   */
  public String execute(final HttpServletRequest request,
      final HttpServletResponse response) throws Exception {
    try {
      if (!request.getParameterMap().containsKey("personnes")
      && !request.getParameterMap().containsKey("idSelectPersonne")
      && !request.getParameterMap().containsKey("errSaisiePersonForm")) {
        if (!DaoPersonne.findAll().isEmpty()) {
          request.setAttribute("personnes", DaoPersonne.findAll());
          request.setAttribute("listModifVide", "");
        } else {
          request.setAttribute("listModifVide",
          "Vous n'avez pas des adhérents à modifier.");
        }
      }
      if (request.getParameterMap().containsKey("idSelectPersonne")) {
        Personne personne = DaoPersonne.findPersonById(
          Integer.parseInt(request.getParameter("idSelectPersonne")));
        request.setAttribute("personneselectionne", personne);
      }
      if (request.getParameterMap().containsKey("idModifier")) {
        Personne personne = DaoPersonne.findPersonById(
          Integer.parseInt(request.getParameter("idModifier")));
        String nom = personne.getNom();
        String prenom = personne.getPrenom();
        personne.setNom(request.getParameter("nom"));
        personne.setPrenom(request.getParameter("prenom"));
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = (Validator) factory.getValidator();
        Set<ConstraintViolation<Personne>> errorsValidation
         = validator.validate(personne);
        if (errorsValidation.isEmpty()) {
          SaisiePersonForm saisiePersonForm = new SaisiePersonForm();
          saisiePersonForm.verifForm(request);
          String resultat = saisiePersonForm.getResultat();
          if (!resultat.trim().isEmpty()) {
            personne.setNom(nom);
            personne.setPrenom(prenom);
            request.setAttribute("personneselectionne", personne);
            request.setAttribute("errSaisiePersonForm", resultat);
          } else {
            DaoPersonne.save(personne);
            request.setAttribute("personnes", DaoPersonne.findAll());
            request.setAttribute("personnesSize", DaoPersonne.findAll().size());
            return "list.jsp";
          }
        } else {
          ArrayList<String> msgErrBeans = new ArrayList<String>();
          personne.setNom(nom);
          personne.setPrenom(prenom);
          for (ConstraintViolation<Personne>
          errorValidation : errorsValidation) {
            msgErrBeans.add("La value que vous essaye de l'insere "
                + "( " + errorValidation.getInvalidValue() + " )"
                + "" + errorValidation.getMessage());
          }
          request.setAttribute("personneselectionne", personne);
          request.setAttribute("errSaisiePersonForm",
              msgErrBeans.toString().substring(
                1, msgErrBeans.toString().length() - 1));
        }
      }
      return "creeEtModification.jsp";
    } catch (Exception e) {
      request.setAttribute("msgErr", e.getMessage());
      LOGGER.warning(e.getMessage());
      return "erreur.jsp";
    }
  }
}
