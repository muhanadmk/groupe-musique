package frontControllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUser;
import models.User;
import utile.HashageUser;

public class PageLogInController implements ICommand {

  /**
 * LOGGER.
 */
private static final Logger LOGGER = Logger.getLogger(
  PageConnectionUserController.class.getName());

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getParameterMap().containsKey("user")
        && request.getParameterMap().containsKey("password")) {
      User user = DaoUser.findUserByName(request.getParameter("user"));
      String passwordBd = HashageUser.getSecurePassword(request.getParameter("password"), user.getSel());
      if (user.getPassword().equals(passwordBd)) {
        request.setAttribute("userAuthentifi", "user a deja passé l'authentification");
        return "list.jsp";
      } else {
        request.setAttribute("userAuthentifi", "user non authentifié");
      }
    }
    return "connexionUser.jsp";
  }
  
}
