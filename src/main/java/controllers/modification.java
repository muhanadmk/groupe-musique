package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class modification  implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/WEB-INF/JSP/modification.jsp";
  }
}
