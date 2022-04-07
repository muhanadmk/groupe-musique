package frontControllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageAccueilController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    if (session.getAttribute("compteurPage") == null) {
      session.setAttribute("compteurPage", 0);
    }else{
      Integer compteurPage = (Integer) session.getAttribute("compteurPage");
      compteurPage++;
      session.setAttribute("compteurPage", compteurPage);
    }
    Cookie cookie = new Cookie("prenom", "muhanad");
    cookie.setMaxAge(60*60*24);
    response.addCookie(cookie);
    
    return "index.jsp";
  }
}
