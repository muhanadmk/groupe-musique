package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoPersonne;

public class DeconnexionController implements ICommand{

  public DeconnexionController(){}
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(false);
    session.invalidate();
    if (!request.getParameterMap().containsKey("personnes")) {
      request.setAttribute("personnes", DaoPersonne.findAll());
      request.setAttribute("personnesSize", DaoPersonne.findAll().size());
    }
    return "list.jsp";
  }
  
}
