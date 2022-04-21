package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exception.DaoException;
import servlet.Servlet;

import models.Groupe;

public class DaoGroupe {
  /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
      DaoGroupe.class.getName());
  /**
   * objet entityManager qui fait le conn à bd.
   */
  private static EntityManager entityManager = Servlet.getEntityManager();

  /**
   * constructeur.
   */
  public DaoGroupe() {
  }

  /**
   * findAll Groupes.
   * 
   * @return list Groupes
   * @throws Exception exception
   */
  public static List<Groupe> findAll() throws Exception {
    List<Groupe> groupes = new ArrayList<Groupe>();
    try {
      groupes = entityManager.createQuery(
          "select p from Groupe p").getResultList();
    } catch (Exception e) {
      LOGGER.warning(
          "On n'a pas réussir à lire la table Groupe." + e.getMessage());
      throw new DaoException("On n'a pas réussir à lire la table Groupe.");
    }
    return groupes;
  }

  public static Groupe findGroupeById(final Integer id) throws Exception {
    Groupe groupe = null;
    try {
      groupe = entityManager.find(Groupe.class, id);
    } catch (Exception e) {
      LOGGER.warning(
          "On n'a pas réussir à lire la table groupe." + e.getMessage());
      throw new DaoException("On n'a pas réussir à lire la table groupe.");
    }
    return groupe;
  }

  public static Integer save(Groupe groupe) throws Exception {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    try {
      entityTransaction.begin();
      entityManager.merge(groupe);
      entityManager.flush();
      entityTransaction.commit();
    } catch (Exception e) {
      entityTransaction.rollback();
      throw new DaoException(
          "On n'a pas réussir à save l'objet dans la table personne.");
    }
    return null;
  }
}
