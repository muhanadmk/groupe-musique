package frontControllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoPersonne;
import dao.DaoUser;
import models.User;
import models.forms.UserFrom;
import servlet.Servlet;

public class PageLogInController implements ICommand {
  public PageLogInController(){}

  /**
 * LOGGER.
 */
private static final Logger LOGGER = Logger.getLogger(
  PageLogInController.class.getName());

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getParameterMap().containsKey("user")
        && request.getParameterMap().containsKey("password")) {
      HttpSession session = request.getSession();
      User user = DaoUser.findUserByName(request.getParameter("user"));
      String passwordBd = UserFrom.getSecurePassword(request.getParameter("password"), user.getSel());
      if (user.getPassword().equals(passwordBd)) {
        session.setAttribute("admin", "admin");
         if (!request.getParameterMap().containsKey("personnes")) {
        request.setAttribute("personnes", DaoPersonne.findAll());
        request.setAttribute("personnesSize", DaoPersonne.findAll().size());
      }
        return "list.jsp";
      } 
    }
    return "connexionUser.jsp";
  }
  
}
