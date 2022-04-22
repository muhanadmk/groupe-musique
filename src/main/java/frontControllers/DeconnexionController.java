package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeconnexionController implements ICommand{

  public DeconnexionController(){}
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    session.setAttribute("admin", null);
    session.setAttribute("logout", "logout");
    return "connexionUser.jsp";
  }
  
}
