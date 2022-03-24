package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listMusiciens  implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/WEB-INF/JSP/liste.jsp";
  }
}
