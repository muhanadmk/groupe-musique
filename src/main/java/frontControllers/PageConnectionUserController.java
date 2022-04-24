package frontControllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoUser;
import models.User;
import models.forms.UserFrom;

public class PageConnectionUserController implements ICommand {
  public PageConnectionUserController() {
  }

  /**
   * 
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
      PageConnectionUserController.class.getName());

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getParameterMap().containsKey("user")
        && request.getParameterMap().containsKey("password")) {
      HttpSession session = request.getSession();
      if (session.getAttribute("csrfTokenSession")
          .equals(request.getParameter("tokenEnvoie"))) {
        String sel = UserFrom.getSalt();
        User user = new User(request.getParameter("user"),
            UserFrom.getSecurePassword(request.getParameter("password"), sel), sel);
        DaoUser.save(user);
        return "list.jsp";
      } else {
        request.setAttribute("errTokenCerf", "vous avez pas le drois d'envoiyer cette from.");
      }
    }
    return "connexionUser.jsp";

  }
}
