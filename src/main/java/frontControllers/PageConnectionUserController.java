package frontControllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUser;
import models.User;
import utile.HashageUser;

public class PageConnectionUserController implements ICommand {
  public PageConnectionUserController(){}
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
          String sel = HashageUser.getSalt();
          User user = new User(request.getParameter("user"),
          HashageUser.getSecurePassword(request.getParameter("password"),sel),sel);
          DaoUser.save(user);
          return "list.jsp";
    }
    return "connexionUser.jsp";

  }
}
