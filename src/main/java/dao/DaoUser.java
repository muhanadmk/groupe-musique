package dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;

import exception.DaoException;
import servlet.Servlet;

import models.User;

public class DaoUser {
  /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
      DaoUser.class.getName());
  /**
   * objet entityManager qui fait le conn à bd.
   */
  private static EntityManager entityManager = Servlet.getEntityManager();

  public static User findUserByName(final String username) throws Exception {
    User user = null;
    try { 
      String sql = "SELECT * FROM `users` WHERE user = ?";
      Query query = entityManager.createNativeQuery(sql, User.class);
      query.setParameter(1, username);
      user = (User) query.getSingleResult();
    } catch (Exception e) {
      LOGGER.warning(
          "On n'a pas réussir à lire la table User." + e.getMessage());
      throw new DaoException("On n'a pas réussir à lire la table User.");
    }
    return user;
  }

  public static Integer save(User user) throws Exception {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    try {
      entityTransaction.begin();
      entityManager.persist(user);
      entityManager.flush();
      entityTransaction.commit();
    } catch (Exception e) {
      entityTransaction.rollback();
      LOGGER.warning(e.getMessage());
      throw new DaoException(
          "On n'a pas réussir à save l'objet dans la table personne.");
    }
    return null;
  }
}
