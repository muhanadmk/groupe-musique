package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import frontControllers.ICommand;
import frontControllers.PageAccueilController;
import frontControllers.PageCreationController;
import frontControllers.PageModificationController;
import frontControllers.PageSuppressionController;
import frontControllers.PagelistpersonnesController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

/**
 * cda08 AFPA.
 * @author Muhanad ALMOKDAD
 */
@WebServlet(urlPatterns = { "/groupe-musique" })
public class Servlet extends HttpServlet {
private static final Logger LOGGER =   Logger.getLogger(PageAccueilController.class.getName());

private static EntityManagerFactory entityManagerFactory = null;
private static EntityManager entityManager = null; 
private static String urlSuite = null;
  
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */

  private Map<String, ICommand> commands = new HashMap<String, ICommand>();
  /**
   * Méthode pour installation de les paramètres de les URL de l'application
   * Chaque commande va appeler un l'objet
   *  de la class contrôleur lié à la valeur de le paramètre.
   */

  public void init() {
    commands.put(null, new PageAccueilController());
    commands.put("list", new PagelistpersonnesController());
    commands.put("cree", new PageCreationController());
    commands.put("modifier", new PageModificationController());
    commands.put("suppression", new PageSuppressionController());

    try {
      entityManagerFactory = Persistence.createEntityManagerFactory("bdMysql");
      entityManager =  entityManagerFactory.createEntityManager();
      LOGGER.info("conne bd bien fait");
    } catch (Exception e) {
      LOGGER.warning("err in con init " + e.getMessage() + e.getCause());
      urlSuite = "erreur.jsp";
    }

  }
  
  public void distroy(){
    try {
      DriverManager.deregisterDriver(DriverManager.getDriver("com.mysql.cj.jdbc.Driver"));
   } catch (SQLException e) {
      LOGGER.info("driver erreur "+e.getMessage());
   }
   AbandonedConnectionCleanupThread.checkedShutdown();

    try {
      entityManagerFactory.close();
    } catch (Exception e) {
      LOGGER.warning("err con  distroy" + e.getMessage());
      urlSuite = "erreur.jsp";
    }
  }

  protected final void processRequest(final HttpServletRequest request,
   final HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      String cmd = request.getParameter("cmd");
      ICommand com = (ICommand) commands.get(cmd);
      urlSuite = com.execute(request, response);
      request.getRequestDispatcher("/WEB-INF/JSP/" + urlSuite)
      .forward(request, response);
    } catch (Exception e) {
      urlSuite = "erreur.jsp";
      request.getRequestDispatcher("/WEB-INF/JSP/" + urlSuite)
      .forward(request, response);
    }
  }
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doGet(final HttpServletRequest request,
   final HttpServletResponse response)
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
  protected void doPost(final HttpServletRequest request,
   final HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  public static EntityManager getEntityManager() {
    return entityManager;
  }


}
