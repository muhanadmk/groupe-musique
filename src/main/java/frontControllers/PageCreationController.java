package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageCreationController  implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "creation.jsp";
  }
}
