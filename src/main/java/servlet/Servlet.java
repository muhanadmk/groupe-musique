
package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontControllers.ICommand;
import frontControllers.PageAccueilController;
import frontControllers.PageCreationController;
import frontControllers.PageModificationController;
import frontControllers.PageSuppressionController;
import frontControllers.PagelistpersonnesController;

/**
 *
 * @author Muhanad ALMOKDAD
 */
@WebServlet(urlPatterns = { "/groupe-musique" })
public class Servlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */

  private Map commands = new HashMap();

  public void init() {
    commands.put(null, new PageAccueilController());
    commands.put("list-de-musiciens", new PagelistpersonnesController());
    commands.put("cree", new PageCreationController());
    commands.put("modifier", new PageModificationController());
    commands.put("suppression", new PageSuppressionController());
    }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String urlSuite = null;
    try (PrintWriter out = response.getWriter()) {
      String cmd = request.getParameter("cmd");
      ICommand com =(ICommand)commands.get(cmd);
      urlSuite = com.execute(request, response);
      request.getRequestDispatcher("/WEB-INF/JSP/"+ urlSuite).forward(request, response);
    } catch (Exception e) {
      urlSuite = "erreur.jsp";
      request.getRequestDispatcher("/WEB-INF/JSP/"+ urlSuite).forward(request, response);
    }
    }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
  // + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

}
